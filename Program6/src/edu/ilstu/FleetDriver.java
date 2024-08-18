package edu.ilstu;

/*
 * Stefan Tujarov 
 * 
 * ULID: SBTUJAR
 * 
 * program thats used to manage a fleet of aircrafts 
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class FleetDriver {

	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	private LocalDate currentDay = LocalDate.parse("06/01/2023", formatter);
	private static Scanner input;
	static String [] textMenu = {"Add an Aircraft", "Display the fleet", "Display Aircraft that Need Maintenance", "Display Aircraft Next Maintenance Date/Miles",
				"Record Miles Traveled", "Record Maintenance", "Retire Aircraft", "Load from a file", "Write to a file"};
	
	public FleetDriver() {
		input = new Scanner(System.in);
		
	}
	
	public static void main(String [] args) {
		Fleet fleet = new Fleet();
		setUp(fleet);
		
	}
	
	/**
	 * A constructor method that initializes an array of Aircraft objects with a capacity of 100 and sets the count to 0.
	 */
	
	public static Aircraft getAircraftInfo() {

		Scanner scanNum = new Scanner(System.in);
		Scanner scanString = new Scanner(System.in);
		
		System.out.println("Enter the registration number: ");
		String regNumber = scanString.nextLine();
		System.out.println("Enter the manufacturer: ");
		String manufacturer = scanString.nextLine();
		System.out.println("Enter the model of aircraft: ");
		String model =scanString.nextLine();
		System.out.println("Enter the year of vehicle: ");
		int year =  scanNum.nextInt();
		System.out.println("Enter the crew size: ");
		int crewSize = scanNum.nextInt();
		System.out.println("Enter the range of the aircraft: ");
		double range = scanNum.nextDouble();
		System.out.println("Enter the current air miles: ");
		double current = scanNum.nextDouble();
		System.out.println("Enter the maximum take off weight: ");
		double maximum = scanNum.nextDouble();
		System.out.println("Enter the mileage on the last maintenance: ");
		double mileage = scanNum.nextDouble();
		System.out.println("Enter the date of the last maintenance (MM/dd/yyyy): ");
		String date = scanString.nextLine();
		LocalDate localDate = LocalDate.parse(date, formatter);
		
		Aircraft aircraftChoice = new Aircraft(model ,regNumber ,manufacturer ,range ,crewSize ,year ,maximum , 200 ,current ,localDate, mileage);
		return aircraftChoice;
	}
	
	
	public static void setUp(Fleet fleet) {
		input = new Scanner(System.in);
		TextMenu menu = new TextMenu(textMenu);
		int choice = -1;
		String text;
		while (choice != 10) {
			choice = menu.getChoice();
			switch (choice) {
			case (1):
				//DONE
				fleet.addAircraft(getAircraftInfo());
				
				break;
			
			case (2):
				//DONE
				System.out.println(fleet.displayFleet());
				break;
				
			case(3):
				//DONE
				System.out.print(fleet.displayMaintenanceList());
				break;
			
			case(4):
				//DONE
			System.out.println(fleet.displayNextMaintenanceList());
				break;
				
			case(5):
				//DONE
				System.out.print("Enter the registration number: ");
				text = input.nextLine();
				System.out.print("How many miles were flown? ");
				int miles = input.nextInt();
				fleet.updateMiles(text, miles);
				break;
				
			case (6):
				//DONE
				System.out.print("Enter the registration number: ");
				text = input.nextLine();
				fleet.updateMaintenance(text);
				break;
				
			case (7):
				//DONE
				System.out.print("Enter the registration number: ");
				text = input.nextLine();
				System.out.print("This aircraft will be removed from the fleet. Are you sure (yes/no)?  ");
				if (input.nextLine().equals("Yes") || input.nextLine().equals("yes")) {
					fleet.removeAircraft(text);
				}
				break;
			
			case (8):
				//DONE
				System.out.print("Enter the name of the file to be read: ");
				text = input.nextLine();
				fleet.readFile(text);
				break;
				
			case (9):
				System.out.print("Enter the name of the file to be written in: ");
				text = input.nextLine();
				fleet.writeFile(text);
				break;
				
		
			}
		}
		System.out.println("Program Exiting!");
		System.exit(0);
	}
}
