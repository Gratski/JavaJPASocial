package system;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import business.AddFriendshipHandler;
import business.AddUserHandler;
import business.FriendshipsCatalog;
import business.GetUsersHandler;
import business.UsersCatalog;
import presentation.FriendshipService;
import presentation.UserService;

/**
 * This class represents a simple social system
 * 
 * @author JoaoR
 *
 */
public class SocialSystem {

	/**
	 * users service methods interface
	 */
	private UserService userService;
	
	/**
	 * friendships service methods interface
	 */
	private FriendshipService friendshipService;
	
	/**
	 * Constructor
	 * Initializes the two needed services
	 */
	public SocialSystem(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyJPAProject");
		UsersCatalog usersCatalog = new UsersCatalog(emf);
		this.userService = 
				new UserService(new GetUsersHandler(usersCatalog), new AddUserHandler(usersCatalog));
		this.friendshipService = 
				new FriendshipService(new AddFriendshipHandler(new FriendshipsCatalog(usersCatalog, emf)));
	}
	
	/**
	 * Get user service
	 * 
	 * @return the user service in use
	 */
	public UserService getUserService(){
		return this.userService;
	}
	
	/**
	 * Get friendships service
	 * 
	 * @return the friendships service in use
	 */
	public FriendshipService getFriendshipService(){
		return this.friendshipService;
	}
	
}
