package mdx.toptrumps;

import android.app.Activity;
import android.os.Bundle;

/**
 * @author ffae
 * 
 * Description: HowPlayActivity.java 
 * This Activity controls the How to play screen. 
 * 
 * @version version 1.0 1 Fev 2015
 */
public class HowPlayActivity extends Activity {

	/**
	 * Description: onCreate 
	 * OnCreate method is used to set the content view to the how to play instructions which displays to the user
	 * the information of how to play the game.
	 * 
	 * @param Bundle savedInstanceState
	 * @return void
	 */
	public void onCreate (Bundle howplay){
        super.onCreate(howplay);
        setContentView(R.layout.howtoplay);
    }

	/**
	 * Description: finish 
	 * Simply, just finished the application.
	 * 
	 * @return void
	 */
	@Override
	public void finish() {
		super.finish();
	}
}
