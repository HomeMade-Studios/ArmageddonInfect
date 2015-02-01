package main;

import java.util.ArrayList;
import java.util.Random;

public class Drop {
	Random rand = new Random();
	ArrayList<String> name=new ArrayList<String>();
	String text="You obtained";
	int n;

	Drop(){
		name.add("Zombie Eye");
		name.add("Zombie Bones");
		name.add("Zombie Flesh");
		name.add("Marihuana");
		name.add("Zombie cunt");
		name.add("Getting high");
	}

	void obtainItem(){
		text = "You obtained: ";
		n=rand.nextInt(6);
		updateString(n);
	}
	
	void updateString(int n){
		text=text+name.get(n);
	}

	public String getText() {
		return text;
	}
	
	public int getN() {
		return n;
	}

	public ArrayList<String> getName() {
		return name;
	}	
	
	
}
