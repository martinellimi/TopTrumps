/**
 * TopTrumps - mdx.toptrumps
 */
package mdx.toptrumps;

import java.util.AbstractMap;
import java.util.LinkedList;

import mdx.toptrumps.common.CommonSystem;
import mdx.toptrumps.model.CardAnimalModel;
import mdx.toptrumps.model.UserModel;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author martinellimi
 * 
 * Description: EndGameActivity.java 
 * This class controls the End of the game. Display the last screen and set the buttons. 
 * 
 * @version version 1.0 2 Feb 2015
 */
public class EndGameActivity extends Activity {

	/**
	 * Description: onCreate 
	 * OnCreate method is used to set the content view to the end match screen which plays a sound if the user win
	 * or loose. 
	 * 
	 * @param Bundle savedInstanceState
	 * @return void
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.endmatch);
		
		if(CommonSystem.getInstance().getComputer().getValue().size() == 0){
			MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.win);
			mediaPlayer.start();
			TextView endText = (TextView)findViewById(R.id.endMatch);
			endText.setText("You Win");
		}
		
		if(CommonSystem.getInstance().getPlayer1().getValue().size() == 0){
			MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.lose);
			mediaPlayer.start();
			TextView endText = (TextView)findViewById(R.id.endMatch);
			endText.setText("You Lose");
		}

		
		Button btnStart = (Button) findViewById(R.id.btnPlayAgain);
		btnStart.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				CommonSystem.getInstance().getPlayers().clear();
				CommonSystem.getInstance().setComputer(
						new AbstractMap.SimpleEntry<UserModel, LinkedList<CardAnimalModel>>(null, null)); 
				CommonSystem.getInstance().setPlayer1(
						new AbstractMap.SimpleEntry<UserModel, LinkedList<CardAnimalModel>>(null, null));
				
				Intent start = new Intent(EndGameActivity.this, TopTrumpsActivity.class);
				startActivity(start);
			}
		});
		
		
		Button btnExit = (Button) findViewById(R.id.btnExit);
		btnExit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(getApplicationContext(), TopTrumpsActivity.class);
			    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			    intent.putExtra("EXIT", true);
			    startActivity(intent);
				
			}
		});

	}
	
	/**
	 * Description: onBackPressed
	 * Overrides the onBackPressed button and starts again the game.  
	 * 
	 * @param Bundle savedInstanceState
	 * @return void
	 */
	@Override
	public void onBackPressed() {
	    Intent intent = new Intent(getApplicationContext(), TopTrumpsActivity.class);
	    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	    startActivity(intent);
	}
}
