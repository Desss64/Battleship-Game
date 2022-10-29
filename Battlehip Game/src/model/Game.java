package model;

import java.util.Scanner;

//Game Class

public class Game {
	// public Board[] playerBoards;
	private int[] score = new int[2];
	private String title = "Battleship";
	private String menuText = "Enter 1 to play or 0 for rules";
	private Scanner sc = new Scanner(System.in);
	private int response;

	public void gameLoop() {

		menu();

		// read in response from user
		response = sc.nextInt();
		validateResponse(response);

		Player p1 = new Player("Bryan");
		Player p2 = new Player("Sam");

		p1.placeAllShips();

		p2.getShipList(0).placeShip(0, 0);

		p1.playTurn(0, 0, p2);
		p2.playTurn(0, 0, p1);

	}

	// displays main menu
	public void menu() {
		int cols = 45;
		int rows = 9;
		int charIndex = 0;

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

	public int[] getScore() {
		return score;
	}

	public int getP1Score() {
		return score[0];
	}

	public int getP2Score() {
		return score[1];
	}

	public void setScore(Player p1, Player p2) {
		score[0] = p1.getNumberOfShipsLeft();
		score[1] = p2.getNumberOfShipsLeft();
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

}
