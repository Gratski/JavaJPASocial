package presentation;

import business.AddFriendshipHandler;
import domain.User;

/**
 * This class represents a friendships service
 * This is where all friendship events are called from
 * Represents a simple interface
 * 
 * @author JoaoR
 *
 */
public class FriendshipService {

	/**
	 * add friendship handler in use
	 */
	private AddFriendshipHandler addFriendshipHandler;
	
	/**
	 * Constructor
	 * 
	 * @param hfh, add frienship handler to be used
	 */
	public FriendshipService(AddFriendshipHandler hfh){
		this.addFriendshipHandler = hfh;
	}
	
	/**
	 * Adds a new friendship between two users
	 * 
	 * @param user1, friend request sender
	 * @param user2, friend request receiver
	 */
	public void addFriend(User user1, User user2){
		this.addFriendshipHandler.addFriendship(user1, user2);
	}
	
}
