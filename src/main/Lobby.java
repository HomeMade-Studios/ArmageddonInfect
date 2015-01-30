package main;

import java.awt.Rectangle;

public class Lobby {
	Rectangle mapSelection;
	Rectangle lobbyHB[];
	
	public Lobby(){
		mapSelection = new Rectangle(855,0,100,45);
		lobbyHB = new Rectangle[1];
		lobbyHB[0] = new Rectangle(0,0,1018,45);
	}

	public Rectangle getMapSelection() {
		return mapSelection;
	}
	
	public Rectangle[] getLobbyHB() {
		return lobbyHB;
	}

}
