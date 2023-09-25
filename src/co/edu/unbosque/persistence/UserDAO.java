package co.edu.unbosque.persistence;

import co.edu.unbosque.model.UserDTO;
import co.edu.unbosque.util.MyLinkedList;

public class UserDAO {

	private MyLinkedList<UserDTO> listOfUsers;

	public UserDAO() {
		listOfUsers = new MyLinkedList<UserDTO>();
	}

	public UserDAO(MyLinkedList<UserDTO> listOfUsers) {
		super();
		this.listOfUsers = listOfUsers;
	}

	public MyLinkedList<UserDTO> getListOfUsers() {
		return listOfUsers;
	}

	public void setListOfUsers(MyLinkedList<UserDTO> listOfUsers) {
		this.listOfUsers = listOfUsers;
	}

	public void createUser(UserDTO user) {
		listOfUsers.add(user);
	}

	public String readUser() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < listOfUsers.size(); i++) {
			sb.append(listOfUsers.get(i) + "\n");
		}
		return sb.toString();
	}

	public boolean updateUser(int i, Object o) {
		try {
			listOfUsers.set(i, (UserDTO) o);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public int deleteUser(int i) {
		try {
			listOfUsers.remove(i);
			return 0;
		} catch (IndexOutOfBoundsException e) {
			return -1;
		}
	}

	public void addFriend(String searchName, String searchFriendName, boolean isPossible) {
		UserDTO friend = new UserDTO();
		UserDTO user = new UserDTO();
		
		for(int i = 0; i<listOfUsers.size(); i++) {
			if(listOfUsers.get(i).getInfo().getUsername().equals(searchName)) {
				user = listOfUsers.get(i).getInfo();
				break;
			}
		}
		
		for(int i = 0; i<listOfUsers.size(); i++) {
			if(listOfUsers.get(i).getInfo().getUsername().equals(searchFriendName)) {
				friend = listOfUsers.get(i).getInfo();
				break;
			}
		}

		if(isPossible) {
			user.getlistOfFriends().add(friend);
			friend.getlistOfFriends().add(user);
		}
		
	}
}
