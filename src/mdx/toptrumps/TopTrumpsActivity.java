package mdx.toptrumps;

import java.util.LinkedList;

import mdx.toptrumps.model.CardAnimalModel;
import mdx.toptrumps.service.GameService;
import mdx.toptrumps.service.GameServiceImpl;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


/**
 * @author martinellimi
 * @description TopTrumpsActivity.java - This class is responsible for controlling the
 * Android Application.
 * @version version 1.0 27 Jan 2015
 */
/**
 * @author martinellimi
 * 
 * @description TopTrumpsActivity.java 
 * class description
 * 
 * @version version 1.0 28 Jan 2015
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
		
		setContentView(R.layout.activity_top_trumps);
		
		gameService = new GameServiceImpl(activity);
		
		gameService.startGame();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.top_trumps, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
