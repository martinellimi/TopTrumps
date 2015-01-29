/**
 * 
 */
package mdx.toptrumps.disney.model.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import mdx.toptrumps.common.CommonSystem;
import mdx.toptrumps.disney.TopTrumpsActivity;
import mdx.toptrumps.disney.model.Attribute;
import mdx.toptrumps.disney.model.CardAttributeType;
import mdx.toptrumps.disney.model.CardModel;
import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * @author martinellimi
 * 
 * @description TextFileAccess.java 
 * Singleton class to access file and generate the cards.
 * 
 * @version version 1.0 27 Jan 2015
 */
public class TextFileAccess {

	/** @description self static reference to the Singleton pattern */
	static TextFileAccess dataAccessor; 
	
	/** @description reference to the Activity received in the constructor to create the asset */
	private Activity mainActivity;
	
	/** @description reference to the asset manager to setting up streams */
	private AssetManager assetManager;
	
	/**
	 * @param mainActivity
	 * @description private constructor following the Singleton Design Patter. 
	 * To get the instance of this class, is used getInstance method, it ensures that only one instance
	 * will be create.
	 */
	private TextFileAccess(Activity mainActivity) {
		this.mainActivity = TopTrumpsActivity.activity;
		this.assetManager = this.mainActivity.getAssets();
	}
	
	
	/**
	 * @description getInstance 
	 * Returns the single TextFileAccess instance. (Singleton pattern)
	 * 
	 * @param Activity parent
	 * @return TextFileAccess
	 */
	static TextFileAccess getInstance(Activity parent) {
		if(dataAccessor == null) {
			dataAccessor = new TextFileAccess(parent);
		}
		
		return dataAccessor;
	}
	
	/**
	 * @description getCards
	 * Returns a list with all cards object for the game.
	 * 
	 * @return List<CardModel>
	 */
	public List<CardModel> getCards() {
		return this.getData();
	}
	
	/**
	 * @description getData
	 * Private method which compiles the list of cards. Internally, this method uses a <code>Scanner</code> 
	 * to read the file line-by-line and parses each line into a CardModel.
	 * This method also uses <code>String</code> 'split' to read the file line-by-line. 
	 * 
	 * @return List<CardModel>
	 */
	private List<CardModel> getData() {
		List<CardModel> data = new ArrayList<CardModel>();
		
		InputStream stream = null;
		
		try {
			
			//TODO: Create cards.db
			stream = assetManager.open("");
			
		} catch (IOException e) {
			System.out.println("Error while opening the file");
			e.printStackTrace();
		}
			
			Scanner sc = new Scanner(stream);
			
			sc.useDelimiter("\n");
			
			while(sc.hasNext()) {
				String line = sc.next().trim();
				
				String[] bits = line.split(":");
				
				String name = bits[0];                             					 // name 
				
				String img = bits[1];                              					 // image file name
				Attribute happiness = new Attribute(
						CardAttributeType.Happiness, Integer.parseInt(bits[2]));     //happiness attribute
				Attribute magic = new Attribute(
						CardAttributeType.Magic, Integer.parseInt(bits[3]));         // magic attribute
				Attribute strength = new Attribute(
						CardAttributeType.Strength, Integer.parseInt(bits[4]));      // strength attribute
				Attribute intelligence = new Attribute(
						CardAttributeType.Intelligence, Integer.parseInt(bits[5]));  // intelligence attribute
				Attribute bravery = new Attribute(
						CardAttributeType.Bravery, Integer.parseInt(bits[6]));       // bravery attribute
				Attribute firstOnFilm = new Attribute(
						CardAttributeType.FirstOnFilm, Integer.parseInt(bits[7]));   // first on film attribute
				
				InputStream imageStream = null;
				
				try {
					imageStream = assetManager.open("" + img);
				} catch (IOException e) {
					System.out.println("Error while opening the image.");
					e.printStackTrace();
				}
				
				Bitmap image = BitmapFactory.decodeStream(imageStream);
				
				CardModel card = new CardModel(image, name, happiness, magic, strength, intelligence, bravery, firstOnFilm);
				
				data.add(card);
			}
			
			return data;
	}
}
