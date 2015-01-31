package main;

import java.util.ArrayList;
import java.util.Random;

public class Drop {
	Random rand = new Random();
	ArrayList<String> name=new ArrayList<String>();
	String text="You obtained";
	
	Drop(){
		name.add("zombie eye.");
		name.add("zombie bones.");
		name.add("zombie flesh.");
	}

	void obtainItem(){
		int n;
		n=rand.nextInt(3);
		updateString(n);
	}
	
	void updateString(int n){
		//text.
		
	}
}
