package model;
//Ship Class

public class Ship {
	
	private String shipName;
	private int shipSize;
	private Boolean isVertical = false;
	private int intactParts;
	public Square[] shipLocation = new Square[shipSize];
	
	
	
	
	public String getShipName() {
		return shipName;
	}
	
	public void setShipName(String name) {
		shipName=name;;
		
	}
	
	public void setShipSize(int size) {
		shipSize=size;
		
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
	
	public Boolean isOutOfBounds() {
		for (int i=0;i<shipSize;i++) {
			if(shipLocation[i].getX() > 7 || shipLocation[i].getY() > 7) {
				return true;
			}else if(shipLocation[i].getX() < 0 || shipLocation[i].getY()< 0) {
				return true;
			}
		}
		return false;
	}
	
	public Boolean isOverlap(Ship ship1) {
		for (int i=0;i<getShipSize();i++)
			for (int j=0;j<ship1.getShipSize();j++) {
				if (shipLocation[i].getX() == ship1.shipLocation[j].getX() && shipLocation[i].getY() == ship1.shipLocation[j].getY()) {
					return true;
				}
			}
			
		return false;
			
	}
	
	public void placeShip(int x, int y) {
		for (int i = 0; i<getShipSize(); i++) {
			if (getIsVertical()== true) {
				shipLocation[i].setX(x);
				shipLocation[i].setY(y+i);
			}else {
				shipLocation[i].setX(x+i);
				shipLocation[i].setY(y);
			}
			
			
		}
	}
	
	public void isHit(int x, int y) {
		for (int i=0;i<shipSize;i++) {
			if(shipLocation[i].getX() == x && shipLocation[i].getY() == y) {
				setIntactParts(getIntactParts()-1);
			}
		}
	}
		
	public Boolean isDestroyed() {
		if(getIntactParts() == 0)
			return true;
		return false;
	}





	
}
