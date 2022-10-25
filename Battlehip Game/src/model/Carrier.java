package model;
//Carrier Class

public class Carrier extends Ship{
	
	public Carrier() {
		setShipName("Carrier");
		setShipSize(5);
		setIntactParts(5);
		shipLocation[0]=new Square();
		shipLocation[1]=new Square();
		shipLocation[2]=new Square();
		shipLocation[3]=new Square();
		shipLocation[4]=new Square();
	}
}
