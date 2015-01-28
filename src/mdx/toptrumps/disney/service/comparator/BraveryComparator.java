/**
 * TopTrumps - mdx.toptrumps.disney.service.comparator
 */
package mdx.toptrumps.disney.service.comparator;

import java.util.Comparator;

import mdx.toptrumps.disney.model.CardModel;

/**
 * @author martinellimi
 * 
 * @description BraveryComparator.java 
 * Custom comparator class based on the <i>bravery rating</i> of the 
 * CardModel object. This class follows the Singleton Design Pattern.
 * 
 * @version version 1.0 28 Jan 2015
 */
public class BraveryComparator implements Comparator<CardModel> {

	/** @description Reference to the comparator object */
	private static BraveryComparator braveryComparator;
	
	/** Private constructor following Singleton pattern, 
	 * so cannot be called from external code. 
	 */
	private BraveryComparator() { } 
	
	/**
	 * @description getInstance
	 * It has Package-protected visibility and returns the Singleton instance of this comparator.
	 * 
	 * @param 
	 * @return HappinessComparator
	 */
	static BraveryComparator getInstance() {
		if(braveryComparator == null) {
			braveryComparator = new BraveryComparator();
		}
		return braveryComparator;
	}
	
	/**
	 * Defines the comparison for the bravery rating. 
	 * This method is specified by <code>Comparator</code> interface which this class implements.
	 * 
	 * An integer is returned, using the logic:
	 * 
	 * <pre>
	 * 		If card c1 has a bravery rating higher than card c2
	 * 		then
	 * 			return a positive integer
	 * 
	 * 		If card c2 has a bravery rating higher than card c1
	 * 		then 
	 * 			return a negative integer
	 * 
	 * 		Otherwise return zero
	 * </pre>
	 * 
	 * @return +1, -1 or 0
	 */
	public int compare(CardModel c1, CardModel c2) {
		return c2.getBravery().getValue().compareTo(c1.getBravery().getValue());
	}
}
