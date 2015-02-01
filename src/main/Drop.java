package main;

import java.util.ArrayList;
import java.util.Random;

public class Drop {
	Random rand = new Random();
	ArrayList<String> name=new ArrayList<String>();
	String text="You obtained";
	int n;

	Drop(){
		name.add("zombie eye");
		name.add("zombie bones");
		name.add("zombie flesh");
	}

	void obtainItem(){
		text = "You obtained";
		n=rand.nextInt(3);
		updateString(n);
		System.out.println(text);
	}
	
	void updateString(int n){
		text=text+" "+name.get(n);
	}

	public String getText() {
		return text;
	}
	
	public int getN() {
		return n;
	}	
}
