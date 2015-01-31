package main;

import java.util.ArrayList;

public class Inventory {
	
	ArrayList<Integer> drop=new ArrayList<Integer>();
	ArrayList<Integer> dropNumber=new ArrayList<Integer>();
	boolean first=true;

	Inventory(){
		drop.add(0);
		dropNumber.add(0);
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
