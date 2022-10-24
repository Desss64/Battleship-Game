package model;
//Battleship Class

public class Battleship extends Ship{
	public Battleship() {
		setShipName("Battleship");
		setShipSize(4);
		setIntactParts(4);
		for (int i = 0;i<getShipSize();i++) {
			shipLocation[i] = new Square();
		}
	}
}
