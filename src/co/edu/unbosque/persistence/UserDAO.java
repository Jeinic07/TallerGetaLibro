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

	public void createUser(Object o) {
		listOfUsers.add((UserDTO) o);
	}
	
	public String readUser() {
		StringBuilder sb = new StringBuilder();
		sb.append("These are the users on list:");
		for(int i = 0; i<listOfUsers.size(); i++) {
			sb.append(listOfUsers.get(i).toString() + "\n");
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
	
	

}
