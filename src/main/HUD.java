package main;

import java.awt.Rectangle;


public class HUD {
	private float health1;
	private float health2;
	private int screenWidth;
	private int screenHeight;
	private int x;
	private int y;
	private int h1;
	private int h2;
	private int h2y;
	private int temp;
	private int expBar,expBox = 0;
	private Rectangle[] iconsHB;

	public HUD(int Width, int Height) {
		screenWidth = Width;
		screenHeight = Height;
		x = screenWidth - 270;
		y = screenHeight - 122;
		h1 = 226;
		h2 = 64;
		h2y = 0;
		temp = 0;
		iconsHB= new Rectangle[3];
		iconsHB[0] = new Rectangle(x+12,y+55, 28, 28);
		iconsHB[1] = new Rectangle(x+118, y+55, 28, 28);
		iconsHB[2] = new Rectangle(x+224, y+55, 28, 28);
	}

	public boolean updateHUD(int health, int healthMax, int exp, int expMax) {
		if (health > health1) {
			health1 = healthMax / 100 * 70;
			health2 = health - health1;
			h1 = (int) (226 * ((health1) / (healthMax / 100 * 70)));
		} else {
			h2 = -1;
			h2y = 65;
			health2 = -1;
			health1 = health;
		}
		if (health2 == -1) {
			h1 = (int) (226 * ((health1) / (healthMax / 100 * 70)));
		} else {
			temp = h2;
			h2 = (int) (64 * ((health2) / (healthMax / 100 * 30)));
			h2y = h2y + (temp - h2);
		}
		expBar = (int)(212 * ((exp%expMax)) / (expMax));
		if(exp >= expMax+(expMax*expBox)){
			expBox++;
		}
		if(expBox == 10){
			expBox = 0;
			return true;
		}
		return false;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public float getH1() {
		return h1;
	}

	public float getH2() {
		return h2;
	}

	public int getH2y() {
		return h2y;
	}

	public int getExpBox() {
		return expBox;
	}

	public int getExpBar() {
		return expBar;
	}

	public Rectangle[] getIconsHB() {
		return iconsHB;
	}
	
}