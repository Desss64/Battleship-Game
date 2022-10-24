import javax.swing.JButton;

/**
 * 
 * Square class
 *
 */
public class Square {

	private int x,y;
	private Boolean squareStatus = true;
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public Boolean getSquareStatus() {
		return squareStatus;
	}
	public void setSquareStatus(Boolean squareStatus) {
		this.squareStatus = squareStatus;
	}
	
	public Square() {
		
	}
	
	public Square(int xDimension, int yDimension, Boolean status) {
		x=xDimension;
		y=yDimension;
		squareStatus = status;
	}
	
	public char getCharacter(Square s1) {
		if (s1.getSquareStatus() == false) {
			return 'X';
		}
		return 'O';
		
	}
}
