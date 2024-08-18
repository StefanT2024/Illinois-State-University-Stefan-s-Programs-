package edu.ilstu;

/*
 * CountingModule class is part of the Children's Learning Game, focusing on counting various objects.
 * It asks the player to count randomly shown images (Clover, Flower, Heart) and keeps track of their score.
 *
 * Note: Currently, the module doesn't handle unexpected inputs (non-numeric) smoothly. 
 */

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CountingModule {

	private final String playerName;
	private final int QUESTIONS_PER_ROUND = 5;
	private int highestCountingScore = 0;

	private final List<String> countingImages = Arrays.asList("Clover.png", "Flower.jpeg", "Heart.jpeg");

	public CountingModule(String playerName) {
		this.playerName = playerName;
	}

	public void runModule() {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		int score = 0;

		for (int i = 0; i < QUESTIONS_PER_ROUND; i++) {
			String randomImage = countingImages.get(random.nextInt(countingImages.size()));
			int randomCount = random.nextInt(5) + 1;

			System.out.println("\nQuestion " + (i + 1) + ": Count the " + randomImage + "s");
			for (int j = 0; j < randomCount; j++) {
				System.out.print("[" + randomImage + "] ");
			}

			int userCount = getUserCount(scanner);

			if (userCount == randomCount) {
				System.out.println("Correct! Well done, " + playerName + "!");
				score++;
			} else {
				System.out.println("Oops! That's incorrect. The correct count is: " + randomCount);
			}
		}

		if (score > highestCountingScore) {
			highestCountingScore = score;
			System.out.println("Congratulations, " + playerName + "! You've achieved a new high score!");
		}

	}

	private int getUserCount(Scanner scanner) {
		int userCount = 0;
		boolean validInput = false;

		while (!validInput) {
			System.out.print("Enter your count: ");
			try {
				userCount = scanner.nextInt();
				validInput = true;
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a number.");
				scanner.next();
			}
		}

		return userCount;
	}

}

