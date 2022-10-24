package model;

public class GameDriver {

	public static void main(String[] args) {
	//Game game;
		
		Board b1 = null,b2 = null;
		Player p1 = new Player("Bryan",b1,b2);
		
		p1.getShipList(4).setIsVertical(true);
		p1.getShipList(4).placeShip(0, 0);
		
	}

}
