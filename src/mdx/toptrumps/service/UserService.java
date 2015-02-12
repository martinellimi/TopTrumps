/**
 * TopTrumps - mdx.toptrumps.disney.service
 */
package mdx.toptrumps.service;

import java.util.List;

import mdx.toptrumps.model.UserModel;

/**
 * @author martinellimi
 * 
 * Description: UserService.java 
 * This interface contains methods to manipulate <code>UserModel</code> objects. 
 * 
 * @version version 1.0 27 Jan 2015
 */
public interface UserService {

	
	/**
	 * Description: setWinner
	 * Set the points for the winner and takes loser's points.
	 * 
	 * @param UserModel user
	 * @return void
	 */
	public void setWinner(UserModel user);
	
	
	/**
	 * Description: createUser
	 * Creates the user with the name received as a parameter.
	 * 
	 * @param 
	 * @return void
	 */
	public void createUser(String name);
}
