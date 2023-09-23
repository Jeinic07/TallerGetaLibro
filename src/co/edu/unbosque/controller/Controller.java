package co.edu.unbosque.controller;
import co.edu.unbosque.view.View;

public class Controller {

	
	private View vi;

	public Controller() {


		start();
	}

	public void start() {
		try {

			while (true) {
				

				int opcion = vi.readInt();
 
				vi.printJump("Welcome to CARELIBRO");
				switch (opcion) {
				case 1:
				
					break;
				case 2:
					
					
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
