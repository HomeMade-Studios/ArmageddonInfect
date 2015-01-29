package main;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImgLoader {
	private int width = 32;
	private int height = 32;
	private int rows = 8;
	private int cols = 4;
	private BufferedImage[][] spritesBase;
	private BufferedImage HUD;
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
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < rows; i++)
		{
		    for (int j = 0; j < cols; j++)
		    {
		        spritesBase[i][j] = bigImg.getSubimage(
		            j * width,
		            i * height,
		            width,
		            height
		        );
		    }
		}		
	}
	
	public BufferedImage getHUD() {
		return HUD;
	}
	public BufferedImage[][] getSprite() {
		return spritesBase;
	}
}
