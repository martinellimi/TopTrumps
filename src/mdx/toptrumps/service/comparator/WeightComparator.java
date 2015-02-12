/**
 * TopTrumps - mdx.toptrumps.disney.service.comparator
 */
package mdx.toptrumps.service.comparator;

import java.util.Comparator;

import mdx.toptrumps.model.CardAnimalModel;

/**
 * @author martinellimi
 * 
 * Description: weightComparator.java 
 * Custom comparator class based on the <i>weight rating</i> of the 
 * CardAnimalModel object. This class follows the Singleton Design Pattern.
 * 
 * @version version 1.0 28 Jan 2015
 */
public class WeightComparator implements Comparator<CardAnimalModel> {

	/** Description: Reference to the comparator object */
	private static WeightComparator weightComparator;
	
	/** Private constructor following Singleton pattern, 
	 * so cannot be called from external code. 
	 */
	private WeightComparator() { } 
	
	/**
	 * Description: getInstance
	 * Returns the Singleton instance of this comparator.
	 * 
	 * @param 
	 * @return WeightComparator
	 */
	public static WeightComparator getInstance() {
		if(weightComparator == null) {
			weightComparator = new WeightComparator();
		}
		return weightComparator;
	}
	
	/**
	 * Defines the comparison for the weight rating. 
	 * This method is specified by <code>Comparator</code> interface which this class implements.
	 * 
	 * An integer is returned, using the logic:
	 * 
	 * <pre>
	 * 		If card c1 has a weight rating higher than card c2
	 * 		then
	 * 			return a positive integer
	 * 
	 * 		If card c2 has a weight rating higher than card c1
	 * 		then 
	 * 			return a negative integer
	 * 
	 * 		Otherwise return zero
	 * </pre>
	 * 
	 * @return +1, -1 or 0
	 */
	public int compare(CardAnimalModel c1, CardAnimalModel c2) {
		return c1.getWeight().getValue().compareTo(c2.getWeight().getValue());
	}
}
