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
 * @description TopTrumpsActivity.java - This class is responsible for controlling the
 * Android Application.
 * @version version 1.0 27 Jan 2015
 */
public class TopTrumpsActivity extends Activity {
	
	public static Activity activity;
	
	/** @description Reference to the gameService */
	private GameService gameService;
	
	/** @description cards list */
	public LinkedList<CardAnimalModel> cards;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		TopTrumpsActivity.activity = this;
		
		setContentView(R.layout.intropage);
		
		gameService = new GameServiceImpl(activity);
		
		gameService.startGame();
		
		Button btnPlayGame = (Button) findViewById(R.id.playGame);
		
		btnPlayGame.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				setContentView(R.layout.selectplayers);
				
				Button btnStart = (Button) findViewById(R.id.playGame);
				btnStart.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						Intent start = new Intent(TopTrumpsActivity.this, GameActivity.class);
						startActivity(start);
					}
				});
			}
		});
		
		Button btnHowPlay = (Button) findViewById(R.id.howPlay);
		
		btnHowPlay.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				setContentView(R.layout.howtoplay);
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
