/**
 * TopTrumps - mdx.toptrumps.disney.service
 */
package mdx.toptrumps.disney.service;

import java.util.List;

import mdx.toptrumps.disney.model.UserModel;

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
		
	}

}
