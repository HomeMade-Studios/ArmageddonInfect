package main;

public class Player {
	private int enemyKilled;
	
	public Player(){
		enemyKilled = 0;
	}
	
	public void AddEnemyKilled(){
		enemyKilled++;
	}
	
	public int enemyKilled(){
		return enemyKilled;
	}
}
