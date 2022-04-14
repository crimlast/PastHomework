//
//	Name:		Barrientos, Joshua
//	Project:	#2
//	Due:		October 7, 2019
//	Course:		cs-1400-03-f19
//
//	Description:
//			A code that will generate a random number fromm 1 to 100 and the user will have up
//			to 8 tries to guess the number. The user can give up by inputting 0 as their guess.
//
import java.util.Scanner;
import java.util.Random;

public class GuessingGame
{
	public static void main(String[]args)
	{
		System.out.println("J. Barrientos's Number Guessing Game\n");
		Random gen = new Random();
		int ran = gen.nextInt(100)+1;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("A secret number between 1-100 has been generated...\n");
		System.out.print("Enter your guess? ");
		int input = keyboard.nextInt();
		int counter = 1;
		while(counter < 8 && input != 0 && input != ran)
		{
			if(input > ran)
			{
				System.out.println("Guess is high, try again.");
			}
			else
			{
				System.out.println("Guess is low, try again.");
			}
			System.out.print("Enter your guess? ");
			input = keyboard.nextInt();
			counter++;
		}
		if(input == ran)
		{
			System.out.println("Correct in " + counter + " guesses.");
		}
		else
		{
			System.out.println("The secret number is " + ran +".");
		}
	}
}
