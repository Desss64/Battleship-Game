package model;

import java.util.Random;

//Player Class

public class Player {
	private String name;
	private Ship[] shipList = new Ship[5];
	private int fires,hits,misses,numberOfShipsLeft;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Ship getShipList(int i) {
		return shipList[i];
	}

	public void setShipList(Ship[] shipList) {
		this.shipList = shipList;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
		setMisses(getFires() - hits);
	}

	public int getNumberOfShipsLeft() {
		return numberOfShipsLeft;
	}

	public void setNumberOfShipsLeft(int numberOfShipsLeft) {
		this.numberOfShipsLeft = numberOfShipsLeft;
	}

	public int getFires() {
		return fires;
	}

	public void setFires(int fires) {
		this.fires = fires;
	}

	public int getMisses() {
		return misses;
	}

	public void setMisses(int misses) {
		this.misses = misses;
	}
	
	public Player(String name, Board b1,Board b2) {
		setName(name);
		buildShips();
		setFires(0);
		setHits(0);
		setNumberOfShipsLeft(5);
		generateBoards(b1,b2);
	}
	
	public void buildShips() {
		shipList[0] = new Destroyer();
		shipList[1] = new Submarine();
		shipList[2] = new Cruiser();
		shipList[3] = new Battleship();
		shipList[4] = new Carrier();
	}
	
	public void generateBoards(Board b1, Board b2) {
		b1 = new Board();
		b2 = new OpponentsBoard();
	}
	
	public void placeAllShips(Board b1) {
		int min = 0;
		int max = 7;
		Random rd =new Random();
		
		shipList[0].setIsVertical(rd.nextBoolean());
		shipList[0].placeShip( (int)(Math.random()*(max-min+1)+min),  (int)(Math.random()*(max-min+1)+min));
		
		
		shipList[1].setIsVertical(rd.nextBoolean());
		shipList[1].placeShip( (int)(Math.random()*(max-min+1)+min),  (int)(Math.random()*(max-min+1)+min));
		while (shipList[1].isOverlap(shipList[0])==true){
			shipList[1].placeShip( (int)(Math.random()*(max-min+1)+min),  (int)(Math.random()*(max-min+1)+min));
		}
		
		shipList[2].setIsVertical(rd.nextBoolean());
		shipList[2].placeShip( (int)(Math.random()*(max-min+1)+min),  (int)(Math.random()*(max-min+1)+min));
		while (shipList[2].isOverlap(shipList[0])==true || shipList[2].isOverlap(shipList[1])==true){
			shipList[2].placeShip( (int)(Math.random()*(max-min+1)+min),  (int)(Math.random()*(max-min+1)+min));
		}
		
		shipList[3].setIsVertical(rd.nextBoolean());
		shipList[3].placeShip( (int)(Math.random()*(max-min+1)+min),  (int)(Math.random()*(max-min+1)+min));
		while (shipList[3].isOverlap(shipList[0])==true || shipList[3].isOverlap(shipList[1])==true || shipList[3].isOverlap(shipList[2])==true){
			shipList[3].placeShip( (int)(Math.random()*(max-min+1)+min),  (int)(Math.random()*(max-min+1)+min));
		}
		
		shipList[4].setIsVertical(rd.nextBoolean());
		shipList[4].placeShip( (int)(Math.random()*(max-min+1)+min),  (int)(Math.random()*(max-min+1)+min));
		while (shipList[4].isOverlap(shipList[0])==true || shipList[4].isOverlap(shipList[1])==true || shipList[4].isOverlap(shipList[2])==true || shipList[4].isOverlap(shipList[3])==true){
			shipList[4].placeShip( (int)(Math.random()*(max-min+1)+min),  (int)(Math.random()*(max-min+1)+min));
		}
	}

	
}
