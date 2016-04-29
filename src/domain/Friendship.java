package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * This class represents a friendship between two users
 * 
 * @author JoaoR
 *
 */
@Entity
public class Friendship {

	@Id @GeneratedValue
	private int id;
	
	@ManyToOne
	private User whoAdded;
	
	@ManyToOne
	private User wasAdded;
	
	/**
	 * Default constructor for JPA
	 */
	public Friendship(){}

	/**
	 * A more convenient constructor
	 * 
	 * @param whoAdded, the person who is requesting friendship
	 * @param wasAdded, the person who request has been sent to
	 */
	public Friendship(User whoAdded, User wasAdded){
		this.whoAdded = whoAdded;
		this.wasAdded = wasAdded;
	}
	
	// SETTERS
	public void setId(int id) {
		this.id = id;
	}

	public void setWhoAdded(User whoAdded) {
		this.whoAdded = whoAdded;
	}

	public void setWasAdded(User wasAdded) {
		this.wasAdded = wasAdded;
	}

	//GETTERS
	public int getId() {
		return id;
	}

	public User getWhoAdded() {
		return whoAdded;
	}

	public User getWasAdded() {
		return wasAdded;
	}
	
}
