package main;

import java.awt.Point;
import java.awt.Rectangle;


public class HUD {
	private Rectangle healtgr1;
	private Rectangle healtgr2;
	private float healt1;
	private float healt2;
	private float healtMAX;
	private int screenWidth;
	private int screenHeight;
	private int x;
	private int y;
	private int h1;
	private int h2;
	private int h2y;
	private int temp;

	public HUD(int Width, int Height, int healtMAX) {
		screenWidth = Width;
		screenHeight = Height;
		x = screenWidth - 275;
		y = screenHeight - 150;
		h1 = 226;
		h2 = 64;
		this.healtMAX = healtMAX;
		healt1 = healtMAX / 100 * 70;
		healt2 = healtMAX / 100 * 30;
		h2y = 0;
		temp = 0;
	}

	public void updateHUD(int life) {
		if (life >= healt1) {
			healt2 = life - healt1;
			healt1 = healtMAX / 100 * 70;
		} else {
			healt2 = -1;
			healt1 = life;
		}
		if (healt2 == -1) {
			h1 = (int) (226 * ((healt1) / (healtMAX / 100 * 70)));
		} else {
			temp = h2;
			h2 = (int) (64 * ((healt2) / (healtMAX / 100 * 30)));
			h2y = h2y + (temp - h2);
		}
	}

	public Rectangle getHealtgr1() {
		return healtgr1;
	}

	public Rectangle getHealtgr2() {
		return healtgr2;
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
}