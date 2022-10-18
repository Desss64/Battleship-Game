package model;

//import java.util.Scanner;

public class Ship {
	
	private String shipName;
	private int shipSize;
	public Square[] shipLocation;
	private int intactParts;
	
	
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
			}else if(shipLocation[i].getX() < 0 || shipLocation[i].getY() < 0) {
				return true;
			}
		}
		return false;
	}
	
	/*public void placeShip(int size) {
		Scanner scn = new Scanner(System.in);
		int xVal,yVal;
		for (int i =0;i<size;i++) {
			System.out.println("Input x value of ship square " + (i+1));
			xVal=scn.nextInt();
			shipLocation[i].setX(xVal);
			System.out.println("Input y value of ship square " + (i+1));
			yVal=scn.nextInt();
			shipLocation[i].setY(yVal);
		}
		scn.close();
	}*/

	
}
