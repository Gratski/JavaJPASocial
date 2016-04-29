package business;

import java.util.List;

import domain.User;

/**
 * This class represents a get users handler
 * It is called everytime user wants to get users info
 * 
 * @author JoaoR
 *
 */
public class GetUsersHandler {

	/**
	 * users catalog in use
	 */
	private UsersCatalog usersCatalog;
	
	/**
	 * Constructor
	 * 
	 * @param usersCatalog, users catalog to be used
	 */
	public GetUsersHandler(UsersCatalog usersCatalog){
		this.usersCatalog = usersCatalog;
	}
	
	/**
	 * Gets all system users
	 * Not a good policy but as this is just a demo
	 * i decided to keep it this way :)
	 * 
	 * @return the system users list
	 */
	public List<User> getAllUsers(){
		return this.usersCatalog.getAll();
	}
	
	/**
	 * Gets a user by id
	 * 
	 * @param id, id number to be considered
	 * @return the user according to the given id number
	 * @throws ApplicationException
	 */
	public User getUserById(int id) throws ApplicationException{
		return this.usersCatalog.getUserById(id);
	}
	
}
