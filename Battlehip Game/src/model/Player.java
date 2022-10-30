package model;

import java.util.Random;

//Player Class

public class Player {
	private String name;
	private Ship[] shipList = new Ship[5];
	private int fires, hits, misses, numberOfShipsLeft;
	private Boolean turn = false;
	public Board placementBoard;
	public OpponentsBoard attackingBoard;
	private String hitStatus;

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

	public Boolean getTurn() {
		return turn;
	}

	public void setTurn(Boolean turn) {
		this.turn = turn;
	}

	public Player(String name) {
		setName(name);
		buildShips();
		setFires(0);
		setHits(0);
		setNumberOfShipsLeft(5);
		generateBoards();
	}

	public void buildShips() {
		shipList[0] = new Destroyer();
		shipList[1] = new Submarine();
		shipList[2] = new Cruiser();
		shipList[3] = new Battleship();
		shipList[4] = new Carrier();
	}

	public void generateBoards() {
		placementBoard = new Board();
		attackingBoard = new OpponentsBoard();
	}

	/**
	 * Places ships in random location on player's board
	 */
	public void placeAllShips() {
		int max = 8;
		Random rd = new Random();

		// randomly place each player's ship on their board
		for (int i = 0; i < shipList.length; i++) {
			for (int j = 0; j < getShipList(i).getShipSize(); j++) {

				// set value for if ship is vertical or not
				shipList[i].setIsVertical(rd.nextBoolean());

				// place ship in random spot on grid
				shipList[i].placeShip((int) (Math.random() * max), (int) (Math.random() * max));

				// if ship is out of bounds during placement
				while (shipList[i].isOutOfBounds()) {
					shipList[i].placeShip((int) (Math.random() * max), (int) (Math.random() * max));
				}

				// if ship overlaps with another ship
				if (i > 0) {
					while (shipList[i].isOverlap(shipList[i - 1])) {
						shipList[i].placeShip((int) (Math.random() * max), (int) (Math.random() * max));
					}
				}
			}
		}
	}

	public Square shoot(int x, int y) {
		Square s1 = new Square(x, y);
		attackingBoard.boardArray[x][y].setSquareStatus(false);
		return s1;
	}

	public Boolean checkIsHit(Square s1) {
		for (int i = 0; i < 5; i++) {
			if (shipList[i].isHit(s1.getX(), s1.getY())) {
				return true;
			}
		}
		return false;
	}

	public void playTurn(int x, int y) {

		shoot(x, y);
		setTurn(false);

		// check if player's shot hit opponent ship
		if (checkIsHit(shoot(x, y)))
			hitStatus = "hit";
		else
			hitStatus = "missed";

		// display coordinate and whether opponent ship was hit
		System.out.println(name + " " + hitStatus + " (" + x + ", " + y + ")");
	}

}
