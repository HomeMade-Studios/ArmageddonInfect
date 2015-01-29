package main;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Character{

    private int x;
    private int y;
    private int dx;
    private int dy;
    private int pov,j,Mj,DMj,an,dAn,k,att;
    private int strength=50;
	int healt=1000;
    Rectangle hitbox,attackbox;
	Random rand = new Random();
	boolean paused,attack;
    
    public Character(int Width, int Height) {
    	dAn=an=j=0;
    	Mj=DMj=10;
        x = (Width/2)-16;
        y = (Height/2)-16;
        hitbox=new Rectangle (x+6,y,20,32);
        attackbox=new Rectangle (x-6,y-6,44,44);
    }
    
    public void move() {
	    	x += dx;
	        y += dy;
	        hitbox=new Rectangle (x+6,y,20,32);
	        attackbox=new Rectangle (x-6,y-6,44,44);
    }
    
    public int GetP(int mx, int my){
    	if (Math.abs(mx-x)>Math.abs(my-y)){	//Algoritmo che determina la posizione del mouse rispetto al personaggio
    		if (mx-x>0){
	    		pov=3;	//Imposta la variabile che indica che guarda a destra
    		}
    		else{
    			pov=2;	//Visione a sinistra
    		}
    	}
    	else{
    		if (my-y>0){
	    		pov=0;	//visione in basso
    		}
    		else{
    			pov=1;	//visione in alto
    		}
    	}
    	return pov;
    }
    
    public void attacked(int Str){
    	if(att>80){
			att=0;
	    	healt-=Str;
		}
    	att++;
    }
    
	public int animationCycle(boolean click){
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
		if(dx==0&&dy==0){
			Mj=DMj;
			an=dAn;
			j=0;
		}
		if(click)
			attack=true;
		if(attack){
			an=3;
			k++;
			if(k>15){
				attack=false;
				k=0;
			}
		}
		return an;
	}
    
	public void keyPressed(KeyEvent e){

        int key = e.getKeyCode();
    	
        if (key == KeyEvent.VK_A) {
            if(dx!=1)
        	dx = -1;
        }

        if (key == KeyEvent.VK_D) {
            if(dx!=-1)
            dx = 1;
        }

        if (key == KeyEvent.VK_W) {
            if(dy!=1)
            dy = -1;
        }

        if (key == KeyEvent.VK_S) {
            if(dy!=-1)
            dy = 1;
        }
        
        if (key == KeyEvent.VK_ESCAPE) {
        	if(paused)
        		paused=false;
        	else
        		paused=true;
        } 
    }
    
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_A) {
            if(dx!=1)
               dx = 0;
           }

           if (key == KeyEvent.VK_D) {
            if(dx!=-1)
               dx = 0;
           }

           if (key == KeyEvent.VK_W) {
            if(dy!=1)
               dy = 0;
           }

           if (key == KeyEvent.VK_S) {
            if(dy!=-1)
               dy = 0;
           }
    }
    
    public int getStrength() {
		return strength;
	}
    
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getHealt() {
		return healt;
	}
	public Rectangle getHitbox() {
		return hitbox;
	}

	public Rectangle getAttackbox() {
		return attackbox;
	}

	public boolean isPaused() {
		return paused;
	}
	
	
}