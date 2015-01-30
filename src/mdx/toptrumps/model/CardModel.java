/**
 * TopTrumps - mdx.toptrumps.disney.model
 */
package mdx.toptrumps.model;

import android.graphics.Bitmap;

/**
 * @author martinellimi
 * 
 * @description Card.java 
 * class description
 * 
 * @version version 1.0 30 Jan 2015
 */
public class CardModel {

	private Integer id;
	
	private String name;
	
	private Bitmap image;
	
	private Integer cardWeight;
	
	private Integer cardLength;

	/** @return the id */
	public Integer getId() {
		return id;
	}

	/** @param id the id to set */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/** @return the name */
	public String getName() {
		return name;
	}

	/** @param name the name to set */
	public void setName(String name) {
		this.name = name;
	}

	/** @return the image */
	public Bitmap getImage() {
		return image;
	}

	/** @param image the image to set */
	public void setImage(Bitmap image) {
		this.image = image;
	}

	/** @return the weight */
	public Integer getCardWeight() {
		return cardWeight;
	}

	/** @param weight the weight to set */
	public void setCardWeight(Integer weight) {
		this.cardWeight = weight;
	}

	/** @return the length */
	public Integer getCardLength() {
		return cardLength;
	}

	/** @param length the length to set */
	public void setCardLength(Integer length) {
		this.cardLength = length;
	}
	
}
