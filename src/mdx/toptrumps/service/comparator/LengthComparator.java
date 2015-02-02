/**
 * TopTrumps - mdx.toptrumps.disney.service.comparator
 */
package mdx.toptrumps.service.comparator;

import java.util.Comparator;

import mdx.toptrumps.model.CardAnimalModel;

/**
 * @author martinellimi
 * 
 * @description lengthComparator.java 
 * Custom comparator class based on the <i>length rating</i> of the 
 * CardModel object. This class follows the Singleton Design Pattern.
 * 
 * @version version 1.0 28 Jan 2015
 */
public class LengthComparator implements Comparator<CardAnimalModel> {

	/** @description Reference to the comparator object */
	private static LengthComparator lengthComparator;
	
	/** Private constructor following Singleton pattern, 
	 * so cannot be called from external code. 
	 */
	private LengthComparator() { } 
	
	/**
	 * @description getInstance
	 * Returns the Singleton instance of this comparator.
	 * 
	 * @param 
	 * @return lengthComparator
	 */
	public static LengthComparator getInstance() {
		if(lengthComparator == null) {
			lengthComparator = new LengthComparator();
		}
		return lengthComparator;
	}
	
	/**
	 * Defines the comparison for the length rating. 
	 * This method is specified by <code>Comparator</code> interface which this class implements.
	 * 
	 * An integer is returned, using the logic:
	 * 
	 * <pre>
	 * 		If card c1 has a length rating higher than card c2
	 * 		then
	 * 			return a positive integer
	 * 
	 * 		If card c2 has a length rating higher than card c1
	 * 		then 
	 * 			return a negative integer
	 * 
	 * 		Otherwise return zero
	 * </pre>
	 * 
	 * @return +1, -1 or 0
	 */
	public int compare(CardAnimalModel c1, CardAnimalModel c2) {
		return c1.getLength().getValue().compareTo(c2.getLength().getValue());
	}
}
