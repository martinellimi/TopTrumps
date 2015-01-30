/**
 * TopTrumps - mdx.toptrumps.disney.model
 */
package mdx.toptrumps.model;

/**
 * @author martinellimi
 * 
 * @description CardAnimalAttribute.java 
 * class description
 * 
 * @version version 1.0 30 Jan 2015
 */
public enum CardAnimalAttribute {

	Height("Height"),
	Weight("Weight"),
	Length("Length"),
	Speed("Speed"),
	KillerInstinct("Killer Instinct");
	
	private String name;
	
	private CardAnimalAttribute(String name) { 
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}	
}
