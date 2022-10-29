package model;
//Game Class.

public class Game {
	// public Board[] playerBoards;
	private int score;

	public void gameLoop() {
		
		// game menu (option to start or read rules)
		menu();

		/*
		 * Player p1 = new Player("Bryan"); Player p2 = new Player("Sam");
		 * 
		 * p1.placeAllShips(); p2.getShipList(0).placeShip(0, 0);
		 * 
		 * p1.playTurn(0, 0, p2); p2.playTurn(0, 0, p1);
		 */
	}

	public void menu() {
		int cols = 45;
		int rows = 9;
		int charIndex = 0;
		int ind = 0;

		String gameTitle = "Battleship";
		String selectText = "Enter 1 to play or 0 for rules";

		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= cols; j++) {
				if (i == 1 || i == rows || j == 1 || j == cols)
					System.out.print("+");
				else if (i == 3 && j >= 18 && j < 18 + gameTitle.length()) {
					System.out.print(gameTitle.charAt(charIndex));
					charIndex++;
				} 
				else if(i == 6 && j >= 8 && j < 8 + selectText.length()) {
					System.out.print(selectText.charAt(ind));
					ind++;
				}
				else {
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

}
