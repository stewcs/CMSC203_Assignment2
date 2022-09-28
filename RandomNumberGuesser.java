/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: This is the driver class for RNG.java. The purpose of this class is to test the RNG class. 
 * 				The program will generate a random number and prompt the user to guess the number. Each time the program will 
 * 				check the guessed number for validity, increment the guess counter, and provide feedback on the guess. 
 * 				The user may guess up to 7 times, each time the program will narrow the low and high number limits for the user.
 * Due: 09/29/2022
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Daniel Xu
*/

/* 
 * pseudocode
1. Initialize variables, scanner
2. Use RNG method to generate random number between 1 and 100
3. Prompt user to make a guess
4. Check if the number is valid, then check if it is correct, less than, or greater than the generated number
5. If guess is wrong, increment guess counter and adjust the low and high limits for user feedback.
6. Repeat until user guesses correctly or guess limit is reached.
7. If user guesses correctly, ask if the user wants to try again.
8. If user reaches maximum guess count, terminate the program.
9. End program.
*/


import java.util.*;


public class RandomNumberGuesser {
	

	public static void main(String[] args) {
		
		
		// Initialize Variables
		int guess;
		int number = RNG.rand();
		
		// Variables to hold lower and higher limits
		int LOWEST_LIMIT = 0;
		int HIGHEST_LIMIT = 100;
		
		// Sentinel to control execution of while loop
		boolean sen = true;
				
		
		// Opening Prompt
		System.out.println("This application generates a random number integer between 1 and 100 "
				+ "and asks the user to guess repeatedly until they guess correctly.");

		
		// Open Scanner
		Scanner input = new Scanner(System.in);

		// Initialize while loop
		while(sen) {
		System.out.println("Enter your guess: ");
				guess = input.nextInt();
				
		// Validate input before comparison.
		if(!RNG.inputValidation(guess, LOWEST_LIMIT, HIGHEST_LIMIT)){ 
			// leave empty
		} else {
				
				// Compare guess to number
				if (guess == number) { // if user guessed number correctly
					System.out.println("You guessed the number! Try again? Enter Yes or No");
					input.nextLine(); // clear scanner buffer
					String answer = input.nextLine();
					if(answer.equalsIgnoreCase("No"))
					System.exit(0); // Exit program if user does not wish to continue
					else // if user wish to continue, reset everything
					RNG.resetCount();
					number = RNG.rand();
					LOWEST_LIMIT = 0;
					HIGHEST_LIMIT = 100;
					
				}else if (guess < number) {
					System.out.println("Your guess was too low!");
					LOWEST_LIMIT = guess+1;
					// Display guess count and new limits
					System.out.println("Number of guesses: " + RNG.getCount());
					if(RNG.getCount() != 7) // if guess count is reached, do not display following text
					System.out.println("Enter your next guess between " + LOWEST_LIMIT + " and " + HIGHEST_LIMIT);
					
				}else if (guess > number) {
					System.out.println("Your guess was too high!");
					HIGHEST_LIMIT = guess-1;
					// Display guess count and new limits
					System.out.println("Number of guesses: " + RNG.getCount());
					if(RNG.getCount() != 7) // if guess count is reached, do not display following text
					System.out.println("Enter your next guess between " + LOWEST_LIMIT + " and " + HIGHEST_LIMIT);
				}
				
			}	
		
				// When user reaches maximum guesses
				if (RNG.getCount() == 7) {
						System.out.println("You have exceeded the maximum number of guesses, 7. The number was " + number + ".Try again.");
							System.exit(0);	
		}
		}
	}
}