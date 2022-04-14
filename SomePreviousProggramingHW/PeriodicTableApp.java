
//
//	Name:		Barrientos, Joshua
//	Homework:	5
//	Due:		Wednesday November 6, 2019
//	Course: 	cs-1400-03-f19
//
//	Description:	A program that uses the class PeriodicTable to print out the table and show a sample call
//			to find Symbol "Fe".
//


public class PeriodicTableApp
{
	public static void main(String[]args) throws Exception
	{
		PeriodicTable periodicTable = new PeriodicTable();
		periodicTable.print();
		Element search = periodicTable.findSymbol("Fe");
		System.out.println("Sample Call with (Fe): \n" + search.toString());

	}
}
