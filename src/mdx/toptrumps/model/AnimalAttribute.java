/**
 * TopTrumps - mdx.toptrumps.disney.model
 */
package mdx.toptrumps.model;

/**
 * @author martinellimi
 * 
 * Description: AnimalAttribute.java 
 * Represents the attribute for the animal card. Has one attribute and the respective value.
 * 
 * @version version 1.0 30 Jan 2015
 */
public class AnimalAttribute {

	private CardAnimalAttribute attribute;
	private Double value;
	
	public AnimalAttribute(CardAnimalAttribute attribute, Double value) {
		this.attribute = attribute;
		this.value = value;
	}

	/** @return the attribute */
	public CardAnimalAttribute getAttribute() {
		return attribute;
	}
	/** @param attribute the attribute to set */
	public void setAttribute(CardAnimalAttribute attribute) {
		this.attribute = attribute;
	}
	/** @return the value */
	public Double getValue() {
		return value;
	}
	/** @param value the value to set */
	public void setValue(Double value) {
		this.value = value;
	}
	
	public AnimalAttribute() { }
	
}
