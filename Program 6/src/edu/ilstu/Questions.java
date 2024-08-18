/**
 * 
 */
package edu.ilstu;

import java.util.Scanner; 

public class Questions {
private String questionText;

private int NUMBER_OF_QUESTIONS = 7;
private String [] answers;
private int [] points;
static boolean questionsSelected = false;

	public Questions (String questionText, String [] arrayAnswers, int [] arrayPoints) {
		
		this.questionText = questionText;
		this.answers = arrayAnswers;
		this.points = arrayPoints;
		arrayAnswers = new String[NUMBER_OF_QUESTIONS];
		arrayPoints = new int[NUMBER_OF_QUESTIONS];
		
	}

public String getretrieveQuestions() {
	return questionText;
}

public void setAnswers(String [] answer, int index, String answers) {
	answer [index] = answers;
	
}

public void setIndex(int [] points, int index, int points1) {
	points [index] = points1;
}

public String []  getAnswer() {
	return answers;
	
}
public int [] arrayPoints() {
	return points;
}

public static String getAnswers(String [] arrayAnswers, int index) {
	return arrayAnswers[index];
}

public int getPoints(int [] arrayPoints, int index) {
	return arrayPoints[index];
}

public void setBoolean() {
	this.questionsSelected = true;
}
public String toString() {
	System.out.println(questionText);
	int count = 0;
	String string = "";
	while (count < answers.length) {
		string += ((count + 1) + ". " + answers[count] + "\n");
		count++;
	}	
	return string;
	
}
}
