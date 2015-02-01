package main;

import java.util.ArrayList;

public class Inventory {
	
	 ArrayList<Integer> drop;
	 ArrayList<Integer> dropNumber;
	 ArrayList<String> dropName;
	private boolean first=true;
	private int x,y;
	
	Inventory(){
		drop=new ArrayList<Integer>();
		dropNumber=new ArrayList<Integer>();
		dropName=new ArrayList<String>();
		x = 700;
		y = 200;
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
		System.out.println(drop);
	}

	public ArrayList<Integer> getDrop() {
		return drop;
	}

	public ArrayList<Integer> getDropNumber() {
		return dropNumber;
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
	

}
