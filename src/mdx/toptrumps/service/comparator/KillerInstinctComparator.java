/**
 * TopTrumps - mdx.toptrumps.disney.service.comparator
 */
package mdx.toptrumps.service.comparator;

import java.util.Comparator;

import mdx.toptrumps.model.CardAnimalModel;

/**
 * @author martinellimi
 * 
 * Description: killer InstinctComparator.java 
 * Custom comparator class based on the <i>killer Instinct rating</i> of the 
 * CardModel object. This class follows the Singleton Design Pattern.
 * 
 * @version version 1.0 28 Jan 2015
 */
public class KillerInstinctComparator implements Comparator<CardAnimalModel> {

	/** Description: Reference to the comparator object */
	private static KillerInstinctComparator killerInstinctComparator;
	
	/** Private constructor following Singleton pattern, 
	 * so cannot be called from external code. 
	 */
	private KillerInstinctComparator() { } 
	
	/**
	 * Description: getInstance
	 * Returns the Singleton instance of this comparator.
	 * 
	 * @param 
	 * @return killer InstinctComparator
	 */
	public static KillerInstinctComparator getInstance() {
		if(killerInstinctComparator == null) {
			killerInstinctComparator = new KillerInstinctComparator();
		}
		return killerInstinctComparator;
	}
	
	/**
	 * Defines the comparison for the killer Instinct rating. 
	 * This method is specified by <code>Comparator</code> interface which this class implements.
	 * 
	 * An integer is returned, using the logic:
	 * 
	 * <pre>
	 * 		If card c1 has a killer Instinct rating higher than card c2
	 * 		then
	 * 			return a positive integer
	 * 
	 * 		If card c2 has a killer Instinct rating higher than card c1
	 * 		then 
	 * 			return a negative integer
	 * 
	 * 		Otherwise return zero
	 * </pre>
	 * 
	 * @return +1, -1 or 0
	 */
	public int compare(CardAnimalModel c1, CardAnimalModel c2) {
		return c1.getKillerInstinct().getValue().compareTo(c2.getKillerInstinct().getValue());
	}
}
