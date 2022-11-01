package model;
//Submarine Class

public class Submarine extends Ship{
	public Submarine() {
		setShipName("Submarine");
		setShipSize(3);
		setIntactParts(3);
		shipLocation[0]=new Square();
		shipLocation[1]=new Square();
		shipLocation[2]=new Square();
		setShipSymbol("S");
	}
}
