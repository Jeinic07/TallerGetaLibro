package co.edu.unbosque.controller;
import co.edu.unbosque.persistence.UserDAO;
import co.edu.unbosque.model.UserDTO;
import co.edu.unbosque.util.Graph;
import co.edu.unbosque.util.MyLinkedList;
import co.edu.unbosque.util.Vertex;
import co.edu.unbosque.view.View;

public class Controller {

	
	private View vi;
	private UserDAO uDAO;

	public Controller() {
		uDAO = new UserDAO();

		start();
	}

	public void start() {
		Graph g1 = new Graph();
		MyLinkedList<Vertex<UserDTO>> vertexList = new MyLinkedList<>();
		try {

			while (true) {
				

				int opcion = vi.readInt();
 
				vi.printJump("\t Welcome to CARELIBRO \n \t What do you wish to do? \n 1) "
						+ "Add an user. \n 2). Add friends to an user \n 3). Calculate friendship grade between users. "
						+ "\n 4). Check disconnected users. \n 5). Check if users have an indirect or direct relationship.");
				switch (opcion) {
				case 1: 
					vi.printJump("Add a user: \n Please, type an username.");
					String username = vi.readAllLine();
					vi.printJump("Type a password.");
					String password = vi.readAllLine();
					uDAO.createUser(new UserDTO(username, password, null));
					vi.printJump("The user has been created.");
					 vertexList.add(new Vertex<UserDTO>(new UserDTO(username, password, null)));

				
					break;
				case 2:
					vi.printJump("Add friends to an user: \n Please, type the username you wish to add a friend to.");
					String firstName = vi.readAllLine();
					vi.printJump("Type the username which will be " +  firstName + "'s friend");
					String secondName = vi.readAllLine();
					uDAO.addFriend(firstName, secondName);
					
					
					break;
				case 3:
				
					break;
				default:
					vi.printJump("Gracias por utilizar este programa");
					System.exit(0);
					break;
				}
			}
		} catch (Exception e) {
			vi.printJump("jaja");
		}
	}

}
