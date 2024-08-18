/**
 * 
 */
package edu.ilstu;
import java.util.Scanner;
import java.util.Random;
import java.util.random.*;
/**
 * @author stefan
 *
 * takes the arrays from the fileHealper and runs the game operation
 *
 */
public class Game {
static Questions [] questionArray = new Questions [10];
static String teamName;
static int teamScore = 0;
static int [] choicesArray= new int [20];
static int [] scoresArray= new int [20];
static Questions [] questions;
Random ran = new Random();

public Game(String teamName, Questions [] questions) {
	for (int i = 0; i < choicesArray.length; i++) {
		choicesArray[i] = -1;
	}
	this.teamName = teamName;
	choicesArray = new int[110];
	scoresArray = new int [110];
	this.questionArray = questions;
	
	// randomizes the question
	for (int i = 0; i < questionArray.length; i++) {
		int rand = ran.nextInt(110);
		questionArray[i] = questionArray[rand];
		}
	}

	public static int getScore() {
		return teamScore;
	}
//play method is used to run player one and player two, diplays the questions and the choices theplayer can choose from and adds up the 
	// team score and sees how many points that player needs to win
public static void Play() {
	Scanner scan = new Scanner(System.in);
	int counter = 0;
	boolean turnover = false;
	while (counter < 10 && turnover == false) {
		String question = questionArray[counter].getretrieveQuestions();
		String [] listQuestions = questionArray[counter].getAnswer();
		int[] listPoints = questionArray[counter].arrayPoints();
			Questions question1 = new Questions(question, listQuestions, listPoints);
			while (counter < 10) {
				System.out.println(questionArray [counter]);
				System.out.println("Enter your answer: ");
				int input = scan.nextInt();
				while (input > 7 || input < 1) {
					System.out.println("Enter your answer: ");
					input = scan.nextInt();
				}
				choicesArray [counter] = input;
				int score = question1.getPoints(listPoints, input -1);
				scoresArray [counter] = score;
				teamScore = teamScore + score;
				counter ++;
			}   
		System.out.println("good job Player 1 !!");
		System.out.println("Your Score was" + teamScore);
		System.out.println("Player two will start now");
		
	}
	System.out.println("you will need" + (500 - teamScore) + "Points to win");
	System.out.println("press Enter on keyboard to start....");
	scan.nextLine();
	
	counter =0;
	turnover = true;
	while (counter < 10 && turnover == true) {
		String question = questionArray[counter].getretrieveQuestions();
		String [] listQuestions = questionArray[counter].getAnswer();
		int[] listPoints = questionArray[counter].arrayPoints();
		Questions question1 = new Questions(question, listQuestions, listPoints);
			while (counter < 10) {
				System.out.println(questionArray[counter]);
				System.out.println("Enter your answer: ");
				int	input = scan.nextInt();
				while (input > 7 || input < 1) {
					System.out.println("Enter your answer: ");
					input = scan.nextInt();
				}
				if (input != choicesArray[counter]) {
					Questions.questionsSelected = false;
				} else {
					Questions.questionsSelected = true;
				}
				if (Questions.questionsSelected == false) {
					int score = question1.getPoints(listPoints, input -1);
					choicesArray [counter + 10] = input;
					scoresArray [counter + 10] = score;
					teamScore = teamScore + score;
					System.out.println("Great Answer! You get" + score + "for this question");
					System.out.println("you need" + (500 - teamScore) + "to win");
				}
				else {
					int score = 0;
					System.out.println("Too Bad! PLayer one answered the same answer. You get no points for this Question");
					System.out.println("you need" + (500 - teamScore) + "to win");
					choicesArray[counter + 10] = input;
					scoresArray[counter + 10] = 0;
				}
				counter ++;
				Questions.questionsSelected = false;
				input = 0;
				
			}   
		}
	
	FileHelper.writeToFile(questionArray, choicesArray, scoresArray);
	if (teamScore < 500) {
		System.out.println("Game Over!");
		System.out.println("Better luck next time");
	}
teamScore = 0;

}
}