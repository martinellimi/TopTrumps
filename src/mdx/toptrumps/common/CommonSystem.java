/**
 * TopTrumps - mdx.toptrumps.common
 */
package mdx.toptrumps.common;

import java.lang.reflect.InvocationTargetException;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import android.app.Activity;
import android.content.pm.ServiceInfo;
import mdx.toptrumps.GameActivity;
import mdx.toptrumps.model.CardAnimalModel;
import mdx.toptrumps.model.UserModel;
import mdx.toptrumps.service.GameService;
import mdx.toptrumps.service.GameServiceImpl;
import mdx.toptrumps.service.UserService;
import mdx.toptrumps.service.UserServiceImpl;

/**
 * @author martinellimi
 * 
 * Description: CommonSystem.java 
 * This class creates a common space to objects that will be used until the game is closed.
 * These objects can be accessed from all other packages.
 * This class implements the Singleton Design Pattern
 * 
 * @version version 1.0 28 Jan 2015
 */
public final class CommonSystem {
	
	public static final Integer NUMBER_CARDS_PLAYER = 15;

	/** Description: List that represents all the players in the game */
	private List<UserModel> players;
	
	/** Description: List that represents all the cards in the game */
	private List<CardAnimalModel> cards;
	
	/** Description: Computer player Object */
	private Map.Entry<UserModel, LinkedList<CardAnimalModel>> computer;
	
	/** Description: Player 1 Object */
	private Map.Entry<UserModel, LinkedList<CardAnimalModel>> player1;
	
	/** Description: List that contains all the draw cards */
	private LinkedList<CardAnimalModel> draw;
	
	/** Description: It says if the game is in a draw. If true, the game is in a draw and the rules need to be different */
	private Boolean gameDraw;
	
	/** Description: Sets the player turn */
	private UserModel playerTurn;
	
	/** Description: Winner player */
	private UserModel winner;
	
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
	
	/** @return the players */
	public List<UserModel> getPlayers() {
		return players;
	}

	/** @param players the players to set */
	public void setPlayers(List<UserModel> players) {
		this.players = players;
	}
	
	/** @return the computer */
	public Map.Entry<UserModel, LinkedList<CardAnimalModel>> getComputer() {
		return computer;
	}

	/** @param computer the computer to set */
	public void setComputer(Map.Entry<UserModel, LinkedList<CardAnimalModel>> computer) {
		if(this.computer == null) {
			this.computer = new AbstractMap.SimpleEntry<UserModel, LinkedList<CardAnimalModel>>(null, null);
		}
		this.computer = computer;
	}
	
	/** @return the playerTurn */
	public UserModel getPlayerTurn() {
		return playerTurn;
	}

	/** @param userTurn the userTurn to set 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException */
	public void setPlayerTurn(UserModel playerTurn) {
		this.playerTurn = playerTurn;
	}
	
	/** @return the player1 */
	public Map.Entry<UserModel, LinkedList<CardAnimalModel>> getPlayer1() {
		return player1;
	}

	/** @param player1 the player1 to set */
	public void setPlayer1(Map.Entry<UserModel, LinkedList<CardAnimalModel>> player1) {
		this.player1 = player1;
	}
	
	/** @return the winner */
	public UserModel getWinner() {
		return winner;
	}

	/** @param winner the winner to set */
	public void setWinner(UserModel winner) {
		this.winner = winner;
	}
	
	/** @return the draw */
	public LinkedList<CardAnimalModel> getDraw() {
		if(this.draw == null) {
			this.draw = new LinkedList<CardAnimalModel>();
		}
		return draw;
	}

	/** @param draw the draw to set */
	public void setDraw(LinkedList<CardAnimalModel> draw) {
		this.draw = draw;
	}
	
	/** @return the gameDraw */
	public Boolean isGameDraw() {
		return gameDraw;
	}

	/** @param gameDraw the gameDraw to set */
	public void setGameDraw(Boolean gameDraw) {
		this.gameDraw = gameDraw;
	}

}
