package week2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * Class: CMSC203 Program: Project 1 Instructor: Professor Gary Thai
 * Description: The ESPGame class implements a simple game where a random color
 * is selected from a file, and the user tries to guess the correct color. After
 * 3 rounds, the score is displayed along with user information. Due: 09/20/2024
 * Platform/compiler: Eclipse I pledge that I have completed the programming
 * assignment independently. I have not copied the code from a student or any
 * source. I have not given my code to any student. Print your Name here: Seid
 * Jemal
 */

public class ESPGame {

	public static void main(String[] args) throws FileNotFoundException {

		// Scanner for keyboard input
		Scanner keyboard = new Scanner(System.in);

		// Random number generator for selecting random colors
		Random random = new Random();

		// Constants
		final String END = "Game over!";
		final int ROUND = 3;

		// Variable to keep track of the user's score
		int score = 0;

		// Open the colors file
		Scanner inputFile = new Scanner(new File("C:/Users/seid0/eclipse-workspace/MCweek1/src/week1/colors.txt"));

		// Print the list of colors once at the start of the game
		while (inputFile.hasNextLine()) {

			System.out.println(inputFile.nextLine());
		}
		// Close the file after printing
		inputFile.close();

		// Game rounds loop
		int round = 1;
		while (round <= ROUND) {

			// Reopen the file for each round to pick a random color
			inputFile = new Scanner(new File("C:/Users/seid0/eclipse-workspace/MCweek1/src/week1/colors.txt"));

			int currentLineNumber = 0;
			String selectedColor = null;

			// Generate a random line number between 1 and 16 (there are 16 colors)
			int randomLineNumber = random.nextInt(16) + 1;

			// Find the randomly selected line
			while (inputFile.hasNextLine()) {
				currentLineNumber++;
				String line = inputFile.nextLine();

				// If the current line matches the randomly selected line number
				if (currentLineNumber == randomLineNumber) {

					selectedColor = line;

					break;// Exit the loop once the color is found
				}

			}
			// Close the file after selecting the color
			inputFile.close();

			// Find the position of the space in the selected color string
			int i = 0;
			while (selectedColor.charAt(i) != ' ') {
				i += 1;
			}

			// Take the actual color name (everything after the space)
			String splitColor = selectedColor.substring(i + 1, selectedColor.length());

			System.out.println();

			// Start the round
			System.out.println("Round " + round);
			System.out.println();
			System.out.println("I am thinking of a color.");
			System.out.println("Is it one of list of colors above?");
			System.out.print("Enter your guess: ");

			// Get user input and convert to lowercase for comparison
			String userInput = keyboard.nextLine();
			String lowerCase = userInput.toLowerCase();

			System.out.println();

			// Reveal the color that was randomly selected
			System.out.println("I was thinking of " + splitColor);
			System.out.println();

			// Check if the user's guess matches the selected color
			if (lowerCase.equals(splitColor)) {
				score += 1;

			}

			round++;// Move to the next round

		}

		// Display the game result
		System.out.println(END);

		System.out.println("You guessed " + score + " out of " + ROUND + " colors correctly.");

		// Asking and collecting user details
		System.out.println("Enter your name: ");

		String name = keyboard.nextLine();

		System.out.println("Describe yourself: ");

		String discription = keyboard.nextLine();

		System.out.println("Due Date: ");

		String dueDate = keyboard.nextLine();

		// Display user details
		System.out.println("User Name: " + name);

		System.out.println("User Description: " + discription);

		System.out.println("Date: " + dueDate);

		// Close the keyboard input scanner
		keyboard.close();

	}

}
