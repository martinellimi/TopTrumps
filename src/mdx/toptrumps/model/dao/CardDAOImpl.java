/**
 * 
 */
package mdx.toptrumps.model.dao;



import java.util.List;

import mdx.toptrumps.model.CardAnimalModel;
import android.app.Activity;

/**
 * @author martinellimi
 * 
 * Description: CardDAOImpl.java 
 * An intermediate class that essentially provides an implementation of the
 * <code>CardDAO</code> interface.
 * 
 * @version version 1.0 27 Jan 2015
 */
public class CardDAOImpl implements CardDAO {

	/** Description: References the <code>TextFileAccess</code> object. */
	private TextFileAccess dataAccess = null;
	
	
	/**
	 * The constructor initializes the dataAccess object using the 'getInstance' method,
	 * following Singleton pattern and pass to the delegated class the <code>Activity</code> object.
	 * 
	 * @param activity
	 */
	public CardDAOImpl() {
		dataAccess = TextFileAccess.getInstance();
	}
	
	/**
	 * Description: getCards
	 * Gets all the cards for the game and returns a populated list with <code>CardModel</code> objects.
	 * Delegates this function to the <code>TextFileAccess</code> which has a package-protected visibility.
	 * 
	 * @return List<CardModel>
	 * @see CardDAO#getCards()
	 */
	public List<CardAnimalModel> getCards() {
		return dataAccess.getCards();
	}
	
	
}
