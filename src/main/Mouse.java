package main;

import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.event.MouseInputListener;


class Mouse implements MouseInputListener {

	private int mx;
	private int my;
	private boolean clicked;
	static Random rand = new Random();

	public void mouseMoved(MouseEvent e) {
        mx = e.getX();
        my = e.getY();
    }
	
	public boolean isMouseClicked(){
		if(clicked){
			clicked=false;
			return true;
		}
		else
			return false;
	}
	
	public void mouseClicked(MouseEvent arg0) {
		clicked=true;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
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

