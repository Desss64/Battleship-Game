package model;
//Game Class

public class Game {
	//public Board[] playerBoards;
	private int[] score = new int[2];
	public Boolean turn;
	
	public int[] getScore() {
		return score;
	}
	
	public int getP1Score() {
		return score[0];
	}
	
	public int getP2Score() {
		return score[1];
	}
	
	public void setScore(Player p1, Player p2) {
		score[0] = p1.getNumberOfShipsLeft();
		score[1] = p2.getNumberOfShipsLeft();
	}
	
	public void playerTurn() {
		
	}
	
	
	
	
	
	
	
	
	
}
