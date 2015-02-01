/**
 * TopTrumps - mdx.toptrumps.disney.service
 */
package mdx.toptrumps.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import android.app.Activity;
import mdx.toptrumps.common.CommonSystem;
import mdx.toptrumps.model.AnimalAttribute;
import mdx.toptrumps.model.Attribute;
import mdx.toptrumps.model.CardAnimalAttribute;
import mdx.toptrumps.model.CardAnimalModel;
import mdx.toptrumps.model.CardAttributeType;
import mdx.toptrumps.model.UserModel;
import mdx.toptrumps.service.comparator.HeightComparator;
import mdx.toptrumps.service.comparator.KillerInstinctComparator;
import mdx.toptrumps.service.comparator.LengthComparator;
import mdx.toptrumps.service.comparator.SpeedComparator;
import mdx.toptrumps.service.comparator.WeightComparator;

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
	
	public GameServiceImpl(Activity activity) {
		cardService = new CardServiceImpl(activity);
		userService = new UserServiceImpl();
	}
	
	public GameServiceImpl() {
		cardService = new CardServiceImpl();
		userService = new UserServiceImpl();
	}
	
	/**
	 * @description distributeCardsRandom
	 * Distributes the cards randomly.
	 * 
	 * @return List<CardModel>
	 * TODO: Implement this method
	 */
	private void distributeCardsRandom() {
		List<CardAnimalModel> shuffledList = CommonSystem.getInstance().getCards();
		Collections.shuffle(shuffledList);
		
		int start = 0;
		
		for (UserModel player : CommonSystem.getInstance().getPlayers()) {
			int cardLimit = start + CommonSystem.NUMBER_CARDS_PLAYER;
			
			LinkedList<CardAnimalModel> cards = new LinkedList<CardAnimalModel>();
			
			for (int i = start; i < cardLimit; i++) {
				cards.add(shuffledList.get(i));
			}
			if(player.isComputer() == true) {
				CommonSystem.getInstance().getComputer().setValue(cards);
			} else {
				CommonSystem.getInstance().getPlayer1().setValue(cards);
			}
			start = cardLimit;
		}
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
	 * @return List<CardModel>
	 * @see GameService#startGame()
	 */
	public List<CardAnimalModel> startGame() {
		
		List<CardAnimalModel> cards = cardService.getCards();
		CommonSystem.getInstance().setCards(cards);
		
		userService.createUser("Test");
		
		distributeCardsRandom();
		
		return cards;
	}

	/**
	 * @description evaluateMove
	 * Evaluates the move, using comparable to compare the players cards, 
	 * deciding the winner and the loser and the next player to start the move.
	 * 
	 * @param CardAnimalAttribute attr
	 * @return List<CardModel>
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @see GameService#evaluateMove()
	 */
	public UserModel evaluateMove(CardAnimalAttribute attr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		CardAnimalModel player1Card = CommonSystem.getInstance().getPlayer1().getValue().get(0);
		CardAnimalModel computerCard = CommonSystem.getInstance().getComputer().getValue().get(0);
		
		UserModel returnUser = new UserModel();
		
		Integer winner = 0;
		
		switch (attr) {
			case Height:
				winner = HeightComparator.getInstance().compare(player1Card, computerCard);
			break;
			case Weight:
				winner = WeightComparator.getInstance().compare(player1Card, computerCard);
			break;
			case Length:
				winner = LengthComparator.getInstance().compare(player1Card, computerCard);
			break;
			case KillerInstinct:
				winner = KillerInstinctComparator.getInstance().compare(player1Card, computerCard);
			break;
			case Speed:
				winner = SpeedComparator.getInstance().compare(player1Card, computerCard);
			break;
		}
		
		if(winner == 1) {
			returnUser = CommonSystem.getInstance().getPlayer1().getKey();
		} else if(winner == 0) {
			
		} else {
			returnUser = CommonSystem.getInstance().getComputer().getKey();
		}
		
		CommonSystem.getInstance().setPlayerTurn(returnUser);
		
		return returnUser;
	}
	
	/**
	 * @description computerMove
	 * Decides which attribute the computer will 'play' against the other player 
	 * and returns this attribute.
	 * Receives the Computer card and computes the probability to win the move with each
	 * attribute of the card and returns the attribute that has the highest probability.
	 * 
	 * @param CardAnimalModelCopy card
	 * @return CardAttributeType
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @see GameService#computerMode()
	 */
	public CardAnimalAttribute computerMove(CardAnimalModel card) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		List<CardAnimalAttribute> attributes = Arrays.asList(CardAnimalAttribute.values());
		
		Integer counter = 0;
		
		Map.Entry<CardAnimalAttribute, Double> bestMove = new AbstractMap.SimpleEntry<CardAnimalAttribute, Double>(CardAnimalAttribute.Height, 0.00);
		
		for (CardAnimalAttribute att : attributes) {
			for (CardAnimalModel item : CommonSystem.getInstance().getCards()) {
				AnimalAttribute attr = this.getAttribute(item, att);
				if(attr.getValue() < this.getAttribute(card, att).getValue()) {
					counter++;
				}
			}
			
			Double probability = calculateProbability(counter, CommonSystem.getInstance().getCards().size());
			
			if(probability > bestMove.getValue()) {
				bestMove = new AbstractMap.SimpleEntry<CardAnimalAttribute, Double>(att, probability);
			}
			counter = 0;
		}
		
		return bestMove.getKey();
	}
	
	
	/**
	 * @description getAttribute
	 * Returns the getter method attribute on the CardModel which is equal to the <code>CardAttributeType</code>
	 * Using Reflection, the method invokes the getter method which has the same name as the <code>CardAttributeType</code>
	 * and returns the value that the getter method returns.
	 * 
	 * @param CardAnimalModelCopy card, CardAttributeType key
	 * @return Attribute
	 */
	private AnimalAttribute getAttribute(CardAnimalModel card, CardAnimalAttribute key) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		AnimalAttribute object = new AnimalAttribute();
		
		try {
			
			Class aClass = card.getClass();
			
			Method method = card.getClass().getMethod("get" + key.getName().replace(" ", ""), null);
	
			Object returnValue = method.invoke(card, null);
			
			object = AnimalAttribute.class.cast(returnValue);
		
		} catch (NoSuchMethodException e) {
			System.out.println("Error when getting attribute.");
			e.printStackTrace();
		}
		
		return object;
	}
	
	/**
	 * @description calculateProbability
	 * Calculates the probability to win the move using this card attribute. 
	 * It receives the number of cards which has the attribute value smaller than the computer card
	 * and receives the total cards in the game and divides the number of cards for the total cards in the game
	 * and returns the probability to win the move with this attribute.
	 * 
	 * @param Integer value and Integer total
	 * @return Double
	 */
	private static Double calculateProbability(Integer value, Integer total) {
		
		Double result = 0.00;
		
		result = ((double)value/(double)(total-1));
		
		return result;
	}
	
	public void setWinner(UserModel user) {
		userService.setWinner(user);
	}
}
