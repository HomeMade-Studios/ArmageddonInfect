package main;

import java.awt.Rectangle;
import java.util.ArrayList;


public class Craft {
	ArrayList<Rectangle> craftingItem;
	Rectangle craftScrollClick;
	Rectangle craftDrag;
	Rectangle confirmCraft;
	Rectangle exitCraft;
	private int x,y;
	private int scrollx,scrolly,tempx,tempy;
	int page = 0;
	boolean dragging,isCrafting;
	
	public Craft(){
		x=200;
		y=200;
		craftingItem=new ArrayList<Rectangle>() ;
		for(int i=0;i<5;i++)
			craftingItem.add(new Rectangle(x+8+96,y+21+(i*35),167,32));
		craftScrollClick=new Rectangle(x+179+96,y+20,5,175);
		craftDrag=new Rectangle(x+96,y,380, 15);
		confirmCraft=new Rectangle(x+240+96,y+175,74,23);	
		exitCraft=new Rectangle(x+467,y,10,10);
		}

	public void craftWindowMove(int dx, int dy){	
		dragging = true;
		tempx=x;
		tempy=y;
		x=dx;
		y=dy;	
		scrollx += x-tempx;
		scrolly += y-tempy;
		for(int i=0;i<5;i++)
			craftingItem.set(i,new Rectangle(x+8+96,y+21+(i*35),167,32));
		craftScrollClick=new Rectangle(x+179+96,y+20,5,175);
		craftDrag=new Rectangle(x+96,y,380, 15);
		confirmCraft=new Rectangle(x+240+96,y+175,74,23);
	}
	
	public void craftScrollMove(int My, int equipSize){	
		if(equipSize > 5){
			if(My > scrolly){
				scrolly+=175/(equipSize/5);
				page++;
			}
			else if(My < scrolly){
				scrolly-=175/(equipSize/5);	
				page--;
			}
		}	
	}
	
	public void updateCraft(){
		craftScrollClick=new Rectangle(x+179,y+20,5,175);
		craftDrag=new Rectangle(x+96,y,380, 15);
		confirmCraft=new Rectangle(x+240+96,y+175,74,23);
		for(int i=0;i<5;i++)
			craftingItem.set(i,new Rectangle(x+8+96,y+21+(i*35),167,32));
	}
	
	public Rectangle getExitCraft() {
		return exitCraft;
	}
	
	public void setDragging(boolean isCrafting) {
		this.dragging = isCrafting;
	}

	public ArrayList<Rectangle> getCraftingItem() {
		return craftingItem;
	}

	public boolean isDragging() {
		return dragging;
	}

	public boolean isCrafting() {
		return isCrafting;
	}

	public Rectangle getCraftScrollClick() {
		return craftScrollClick;
	}

	public Rectangle getCraftDrag() {
		return craftDrag;
	}

	public Rectangle getConfirmCraft() {
		return confirmCraft;
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
	
	
}
