/**
 * TopTrumps - mdx.toptrumps
 */
package mdx.toptrumps;

import java.lang.reflect.InvocationTargetException;

import mdx.toptrumps.common.CommonSystem;
import mdx.toptrumps.model.CardAnimalAttribute;
import mdx.toptrumps.model.CardAnimalModel;
import mdx.toptrumps.model.UserModel;
import mdx.toptrumps.service.GameService;
import mdx.toptrumps.service.GameServiceImpl;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.*;

/**
 * @author martinellimi
 * 
 * Description: GameActivity.java 
 * This Activity controls the entire game activities. It sets up the screen for the user to play.  
 * 
 * @version version 1.0 30 Jan 2015
 */
public class GameActivity extends Activity {
	
	/** Description: This is the gameService object, used to call methods inside the Game Service */
	private GameService gameService = new GameServiceImpl();
	
	/**
	 * Description: computerMove 
	 * Calls the gameService method that represents the computer player and select one of the attributes to play against. 
	 * 
	 * @param CardAnimalModel card
	 * @return void
	 */
	public void computerMove() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		CardAnimalAttribute attribute = gameService.computerMove(CommonSystem.getInstance().getComputer().getValue().getFirst());
		this.evaluateMove(attribute);
	}
	
	/**
	 * Description: onBackPressed 
	 * OnBackPressed is used to start the TopTrumpsActivity and reinitialize the game when the return button is pressed.
	 * 
	 * @return void
	 */
	@Override
	public void onBackPressed() {
	    Intent intent = new Intent(getApplicationContext(), TopTrumpsActivity.class);
	    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	    startActivity(intent);
	}
	
	/**
	 * Description: onCreate 
	 * OnCreate method is used to set the content view to the main screen which displays the player card 
	 * Calls the method to set up the screen and the values and also check if it is the computer turn to play and
	 * after 3 seconds, starts the computerMove method.
	 * 
	 * @param Bundle savedInstanceState
	 * @return void
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.mainview);

		setUpScreen();
		
		if(CommonSystem.getInstance().getPlayerTurn().isComputer() == true) {
			new Handler().postDelayed(new Runnable() {
		        @Override
		        public void run() {
	    			try {
	    				computerMove();
	    			} catch (IllegalAccessException e) {
	    				e.printStackTrace();
	    			} catch (IllegalArgumentException e) {
	    				e.printStackTrace();
	    			} catch (InvocationTargetException e) {
	    				e.printStackTrace();
	    			}
		        }
		    }, 3000);
		}
		
		
	}

	/**
	 * Description: setUpScreen 
	 * Sets up the screen for the player. Sets the points and name and calls the method 
	 * to set up card information in the screen.
	 * 
	 * @return void
	 */
	private void setUpScreen() {
		setContentView(R.layout.mainview);
		
		UserModel user = CommonSystem.getInstance().getPlayer1().getKey();

		TextView userPoint = (TextView) findViewById(R.id.scoreUser);
		userPoint.setText(user.getPoint().toString());
		TextView androidPoint = (TextView) findViewById(R.id.scoreAndroid);
		androidPoint.setText(CommonSystem.getInstance().getComputer().getKey()
				.getPoint().toString());
		TextView player = (TextView)findViewById(R.id.player);
		player.setText(CommonSystem.getInstance().getPlayerTurn().getName());

		setUpUserCards(CommonSystem.getInstance().getPlayer1().getValue().getFirst());
	}
	
	/**
	 * Description: setUpUserCards 
	 * Set up the values for the player card. Receiving the player card, set the values on the screen for the player.
	 * 
	 * @param CardAnimalModel card
	 * @return void
	 */
	private void setUpUserCards(CardAnimalModel card) {
		
		ImageView cardImg = (ImageView)findViewById(R.id.imgCardUser);
		cardImg.setImageBitmap(card.getImage());
		
		TextView cardName = (TextView) findViewById(R.id.cardNameUser);
		cardName.setText(card.getName());

		Button btnHeight = (Button) findViewById(R.id.userheight);
		setButton(btnHeight, card.getHeight().getValue().toString());

		Button btnUserkillerinstinct = (Button) findViewById(R.id.userkillerinstinct);
		setButton(btnUserkillerinstinct, card.getKillerInstinct().getValue()
				.toString());

		Button btnUserlength = (Button) findViewById(R.id.userlength);
		setButton(btnUserlength, card.getLength().getValue().toString());

		Button btnUserspeed = (Button) findViewById(R.id.userspeed);
		setButton(btnUserspeed, card.getSpeed().getValue().toString());

		Button btnUserweight = (Button) findViewById(R.id.userweight);
		setButton(btnUserweight, card.getWeight().getValue().toString());
		
	}

	/**
	 * Description: setButton 
	 * To do not repeat this code, this method is used to set the event listener in each button and also 
	 * calls the evalueteMove method sending the parameter that was chose on the screen, if the player is not
	 * the computer, if the user is not the computer, just disabled the button, to not allow user to click on it when
	 * it is not his turn to play.
	 * 
	 * @param CardAnimalModel card
	 * @return void
	 */
	private void setButton(Button btn, String text) {
		btn.setText(text);
		if(!CommonSystem.getInstance().getPlayerTurn().isComputer() == true) {
			btn.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					try {
						switch (v.getId()) {
							case R.id.userheight:
								evaluateMove(CardAnimalAttribute.Height);
							break;
							case R.id.userkillerinstinct:
								evaluateMove(CardAnimalAttribute.KillerInstinct);
							break;
							case R.id.userlength:
								evaluateMove(CardAnimalAttribute.Length);
							break;
							case R.id.userspeed:
								evaluateMove(CardAnimalAttribute.Speed);
							break;
							case R.id.userweight:
								evaluateMove(CardAnimalAttribute.Weight);
							break;
						}
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
					
				}
			});
		} else {
			btn.setEnabled(false);
		}
	}

	/**
	 * Description: evaluateMove 
	 * Evaluates the move, receiving the Attribute that was chosen and starts the ShowCardActivity, sending the attribute.  
	 * 
	 * @param CardAnimalAttribute attr
	 * @return void
	 */
	private void evaluateMove(CardAnimalAttribute attr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		gameService.evaluateMove(attr);

		Intent start = new Intent(GameActivity.this, ShowCardActivity.class);
		Bundle args = new Bundle();
		args.putSerializable("attribute", attr);
		
		start.putExtras(args); 
		
		startActivity(start);
	}
}
