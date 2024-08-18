/**
 * 
 */
package edu.ilstu;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author Stefan Tujarov ULID: SBTUJAR
 */
public class TShirtOrder {

	public static void main(String[] args) {

		// declaring and initializing constants and variables

		final double CHIEFS = 40.00;
		final double EAGLES = 40.00;
		final double SUPERBOWL = 40.00;
		final double TAX_RATE = 0.10;
		final double SHIPPING_COST = 0.05;

		Scanner scan = new Scanner(System.in);
		Scanner scan1 = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("$0.00");
		System.out.println("Super Bowl T-Shirts");
		System.out.println("Chiefs T-shirts " + df.format(CHIEFS));
		System.out.println("Eagles T-shirts " + df.format(EAGLES));
		System.out.println("Super Bowl T-shirts " + df.format(SUPERBOWL));

		int chiefTotal = 0;
		int eagleTotal = 0;
		int superBowlTotal = 0;
		String customNameChiefs = "";
		String customNameEagles = "";
		String customNameSuperBowl = "";

		System.out.println("Enter the number of Chiefs T-Shirts to purchase: ");
		int numOfChiefs = scan1.nextInt();

		// if statement for chiefs jersey takes user input and asks how many and if they
		// want to customizes the jersey

		if (numOfChiefs > 0) {
			int counter = 1;
			System.out.println("Would you like to customize (y/n): ");
			char customChiefs = scan.nextLine().charAt(0);

			if (customChiefs == 'y' || customChiefs == 'Y') {
				while (numOfChiefs >= counter) {
					System.out.println("What do you want to print on the back of shirt " + counter + ": ");
					customNameChiefs = scan.nextLine();
					customNameChiefs = customNameChiefs.replaceFirst(" ", "");
					chiefTotal += customNameChiefs.length();
					counter++;

				}
			}

		}

		System.out.println("Enter the number of Eagles T-Shirts to purchase: ");
		int numOfEagles = scan1.nextInt();

		// if statement for eagles jersey takes user input and asks how many and if they
		// want to customizes the jersey

		if (numOfEagles > 0) {
			int counter = 1;
			System.out.println("Would you like to customize (y/n): ");
			char customEagles = scan.nextLine().charAt(0);

			if (customEagles == 'y' || customEagles == 'Y') {

				while (numOfEagles >= counter) {
					System.out.println("What do you want to print on the back of shirt " + counter + ": ");
					customNameEagles = scan.nextLine();
					customNameEagles = customNameEagles.replaceFirst(" ", "");
					eagleTotal += customNameEagles.length();
					counter++;

				}
			}

		}

		System.out.println("Enter the number of Super-Bowl T-Shirts to purchase:  ");
		int numOfSuperBowl = scan1.nextInt();

		// if statement for super bowl jersey takes user input and asks how many and if
		// they want to customizes the jersey

		if (numOfSuperBowl > 0) {
			int counter = 1;
			System.out.println("Would you like to customize (y/n): ");
			char customSuperBowl = scan.nextLine().charAt(0);

			if (customSuperBowl == 'y' || customSuperBowl == 'Y') {
				while (numOfSuperBowl >= counter) {
					System.out.println("What do you want to print on the back of shirt " + counter + ": ");
					customNameSuperBowl = scan.nextLine();
					customNameSuperBowl = customNameSuperBowl.replaceFirst(" ", "");
					superBowlTotal += customNameSuperBowl.length();
					counter++;

				}
			}

		}

		// shipping address and information

		System.out.println("Please enter shipping information:");
		System.out.println("Enter first name: ");
		String firstName = scan.nextLine();

		System.out.println("Enter last name: ");
		String lastName = scan.nextLine();

		System.out.println("Enter street address: ");
		String street = scan.nextLine();

		System.out.println("Enter city: ");
		String city = scan.nextLine();

		System.out.println("Enter state: ");
		String state = scan.nextLine();

		System.out.println("Enter zip code: ");
		int zipCode = scan1.nextInt();

		System.out.println("\n");
		System.out.println("\tOrder Summary");
		System.out.println("Chiefs T-shirts\t\t\t" + numOfChiefs);
		System.out.println("Chiefs Printed letters\t\t" + chiefTotal);

		System.out.println("Eagles T-shirts\t\t\t" + numOfEagles);
		System.out.println("Eagles Printed letters\t\t" + eagleTotal);

		System.out.println("Super Bowl T-shirts\t\t" + numOfSuperBowl);
		System.out.println("Super Bowl Printed letters\t" + superBowlTotal);

		System.out.println("\n");

		// subTotal and taxes and shipping cost

		double subTotal = (numOfChiefs * CHIEFS + chiefTotal) + (numOfEagles * EAGLES + eagleTotal)
				+ (numOfSuperBowl * SUPERBOWL + superBowlTotal);
		System.out.println("Subtotal \t\t\t" + df.format(subTotal));

		double tax = subTotal * TAX_RATE;
		System.out.println("Tax \t\t\t\t" + df.format(tax));

		double shipping = (subTotal + tax) * SHIPPING_COST;
		System.out.println("Shipping \t\t\t" + df.format(shipping));

		double total = subTotal + tax + shipping;
		System.out.println("Total\t\t\t\t" + df.format(total));

		System.out.println("This order will be shipped to: ");
		System.out.println(firstName + " " + lastName);
		System.out.println(street);
		System.out.println(city + ", " + state + " " + zipCode);

	}

}
