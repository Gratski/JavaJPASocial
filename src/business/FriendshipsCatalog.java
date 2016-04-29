package business;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import domain.Friendship;
import domain.User;

/**
 * This class represents a Friendships Catalog
 * It follow the Catalog Pattern
 * 
 * @author JoaoR
 *
 */
public class FriendshipsCatalog {

	/**
	 * Users Catalog is present just for convenience
	 */
	private UsersCatalog usersCatalog;
	
	/**
	 * Used to manipulated persisted data
	 */
	private EntityManagerFactory emf;
	
	/**
	 * Constructor
	 * 
	 * @param usersCatalog, users catalog
	 * @param emf, entity manager factory
	 */
	public FriendshipsCatalog(UsersCatalog usersCatalog, EntityManagerFactory emf){
		this.usersCatalog = usersCatalog;
		this.emf = emf;
	}
	
	/**
	 * Add a new frienship between two users
	 * 
	 * @param u1, user who sent the request
	 * @param u2, user who request has been sent to
	 */
	public void addFrienship(User u1, User u2){
	
		EntityManager em = this.emf.createEntityManager();
		try{
			
			em.getTransaction().begin();
			
			// add the new friendship
			Friendship fs = new Friendship(u1, u2);
			em.persist(fs);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			// rollback if needed
			if(em.getTransaction().isActive())
				em.getTransaction().rollback();
		} finally {
			em.close();
		}
		
	}
	
}
