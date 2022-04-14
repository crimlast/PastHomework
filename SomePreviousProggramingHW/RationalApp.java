//
//	Name:		Barrientos, Joshua
//	Homework:	6
//	Due:		November 15, 2019
//	Course:		cs-1400-03-f19
//
//	Description:
//			A code to test out the Rational class.
//

public class RationalApp
{
	public static void main(String[] args)
	{
		System.out.println("Rational by J. Barrientos\n");
		System.out.println("Your Test Output\n");
		Rational api = new Rational(22, 7);
		System.out.print("api: " + api.toString() + " ~ ");
		api.print(40);
		System.out.println("\nHarmonics Series:");
		Rational fraction = new Rational( 1, 1);
		System.out.print(fraction.toString() + " ~ 1.0\n");
		Rational nextFraction = new Rational(1, 1);
		for(int i = 2; i < 11; i++)
		{
			nextFraction.set(1, i);
			fraction.add(nextFraction);
			System.out.print(fraction.toString() + " ~ ");
			fraction.print(15);
			System.out.println();
		}

	}
}
