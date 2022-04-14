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
import java.io.PrintWriter;

public class PeriodicTable
{
	private Element[] table;
	private int actualNumber;

	public PeriodicTable() throws Exception
	{
		table = new Element[130];
		File file = new File("/user/tvnguyen7/data/periodictable.dat");
		Scanner keyboard = new Scanner(file);

		while (keyboard.hasNext())
		{
			int numberElement = keyboard.nextInt();
			String symbolElement = keyboard.next();
			double massElement = keyboard.nextDouble();
			String nameElement = keyboard.next();
			Element currentElement = new Element(numberElement, nameElement, symbolElement, massElement);
			table[actualNumber++] = currentElement;
		}
	}


	public void print()
	{

		System.out.println("PeriodicTable by J. Barrientos\n");
		System.out.println(actualNumber + " elements\n");
		System.out.println ("\nPeriodic Table (" + actualNumber + ")");
		System.out.printf("ANo. %-20s Abr    Mass\n", "Name");
		System.out.println("---- -------------------- --- -------");
		double totalMass = 0;
		for (int i = 0; i < actualNumber; i++)
		{
			totalMass += table[i].getMass();
			System.out.println(table[i].toString());
		}
		System.out.printf("\nThe average Mass = %18.2f\n", totalMass/actualNumber);
	}

	public Element findSymbol(String theSymbol)
	{
		int index = 0;
		while (index < actualNumber)
		{
			if(table[index].getSymbol().equals(theSymbol))
			{
				return table[index];
			}
			else
				index++;
		}
		return null;
	}
}
