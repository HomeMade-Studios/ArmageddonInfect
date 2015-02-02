package main;

import java.io.Serializable;
import java.util.ArrayList;

public class SavedData implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int exp,MaxHealt,level,strength,inventoryX,inventoryY,addHealtChar,addStrengthChar;
	public int getInventoryX() {
		return inventoryX;
	}

	public void setInventoryX(int inventoryX) {
		this.inventoryX = inventoryX;
	}

	public int getInventoryY() {
		return inventoryY;
	}

	public void setInventoryY(int inventoryY) {
		this.inventoryY = inventoryY;
	}

	private ArrayList<Integer> drop=new ArrayList<Integer>();
	private ArrayList<Integer> dropNumber=new ArrayList<Integer>();
	private ArrayList<String> dropName=new ArrayList<String>();
	private ArrayList<Integer> equip=new ArrayList<Integer>();
	private ArrayList<String> equipName=new ArrayList<String>();
	private ArrayList<Integer> equipType=new ArrayList<Integer>();
	private ArrayList<Integer> equipWear=new ArrayList<Integer>();
	 
	public int getAddHealtChar() {
		return addHealtChar;
	}

	public void setAddHealtChar(int addHealtChar) {
		this.addHealtChar = addHealtChar;
	}

	public int getAddStrengthChar() {
		return addStrengthChar;
	}

	public void setAddStrengthChar(int addStrengthChar) {
		this.addStrengthChar = addStrengthChar;
	}

	public ArrayList<Integer> getEquip() {
		return equip;
	}

	public void setEquip(ArrayList<Integer> equip) {
		this.equip = equip;
	}

	public ArrayList<String> getEquipName() {
		return equipName;
	}

	public void setEquipName(ArrayList<String> equipName) {
		this.equipName = equipName;
	}

	public ArrayList<Integer> getEquipType() {
		return equipType;
	}

	public void setEquipType(ArrayList<Integer> equipType) {
		this.equipType = equipType;
	}

	public ArrayList<Integer> getEquipWear() {
		return equipWear;
	}

	public void setEquipWear(ArrayList<Integer> equipWear) {
		this.equipWear = equipWear;
	}

	public ArrayList<Integer> getDrop() {
		return drop;
	}

	public void setDrop(ArrayList<Integer> drop) {
		this.drop = drop;
	}

	public ArrayList<Integer> getDropNumber() {
		return dropNumber;
	}
	
	public ArrayList<String> getDropName() {
		return dropName;
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

	public void setDropName(ArrayList<String> dropName) {
		this.dropName = dropName;
		
	}
}
