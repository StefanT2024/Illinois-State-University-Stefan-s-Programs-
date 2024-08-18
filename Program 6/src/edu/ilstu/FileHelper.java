/**
 * 
 */
package edu.ilstu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author stefan
 * reads the question from csv and writes the question on a seperate text file 
 */
public class FileHelper {

	public static Questions[] readInventory() {
		int count = 0;
		Questions[] question = new Questions[110];
		
		try	{								   															   						
			File f = new File("Questions.csv");  					
			Scanner scan = new Scanner(f);	
			scan.nextLine();  
			while (scan.hasNextLine())	{							
				String[] line = scan.nextLine().split(",");			
				String Question = line[0];
				String [] Answers = new String[7];
				int [] Points = new int[7];
				Answers[0] = line[1];
				Answers[1] = line[3];
				Answers[2] = line[5];
				Answers[3] = line[7];
				Answers[4] = line[9];
				Answers[5] = line[11];
				Answers[6] = line[13];
				
				Points[0] = Integer.parseInt(line[2]);
				Points[1] = Integer.parseInt(line[4]);
				Points[2] = Integer.parseInt(line[6]);
				Points[3] = Integer.parseInt(line[8]);
				Points[4] = Integer.parseInt(line[10]);
				Points[5] = Integer.parseInt(line[12]);
				Points[6] = Integer.parseInt(line[14]);
				question[count] = new Questions(Question, Answers, Points);
				count++;
			
				
			}
		} catch (FileNotFoundException ife)	{															
			System.out.println("Unable to open file.");				
			System.out.println("Closing the program.");				
		} catch (InputMismatchException misexc)	{															
			System.out.println("Invalid data type.");				
		}			
		return question;
	}
	
	
public static void writeToFile(Questions [] questionList, int [] choiceList, int [] pointList) {
	String Name = Game.teamName;
	
	try {
		int totalScore = Game.getScore();
		FileWriter f = new FileWriter(Name + ".txt");
		PrintWriter out = new PrintWriter(f, true);
		out.println("Team " + Name + " results");
		int counter = 0;
		while (counter < 10) {
			String questionText = questionList[counter].getretrieveQuestions();	
			int [] pointArray = questionList[counter].arrayPoints();
			String [] answerArray = questionList[counter].getAnswer();
			String player1Answer = answerArray[choiceList[counter]];
			String player2Answer = answerArray[choiceList[counter + 10]];
			int player1Points = pointArray[choiceList[counter]];
			int player2Points = pointArray[choiceList[counter + 10]];
			
			out.println(counter + 1 + ". " + questionText);
			out.println("player 1 answered: " + player1Answer + " and got " + player1Points + " points");
			if (choiceList[counter + 10] == -1) {
				out.println("Game is over. Player 2 did not answer\n");
			} else {
				out.println("player 2 answered: " + player2Answer + " and got " + player2Points + " points\n");
			counter++;
			}
		}
		out.println("total points for this team: " + totalScore);
		out.close();
		counter =0;
	}		
	catch (IOException e) {
	System.err.println(e.getLocalizedMessage());
}
	}
}
