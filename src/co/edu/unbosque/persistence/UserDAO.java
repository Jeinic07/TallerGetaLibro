package co.edu.unbosque.persistence;

import co.edu.unbosque.model.UserDTO;
import co.edu.unbosque.util.MyLinkedList;

public class UserDAO {
	private MyLinkedList<UserDTO> listUsers;
	
	public UserDAO() {
		listUsers = new MyLinkedList<UserDTO>();
	}

	public UserDAO(MyLinkedList<UserDTO> listUsers) {
		super();
		this.listUsers = listUsers;
	}
	public void createUser() {
		
	}
	
	

}
