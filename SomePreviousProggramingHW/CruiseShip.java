//
//	Name:		Barrientos, Joshua
//	Project:	4
//	Due:		December 9, 2019
//	Course:		CS-1400-02-F19
//
//	Description:
//			A source code creating a CruiseShip class that extends the Ship class.
//

public class CruiseShip extends Ship
{
	private int maxOccupancy;

	public CruiseShip(String name, String year, int max)
	{
		super(name, year);
		maxOccupancy = max;
	}

	public int getMaxPeople()
	{
		return maxOccupancy;
	}

	@Override
	public String toString()
	{
		return String.format("%-20s Cruise:%d" , getName(), maxOccupancy);
	}
}
