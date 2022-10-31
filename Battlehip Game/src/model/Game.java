package model;

import java.util.Scanner;

//Game Class
public class Game {
	// public Board[] playerBoards;
	private String title = "Battleship";
	private String menuText = "Enter 1 to play or 0 for rules";
	private Scanner sc = new Scanner(System.in);
	private int response;
	private int score;
	private String playerName;
	private int x;
	private int y;
	private String hitStatus;

	public void gameLoop() {

		// display game menu
		menu();

		// read in response to menu prompt
		response = sc.nextInt();
		validateResponse(response);
		sc.nextLine();

		// create player
		System.out.print("\nEnter a player name: ");
		playerName = sc.nextLine();
		Player p1 = new Player(playerName);
		Player p2 = new Player("Sam");

		// randomly place ships
		p1.placeAllShips();
		p2.placeAllShips();

		while (true) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < p1.getShipList(i).getShipSize(); j++) {
					System.out.println(p1.getShipList(i).shipLocation[j].getSquarePosition());
				}
				System.out.println();
			}

			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < p2.getShipList(i).getShipSize(); j++) {
					System.out.println(p2.getShipList(i).shipLocation[j].getSquarePosition());
				}
				System.out.println();
			}

			// fire shot
			System.out.println("Coordinate pair to fire shot (x, y)");
			System.out.print("Enter x: ");
			x = sc.nextInt();
			System.out.print("Enter y: ");
			y = sc.nextInt();
			System.out.println();

			p1.playTurn(x, y);
			getHitStatus(p1, p2, x, y);
			p2.playTurn(0, 0);
			getHitStatus(p2, p1, 0, 0);

			// check winning condition (all opponent ships sunk)
			if (p1.getNumberOfShipsLeft() == 0) {
				System.out.println(p1.getName() + " won!");
				p1.setWinCount(p1.getWinCount() + 1);

			} else if (p2.getNumberOfShipsLeft() == 0) {
				System.out.println(p2.getName() + " won!");
				p2.setWinCount(p2.getWinCount() + 1);
			}

			System.out.println();

			// display stats for each player
			midGameStats(p1);
			midGameStats(p2);
		}
	}

	// displays main menu
	public void menu() {
		int cols = 45; // cols of menu box
		int rows = 9; // rows of menu box
		int charIndex = 0; // index to loop through menu string

		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= cols; j++) {
				if (i == 1 || i == rows || j == 1 || j == cols)
					System.out.print("+");
				else if (i == 3 && j >= 18 && j < 18 + title.length()) {
					System.out.print(title.charAt(charIndex));
					charIndex++;
				} else if (i == 6 && j >= 8 && j < 8 + menuText.length()) {
					System.out.print(menuText.charAt(charIndex));
					charIndex++;
				} else {
					charIndex = 0;
					System.out.print(" ");
				}

			}
			System.out.println();
		}
	}

	public int getScore() {
		return score;
	}

	public void setScore(Player p1) {
		score = p1.getNumberOfShipsLeft();
	}

	/**
	 * Validates user's response to prompt in game menu
	 * 
	 * @param response
	 */
	public void validateResponse(int response) {
		do {
			if (response != 0 && response != 1) {
				System.out.println("Invalid input. Please enter 0 or 1: ");
				response = sc.nextInt();
			}
		} while (response != 0 && response != 1);
	}

	public void getHitStatus(Player playerShooting, Player playerShot, int x, int y) {
		// check if player's shot hit opponent ship
		if (playerShot.checkIsHit(playerShooting.shoot(x, y)))
			hitStatus = "hit";
		else
			hitStatus = "missed";

		// display coordinate and whether opponent ship was hit
		System.out.println(playerShooting.getName() + " " + hitStatus + " (" + x + ", " + y + ")");
	}

	public void midGameStats(Player p) {
		// player name
		System.out.println(p.getName());
		
		// number of ships left
		for (int i = 0; i < 5; i++) {
			if (p.getShipList(i).isDestroyed())
				p.setNumberOfShipsLeft(p.getNumberOfShipsLeft() - 1);
		}

		System.out.println("Ships Left: " + p.getNumberOfShipsLeft());
		System.out.println();
	}

	public void endGameStats(Player p) {
		// number of shots fired
		System.out.println("Fires: " + p.getFires());

		// number of misses
		System.out.println("Misses: " + p.getMisses());

		// number of wins
		System.out.println("Wins: " + p.getWinCount());
	}

}
