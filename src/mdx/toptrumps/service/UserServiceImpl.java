/**
 * TopTrumps - mdx.toptrumps.disney.service
 */
package mdx.toptrumps.service;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import mdx.toptrumps.common.CommonSystem;
import mdx.toptrumps.model.CardAnimalModel;
import mdx.toptrumps.model.UserModel;

/**
 * @author martinellimi
 * 
 * @description UserServiceImpl.java 
 * Implements the UserService interface and it is used to implement actions 
 * that manipulates UserModel object. 
 * 
 * @version version 1.0 27 Jan 2015
 */
public class UserServiceImpl implements UserService {

	/**
	 * @description
	 * Returns all the game players.
	 * 
	 * @return List<UserModel>
	 * @see UserService#getUsers()
	 * TODO: implement this method
	 */
	public List<UserModel> getUsers() {
		return null;
	}

	/**
	 * @description getUserPoints
	 * Returns the points of the player that was received as parameter in the method.
	 * 
	 * @param UserModel user
	 * @return Integer
	 * @see UserService#getUserPoints(UserModel)
	 * TODO: Implement this method
	 */
	public Integer getUserPoints(UserModel user) {
		return null;
	}

	/**
	 * @description setWinner
	 * Set the points for the winner and takes loser's points.
	 * 
	 * @param UserModel user
	 * @return void
	 * TODO: Implement this method
	 */
	public void setWinner(UserModel user) {
		if(user.isComputer() == true) {
			CardAnimalModel cardLost = new CardAnimalModel();
			cardLost = CommonSystem.getInstance().getPlayer1().getValue().get(0);
			CommonSystem.getInstance().getPlayer1().getValue().removeFirst();
			
			CardAnimalModel cardBack = new CardAnimalModel();
			cardBack = CommonSystem.getInstance().getComputer().getValue().get(0);
			CommonSystem.getInstance().getComputer().getValue().removeFirst();
			
			CommonSystem.getInstance().getComputer().getValue().addLast(cardLost);
			CommonSystem.getInstance().getComputer().getValue().addLast(cardBack);
			
			
		} else {
			CardAnimalModel cardLost = new CardAnimalModel();
			cardLost = CommonSystem.getInstance().getComputer().getValue().get(0);
			CommonSystem.getInstance().getComputer().getValue().removeFirst();
			
			CardAnimalModel cardBack = new CardAnimalModel();
			cardBack = CommonSystem.getInstance().getPlayer1().getValue().get(0);
			CommonSystem.getInstance().getPlayer1().getValue().removeFirst();
			
			CommonSystem.getInstance().getPlayer1().getValue().addLast(cardLost);
			CommonSystem.getInstance().getPlayer1().getValue().addLast(cardBack);
		}
		
		CommonSystem.getInstance().getPlayer1().getKey().setPoint(CommonSystem.getInstance().getPlayer1().getValue().size());
		CommonSystem.getInstance().getComputer().getKey().setPoint(CommonSystem.getInstance().getComputer().getValue().size());
	}

	/**
	 * @description createUser
	 * Creates the user with the name received as a parameter.
	 * 
	 * @param 
	 * @return void
	 * @see UserService#createUser(String)
	 * TODO: Implement this method
	 */
	public void createUser(String name) {
		List<UserModel> players = new ArrayList<UserModel>();
		
		Map.Entry<UserModel, LinkedList<CardAnimalModel>> computer = new AbstractMap.SimpleEntry<UserModel, LinkedList<CardAnimalModel>>(createComputer(), null);
		Map.Entry<UserModel, LinkedList<CardAnimalModel>> player1 = new AbstractMap.SimpleEntry<UserModel, LinkedList<CardAnimalModel>>(createCommonUser(name), null);
		CommonSystem.getInstance().setComputer(computer);
		CommonSystem.getInstance().setPlayer1(player1);
		
		players.add(createComputer());
		players.add(createCommonUser(name));
		CommonSystem.getInstance().setPlayers(players);
		
	}
	
	private UserModel createComputer() {
		UserModel user = new UserModel();
		user.setComputer(true);
		user.setId(-1);
		user.setName("Android");
		user.setPoint(CommonSystem.NUMBER_CARDS_PLAYER);
		
		return user;
	}
	
	private UserModel createCommonUser(String name) {
		UserModel user = new UserModel();
		user.setComputer(false);
		user.setName(name);
		user.setId(1);
		user.setPoint(CommonSystem.NUMBER_CARDS_PLAYER);
		
		return user;
	}
}
