package main;

import java.awt.Rectangle;
import java.util.Random;

public class Enemy {
	
	int x;
	int y;
	int delay;
	int move;
	int strength;
	int i;  
	int health;
	int drop;
	int p,j,Mj,DMj,an,dAn,k;
	Rectangle enemyHB;
	Rectangle enemyHealth;
	Random rand = new Random();
	
	public Enemy(int wave){
		
		x = rand.nextInt(992);
		y = rand.nextInt(668);
		k = 0;
		strength = 10+wave;
		health=100;
		dAn=an=j=0;
    	Mj=DMj=15;
		delay = 0 + rand.nextInt(5);
		j = 0;
		enemyHB =new Rectangle(x+6,y,20,32);
		enemyHealth=new Rectangle(enemyHB.x,enemyHB.y-12,(int)enemyHB.getWidth(),3);
		p = 4;
		drop=rand.nextInt(4);
	}
	
	public void move(int characterx, int charactery, Rectangle characterHB){
		if(!enemyHB.intersects(characterHB)){
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
			if(an>2){
				Mj=DMj;
				an=dAn;
				j=0;
			}
			if(x == characterx && y == charactery){
				Mj=DMj;
				an=dAn;
				j=0;
			}
			enemyHB = new Rectangle(x+6,y,20,32);
			enemyHealth=new Rectangle(enemyHB.x,enemyHB.y-12,(int)enemyHB.getWidth(),3);
		}
		else{
			if(k > 20){
				an = 3;
				if(k == 40){
					k = 0;
				}
				
			}
			else{
				an = 0;
			}
			k++;
			
		}
	}
	
	public void attacked(int Str, int Pov,int cx,int cy, boolean click){
		System.out.println(click);
		if(click){
			if((cx>x&&Pov==2)||(cx<x&&Pov==3)||(cy>y&&Pov==1)||(cy<y&&Pov==0))
				health-=Str;
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
	
	public int getStrength() {
		return strength;
	}
	
	public Rectangle getEnemyHB() {
		return enemyHB;
	}

	public int getHealth() {
		return health;
	}

	public Rectangle getEnemyHealth() {
		return enemyHealth;
	}
	
	public int getDrop() {
		return drop;
	}	
}
