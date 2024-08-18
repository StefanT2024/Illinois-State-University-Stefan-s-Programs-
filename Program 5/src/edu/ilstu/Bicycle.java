/**
 * 
 */
package edu.ilstu;

/**
 * @author Stefan Tujarov
 *
 */

import java.util.Scanner;
public class Bicycle {
private String bikeType;
private int wheelSize;
private boolean assembled;
private char gender;
private Bicycle bicycle;



public Bicycle (String bikeType, int wheelSize, boolean assembled, char gender) {

	this.bikeType = bikeType;
	this.wheelSize = wheelSize;
	this.assembled = assembled;
	this.gender = gender;
}

public Bicycle (Bicycle bicycle) {
	this.bicycle = bicycle;
}


public String getbikeType() {
	
	return bikeType;
}

public int getwheelSize() {
	
	return wheelSize;
}
public boolean getassembled() {
	
	return assembled;
}

public char getgender() {
	
	return gender;
}

public final String toString() {
	String gender;
	if (this.gender == 'm')
		gender = "Male";
	else
		gender = "Female";
		
	return ("Type: " + getbikeType() + "Size: " + getwheelSize() + "Assembled: " + getassembled() + "Gender: " + getgender());
}


}


