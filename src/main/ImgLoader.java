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
	private BufferedImage lobbyHUD;
	private BufferedImage bigImg;

	public ImgLoader(){
	width = 32;
	height = 32;
	rows = 8;
	cols = 4;
	spritesBase = new BufferedImage[rows][cols];
	load();
	}
	void load(){
		try {
			bigImg = ImageIO.read(getClass().getResource("/img/Spritesheet.png"));
			HUD=ImageIO.read(getClass().getResource("/img/HUD.png"));
			lobbyHUD=(ImageIO.read(getClass().getResource("/img/tavern_hud.png")));
			lobby=ImageIO.read(getClass().getResource("/img/Lobby.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < rows; i++)
		{
		    for (int j = 0; j < cols; j++)
		    {
		        spritesBase[i][j] = bigImg.getSubimage(j * width,i * height,width,height);
		    }
		}	
		cols=1;
		try {
	    	mapBackground= new BufferedImage [cols];
	        mapBackground[0] = ImageIO.read(getClass().getResource("/img/MapBackgrounds01.png"));
		} catch (IOException e) {
			e.printStackTrace();
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
	public BufferedImage getLobbyHUD() {
		return lobbyHUD;
	}
}
