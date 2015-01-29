package main;

import java.awt.event.KeyEvent;
import java.util.Random;

public class Character{

    static int x;
    static int y;
    int dx;
    int dy;
    int pov,j,Mj,DMj,an,dAn;
    int strength=25;
    int healt=100;
	Random rand = new Random();
	boolean paused,attack;
    
    public Character() {
    	dAn=an=j=0;
    	Mj=DMj=15;
        x = 480;
        y = 318;
    }
    
    public void move() {
    	x += dx;
        y += dy;
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
    
	public int animationCycle(boolean click){
		if(!attack)
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
		if(click){
			attack=true;
			an=3;
		}
		return an;
	}
    
	public void keyPressed(KeyEvent e){

        int key = e.getKeyCode();
    	
        if (key == KeyEvent.VK_A) {
            dx = -1;
        }

        if (key == KeyEvent.VK_D) {
            dx = 1;
        }

        if (key == KeyEvent.VK_W) {
            dy = -1;
        }

        if (key == KeyEvent.VK_S) {
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
        
    	if (key == KeyEvent.VK_1 ) {
        }
    	
        
        if (key == KeyEvent.VK_A) {
            dx = 0;
        }

        if (key == KeyEvent.VK_D) {
            dx = 0;
        }

        if (key == KeyEvent.VK_W) {
            dy = 0;
        }

        if (key == KeyEvent.VK_S) {
            dy = 0;
        }
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
}