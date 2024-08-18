/**
 * 
 */
package edu.ilstu;
import java.util.Random;
import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * A Program that tells a story with users input 
 * 
 * 
 * @author Stefan Tujarov
 * ULID: SBTUJAR
 *
 */
public class StoryTime {

	
	public static void main(String[] args) {
	
		DecimalFormat df = new DecimalFormat("$0.00");
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		
		double theWage = rand.nextDouble(11)+10;
		double theSalary = theWage * 2080;
	
		// Prompt user for there full name
		
		System.out.println("Enter a first and last name: ");
		String fullName = scan.nextLine();
		String firstName;
		
		// takes full name and uses a method within a method to get the first name 
		firstName = fullName.substring(0, fullName.indexOf(" "));
		
		// ask for users age, if age is higher then 18, user needs to renter their age
		
		System.out.println("Enter an age under 18: ");
		int theAge = scan.nextInt();
			if (theAge > 18) {
				System.out.println("Enter an age under 18:");
				 theAge = scan.nextInt();
			}
		 
		 System.out.println("Enter a city: ");
		 String theCity =scan.next();
		 
		 System.out.println("Enter a name of a college:");
		 String theCollege = scan.next();
		 
		 System.out.println("Enter a profession");
		 String theProfession = scan.next();
		 
		// calculates the users tax rate, salary, and the net wage
		 
		 System.out.println("Enter a tax rate: (.nn): ");
		 double theTaxRate = scan.nextDouble();
		 double theNetWage = theSalary - (theSalary * theTaxRate) ;
		 double theTaxes = theSalary - theNetWage;
		 
		 // if else statement that makes sure that user can't enter below .15 and above .30
		 if (theTaxRate > .30 || theTaxRate < .15) {
			 System.out.println("Enter a tax rate: (.nn): ");
			 theTaxRate = scan.nextDouble();
			  }
			 
		theTaxRate = theTaxRate * 100;	 
		 
		 System.out.println("Enter a animal: ");
		 String theAnimal = scan.next();
		 
		 System.out.println("Enter a pet's name: ");
		 String thePetName =scan.next();
		 
		 //the sentences are declared into strings, makes it easier to get the last word for each sentence for the new string 
		 
		 String string1 = "There once was a person named " +fullName + " who lived in " + theCity+ ". ";
		 System.out.println(string1);
		 
		 String string2 ="Even though"+ " " +firstName + " " +"was only " + theAge+ ", " + firstName + " went to college at " +theCollege+". ";
		 System.out.println(string2);
		 
		 String string3 = firstName + " " +"graduated and went to work as a(n)"+ " " +theProfession+ ". "; 
		 System.out.println(string3);

		 String string4 = fullName +" " + "was paid "+ df.format(theWage) + " " +"per hour, which is " + df.format(theSalary) + " " +"each year.";
		System.out.println(string4);
		 
		 String string5 = firstName +"’s tax rate was " + theTaxRate + "%.";
		 System.out.println(string5);
		 
		 String string6 = firstName+ " " +"paid "+ " " +df.format(theTaxes)+ " " +"in taxes which left"+ " " +fullName+ " " +"with " +df.format(theNetWage)+ " " +"to spend.";
		 System.out.println(string6);
		 
		 String string7 = "Soon there after, "+ firstName + " adopted a(n) " +theAnimal +" named "+thePetName + "!";
		 System.out.println(string7);
		 
		 String string8 = thePetName+ " " +"and"+ " " +fullName +" " +"both lived happily ever after!";
		 System.out.println(string8 + "\n");
		
		String newString = theCity+ " " + theCollege+ " " + theProfession + " " + string4.substring(string4.lastIndexOf(" ")+1, string4.length()-1)+" " + string5.substring(string5.lastIndexOf(" ") +1, string5.length()-1)   
				+ " " +string6.substring(string6.lastIndexOf(" ") +1, string6.length()-1)+ " " +thePetName + " " +string8.substring(string8.lastIndexOf(" ")+1, string8.length());
		System.out.println(newString);
	
	}
	 
}
