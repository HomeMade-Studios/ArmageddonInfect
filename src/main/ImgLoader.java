package main;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImgLoader {
	private int width;
	private int height;
	private int rows;
	private int cols;
	private BufferedImage[][] spritesBase;
	private BufferedImage mapBackground[];
	private BufferedImage HUD;
	private BufferedImage lobby;
	private BufferedImage bigImg;

	public ImgLoader(){
	System.out.println(getClass());
	spritesBase = new BufferedImage[rows][cols];
	load();
	}
	void load(){
		try {
			bigImg = ImageIO.read(getClass().getResource("/img/Spritesheet.png"));
			HUD=ImageIO.read(getClass().getResource("/img/HUD.png"));
			lobby=ImageIO.read(getClass().getResource("/img/Lobby.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		width = 32;
		height = 32;
		rows = 8;
		cols = 4;
		for (int i = 0; i < rows; i++)
		{
		    for (int j = 0; j < cols; j++)
		    {
		        spritesBase[i][j] = bigImg.getSubimage(j * width,i * height,width,height);
		    }
		}	
		width = 1024;
		height = 700;
		rows = 1;
		cols = 2;
		try {
			bigImg = ImageIO.read(getClass().getResource("/img/MapBackgrounds.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < rows; i++)
		{
		    for (int j = 0; j < cols; j++)
		    {
		        mapBackground[(i * cols) + j] = bigImg.getSubimage(j * width,i * height,width,height);
		    }
		}
	}
	
	public BufferedImage getHUD() {
		return HUD;
	}
	
	public BufferedImage getLobby() {
		return lobby;
	}
	
	public BufferedImage[][] getSprite() {
		return spritesBase;
	}
	
	public BufferedImage[] getMapBackground() {
		return mapBackground;
	}
}
