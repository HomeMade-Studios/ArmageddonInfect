package main;

import java.util.Random;

public class Enemy {
	
	int x;
	int y;
	int delay;
	int j;
	Random rand = new Random();
	
	public Enemy(){
		
		x = rand.nextInt(992);
		y = rand.nextInt(668);
		delay = 2 + rand.nextInt(3);
		j = 0;
	}
	
	public void move(int characterx, int charactery){
		if(j > delay ){
			if(x < characterx){
				x++;
			}
			if(x > characterx){
				x--;
			}
			if(y < charactery){
				y++;
			}
			if(y > charactery){
				y--;
			}
			j = 0;
		}
		else{
			j++;
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	

}
