package main;

import java.awt.event.KeyEvent;



public class Input {
	private int dx;
	private int dy;
	private boolean paused = false, inventoryMenu = false, statsMenu = false, equipmentMenu = false, craftingMenu = false,addEquip=false;
	
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
        	if(inventoryMenu)
        		inventoryMenu=false;
        	else
        		inventoryMenu=true;
        }
        
        if (key == KeyEvent.VK_K) {
        	if(statsMenu)
        		statsMenu=false;
        	else
        		statsMenu=true;
        }  
        
        if (key == KeyEvent.VK_P) {
        	if(equipmentMenu)
        		equipmentMenu=false;
        	else
        		equipmentMenu=true;
        } 
        
        if (key == KeyEvent.VK_C) {
        	if(craftingMenu)
        		craftingMenu=false;
        	else
        		craftingMenu=true;
        }
        if (key == KeyEvent.VK_L) {
        		addEquip=true;
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
        if (key == KeyEvent.VK_L) {
        	addEquip=false;
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
		return inventoryMenu;
	}

	public void setInventoryMenu(boolean inventory) {
		this.inventoryMenu = inventory;
	}

	public boolean isStatsMenu() {
		return statsMenu;
	}

	public void setStatsMenu(boolean stats) {
		this.statsMenu = stats;
	}

	public boolean isEquipmentMenu() {
		return equipmentMenu;
	}

	public void setEquipmentMenu(boolean equipment) {
		this.equipmentMenu = equipment;
	}
	
	public boolean isCraftingMenu() {
		return craftingMenu;
	}

	public void setCraftingMenu(boolean crafting) {
		this.craftingMenu = crafting;
	}
	public boolean addedEquip() {
		return addEquip;
	}    
}



