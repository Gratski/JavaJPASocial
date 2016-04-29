package presentation;

import java.util.List;

import business.AddUserHandler;
import business.ApplicationException;
import business.GetUsersHandler;
import domain.User;

/**
 * This class represents an interface to users related methods
 * It is a service
 * 
 * @author JoaoR
 *
 */
public class UserService {

	/**
	 * get users handler in use
	 */
	private GetUsersHandler getUsersHandler;
	
	/**
	 * add user handler in use
	 */
	private AddUserHandler addUserHandler;
	
	/**
	 * Constructor
	 * 
	 * @param getUsersHandler, get users handler to be used
	 * @param addUserHandler, add users handler to be used
	 */
	public UserService(GetUsersHandler getUsersHandler, AddUserHandler addUserHandler){
		this.getUsersHandler = getUsersHandler;
		this.addUserHandler = addUserHandler;
	}
	
	/**
	 * Gets all system users
	 * This is not a good policy but as this is just a demo
	 * i'll keep it this way :)
	 * 
	 * @return a list with all system users
	 */
	public List<User> getAllUsers(){
		return this.getUsersHandler.getAllUsers();
	}
	
	/**
	 * Gets a single user by id
	 * 
	 * @param id, id number to be considered
	 * @return the corresponding user
	 * @throws ApplicationException
	 */
	public User getUserById(int id) throws ApplicationException{
		return this.getUsersHandler.getUserById(id);
	}
	
	/**
	 * Adds a new user to the system
	 * 
	 * @param name, user name
	 * @param email, user email
	 * @param password, user password
	 * @return the inserted user id
	 * @throws ApplicationException
	 */
	public int addNewUser(String name, String email, String password) throws ApplicationException{
		return this.addUserHandler.addUser(name, email, password);
	}
	
}
