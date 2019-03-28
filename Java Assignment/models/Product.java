package models;

import models.GoldenTicket;
public class Product{
	
	private String description;
	private long barcode;
	private String serialNumber;
	private GoldenTicket prizeTicket;
	private boolean hasGoldenTicket=false;
	
	public Product(){}
	
	public Product(String description, long barcode,String serialNumber, GoldenTicket prizeTicket){
		this.description = description;
		this.barcode = barcode;
		this.serialNumber = serialNumber;
		this.prizeTicket = prizeTicket;
	}
	
	//Getters and Setters
	public String getDescription()
    {
        return description;
    }
	
	public void setDescription(String _description)
    {
        this.description=_description;
    }
	
	public long getBarcode(){
		return barcode;
	}
	
	public void setBarcode(long barcode){
		this.barcode = barcode;
	}
	public String getSerialNumber(){
		return serialNumber;
	}
	
	public void setSerialNumber(String serialNumber){
		this.serialNumber = serialNumber;
	}
	
	public GoldenTicket getPrizeTicket()
    {
        return prizeTicket;
    }
	
	public void setPrizeTicket(GoldenTicket prizeTicket){
		this.prizeTicket=prizeTicket;
	}
	
	public void setTicketState(boolean hasGoldenTicket)
    {
        this.hasGoldenTicket=hasGoldenTicket;
    }
	
	public boolean getGoldenTicket(){
		return hasGoldenTicket;
	}
	
	@Override
	public String toString(){
		return "  description: " + this.description + "  barcode: " + this.barcode 
		        + "  serialNumber: " + this.serialNumber + "  prizeTicket: " + this.getPrizeTicket() + System.lineSeparator();
	}  
}