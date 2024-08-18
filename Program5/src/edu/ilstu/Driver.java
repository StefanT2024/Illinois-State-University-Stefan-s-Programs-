/**
 * 
 */
package edu.ilstu;

import java.util.Scanner;

/**
 * @author stefa
 *
 */
public class Driver {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Scanner intScan = new Scanner(System.in);
		MailBox [] mailboxes = new MailBox[5];
		MailBox mailbox1 = new MailBox("gmail");
		MailBox mailbox2 = new MailBox("outlook");
		MailBox mailbox3 = new MailBox("icloud");
		mailboxes[0] = mailbox1;
		mailboxes[1] = mailbox2;
		mailboxes[2] = mailbox3;
		
		Email email1 = new Email();
		email1.setDate(new Date(2022,11,5));
		email1.setSubject("Exam2 guidelines");
		Email email2 = new Email(new Date(2021,3,5),true,"Quiz3 in Ch7");
		Email email3 = new Email();
		email3.setDate(new Date(2020,11,3));
		email3.setSubject("Late submission policy");
		mailbox1.addEmail(new Email(new Date(2000,1,1),false,"placeholder"));
		mailbox3.addEmail(new Email(new Date(2000,1,1),false,"placeholder"));
		mailbox2.addEmail(email1);
		mailbox2.addEmail(email2);
		mailbox2.addEmail(email3);
		
		int choice = 99;
		boolean found = false;
		while (choice != 5) {	
			displayMenu();
			choice = intScan.nextInt();
			String client;
			
			while (choice > 5 || choice < 1) {
				System.out.println("Invalid input, select from 1 - 5: ");
				choice = intScan.nextInt();
				
			}
			
			
			switch (choice) {
			
			case 1:
				System.out.println("Enter client: ");
				client = scan.nextLine();
				found = false;
				while (found == false) {
					for (int i = 0; i < mailboxes.length; i++) {
						if (mailboxes[i] != null) {
							if (client.equals(mailboxes[i].getClient()) || found == true) {
								found = true;
							}
						}
					}
					if (found == false) {
						System.out.println("Client not found. Enter client name:");
						client = scan.nextLine();
					}
				}
				System.out.println(client + " account summary");
				System.out.println("The account has " + findMailbox(client, mailboxes).getActualSize() + " emails");
				System.out.println(findMailbox(client,mailboxes).countUrgent() + " email(s) was urgent");
				System.out.println(findMailbox(client,mailboxes));
				
				break;
			
			case 2:
				boolean isUrgent = false;
				System.out.println("For Which client: ");
				client =scan.nextLine();
				found = false;
				while (found == false) {
					for (int i = 0; i < mailboxes.length; i++) {
						if (mailboxes[i] != null) {
							if (client.equals(mailboxes[i].getClient()) || found == true) {
								found = true;
							}
						}
					}
					if (found == false) {
						System.out.println("Client not found. Enter client name:");
						client = scan.nextLine();
					}
				}
				System.out.println("Enter email information on one line as follows: "
						+ "<urgent>,<m>,<d>,<y>,<msg> ");
				String msg = scan.nextLine();
				
				String urgent = msg.substring(0, msg.indexOf(","));
				msg = msg.substring(msg.indexOf(",") + 1, msg.length());
				String month = msg.substring(0, msg.indexOf(","));
				msg = msg.substring(msg.indexOf(",") + 1, msg.length());
				String day = msg.substring(0, msg.indexOf(","));
				msg = msg.substring(msg.indexOf(",") + 1, msg.length());
				String year = msg.substring(0, msg.indexOf(","));
				msg = msg.substring(msg.indexOf(",") + 1, msg.length());
				String subject = msg.substring(0, msg.length());
				msg = msg.substring(msg.indexOf(",") + 1, msg.length());
				int y = Integer.parseInt(year);
				int m = Integer.parseInt(month);
				int d = Integer.parseInt(day);
				if (urgent.equals("true")) {
					isUrgent = true;
				}
				Email email = new Email(new Date(y, m, d), isUrgent, subject);
				addEmailToMailBox(client, mailboxes, email);
				break;
				
			case 3:
				System.out.println("For Which client?  ");
				client =scan.nextLine();
				found = false;
				while (found == false) {
					for (int i = 0; i < mailboxes.length; i++) {
						if (mailboxes[i] != null) {
							if (client.equals(mailboxes[i].getClient()) || found == true) {
								found = true;
							}
						}
					}
					if (found == false) {
						System.out.println("Client not found. Enter client name:");
						client = scan.nextLine();
					}
				}
				System.out.println("For what year? ");
				 int year1 = intScan.nextInt();
				 System.out.println(findMailbox(client, mailboxes).findEmail(year1));
				 break;
			case 4:
				System.out.println("For Which client?  ");
				client =scan.nextLine();
				found = false;
				while (found == false) {
					for (int i = 0; i < mailboxes.length; i++) {
						if (mailboxes[i] != null) {
							if (client.equals(mailboxes[i].getClient()) || found == true) {
								found = true;
							}
						}
					}
					if (found == false) {
						System.out.println("Client not found. Enter client name:");
						client = scan.nextLine();
					}
				}
				findMailbox(client, mailboxes).sortEmailsByDate();
				break;
			case 5:
				System.err.println("Goodbye!");
				System.exit(0);
			}
			
			
		
		}
		
		
	}

	
	public static void displayMenu() {
		System.out.println("Hello! What would you like to do?");
		System.out.println("1- \tList Emails in a mailbox");
		System.out.println("2- \tAdd an email to a mailbox");
		System.out.println("3- \tSearch for an email in a mailbox by year");
		System.out.println("4- \tSort emails in a mailbox by year");
		System.out.println("5- \tQuit");
	}
	
	public static MailBox findMailbox(String client, MailBox[] arr) {
		MailBox box = new MailBox();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null && arr[i].getClient().equals(client)) {
				box = arr[i];
			}
		}
		return box;
	}
	public static void addEmailToMailBox(String client, MailBox [] arr, Email email) {
		MailBox box = findMailbox(client, arr);
		box.addEmail(email);
		
	}
	
}
