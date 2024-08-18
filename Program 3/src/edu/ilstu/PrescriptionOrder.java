/**
 * 
 */
package edu.ilstu;

/**
 * @author Stefan Tujarov
 *
 */


import java.util.Scanner; 
public class PrescriptionOrder {
public int rxNumber;
private String pharmacyBranch;
private String drugName;
private String drugType;
private int maxNumRefills;
private int numOfRefillsRequested;
public static int totalPrescriptions;	
Scanner scan = new Scanner(System.in);
public PrescriptionOrder(int rxNumber, String drugName, String pharmacyBranch, String drugType, int maxNumRefills ) {
		this.rxNumber = rxNumber;
		this.pharmacyBranch = pharmacyBranch;
		this.drugName = drugName;
		this.drugType = drugType;
		this.pharmacyBranch = pharmacyBranch;
		this.maxNumRefills = maxNumRefills;
}
	// this method takes each prescription and displays the kind of drug, and the max refills that the user can get 

	public int calcMaximumRefills() {
		if (drugType.equals("Antibiotic")){
			maxNumRefills = 1;
		}else if(drugType.equals("Vitamin supplement")) {
			maxNumRefills = 5;
		}else if(drugType.equals("Vaccine")) {
			maxNumRefills = 0;
		}else{
			maxNumRefills = 0;
		} 
		return maxNumRefills;
	}
	
// to string will take the will return the rx number and the branch and the getRefillsAvaliable will display the refills in the "L" menu
	public final String toString() {
		return (rxNumber + " " + drugName + " " + pharmacyBranch + " " + getRefillsAvailable());
		}
		
	// this method will subtract the refills when the user request a refill 
	public int getRefillsAvailable() {
		return (maxNumRefills - numOfRefillsRequested);
	}
	
	// this method will take the max refills and subtract the refills and will display a message if the user 
	// has enough refills but if the user has 0 refills left then the user will be displayed with another message 
	public void Refill() {
		if (calcMaximumRefills() - numOfRefillsRequested > 0) {
			numOfRefillsRequested++;
			System.out.println("Refill Complete");
		}else{ 
			System.out.println("You have reached your maximum refills");
		}
	}
	
// the transfer method will take the branch and will allow the user to move and rename where they want there prescription to be 
	
	public void transfer(String pharmacyBranch1) {
	System.out.println("Transfer complete.\n");
	pharmacyBranch = pharmacyBranch1;
		
	}


// display menu is the menu where the user can navigate and get the type of prescription or the refills or transfer 
	
	public static void displayMenu() {
		System.out.println("Please Choose one of the following");
		System.out.println("L - list all avalible prescription orders");
		System.out.println("R - refill a prescription");
		System.out.println("T - transfer a prescription");
		System.out.println("Q - quit");
		System.out.print("Enter your choice: ");
	
	}
	
}


