/**
 * TopTrumps - mdx.toptrumps.disney.service
 */
package mdx.toptrumps.disney.service;

import java.util.List;

import mdx.toptrumps.disney.model.CardAttributeType;
import mdx.toptrumps.disney.model.CardModel;
import mdx.toptrumps.disney.model.UserModel;

/**
 * @author martinellimi
 * 
 * @description GameServiceImpl.java 
 * Implements the <code>GameService</code> Interface. 
 * This class is responsible to control all the game actions.
 * 
 * @version version 1.0 27 Jan 2015
 */
public class GameServiceImpl implements GameService {

	/** @description Reference to the <code>CardService</code> to use methods to manipulate Card object */
	private CardService cardService;
	
	/** @description Reference to the <code>UserService</code> to use methods to manipulate User object*/
	private UserService userService;
	
	/** @description List that contains the players for the game. */
	private List<UserModel> users;
	
	/**
	 * @description distributeCardsRandom
	 * Distributes the cards randomly.
	 * 
	 * @return List<CardModel>
	 * TODO: Implement this method
	 */
	private List<CardModel> distributeCardsRandom() {
		return null;
	}
	
	/**
	 * @description chooseFirstUser
	 * Chooses the first player to start the game.
	 * 
	 * @return UserModel
	 * TODO: Implements this method
	 */
	private UserModel chooseFirstUser() {
		return null;
	}
	
	/**
	 * @description startGame
	 * Simply starts the game returning the list with all the cards 
	 * and setting up the players.
	 * 
	 * @param 
	 * @return List<CardModel>
	 * @see GameService#startGame()
	 */
	public List<CardModel> startGame() {
		return null;
	}

	/**
	 * @description evaluateMove
	 * Evaluates the move, using comparable to compare the players cards, 
	 * deciding the winner and the loser and the next player to start the move.
	 * 
	 * @param 
	 * @return List<CardModel>
	 * @see GameService#evaluateMove()
	 */
	public UserModel evaluateMove() {
		return null;
	}

	/**
	 * @description computerMode
	 * Decides which attribute the computer will 'play' against the other player 
	 * and returns this attribute.
	 * 
	 * @return CardAttributeType
	 * @see GameService#computerMode()
	 */
	public CardAttributeType computerMode() {
		return null;
	}
}
