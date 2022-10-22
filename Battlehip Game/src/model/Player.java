package model;

import java.util.Random;

//Player Class

public class Player {
	private String name;
	private Ship[] shipList;
	private int fires,hits,misses,numberOfShipsLeft;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Ship[] getShipList() {
		return shipList;
	}

	public void setShipList(Ship[] shipList) {
		this.shipList = shipList;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
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
	
	public void placeAllShips() {
		int min = 0;
		int max = 7;
		Random rd =new Random();
		
		shipList[0].setIsVertical(rd.nextBoolean());
		shipList[0].placeShip( (int)(Math.random()*(max-min+1)+min),  (int)(Math.random()*(max-min+1)+min));
	}

	
}
