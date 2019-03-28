import models.OompaLoompaSong;
import models.Functions;
import models.Kid;
import models.OompaLoompa;

import java.util.Scanner;


public class Main{
	public static void main(String args[]){
		
		int option = 0;
		Scanner scanner = new Scanner(System.in);
		do{
			System.out.println(" Welcome to Willy Wonka's Cholate Factory! "+ 
			"\n 1 - Register Prize tickets" + "\n 2 - List all prize tickets" +
			"\n 3 - List only raffled tickets "+ "\n 4 - Create a new Oompa Loompa song"+
			"\n 5 - Register Beings" + "\n 6 - Register Products" + "\n 7 - Ruffle tickets" +
			"\n 8 - Register sale " + "\n 9 - List winners \n");
		
			Functions f=  new Functions();

			option = scanner.nextInt();
			
			switch(option){
				case 1:
				//-- - Register Prize tickets
				f.registerPrizeTickets();
				break;
				
				case 2:
				//-- register list All The Prize Ticket
				f.listAllThePrizeTicket();
				break;
				
				case 3:
				//-- List only raffled tickets
				f.listOnlyRaffledTickets();
				break;
				
				
				case 4:			
				//-------------create song
				System.out.println("Please input a number to define the length of your own OompaLoompaSong! ");
				System.out.println(new OompaLoompaSong(scanner.nextInt()).sing());
				break;
				
				case 5:
				//-- register beings
				System.out.println("Which Beings are there to register?");
				f.registerBeings();
				break;
				
				case 6:
				//---register products
				f.registerProducts();
				
				case 7:
				//-- ruffle tickets
				f.ruffleTickets();
				break;
				
				case 8:
				//-- register sales
				f.registerSales();
				break;
		
				case 9:
				//--List winner;
				f.listWinners();
				break;
			}
		}while(option != 0);
	}
}
