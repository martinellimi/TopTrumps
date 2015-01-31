/**
 * TopTrumps - mdx.toptrumps
 */
package mdx.toptrumps;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.w3c.dom.Text;

import mdx.toptrumps.common.CommonSystem;
import mdx.toptrumps.model.CardAnimalModel;
import mdx.toptrumps.model.UserModel;
import mdx.toptrumps.view.CardView;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author martinellimi
 * 
 * @description GameActivity.java 
 * class description
 * 
 * @version version 1.0 30 Jan 2015
 */
public class GameActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.showcards);
		
		setUpScreen();
	}
	
	private void setUpScreen() {
		UserModel user = (UserModel)CommonSystem.getInstance().getGame().keySet().toArray()[0];
		
		TextView userPoint = (TextView)findViewById(R.id.scoreUser);
		userPoint.setText(user.getPoint().toString());
		TextView androidPoint = (TextView)findViewById(R.id.scoreAndroid);
		androidPoint.setText(CommonSystem.getInstance().getComputer().getKey().getPoint().toString());
		
		setUpCardForTheMove();
	}
	
	private void setUpCardForTheMove() {
		CommonSystem.getInstance().setMove(new HashMap<UserModel, CardAnimalModel>());
		for(Entry<UserModel, List<CardAnimalModel>> item : CommonSystem.getInstance().getGame().entrySet()) {
			CommonSystem.getInstance().getMove().put(item.getKey(), item.getValue().get(0));
		}
		
		CommonSystem.getInstance().getMove().put(CommonSystem.getInstance().getComputer().getKey(), 
				CommonSystem.getInstance().getComputer().getValue().get(0));
		
		setUpdCardView();
	}
	
	private void setUpdCardView() {
		for(Entry<UserModel, CardAnimalModel> item : CommonSystem.getInstance().getMove().entrySet()) {
			if(item.getKey().isComputer()) {
				setUpAndroidCards(item.getValue());
			} else {
				setUpUserCards(item.getValue());
			}
		}
	}
	
	private void setUpUserCards(CardAnimalModel card){
		Button btnHeight = (Button)findViewById(R.id.userheight);
		setButton(btnHeight, card.getHeight().getValue().toString());
		
		Button btnUserkillerinstinct = (Button)findViewById(R.id.userkillerinstinct);
		setButton(btnUserkillerinstinct, card.getKillerInstinct().getValue().toString());
		
		Button btnUserlength = (Button)findViewById(R.id.userlength);
		setButton(btnUserlength, card.getLength().getValue().toString());
		
		Button btnUserspeed = (Button)findViewById(R.id.userspeed);
		setButton(btnUserspeed, card.getSpeed().getValue().toString());
		
		Button btnUserweight = (Button)findViewById(R.id.userweight);
		setButton(btnUserweight, card.getWeight().getValue().toString());
	}
	
	private void setUpAndroidCards(CardAnimalModel card){
		Button btnHeight = (Button)findViewById(R.id.androidheight);
		setButton(btnHeight, card.getHeight().getValue().toString());
		
		Button btnUserkillerinstinct = (Button)findViewById(R.id.androidkillerinstinct);
		setButton(btnUserkillerinstinct, card.getKillerInstinct().getValue().toString());
		
		Button btnUserlength = (Button)findViewById(R.id.androidlength);
		setButton(btnUserlength, card.getLength().getValue().toString());
		
		Button btnUserspeed = (Button)findViewById(R.id.androidspeed);
		setButton(btnUserspeed, card.getSpeed().getValue().toString());
		
		Button btnUserweight = (Button)findViewById(R.id.androidweight);
		setButton(btnUserweight, card.getWeight().getValue().toString());
	}

	private void setButton(Button btn, String text) {
		btn.setText(text);
		btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
			}
		});
	}
	
	public void startRound() {
		
	}
	
}
