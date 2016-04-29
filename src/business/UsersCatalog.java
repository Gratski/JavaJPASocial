package business;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import domain.User;

/**
 * This class represents a users catalog
 * It follows the Catalog Pattern
 * It is responsible for system users management
 * 
 * @author JoaoR
 *
 */
public class UsersCatalog {

	/**
	 * Entity manager factory
	 */
	private EntityManagerFactory emf;
	
	/**
	 * Constructor
	 * 
	 * @param emf 	EntityManagerFactory to be used
	 * 				when accessing data 
	 */
	public UsersCatalog(EntityManagerFactory emf){
		this.emf = emf;
	}
	
	/**
	 * Gets all users present in database
	 * 
	 * @return
	 */
	public List<User> getAll(){
			EntityManager em = emf.createEntityManager();
			TypedQuery<User> query = em.createNamedQuery(User.GET_ALL_USERS, User.class);
			return query.getResultList();			
	}
	
	/**
	 * Adds a new user to the system
	 * 
	 * @param name, user name to be added
	 * @param email, user email to be added
	 * @param password, user password to be added
	 * @throws ApplicationException
	 */
	public int addNewUser(String name, String email, String password)
			 throws ApplicationException{
		
		EntityManager em = this.emf.createEntityManager();
		try{			
			em.getTransaction().begin();
			
			User user = new User(name, email, password);
			em.persist(user);
			
			em.getTransaction().commit();
			
			// return the inserted user id
			return user.getId();
			
		} catch (Exception e) {
			if(em.getTransaction().isActive())
				em.getTransaction().rollback();
			throw new ApplicationException("Error inserting new user", e);
		} finally{
			em.close();
		}
		
	}

	/**
	 * Get a user given the parameter id from the database
	 * 
	 * @param id, id to be considered
	 * @return
	 * @throws ApplicationException
	 */
	public User getUserById(int id) throws ApplicationException{
		
		EntityManager em = this.emf.createEntityManager();
		try{
			// obtain user from database
			TypedQuery<User> query = em.createNamedQuery(User.GET_USER_BY_ID, User.class);
			query.setParameter(User.USER_ID, id);
			User user = query.getSingleResult();
			return user;
		} catch (Exception e) {
			throw new ApplicationException("", e);
		} finally {
			em.close();
		}
		
	}
}
