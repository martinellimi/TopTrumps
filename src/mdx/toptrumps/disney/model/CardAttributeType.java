/**
 * TopTrumps - mdx.toptrumps.disney.model
 */
package mdx.toptrumps.disney.model;

/**
 * @author martinellimi
 * 
 * @description CardAttributeType.java 
 * Represents the card attributes.
 * 
 * @version version 1.0 27 Jan 2015
 */
public enum CardAttributeType {

	Happiness("Happiness"),
	Magic("Magic"),
	Strength("Strength"),
	Bravery("Bravery"),
	Intelligence("Intelligence"),
	FirstOnFilm("First On Film");
	
	private String name;
	
	private CardAttributeType(String name) { 
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
