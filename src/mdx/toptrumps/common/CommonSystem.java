/**
 * TopTrumps - mdx.toptrumps.common
 */
package mdx.toptrumps.common;

import java.util.List;

import android.app.Activity;
import mdx.toptrumps.disney.model.CardModel;
import mdx.toptrumps.disney.model.UserModel;

/**
 * @author martinellimi
 * 
 * @description CommonSystem.java 
 * This class creates a common space to objects that will be used until the game is closed.
 * These objects can be accessed from all other packages.
 * This class implements the Singleton Design Pattern
 * 
 * @version version 1.0 28 Jan 2015
 */
public final class CommonSystem {

	private List<UserModel> players;
	
	private List<CardModel> cards;
	
	private static CommonSystem commonSystem;
	
	private CommonSystem() { }
	
	public static CommonSystem getInstance() {
		if(CommonSystem.commonSystem == null) {
			CommonSystem.commonSystem = new CommonSystem();
		}
		
		return CommonSystem.commonSystem;
	}
}
