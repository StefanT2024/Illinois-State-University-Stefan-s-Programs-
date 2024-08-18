/**
 * 
 */
package edu.ilstu;

import java.util.Scanner;
public class FastMoneyRound {

	
	public static void main(String[] args) {
		Questions [] questions = FileHelper.readInventory();
System.out.println("#######################");
System.out.println("Welcome to Family Fued!");
System.out.println("#######################");

System.out.println("                       ");

Scanner scan = new Scanner(System.in);
System.out.println("Please Enter Team Name: ");
String teamNameScan = scan.nextLine();	
	
System.out.println("Good Luck Team " + (teamNameScan));
	
Game game1 = new Game(teamNameScan, questions);
System.out.println("GoodLuck team " + teamNameScan);
System.out.println("Player One will start now");
System.out.println("Press enter on your keyboard to start: ");
	scan.nextLine();
	Game.Play();
	
	}

}
