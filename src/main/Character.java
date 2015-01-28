package main;

import java.awt.event.KeyEvent;
import java.util.Random;

public class Character{

    static int x;
    static int y;
    int dx;
    int dy;
    int p,j,Mj,DMj,an,dAn;
    int strength=25;
    int healt=100;
	Random rand = new Random();
	boolean paused;
    
    public Character() {
    	dAn=an=j=0;
    	Mj=DMj=5;
        x = 480;
        y = 318;
    }
    
    public void move() {
    	x += dx;
        y += dy;
        System.out.println(x+" "+y);
        }
    
    public int GetP(int mx, int my){
    	if (Math.abs(mx-x)>Math.abs(my-y)){	//Algoritmo che determina la posizione del mouse rispetto al personaggio
    		if (mx-x>0){
	    		p=3;	//Imposta la variabile che indica che guarda a destra
    		}
    		else{
    			p=2;	//Visione a sinistra
    		}
    	}
    	else{
    		if (my-y>0){
	    		p=0;	//visione in basso
    		}
    		else{
    			p=1;	//visione in alto
    		}
    	}
    	return p;
    }
    
	public int animationCycle(){
		j++;
		if(j>Mj){
			an++;
			Mj+=25;
		}
		if(an==3){
			Mj=25;
			an=dAn;
			j=0;
		}
		if(dx==0&&dy==0){
			Mj=25;
			an=dAn;
			j=0;
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