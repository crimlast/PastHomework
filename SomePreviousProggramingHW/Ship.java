//
//	Name:		Barrientos, Joshua
//	Project:	4
//	Due:		December 9, 2019
//	Course:		CS-1400-02-F19
//
//	Description:
//			Source file that creates an object class for Ship.

public abstract class Ship
{
	private String name;
	private String year;

	public Ship(String name, String year)
	{
		this.name = name;
		this.year = year;
	}

	public String getName()
	{
		return name;
	}

	public String getYear()
	{
		return year;
	}

	@Override
	public abstract String toString();
}
