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
	private BufferedImage[][] HUDicon;
	private BufferedImage mapBackground[];
	private BufferedImage HUD;
	private BufferedImage lobby;
	private BufferedImage lobbyHUD;
	private BufferedImage pauseOverlay;
	private BufferedImage bigImg;
	private BufferedImage HUDicons;
	private BufferedImage bancone;
	

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
			pauseOverlay=(ImageIO.read(getClass().getResource("/img/pause_overlay.png")));
			lobby=ImageIO.read(getClass().getResource("/img/Lobby.png"));
			bancone=ImageIO.read(getClass().getResource("/img/tavern_bancone.png"));
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
		width = 32;
		height = 32;
		rows = 2;
		cols = 3;
		HUDicon = new BufferedImage[rows][cols];
		try {
	        HUDicons = ImageIO.read(getClass().getResource("/img/tavern_hud_icons.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < rows; i++)
		{
		    for (int j = 0; j < cols; j++)
		    {
		    	HUDicon[i][j] = HUDicons.getSubimage(j * width,i * height,width,height);
		    }
		}	
		cols=1;
		mapBackground= new BufferedImage [cols];
		try {
	    	
	        mapBackground[0] = ImageIO.read(getClass().getResource("/img/MapBackgrounds01.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public BufferedImage getPauseOverlay() {
		return pauseOverlay;
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
	
	public BufferedImage[][] getHUDicon() {
		return HUDicon;
	}
	
	public BufferedImage[] getMapBackground() {
		return mapBackground;
	}
	
	public BufferedImage getLobbyHUD() {
		return lobbyHUD;
	}
	
	public BufferedImage getBancone() {
		return bancone;
	}
}
