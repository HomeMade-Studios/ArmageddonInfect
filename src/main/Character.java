package main;

import java.awt.Rectangle;
import java.util.Random;

public class Character{

    private int x,oldx;
    private int y,oldy;
    private int pov,j,Mj,DMj,an,dAn,k,att,exp,maxExp,addhp,addStrength;
    private int strength=50;
	int healt,healtMax;
	int level;
    Rectangle hitbox,attackbox,walkableMapArea,walkableLobbyArea;
	Random rand = new Random();
	boolean attack;
    
    public Character(int Width, int Height) {
    	addhp=0;
    	addStrength=0;
    	dAn=an=j=0;
    	k=0;
    	maxExp=100;
    	Mj=DMj=15;
        x = (Width/2)-16;
        y = (Height/2)-16;
        walkableMapArea=new Rectangle (47,28,923,597);
        walkableLobbyArea=new Rectangle (25,5,964,630);    
    }
    
    public void move(boolean isInLobby, int dx, int dy) {
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
    
	public void animationCycle(boolean click, int dx, int dy){
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
	
	public void wearEquip(int t,int n){
		
		if(t==1){
			if(addStrength!=0)
				strength-=addStrength;
			addStrength=n;
			strength+=addStrength;
		}
		else{ 
			if(addhp!=0)
				healt-=addhp;
			addhp=n;
			healtMax+=addhp;
			healt=healtMax;
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

	public void setAddhp(int addhp) {
		this.addhp = addhp;
	}

	public void setAddStrength(int addStrength) {
		this.addStrength = addStrength;
	}

	public int getAddhp() {
		return addhp;
	}

	public int getAddStrength() {
		return addStrength;
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