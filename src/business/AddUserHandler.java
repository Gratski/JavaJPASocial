package business;

/**
 * This class represents a add user handler
 * It is called every time a new user is added
 * 
 * @author JoaoR
 *
 */
public class AddUserHandler {

	/**
	 * users catalog in use
	 */
	private UsersCatalog usersCatalog;
	
	/**
	 * Constructor
	 * 
	 * @param usersCatalog, users catalog to be used
	 */
	public AddUserHandler(UsersCatalog usersCatalog){
		this.usersCatalog = usersCatalog;
	}
	
	/**
	 * Adds a new user to the system
	 * 
	 * @param name, user name
	 * @param email, user email
	 * @param password, user password
	 * @return the created user'd id
	 * @throws ApplicationException
	 */
	public int addUser(String name, String email, String password) throws ApplicationException{
		return this.usersCatalog.addNewUser(name, email, password);
	}
	
}
