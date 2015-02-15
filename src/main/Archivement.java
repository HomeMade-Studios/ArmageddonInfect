package main;

public class Archivement {
	
	String name, goal;
	boolean unlocked;
	
	public Archivement(String name, String goal){
		this.name = name;
		this.goal = goal;
		unlocked = false;
	}

	public boolean isUnlocked() {
		return unlocked;
	}

	public void setUnlocked(boolean unlocked) {
		this.unlocked = unlocked;
	}

	public String getName() {
		return name;
	}

	public String getGoal() {
		return goal;
	}
	
}
