/**
 * TopTrumps - mdx.toptrumps.disney.service
 */
package mdx.toptrumps.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import mdx.toptrumps.model.CardAnimalAttribute;
import mdx.toptrumps.model.CardAnimalModel;
import mdx.toptrumps.model.UserModel;

/**
 * @author martinellimi
 * 
 * Description: GameService.java 
 * This interface contains methods to control the game.
 * 
 * @version version 1.0 27 Jan 2015
 */
public interface GameService {
	
	/**
	 * Description: startGame
	 * Simply starts the game returning the list with all the cards 
	 * and setting up the players.
	 * 
	 * @return List<CardModel>
	 */
	public List<CardAnimalModel> startGame();
	
	
	/**
	 * Description: evaluateMove
	 * Evaluates the move, using comparable to compare the players cards, 
	 * deciding the winner and the loser and the next player to start the move.
	 * 
	 * @param 
	 * @return UserModel
	 */
	public UserModel evaluateMove(CardAnimalAttribute attr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
	/**
	 * Description: computerMode
	 * Decides which attribute the computer will 'play' against the other player 
	 * and returns this attribute.
	 * 
	 * @return CardAttributeType
	 */
	public CardAnimalAttribute computerMove(CardAnimalModel card) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
	public void setWinner(UserModel user);
}
