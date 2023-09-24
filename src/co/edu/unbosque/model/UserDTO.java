package co.edu.unbosque.model;

import co.edu.unbosque.util.MyLinkedList;

public class UserDTO {
	private int id;
	private String username;
	private String password;
	private MyLinkedList<UserDTO> listOfFriends;
	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserDTO(int id,String username, String password, MyLinkedList<UserDTO> friendList) {

	public UserDTO(String username, String password, MyLinkedList<UserDTO> listOfFriends) {

		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.listOfFriends = listOfFriends;
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

	public MyLinkedList<UserDTO> getlistOfFriends() {
		return listOfFriends;
	}

	public void setlistOfFriends(MyLinkedList<UserDTO> listOfFriends) {
		this.listOfFriends = listOfFriends;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ID: " + id);
		sb.append("\nUsername: " + username);
		sb.append("\nPassword: " + password);
		sb.append("\nList of friends: \n" + listOfFriends.toString());
		return sb.toString();
	}
	
}
