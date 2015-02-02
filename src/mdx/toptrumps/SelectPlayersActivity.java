package mdx.toptrumps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectPlayersActivity extends Activity {

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

	@Override
	public void finish() {
		super.finish();
	}
	
}
