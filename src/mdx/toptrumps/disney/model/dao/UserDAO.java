/**
 * 
 */
package mdx.toptrumps.disney.model.dao;

import java.util.List;

import mdx.toptrumps.disney.model.UserModel;

/**
 * @author martinellimi
 * @description UserDAO.java This is the interface for the userDAO
 * @version version 1.0 27 Jan 2015
 */
public interface UserDAO {
	
	/**
	 * @description getUsers - this method gets the users in the game
	 * @return List<UserModel>
	 */
	public List<UserModel> getUsers();
	
	/**
	 * @description getUserById - this method get specific user by his id
	 * @param Integer id
	 * @return UserModel
	 */
	public UserModel getUserById(Integer id);
	
	/**
	 * @description getUserPoints - this method gets the user points, selecting the user by 
	 * his id
	 * @param Integer id
	 * @return Integer
	 */
	public Integer getUserPoints(Integer id);
	
}
