package main;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Character{

    private int x,oldx;
    private int y,oldy;
    private int dx;
    private int dy;
    private int pov,j,Mj,DMj,an,dAn,k,att,exp,maxExp;
    private int strength=50;
	int healt,healtMax;
	int level;
    Rectangle hitbox,attackbox,walkableMapArea,walkableLobbyArea;
	Random rand = new Random();
	boolean paused,attack;
    
    public Character(int Width, int Height) {
    	healt=healtMax=100;
    	dAn=an=j=0;
    	k=0;
    	level = 0;
    	maxExp=100;
    	Mj=DMj=15;
        x = (Width/2)-16;
        y = (Height/2)-16;
        walkableMapArea=new Rectangle (47,28,923,597);
        walkableLobbyArea=new Rectangle (25,5,964,630);    
    }
    
    public void move(boolean isInLobby) {
    	oldx=x;
    	oldy=y;
	    x += dx;
	    y += dy;
        hitbox=new Rectangle (x+4,y,21,32);
	    attackbox=new Rectangle (x-6,y-6,44,44);
	    if(isInLobby){
	    	if(!walkableLobbyArea.intersects(hitbox)){
		    	stopmove();
		    }
	    }
	    else{
	    	if(!walkableMapArea.intersects(hitbox)){
		    	stopmove();
		    }
	    }
	    
    }
    
    public void stopmove() {
    	x=oldx;
    	y=oldy;
	}

	public void SetP(int mx, int my){
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
    }
    
    public void attacked(int Str){
    	if(att>80){
			att=0;
	    	healt-=Str;
		}
    	att++;
    }
    
	public void animationCycle(boolean click){
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
	}
    
	public void keyPressed(KeyEvent e){

        int key = e.getKeyCode();
    	
        if (key == KeyEvent.VK_F) {
            healt=healtMax;
        }
        
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
    
    public int getPov() {
		return pov;
	}

	public int getAn() {
		return an;
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

	public int getHealtMax() {
		return healtMax;
	}
	
	public Rectangle getHitbox() {
		return hitbox;
	}

	public Rectangle getAttackbox() {
		return attackbox;
	}
	
	public Rectangle getWalkableMapArea() {
		return walkableMapArea;
	}
	
	public Rectangle getWalkableLobbyArea() {
		return walkableLobbyArea;
	}

	public boolean isPaused() {
		return paused;
	}

	public int getExp() {
		return exp;
	}

	public int getMaxExp() {
		return maxExp;
	}

	public int getLevel() {
		return level;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public void setHealtMax(int healtMax) {
		this.healtMax = healtMax;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}
}