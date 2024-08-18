package edu.ilstu;

import java.util.Arrays;

public class MailBox {

	private String client;
	private Email [] emails = new Email[10];
	private int actualSize;
	
	/**
	 * 
	 * Default constructor that has default values
	 */
	public MailBox() {
		this.client = "User";
		this.actualSize = 0;
	}
	
	/**
	 * @param client
	 * 
	 * constructor that calls default constructor
	 */
	public MailBox(String client) {
		this.client = client;
		new MailBox();
	}
	
	/**
	 * @return
	 * 
	 * getter that returns the client 
	 */
	public String getClient() {
		return client;
	}
	
	/**
	 * @param index
	 * @return
	 * 
	 * getter that returns the index of the emails array
	 */
	public Email getEmail(int index) {
		return emails[index];
	}
	
	/**
	 * @return
	 * 
	 * getter that returns the actual size
	 */
	public int getActualSize() {
		return actualSize;
	}

	
	/**
	 * @param email
	 * 
	 * setter that addsEmailes, to email array
	 * 
	 */
	
	public void addEmail(Email email) {
		if (actualSize == 10 ) {
			System.out.println("You have reached the maximum capacity. Upgrade your account.");
		} else {
			emails[actualSize] = email;
			actualSize++;
			System.out.println("Email added succesfully");
		}
		
	}

	/**
	 * setter that sorts the array by the year
	 */
	public void sortEmailsByDate() {
		Email temp;
		int items = 0;
		for (int i =0; i < emails.length; i++) {
			if (emails[i]!= null) {
				items++;
			}
		}
		Email [] emailArr = new Email[items];
		for (int i = 0; i < emailArr.length; i++) {
			emailArr[i] = emails[i];
		}
		for (int i = emailArr.length - 1; i < emailArr.length; i--) {
			for (int j = 0; j < i; j++) {
				if (emailArr[j].getDate().getYear() < emailArr[j + 1].getDate().getYear()) {
					temp = emailArr[j];
					emailArr[j] = emailArr[j + 1];
					emailArr[j + 1] = temp;
				}
			}
		}
		for (int i = 0; i < emailArr.length; i++) {
			emails[i] = emailArr[i];
		}
		System.out.println("Emails sorted by year!");
	}

	/**
	 * @param year
	 * @return
	 * 
	 * getter that returns and finds the array by the year 
	 */

	public Email findEmail(int year) {
		boolean found = false;
		int index = 0;
		int numFound = 0;
		for (int i = 0; i < actualSize; i++) {
			if (emails[i] != null && emails[i].getDate().getYear() == year) {
				if (found != true) {
					found = true;
					index = i;
				}
				numFound++;
			}
		}
		if (numFound == 1) {
			System.out.println("Found " + numFound + " email");
		} else {
			System.out.println("Found " + numFound + " emails");
		}
		return emails[index];
	}

	/**
	 * @return
	 * 
	 * getter that returns the counts which email are urgent 
	 */
	public int countUrgent() {
		int numUrgents = 0;
		for (int i = 0; i < actualSize; i++) {
			if (emails[i].isUrgent() == true) {
				numUrgents++;
			}
		}
		return numUrgents;
	}

	
	/**
	 * to string that returns the information summary of the emails
	 */
	public String toString() {
		String output = "";
		for (int i = 0; i < emails.length; i++) {
			if (emails[i] != null) {
				output = output + "Email " + (i + 1) + " info: " + emails[i].getDate() + " Subject: " + emails[i].getSubject() + "\n";
			}
		}
		return output;
		
	}
	
	
}

