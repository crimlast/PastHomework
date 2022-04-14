
//
//	Name:		Barrientos, Joshua
//	Project:	4
//	Due:		Dec 9, 2019
//	Course:		CS-1400-02-F19
//
//	Description:
//		Cargoship that extends Ship.
//

public class CargoShip extends Ship
{
	private int cargoCap;
	public CargoShip(String name, String year, int cargo)
	{
		super(name, year);
		cargoCap = cargo;
	}
	public int getCargoCappacity()
	{
		return cargoCap;
	}
	@Override
	public String toString()
	{
		return String.format("%-20s Cargo:%d", getName(), cargoCap);
	}
}
