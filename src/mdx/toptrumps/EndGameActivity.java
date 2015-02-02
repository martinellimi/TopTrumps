/**
 * TopTrumps - mdx.toptrumps
 */
package mdx.toptrumps;

import java.util.AbstractMap;
import java.util.LinkedList;

import mdx.toptrumps.common.CommonSystem;
import mdx.toptrumps.model.CardAnimalAttribute;
import mdx.toptrumps.model.CardAnimalModel;
import mdx.toptrumps.model.UserModel;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author martinellimi
 * 
 * @description EndGameActivity.java 
 * class description
 * 
 * @version version 1.0 2 Feb 2015
 */
public class EndGameActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.endmatch);
		
		Button btnStart = (Button) findViewById(R.id.Button01);
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
		
		Button btnExit = (Button) findViewById(R.id.playGame);
		btnExit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
			}
		});

	}
	
	@Override
	protected void onDestroy() {
		
	}
	
	
}
