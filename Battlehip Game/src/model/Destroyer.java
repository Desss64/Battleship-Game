package model;
//Destroyer Class

public class Destroyer extends Ship{
	public Destroyer() {
		setShipName("Destroyer");
		setShipSize(2);
		setIntactParts(2);
		shipLocation[0]=new Square();
		shipLocation[1]=new Square();
		setShipSymbol("D");
	}
}
