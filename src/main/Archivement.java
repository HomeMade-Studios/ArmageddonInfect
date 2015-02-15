package main;

import java.awt.Point;

public class Archivement {
	
	String name, goal;
	Point imagePosition;
	boolean unlocked;
	
	
	public Archivement(String name, String goal, Point imagePosition){
		this.name = name;
		this.goal = goal;
		this.imagePosition = imagePosition;
		unlocked = false;
	}


	public boolean isUnlocked() {
		return unlocked;
	}


	public void setUnlocked(boolean unlocked) {
		this.unlocked = unlocked;
	}	
	
	
	
}
