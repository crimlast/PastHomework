//
//	Name:		Barrientos, Joshua
//	Project:	3
//	Due:		Wednesday October 23, 2019
//	Course:		CS-1400-03-SP19
//	Description:
//			A code that will read information about elements in the periodic table and print it out
//			sorted by atomic number or name.
//

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class PeriodicTableOriginal
{
	public static void main(String [] args)
	{
		final int MAX_ELEMENTS = 128;
		int[] atomicNumber = new int[MAX_ELEMENTS];
		String[] elementName = new String[MAX_ELEMENTS];
		String[] symbol = new String[MAX_ELEMENTS];
		double[] atomicMass = new double[MAX_ELEMENTS];
		int counter = 0;

		File periodicTableData = new File("/user/tvnguyen7/data/periodictable.dat");
		Scanner keyboard = new Scanner(periodicTableData);

		while (keyboard.hasNext())
		{
			atomicNumber[counter] = keyboard.nextInt();
			symbol[counter] = keyboard.next();
			atomicMass[counter] = keyboard.nextDouble();
			elementName[counter] = keyboard.next();
			counter++;
		}

		int numberOfElements = counter;
		System.out.println("PeriodicTable by J. Barrientos\n");
		System.out.println(numberOfElements + " elements\n");

		if(args.length == 3 && args[0].equals("print") && (args[1].equals("name") || args[1].equals("atomic"))) {

			PrintWriter outputFile = new PrintWriter(args[2]);

			outputFile.println("Periodic Table (" + numberOfElements + ")\n");
			outputFile.printf("ANo. %-20s Abr %7s\n", "Name", "Mass");
			outputFile.println("---- -------------------- --- -------");

			if (args[1].equals("atomic"))
			{
				int index, minValue, minIndex;
				double minAtomicMass = 0;
				String minName = null;
				String minSymbol = null;
				for (int i = 0; i < numberOfElements; i++)
				{
					minIndex = i;
					minValue = atomicNumber[i];

					minAtomicMass = atomicMass[i];
					minName = elementName[i];
					minSymbol = symbol[i];

					for (index = i + 1; index < numberOfElements; index++)
					{
						if(atomicNumber[index] < minValue)
						{
							minIndex = index;
							minValue = atomicNumber[index];

							minAtomicMass = atomicMass[index];
							minName = elementName[index];
							minSymbol = symbol[index];

						}
					}
					atomicNumber[minIndex] = atomicNumber[i];
					atomicNumber[i] = minValue;

					atomicMass[minIndex] = atomicMass[i];
					atomicMass[i] = minAtomicMass;
					elementName[minIndex] = elementName[i];
					elementName[i] = minName;
					symbol[minIndex] = symbol[i];
					symbol[i] = minSymbol;
				}

			}

			else if (args[1].equals("name"))
			{
				String lowerName, correspondingSymbol;
				int correspondingAtomicNumber, minIndex, index;
				double correspondingMass;

				for (int i = 0; i < numberOfElements; i++)
				{
					minIndex = i;
					lowerName = elementName[i];

					correspondingAtomicNumber = atomicNumber[i];
					correspondingSymbol = symbol[i];
					correspondingMass = atomicMass[i];

					for (index = i + 1; index < numberOfElements; index++)
					{
						if((lowerName.compareTo(elementName[index])) > 0)

						{
							minIndex = index;
							lowerName = elementName[index];

							correspondingAtomicNumber = atomicNumber[index];
							correspondingSymbol = symbol[index];
							correspondingMass = atomicMass[index];
						}
					}

					elementName[minIndex] = elementName[i];
					elementName[i] = lowerName;


					atomicNumber[minIndex] = atomicNumber[i];
					atomicNumber[i] = correspondingAtomicNumber;
					symbol[minIndex] = symbol[i];
					symbol[i] = correspondingSymbol;
					atomicMass[minIndex] = atomicMass[i];
					atomicMass[i] = correspondingMass;
				}
			}

			double totalMass = 0;
			for (int i = 0; i < numberOfElements; i++)
			{
				outputFile.printf("%4d ", atomicNumber[i]);
				outputFile.printf("%-20s ", elementName[i]);
				outputFile.printf("%-3s ", symbol[i]);
				outputFile.printf("%7.2f\n", atomicMass[i]);
				totalMass += atomicMass[i];
			}
			double averageMass = totalMass/numberOfElements;
			outputFile.printf("\nThe average mass: %18.2f\n", averageMass);

			outputFile.close();
			System.out.println("Output file printed.");
		}
		else if (args.length > 0)
		{
			System.out.println("Unknown action.");
		}
	}
}
