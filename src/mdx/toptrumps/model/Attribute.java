/**
 * TopTrumps - mdx.toptrumps.disney.model
 */
package mdx.toptrumps.model;

/**
 * @author martinellimi
 * 
 * @description Attribute.java 
 * Represents the card attribute
 * 
 * @version version 1.0 27 Jan 2015
 */
public class Attribute {

	private CardAttributeType attribute;
	private  Integer value;
	
	public Attribute(Integer value, CardAttributeType attribute) {
		this.attribute = attribute;
		this.value = value;
	}

	/** @return the attribute */
	public CardAttributeType getAttribute() {
		return attribute;
	}
	/** @param attribute the attribute to set */
	public void setAttribute(CardAttributeType attribute) {
		this.attribute = attribute;
	}
	/** @return the value */
	public Integer getValue() {
		return value;
	}
	/** @param value the value to set */
	public void setValue(Integer value) {
		this.value = value;
	}
	
	public Attribute(CardAttributeType att, Integer value) {
		this.attribute = att;
		this.value = value;
	}
	
	public Attribute() { }
	
}
