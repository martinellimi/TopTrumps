/**
 * 
 */
package mdx.toptrumps.disney.model;

/**
 * @author martinellimi
 * @description UserModel.java - This class represents the User.
 * @version version 1.0 27 Jan 2015
 */
public class UserModel {

	
	/** @description User Id */
	private Integer id;
	
	/** @description User name */
	private String name;
	
	/** @description User points in the game */
	private Integer point;
	
	/** @description this attribute refers if the player is the computer or not */
	private Boolean computer;
	
	// Getters and setters

	/** @return the user id */
	public Integer getId() {
		return id;
	}

	/** @param id the id to set */
	public void setId(Integer id) {
		this.id = id;
	}

	/** @return the user name */
	public String getName() {
		return name;
	}

	/** @param name the name to set */
	public void setName(String name) {
		this.name = name;
	}

	/** @return the user point */
	public Integer getPoint() {
		return point;
	}

	/** @param point the point to set */
	public void setPoint(Integer point) {
		this.point = point;
	}

	/** @return if the user is the computer */
	public Boolean isComputer() {
		return computer;
	}

	/** @param computer the computer to set */
	public void setComputer(Boolean computer) {
		this.computer = computer;
	}
	
	
	
}
