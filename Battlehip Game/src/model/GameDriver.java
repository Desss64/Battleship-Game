package model;

public class GameDriver {

	public static void main(String[] args) {
	//Game game;
		
		Player p1 = new Player("Bryan");
		Player p2 = new Player("Sam");
		
		p1.placeAllShips();
		p2.getShipList(0).placeShip(0,0);
		
		
		p1.playTurn(0, 0, p2);
		p2.playTurn(0, 0, p1);
		System.out.println(p2.placementBoard.boardArray[0][0].getSquareStatus()); 
		
	}

}
