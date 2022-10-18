package model;

public class Game extends Board{
	public Board[] playerBoards;
	public int[] score;
	public Boolean turn;
	
	public void generateBoards(Board b1, Board b2) {
		b1 = new Board();
		b2 = new OpponentsBoard();
	}
	
	
	
}
