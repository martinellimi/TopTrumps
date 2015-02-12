/**
 * 
 */
package mdx.toptrumps.model.dao;

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
 * Description: UserDAOImpl.java - This class implements the User interface and implements
 * the methods to manipulate the user model Object
 * 
 * @version version 1.0 27 Jan 2015
 */
public class UserDAOImpl implements UserDAO {

	
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
