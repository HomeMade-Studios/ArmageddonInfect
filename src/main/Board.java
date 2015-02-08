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

	Mouse mouse;
	HUD hud;
	ImgLoader loader;
	Enemy enemy;
	Lobby lobby;
	FontExt font;
	Input input;
	Drop drop;
	Craft craft;
	SavedData save;
	Inventory inventory;
	Equip equip;
	Equippable equippable;
	Random rand = new Random();
	ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	ArrayList<Character> character = new ArrayList<Character>();
	private Timer timer;
	boolean isInLobby = true;
	boolean levelUp = false;
	boolean inventoryMenu = false,statsMenu = false,equipmentMenu=false,craftMenu=false;
	boolean dropped,addedequip=false;
	boolean firstTime = true;
    String filename = "character.sav";
    File f = new File(filename);
    int a = 0;
	int screenWidth;
	int screenHeight;
	int oldMouseX, oldMouseY;
	int spawnFrequency;
	int wave,waveFinish;
	int characterSelected;
	
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
        equip=new Equip();
        craft=new Craft();
        equippable=new Equippable();
        drop = new Drop();
        characterSelected = 0;
        character.add(new Cazzillo(screenWidth, screenHeight));
        character.add(new Engineer(screenWidth, screenHeight));
        enemy=new Enemy(wave);
        lobby=new Lobby();
        hud= new HUD(screenWidth, screenHeight);
        loader= new ImgLoader();
        if (f.exists() && !f.isDirectory()){
        	load();
        	}
        else{
        	save= new SavedData();}
        timer = new Timer (10 , this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
	    
        if(isInLobby){
	        g2d.setColor(Color.BLACK);
        	g2d.drawImage(loader.getLobby(), -(1018 - screenWidth)/2, -(672 - screenHeight)/2, null);  
        	g2d.drawImage(loader.getBancone2(),-(1018 - screenWidth)/2, -(672 - screenHeight)/2, null);
        	g2d.drawImage(loader.getCharacter()[character.get(characterSelected).getPov()][character.get(characterSelected).getAn()],character.get(characterSelected).getX(),character.get(characterSelected).getY(),null);
        	g2d.drawImage(loader.getBancone(),-(1018 - screenWidth)/2, -(672 - screenHeight)/2, null);
        	if(input.isCraftingMenu()){
        		g2d.drawImage(loader.getCraftingMenu(), craft.getX(), craft.getY(), null);
        	}
        	if(input.isInventory()){
        		g2d.drawImage(loader.getInventoryMenu(), inventory.getX(), inventory.getY(), null);
        		g2d.drawImage(loader.getScrollButton(), inventory.getScrollX(), inventory.getScrollY(), null);
        		g2d.drawImage(loader.getScrollButton(), inventory.getX()+88, inventory.getY()+40, null);
        		for(int i=0;i<5;i++){
        			if(inventory.getDrop().size() < i+inventory.getPage()*5+1) break;
        			g2d.drawImage(loader.getDrop()[inventory.getDrop().get(i+(inventory.getPage()*5))], inventory.getX()+103, inventory.getY()+9+i*36, null);
        			g2d.drawString(inventory.getDropName().get(i+(inventory.getPage()*5))+" ["+inventory.getDropNumber().get(i+(inventory.getPage()*5))+"]", inventory.getX()+140, inventory.getY()+28+i*36);
        		}
        	}
        	if(input.isEquipmentMenu()){
        		g2d.drawImage(loader.getEquipMenu(), equip.getX(), equip.getY(), null);
        		g2d.drawImage(loader.getScrollButton(), equip.getScrollX(), equip.getScrollY(), null);
        		if(!equip.isIsequipping())
        			g2d.drawImage(loader.getEquipButtonPressed(), equip.getX()+356, equip.getY()+175, null);
        		else
            		g2d.drawImage(loader.getEquipButton(), equip.getX()+356, equip.getY()+175, null);
        		for(int i=0;i<5;i++){
        			if(equip.getEquip().size() < i+equip.getPage()*5+1) break;
        			g2d.drawImage(loader.getEquip()[equip.getEquip().get(i+(equip.getPage()*5))], equip.getX()+8+96, equip.getY()+21+(i*35)+i, null);
        			g2d.drawString(equip.getEquipName().get(i+(equip.getPage()*5)), equip.getX()+46+96, equip.getY()+40+i*36);
        		}
        		if(equip.getEquipWear().get(0)!=null)
        			g2d.drawImage(loader.getEquip()[equip.getEquipWear().get(0)], equip.getX()+194+96, equip.getY()+95, null);
        		if(equip.getEquipWear().get(1)!=null)
        			g2d.drawImage(loader.getEquip()[equip.getEquipWear().get(1)], equip.getX()+194+96, equip.getY()+60, null);
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
        	
		    if(addedequip){
			    g2d.setColor(Color.WHITE);
			    g2d.drawString(equippable.getText(), 50, 652);
			    g2d.drawImage(loader.getEquip()[equippable.getN()], 10, 630, null);
			    a++;
			    if(a==250){
			    	addedequip = false;
			    	a=0;
			    }
		    }
        }
        else{
        	g2d.drawImage(loader.getMapBackground()[0],-(1920 - screenWidth)/2, -(1080 - screenHeight)/2,null);
        	g2d.drawImage(loader.getCharacter()[character.get(characterSelected).getPov()][character.get(characterSelected).getAn()],character.get(characterSelected).getX(),character.get(characterSelected).getY(),null);
    	    for(int i = 0; i < enemies.size(); i++){
    	       	g2d.drawImage(loader.getEnemy()[enemies.get(i).getP()][enemies.get(i).getAn()], enemies.get(i).getX(), enemies.get(i).getY(), null);
    	        g2d.setColor(Color.BLACK);
    	    	g2d.draw(enemies.get(i).getEnemyHealth());
    	        g2d.setColor(Color.RED);
    	        g2d.fill(new Rectangle((int)enemies.get(i).getEnemyHealth().getX(),(int) enemies.get(i).getEnemyHealth().getY(), (int)((float)enemies.get(i).getHealth()*0.2), (int)enemies.get(i).getEnemyHealth().getHeight()));
    	    } 
	        g2d.setColor(Color.GREEN);
		    g2d.fill(new Rectangle(hud.getX()+34, hud.getY()+68, (int)hud.getH1(), 18));
		    g2d.fill(new Rectangle(hud.getX()+242, hud.getY()+4+hud.getH2y(), 18, (int)hud.getH2()));
		    g2d.setColor(Color.CYAN);
		    for(int i = 0; i < hud.getExpBox(); i++){
		    	g2d.fill(new Rectangle(hud.getX()+48+i*24, hud.getY()+95, 20, 8));
		    }
		    g2d.fill(new Rectangle(hud.getX()+48, hud.getY()+106, hud.getExpBar(), 7));
		    g2d.drawImage(loader.getMapHud(), hud.getX(), hud.getY(), null);
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
		/*String level="Level "+ character.getLevel();																					//Crea la stringa per l'input
		font.input(level);																												//Crea arraylist con i valori giusti per il for
		for (int i = 0; i <level.length(); i++)																							//Inserire come valore massimo contatore lunghezza stringa
		{
	    	g2d.drawImage(loader.getFont()[font.returnString().get(i)], hud.getX()+(i*loader.getFontWidth())+i, hud.getY(), null);		//Come posizione lasciare i*loader.getFontWidth() e aggiungere le coordinate altrimenti i caratteri si sovrappongono
		}
		font.clear();	*/																												//Pulizia arraylist, altrimenti si creerebbe un arraylist infinito
		if(!isInLobby){
	    String level=""+character.get(characterSelected).getLevel();																					//Crea la stringa per l'input
		font.input(level);																												//Crea arraylist con i valori giusti per il for
		for (int i = 0; i <level.length(); i++)																							//Inserire come valore massimo contatore lunghezza stringa
		{
	    	g2d.drawImage(loader.getFontSmall()[font.returnString().get(i)], hud.getX()+(i*loader.getSmallFontWidth())+i+146, hud.getY()+53, null);		//Come posizione lasciare i*loader.getFontWidth() e aggiungere le coordinate altrimenti i caratteri si sovrappongono
		}
		font.clear();
		}
		if(input.isPaused()){
        	g2d.drawImage(loader.getPauseMenu(),-(1920 - screenWidth)/2, -(1080 - screenHeight)/2,null);
        }
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }


	public void actionPerformed(ActionEvent e) {
		if(!input.isPaused()){
			character.get(characterSelected).move(isInLobby, input.getDx(), input.getDy());
			character.get(characterSelected).SetP(mouse.getMx(), mouse.getMy());
			character.get(characterSelected).animationCycle(mouse.isMouseClicked(), input.getDx(), input.getDy());
			if(isInLobby){
				for(int i=0;i<lobby.getLobbyHB().length;i++){
					if(lobby.getLobbyHB()[i].intersects(character.get(characterSelected).getHitbox())){
						character.get(characterSelected).stopmove();
					}
				}
				if(character.get(characterSelected).getHitbox().intersects(lobby.getMapSelection())){
					save();
					isInLobby = false;
				}
				if(mouse.getMousePos().intersects(hud.getIconsHB()[0]) && mouse.isMouseClicked()){
					if(!input.isStatsMenu()){
						System.out.println("Stats opened");
						input.setStatsMenu(true);
					}
					else{
						System.out.println("Stats closed");
						input.setStatsMenu(false);
					}
					mouse.setClicked(false);
				}
				else if(mouse.getMousePos().intersects(hud.getIconsHB()[1]) && mouse.isMouseClicked()){
					if(!input.isEquipmentMenu()){
						System.out.println("Equipment opened");
						input.setEquipmentMenu(true);
					}
					else{
						System.out.println("Equipment closed");
						input.setEquipmentMenu(false);
					}
					mouse.setClicked(false);
				}
				else if(mouse.getMousePos().intersects(hud.getIconsHB()[2]) && mouse.isMouseClicked()){
					if(!input.isInventory()){
						input.setInventoryMenu(true);
					}
					else{
						input.setInventoryMenu(false);
					}
					mouse.setClicked(false);
				}
				if(input.isInventory()){
					if((mouse.getMousePos().intersects(inventory.getInventoryDrag())||inventory.isDragging())&&mouse.isMouseClicked()){	
						inventory.inventoryWindowMove(mouse.getMx()-180,mouse.getMy());
					}
					else
						inventory.setDragging(false);
					if(mouse.isMouseClicked() && mouse.getMousePos().intersects(inventory.getInventoryScrollClick())){
						inventory.inventoryScrollMove(mouse.getMy(), inventory.drop.size());
						mouse.setClicked(false);
					}
					
				}
				else
					inventory.updateInventory();
				
				if(input.isEquipmentMenu()){
					if((mouse.getMousePos().intersects(equip.getEquipDrag())||equip.isDragging())&&mouse.isMouseClicked()){	
						equip.inventoryWindowMove(mouse.getMx()-161,mouse.getMy()-5);
					}
					else
						equip.setDragging(false);
					if(mouse.isMouseClicked() && mouse.getMousePos().intersects(inventory.getInventoryScrollClick())){
						equip.equipScrollMove(mouse.getMy(), equip.equip.size());
						mouse.setClicked(false);
					}
					for(int i=0; i<5;i++)
						if(mouse.getMousePos().intersects(equip.getEquippingItem().get(i))&&mouse.isMouseClicked())
							equip.setEquipping(true,i);
					if(mouse.getMousePos().intersects(equip.getConfirmEquip())&&mouse.isMouseClicked()&&equip.isIsequipping()){
						if(equip.getEquipWear().get(0)!=null)
							character.get(characterSelected).wearEquip(0, equippable.getForce().get(equip.getEquipWear().get(0)));
						if(equip.getEquipWear().get(1)!=null)
							character.get(characterSelected).wearEquip(1, equippable.getForce().get(equip.getEquipWear().get(1)));
						equip.setIsequipping(false);
						}
				}
				else
					equip.updateEquip();
				if(input.addedEquip()){
					equippable.obtainItem(0);
					addedequip=true;
					equip.addEquip(equippable.getN(),equippable.getName().get(equippable.getN()),equippable.getType().get(equippable.getN()));
					equippable.obtainItem(1);
					addedequip=true;
					equip.addEquip(equippable.getN(),equippable.getName().get(equippable.getN()),equippable.getType().get(equippable.getN()));
					equippable.obtainItem(2);
					addedequip=true;
					equip.addEquip(equippable.getN(),equippable.getName().get(equippable.getN()),equippable.getType().get(equippable.getN()));
					equippable.obtainItem(3);
					addedequip=true;
					equip.addEquip(equippable.getN(),equippable.getName().get(equippable.getN()),equippable.getType().get(equippable.getN()));
					equippable.obtainItem(4);
					addedequip=true;
					equip.addEquip(equippable.getN(),equippable.getName().get(equippable.getN()),equippable.getType().get(equippable.getN()));
					equippable.obtainItem(5);
					addedequip=true;
					equip.addEquip(equippable.getN(),equippable.getName().get(equippable.getN()),equippable.getType().get(equippable.getN()));
				}
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
		    		enemies.get(i).move(character.get(characterSelected).getX(), character.get(characterSelected).getY(), character.get(characterSelected).getHitbox());
		    		if(enemies.get(i).getEnemyHB().intersects(character.get(characterSelected).getHitbox()))
		    			character.get(characterSelected).attacked(enemies.get(i).getStrength());
		        	if(enemies.get(i).getEnemyHB().intersects(character.get(characterSelected).getAttackbox())){
		        		enemies.get(i).attacked(character.get(characterSelected).getStrength(),character.get(characterSelected).getPov(),character.get(characterSelected).getX(),character.get(characterSelected).getY(),mouse.isMouseClicked());
		        		}
		        	if(enemies.get(i).getHealth() <= 0){
		        		if(enemies.get(i).getDrop() == 0){
		        			drop.obtainItem();
		        			dropped = true;
		        			inventory.addDrop(drop.getN(),drop.getName().get(drop.getN()));
		        		}
		        		enemies.remove(i);
		        		character.get(characterSelected).setExp(character.get(characterSelected).getExp() + 500);
		        	}
		        	
		    	}
		    	mouse.setClicked(false);
		    	if(character.get(characterSelected).getHealt() <= 0){
		    		isInLobby = true;
		    		save();
		    		reset();
		    		load();
		    	}
			}
			if(hud.updateHUD(character.get(characterSelected).getHealt(),character.get(characterSelected).getHealtMax(), character.get(characterSelected).getExp(),character.get(characterSelected).getMaxExp())){
				character.get(characterSelected).setLevel(character.get(characterSelected).getLevel()+1);
				character.get(characterSelected).setExp(character.get(characterSelected).getExp()-character.get(characterSelected).getMaxExp()*10);
			};
		    
		}
		repaint();
    }
	
	private void reset(){
		spawnFrequency = 150;
		enemies.clear();
		wave = 0;
		waveFinish = 0;
		ArrayList<Character> character = new ArrayList<Character>();
		character.add(new Cazzillo(screenWidth, screenHeight));
        character.add(new Engineer(screenWidth, screenHeight));
		if(equip.getEquipWear().get(0)!=null)
			character.get(characterSelected).wearEquip(0, equippable.getForce().get(equip.getEquipWear().get(0)));
		if(equip.getEquipWear().get(1)!=null)
			character.get(characterSelected).wearEquip(1, equippable.getForce().get(equip.getEquipWear().get(1)));
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
      	save.setExp(character.get(characterSelected).getExp());
      	save.setMaxHealt(character.get(characterSelected).getHealtMax());
      	save.setLevel(character.get(characterSelected).getLevel());
      	save.setStrength(character.get(characterSelected).getStrength());
      	save.setDrop(inventory.getDrop());
      	save.setDropName(inventory.getDropName());
      	save.setDropNumber(inventory.getDropNumber());
      	save.setInventoryX(inventory.getX());
      	save.setInventoryY(inventory.getY());
      	save.setEquip(equip.getEquip());
      	save.setEquipName(equip.getEquipName());
      	save.setEquipType(equip.getEquipType());
      	save.setEquipWear(equip.getEquipWear());
      	save.setAddHealtChar(character.get(characterSelected).getAddhp());
      	save.setAddStrengthChar(character.get(characterSelected).getAddStrength());
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
        }catch (Exception ex) {
          ex.printStackTrace();
        }        
        character.get(characterSelected).setExp(save.getExp());
        character.get(characterSelected).setHealtMax(save.getMaxHealt());
      	character.get(characterSelected).setLevel(save.getLevel());
      	character.get(characterSelected).setStrength(save.getStrength());
      	inventory.setDrop(save.getDrop());
      	inventory.setDropName(save.getDropName());
      	inventory.setDropNumber(save.getDropNumber());
      	inventory.setX(save.getInventoryX());
      	inventory.setY(save.getInventoryY());
      	equip.setEquip(save.getEquip());
      	equip.setEquipName(save.getEquipName());
      	equip.setEquipType(save.getEquipType());
      	equip.setEquipWear(save.getEquipWear());
      	character.get(characterSelected).setAddhp(save.getAddHealtChar());
      	character.get(characterSelected).setAddStrength(save.getAddStrengthChar());
      }
}