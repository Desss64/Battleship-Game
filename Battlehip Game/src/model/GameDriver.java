package model;

public class GameDriver {

	public static void main(String[] args) {
	//Game game;
		
		Board b1 = null,b2 = null;
		Player p1 = new Player("Bryan",b1,b2);
		
		p1.placeAllShips(b1);
		System.out.println(p1.getShipList(2).shipLocation[0].getSquarePosition());
		System.out.println(p1.getShipList(2).shipLocation[1].getSquarePosition());
		System.out.println(p1.getShipList(2).shipLocation[2].getSquarePosition());
		
		System.out.println(p1.getShipList(3).shipLocation[0].getSquarePosition());
		System.out.println(p1.getShipList(3).shipLocation[1].getSquarePosition());
		System.out.println(p1.getShipList(3).shipLocation[2].getSquarePosition());
		System.out.println(p1.getShipList(3).shipLocation[3].getSquarePosition());
	}

}
