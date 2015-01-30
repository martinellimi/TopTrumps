/**
 * TopTrumps - mdx.toptrumps.disney.view
 */
package mdx.toptrumps.view;

import mdx.toptrumps.model.CardAnimalModel;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author martinellimi
 * 
 * @description CardView.java 
 * class description
 * 
 * @version version 1.0 28 Jan 2015
 */
public class CardView {
	
	/** @description card image */
	public ImageView image;
	
	/** @description character name */
	public TextView name;
	
	/** @description label weight */
	public TextView weightLabel;
	
	/** @description label length */
	public TextView lengthLabel;
	
	/** @description magic label */
	public TextView magicLabel;
	
	/** @description strength label */
	public TextView strengthLabel;
	
	/** @description Intelligence label */
	public TextView intelLabel;
	
	/** @description Happiness label */
	public TextView happiLabel;
	
	/** @description Bravery label */
	public TextView braveLabel;
	
	/** @description First On Film label */
	public TextView firstLabel;
	
	/** @description Reference to the card */
	public CardAnimalModel card;
	
}
