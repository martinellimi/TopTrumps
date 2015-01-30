/**
 * 
 */
package mdx.toptrumps.model.dao;

import java.util.List;

import mdx.toptrumps.model.AnimalAttribute;
import mdx.toptrumps.model.CardAnimalModel;

/**
 * @author martinellimi
 * @description CardDAO.java class description
 * @version version 1.0 27 Jan 2015
 */
public interface CardDAO {

	/**
	 * @description getCards
	 * Gets all the cards for the game and return a populated list with <code>CardModel</code> objects.
	 * 
	 * @return List<CardModel>
	 */
	public List<CardAnimalModel> getCards();
}
