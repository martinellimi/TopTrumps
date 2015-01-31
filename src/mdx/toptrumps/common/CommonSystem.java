/**
 * TopTrumps - mdx.toptrumps.common
 */
package mdx.toptrumps.common;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import android.app.Activity;
import mdx.toptrumps.model.CardAnimalModel;
import mdx.toptrumps.model.UserModel;

/**
 * @author martinellimi
 * 
 * @description CommonSystem.java 
 * This class creates a common space to objects that will be used until the game is closed.
 * These objects can be accessed from all other packages.
 * This class implements the Singleton Design Pattern
 * 
 * @version version 1.0 28 Jan 2015
 */
public final class CommonSystem {
	
	public static final Integer NUMBER_CARDS_PLAYER = 15;

	private List<UserModel> players;
	
	private List<CardAnimalModel> cards;
	
	private Map<UserModel, CardAnimalModel> move;
	
	private Map<UserModel, List<CardAnimalModel>> game;
	
	private Map.Entry<UserModel, List<CardAnimalModel>> computer;
	
	private static CommonSystem commonSystem;
	
	private CommonSystem() { }
	
	public static CommonSystem getInstance() {
		if(CommonSystem.commonSystem == null) {
			CommonSystem.commonSystem = new CommonSystem();
		}
		
		return CommonSystem.commonSystem;
	}
	
	/** @return the cards */
	public List<CardAnimalModel> getCards() {
		return cards;
	}

	/** @param cards the cards to set */
	public void setCards(List<CardAnimalModel> cards) {
		this.cards = cards;
	}
	
	/** @return the move */
	public Map<UserModel, CardAnimalModel> getMove() {
		if(this.move == null) {
			this.move = new HashMap<UserModel, CardAnimalModel>();
		}
		return move;
	}

	/** @param move the move to set */
	public void setMove(Map<UserModel, CardAnimalModel> move) {
		this.move = move;
	}
	
	/** @return the players */
	public List<UserModel> getPlayers() {
		return players;
	}

	/** @param players the players to set */
	public void setPlayers(List<UserModel> players) {
		this.players = players;
	}
	
	/** @return the game */
	public Map<UserModel, List<CardAnimalModel>> getGame() {
		return game;
	}

	/** @param game the game to set */
	public void setGame(Map<UserModel, List<CardAnimalModel>> game) {
		this.game = game;
	}
	
	/** @return the computer */
	public Map.Entry<UserModel, List<CardAnimalModel>> getComputer() {
		return computer;
	}

	/** @param computer the computer to set */
	public void setComputer(Map.Entry<UserModel, List<CardAnimalModel>> computer) {
		if(this.computer == null) {
			this.computer = new AbstractMap.SimpleEntry<UserModel, List<CardAnimalModel>>(null, null);
		}
		this.computer = computer;
	}
}
