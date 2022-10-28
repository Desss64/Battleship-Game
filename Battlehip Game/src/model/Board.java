package model;
//Board Class

public class Board {
	final private int size = 8;
	public Square[][] boardArray = new Square[size][size];

	public int getSize() {
		return size;
	}

	public Board() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				boardArray[i][j] = new Square(i, j, true);
			}
		}
	}

}
