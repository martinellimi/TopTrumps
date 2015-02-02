/**
 * TopTrumps - mdx.toptrumps.disney.service.comparator
 */
package mdx.toptrumps.service.comparator;

import java.util.Comparator;

import mdx.toptrumps.model.CardAnimalModel;

/**
 * @author martinellimi
 * 
 * @description speedComparator.java 
 * Custom comparator class based on the <i>speed rating</i> of the 
 * CardModel object. This class follows the Singleton Design Pattern.
 * 
 * @version version 1.0 28 Jan 2015
 */
public class SpeedComparator implements Comparator<CardAnimalModel> {

	/** @description Reference to the comparator object */
	private static SpeedComparator speedComparator;
	
	/** Private constructor following Singleton pattern, 
	 * so cannot be called from external code. 
	 */
	private SpeedComparator() { } 
	
	/**
	 * @description getInstance
	 * Returns the Singleton instance of this comparator.
	 * 
	 * @param 
	 * @return speedComparator
	 */
	public static SpeedComparator getInstance() {
		if(speedComparator == null) {
			speedComparator = new SpeedComparator();
		}
		return speedComparator;
	}
	
	/**
	 * Defines the comparison for the speed rating. 
	 * This method is specified by <code>Comparator</code> interface which this class implements.
	 * 
	 * An integer is returned, using the logic:
	 * 
	 * <pre>
	 * 		If card c1 has a speed rating higher than card c2
	 * 		then
	 * 			return a positive integer
	 * 
	 * 		If card c2 has a speed rating higher than card c1
	 * 		then 
	 * 			return a negative integer
	 * 
	 * 		Otherwise return zero
	 * </pre>
	 * 
	 * @return +1, -1 or 0
	 */
	public int compare(CardAnimalModel c1, CardAnimalModel c2) {
		return c1.getSpeed().getValue().compareTo(c2.getSpeed().getValue());
	}
}
