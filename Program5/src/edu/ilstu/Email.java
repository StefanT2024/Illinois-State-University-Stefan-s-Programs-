package edu.ilstu;

public class Email {

	private Date date;
	private String subject;
	private boolean urgent;
	
	/**
	 * default constructor that has default values
	 */
	public Email() {
		this.date = new Date(2000, 1, 1);
		this.subject = "title";
		this.urgent= false;
	}
	
	/**
	 * @param date
	 * @param urgent
	 * @param subject
	 * 
	 * constructor that has the Date from the date class, and urgent, and the subject
	 */
	public Email(Date date, boolean urgent, String subject) {
		this.date = date;
		this.urgent = urgent;
		this.subject = subject;
	}
		
	/**
	 * @return
	 * 
	 * Getter that gets the date from the date class
	 */
	public Date getDate() {
		return date;
	}
	
	/**
	 * @param date
	 * 
	 * setter that sets the Date from the date class
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	/**
	 * @return
	 * 
	 * Getter thats a string that returns the subject
	 */
	public String getSubject() {
		return subject;
	}
	
	/**
	 * @param subject
	 * 
	 * setter that sets the subject
	 */
	public void setSubject(String subject) {
		this.subject =subject;
	}
	
	/**
	 * @return
	 * 
	 * getter that returns the urgent  
	 */
	public boolean isUrgent() {
		return urgent;
	}
	
	/**
	 * @param urgent
	 * 
	 * setter that sets the urgent 
	 */
	public void setUrgent(boolean urgent) {
		this.urgent = urgent;	
	}

	/**
	 * toString thats a string that returns the date and subject 
	 */
	
	public String toString() {
		return "Email info: " + date + " Subject: " + subject;
	}
	
	
	
	}
	

