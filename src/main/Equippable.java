package main;

import java.util.ArrayList;
import java.util.Random;

public class Equippable {
	Random rand = new Random();
	ArrayList<String> name=new ArrayList<String>();
	ArrayList<Integer> type=new ArrayList<Integer>();
	ArrayList<Integer> force=new ArrayList<Integer>();
	String text="You obtained";
	int n;

	Equippable(){
		name.add("Zombie bones & eye");
		name.add("Elm!");
		name.add("Robba");
		name.add("Pene");
		name.add("Figo!");
		name.add("Forse Funzia!");
		
		type.add(1);
		type.add(0);
		type.add(1);
		type.add(1);
		type.add(1);
		type.add(1);
		
		force.add(100);
		force.add(100);
		force.add(100);
		force.add(100);
		force.add(100);
		force.add(100);
	}

	void obtainItem(int item){
		text = "You obtained: ";
		n=item;
		updateString(n);
	}
	
	void updateString(int n){
		text=text+name.get(n);
	}

	public ArrayList<Integer> getForce() {
		return force;
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
	
	public ArrayList<Integer> getType() {
		return type;
	}	
}