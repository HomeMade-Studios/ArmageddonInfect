package main;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;


@SuppressWarnings("serial")
public class Board extends JPanel implements ActionListener {

	Character character;
	Mouse mouse;
	HUD hud;
	ImgLoader loader;
	Enemy enemy;
	Random rand = new Random();
	ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private Timer timer;
	int screenWidth;
	int screenHeight;
	int spawnFrequency;
	
	public Board(int Width, int Height) {
		screenWidth=Width;
		screenHeight=Height;
		mouse=new Mouse();
    	addMouseMotionListener(mouse);
    	addMouseListener(mouse);
        addKeyListener(new TAdapter());
        setBackground(Color.DARK_GRAY);
        setFocusable(true);
        spawnFrequency = 100;
        character=new Character(screenWidth, screenHeight);
        enemy=new Enemy();
        hud= new HUD(screenWidth, screenHeight,character.getHealt());
        loader= new ImgLoader();
        timer = new Timer (10 , this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.GREEN);
        g2d.drawImage(loader.getSprite()[character.GetP(mouse.getMx(), mouse.getMy())][character.animationCycle(mouse.isMouseClicked())],character.getX(),character.getY(),null);
        for(int i = 0; i < enemies.size(); i++){
        	g2d.drawImage(loader.getSprite()[enemies.get(i).getP()][enemies.get(i).getAn()], enemies.get(i).getX(), enemies.get(i).getY(), null);
        }
        g2d.fill(new Rectangle(hud.getX()+34, hud.getY()+68, (int)hud.getH1(), 18));
        g2d.fill(new Rectangle(hud.getX()+242, hud.getY()+4+hud.getH2y(), 18, (int)hud.getH2()));
        g2d.drawImage(loader.getHUD(), hud.getX(), hud.getY(), null);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
    
    public void actionPerformed(ActionEvent e) {
    	if(rand.nextInt(spawnFrequency) == 1){
    		enemies.add(new Enemy());
    	}
    	character.move();
    	for(int i = 0; i < enemies.size(); i++){
    		enemies.get(i).move(character.getX(), character.getY(), character.getHitbox());
    	}
    	if(enemy.getEnemyHB().intersects(character.getHitbox()))
    		character.attacked(enemy.getStrength());
    	if(enemy.getEnemyHB().intersects(character.getHitbox())&&mouse.isMouseClicked())
    		enemy.attacked(character.getStrength(),character.GetP(mouse.getMx(), mouse.getMy()),character.getX(),character.getY());
    	hud.updateHUD(character.getHealt());
	    repaint();
    }
    
    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
        	character.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
        	character.keyPressed(e);
        }
    }
}