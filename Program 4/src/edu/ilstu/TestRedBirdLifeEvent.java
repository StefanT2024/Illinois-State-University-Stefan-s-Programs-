/**
 * 
 */
package edu.ilstu;
import java.util.Scanner;
/**
 * @author Stefan Tujarov
 * ULID: SBTUJAR
 * 
 * Program thats a menu for "RedBirdLifeEvent",manages all the plans. Allows user 
 * to choose an event and as how many seats they need.
 *
 */
public class TestRedBirdLifeEvent {

	/*
	 * Calling the constructors and making all four events.
	 */

	public static void main(String[] args) {
		RedBirdLifeEvent event1 = new RedBirdLifeEvent("Success in IT168", "Workshop");
		RedBirdLifeEvent event2 = new RedBirdLifeEvent("Test Prep Seminar", "Seminar", 50);
		RedBirdLifeEvent event3 = new RedBirdLifeEvent("Working in Teams", "Workshop", 10);
		RedBirdLifeEvent event4 = new RedBirdLifeEvent("SIT career fair", "Career fair");
		
		Scanner scan = new Scanner(System.in);
		
		// Q will also exit out the menu 
		
		System.out.println("Welcome to RedBirdLifeEvents page!\n");
		
		char choose1 = 'x';
		while (choose1 != 'Q') {	
			RedBirdLifeEvent.displayMenu();
			String choose = scan.next();
			choose = choose.toUpperCase();	
			choose1 = choose.charAt(0);
			
		switch (choose) {
		case "L":
		case "l":
			
			//displaying all four events, with the event name, the bar code 
			
			System.out.println(event1);
			System.out.println(event2);
			System.out.println(event3);
			System.out.println(event4);
		break;
			
		
		case "IR":
		case "ir":
			System.out.println("For which event? ");
			Scanner eventScan = new Scanner(System.in);
			System.out.println("Enter your choice:  ");
			String choice = eventScan.nextLine();
			
			/*
			 * For the "IR" a while statement is used to check if the user put in the right bar code
			 * and subtracts number of seats that user has asked for 
			 * 
 			 */
			
			while (!(choice.equals(event1.getBarCode()) || choice.equals(event2.getBarCode()) ||choice.equals(event3.getBarCode()) || choice.equals(event4.getBarCode()))){
				System.out.println("Sorry, no matching order was found");
				System.out.print("Enter your choice: ");
				choice = eventScan.nextLine();
			}
			if (choice.equals(event1.getBarCode())) {
				if (event1.getAvaliableSeats() > 0) {
					event1.register();
					System.out.println("Regestration Successful");
				} else {
					System.out.println("Sorry, we have reached the maximum number of seats for this event.");
				}
				
				
			} else if (choice.equals(event2.getBarCode())){
				
				if(event2.getAvaliableSeats() > 0) {
					event2.register();
					System.out.println("Regestration Successful");
				}else {
					System.out.println("Sorry, we have reached the maximum number of seats for this event.");
				}
				
			}else if (choice.equals(event3.getBarCode())) {
				
				if(event3.getAvaliableSeats()> 0) {
					event3.register();
					System.out.println("Regestration Successful");
				}else {
					System.out.println("Sorry, we have reached the maximum number of seats for this event.");
				}
				
				
			}else {
				
				if(event4.getAvaliableSeats() > 0) {
					event4.register();
					System.out.println("Regestration Successful");
				}else {
				
					System.out.println("Sorry, we have reached the maximum number of seats for this event.");
			}
				
			}
		
		break;
		
		case "GR":
		case "gr":
			
			/*
			 * the "GR" tab is the same as the "IR" tab just now user can request how many seats they would like to request
			 */
			
			System.out.println("For which event? ");
			Scanner eventScan1 = new Scanner(System.in);
			System.out.println("Enter your choice:  ");
			String choice1 = eventScan1.nextLine();
			System.out.println("How many seats: ");
			int seatSelection = eventScan1.nextInt();
			while (!(choice1.equals(event1.getBarCode()) || choice1.equals(event2.getBarCode()) ||choice1.equals(event3.getBarCode()) || choice1.equals(event4.getBarCode()))){
				System.out.println("Sorry, no matching order was found");
				System.out.print("Enter your choice: ");
				choice = eventScan1.nextLine();
			}
			if (choice1.equals(event1.getBarCode())) {
				if (event1.getAvaliableSeats() >= seatSelection) {
					event1.register(seatSelection);
					
					System.out.println("Regestration Successful");
				} else {
					System.out.println("Sorry, we have reached the maximum number of seats for this event.");
				}
				
				
			} else if (choice1.equals(event2.getBarCode())){
				
				if(event2.getAvaliableSeats() >= seatSelection) {
					event2.register(seatSelection);
					System.out.println("Regestration Successful");
				}else {
					System.out.println("Sorry, we have reached the maximum number of seats for this event.");
				}
				
			}else if (choice1.equals(event3.getBarCode())) {
				
				if(event3.getAvaliableSeats()>= seatSelection) {
					event3.register(seatSelection);
					System.out.println("Regestration Successful");
				}else {
					System.out.println("Sorry, we have reached the maximum number of seats for this event.");
				}
				
				
			}else {
				
				if(event4.getAvaliableSeats() >= seatSelection) {
					event4.register(seatSelection);
					System.out.println("Regestration Successful");
				}else {
				
					System.out.println("Sorry, we have reached the maximum number of seats for this event.");
			}
				
			}
		
			
		break;
		
		case "Q":
		case "q":
			System.out.println("Goodbye!");
		break;
		
		default:
			System.out.println("Invalid input");
			break;
		}
		
	
		
	}

}
	
}
