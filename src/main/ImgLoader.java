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
	private BufferedImage[] equip;
	private BufferedImage mapBackground[];
	private BufferedImage mapHud;
	private BufferedImage lobby;
	private BufferedImage lobbyHud;
	private BufferedImage bigImg;
	private BufferedImage bancone;
	private BufferedImage bancone2;
	private BufferedImage scrollButton;
	private BufferedImage equipMenu;
	private BufferedImage inventoryMenu;
	private BufferedImage alchemistMenu;
	private BufferedImage craftingMenu;
	private BufferedImage enchanterMenu;
	private BufferedImage merchantMenu;
	private BufferedImage pauseMenu;
	private BufferedImage trasherMenu;
	private BufferedImage buyButton;
	private BufferedImage closeMenuButton;
	private BufferedImage combineButton;
	private BufferedImage craftButton;
	private BufferedImage equipButton;
	private BufferedImage equipButtonPressed;
	private BufferedImage enchantButton;
	private BufferedImage recycleButton;
	
	
	

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
			lobby=ImageIO.read(getClass().getResource("/img/Tavern/Tavern.png"));
			bancone=ImageIO.read(getClass().getResource("/img/Tavern/tavern_bancone.png"));
			bancone2=ImageIO.read(getClass().getResource("/img/Tavern/tavern_bancone_sotto.png"));
			scrollButton=ImageIO.read(getClass().getResource("/img/Menu/Buttons/scroll_button.png"));
			buyButton=ImageIO.read(getClass().getResource("/img/Menu/Buttons/buy_button.png"));
			closeMenuButton=ImageIO.read(getClass().getResource("/img/Menu/Buttons/close_menu_button.png"));
			combineButton=ImageIO.read(getClass().getResource("/img/Menu/Buttons/combine_button.png"));
			craftButton=ImageIO.read(getClass().getResource("/img/Menu/Buttons/craft_button.png"));
			enchantButton=ImageIO.read(getClass().getResource("/img/Menu/Buttons/enchant_button.png"));
			recycleButton=ImageIO.read(getClass().getResource("/img/Menu/Buttons/recycle_button.png"));
			inventoryMenu=ImageIO.read(getClass().getResource("/img/Menu/inventory_menu.png"));
			equipMenu=ImageIO.read(getClass().getResource("/img/Menu/equip_menu.png"));
			alchemistMenu=ImageIO.read(getClass().getResource("/img/Menu/alchemist_menu.png"));
			craftingMenu=ImageIO.read(getClass().getResource("/img/Menu/blacksmith_menu.png"));
			enchanterMenu=ImageIO.read(getClass().getResource("/img/Menu/enchanter_menu.png"));
			merchantMenu=ImageIO.read(getClass().getResource("/img/Menu/merchant_menu.png"));
			trasherMenu=ImageIO.read(getClass().getResource("/img/Menu/trasher_menu.png"));
			pauseMenu=ImageIO.read(getClass().getResource("/img/Menu/pause_menu.png"));
			equipButton=ImageIO.read(getClass().getResource("/img/Menu/Buttons/equip_button.png")).getSubimage(0,0, 56, 23);
			equipButtonPressed=ImageIO.read(getClass().getResource("/img/Menu/Buttons/equip_button.png")).getSubimage(0,23, 56, 23);
						
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
		
		try {
			width = 32;
			height = 32;
			rows=16;
			cols=16;
			equip=new BufferedImage [rows*cols];
			bigImg = ImageIO.read(getClass().getResource("/img/Menu/Icons/equip_icons.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < rows; i++)
		{
		    for (int j = 0; j < cols; j++)
		    {
		        equip[(i * cols) + j] = bigImg.getSubimage(j * width, i * height, width, height);
		    }
		}
	}
	
	
	public BufferedImage getEquipButton() {
		return equipButton;
	}

	public BufferedImage getEquipButtonPressed() {
		return equipButtonPressed;
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
	
	public BufferedImage[] getEquip() {
		return equip;
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

	public BufferedImage getCraftingMenu() {
		return craftingMenu;
	}

	public BufferedImage getEnchanterMenu() {
		return enchanterMenu;
	}

	public BufferedImage getMerchantMenu() {
		return merchantMenu;
	}
	
	public BufferedImage getEquipMenu() {
		return equipMenu;
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

	public BufferedImage getBuyButton() {
		return buyButton;
	}

	public BufferedImage getCloseMenuButton() {
		return closeMenuButton;
	}

	public BufferedImage getCombineButton() {
		return combineButton;
	}

	public BufferedImage getCraftButton() {
		return craftButton;
	}

	public BufferedImage getEnchantButton() {
		return enchantButton;
	}

	public BufferedImage getRecycleButton() {
		return recycleButton;
	}
	
	
}
