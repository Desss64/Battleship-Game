package model;

import java.util.Scanner;

import javax.swing.JFrame;

import controller.Client;
import controller.Server;

public class GameDriver {

	public static void main(String[] args) {
		String role;
		Scanner in = new Scanner(System.in);             
		System.out.println("Select a role for connection: ");
		System.out.println("1.Server ");
		System.out.println("2.Client ");
		role = in.nextLine(); 
		
		if (role.equals("2")) {
			String ip;           
			Client application; // declare client application
			System.out.print("Enter the ip of your opponent, or Local to use only one machine: ");
			ip = in.next(); 
			   if ( ip.equals("Local"))
			      application = new Client( "127.0.0.1" ); // connect to localhost
			   else
			      application = new Client( ip ); 

			   application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
			   application.runClient(); // run client application
			Game game = new Game();
			game.gameLoop();
		}else if(role.equals("1")) {
			 Server application = new Server(); // create server
			   application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
			   application.runServer(); // run server application
			   Game game = new Game();
				game.gameLoop();
		} else {            
			System.out.println("Please make a valid selection for role: ");
			System.out.println("1.Server ");
			System.out.println("2.Client ");
			role = in.next();
			in.close(); 
		}
		

		/*Player p1 = new Player("Bryan");
		Player p2 = new Player("Sam");
		p1.placeAllShips();
		p2.getShipList(0).placeShip(0, 0);
		p1.playTurn(0, 0, p2);
		p2.playTurn(0, 0, p1);*/
		// System.out.println(p2.placementBoard.boardArray[0][0].getSquareStatus());

	}

}
