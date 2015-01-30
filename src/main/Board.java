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
	Lobby lobby;
	Random rand = new Random();
	ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private Timer timer;
	boolean isInLobby = true;
	int screenWidth;
	int screenHeight;
	int spawnFrequency;
	int wave,waveFinish;
	
	public Board(int Width, int Height) {
		screenWidth=Width - 6;
		screenHeight=Height - 28;
		mouse=new Mouse();
    	addMouseMotionListener(mouse);
    	addMouseListener(mouse);
        addKeyListener(new TAdapter());
        setBackground(Color.DARK_GRAY);
        setFocusable(true);
        spawnFrequency = 200;
        wave = 0;
        waveFinish = 0;
        character=new Character(screenWidth, screenHeight);
        enemy=new Enemy(wave);
        lobby=new Lobby();
        hud= new HUD(screenWidth, screenHeight);
        loader= new ImgLoader();
        timer = new Timer (10 , this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        if(!character.isPaused()){
        	if(isInLobby){
        		g2d.drawImage(loader.getLobby(), -(1020 - screenWidth)/2, -(700 - screenHeight)/2, null);    
        		g2d.drawImage(loader.getSprite()[character.getPov()][character.getAn()],character.getX(),character.getY(),null);
        	}
        	else{
        		g2d.drawImage(loader.getMapBackground()[0],-(1920 - screenWidth)/2, -(1080 - screenHeight)/2,null);
        		g2d.drawImage(loader.getSprite()[character.getPov()][character.getAn()],character.getX(),character.getY(),null);
    	        for(int i = 0; i < enemies.size(); i++){
    	        	g2d.drawImage(loader.getSprite()[enemies.get(i).getP()][enemies.get(i).getAn()], enemies.get(i).getX(), enemies.get(i).getY(), null);
    	            g2d.setColor(Color.BLACK);
    	    		g2d.draw(enemies.get(i).getEnemyHealth());
    	            g2d.setColor(Color.RED);
    	    		g2d.fill(new Rectangle((int)enemies.get(i).getEnemyHealth().getX(),(int) enemies.get(i).getEnemyHealth().getY(), (int)((float)enemies.get(i).getHealth()*0.2), (int)enemies.get(i).getEnemyHealth().getHeight()));
    	        }
    	        
            }
        	g2d.setColor(Color.GREEN);
	        g2d.fill(new Rectangle(hud.getX()+34, hud.getY()+68, (int)hud.getH1(), 18));
	        g2d.fill(new Rectangle(hud.getX()+242, hud.getY()+4+hud.getH2y(), 18, (int)hud.getH2()));
	        g2d.setColor(Color.CYAN);
	        for(int i = 0; i < hud.getExpBox(); i++){
	        g2d.fill(new Rectangle(hud.getX()+48+i*24, hud.getY()+95, 20, 8));
	        }
	        g2d.fill(new Rectangle(hud.getX()+48, hud.getY()+106, hud.getExpBar(), 7));
	        g2d.drawImage(loader.getHUD(), hud.getX(), hud.getY(), null);
        }
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }


	public void actionPerformed(ActionEvent e) {
		if(!character.isPaused()){
			character.move();
			character.SetP(mouse.getMx(), mouse.getMy());
			character.animationCycle(mouse.isMouseClicked());
			if(isInLobby){
				if(character.getHitbox().intersects(lobby.getMapSelection())){
					isInLobby = false;
				}
			}
			else{
				if(rand.nextInt(spawnFrequency) == 0){
		    		enemies.add(new Enemy(wave));
		    		waveFinish++;
		    		if(waveFinish == 11){
		    			wave++;
		    			waveFinish = 1;
		    		}
		    	}
		    	for(int i = 0; i < enemies.size(); i++){
		    		enemies.get(i).move(character.getX(), character.getY(), character.getHitbox());
		    		if(enemies.get(i).getEnemyHB().intersects(character.getHitbox()))
		        		character.attacked(enemies.get(i).getStrength());
		        	if(enemies.get(i).getEnemyHB().intersects(character.getAttackbox())){
		        		enemies.get(i).attacked(character.getStrength(),character.getPov(),character.getX(),character.getY(),mouse.isMouseClicked());
		        		}
		        	if(enemies.get(i).getHealth() <= 0){
		        		enemies.remove(i);
		        		character.setExp(character.getExp() + 50);
		        	}
		        	
		    	}
		    	mouse.setClick(false);
		    	if(character.getHealt() <= 0){
		    		isInLobby = true;
		    		reset();
		    	}
			}
			hud.updateHUD(character.getHealt(),character.getHealtMax(), character.getExp(),character.getMaxExp());
		    repaint();
		}
    }
	
	private void reset(){
		spawnFrequency = 150;
		enemies.clear();
		character= new Character(screenWidth, screenHeight);
		hud=new HUD(screenWidth, screenHeight);
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