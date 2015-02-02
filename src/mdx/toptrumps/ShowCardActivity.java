/**
 * TopTrumps - mdx.toptrumps
 */
package mdx.toptrumps;

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
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author martinellimi
 * 
 * @description ShowCardActivity.java 
 * class description
 * 
 * @version version 1.0 1 Feb 2015
 */
public class ShowCardActivity extends Activity {
	
	private GameService gameService = new GameServiceImpl();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.showcards);
		
		CardAnimalAttribute attr = (CardAnimalAttribute) getIntent().getSerializableExtra("attribute");
		
		setUpWinner();
		
		TextView attribute = (TextView)findViewById(R.id.attribute);
		attribute.setText(attr.getName());
		
		setUpAndroidCards(CommonSystem.getInstance().getComputer().getValue().getFirst());
		setUpUserCards(CommonSystem.getInstance().getPlayer1().getValue().getFirst());
		
		new Handler().postDelayed(new Runnable() {
	        @Override
	        public void run() {
	        	gameService.setWinner(CommonSystem.getInstance().getPlayerTurn());
	        	if(CommonSystem.getInstance().getComputer().getValue().size() == 0 || 
	        			CommonSystem.getInstance().getPlayer1().getValue().size() == 0) {
	        		Intent start = new Intent(ShowCardActivity.this, EndGameActivity.class);
					startActivity(start);
	        	} else {
	        		Intent start = new Intent(ShowCardActivity.this, GameActivity.class);
					startActivity(start);
	        	}
	        }
	    }, 2500);

	}
	
	
	private void setUpAndroidCards(CardAnimalModel card) {

		UserModel user = CommonSystem.getInstance().getPlayer1().getKey();

		TextView userPoint = (TextView) findViewById(R.id.scoreUser);
		userPoint.setText(user.getPoint().toString());

		TextView androidPoint = (TextView) findViewById(R.id.scoreAndroid);
		androidPoint.setText(CommonSystem.getInstance().getComputer().getKey()
				.getPoint().toString());
		
		TextView cardName = (TextView) findViewById(R.id.cardNameAndroid);
		cardName.setText(card.getName());

		Button btnHeight = (Button) findViewById(R.id.androidheight);
		btnHeight.setText(card.getHeight().getValue()
				.toString());

		Button btnUserkillerinstinct = (Button) findViewById(R.id.androidkillerinstinct);
		btnUserkillerinstinct.setText(card.getKillerInstinct().getValue()
				.toString());

		Button btnUserlength = (Button) findViewById(R.id.androidlength);
		btnUserlength.setText(card.getLength().getValue()
				.toString());

		Button btnUserspeed = (Button) findViewById(R.id.androidspeed);
		btnUserspeed.setText(card.getSpeed().getValue()
				.toString());

		Button btnUserweight = (Button) findViewById(R.id.androidweight);
		btnUserweight.setText(card.getWeight().getValue()
				.toString());
	}
	
	private void setUpWinner() {
		UserModel winner = CommonSystem.getInstance().getPlayerTurn();
		if(!CommonSystem.getInstance().isGameDraw()) {
			if(winner.isComputer() == true) {
				ImageView image = (ImageView)findViewById(R.id.userWin);
				image.setVisibility(View.INVISIBLE);
				ImageView computer = (ImageView)findViewById(R.id.androidWin);
				computer.setVisibility(View.VISIBLE);
				computer.invalidate();
			} else {
				ImageView image = (ImageView)findViewById(R.id.userWin);
				image.setVisibility(View.VISIBLE);
				ImageView computer = (ImageView)findViewById(R.id.androidWin);
				computer.setVisibility(View.INVISIBLE);
				computer.invalidate();
			}
		}
	}
	
	private void setUpUserCards(CardAnimalModel card) {

		TextView cardName = (TextView) findViewById(R.id.cardNameUser);
		cardName.setText(card.getName());

		Button btnHeight = (Button) findViewById(R.id.userheight);
		btnHeight.setText(card.getHeight().getValue()
				.toString());

		Button btnUserkillerinstinct = (Button) findViewById(R.id.userkillerinstinct);
		btnUserkillerinstinct.setText(card.getKillerInstinct().getValue()
				.toString());

		Button btnUserlength = (Button) findViewById(R.id.userlength);
		btnUserlength.setText(card.getLength().getValue()
				.toString());
		
		Button btnUserspeed = (Button) findViewById(R.id.userspeed);
		btnUserspeed.setText(card.getSpeed().getValue()
				.toString());

		Button btnUserweight = (Button) findViewById(R.id.userweight);
		btnUserweight.setText(card.getWeight().getValue()
				.toString());
	}
	
}
