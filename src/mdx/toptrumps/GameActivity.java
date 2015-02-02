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
import android.widget.Button;
import android.widget.TextView;

/**
 * @author martinellimi
 * 
 * @description GameActivity.java class description
 * 
 * @version version 1.0 30 Jan 2015
 */
public class GameActivity extends Activity {

	private GameService gameService = new GameServiceImpl();
	
	UserModel winner;
	
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
	    				computeMove();
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

		setUpCardForTheMove();
	}

	private void setUpCardForTheMove() {
		setUpdCardView();
	}

	private void setUpdCardView() {
		setUpUserCards(CommonSystem.getInstance().getPlayer1().getValue().getFirst());
	}

	private void setUpUserCards(CardAnimalModel card) {

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

	private void setUpAndroidCards(CardAnimalModel card) {

		UserModel user = CommonSystem.getInstance().getPlayer1().getKey();

		TextView userPoint = (TextView) findViewById(R.id.scoreUser);
		userPoint.setText(user.getPoint().toString());
		userPoint.invalidate();
		TextView androidPoint = (TextView) findViewById(R.id.scoreAndroid);
		androidPoint.setText(CommonSystem.getInstance().getComputer().getKey()
				.getPoint().toString());
		
		TextView cardName = (TextView) findViewById(R.id.cardNameAndroid);
		cardName.setText(card.getName());

		Button btnHeight = (Button) findViewById(R.id.androidheight);
		setButton(btnHeight, card.getHeight().getValue().toString());

		Button btnUserkillerinstinct = (Button) findViewById(R.id.androidkillerinstinct);
		setButton(btnUserkillerinstinct, card.getKillerInstinct().getValue()
				.toString());

		Button btnUserlength = (Button) findViewById(R.id.androidlength);
		setButton(btnUserlength, card.getLength().getValue().toString());

		Button btnUserspeed = (Button) findViewById(R.id.androidspeed);
		setButton(btnUserspeed, card.getSpeed().getValue().toString());

		Button btnUserweight = (Button) findViewById(R.id.androidweight);
		setButton(btnUserweight, card.getWeight().getValue().toString());
	}

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

	public void computeMove() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		CardAnimalAttribute attribute = gameService.computerMove(CommonSystem.getInstance().getComputer().getValue().getFirst());
		this.evaluateMove(attribute);
	}
	
	private void evaluateMove(CardAnimalAttribute attr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		winner = gameService.evaluateMove(attr);

		
		Intent start = new Intent(GameActivity.this, ShowCardActivity.class);
		

		Bundle args = new Bundle();
		args.putSerializable("attribute", attr);
		
//		start.putExtra("attribute", attr);

//		b.putInt("attribute", attr); //Your id
		start.putExtras(args); //Put your id to your next Intent
		
		startActivity(start);
		
//		setContentView(R.layout.showcards);
//		
//		if(winner.isComputer() == true) {
//			ImageView image = (ImageView)findViewById(R.id.userWin);
//			image.setVisibility(0);
//			ImageView computer = (ImageView)findViewById(R.id.androidWin);
//			computer.setVisibility(1);
//			computer.invalidate();
//		} else {
//			ImageView image = (ImageView)findViewById(R.id.userWin);
//			image.setVisibility(1);
//			ImageView computer = (ImageView)findViewById(R.id.androidWin);
//			computer.setVisibility(0);
//			computer.invalidate();
//		}
//		
//		setUpAndroidCards(CommonSystem.getInstance().getComputer().getValue().getFirst());
//		setUpUserCards(CommonSystem.getInstance().getPlayer1().getValue().getFirst());
//		
//		new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//            	gameService.setWinner(winner);
//        		setUpScreen();
//            }
//        }, 5000);
		
		
		
		
	}
}
