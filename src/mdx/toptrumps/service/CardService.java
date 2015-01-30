/**
 * TopTrumps - mdx.toptrumps.disney.service
 */
package mdx.toptrumps.service;

import java.util.List;

import mdx.toptrumps.model.CardAnimalModel;

/**
 * @author martinellimi
 * 
 * @description CardService.java 
 * This interface contains just one method to get the cards. 
 * 
 * @version version 1.0 27 Jan 2015
 */
public interface CardService {

	/**
	 * @description getCards
	 * Gets the cards from the CardDAO and returns the cards to play the game.
	 * 
	 * @param 
	 * @return List<CardModel>
	 */
	public List<CardAnimalModel> getCards();
}
