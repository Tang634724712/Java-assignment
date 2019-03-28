package models;

import java.util.Date;


public class GoldenTicket{
	
	private String code;
	private Date raffled;
	
	//Constructors:
	public GoldenTicket(){}  // emptty constructor
	public GoldenTicket(String code, Date raffled){   //constructor with arguments
		this.code=code;
		this.raffled=raffled;
	}

	// Getters and Setters
	public String getCode(){
		return code;
	}
	
	public void setCode(String code){
		this.code=code;
	}
	
	public Date getRaffled(){
		return raffled;
	}
	
	public void setRaffled(){
		this.raffled=raffled;
	}
	// If the current ticket has been already raffled
	public boolean isRaffled(){
		return raffled!=null;
	}
}