package model;
//Ship Class

public class Ship{

	private String shipName;
	private int shipSize;
	private Boolean isVertical = false;
	private int intactParts;
	public Square[] shipLocation = new Square[5];
	private String shipSymbol;
	
	public void setShipSymbol(String shipSymbol) {
		this.shipSymbol = shipSymbol;
	}
	
	public String getShipSymbol() {
		return shipSymbol;
	}

	public String getShipName() {
		return shipName;
	}

	public void setShipName(String name) {
		shipName = name;

	}

	public void setShipSize(int size) {
		shipSize = size;

	}

	public int getShipSize() {
		return shipSize;
	}

	public Boolean getIsVertical() {
		return isVertical;
	}

	public void setIsVertical(Boolean isVertical) {
		this.isVertical = isVertical;
	}

	public int getIntactParts() {
		return intactParts;
	}

	public void setIntactParts(int intactParts) {
		this.intactParts = intactParts;
	}

	/*
	 * public void buildShipLocation() { for (int i = 0;i<getShipSize();i++) {
	 * shipLocation[i] = new Square(); } }
	 */

	public Boolean isOutOfBounds() {
		for (int i = 0; i < shipSize; i++) {
			if (shipLocation[i].getX() > 7 || shipLocation[i].getY() > 7) {
				return true;
			} else if (shipLocation[i].getX() < 0 || shipLocation[i].getY() < 0) {
				return true;
			}
		}
		return false;
	}

	public Boolean isOverlap(Ship ship1) {
		for (int i = 0; i < getShipSize(); i++)
			for (int j = 0; j < ship1.getShipSize(); j++) {
				if (shipLocation[i].equals(ship1.shipLocation[j])) {
					return true;
				}
			}

		return false;

	}

	public void placeShip(int x, int y, Player p, Ship ship) {
		for (int i = 0; i < ship.getShipSize(); i++) {
			if (ship.getIsVertical() == true && y + getShipSize() < 9) {
				shipLocation[i].setX(x);
				shipLocation[i].setY(y + i);
				p.placementBoard.gameBoard[x][y+i] = ship.getShipSymbol();
			} else if(ship.getIsVertical() == false && x + ship.getShipSize() < 9){
				shipLocation[i].setX(x + i);
				shipLocation[i].setY(y);
				p.placementBoard.gameBoard[x+i][y] =ship. getShipSymbol();
			}
		}
	}

	public Boolean isHit(int x, int y, Ship ship, Player p) {
		for (int i = 0; i < ship.shipSize; i++) {
			// check if cell on board has char in it
			if (p.placementBoard.gameBoard[x][y] != "-") {
				ship.shipLocation[i].setSquareStatus(false);
				setIntactParts(ship.getIntactParts() - 1);
				// set contents to 'x'
				p.placementBoard.gameBoard[x][y] = "X";
				return true;
			}
		}
		return false;
		
		/*for (int i = 0; i < ship.shipSize; i++) {
			if (ship.shipLocation[i].getSquarePosition().equals(x + ", " + y)) {
				ship.shipLocation[i].setSquareStatus(false);
				setIntactParts(getIntactParts() - 1);
				return true;
			}
		}
		return false;*/
	}

	public Boolean isDestroyed() {
		if (getIntactParts() == 0)
			return true;
		return false;
	}

}
