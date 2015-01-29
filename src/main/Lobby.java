package main;

import java.awt.Rectangle;

public class Lobby {
	Rectangle mapSelection;
	
	public Lobby(){
		mapSelection = new Rectangle(900,10,100,100);
	}

	public Rectangle getMapSelection() {
		return mapSelection;
	}

}
