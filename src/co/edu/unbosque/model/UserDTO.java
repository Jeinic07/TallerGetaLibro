package co.edu.unbosque.model;

import co.edu.unbosque.util.MyLinkedList;

public class UserDTO {
	private int id;
	private String username;
	private String password;
	private MyLinkedList<UserDTO> friendList;
	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserDTO(int id,String username, String password, MyLinkedList<UserDTO> friendList) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.friendList = friendList;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public MyLinkedList<UserDTO> getFriendList() {
		return friendList;
	}

	public void setFriendList(MyLinkedList<UserDTO> friendList) {
		this.friendList = friendList;
	}
}
