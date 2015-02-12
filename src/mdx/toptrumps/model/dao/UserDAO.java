/**
 * 
 */
package mdx.toptrumps.model.dao;

import java.util.List;

import mdx.toptrumps.model.UserModel;

/**
 * @author martinellimi
 * Description: UserDAO.java This is the interface for the userDAO
 * @version version 1.0 27 Jan 2015
 */
public interface UserDAO {
	
	/**
	 * Description: createUser
	 * Creates the user, receiving the name.
	 * 
	 * @param String name
	 * @return Integer
	 */
	public void createUser(String name);
}
