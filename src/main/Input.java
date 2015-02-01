package main;

import java.awt.event.KeyEvent;



public class Input {
	private int dx;
	private int dy;
	private boolean paused = false, inventory = false, stats = false, equipment = false;
	
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
        
        if (key == KeyEvent.VK_I) {
        	if(inventory)
        		inventory=false;
        	else
        		inventory=true;
        }
        
        if (key == KeyEvent.VK_K) {
        	if(stats)
        		stats=false;
        	else
        		stats=true;
        }  
        
        if (key == KeyEvent.VK_P) {
        	if(equipment)
        		equipment=false;
        	else
        		equipment=true;
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

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public boolean isPaused() {
		return paused;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}

	public boolean isInventory() {
		return inventory;
	}

	public void setInventory(boolean inventory) {
		this.inventory = inventory;
	}

	public boolean isStats() {
		return stats;
	}

	public void setStats(boolean stats) {
		this.stats = stats;
	}

	public boolean isEquipment() {
		return equipment;
	}

	public void setEquipment(boolean equipment) {
		this.equipment = equipment;
	}
	
	
    
}



