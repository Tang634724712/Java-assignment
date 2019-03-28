package models;


import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


// public class OompaLoompaSong
public class OompaLoompaSong{
	
	private ArrayList<String> linesOfSong;

	
	private int lines;
	private String song = "";
	//Constructors:
	// define how many lines  the song shall have
	public OompaLoompaSong(int lines){
		this.lines=lines;
	}       
	
	public int getLinesOfOompaLoompaSong(){
		return this.lines;
	}
	
	// Return a String with the song
	public String sing(){
		linesOfSong = new ArrayList<String>();
		String line;
        String fileName = "OompaLoompaSong.txt";
		
		try{
            BufferedReader br =  new BufferedReader(new FileReader(fileName));
			StringBuilder sb = new StringBuilder();
			//line = br.readLine();	
			
			while ((line = br.readLine()) != null) {
                linesOfSong.add(line);
			}
			br.close(); 
		}
		catch(IOException e){
			System.out.println("Sorry, we couldn't make this song! ");
		}
		RandomSong();
		return song;
	}

	public void RandomSong( ){
		for(int i=0;i<lines;i++){
			song = song.concat(linesOfSong.get(i));
			song = song.concat(System.lineSeparator());
		}
	}
	
}