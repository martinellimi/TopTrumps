package mdx.toptrumps;

import java.util.LinkedList;

import mdx.toptrumps.model.CardAnimalModel;
import mdx.toptrumps.service.GameService;
import mdx.toptrumps.service.GameServiceImpl;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


/**
 * @author martinellimi
 * Description: TopTrumpsActivity.java
 * This class is responsible for controlling the Android Application.
 * 
 * @version version 1.0 27 Jan 2015
 */
public class TopTrumpsActivity extends Activity {
	
	public static Activity activity;
	
	/** Description: Reference to the gameService */
	private GameService gameService;
	
	/** Description: cards list */
	public LinkedList<CardAnimalModel> cards;
	
	/**
	 * Description: onResume 
	 * onResume receives a parameter, and if it is exit, finished the application.
	 * 
	 * @param Bundle savedInstanceState
	 * @return void
	 */
	@Override
	protected void onResume(){
		super.onResume();
		if (getIntent().getBooleanExtra("EXIT", false)) {
		    finish();
		}
	}
	
	/**
	 * Description: onCreate 
	 * OnCreate method is used to set the content view to the first screen and display the options to the user. 
	 * 
	 * @param Bundle savedInstanceState
	 * @return void
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		TopTrumpsActivity.activity = this;
		
		setContentView(R.layout.intropage);
		
		gameService = new GameServiceImpl();
		
		gameService.startGame();
		
		Button btnPlayGame = (Button) findViewById(R.id.playGame);
		
		btnPlayGame.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				Intent playgame = new Intent(TopTrumpsActivity.this, SelectPlayersActivity.class);
            	startActivityForResult(playgame, 1);
			}
		});
		
		Button btnHowPlay = (Button) findViewById(R.id.howPlay);
		
		btnHowPlay.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent howtoplay = new Intent(TopTrumpsActivity.this, HowPlayActivity.class);
            	startActivityForResult(howtoplay, 1);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.top_trumps, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
