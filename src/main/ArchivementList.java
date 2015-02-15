package main;

import java.awt.Point;
import java.util.ArrayList;

public class ArchivementList {
	ArrayList<Archivement> archivement = new ArrayList<Archivement>();;
	ArrayList<String> names = new ArrayList<String>();
	ArrayList<String> goals = new ArrayList<String>();
	ArrayList<Point> imagePositions = new ArrayList<Point>();
	
	public ArchivementList(){
		UpdateListNames();
		UpdateListGoals();
		Load();
	}
	
	void Load(){
		for(int i = 0; i < names.size(); i++){
			archivement.add(new Archivement(names.get(i), goals.get(i)));
		}
	}
	
	public void CheckUnlockedArchivement(int enemyKilled){
		if(enemyKilled >= 10)
			archivement.get(0).setUnlocked(true);
	}
	
	public void UpdateListNames(){
		names.add("Begginer Zombie Killer");
	}
	
	public void UpdateListGoals(){
		goals.add("Kill 10 enemies");
	}
	
	public String getArchivementName(int n){
		return archivement.get(n).getName();
	}
	
	public String getArchivementGoal(int n){
		return archivement.get(n).getGoal();
	}
	
	public boolean isArchivementUnlocked(int n){
		return archivement.get(n).isUnlocked();
	}
	
}
