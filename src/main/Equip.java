package main;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Equip {
	
	 ArrayList<Integer> equip;
	 ArrayList<String> equipName;
	private boolean first=true;
	Rectangle equipScrollClick;
	Rectangle equipDrag;
	private int x,y;
	private int scrollx,scrolly,tempx,tempy;
	int page = 0;
	boolean dragging;
	
	Equip(){
		equip=new ArrayList<Integer>();
		equipName=new ArrayList<String>();
		x = 700;
		y = 200;
		scrollx = x+274;
		scrolly = y+15;
		equipScrollClick=new Rectangle(x+274,y+15,5,163);
		equipDrag=new Rectangle(x,y,192,9);
	}
	
	public void inventoryWindowMove(int dx, int dy){	
		dragging = true;
		tempx=x;
		tempy=y;
		x=dx;
		y=dy;	
		scrollx += x-tempx;
		scrolly += y-tempy;
		equipScrollClick=new Rectangle(x+274,y+15,5,163);
		equipDrag=new Rectangle(x+95,y,192,9);
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

	public void addEquip(int n, String name){
		for(int i=0;i<equip.size();i++){
			if(equip.get(i)==n){
				first=false;
				break;
			}
		}
		if(first){
			equip.add(n);
			equipName.add(name);
		}
		System.out.println(equipName);
		System.out.println(n);
		first = true;
	}

	
	public void updateInventory(){
		equipScrollClick=new Rectangle(x+274,y+15,5,163);
		equipDrag=new Rectangle(x+95,y,192,9);
	}
	
	public Rectangle getInventoryDrag() {
		return equipDrag;
	}

	public void setInventoryDrag(Rectangle inventoryDrag) {
		this.equipDrag = inventoryDrag;
	}

	public boolean isDragging() {
		return dragging;
	}

	public void setDragging(boolean dragging) {
		this.dragging = dragging;
	}
	
	public ArrayList<Integer> getDrop() {
		return equip;
	}
	
	public ArrayList<String> getDropName() {
		return equipName;
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
		this.equip = drop;
	}

	public void setDropName(ArrayList<String> dropName) {
		this.equipName = dropName;
	}

	public Rectangle getInventoryScrollClick() {
		return equipScrollClick;
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
