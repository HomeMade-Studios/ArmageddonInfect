package main;

import java.awt.Rectangle;

public class Stats {
	
	int x,y;
	Rectangle inventoryScrollClick;
	Rectangle inventoryDrag;
	Rectangle StrenghtUpHB, StrenghtDownHB;
	Rectangle DefenseUpHB, DefenseDownHB;
	Rectangle VitalityUpHB, VitalityDownHB;
	Rectangle DexterityUpHB, DexterityDownHB;
	
	public Stats(){
		x = 350;
		y = 200;
		StrenghtUpHB = new Rectangle(x+235,y+35,30,15);
		StrenghtDownHB = new Rectangle(x+235,y+65,30,15);
		DefenseUpHB = new Rectangle(x+235,y+82,30,15);
		DefenseDownHB = new Rectangle(x+235,y+112,30,15);
		VitalityUpHB = new Rectangle(x+235,y+129,30,15);
		VitalityDownHB = new Rectangle(x+235,y+159,30,15);
		DexterityUpHB = new Rectangle(x+235,y+176,30,15);
		DexterityDownHB = new Rectangle(x+235,y+206,30,15);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Rectangle getInventoryScrollClick() {
		return inventoryScrollClick;
	}

	public void setInventoryScrollClick(Rectangle inventoryScrollClick) {
		this.inventoryScrollClick = inventoryScrollClick;
	}

	public Rectangle getInventoryDrag() {
		return inventoryDrag;
	}

	public void setInventoryDrag(Rectangle inventoryDrag) {
		this.inventoryDrag = inventoryDrag;
	}

	public Rectangle getStrenghtUpHB() {
		return StrenghtUpHB;
	}

	public void setStrenghtUpHB(Rectangle strenghtUpHB) {
		StrenghtUpHB = strenghtUpHB;
	}

	public Rectangle getStrenghtDownHB() {
		return StrenghtDownHB;
	}

	public void setStrenghtDownHB(Rectangle strenghtDownHB) {
		StrenghtDownHB = strenghtDownHB;
	}

	public Rectangle getDefenseUpHB() {
		return DefenseUpHB;
	}

	public void setDefenseUpHB(Rectangle defenseUpHB) {
		DefenseUpHB = defenseUpHB;
	}

	public Rectangle getDefenseDownHB() {
		return DefenseDownHB;
	}

	public void setDefenseDownHB(Rectangle defenseDownHB) {
		DefenseDownHB = defenseDownHB;
	}

	public Rectangle getVitalityUpHB() {
		return VitalityUpHB;
	}

	public void setVitalityUpHB(Rectangle vitalityUpHB) {
		VitalityUpHB = vitalityUpHB;
	}

	public Rectangle getVitalityDownHB() {
		return VitalityDownHB;
	}

	public void setVitalityDownHB(Rectangle vitalityDownHB) {
		VitalityDownHB = vitalityDownHB;
	}

	public Rectangle getDexterityUpHB() {
		return DexterityUpHB;
	}

	public void setDexterityUpHB(Rectangle dexterityUpHB) {
		DexterityUpHB = dexterityUpHB;
	}

	public Rectangle getDexterityDownHB() {
		return DexterityDownHB;
	}

	public void setDexterityDownHB(Rectangle dexterityDownHB) {
		DexterityDownHB = dexterityDownHB;
	}
	
	
}
