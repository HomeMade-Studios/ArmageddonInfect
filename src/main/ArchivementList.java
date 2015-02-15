package main;

import java.awt.Point;
import java.util.ArrayList;

public class ArchivementList {
	ArrayList<Archivement> archivement = new ArrayList<Archivement>();;
	ArrayList<String> names = new ArrayList<String>();
	ArrayList<Point> imagePositions = new ArrayList<Point>();
	
	public ArchivementList(){
		UpdateListNames();
		UpdateListPoint();
		Load();
	}
	
	void Load(){
		for(int i = 0; i < names.size(); i++){
			archivement.add(new Archivement(names.get(i), imagePositions.get(i)));
		}
		
	}
	
	public void UpdateListNames(){
		names.add("Kill 10 enemies");
	}
	
	public void UpdateListPoint(){
		imagePositions.add(new Point(100,100));
	}
	
}
