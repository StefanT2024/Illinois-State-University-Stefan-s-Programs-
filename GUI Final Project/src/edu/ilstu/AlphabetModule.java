package edu.ilstu;

/*
 * AlphabetModule class represents a learning module for the Children's Learning Game, focusing on alphabets.
 * It prompts the player with images corresponding to randomly selected letters (A, B, or C) and evaluates their responses. 
 * The module keeps track of the player's score and highest achieved score.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class AlphabetModule {

	// Player's name and highest score variables
	private final String playerName;
	private int highestAlphabetScore = 0;

	// Number of questions per round
	private final int QUESTIONS_PER_ROUND = 5;

	// Valid letters for the game
	private final List<Character> validLetters = Arrays.asList('A', 'B', 'C');

	// Map to store images associated with each letter
	private final Map<Character, List<String>> alphabetImages = new HashMap<>();

	// Constructor initializes the player's name and sets up images for each letter
	public AlphabetModule(String playerName) {
		this.playerName = playerName;
		initializeAlphabetImages();
	}

	// Main method to run the alphabet learning module
	public void runModule() {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		int score = 0;

		// Loop through the specified number of questions per round
		for (int i = 0; i < QUESTIONS_PER_ROUND; i++) {
			char randomLetter = getRandomLetter();

			// Get options for the current letter and shuffle them
			List<String> options = getAlphabetOptions(randomLetter);
			Collections.shuffle(options);

			// Display the question and available options
			System.out.println("\nQuestion " + (i + 1) + ": What image represents the letter " + randomLetter + "?");
			displayOptions(options);

			// Get and evaluate the user's choice
			int userChoice = getUserChoice(scanner, options.size());

			if (userChoice == options.indexOf(alphabetImages.get(randomLetter).get(0)) + 1) {
				System.out.println("Correct! Good job, " + playerName + "!");
				score++;
			} else {
				System.out.println(
						"Oops! That's incorrect. The correct answer is: " + alphabetImages.get(randomLetter).get(0));
			}
		}

		// Update and display the highest score
		updateHighestScore(score);
		scanner.close();
	}

	// Initialize the map with images for each letter
	private void initializeAlphabetImages() {
		alphabetImages.put('A', Arrays.asList("Apple.jpg", "Airplane.jpg", "Ant.jpg"));
		alphabetImages.put('B', Arrays.asList("Banana.jpg", "Ball.jpg", "Bear.jpg"));
		alphabetImages.put('C', Arrays.asList("Cat.jpg", "Car.jpg", "Cake.jpg"));
	}

	// Get a random letter from the validLetters list
	private char getRandomLetter() {
		return validLetters.get(new Random().nextInt(validLetters.size()));
	}

	/*
	 * Initialize options with the first image associated with the given letter.
	 * For other letters, add two randomly selected images to the options list.
	 * Exclude the entry for the given letter, Get the list of associated images
	 * Randomly select an image Limit to two randomly selected images, Add each
	 * randomly selected image to options
	 */
	private List<String> getAlphabetOptions(char letter) {
		List<String> options = new ArrayList<>(Collections.singletonList(alphabetImages.get(letter).get(0)));
		alphabetImages.entrySet().stream().filter(entry -> entry.getKey() != letter).map(Map.Entry::getValue)
				.map(valueList -> valueList.get(new Random().nextInt(valueList.size()))).limit(2).forEach(options::add);
		return options;
	}

	// Display the available options to the player
	private void displayOptions(List<String> options) {
		options.forEach(option -> System.out.println(options.indexOf(option) + 1 + ". " + option));
	}

	// Get and validate the user's choice within the given range
	private int getUserChoice(Scanner scanner, int maxChoice) {
		int userChoice;
		do {
			System.out.print("Enter your choice (1-" + maxChoice + "): ");
			while (!scanner.hasNextInt()) {
				System.out.print("Invalid input. Please enter a number: ");
				scanner.next();
			}
			userChoice = scanner.nextInt();
		} while (userChoice < 1 || userChoice > maxChoice);
		return userChoice;
	}

	// Update and display the highest score if the current score is higher
	private void updateHighestScore(int score) {
		if (score > highestAlphabetScore) {
			highestAlphabetScore = score;
			System.out.println("Congratulations, " + playerName + "! You've achieved a new high score!");
		}
	}
}
