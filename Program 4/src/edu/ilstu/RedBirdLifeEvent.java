package edu.ilstu;

import java.util.Random;

public class RedBirdLifeEvent {

	public static double numberOfEvents =0;
	private String barCode;
	private String locationRoomNumber;
	private String eventName;
	private String eventType;
	private double requestedSeats = 0;
	private double seatCapacity = 0;
	private double seatsTaken = 0;
	
	/**
	 *  default constructor that seats the instance variables to default
	 */
	public RedBirdLifeEvent() {
	
		
	}

	/**
	 * @param newEventName
	 * @param newEventType
	 * 
	 * constructor that has two variables one string for newEventName, and another string 
	 * that is the newEventType
	 */
	public RedBirdLifeEvent(String newEventName, String newEventType) {
		this.eventName = newEventName;
		this.eventType = newEventType;
		calcMaximumSeats(newEventType);
		barCode = generateBarCode();
	}



	private String generateBarCode() {
		
		Random rand = new Random();
		int generatedCode = rand.nextInt(9000)+1000;
		
		int spaceIndex = locationRoomNumber.indexOf(" ");
		barCode = eventName.substring(0, 1) + locationRoomNumber.substring(0, 1) + locationRoomNumber.substring(spaceIndex+ 1, spaceIndex + 2) + generatedCode;
		
		return barCode;
		
		
	}

	/**
	 * @param newEventName
	 * @param newEventType
	 * @param newSeatCapacity
	 * 
	 * Another default constructor that passes three variables, same as last constructor but now there 
	 * is another new variables thats a double and its called newSeatCapacity
	 */
	public RedBirdLifeEvent(String newEventName, String newEventType, double newSeatCapacity) {
		this.eventName = newEventName;
		this.eventType = newEventType;
		this.seatCapacity = newSeatCapacity;
		calcMaximumSeats(newEventType);
		barCode = generateBarCode();
	}

	

	private void calcMaximumSeats(String eventType) {
		
		switch (eventType) {
		case "Workshop":
			this.locationRoomNumber = "Julian Hall 28";
			this.seatCapacity = 30;
		break;
		
		case "Seminar":
			this.locationRoomNumber = "Visual Arts 151";
			this.seatCapacity = 100;
		break;
		
		case "Career fair":
			this.locationRoomNumber = "Performing Arts Lobby";
			this.seatCapacity = 10000000;
		break;
		}
	}

	public static double getNumberOfEvents() {
		return numberOfEvents;
	}

	public static void setNumberOfEvents(double numberOfEvents) {
		RedBirdLifeEvent.numberOfEvents = numberOfEvents;
	}

	/**
	 * @return
	 * String method to return bar code 
	 */
	public String getBarCode() {
		return barCode;
	}

	/**
	 * @param barCode
	 * setter for bar codes
	 */
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	/**
	 * @return
	 * String method that returns the location and room number for events 
	 */
	public String getLocationRoomNumber() {
		return locationRoomNumber;
	}

	/**
	 * @param locationRoomNumber
	 * setter that sets the location and room number to a different location and room number 
	 */
	public void setLocationRoomNumber(String locationRoomNumber) {
		this.locationRoomNumber = locationRoomNumber;
	}

	/**
	 * @return
	 * String method used to return event name 
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * @param eventName
	 * setter to set the event name 
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	/**
	 * @return
	 * String method getter that returns the Event type 
	 */
	public String getEventType() {
		return eventType;
	}

	/**
	 * @param eventType
	 * setter that sets the event type 
	 */
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	/**
	 * @return
	 * double method that returns the requested seats that the user asks for 
	 */
	public double getRequestedSeats() {
		return requestedSeats;
	}

	/**
	 * @param requestedSeats
	 * Setter that sets the requested seats 
	 */
	public void setRequestedSeats(double requestedSeats) {
		this.requestedSeats = requestedSeats;
	}

	/**
	 * @return
	 * double method that returns back the seat Capacity for each event
	 */
	public double getSeatCapcity() {
		return seatCapacity;
	}

	/**
	 * @param seatCapcity
	 * setter that sets the seat capacity to a different number 
	 */
	public void setSeatCapcity(double seatCapcity) {
		this.seatCapacity = seatCapcity;
	}

	/**
	 * @return
	 * double method that returns back the seats taken 
	 */
	public double getSeatsTaken() {
		return seatsTaken;
	}

	/**
	 * @param seatsTaken
	 */
	public void setSeatsTaken(double seatsTaken) {
		this.seatsTaken = seatsTaken;
	}

	
	/**
	 * @return
	 * method used to get the available seats in the events 
	 */
	public double getAvaliableSeats() {
		return seatCapacity - seatsTaken;
	}
	
	/**
	 * @return
	 * Registration for events 
	 */
	public boolean register(){
		return register(1.0);
		
		
	}
	
	/**
	 * @param requestedSeats
	 * @return
	 * Registration that lets user know the amount of seats for a a event and asks user how many 
	 * seats they want to request for the event  
	 */
	public boolean register(double requestedSeats) {
		if (eventType.equals("Career fair")){
			seatsTaken += requestedSeats;
			return true;
		}else {
			double avaliableSeats = getAvaliableSeats();
			if(avaliableSeats >= requestedSeats) {
				seatsTaken += requestedSeats;
				return true;
				
			}else {
				return false;
			}
		}
	}
	
	
	
	public static void displayMenu() {
		System.out.println("Please Choose one of the following");
		System.out.println("                                  ");
		System.out.println("L - list all avalible events");
		System.out.println("IR - individual registration");
		System.out.println("GR - group registration");
		System.out.println("Q - quit");
		System.out.print("Enter your choice: ");
	
	}
	
	
	/**
	 *to string that prints out/ returns the bar code, location number, event name, event type and the avaliable seats 
	 */
	public String toString() {
		return barCode + "\t"+ locationRoomNumber + "\t\t" + eventName + "\t" + eventType + " \t"+ getAvaliableSeats() ;
	}



}
