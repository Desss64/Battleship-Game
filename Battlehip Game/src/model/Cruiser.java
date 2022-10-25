package model;
//Cruiser Class

public class Cruiser extends Ship{
	public Cruiser() {
		setShipName("Cruiser");
		setShipSize(3);
		setIntactParts(3);
		shipLocation[0]=new Square();
		shipLocation[1]=new Square();
		shipLocation[2]=new Square();
	}
}
