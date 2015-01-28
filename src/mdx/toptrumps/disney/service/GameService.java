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
 * @description GameService.java 
 * This interface contains methods to control the game.
 * 
 * @version version 1.0 27 Jan 2015
 */
public interface GameService {
	
	/**
	 * @description startGame
	 * Simply starts the game returning the list with all the cards 
	 * and setting up the players.
	 * 
	 * @return List<CardModel>
	 */
	public List<CardModel> startGame();
	
	
	/**
	 * @description evaluateMove
	 * Evaluates the move, using comparable to compare the players cards, 
	 * deciding the winner and the loser and the next player to start the move.
	 * 
	 * @param 
	 * @return UserModel
	 */
	public UserModel evaluateMove();
	
	/**
	 * @description computerMode
	 * Decides which attribute the computer will 'play' against the other player 
	 * and returns this attribute.
	 * 
	 * @return CardAttributeType
	 */
	public CardAttributeType computerMode();
}
