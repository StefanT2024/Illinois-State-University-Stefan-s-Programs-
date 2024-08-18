/**
 * 
 */
package edu.ilstu;

/**
 * @author stefa
 *
 */
import java.util.Scanner;
public class BicycleDriver {

	public static void menuOptions() {
		System.out.println("1 - List inventory by wheek size");
		System.out.println("2- List inventory by type");
		System.out.println("3- List inventory by gender");
		System.out.println("4- List inventory by assembled");
		System.out.println("5 - List inventory by all criteria");
		System.out.println("6 - List entire inventory");
		System.out.println("7 - Quit");
		System.out.print("Enter your choice: ");
	}
	
	public static void outputList(Bicycle[] bicycle) {
		for (int i = 0; i < bicycle.length; i++) {
			if (bicycle[i] != null) {
				System.out.println(bicycle[i]);
				}
			}
		}
	
		public static String determineType() {
		Scanner scanType = new Scanner(System.in);
			int numberChoice = 6;
		String bikeTypeChoice;
		while (numberChoice < 1 || numberChoice > 5) {
		System.out.println("select a bicycle type: ");
		System.out.println("1 - Mountain");
		System.out.println("2 - Speed");
		System.out.println("3 - Hybrid");
		System.out.println("4 - Road");
		System.out.println("5 - Dirt");
		numberChoice = scanType.nextInt();
		if (numberChoice < 1 || numberChoice > 5) {
			System.out.println("Invald");
		}
		}
	
	if (numberChoice == 1) {
		bikeTypeChoice = "Mountain";
	} else if  (numberChoice == 2) {
	bikeTypeChoice = "Speed";
	} else if(numberChoice == 3) {
	bikeTypeChoice = "Hybrid";
	}else if  (numberChoice == 4 ) {
		bikeTypeChoice ="Road";
	}else {
		 bikeTypeChoice = "Dirt";
		}
	return bikeTypeChoice;
	}
	
	public static void processByWheelSize(Bicycle[] bicycle) {
		System.out.print("Enter the wheel size -- 14 or 16: ");
		Scanner scanWheel = new Scanner(System.in);
		int wheel = scanWheel.nextInt();
		System.out.println("How many do you want to find?: ");
		int numWheel = scanWheel.nextInt();
		int count = 0;
		for (int i = 0; i < bicycle.length; i++) {
			if (bicycle[i] != null) {
				if (bicycle[i].getwheelSize() == wheel && numWheel != count) {
				System.out.println(bicycle[i]);
				count ++;
				}
			}
			
		}
		
	}
	
	public static void processByType(Bicycle[] bicycle) {
		Scanner scan = new Scanner(System.in);
		String bikeChoice = determineType();
		System.out.println("How many do you want to find: ");
		int numType = scan.nextInt();
		int count = 0;
		for (int i = 0; i < bicycle.length; i++) {
			if (bicycle[i] != null) {
			if (bicycle[i].getbikeType().equals(bikeChoice)  && numType != count) {
				System.out.println(bicycle[i]);
				count++;
			}
		}
	} 
	
	}	
	public static void processByGender(Bicycle[] bicycle) {
		Scanner scanGender = new Scanner(System.in);
		
		
		int chooseGender = 0;
		while (chooseGender != 1 && chooseGender != 2) {
			System.out.println("What gender bike od you want: 1 for female and 2 for male: ");
			chooseGender = scanGender.nextInt();
		}	
		if (chooseGender == 1 ) {
			char gender = 'f';
			System.out.println("How many do you want to find: ");
			int numCounter = scanGender.nextInt();
			int count = 0;
			for (int i = 0; i < bicycle.length; i++) {
				if (bicycle[i] != null) {
					if (bicycle[i].getgender() == gender && numCounter != count) {
					System.out.println(bicycle[i]);
					count++;
					}
				}
			}
		}else {
				char gender = 'm';
				System.out.println("How many do you want to find: ");
				int numCounter = scanGender.nextInt();
				int count = 0;
				for (int i = 0; i < bicycle.length; i++) {
					if (bicycle[i] != null) {
						if (bicycle[i].getgender() == gender && numCounter != count) {
						System.out.println(bicycle[i]);
						count++;
						}
					}
				}
		}				
	}
		
	public static void processByAssemble(Bicycle[] bicycle) {
		String chooseAssemble = "string1";
		int chooseAssemble1 = 0;
		Scanner choiceAssemble = new Scanner(System.in);
		Scanner choiceAssemble1 = new Scanner(System.in);
		while (!(chooseAssemble.equals("yes") || chooseAssemble.equals("no"))) {
		System.out.println("Do you want this assembled?: ");
		chooseAssemble = choiceAssemble.nextLine();
		}
			System.out.println("How many doyou want to find?: ");
		chooseAssemble1 = choiceAssemble1.nextInt();
			
		if (chooseAssemble.equals("yes")) {
			boolean Assembled = true;
			int count = 0;
			for (int i = 0; i<bicycle.length; i++) {
			if (bicycle[i] != null) {
				if (bicycle[i].getassembled() == Assembled && chooseAssemble1 != count) {
					System.out.println(bicycle[i]);
					count++;
				}
			
			}	
		}
		}
		if (chooseAssemble.equals("no")) {
			boolean Assembled = false;
		int count = 0;
			for (int i = 0; i<bicycle.length; i++) {
			if (bicycle[i] != null) {
				if (bicycle[i].getassembled() == Assembled && chooseAssemble1 != count) {
					System.out.println(bicycle[i]);
					count++;
				}
			
			}	
		}
	}
}	
	
		
	public static void processByAllCriteria(Bicycle[] bicycle) {
	
		int wheelSizeChoice= 0;
		int genderChoice = 0;
		boolean assembleChoice = false;
		int choose = 0;
		
		Scanner size  = new Scanner(System.in);
		while (wheelSizeChoice != 14 && wheelSizeChoice != 16) {
			System.out.println("Enter the wheel size -- 14 or 16: ");
		wheelSizeChoice = size.nextInt();	
		}
		
		String typeChoose = determineType();
		
		Scanner gender = new Scanner(System.in);
		while (genderChoice != 1 && genderChoice != 2) {
			System.out.println("What gender bike doyou want: 1 for female and 2 for male: ");
			genderChoice = gender.nextInt();
		}
			 if (choose == 1) {
				genderChoice = 'f';
			}else {
				genderChoice = 'm';
			}
		
		Scanner assemble = new Scanner(System.in);
		System.out.println("Do you want this assembled?: ");
		String assmemle = assemble.nextLine();
		if (assemble.equals("yes")) {
			boolean Assembled = true;
		}
		if (assemble.equals("no")) {
			boolean Assembled = false;
		}
		int count = 0;
	System.out.println("How many do you want to find: ");
	int number = size.nextInt();
	for (int i = 0; i<bicycle.length; i++) {
		
			if (bicycle[i] != null) {
			
			if (bicycle[i].getassembled() && bicycle [i].getbikeType().equals(typeChoose) && bicycle[i].getwheelSize() == wheelSizeChoice && bicycle[i].getgender() == genderChoice && number != count) {
					
				System.out.println(bicycle[i]);
				count++;
			}
		}	
	}
}	
	

	
	public static void main(String[] args) {
	System.out.println("Enter your name: ");
		Scanner scanString = new Scanner(System.in);
		String input1 = scanString.next();		
		System.out.println("Welcome " + input1 + " to the Wheels and Gears");
		Bicycle [] bicycle = BicycleInventory.bicycle;
		BicycleInventory.readInventory(); 
	Scanner input2 = new Scanner (System.in);
		int choose = 0;
	while(choose != 7) {
		menuOptions();
		choose = input2.nextInt();
		input2.nextLine();
		switch(choose) {
			case 1: 
		processByWheelSize(bicycle);
			  	
				
		break;
			
			
			case 2:
		processByType(bicycle);
				break;
		
			
			case 3:
		processByGender(bicycle);
				break;
			
			
			case 4:
		processByAssemble(bicycle);
				break;
			
			
			case 5:
		processByAllCriteria(bicycle);
				break;
			
			
			case 6:
				outputList(bicycle);
				break;
			
			
			case 7:
		System.out.println("Goodbye");
		System.exit(0);
				break;
		
			
			
			default:
		break;
		
		
		
			}
		
		}
	}
}
