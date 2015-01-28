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
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;


@SuppressWarnings("serial")
public class Board extends JPanel implements ActionListener {

	Character cazzillo;
	HUD hud;
	ImgLoader loader;
	Random rand = new Random();
	private Timer timer;
	int screenWidth;
	int screenHeight;
	
	public Board(int Width, int Height) {
		screenWidth=Width;
		screenHeight=Height;
    	addMouseMotionListener(new Mouse());
    	addMouseListener(new Mouse());
        addKeyListener(new TAdapter());
        setBackground(Color.DARK_GRAY);
        setFocusable(true);
        cazzillo=new Character();
        hud= new HUD(screenWidth, screenHeight,cazzillo.getHealt());
        loader= new ImgLoader();
        timer = new Timer (10 , this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.GREEN);
        g2d.fill(new Rectangle(hud.getX()+34, hud.getY()+68, (int)hud.getH1(), 18));
        g2d.fill(new Rectangle(hud.getX()+242, hud.getY()+4+hud.getH2y(), 18, (int)hud.getH2()));
        g2d.drawImage(loader.getHUD(), hud.getX(), hud.getY(), null);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
    
    
    public void actionPerformed(ActionEvent e) {
    		hud.updateHUD(cazzillo.getHealt());
	    	repaint();
    }
    
    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
        	cazzillo.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
        	cazzillo.keyPressed(e);
        }
    }
}