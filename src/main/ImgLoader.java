package main;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImgLoader {
	private int width;
	private int fontWidth,smallFontWidth;
	private int height;
	private int rows;
	private int cols;
	private BufferedImage[][] spritesBase;
	private BufferedImage[][] lobbyHudIcon;
	private BufferedImage[] font;
	private BufferedImage[] fontSmall;
	private BufferedImage[] drop;
	private BufferedImage mapBackground[];
	private BufferedImage mapHud;
	private BufferedImage lobby;
	private BufferedImage lobbyHud;
	private BufferedImage bigImg;
	private BufferedImage bancone;
	private BufferedImage bancone2;
	private BufferedImage scrollButton;
	private BufferedImage inventoryMenu;
	private BufferedImage alchemistMenu;
	private BufferedImage blacksmithMenu;
	private BufferedImage enchanterMenu;
	private BufferedImage merchantMenu;
	private BufferedImage pauseMenu;
	private BufferedImage trasherMenu;
	
	

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
			bigImg = ImageIO.read(getClass().getResource("/img/Characters/Spritesheet.png"));
			mapHud=ImageIO.read(getClass().getResource("/img/Hud/map_hud.png"));
			lobbyHud=ImageIO.read(getClass().getResource("/img/Hud/lobby_hud.png"));
			lobby=ImageIO.read(getClass().getResource("/img/Tavern/tavern.png"));
			bancone=ImageIO.read(getClass().getResource("/img/Tavern/tavern_bancone.png"));
			bancone2=ImageIO.read(getClass().getResource("/img/Tavern/tavern_bancone_sotto.png"));
			scrollButton=ImageIO.read(getClass().getResource("/img/Menu/Buttons/scroll_button.png"));
			scrollButton=ImageIO.read(getClass().getResource("/img/Menu/Buttons/buy_button.png"));
			scrollButton=ImageIO.read(getClass().getResource("/img/Menu/Buttons/close_menu_button.png"));
			scrollButton=ImageIO.read(getClass().getResource("/img/Menu/Buttons/combine_button.png"));
			scrollButton=ImageIO.read(getClass().getResource("/img/Menu/Buttons/craft_button.png"));
			scrollButton=ImageIO.read(getClass().getResource("/img/Menu/Buttons/enchant_button.png"));
			scrollButton=ImageIO.read(getClass().getResource("/img/Menu/Buttons/recycle_button.png"));
			inventoryMenu=ImageIO.read(getClass().getResource("/img/Menu/inventory_menu.png"));
			alchemistMenu=ImageIO.read(getClass().getResource("/img/Menu/alchemist_menu.png"));
			blacksmithMenu=ImageIO.read(getClass().getResource("/img/Menu/blacksmith_menu.png"));
			enchanterMenu=ImageIO.read(getClass().getResource("/img/Menu/enchanter_menu.png"));
			merchantMenu=ImageIO.read(getClass().getResource("/img/Menu/merchant_menu.png"));
			trasherMenu=ImageIO.read(getClass().getResource("/img/Menu/trasher_menu.png"));
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
		lobbyHudIcon = new BufferedImage[rows][cols];
		try {
			bigImg = ImageIO.read(getClass().getResource("/img/Hud/lobby_hud_icons.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < rows; i++)
		{
		    for (int j = 0; j < cols; j++)
		    {
		    	lobbyHudIcon[i][j] = bigImg.getSubimage(j * width,i * height,width,height);
		    }
		}	
		
		cols=1;
		mapBackground= new BufferedImage [cols];
		try {
	    	
	        mapBackground[0] = ImageIO.read(getClass().getResource("/img/Map/map_background_01.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			fontWidth = 20;
			height = 30;
			rows=2;
			cols=26;
			font=new BufferedImage [rows*cols];
			bigImg = ImageIO.read(getClass().getResource("/img/Fonts/font.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < rows; i++)
		{
		    for (int j = 0; j < cols; j++)
		    {
		        font[(i * cols) + j] = bigImg.getSubimage(j * fontWidth,i * height,fontWidth,height);
		    }
		}
		
		try {
			smallFontWidth = 8;
			height = 11;
			rows=2;
			cols=26;
			fontSmall=new BufferedImage [rows*cols];
			bigImg = ImageIO.read(getClass().getResource("/img/Fonts/font_small.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < rows; i++)
		{
		    for (int j = 0; j < cols; j++)
		    {
		        fontSmall[(i * cols) + j] = bigImg.getSubimage(j * smallFontWidth, i * height, smallFontWidth, height);
		    }
		}
		try {
			width = 32;
			height = 32;
			rows=16;
			cols=16;
			drop=new BufferedImage [rows*cols];
			bigImg = ImageIO.read(getClass().getResource("/img/Menu/Icons/drop_icons.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < rows; i++)
		{
		    for (int j = 0; j < cols; j++)
		    {
		        drop[(i * cols) + j] = bigImg.getSubimage(j * width, i * height, width, height);
		    }
		}
		
	}
	
	
	public int getFontWidth() {
		return fontWidth;
	}	
	
	public BufferedImage getLobby() {
		return lobby;
	}
	
	public BufferedImage[][] getSpriteBase() {
		return spritesBase;
	}
	
	public BufferedImage[] getFont() {
		return font;
	}
	
	public BufferedImage[][] getLobbyHudIcon() {
		return lobbyHudIcon;
	}
	
	public BufferedImage[] getMapBackground() {
		return mapBackground;
	}
	
	public BufferedImage getLobbyHud() {
		return lobbyHud;
	}
	
	public BufferedImage getBancone() {
		return bancone;
	}
	
	public BufferedImage getBancone2() {
		return bancone2;
	}
	
	public BufferedImage getScrollButton(){
		return scrollButton;
	}
	
	public BufferedImage[] getDrop() {
		return drop;
	}

	public BufferedImage[] getFontSmall() {
		return fontSmall;
	}

	public BufferedImage getMapHud() {
		return mapHud;
	}

	public BufferedImage getInventoryMenu() {
		return inventoryMenu;
	}

	public BufferedImage getAlchemistMenu() {
		return alchemistMenu;
	}

	public BufferedImage getBlacksmithMenu() {
		return blacksmithMenu;
	}

	public BufferedImage getEnchanterMenu() {
		return enchanterMenu;
	}

	public BufferedImage getMerchantMenu() {
		return merchantMenu;
	}

	public BufferedImage getPauseMenu() {
		return pauseMenu;
	}

	public BufferedImage getTrasherMenu() {
		return trasherMenu;
	}

	public int getSmallFontWidth() {
		return smallFontWidth;
	}
	
}
