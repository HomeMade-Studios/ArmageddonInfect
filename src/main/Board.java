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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
	FontExt font;
	Input input;
	Drop drop;
	SavedData save;
	Inventory inventory;
	Random rand = new Random();
	ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private Timer timer;
	boolean isInLobby = true;
	boolean levelUp = false;
	boolean inventoryWindow = false,stats = false,equipment=false;
	boolean dropped;
	boolean firstTime = true;
    String filename = "character.sav";
    File f = new File(filename);
    int a = 0;
	int screenWidth;
	int screenHeight;
	int oldMouseX, oldMouseY;
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
        spawnFrequency = 100;
        wave = 0;
        waveFinish = 0;
        font=new FontExt();
        input=new Input();
        inventory=new Inventory();
        drop = new Drop();
        character=new Character(screenWidth, screenHeight);
        enemy=new Enemy(wave);
        lobby=new Lobby();
        hud= new HUD(screenWidth, screenHeight);
        loader= new ImgLoader();
        if (f.exists() && !f.isDirectory()){
        	load();
        	}
        else{
        	save= new SavedData();}
        timer = new Timer (5 , this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
	    
        if(isInLobby){
        	g2d.drawImage(loader.getLobby(), -(1018 - screenWidth)/2, -(672 - screenHeight)/2, null);  
        	g2d.drawImage(loader.getBancone2(),-(1018 - screenWidth)/2, -(672 - screenHeight)/2, null);
        	g2d.drawImage(loader.getSpriteBase()[character.getPov()][character.getAn()],character.getX(),character.getY(),null);
        	g2d.drawImage(loader.getBancone(),-(1018 - screenWidth)/2, -(672 - screenHeight)/2, null);
        	if(input.isInventory()){
        		g2d.drawImage(loader.getInventoryMenu(), inventory.getX(), inventory.getY(), null);
        		g2d.drawImage(loader.getScrollButton(), inventory.getX()+274, inventory.getY()+15, null);
        		g2d.drawImage(loader.getScrollButton(), inventory.getX()+88, inventory.getY()+40, null);
        		for(int i=0;i<inventory.getDrop().size();i++){
        			g2d.drawImage(loader.getDrop()[inventory.getDrop().get(i)], inventory.getX()+103, inventory.getY()+9+i*35, null);
        			g2d.drawString(inventory.getDropName().get(i)+" ["+inventory.getDropNumber().get(i)+"]", inventory.getX()+140, inventory.getY()+28+i*36);
        		}
        	}
        	g2d.drawImage(loader.getLobbyHud(), hud.getX(), hud.getY(), null);
        	for(int i=0; i<hud.getIconsHB().length; i++){
        		if(hud.getIconsHB()[i].intersects(mouse.getMousePos())){
        			g2d.drawImage(loader.getLobbyHudIcon()[0][i], hud.getX()+10+i*106, hud.getY()+53, null);
        		}
        		else{
        			g2d.drawImage(loader.getLobbyHudIcon()[1][i], hud.getX()+10+i*106, hud.getY()+53, null);
        		}
        	}
        }
        else{
        	g2d.drawImage(loader.getMapBackground()[0],-(1920 - screenWidth)/2, -(1080 - screenHeight)/2,null);
        	g2d.drawImage(loader.getSpriteBase()[character.getPov()][character.getAn()],character.getX(),character.getY(),null);
    	    for(int i = 0; i < enemies.size(); i++){
    	       	g2d.drawImage(loader.getSpriteBase()[enemies.get(i).getP()][enemies.get(i).getAn()], enemies.get(i).getX(), enemies.get(i).getY(), null);
    	        g2d.setColor(Color.BLACK);
    	    	g2d.draw(enemies.get(i).getEnemyHealth());
    	        g2d.setColor(Color.RED);
    	        g2d.fill(new Rectangle((int)enemies.get(i).getEnemyHealth().getX(),(int) enemies.get(i).getEnemyHealth().getY(), (int)((float)enemies.get(i).getHealth()*0.2), (int)enemies.get(i).getEnemyHealth().getHeight()));
    	        
    	    } 
    	    g2d.drawImage(loader.getMapHud(), hud.getX(), hud.getY(), null);
	        g2d.setColor(Color.GREEN);
		    g2d.fill(new Rectangle(hud.getX()+34, hud.getY()+68, (int)hud.getH1(), 18));
		    g2d.fill(new Rectangle(hud.getX()+242, hud.getY()+4+hud.getH2y(), 18, (int)hud.getH2()));
		    if(dropped){
			    g2d.setColor(Color.BLACK);
			    g2d.drawString(drop.getText(), 50, 652);
			    g2d.drawImage(loader.getDrop()[drop.getN()], 10, 630, null);
			    a++;
			    if(a==250){
			    	dropped = false;
			    	a=0;
			    }
		    }
        }
	    g2d.setColor(Color.CYAN);
	    for(int i = 0; i < hud.getExpBox(); i++){
	    	g2d.fill(new Rectangle(hud.getX()+48+i*24, hud.getY()+95, 20, 8));
	    }
	    g2d.fill(new Rectangle(hud.getX()+48, hud.getY()+106, hud.getExpBar(), 7));
	    
		String level="Level "+ character.getLevel();																					//Crea la stringa per l'input
		font.input(level);																												//Crea arraylist con i valori giusti per il for
		for (int i = 0; i <level.length(); i++)																							//Inserire come valore massimo contatore lunghezza stringa
		{
	    	g2d.drawImage(loader.getFont()[font.returnString().get(i)], hud.getX()+(i*loader.getFontWidth())+i, hud.getY(), null);		//Come posizione lasciare i*loader.getFontWidth() e aggiungere le coordinate altrimenti i caratteri si sovrappongono
		}
		font.clear();																													//Pulizia arraylist, altrimenti si creerebbe un arraylist infinito
		if(character.isPaused()){
        	g2d.drawImage(loader.getPauseMenu(),-(1920 - screenWidth)/2, -(1080 - screenHeight)/2,null);
        }
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }


	public void actionPerformed(ActionEvent e) {
		if(!input.isPaused()){
			character.move(isInLobby, input.getDx(), input.getDy());
			character.SetP(mouse.getMx(), mouse.getMy());
			character.animationCycle(mouse.isMouseClicked(), input.getDx(), input.getDy());
			if(isInLobby){
				for(int i=0;i<lobby.getLobbyHB().length;i++){
					if(lobby.getLobbyHB()[i].intersects(character.getHitbox())){
						character.stopmove();
					}
				}
				if(character.getHitbox().intersects(lobby.getMapSelection())){
					save();
					isInLobby = false;
				}
				if(mouse.getMousePos().intersects(hud.getIconsHB()[0]) && mouse.isMouseClicked()){
					if(!input.isStats()){
						System.out.println("Stats opened");
						input.setStats(true);
					}
					else{
						System.out.println("Stats closed");
						input.setStats(false);
					}
					mouse.setClicked(false);
				}
				else if(mouse.getMousePos().intersects(hud.getIconsHB()[1]) && mouse.isMouseClicked()){
					if(!input.isEquipment()){
						System.out.println("Equipment opened");
						input.setEquipment(true);
					}
					else{
						System.out.println("Equipment closed");
						input.setEquipment(false);
					}
					mouse.setClicked(false);
				}
				else if(mouse.getMousePos().intersects(hud.getIconsHB()[2]) && mouse.isMouseClicked()){
					if(!input.isInventory()){
						input.setInventory(true);
					}
					else{
						input.setInventory(false);
					}
					mouse.setClicked(false);
				}
				if(input.isInventory()){
					if((mouse.getMousePos().intersects(inventory.getInventoryDrag())||inventory.isDragging())&&mouse.isMouseClicked()){	
						inventory.inventoryWindowMove(mouse.getMx()-180,mouse.getMy());
					}
					System.out.println(inventory.getX()+" "+inventory.getY());
					if(!mouse.isMouseClicked()||!mouse.getMousePos().intersects(inventory.getInventoryDrag()))
						inventory.setDragging(false);
				}
				else
					inventory.updateInventory();
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
		        		if(enemies.get(i).getDrop() == 0){
		        			drop.obtainItem();
		        			dropped = true;
		        			inventory.addDrop(drop.getN(),drop.getName().get(drop.getN()));
		        		}
		        		enemies.remove(i);
		        		character.setExp(character.getExp() + 500);
		        	}
		        	
		    	}
		    	mouse.setClicked(false);
		    	if(character.getHealt() <= 0){
		    		isInLobby = true;
		    		save();
		    		reset();
		    		load();
		    	}
			}
			if(hud.updateHUD(character.getHealt(),character.getHealtMax(), character.getExp(),character.getMaxExp())){
				character.setLevel(character.getLevel()+1);
				character.setExp(character.getExp()-character.getMaxExp()*10);
			};
		    
		}
		repaint();
    }
	
	private void reset(){
		spawnFrequency = 150;
		enemies.clear();
		wave = 0;
		waveFinish = 0;
		character= new Character(screenWidth, screenHeight);
		hud=new HUD(screenWidth, screenHeight);
	}
    
    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
        	input.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
        	input.keyPressed(e);
        }
    }
    
    public void save (){
      	 FileOutputStream fos = null;
      	 ObjectOutputStream out = null;
      	save.setExp(character.getExp());
      	save.setMaxHealt(character.getHealtMax());
      	save.setLevel(character.getLevel());
      	save.setStrength(character.getStrength());
      	save.setDrop(inventory.getDrop());
      	save.setDropName(inventory.getDropName());
      	save.setDropNumber(inventory.getDropNumber());
      	save.setInventoryX(inventory.getX());
      	save.setInventoryY(inventory.getY());
      	 try {
      	   fos = new FileOutputStream(filename);
      	   out = new ObjectOutputStream(fos);
      	   out.writeObject(save);
      	   out.close();
      	 } catch (Exception ex) {
      	   ex.printStackTrace();
      	 }
      }
      public void load (){
      	FileInputStream fis = null;
          ObjectInputStream in = null;
          try {
            fis = new FileInputStream(filename);
            in = new ObjectInputStream(fis);
            save = (SavedData) in.readObject();
            in.close();
          } catch (Exception ex) {
            ex.printStackTrace();
          }        
      	character.setExp(save.getExp());
      	character.setHealtMax(save.getMaxHealt());
      	character.setLevel(save.getLevel());
      	character.setStrength(save.getStrength());
      	inventory.setDrop(save.getDrop());
      	inventory.setDropName(save.getDropName());
      	inventory.setDropNumber(save.getDropNumber());
      	inventory.setX(save.getInventoryX());
      	inventory.setY(save.getInventoryY());
      }
}