package edu.ilstu;
/*
 * @Author: Stefan Tujarov 
 * 
 * ULID: SBTUJAR
 *  
 *  Aircraft class that used for each individual aircraft
 */

import java.time.LocalDate;

public class Aircraft {

	//instance variable 
	
	private String aircraftName;
	private String regNumber;
	private String manufacturer;
	private double maxRange;
	private int crewSize;
	private int yearPutInService;
	private double maxServiceWeight;
	private int numPassengers;
	private String lastMaintenanceDate1;
	private double currentAirMiles;
	private LocalDate lastmaintenanceDate;
	private double lastmaintenanceMiles;

	//Default constructor 
	public Aircraft () {
	}

	//parameterized constructor to set all the instance variables
	public Aircraft(String aircraftName, String regNumber, String manufacturer, double maxRange, int crewSize, int yearPutInService, 
			double maxServiceWeight, int numPassengers, double currentAirMiles, LocalDate lastmaintenanceDate, double lastmaintenanceMiles) {
		this.aircraftName = aircraftName;
		this.regNumber = regNumber;
		this.manufacturer = manufacturer;
		this.maxRange = maxRange;
		this.crewSize = crewSize;
		this.yearPutInService = yearPutInService;
		this.maxServiceWeight =  maxServiceWeight;
		this.numPassengers = numPassengers;
		this.currentAirMiles = currentAirMiles;
		this.lastmaintenanceDate = lastmaintenanceDate;
		this.lastmaintenanceMiles = lastmaintenanceMiles;
	}

	/**
	 * @return
	 * getter that returns the aircraft name
	 */
	public String getAircraftName() {
		return aircraftName;
	}

	/**
	 * @param aircraftName
	 * 
	 * setter that sets aircraft name to aircraft name
	 */
	public void setAircraftName(String aircraftName) {
		this.aircraftName = aircraftName;
	}

	/**
	 * @return
	 * 
	 * getter that returns back regNumber
	 */
	public String getRegNumber() {
		return regNumber;
	}

	/**
	 * @param regNumber
	 * 
	 * setter that sets the negNumber
	 * 
	 */
	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	/**
	 * @return
	 * getter that returns back who the manufacturer 
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * @param manufacturer
	 * 
	 * setter that sets the manufacturer
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	/**
	 * @return
	 * getter that turns back the maximum range 
	 */
	public double getMaxRange() {
		return maxRange;
	}

	/**
	 * @param maxRange
	 * 
	 * setter that sets the max range 
	 */
	public void setMaxRange(double maxRange) {
		this.maxRange = maxRange;
	}

	/**
	 * @return
	 * getter that that returns back the number of the crew size 
	 */
	public int getCrewSize() {
		return crewSize;
	}

	/**
	 * @param crewSize
	 * 
	 * setter that sets the number of the crew size to the crew size 
	 */
	
	public void setCrewSize(int crewSize) {
		this.crewSize = crewSize;
	}

	/**
	 * @return
	 * 
	 * getter that returns back the year that aircraft was put in service
	 */
	public int getYearPutInService() {
		return yearPutInService;
	}

	/**
	 * @param yearPutInService
	 * 
	 * setter that sets the years put in service
	 */
	public void setYearPutInService(int yearPutInService) {
		this.yearPutInService = yearPutInService;
	}

	/**
	 * @return
	 * 
	 * getter that returns back the max service weight 
	 */
	public double getMaxServiceWeight() {
		return maxServiceWeight;
	}

	/**
	 * @param maxServiceWeight
	 * 
	 * setter that sets the max service weight 
	 */
	public void setMaxServiceWeight(double maxServiceWeight) {
		this.maxServiceWeight = maxServiceWeight;
	}

	/**
	 * @return
	 * 
	 * getter that returns back the number of passengers 
	 */
	public int getNumPassengers() {
		return numPassengers;
	}

	/**
	 * @param numPassengers
	 * 
	 * setter that sets the number of passenger
	 */
	public void setNumPassengers(int numPassengers) {
		this.numPassengers = numPassengers;
	}

	/**
	 * @return
	 * 
	 * getter that returns back the last maintenance date
	 */
	public LocalDate getLastmaintenanceDate() {
		return lastmaintenanceDate;
	}
	
	/**
	 * @return
	 * 
	 * getter that returns back the current air miles
	 */
	public double getCurrentAirMiles() {
		return currentAirMiles;
	}

	/**
	 * @param lastmaintenanceDate
	 * 
	 * setter that sets the last maintenance date
	 */
	public void setLastmaintenanceDate(LocalDate lastmaintenanceDate) {
		this.lastmaintenanceDate = lastmaintenanceDate;
	}

	/**
	 * @return
	 * getter that returns back the last maintenance miles 
	 */
	public double getLastmaintenanceMiles() {
		return lastmaintenanceMiles;
	}

	/**
	 * @param lastmaintenanceMiles
	 * 
	 * setter that sets the last maintenance mile
	 */
	public void setLastmaintenanceMiles(double lastmaintenanceMiles) {
		this.lastmaintenanceMiles = lastmaintenanceMiles;
	}
	
	/**
	 * @param setCurrentAirMiles
	 * 
	 * setter that sets the current air miles
	 */
	public void setCurrentAirMiles (double setCurrentAirMiles) {
		this.currentAirMiles = currentAirMiles;
	}

	/**
	 * @return
	 * 
	 * method to determine if the aircraft needs maintenance
	 */
	public boolean needsMaintence() {
		LocalDate currentDate = LocalDate.now(); // gets current date 
			return currentDate.minusMonths(3).isAfter(lastmaintenanceDate) || lastmaintenanceMiles >= 150_000; 
			// check if last maintenance date is more than 3 months ago or if the mileage is more than 150,000 miles
	}
	
	/**
	 * @return
	 * 
	 *  method to determine if the aircraft should be retired
	 */
	public boolean shouldRtire() {
		
		LocalDate currentDate = LocalDate.now();
			return currentDate.getYear() - yearPutInService > 20 || lastmaintenanceMiles >= 2_000_000;
	}
	
	// toString that prints out everything
	public String toString() {
		return aircraftName + regNumber + manufacturer +maxRange+ crewSize+ yearPutInService+maxServiceWeight+numPassengers+lastmaintenanceDate+lastmaintenanceMiles;
	}

}
