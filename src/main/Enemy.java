package main;

import java.util.Random;

public class Enemy {
	
	int x;
	int y;
	int delay;
	int move;
	int i;  
	int p,j,Mj,DMj,an,dAn;
	Random rand = new Random();
	
	public Enemy(){
		
		x = rand.nextInt(992);
		y = rand.nextInt(668);
		dAn=an=j=0;
    	Mj=DMj=15;
		delay = 2 + rand.nextInt(3);
		j = 0;
	}
	
	public void move(int characterx, int charactery){
		if(move > delay ){
			if(x < characterx){
				x++;
				p=7;
			}
			if(x > characterx){
				x--;
				p=6;
			}
			if(y < charactery){
				y++;
				p=4;
			}
			if(y > charactery){
				y--;
				p=5;
			}
			move = 0;
		}
		else{
			move++;
		}
		
		j++;				//Aggiunge ritardo all'animazione
		if(j>Mj){
			an++;
			Mj+=DMj;
		}
		if(an==3){
			Mj=DMj;
			an=dAn;
			j=0;
		}
		if(x == characterx && y == charactery){
			Mj=DMj;
			an=dAn;
			j=0;
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

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public int getAn() {
		return an;
	}
	
	
	
	
	

}
