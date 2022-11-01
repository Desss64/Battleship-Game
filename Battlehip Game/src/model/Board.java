package model;
//Board Class

public class Board {
	final private int size = 8;
	public Square[][] boardArray = new Square[size][size];
	public String[][] gameBoard = new String[size][size];

	public int getSize() {
		return size;
	}

	public Board() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				boardArray[i][j] = new Square(i, j);
			}
		}
		createBoard(gameBoard);
	}

	/**
	 * Displays current state of board
	 */
	public void showBoard(String [][] gameBoard, String name) {
		
		System.out.println();
		System.out.println(name + "'s board");
		
		System.out.print(" ");

		// prints x coordinate labels
		for (int x = 0; x < size; x++)
			System.out.print("  " + x);
		System.out.println();

		for (int i = 0; i < size; i++) {
			// prints y coordinate labels
			System.out.print(i);
			for (int j = 0; j < size; j++) {
				System.out.print("  " + gameBoard[i][j]);
			}
			System.out.println();
		}
		
		System.out.println();
	}

	public void createBoard(String [][] gameBoard) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				gameBoard[i][j] = "-";
			}
		}
	}
}
