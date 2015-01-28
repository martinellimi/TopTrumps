/**
 * 
 */
package mdx.toptrumps.disney.model.dao;



import java.util.List;

import android.app.Activity;
import mdx.toptrumps.disney.model.CardModel;

/**
 * @author martinellimi
 * 
 * @description CardDAOImpl.java 
 * An intermediate class that essentially provides an implementation of the
 * <code>CardDAO</code> interface.
 * 
 * @version version 1.0 27 Jan 2015
 */
public class CardDAOImpl implements CardDAO {

	/** @description References the <code>TextFileAccess</code> object. */
	private TextFileAccess dataAccess = null;
	
	
	/**
	 * The constructor initializes the dataAccess object using the 'getInstance' method,
	 * following Singleton pattern and pass to the delegated class the <code>Activity</code> object.
	 * 
	 * @param activity
	 */
	public CardDAOImpl(Activity activity) {
		dataAccess = TextFileAccess.getInstance(activity);
	}
	
	/**
	 * @description getCards
	 * Gets all the cards for the game and returns a populated list with <code>CardModel</code> objects.
	 * Delegates this function to the <code>TextFileAccess</code> which has a package-protected visibility.
	 * 
	 * @return List<CardModel>
	 * @see CardDAO#getCards()
	 */
	public List<CardModel> getCards() {
		return dataAccess.getCards();
	}
	
	
}
