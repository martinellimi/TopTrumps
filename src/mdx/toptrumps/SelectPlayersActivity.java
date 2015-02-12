package mdx.toptrumps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * @author ffae
 * 
 * Description: SelectPlayersActivity.java 
 * This Activity controls the players option.
 * 
 * @version version 1.0 1 Fev 2015
 */
public class SelectPlayersActivity extends Activity {

	/**
	 * Description: onCreate 
	 * OnCreate method is used to set the content view to the select players screen which displays to the user
	 * the players option.
	 * 
	 * @param Bundle savedInstanceState
	 * @return void
	 */
	public void onCreate (Bundle selectplayer){
        super.onCreate(selectplayer);
        setContentView(R.layout.selectplayers);
        
		Button btnStart = (Button) findViewById(R.id.playGame);
		btnStart.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent start = new Intent(SelectPlayersActivity.this, GameActivity.class);
				startActivity(start);
			}
		});
        
        
    }

	/**
	 * Description: onCreate 
	 * Simply, just finished the application.
	 * 
	 * @return void
	 */
	@Override
	public void finish() {
		super.finish();
	}
	
}
