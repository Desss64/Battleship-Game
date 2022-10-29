package model;
//Opponents Board Class

public class OpponentsBoard extends Board {

	public OpponentsBoard() {
		int size = getSize();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				boardArray[i][j] = new Square(i, j);
			}
		}
	}
}
