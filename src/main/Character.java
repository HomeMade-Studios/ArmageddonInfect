package main;

import java.awt.event.KeyEvent;
import java.util.Random;

public class Character{

    static int x;
    static int y;
    int dx;
    int dy;
    int strength=25;
    int healt=100;
	Random rand = new Random();
	boolean paused;
    
    public Character() {
        x = 480;
        y = 318;
    }
    
    public void move() {
    	x += dx;
        y += dy;
        System.out.println(x+" "+y);
        }
    
	public void keyPressed(KeyEvent e) {

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