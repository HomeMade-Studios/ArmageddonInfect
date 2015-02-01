package main;

import java.util.ArrayList;

public class FontExt {
	private ArrayList<Integer> StringAfter;
	private boolean Error;
	
	FontExt(){
		Error=false;
		StringAfter=new ArrayList<Integer>();
	}
	
	public void input(String string){
        for (int i=0;i<string.length();i++){
        	int c=string.charAt(i);
        	if (c>=97){
        		c-=32;
        		}
        	if(c>=65&&c<=90||c>=48&&c<=57||c==32){
	        	if(c>=65&&c<=90){
	        		c-=65;}
	        	else if(c==32){
	        		c+=19;}
	        	else if(c>=48&&c<=57){
	        		c-=22;}
        	}
        	else
        		Error=true;
        	StringAfter.add(c);
        }
        if(Error){
        	System.out.println("Errore nella stringa di input, non inserire simboli.");
        	StringAfter.clear();
        }
	}
	
	public ArrayList<Integer> returnString(){
		return StringAfter;
	}
	
	public void clear(){
		StringAfter.clear();
	}
}
