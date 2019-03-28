package models;

public class Beings{
	//attributes
	private String name;
	private String code;
	
	//constructor
	public Beings(){}  //empty constructor
	public Beings(String name, String code){
		this.name=name;
		this.code=code;
	}
	
	//getters and setters
	public String getName(){
		return name;
	}
	
	public void setName(){
		this.name=name;
	}
	
	public String getCode(){
		return code;
	}
	
	public void setCode(){
		this.code=code;
	}
}