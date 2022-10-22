/**
 * 
 * Model for player's board
 *
 */
public class Board extends Square{

	final private int size = 8;
	public Square[][] boardArray;

	public int getSize() {
		return size;
	}
	
	public Board() {
		boardArray = new Square[size][size];
		
		for (int i=0; i<size;i++) {
			for (int j=0; j<size;j++) {
				boardArray[i][j] = new Square(i,j,true);
			}
		}
	}

}
