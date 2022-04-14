//
//	Name:		Barrientos, Joshua
//	Project: 	4
//	Due:		December 9, 2019
//	Course:		CS-1400-02-F19
//
//	Description:
//		A tester program with a main method creating an inventory of ships owned while testing out the Ship class and its subclasses.
//

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ShipDemo
{
	public static void main(String[] args) throws FileNotFoundException
	{
		try{
			ArrayList<Ship> inventory = new ArrayList<>();
			File companyFile = null;
			if(args.length > 0)
			{
				companyFile = new File(args[0]);
			}
			else
			{
				companyFile = new File("mycompany.dat");
			}
			Scanner keyboard = new Scanner(companyFile);
			String name, year;
			char type;
			int parameter, cruiseCount, cargoCount;
			cruiseCount = 0;
			cargoCount = 0;
			String companyName = keyboard.next();
			while (keyboard.hasNext())
			{
				type = keyboard.next().charAt(0);
				name = keyboard.next().replaceAll("_"," ");
				year = keyboard.next();
				parameter = keyboard.nextInt();
				if('c' == type)
				{
					inventory.add(new CruiseShip(name, year, parameter));
					cruiseCount+= parameter;
				}
				else if('C' == type)
				{
					inventory.add(new CargoShip(name, year, parameter));
					cargoCount+= parameter;
				}
			}
			Ship[] arrayShip= new Ship[inventory.size()];
			for (int i = 0; i < inventory.size(); i++)
			{
				arrayShip[i] = inventory.get(i);
			}
			System.out.println("\nWelcome to " + companyName + " by B. Joshua\n");
			System.out.printf("%-20s %10s\n", "Ship name", "Type");
			System.out.println("-------------------- ---------------");
			for (int i = 0; i < arrayShip.length; i++)
			{
				System.out.println(arrayShip[i]);
			}
			System.out.println("Total Ships = " + inventory.size());
			System.out.println("Total Passenger = " + cruiseCount);
			System.out.println("Total Tonnage = " + cargoCount);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found");
		}
	}
}
