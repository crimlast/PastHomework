//
//	Name:		Barrientos, Joshua
//	Homework:	1
//	Due:		2/14/20
//	Course:		cs-2400-01
//
//	Description:
//			A java program to simulate a game that takes in six cards and one at a time each player guesses which card is in the bag. If the
//			guess is correct, you remove the card and hand it to the player. The player with the most cards when the bag is empty is the winner.
//

import java.util.Random;
import java.util.Scanner;

public class CardGame{
	public static void main(String[] args){
		System.out.println("J. Barrientos's Card Game\n");
		BagInterface<Integer> cardList = new ArrayBag<>();
		Scanner keyboard = new Scanner(System.in);
		int player1 = 0;
		int player2 = 0;
		int card;
		Random ran = new Random();
		System.out.println("Six Cards Selected");
		int guess = 0;
		if(args.length == 1 && args[0].equals("debug")){
			for(int i = 0; i < 6; i++){
				card = ran.nextInt(13) + 1;
				if(cardList.contains(card)){
					i--;
				}
				else{
					cardList.add(card);
					System.out.print(card + " ");
				}
			}
		}
		else{
			for(int i = 0; i < 6; i++){
				card = ran.nextInt(13) + 1;
				if(cardList.contains(card)){
					i--;
				}
				else{
					cardList.add(card);
				}
			}
		}
		System.out.println("\n");
		while(!cardList.isEmpty()){
			System.out.print("Player 1? ");
			card = keyboard.nextInt();
			if(cardList.contains(card)){
				cardList.remove();
				player1++;
				System.out.println("Got Card");
			}
			System.out.print("Player 2? ");
			card = keyboard.nextInt();
			if(cardList.contains(card)){
				cardList.remove();
				player2++;
				System.out.println("Got Card");
			}
		}
		System.out.println();
		if(player1 > player2){
			System.out.println("Player 1 wins with " + player1 + " cards");
		}
		else if(player1 == player2){
			System.out.println("Game is a tie");
		}
		else{
			System.out.println("Player 2 wins with " + player2 + " cards");

		}
	}
}
