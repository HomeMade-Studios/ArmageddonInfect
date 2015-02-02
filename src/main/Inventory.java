package main;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Inventory {
	
	 ArrayList<Integer> drop;
	 ArrayList<Integer> dropNumber;
	 ArrayList<String> dropName;
	private boolean first=true;
	Rectangle inventoryScrollClick;
	Rectangle inventoryDrag;
	private int x,y;
	private int scrollx,scrolly,tempx,tempy;
	int page = 0;
	boolean dragging;
	
	Inventory(){
		drop=new ArrayList<Integer>();
		dropNumber=new ArrayList<Integer>();
		dropName=new ArrayList<String>();
		x = 700;
		y = 200;
		scrollx = x+274;
		scrolly = y+15;
		inventoryScrollClick=new Rectangle(x+274,y+15,5,163);
		inventoryDrag=new Rectangle(x,y,192,9);
	}
	
	public void inventoryWindowMove(int dx, int dy){	
		dragging = true;
		tempx=x;
		tempy=y;
		x=dx;
		y=dy;	
		scrollx += x-tempx;
		scrolly += y-tempy;
		inventoryScrollClick=new Rectangle(x+274,y+15,5,163);
		inventoryDrag=new Rectangle(x+95,y,192,9);
	}
	
	public void inventoryScrollMove(int My, int inventorySize){	
		if(inventorySize > 5){
			if(My > scrolly){
				scrolly+=160/(inventorySize/5);
				page++;
			}
			else if(My < scrolly){
				scrolly-=160/(inventorySize/5);	
				page--;
			}
		}
	}
	
	public void updateInventory(){
		inventoryScrollClick=new Rectangle(x+274,y+15,5,163);
		inventoryDrag=new Rectangle(x+95,y,192,9);
	}
	
	public Rectangle getInventoryDrag() {
		return inventoryDrag;
	}

	public void setInventoryDrag(Rectangle inventoryDrag) {
		this.inventoryDrag = inventoryDrag;
	}

	public boolean isDragging() {
		return dragging;
	}

	public void setDragging(boolean dragging) {
		this.dragging = dragging;
	}

	public void addDrop(int n, String name){
		for(int i=0;i<drop.size();i++){
			if(drop.get(i)==n){
				dropNumber.set(i, dropNumber.get(i)+1);
				first=false;
				break;
			}
		}
		if(first){
			drop.add(n);
			dropNumber.add(1);
			dropName.add(name);
		}
		first = true;
	}

	public ArrayList<Integer> getDrop() {
		return drop;
	}

	public ArrayList<Integer> getDropNumber() {
		return dropNumber;
	}	
	
	public ArrayList<String> getDropName() {
		return dropName;
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

	public void setDrop(ArrayList<Integer> drop) {
		this.drop = drop;
	}

	public void setDropNumber(ArrayList<Integer> dropNumber) {
		this.dropNumber = dropNumber;
	}

	public void setDropName(ArrayList<String> dropName) {
		this.dropName = dropName;
	}

	public Rectangle getInventoryScrollClick() {
		return inventoryScrollClick;
	}
	
	public int getScrollY() {
		return scrolly;
	}
	
	public int getScrollX() {
		return scrollx;
	}
	
	public int getPage() {
		return page;
	}
	
	
	

}
