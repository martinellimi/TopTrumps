package mdx.toptrumps.disney;

import java.util.LinkedList;

import mdx.toptrumps.disney.model.CardModel;
import mdx.toptrumps.disney.service.GameService;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


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
public class TopTrumpsActivity extends ActionBarActivity {
	
	/** @description Reference to the gameService */
	private GameService gameService;
	
	/** @description cards list */
	private LinkedList<CardModel> cards;
	
	/** @description card image */
	private ImageView image;
	
	/** @description character name */
	private TextView name;
	
	/** @description label weight */
	private TextView weightLabel;
	
	/** @description label length */
	private TextView lengthLabel;
	
	
	/** @description magic label */
	private TextView magicLabel;
	
	/** @description strength label */
	private TextView strengthLabel;
	
	/** @description Intelligence label */
	private TextView intelLabel;
	
	/** @description Happiness label */
	private TextView happiLabel;
	
	/** @description Bravery label */
	private TextView braveLabel;
	
	/** @description First On Film label */
	private TextView firstLabel;
	
	/** @description Reference to the card */
	private CardModel card;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_top_trumps);
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
