package startup;

import java.util.List;

import business.ApplicationException;
import domain.Friendship;
import domain.User;
import presentation.FriendshipService;
import presentation.UserService;
import system.SocialSystem;

/**
 * This class represents a simple usage of a JPA implementation
 * In this example i've used EclipseLink
 * 
 * @author JoaoR
 *
 */
public class ClientExample {

	
	public static void main(String[]args){
		
		SocialSystem system = new SocialSystem();
		UserService us = system.getUserService();
		FriendshipService fs = system.getFriendshipService();
		
		try{			
			// add new user
			int userId = us.addNewUser("John", "rodrigues.at.work@gmail.com", "password!");
			int friendId = us.addNewUser("Simao Neves", "simaocostaneves@gmail.com", "mypassword");
			
			System.out.println("My id: " + userId);
			System.out.println("Jamas id: " + friendId);
			
			// obtain after insert user
			User me = us.getUserById(userId);
			if(me != null)
				System.out.println("Username: " + me.getName());
			
			User friend = us.getUserById(friendId);
			if(friend != null)
				System.out.println("Friendname: " + friend.getName());
			
			// establish friendship
			fs.addFriend(me, friend);
			
			// otain friends i added
			me = us.getUserById(userId);
			List<Friendship> friends = me.getFriendsIAdded();
			for(Friendship f : friends)
				System.out.println("FRIENDED: " + f.getWasAdded().getName());
			
		} catch (ApplicationException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
