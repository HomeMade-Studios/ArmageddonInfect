package main;

import javax.swing.JFrame;

public class Application extends JFrame {
	
	private static final long serialVersionUID = 1L;
	final int screenWidth=1024;
	final int screenHeight=700;
	public Application() {

        add(new Board(screenWidth, screenHeight));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Gestione dell finestra di gioco
        setSize(screenWidth, screenHeight);
        setLocationRelativeTo(null);
        setTitle("Armageddon Infect");
        setResizable(false);
        setVisible(true);

    }

    public static void main(String[] args)	 {
        new Application();
    }
}
