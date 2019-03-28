package models;

import models.Kid;
import models.OompaLoompa;
import models.Product;

import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.io.File;
import java.io.*;
import java.util.Collections;
import java.util.Random;


public class Functions{
	
	private ArrayList<Kid> kids = new ArrayList<Kid>(); 
	private ArrayList<OompaLoompa> OompaLoompas = new ArrayList<OompaLoompa>();
	private	ArrayList<Product> products = new ArrayList<>();

	public void registerBeings(){
		Kid a = new Kid("123", "Tan", "1995.12.10", null, "Switzerland"); kids.add(a);
		Kid b = new Kid("456", "John", ".1996.12.10", null, "UK"); kids.add(b);   
        Kid c = new Kid("789", "Printer", "1998.12.10", null, "China"); kids.add(c);
        Kid d = new Kid("111", "Lucy", "2000.02.20", null, "Japan"); kids.add(d);
		Kid e = new Kid("222", "Lily", "2005.06.08", null, "Hungary"); kids.add(e);
		
		OompaLoompa O1 = new OompaLoompa("oompa1","000",10,"Ice"); OompaLoompas.add(O1);
		OompaLoompa O2 = new OompaLoompa("oompa2","333",17,"Snow"); OompaLoompas.add(O2);
		OompaLoompa O3 = new OompaLoompa("oompa3","666",22,"Man"); OompaLoompas.add(O3);
		OompaLoompa O4 = new OompaLoompa("oompa4","999",28,"Chinken"); OompaLoompas.add(O4);
		
		int number;
		Scanner scanner = new Scanner(System.in);
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy.MM.dd");
	
			System.out.println("Press 1 to register the kids or press 2 to register the OompaLoompa : ");
			number = scanner.nextInt();
			if(number==1){
				String code;
				System.out.println("Please type the code of the kid: ");
				code = scanner.next();
				
				String name;
				System.out.println("Please type the name of the kid: ");
				name = scanner.next();
				
				String birthday;
				System.out.println("Please type the birthday (yyyy.MM.dd) of the kid: ");
				Date bd;
				birthday	= scanner.next();
				
				try{
					bd = myFormat.parse(birthday);
				} catch (Exception ae){
					System.out.println("input error!");
				}
				
				String placeOfBirth;
				System.out.println("Please type the birth place of the kid: ");
				placeOfBirth=scanner.next();
				
				Kid k = new Kid(code, name, birthday, null, placeOfBirth);
				kids.add(k);
			}
			else if(number==2){
				
				
				String code;
				System.out.println("Please type the code of the oompaloompa: ");
				code = scanner.next();
				
				String name;
				System.out.println("Please type the name of the oompaloompa: ");
				name = scanner.next();
				
				int height;
				System.out.println("Please type the height of the oompaloompa: ");
				height = scanner.nextInt();
				
				String favoriteFood;
				System.out.println("Please type the favorite food of the oompaloompa: ");
				favoriteFood = scanner.next();
				
				OompaLoompa oompaLoompa = new OompaLoompa(name, code, height, favoriteFood);
				OompaLoompas.add(oompaLoompa);
			}
			else{
				System.out.println("You register for nothing :)");
			}
		
	}
	
	
	public void registerProducts(){
		try{
			File file = new File("Products.txt");
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()){
				String description;
				description = scanner.next();
				
				long barcode;
				barcode = scanner.nextLong();
				
				String serialNumber;
				serialNumber = scanner.next();
				
				
				Product p = new Product(description,barcode,serialNumber,null);
				products.add(p);	
			}
		    //System.out.println("the registered products: "+" "+ products.toString());

			scanner.close();
		} catch (FileNotFoundException e){
			System.out.println("The product file is not avavilable!");
		}
	}
	
	public void registerSales(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please type the user code(the same tyoe with kids' code): ");
		String userCode = scanner.next();
	
		for(int i=0;i<kids.size();++i){
			if(kids.get(i).getCode().equals(userCode)){
				System.out.println(kids.get(i).getName());
			}
			else{
				System.out.println("There is no such a lucky kid");
			}
		}
		
		System.out.println("Please type the barcode of the product:");
		long productBarCode = scanner.nextLong();
		
		
		ArrayList<Product> such_products = new ArrayList<>();
		boolean such_products_exist = false;
		for (int i=0;i<products.size();i++){						
			if (products.get(i).getBarcode()==(productBarCode)){
				such_products.add(products.get(i));
				such_products_exist = true;
			}
			else{
				System.out.println("There is no such product having barcode!");
			}			
			if(such_products_exist){
				Random random = new Random();
				int index=0;
				while(products.get(index).getBarcode()!=productBarCode){
					index = random.nextInt(products.size()-1);
				}	
				
					kids.get(i).addPurchasedProducts(products.get(index));
					products.remove(i);	
				
			}			
		}
	}
	
	public void registerPrizeTickets(){
		String serialNumber = "";
		System.out.println("How many tickets would you like to register? (please give a number less then 10 as we only have 9 kinds of products yet)");
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		for(int i=0;i<a;i++){
			System.out.println("Please type the serial number of the product you'd like to register ticket on");
			serialNumber = scanner.next();
			
			//scanner.nextLine();
			for(int j=0;j<products.size();j++){
				if(products.get(j).getSerialNumber().equals(serialNumber)){
					//System.out.println(products.get(j).getSerialNumber().equals(serialNumber));
					//System.out.println("Enter the "+(j+1)+" ticket's code");
					//String code =scanner.next();
					System.out.println("If you'd like to make this ticket to be raffled/GoldenTicket, then type 1. otherwise type 0");
					//Scanner number = new Scanner(System.in);
					int number = scanner.nextInt();
					if(number==1){
						System.out.println("Design the prize ticket's code (whatever you want to type): ");
						String code =scanner.next();
						Date date = new Date();
						GoldenTicket ticket = new GoldenTicket(code,date);
						products.get(j).setPrizeTicket(ticket);
						products.get(j).setTicketState(true);
						//System.out.println("does this work?"+products.get(j).getGoldenTicket());
					}
					else if(number ==0){
						products.get(j).setPrizeTicket(null);
					}
					else{
						System.out.println("Your instruction is out of reach!");
					}
				}
			}
		}
	}
	
	public void listAllThePrizeTicket(){
		for(Product p: products){
			if(p.getGoldenTicket()){
				System.out.println("Here are all the prize tickets: "+p);
			}
		}
	}
	
	public void listOnlyRaffledTickets(){
		for(Product p: products){
			if(p.getGoldenTicket()&&p.getPrizeTicket().isRaffled()){
				System.out.println("Here are all the only Raffled tickets: "+p);				
			}
		}
	}
	
	public static String getRandomCode() {
		System.out.println("Please type a number as the length of the code you'd like to generate: ");
		Scanner scanner = new Scanner(System.in);
		int length = scanner.nextInt();
		String strings = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz0123456789";
                Random random = new Random();
                StringBuffer codes = new StringBuffer();
                for(int i=0;i<length;i++){
                    int n = random.nextInt(strings.length());
                    codes.append(strings.charAt(n));
                }
                return codes.toString();
    }
	
	public void ruffleTickets(){
		System.out.println("Please give a number of tickets to be ruffled: ");
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();		

		if(number>=products.size()){
			System.out.println("All the products will be ruffled with goldenTickets! ");
			
			for(int i=0;i<products.size();i++){
				Date date = new Date();	
				String code = getRandomCode();
				GoldenTicket tickets = new GoldenTicket(code,date);
				products.get(i).setPrizeTicket(tickets);
			}
		}
		else{
			Collections.shuffle(products);  
			for(int i=0;i<number;++i){
				Date date = new Date();	
				String code = getRandomCode();
				GoldenTicket tickets = new GoldenTicket(code,date);
				products.get(i).setPrizeTicket(tickets);
			}	
		}
		
	}

	
	public void listWinners(){
		for(int i=0;i<kids.size();i++){
				if(kids.get(i).getPurchasedProducts().size()!=0 && kids.get(i).getPurchasedProducts().get(i).getGoldenTicket()){
					System.out.println("The lucky kid(s) is/are:" + kids.get(i).getName() );
				}
				else{
					System.out.println("There is no winner!");
				}
		}
	}
}