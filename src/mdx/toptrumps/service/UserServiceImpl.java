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
import mdx.toptrumps.model.dao.UserDAO;
import mdx.toptrumps.model.dao.UserDAOImpl;

/**
 * @author martinellimi
 * 
 * Description: UserServiceImpl.java 
 * Implements the UserService interface and it is used to implement actions 
 * that manipulates UserModel object. 
 * 
 * @version version 1.0 27 Jan 2015
 */
public class UserServiceImpl implements UserService {

	
	private UserDAO userDAO = new UserDAOImpl();
	
	/**
	 * Description: setWinner
	 * Gets the winner, take out the loser card and give it to the winner. Get the first card from the winner and 
	 * add it to the end of the linked list and also add in the end, the card from the loser.
	 * Sets the players points according to how many cards the player has.
	 * 
	 * @param UserModel user
	 * @return void
	 */
	public void setWinner(UserModel user) {
		CardAnimalModel card1 = new CardAnimalModel();
		CardAnimalModel card2 = new CardAnimalModel();
		
		card1 = CommonSystem.getInstance().getPlayer1().getValue().get(0);
		CommonSystem.getInstance().getPlayer1().getValue().removeFirst();
		
		card2 = CommonSystem.getInstance().getComputer().getValue().get(0);
		CommonSystem.getInstance().getComputer().getValue().removeFirst();
		
		if(!(CommonSystem.getInstance().getDraw().size() == 0 && !CommonSystem.getInstance().isGameDraw())) {
			if(user.isComputer()) {
				CommonSystem.getInstance().getComputer().getValue().addAll(CommonSystem.getInstance().getComputer().getValue().size(), CommonSystem.getInstance().getDraw());
			} else if(user.getId() == 1) {
				CommonSystem.getInstance().getPlayer1().getValue().addAll(CommonSystem.getInstance().getPlayer1().getValue().size(), CommonSystem.getInstance().getDraw());
			}
			CommonSystem.getInstance().getDraw().clear();
		}
		
		if(!CommonSystem.getInstance().isGameDraw()) {
			if(user.isComputer()) {
				CommonSystem.getInstance().getComputer().getValue().addLast(card1);
				CommonSystem.getInstance().getComputer().getValue().addLast(card2);
			} else {
				CommonSystem.getInstance().getPlayer1().getValue().addLast(card1);
				CommonSystem.getInstance().getPlayer1().getValue().addLast(card2);
			}
		} else {
			CommonSystem.getInstance().getDraw().add(card2);
			CommonSystem.getInstance().getDraw().add(card1);
		}
		
		CommonSystem.getInstance().getPlayer1().getKey().setPoint(CommonSystem.getInstance().getPlayer1().getValue().size());
		CommonSystem.getInstance().getComputer().getKey().setPoint(CommonSystem.getInstance().getComputer().getValue().size());
	}

	/**
	 * Description: createUser
	 * Creates the user with the name received as a parameter.
	 * 
	 * @param 
	 * @return void
	 * @see UserService#createUser(String)
	 * TODO: Implement this method
	 */
	public void createUser(String name) {
		userDAO.createUser(name);
	}
}
