package edu.ilstu;

/*
 * Stefan tujarov 
 * 
 * ULID: SBTUJAR
 * 
 * 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Fleet {
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	private LocalDate currentDay = LocalDate.parse("06/01/2023", formatter);
	private Aircraft [] fleet;
	private int count;
	
	
	/**
	 * A constructor method that initializes an array of Aircraft objects with a capacity of 100 and sets the count to 0.
	 */
	public Fleet() {
		
		fleet = new Aircraft[100];
		count = 0;
	}
	
	/**
	 * @return
	 * 
	 * getter method that displays a list of aircraft and their information, including the next maintenance date and the next maintenance miles.
	 */
	public String displayNextMaintenanceList() {
		
		    System.out.println("AC Name\tRegNum\t Manuf.\tNext MDate\tNext MMiles");
		    String text = "";
		    for (int i = 0; i < count; i++) {
		        LocalDate nextMaintenanceDate = fleet[i].getLastmaintenanceDate().plusMonths(3);
		        double nextMaintenanceMiles = fleet[i].getLastmaintenanceMiles() + 150000;
		        text += (fleet[i].getAircraftName() + "\t" + fleet[i].getRegNumber() + "\t" + fleet[i].getManufacturer() + "\t" + 
		                nextMaintenanceDate.format(DateTimeFormatter.ISO_LOCAL_DATE) + "\t" + nextMaintenanceMiles);
		        text += "\n";
		    }
		    return text;
		}

	
	

	/**
	 * @param fileName
	 *  A method that reads data from a file and initializes Aircraft objects with the data.
	 */
	public void readFile(String fileName) {
		
		try (Scanner scan = new Scanner(new File(fileName))){
			while (scan.hasNextLine()) {
				String text = scan.nextLine();
				while(!(text.equals("")) && scan.hasNextLine()) {
					if (count >= 1) {
						scan.nextLine();
						text = scan.nextLine();
					}
					String aircraftName = text.substring(0, text.indexOf(" "));
					String regNumber = text.substring(text.indexOf(" ") + 1, text.length());
					String manufacturer = scan.nextLine();
					text = scan.nextLine();
					double maxRange = Double.parseDouble(text);
					text= scan.nextLine();
					int crewSize = Integer.parseInt(text);
					text= scan.nextLine();
					int yearPutInService = Integer.parseInt(text);
					text = scan.nextLine();
					double maxServiceWeight = Double.parseDouble(text);
					text= scan.nextLine();
					int numPassenger = Integer.parseInt(text);
					text = scan.nextLine();
					int currentMiles = Integer.parseInt(text);
					String lastmaintenanceDate = scan.nextLine();
					LocalDate localDate = LocalDate.parse(lastmaintenanceDate, formatter);
					text = scan.nextLine();
					double lastmaintenanceMiles = Double.parseDouble(text);
					Aircraft aircraft = new Aircraft (aircraftName, regNumber, manufacturer, maxRange, crewSize, yearPutInService, maxServiceWeight, numPassenger, currentMiles, localDate,lastmaintenanceMiles);
					addAircraft(aircraft);
				}
			}
		scan.close();
		
		} catch (FileNotFoundException e) {
			System.err.println("File Not Found");
		}
		
	}

	/**
	 * @param fileName
	 * 
	 * A method that writes the Aircraft objects' information to a file.
	 */
	public void writeFile(String fileName) {
		try {
			FileWriter fw = new FileWriter(fileName,true);
			PrintWriter printWriter = new PrintWriter(fw);
			
		for (int i = 0; i < count; i++) {
			fw.write(fleet[i].getAircraftName() + " " + fleet[i].getRegNumber() + "\n");
			fw.write(fleet[i].getManufacturer() + "\n");
			fw.write(fleet[i].getMaxRange() + "\n");
			fw.write(fleet[i].getCrewSize() + "\n");
			fw.write(fleet[i].getYearPutInService() + "\n");
			fw.write(fleet[i].getMaxServiceWeight() + "\n");
			fw.write(fleet[i].getNumPassengers() + "\n");
			fw.write(fleet[i].getCurrentAirMiles() + "\n");
			fw.write(fleet[i].getLastmaintenanceDate() + "\n");
			fw.write(fleet[i].getLastmaintenanceMiles() + "\n");
			
			
			fw.close();
		
		System.out.println("Number of aircrafts in fleet: " + count);
		
		}

	
		}catch(FileNotFoundException e) {
			
			
		}catch(IOException ioe) {
			System.out.println("an error occured while writing to file: " + ioe.getMessage());
		}
	}

	/**
	 * @param aircraft
	 * setter that adds a aircraft to the array of other aircrafts
	 */
	public void addAircraft(Aircraft aircraft) {
		for (int i = 0; i < count;i++) {
			if (fleet[i].getRegNumber().equals(aircraft.getRegNumber())){
				System.out.println("Aircraft with registration number " + aircraft.getRegNumber() + " already exists.");
				return;
			}
		}
		fleet[count] = aircraft;
		count++;
		System.out.println("Number of vehicles in fleet: " + count);
	}

	
	/**
	 * @return
	 * 
	 * getter that returns the fleet of aircrafts that the user made 
	 */
	
	public String displayFleet() {
		String text ="";
		System.out.println("CURRENT FLEET COMPOSITION");
		System.out.println("NAME\tREG\tMANUF\tRANGE\tCREW\tYIS\tWEIGHT\tPASS\tCMILES\tLmDATE\t\tLmMILES");
		for (int i = 0; i < count; i++) {
			text += (fleet[i].getAircraftName() + "\t" + fleet[i].getRegNumber() + "\t" + fleet[i].getManufacturer() + "\t" + fleet[i].getMaxRange() + "\t" + fleet[i].getCrewSize() + "\t" + 
					fleet[i].getYearPutInService() + "\t" + fleet[i].getMaxServiceWeight() + "\t" + fleet[i].getNumPassengers() + "\t" + fleet[i].getLastmaintenanceDate() + "\t" + 
					fleet[i].getLastmaintenanceMiles());
			text += "\n";
		}
		return text;
		
		
	}

	
	/**
	 * @return
	 * 
	 *  A method that displays a list of aircrafts that should have maintenance work done on them 
	 */
	public String displayMaintenanceList() {
		System.out.println("AC Name\tRegNum\t Manuf.\tLast MDate\tLast MMiles");
		String text  ="";
		for (int i = 0; i < count; i++) {
			if (fleet[i].needsMaintence() == true) {
				text += (fleet[i].getAircraftName() + "\t" + fleet[i].getRegNumber() + "\t" + fleet[i].getManufacturer() + "\t" + fleet[i].getLastmaintenanceDate() + "\t" + 
					fleet[i].getLastmaintenanceMiles());
			text += "\n";
			}
		}
		return text;
	}
		
		
		
		
	/**
	 * @param regNumber
	 * @param miles
	 * setter that updates the miles on a aircraft
	 */
	public void updateMiles(String regNumber, double miles) {
		boolean found = false;
		for (int i = 0; i < count; i++) {
			if (fleet[i].getRegNumber().equals(regNumber)) {
				fleet[i].setLastmaintenanceMiles(fleet[i].getLastmaintenanceMiles() + miles);
				System.out.println("Miles updated for \n" + regNumber + "\n" + fleet[i].getManufacturer() + "\n" + fleet[i].getAircraftName());
				System.out.println("\nNew Miles: " + fleet[i].getLastmaintenanceMiles());
				found = true;
			}
		}
		if (found == false) {
			System.out.println("No aircraft found");
		}
	}
	
	/**
	 * @param regNumber
	 * setter that does maintenance on a aircraft and displays whens the next date and miles that aircraft needs to do
	 */
	public void updateMaintenance(String regNumber) {
		boolean found = false;
		for (int i = 0; i < count; i++) {
			if (fleet[i].getRegNumber().equals(regNumber)) {
				fleet[i].setLastmaintenanceDate(currentDay);
				System.out.println("Maintenance Miles updated for \n" + regNumber + "\n" + fleet[i].getManufacturer() + "\n" + fleet[i].getAircraftName());
				System.out.println("\nNext Maintenance Date: " + currentDay.plusMonths(3));
				System.out.println("Next Maintenance Miles: " + (fleet[i].getLastmaintenanceMiles() + 150000));
				found = true;
			} 
		}
		if (found == false) {
			System.out.println("No aircraft found");
		}
	}
	
	/**
	 * @param regNumber
	 * 
	 * setter that displays the aircraft
	 */
	public void displayAircraft(String regNumber) {
		boolean found = false;
		for (int i = 0; i < count; i++) {
			if (fleet[i].getRegNumber().equals(regNumber)) {
				System.out.println(fleet[i]);
				found = true;
			} 
		}
		if (found == false) {
			System.out.println("No aircraft found");
		}
	}
	
	/**
	 * @param regNumber
	 * setter that removes an array craft from the fleet
	 */
	public void removeAircraft(String regNumber) {
		Aircraft [] tempFleet = new Aircraft[count - 1];
		boolean found = false;
		int index = 0;
		for (int i = 0; i < count; i++) {
			if (fleet[i].getRegNumber().equals(regNumber)) {
				index = i;
				found = true;
			}
		}
		if (found == false) {
			System.out.println("No aircraft found");
		} else {
			int tempCount = 0;
			int counter = 0;
			while (counter != count - 1) {
				if (index != counter) {
					tempFleet[tempCount] = fleet[counter];
					tempCount++;
				}
				counter++;
			}
			for (int i = 0; i < count - 1; i++) {
				fleet[i] = null;
				fleet[i] = tempFleet[i];
			}
			count--;
			System.out.println("Aircraft " + regNumber + " has been retired.");
			System.out.println("Number of aircraft in fleet: " + count);
		}
	}
}
