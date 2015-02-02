package main;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Equip {
	
	 ArrayList<Integer> equip;
	 ArrayList<String> equipName;
	 ArrayList<Integer> equipType;
	 public ArrayList<Integer> getEquipType() {
		return equipType;
	}

	ArrayList<Rectangle> equippingItem;
	 ArrayList<Integer> equipWear;

	private boolean first=true;
	Rectangle equipScrollClick;
	Rectangle equipDrag;
	Rectangle confirmEquip;
	private int x,y;
	private int scrollx,scrolly,tempx,tempy;
	int page = 0;
	boolean dragging,isequipping;
	
	Equip(){
		equipWear=new ArrayList<Integer>();
		for(int i=0;i<2;i++)
			equipWear.add(null);
		equippingItem=new ArrayList<Rectangle>() ;
		equip=new ArrayList<Integer>();
		equipName=new ArrayList<String>();
		equipType=new ArrayList<Integer>();
		x = 300;
		y = 100;
		for(int i=0;i<5;i++)
			 equippingItem.add(new Rectangle(x+8,y+21+(i*35),167,32));
		scrollx = x+179;
		scrolly = y+20;
		equipScrollClick=new Rectangle(x+179,y+20,5,175);
		confirmEquip=new Rectangle(x+240,y+175,74,23);
		equipDrag=new Rectangle(x,y,321, 15);
	}
	
	public void inventoryWindowMove(int dx, int dy){	
		dragging = true;
		tempx=x;
		tempy=y;
		x=dx;
		y=dy;	
		scrollx += x-tempx;
		scrolly += y-tempy;
		equipScrollClick=new Rectangle(x+179,y+20,5,175);
		equipDrag=new Rectangle(x,y,321, 15);
		equippingItem.clear();
		for(int i=0;i<5;i++)
			 equippingItem.add(new Rectangle(x+8,y+21+(i*35),167,32));
	}
	
	public void equipScrollMove(int My, int equipSize){	
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

	public void addEquip(int n, String name, int type){
		for(int i=0;i<equip.size();i++){
			if(equip.get(i)==n){
				first=false;
				break;
			}
		}
		if(first){
			equip.add(n);
			equipName.add(name);
			equipType.add(type);
		}
		first = true;
	}

	public void updateEquip(){
		equipScrollClick=new Rectangle(x+179,y+20,5,175);
		equipDrag=new Rectangle(x,y,321, 15);
	}

	public void setEquipping(boolean arg0,int n){
		if(equipType.size()!=0){
			this.isequipping=arg0;
			if(equipType.get(n)==1)
				equipWear.set(1, n);
			else {
				equipWear.set(0, n);
			}
		}
	}
	public ArrayList<Rectangle> getEquippingItem() {
		return equippingItem;
	}

	public Rectangle getEquipDrag() {
		return equipDrag;
	}
	
	public Rectangle getConfirmEquip() {
		return confirmEquip;
	}

	public 	 ArrayList<Integer> getEquipWear() {
		return equipWear;
	}

	public boolean isIsequipping() {
		return isequipping;
	}

	public void setIsequipping(boolean isequipping) {
		this.isequipping = isequipping;
	}

	public boolean getEquipping() {
		return isequipping;
	}
	
	public void setEquipType(ArrayList<Integer> equipType) {
		this.equipType = equipType;
	}

	public void setEquipWear(ArrayList<Integer> equipWear) {
		this.equipWear = equipWear;
	}

	public void setEquipDrag(Rectangle inventoryDrag) {
		this.equipDrag = inventoryDrag;
	}

	public boolean isDragging() {
		return dragging;
	}

	public void setDragging(boolean dragging) {
		this.dragging = dragging;
	}
	
	public ArrayList<Integer> getEquip() {
		return equip;
	}
	
	public ArrayList<String> getEquipName() {
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

	public void setEquip(ArrayList<Integer> drop) {
		this.equip = drop;
	}

	public void setEquipName(ArrayList<String> dropName) {
		this.equipName = dropName;
	}

	public Rectangle getEquipScrollClick() {
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
