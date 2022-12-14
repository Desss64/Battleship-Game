package model;
//Square Class

public class Square {
	private int x, y;
	private Boolean squareStatus = true;
	// private Boolean isOccupied = false;

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

	/*
	 * public Boolean getIsOccupied() { return isOccupied; } public void
	 * setIsOccupied(Boolean isoccupied) { this.isOccupied = isoccupied; }
	 */

	public Square() {

	}

	public Square(int xDimension, int yDimension) {
		x = xDimension;
		y = yDimension;
		squareStatus = true;
	}

	public char getCharacter(Square s1) {
		if (s1.getSquareStatus() == false) {
			return 'X';
		}
		return 'O';

	}

	public String getSquarePosition() {
		return getX() + ", " + getY();
	}

	public Boolean equals(Square s2) {
		if (this.getX() == s2.getX() && this.getY() == s2.getY()) {
			return true;
		}
		return false;
	}

}
