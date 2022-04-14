//
//	Name:		Barrientos, Joshua
//	Homework:	5
//	Due:		Nov 6, 2019
//	Course:		cs-1400-03-f19
//
//	Description: Creating an Element Object that takes in symbol, name, mass and number.
//

public class Element
{
	private String name;
	private String symbol;
	private double mass;
	private int number;

	public Element(int atomicNumber, String elementName, String atomicSymbol, double atomicMass)
	{
		number = atomicNumber;
		name = elementName;
		mass = atomicMass;
		symbol = atomicSymbol;
	}

	public String toString()
	{
		String s = String.format("%4d ", number);
		s = s + String.format("%-20s ", name);
		s = s + String.format("%-3s ", symbol);
		s = s + String.format("%7.2f", mass);
		return s;
	}

	public String getSymbol()
	{
		return symbol;
	}
	public double getMass()
	{
		return mass;
	}
	public int getNumber()
	{
		return number;
	}
	public String getName()
	{
		return name;
	}
}
