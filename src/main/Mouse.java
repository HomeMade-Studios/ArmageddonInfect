package main;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.event.MouseInputListener;


class Mouse implements MouseInputListener {

	private int mx;
	private int my;
	private boolean clicked;
	private Rectangle mousePos;
	
	Mouse(){
		mousePos= new Rectangle(0,0,1,1);
	}
	
	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}

	static Random rand = new Random();

	public void mouseMoved(MouseEvent e) {
        mx = e.getX();
        my = e.getY();
		mousePos= new Rectangle(mx,my,1,1);
    }
	
	public boolean isMouseClicked(){
		if(clicked){
			return true;
		}
		else
			return false;
	}
	
	public Rectangle getMousePos() {
		return mousePos;
	}

	public void setClick(boolean robba){
		this.clicked=robba;
	}
	
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		clicked=true;		
	}

	public void mouseReleased(MouseEvent e) {
		clicked=false;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public int getMx() {
		return mx;
	}

	public int getMy() {
		return my;
	}	
}

