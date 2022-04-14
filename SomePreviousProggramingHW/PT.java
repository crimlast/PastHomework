//
//	Name:		Barrientos, Joshua
//	Homework:	3
//	Due:		Wednesday November 6, 2019
//	Course:		CS-1400-03-f19
//	Description:
//			A code that will create a Periodic Table object that read information about elements and be able to print
//			them out or find a specific element with its symbol.
//

import java.util.Scanner;
import java.io.File;

public class PeriodicTable
{
	private Element[] table;
	private int actualNumber;

	public PeriodicTable()

	{
		table = new Element[130];
		File periodic = new File("/user/tvnguyen7/data/periodictable.dat");
		Scanner keyboard = new Scanner(periodic);

		while (keyboard.hasNext())
		{
			int numberElement = keyboard.nextInt();
			String symbolElement = keyboard.next();
			double massElement = keyboard.nextDouble();
			String nameElement = keyboard.next();
			Element currentElement = new Element(numberElement, nameElement, symbolElement, massElement);
			actualNumber++;
			table[actualNumber] = currentElement;
		}
	}


	public void Print()
	{

		System.out.println("PeriodicTable by J. Barrientos\n");
		System.out.println(actualNumber + " elements\n");

		int index, minIndex;
		Element placeHolderElement;
		for (int i = 0; i < actualNumber; i++)
		{
			minIndex = i;
			placeHolderElement = table[i];

			for (index = i + 1; index < actualNumber; index++)
			{
				if(table[index].getNumber() < placeHolderElement.getNumber())
				{
					minIndex = index;
					placeHolderElement = table[index];


				}
			}

			table[minIndex] = table[i];
			table[i] = placeHolderElement;
		}
		for (int i = 0; i < actualNumber; i++)
		{
			System.out.print(table[i].toString());
		}
	}

	public Element findSymbol(String symbol)
	{
		boolean found = true;
		int counter = -1;

		while (!found && counter < actualNumber)
		{
			counter++;
			if (table[counter].getSymbol().equals(symbol))
			{
				found = false;
			}
		}
		return table[counter];
	}
}
