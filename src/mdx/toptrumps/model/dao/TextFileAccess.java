/**
 * 
 */
package mdx.toptrumps.model.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import mdx.toptrumps.TopTrumpsActivity;
import mdx.toptrumps.common.CommonSystem;
import mdx.toptrumps.model.AnimalAttribute;
import mdx.toptrumps.model.Attribute;
import mdx.toptrumps.model.CardAnimalAttribute;
import mdx.toptrumps.model.CardAnimalModel;
import mdx.toptrumps.model.CardAttributeType;
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
	public List<CardAnimalModel> getCards() {
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
	private List<CardAnimalModel> getData() {
		List<CardAnimalModel> data = new ArrayList<CardAnimalModel>();
		
		InputStream stream = null;
		
		try {
			
			//TODO: Create cards.db
			stream = assetManager.open("database/animal.db");
			
		} catch (IOException e) {
			System.out.println("Error while opening the file");
			e.printStackTrace();
		}
			
			Scanner sc = new Scanner(stream);
			
			sc.useDelimiter("\n");
			
			Integer id = 0;
			
			while(sc.hasNext()) {
				String line = sc.next().trim();
				
				String[] bits = line.split(":");
				
				String name = bits[0];                             					 // name 
				
				String img = bits[1];                              					 // image file name
				
				Integer weight = Integer.parseInt(bits[2]);                          // image weight name
				
				Integer length = Integer.parseInt(bits[3]);                          // image length name
				
				AnimalAttribute animalHeight = new AnimalAttribute(
						CardAnimalAttribute.Height, Double.parseDouble(bits[4]));     			//height attribute
				AnimalAttribute animalWeight = new AnimalAttribute(
						CardAnimalAttribute.Weight, Double.parseDouble(bits[5]));         		// weight attribute
				AnimalAttribute animalLength = new AnimalAttribute(
						CardAnimalAttribute.Length, Double.parseDouble(bits[6]));      			// length attribute
				AnimalAttribute speed = new AnimalAttribute(
						CardAnimalAttribute.Speed, Double.parseDouble(bits[7]));  				// speed attribute
				AnimalAttribute killer = new AnimalAttribute(
						CardAnimalAttribute.KillerInstinct, Double.parseDouble(bits[8]));       // killer Instinct attribute
				
				InputStream imageStream = null;
				
				try {
					imageStream = assetManager.open("" + img);
				} catch (IOException e) {
					System.out.println("Error while opening the image.");
					e.printStackTrace();
				}
				
				Bitmap image = BitmapFactory.decodeStream(imageStream);
				
				id++;
				
				CardAnimalModel card = new CardAnimalModel(id, image, name, weight, length, animalHeight, animalWeight, animalLength, speed, killer);
				
				data.add(card);
			}
			
			return data;
	}
}
