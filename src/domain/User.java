package domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * This class represents a User
 * 
 * @author JoaoR
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name=User.GET_ALL_USERS, query="select u from User u"),
	@NamedQuery(name=User.GET_USER_BY_ID, query="select u from User u where u.id = :" + User.USER_ID)
})
public class User {

	/**
	 * query names
	 */
	public static final String GET_ALL_USERS = "User.getAll";
	public static final String GET_USER_BY_ID = "User.getById";
	public static final String GET_USER_FRIENDS = "User.getFriends";
	
	/**
	 * query attributes
	 */
	public static final String CURRENT_USER = "User.currentUser";
	public static final String CURRENT_USER_FRIEND = "User.currentUserFriend";
	public static final String USER_ID = "Userid";
	
	@Id @GeneratedValue
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@OneToMany(mappedBy="owner")
	private List<Album> albums;
	
	@OneToMany(mappedBy="whoAdded")
	private List<Friendship> friendsIAdded;
	
	@OneToMany(mappedBy="wasAdded")
	private List<Friendship> friendsThatAddedMe;
	
	/**
	 * Default constructor to be used by JPA
	 */
	public User(){}
	
	/**
	 * User specific constructor
	 * 
	 * @param id, user id
	 * @param name, user name
	 * @param email, user email
	 * @param password, user password
	 */
	public User(String name, String email, String password){
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	// GETTERS
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public List<Album> getAlbums() {
		return albums;
	}
	
	public List<Friendship> getFriendsIAdded(){
		return this.friendsIAdded;
	}
	
	public List<Friendship> getFriendsThatAddedMe(){
		return this.friendsThatAddedMe;
	}

	// SETTERS
	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}
	
	public void setFriendsIAdded(List<Friendship> l){
		this.friendsIAdded = l; 
	}
	
	public void setFriendsThatAddedMe(List<Friendship> l){
		this.friendsThatAddedMe = l;
	}
	
}
