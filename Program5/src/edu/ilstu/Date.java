package edu.ilstu;

/**
 * @author stefa
 *
 */
public class Date {

	private int year;
	private int month;
	private int day;
	
	/**
	 *  default Date constructor has default dates 
	 */
	public Date() {
		
	}
	
	/**
	 * constructor that has year, month, day
	 * 
	 * @param year
	 * @param month
	 * @param day
	 */
	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	/**
	 * @return
	 * 
	 * getter that returns year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year
	 * 
	 * setter that passes year
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return
	 * 
	 * getter that returns month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @param month
	 * 
	 * setter that passes month
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * @return 
	 * 
	 * getter that returns day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * @param day
	 * 
	 * setter that passes day
	 */
	public void setDay(int day) {
		this.day = day;
	}


	/**
	 *toString that returns year, month, and day
	 */
	public String toString() {
		return "Date:" + this.year + "/" + this.month + "/" + this.day;
	}
	
	
	
}
