package main;

import java.awt.Rectangle;

public class Lobby {
	Rectangle mapSelection;
	Rectangle lobbyHB[];
	
	public Lobby(){
		mapSelection = new Rectangle(855,0,100,45);
		lobbyHB = new Rectangle[5];
		lobbyHB[0] = new Rectangle(0,0,1018,45);
		lobbyHB[1] = new Rectangle(419,0,5,198);
		lobbyHB[2] = new Rectangle(73,198,351,45);
		lobbyHB[3] = new Rectangle(73,198,5,127);
		lobbyHB[4] = new Rectangle(77,305,347,8);
	}

	public Rectangle getMapSelection() {
		return mapSelection;
	}
	
	public Rectangle[] getLobbyHB() {
		return lobbyHB;
	}

}
