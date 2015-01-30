package main;

import java.awt.Rectangle;

public class Lobby {
	Rectangle mapSelection;
	
	public Lobby(){
		mapSelection = new Rectangle(855,15,100,35);
	}

	public Rectangle getMapSelection() {
		return mapSelection;
	}

}
