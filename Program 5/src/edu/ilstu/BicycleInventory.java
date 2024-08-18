package edu.ilstu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BicycleInventory{
	static Bicycle[] bicycle = new Bicycle[100];
	static int count = 0;
	
	public BicycleInventory() {
		Bicycle [] bicycle = new Bicycle[100];
		int wheelSize = 0;
	}
	
	public static void readInventory() {
		//***********************************************************************************
		//Do not change the code below*******************************************************
		int index = 0;						  						
		try	{								   															   						
			File f = new File("bicycle.txt");  					
			Scanner file = new Scanner(f);							
			while (file.hasNextLine())	{							
			String[] line = file.nextLine().split(",");			
				String type = line[0];								
				int wheelSize = Integer.parseInt(line[1]);		
				boolean assembled = Boolean.parseBoolean(line[2]);	
				char gender = line[3].charAt(0);					
		//***********************************************************************************
		// Use these values to create a Bicycle and add it to the array
				
					bicycle [count] = new Bicycle(type, wheelSize, assembled, gender);
					count ++;
			
				
				
				
		//Add code above this line
			}//Do not change****************************************************************
		} catch (FileNotFoundException ife)	{															
			System.out.println("Unable to open file.");				
			System.out.println("Closing the program.");				
		} catch (InputMismatchException misexc)	{															
			System.out.println("Invalid data type.");				
		}															
	}


}







