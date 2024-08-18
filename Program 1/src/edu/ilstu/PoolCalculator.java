/**
 * 
 */
package edu.ilstu;
import java.util.Scanner;
import java.text.DecimalFormat;
/**
 * Program to calculate the area of an in-ground swimming pool, it’s
approximate surface area, it’s approximate volume, and gallons of water it can hold:
 * 
 * @author Stefan Tujarov
 *	ULID: SBTUJAR
 */
public class PoolCalculator {

	
public static void main(String[] args) {

	//initializing and declaring variables and constants
 	
	final double GALLONS_OF_WATER = 7.48;
	
	final double PI = 3.14;
	
	double radius =15;
	
	double averageDepth = 0;
	
	double gallonsOfWater;
	
	double area;
	
	double undergroundSurfaceArea;
	
	double volume;
	
	/* we ask the user for the radius,and we ask the user for the depth of the 
	 * pool, then we can calculated the area, volume, average depth, gallons of water,
		and the underground surface area of the pool. */
	
	DecimalFormat df= new DecimalFormat("0.0");

	Scanner scan = new Scanner(System.in);	
	
	System.out.print("Enter the radius of the pool: " );
	radius = scan.nextDouble();
	
	area = radius * radius * PI;

	System.out.print("Enter the average depth of the pool: ");

	averageDepth = scan.nextDouble();

	volume = area * averageDepth;

	gallonsOfWater = volume * GALLONS_OF_WATER;

	undergroundSurfaceArea = 2 * PI * radius * averageDepth + 2* PI* radius *radius;
 
	/*Prints out the result of the Area, Volume, Gallons of water
	 * and the underground surface of the pool
	 */
		System.out.println("");
		
		System.out.println("Area = " + df.format(area));
		
		System.out.println("Volume = " + df.format(volume));
		
		System.out.println("Gallons of water = " + df.format(gallonsOfWater));
		
		System.out.println("Underground surface area = " + df.format(undergroundSurfaceArea));
	}

}
