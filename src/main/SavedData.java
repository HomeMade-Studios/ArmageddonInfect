package main;

import java.io.Serializable;
import java.util.ArrayList;

public class SavedData implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int exp,MaxHealt,level,strength;
	private ArrayList<Integer> drop=new ArrayList<Integer>();
	private ArrayList<Integer> dropNumber=new ArrayList<Integer>();

	public ArrayList<Integer> getDrop() {
		return drop;
	}

	public void setDrop(ArrayList<Integer> drop) {
		this.drop = drop;
	}

	public ArrayList<Integer> getDropNumber() {
		return dropNumber;
	}

	public void setDropNumber(ArrayList<Integer> dropNumber) {
		this.dropNumber = dropNumber;
	}

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
