/**
 * TopTrumps - mdx.toptrumps.common
 */
package mdx.toptrumps.common;

import java.util.List;

import android.app.Activity;
import mdx.toptrumps.model.CardAnimalModel;
import mdx.toptrumps.model.UserModel;

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
	
	private List<CardAnimalModel> cards;
	
	private static CommonSystem commonSystem;
	
	private CommonSystem() { }
	
	public static CommonSystem getInstance() {
		if(CommonSystem.commonSystem == null) {
			CommonSystem.commonSystem = new CommonSystem();
		}
		
		return CommonSystem.commonSystem;
	}
	
	/** @return the cards */
	public List<CardAnimalModel> getCards() {
		return cards;
	}

	/** @param cards the cards to set */
	public void setCards(List<CardAnimalModel> cards) {
		this.cards = cards;
	}
}
