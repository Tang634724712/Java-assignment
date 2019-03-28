package models;

import java.util.ArrayList;


public class Kid extends Beings{
	
	private String birthday;
	private ArrayList<Product> purchased_products;
	private String place_of_birth;
	
	//constructor
	public Kid(){}  
	
	public Kid(String code, String name ,String birthday, ArrayList<Product> purchased_products,String place_of_birth){
		super(code,name);
		this.birthday=birthday;
		this.purchased_products=new ArrayList<Product>();
		this.place_of_birth=place_of_birth;
	}
	
	//getters and setters
	public String getBirthday(){
		return birthday;
	}
	
	public void setBirthday(String birthday){
		this.birthday = birthday;
	}
	
	public String getPlace_of_birth(){
		return place_of_birth;
	}
	
	public void setPlace_of_birth(String place_of_birth){
		this.place_of_birth = place_of_birth;
	}
	
	public ArrayList<Product> getPurchasedProducts(){
		return this.purchased_products;
	}
	
	public void setPurchasedProducts(ArrayList<Product> purchased_products){
		this.purchased_products=purchased_products;
	}
	
	//custom method
	public void addPurchasedProducts(Product pro){
		purchased_products.add(pro);
	}
}