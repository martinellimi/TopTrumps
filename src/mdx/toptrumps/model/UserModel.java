/**
 * 
 */
package mdx.toptrumps.model;

/**
 * @author martinellimi
 * Description: UserModel.java
 * This class represents the User.
 * 
 * @version version 1.0 27 Jan 2015
 */
public class UserModel {

	
	/** Description: User Id */
	private Integer id;
	
	/** Description: User name */
	private String name;
	
	/** Description: User points in the game */
	private Integer point;
	
	/** Description: this attribute refers if the player is the computer or not */
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserModel other = (UserModel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
