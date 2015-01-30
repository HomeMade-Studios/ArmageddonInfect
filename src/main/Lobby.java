package main;

import java.awt.Rectangle;

public class Lobby {
	Rectangle mapSelection;
	
	public Lobby(){
		mapSelection = new Rectangle(855,0,100,45);
	}

	public Rectangle getMapSelection() {
		return mapSelection;
	}

}
