/**
 * TopTrumps - mdx.toptrumps.disney.service
 */
package mdx.toptrumps.disney.service;

import java.util.List;

import mdx.toptrumps.disney.model.UserModel;

/**
 * @author martinellimi
 * 
 * @description UserService.java 
 * This interface contains methods to manipulate <code>UserModel</code> objects. 
 * 
 * @version version 1.0 27 Jan 2015
 */
public interface UserService {

	
	/**
	 * @description getUsers
	 * Returns all the game players.
	 * 
	 * @return List<UserModel>
	 */
	public List<UserModel> getUsers();
	
	
	/**
	 * @description getUserPoints
	 * Returns the points of the player that was received as parameter in the method.
	 * 
	 * @param UserModel user
	 * @return Integer
	 */
	public Integer getUserPoints(UserModel user);
	
	/**
	 * @description setWinner
	 * Set the points for the winner and takes loser's points.
	 * 
	 * @param UserModel user
	 * @return void
	 */
	public void setWinner(UserModel user);
	
	
	/**
	 * @description createUser
	 * Creates the user with the name received as a parameter.
	 * 
	 * @param 
	 * @return void
	 */
	public void createUser(String name);
}
