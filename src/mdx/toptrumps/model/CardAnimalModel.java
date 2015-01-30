/**
 * TopTrumps - mdx.toptrumps.disney.model
 */
package mdx.toptrumps.model;

import android.graphics.Bitmap;

/**
 * @author martinellimi
 * 
 * @description CardAnimalModel.java 
 * class description
 * 
 * @version version 1.0 30 Jan 2015
 */
public class CardAnimalModel extends CardModel {

	public CardAnimalModel() { }
	
	public CardAnimalModel(Integer id, Bitmap image, String name, Integer cardWeight, Integer cardLength, 
			AnimalAttribute height, AnimalAttribute weight, AnimalAttribute length, AnimalAttribute speed, AnimalAttribute killerInstinct) {
		super();
		super.setId(id);
		super.setImage(image);
		super.setName(name);
		super.setCardWeight(cardWeight);
		super.setCardLength(cardLength);
		this.height = height;
		this.weight = weight;
		this.length = length;
		this.speed = speed;
		this.killerInstinct = killerInstinct;
	}
	
	/** @description field description */
	private AnimalAttribute height;

	/** @description field description */
	private AnimalAttribute weight;
	
	/** @description field description */
	private AnimalAttribute length;
	
	/** @description field description */
	private AnimalAttribute speed;
	
	/** @description field description */
	private AnimalAttribute killerInstinct;
	
	/** @return the height */
	public AnimalAttribute getHeight() {
		return height;
	}

	/** @param height the height to set */
	public void setHeight(AnimalAttribute height) {
		this.height = height;
	}

	/** @return the weight */
	public AnimalAttribute getWeight() {
		return weight;
	}

	/** @param weight the weight to set */
	public void setWeight(AnimalAttribute weight) {
		this.weight = weight;
	}

	/** @return the length */
	public AnimalAttribute getLength() {
		return length;
	}

	/** @param length the length to set */
	public void setLength(AnimalAttribute length) {
		this.length = length;
	}

	/** @return the speed */
	public AnimalAttribute getSpeed() {
		return speed;
	}

	/** @param speed the speed to set */
	public void setSpeed(AnimalAttribute speed) {
		this.speed = speed;
	}

	/** @return the killerInstinct */
	public AnimalAttribute getKillerInstinct() {
		return killerInstinct;
	}

	/** @param killerInstinct the killerInstinct to set */
	public void setKillerInstinct(AnimalAttribute killerInstinct) {
		this.killerInstinct = killerInstinct;
	}
	
}
