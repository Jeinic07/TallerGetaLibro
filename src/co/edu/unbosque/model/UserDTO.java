package co.edu.unbosque.model;

import co.edu.unbosque.util.MyLinkedList;

public class UserDTO {
	private String username;
	private String password;
	private MyLinkedList<UserDTO> friendList;
	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserDTO(String username, String password, MyLinkedList<UserDTO> friendList) {
		super();
		this.username = username;
		this.password = password;
		this.friendList = friendList;
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
