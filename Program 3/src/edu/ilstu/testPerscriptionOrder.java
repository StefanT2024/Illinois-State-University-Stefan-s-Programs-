/**
 * 
 */
package edu.ilstu;

/**
 * @author Stefan Tujarov 
 *
 */
import java.util.Scanner;

public class testPerscriptionOrder {
	// Import two scanners for user input for switch statement 
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Scanner keyboard = new Scanner(System.in);

PrescriptionOrder prescriptionOrder1 = new PrescriptionOrder( 1320335, "AMOXICILLIN 500 MG CAPSULE", "CVS-Peoria", "Antibiotic", 1);
PrescriptionOrder prescriptionOrder2 = new PrescriptionOrder( 5304689, "VITAMIN D2 1.25MG CAPSULE" , "CVS-Bloomington" , "VITAMIN", 5);
PrescriptionOrder prescriptionOrder3 = new PrescriptionOrder( 1145059, "FLUCERVAX QUAD 0.5ML SYRINGE" , "CVS-Chicago" , "Vaccine", 0);	
  	

System.out.println("Wlecome to CVS!");


// Q will also exit out the menu and will loop around back to the original menu basically it won't end the program
char choose1 = 'x';
while (choose1 != 'Q') {	
	PrescriptionOrder.displayMenu();
	String choose = scan.next();
	choose = choose.toUpperCase();
	
	// this "if" statement will basically give the user a invalid input when they enter a random letter or number thats not 
	// either a L,Q,R,T
	if (choose.length() > 1) {
		choose = "a";
	}
	
	choose1 = choose.charAt(0);

		switch (choose1) {
		case 'l':
		case 'L':
			// The user can type in L into the menu and will be listed with all three prescriptions with the 
			// The type of drug how many refills etc
			
			System.out.println(prescriptionOrder1);
			System.out.println(prescriptionOrder2);
			System.out.println(prescriptionOrder3);
			break;
			
		case 'r':
		case 'R':
			//The user can type R into the menu and will be asked which order the program will check all three for a match 
			// It will then display if there are anymore refills or if the user has reached the maximum number of refills 
			System.out.print("For which order?: ");
			int keyboard1 = scan.nextInt();
			if (keyboard1 == prescriptionOrder1.rxNumber) {
			prescriptionOrder1.Refill();
			}else if (keyboard1 == prescriptionOrder2.rxNumber) {
				prescriptionOrder2.Refill();			
				}else if (keyboard1 == prescriptionOrder3.rxNumber) {
					prescriptionOrder3.Refill();
				}else {
					System.out.println("No matching users");
				}
				break;	
		// The user can type in T and will be presented with the option to enter what order they 
		// would like to transfer to another branch
		case't':
		case'T':
			System.out.print("For which order?: ");
			int keyboard2 = scan.nextInt();
			if (keyboard2 == prescriptionOrder1.rxNumber) {
				System.out.print("\n Enter the new name for the new pharmacy branch: ");
				String pharmacyBranch = scan.next();
;				prescriptionOrder1.transfer(pharmacyBranch);
			}else if (keyboard2 == prescriptionOrder2.rxNumber) {
				
				System.out.print("\n Enter the new name for the new pharmacy branch: ");
				String pharmacyBranch = scan.next();
				prescriptionOrder2.transfer(pharmacyBranch);			
				
			}else if (keyboard2 == prescriptionOrder3.rxNumber) {
					System.out.print("\n Enter the new name for the new pharmacy branch: ");
					String pharmacyBranch = scan.next();
					prescriptionOrder3.transfer(pharmacyBranch);
				}else {
					System.out.println("No matching users");
				}
			break;
			
		// Q will close the menu and the user will be presented with a goodbye message 
		case 'q':
		case 'Q':
			System.out.println("GoodBye!");
		break;
		
		
		
		default:
			System.out.println("Invalid input");
			
		
			}
		}	
	} 
}
