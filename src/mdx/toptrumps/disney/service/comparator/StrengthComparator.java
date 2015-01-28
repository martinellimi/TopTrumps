/**
 * TopTrumps - mdx.toptrumps.disney.service.comparator
 */
package mdx.toptrumps.disney.service.comparator;

import java.util.Comparator;

import mdx.toptrumps.disney.model.CardModel;

/**
 * @author martinellimi
 * 
 * @description StrengthComparator.java 
 * Custom comparator class based on the <i>strength rating</i> of the 
 * CardModel object. This class follows the Singleton Design Pattern.
 * 
 * @version version 1.0 28 Jan 2015
 */
public class StrengthComparator implements Comparator<CardModel> {

	/** @description Reference to the comparator object */
	private static StrengthComparator strengthComparator;
	
	/** Private constructor following Singleton pattern, 
	 * so cannot be called from external code. 
	 */
	private StrengthComparator() { } 
	
	/**
	 * @description getInstance
	 * It has Package-protected visibility and returns the Singleton instance of this comparator.
	 * 
	 * @param 
	 * @return StrengthComparator
	 */
	static StrengthComparator getInstance() {
		if(strengthComparator == null) {
			strengthComparator = new StrengthComparator();
		}
		return strengthComparator;
	}
	
	/**
	 * Defines the comparison for the strength rating. 
	 * This method is specified by <code>Comparator</code> interface which this class implements.
	 * 
	 * An integer is returned, using the logic:
	 * 
	 * <pre>
	 * 		If card c1 has a strength rating higher than card c2
	 * 		then
	 * 			return a positive integer
	 * 
	 * 		If card c2 has a strength rating higher than card c1
	 * 		then 
	 * 			return a negative integer
	 * 
	 * 		Otherwise return zero
	 * </pre>
	 * 
	 * @return +1, -1 or 0
	 */
	public int compare(CardModel c1, CardModel c2) {
		return c2.getStrength().getValue().compareTo(c1.getStrength().getValue());
	}
}
