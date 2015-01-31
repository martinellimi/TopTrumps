/**
 * TopTrumps - mdx.toptrumps.disney.service
 */
package mdx.toptrumps.service;

import java.util.AbstractMap;
import java.util.ArrayList;
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
		Map.Entry<UserModel, List<CardAnimalModel>> computer = new AbstractMap.SimpleEntry<UserModel, List<CardAnimalModel>>(createComputer(), null);
		CommonSystem.getInstance().setComputer(computer);
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
