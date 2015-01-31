package main;

import java.util.ArrayList;

public class Inventory {
	
	ArrayList<Integer> drop=new ArrayList<Integer>();
	ArrayList<Integer> dropNumber=new ArrayList<Integer>();
	boolean first=true;
	int x,y;
	
	Inventory(){
		drop.add(0);
		dropNumber.add(0);
		x = 700;
		y = 200;
	}
	
	public void addDrop(int n){
		for(int i=0;i<drop.size();i++){
			if(drop.get(i)!=n){
				first=true;
			}
			else{
				dropNumber.set(i, dropNumber.get(i)+1);
				first=false;
			}
		}
		if(first){
			drop.add(n);
			dropNumber.add(1);
		}
	}

}
