package main;

import java.io.Serializable;

public class SavedData implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int exp,MaxHealt,level,strength;

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getMaxHealt() {
		return MaxHealt;
	}

	public void setMaxHealt(int maxHealt) {
		MaxHealt = maxHealt;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}
}
