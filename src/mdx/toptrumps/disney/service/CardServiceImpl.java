/**
 * TopTrumps - mdx.toptrumps.disney.service
 */
package mdx.toptrumps.disney.service;

import java.util.List;

import android.app.Activity;
import mdx.toptrumps.disney.model.CardModel;
import mdx.toptrumps.disney.model.dao.CardDAO;
import mdx.toptrumps.disney.model.dao.CardDAOImpl;

/**
 * @author martinellimi
 * 
 * @description CardServiceImpl.java 
 * Implements the <code>CardService</code> Interface and main role is control 
 * the activities related to the playing Cards.
 * 
 * @version version 1.0 27 Jan 2015
 */
public class CardServiceImpl implements CardService {

	private CardDAO cardDAO;
	
	/**
	 * CardServiceImpl receives an Activity to pass this instance to the 
	 * <code>CardDAOImpl</code>
	 * 
	 * @param activity
	 */
	public CardServiceImpl(Activity activity) {
		cardDAO = new CardDAOImpl(activity);
	}
	
	/**
	 * @description getCards
	 * Gets the cards from the CardDAO and returns the cards to play the game.
	 * 
	 * @return List<CardModel>
	 * @see CardService#getCards()
	 * TODO: implement this method.
	 */
	public List<CardModel> getCards() {
		return null;
	}

}
