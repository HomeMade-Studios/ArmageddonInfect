package main;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImgLoader {
	int width = 32;
	int height = 32;
	int rows = 8;
	int cols = 4;
	BufferedImage[][] spritesBase;
	BufferedImage HUD;
	BufferedImage bigImg;

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
