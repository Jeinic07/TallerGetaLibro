package co.edu.unbosque.persistence;

import co.edu.unbosque.model.UserDTO;
import co.edu.unbosque.util.MyLinkedList;

public class UserDAO {
	private MyLinkedList<UserDTO> listUsers;
	private MyLinkedList<UserDTO> listFriends;
	 
	
	public UserDAO() {
		listUsers = new MyLinkedList<UserDTO>();
		listFriends = new MyLinkedList<UserDTO>();
	}

	public UserDAO(MyLinkedList<UserDTO> listUsers, MyLinkedList<UserDTO> listFriends) {
		super();
		this.listUsers = listUsers;
		this.listFriends = listFriends;
	}
	
	public void createUser(String ...args) {
		listUsers.add(new UserDTO(Integer.parseInt(args[0]), args[1],  args[2], null));
		//q se cree con amigos vacios pq luego se van a añadir en otra funcion??
	}
	
	public void addFriend(String searchName, String searchFriendName){
		for(int i = 0; i < listUsers.size(); i++) {
			if(listUsers.get(i).getInfo().getUsername().equals(searchName)) {
				System.out.println("User found, what friend do you want to add to this user?");
				for(int  j= 0; j < listUsers.size(); j++) {
					if(listUsers.get(j).getInfo().getUsername().equals(searchFriendName)) {
						UserDTO friend = listUsers.get(j).getInfo();
						listUsers.get(i).getInfo().getFriendList().add(friend);;
						
					}	
				}
			}
		}
			
		
		
	}
	
	
	

}
