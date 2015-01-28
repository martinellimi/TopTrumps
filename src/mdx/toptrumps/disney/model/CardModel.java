/**
 * 
 */
package mdx.toptrumps.disney.model;

import android.graphics.Bitmap;

/**
 * @author martinellimi
 * @description CardModel.java - This class is the model for the cards used in the game.
 * @version version 1.0 27 Jan 2015
 */
public class CardModel {
	
	

	/**
	 * @param image
	 * @param name
	 * @param happiness
	 * @param magic
	 * @param strength
	 * @param intelligence
	 * @param bravery
	 * @param firstOnFilm
	 */
	public CardModel(Bitmap image, String name, Attribute happiness,
			Attribute magic, Attribute strength, Attribute intelligence,
			Attribute bravery, Attribute firstOnFilm) {
		super();
		this.image = image;
		this.name = name;
		this.happiness = happiness;
		this.magic = magic;
		this.strength = strength;
		this.intelligence = intelligence;
		this.bravery = bravery;
		this.firstOnFilm = firstOnFilm;
	}
	
	public CardModel() { };

	/** @description card Id */
	private Integer id;
	
	/** @description Image that represents the Disney characters */
	private Bitmap image;
	
	/** @description Disney characters name */
	private String name;
	
	/** @description Happiness attribute */
	private Attribute happiness;
	
	/** @description Magic attribute */
	private Attribute magic;
	
	/** @description Strength attribute */
	private Attribute strength;
	
	/** @description Intelligence attribute */
	private Attribute intelligence;
	
	/** @description Bravery attribute */
	private Attribute bravery;
	
	/** @description First time that the character has appeared in a this movie attribute */
	private Attribute firstOnFilm;

	/** @return the card id */
	public Integer getId() {
		return id;
	}

	/** @return the card image */
	public Bitmap getImage() {
		return image;
	}

	/** @return the card name */
	public String getName() {
		return name;
	}

	/** @return the happiness attribute value */
	public Attribute getHappiness() {
		return happiness;
	}

	/** @return the magic attribute value */
	public Attribute getMagic() {
		return magic;
	}

	/** @return the strength */
	public Attribute getStrength() {
		return strength;
	}

	/** @return the intelligence */
	public Attribute getIntelligence() {
		return intelligence;
	}

	/** @return the bravery */
	public Attribute getBravery() {
		return bravery;
	}

	/** @return the firstOnFilm */
	public Attribute getFirstOnFilm() {
		return firstOnFilm;
	}
}
