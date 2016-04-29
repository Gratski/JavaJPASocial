package business;

import domain.User;
import presentation.FriendshipService;

/**
 * This class represents a add friend event handler
 * 
 * @author JoaoR
 *
 */
public class AddFriendshipHandler {

	/**
	 * friendships catalog in use
	 */
	private FriendshipsCatalog friendshipsCatalog;
	
	/**
	 * Constructor
	 * 
	 * @param fsc, friendships catalog to be used
	 */
	public AddFriendshipHandler(FriendshipsCatalog fsc){
		this.friendshipsCatalog = fsc;
	}
	
	/**
	 * Adds a new friendship between two users
	 * 
	 * @param user1, friendship request sender
	 * @param user2, friendship request receiver
	 */
	public void addFriendship(User user1, User user2){
		this.friendshipsCatalog.addFrienship(user1, user2);
	}
}
