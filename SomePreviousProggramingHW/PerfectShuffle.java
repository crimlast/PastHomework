//
// 	Name: Barrientos, Joshua
//	Homework: #
//	Due: May 6, 2020(end of the day)
// 	Course: cs-2400-02
//
// 	Description:
// 		Creation of a PerfectShuffle class to test the inShuffle method with using the ArrayDeque from java.
//

import java.util.*;

public class PerfectShuffle {
    public static void main(String[] args){
        int[] deck = new int[52];
        if(args.length > 0 && args[0] != null){
            String number = args[0];
            int newLength = Integer.parseInt(number);
            deck = new int[newLength];
        }
        int[] deckOther = new int[deck.length];

        for(int i = 0; i < deck.length; i++){
            deck[i] = i;
            deckOther[i] = i;
        }
        System.out.println("Card Shuffle by J. Barrientos\n\n" + deck.length + " Cards\n");

        System.out.println("Original:");
        for(int n : deck){
            System.out.println(cardName(n));
        }
        int counter =  1;
        deckOther = inShuffle(deckOther);
	boolean equals = false;
	int counterCorrect = 0;

        while(!equals){
            System.out.println("\nRound " + counter++ + ":");
            for(int element : deckOther){
                System.out.println(cardName(element));
            }
            counterCorrect = 0;
            equals = true;
            for(int i = 0; i < deck.length; i++){
		if(deck[i] != deckOther[i]){
                    equals = false;
		}
            }
            deckOther = inShuffle(deckOther);
        }

        System.out.println("\nOriginal order in " + --counter + " in-shuffle");

    }

	public static int[] inShuffle(int[] deck){
		Deque<Integer> deque = new ArrayDeque<Integer>();
		int[] topHalf = new int[deck.length/2];
 		int[] bottom;
		if(deck.length % 2 == 1){
			bottom = new int[deck.length/2 + 1];
  		}
		else{
			bottom = new int[deck.length/2];
		}

		int[] shuffled = new int[deck.length];
		for(int i = 0; i < deck.length/2; i++){
			topHalf[i] = deck[i];
		}
		for(int i = deck.length/2; i< deck.length; i++){
			bottom[i - deck.length/2] = deck[i];
		}
		for(int i = 0; i< deck.length; i++){
		       if(i%2 == 1 ){
				deque.add(topHalf[i/2]);
		}
	       else{
			deque.add(bottom[i/2]);
		}
	}
	for(int i = 0; i< deck.length; i++){
        	shuffled[i] = deque.removeFirst();
    	}

    	return shuffled;
	}

    public static String cardName(int value){
        String name = value%13 + 1 + " ";
        if(value%13 == 0){
            name = "Ace ";
        }
        if(value%13 == 10){
            name = "Jack ";
        }
        if(value%13 == 11){
            name = "Queen ";
        }
        if(value%13 == 12){
            name = "King ";
        }
        name += "of ";
        if(value <= 13){
            name += "Spades";
        }
        else if(value <= 26){
            name += "Diamonds";
        }
        else if(value <= 39){
            name += "Hearts";
        }
        else{
            name += "Clubs ";
        }
        return name;

    }
}

