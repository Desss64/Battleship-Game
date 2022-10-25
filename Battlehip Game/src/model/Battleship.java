package model;
//Battleship Class

public class Battleship extends Ship{
	public Battleship() {
		setShipName("Battleship");
		setShipSize(4);
		setIntactParts(4);
		shipLocation[0]=new Square();
		shipLocation[1]=new Square();
		shipLocation[2]=new Square();
		shipLocation[3]=new Square();
	}
}
