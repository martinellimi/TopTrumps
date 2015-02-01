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
import mdx.toptrumps.model.CardAnimalModel;
import mdx.toptrumps.model.UserModel;
import mdx.toptrumps.service.GameService;
import mdx.toptrumps.service.GameServiceImpl;
import mdx.toptrumps.service.UserService;
import mdx.toptrumps.service.UserServiceImpl;

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
	
//	private Map<UserModel, CardAnimalModel> move;
	
//	private Map<UserModel, List<CardAnimalModel>> game;
	
	private Map.Entry<UserModel, LinkedList<CardAnimalModel>> computer;
	
	private Map.Entry<UserModel, LinkedList<CardAnimalModel>> player1;
	
	private UserModel playerTurn;
	
	private static CommonSystem commonSystem;
	
	private GameService gameService = new GameServiceImpl();
	
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
//	public Map<UserModel, CardAnimalModel> getMove() {
//		if(this.move == null) {
//			this.move = new HashMap<UserModel, CardAnimalModel>();
//		}
//		return move;
//	}

//	/** @param move the move to set */
//	public void setMove(Map<UserModel, CardAnimalModel> move) {
//		this.move = move;
//	}
	
	/** @return the players */
	public List<UserModel> getPlayers() {
		return players;
	}

	/** @param players the players to set */
	public void setPlayers(List<UserModel> players) {
		this.players = players;
	}
	
//	/** @return the game */
//	public Map<UserModel, List<CardAnimalModel>> getGame() {
//		return game;
//	}
//
//	/** @param game the game to set */
//	public void setGame(Map<UserModel, List<CardAnimalModel>> game) {
//		this.game = game;
//	}
	
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
	public void setPlayerTurn(UserModel playerTurn) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		this.playerTurn = playerTurn;
		if(playerTurn.isComputer() == true) {
			gameService.computerMove(this.computer.getValue().get(0));
		}
	}
	
	/** @return the player1 */
	public Map.Entry<UserModel, LinkedList<CardAnimalModel>> getPlayer1() {
		return player1;
	}

	/** @param player1 the player1 to set */
	public void setPlayer1(Map.Entry<UserModel, LinkedList<CardAnimalModel>> player1) {
		this.player1 = player1;
	}

}
