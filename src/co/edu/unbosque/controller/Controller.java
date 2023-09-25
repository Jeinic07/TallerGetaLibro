package co.edu.unbosque.controller;

import co.edu.unbosque.persistence.UserDAO;

import java.util.Iterator;

import co.edu.unbosque.model.UserDTO;
import co.edu.unbosque.util.Edge;
import co.edu.unbosque.util.Graph;
import co.edu.unbosque.util.MyLinkedList;
import co.edu.unbosque.util.Node;
import co.edu.unbosque.util.Vertex;
import co.edu.unbosque.util.algorithm.AbstractSearch;
import co.edu.unbosque.util.algorithm.DepthFirstSearch;
import co.edu.unbosque.view.View;

public class Controller {

	private View vi;
	private UserDAO uDAO;

	public Controller() {
		uDAO = new UserDAO();
		vi = new View();

		start();
	}

	private void start() {
		Graph g1 = new Graph();
		MyLinkedList<Vertex<UserDTO>> vertexList = new MyLinkedList<>();
		MyLinkedList<Edge> edgeList = new MyLinkedList<>();
		try {

			menu: while (true) {
				vi.printJump("\t Welcome to CARELIBRO \n \t What do you wish to do? \n 1) "
						+ "Add an user. \n 2). Add friends to an user \n 3). Calculate friendship grade between users. "
						+ "\n 4). Check disconnected users. \n 5). Check if users have an indirect or direct relationship.");
				int opcion = vi.readInt();
				switch (opcion) {
				case 1:
					vi.printJump("Add a user: \n Please, type the id:");
					int id = vi.readInt();
					vi.printJump("Type a username:");
					String username = vi.readLine();
					vi.printJump("Type a password.");
					String password = vi.readLine();
					UserDTO newUser = new UserDTO(id, username, password, new MyLinkedList<UserDTO>());
					uDAO.createUser(newUser);
					vi.printJump("The user has been created.");
					vertexList.add(new Vertex<UserDTO>(newUser));

					break;
				case 2:
					boolean isPossible = false;
					if (uDAO.getListOfUsers().size() <= 1) {
						vi.printJump("You need at least two users in the list to start connecting friends. \n");
						vi.printJump(uDAO.readUser());
						isPossible = false;
						continue menu;
					} else {
						vi.printJump(
								"Add friends to an user: \n Please, type the username you wish to add a friend to.");
						String firstName = vi.readLine();
						vi.printJump("Type the username which will be " + firstName + "'s friend");
						String secondName = vi.readLine();

						isPossible = true;

						uDAO.addFriend(firstName, secondName, isPossible);

						Vertex<UserDTO> sourceNode = null;
						for (int j = 0; j < vertexList.size(); j++) {
							if (vertexList.get(j).getInfo().getInfo().getUsername().equalsIgnoreCase(firstName)) {
								sourceNode = vertexList.get(j).getInfo();
								break;
							}
						}
						Vertex<UserDTO> destinationNode = null;
						for (int j = 0; j < vertexList.size(); j++) {
							if (vertexList.get(j).getInfo().getInfo().getUsername().equalsIgnoreCase(secondName)) {
								destinationNode = vertexList.get(j).getInfo();
								break;
							}
						}
						Edge edge = new Edge(sourceNode, destinationNode, 1);
						edgeList.add(edge);
						sourceNode.addEdge(edge);
						
						int indexUser = vertexList.indexOf(sourceNode);
						int indexFriend = vertexList.indexOf(destinationNode);
						

						Graph graph = new Graph();
						for (int i = 0; i < vertexList.size(); i++) {
							Node<Vertex<UserDTO>> vertexToAdd = vertexList.get(i);
							Vertex<UserDTO> vertexToAddToGraph = vertexToAdd.getInfo();
							graph.addVertex(vertexToAddToGraph);
						}

						System.out.println(uDAO.readUser());
						break;
					}
				case 3:

					vi.printJump("Type first username:");
					String user = vi.readLine();
					vi.printJump("Type the second user:");
					String friend = vi.readLine();

					Vertex<UserDTO> sourceNode = null;
					for (int j = 0; j < vertexList.size(); j++) {
						if (vertexList.get(j).getInfo().getInfo().getUsername().equalsIgnoreCase(user)) {
							sourceNode = vertexList.get(j).getInfo();
							break;
						}
					}
					Vertex<UserDTO> destinationNode = null;
					for (int j = 0; j < vertexList.size(); j++) {
						if (vertexList.get(j).getInfo().getInfo().getUsername().equalsIgnoreCase(friend)) {
							destinationNode = vertexList.get(j).getInfo();
							break;
						}
					}

					DepthFirstSearch dfs = new DepthFirstSearch(sourceNode, destinationNode);
					if (dfs.runSearch()) {
						vi.printJump("The friendship grade is: " + dfs.getDepth());
					} else {
						vi.printJump("There is no connection between " + sourceNode.getInfo().getUsername() + " and "
								+ destinationNode.getInfo().getUsername());
					}

					break;
				default:
					vi.printJump("Gracias por utilizar este programa");
					System.exit(0);
					break;
				}
			}
		} catch (Exception e) {

		}
	}

}