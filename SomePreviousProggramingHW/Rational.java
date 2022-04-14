//
// 	Name:		Barrientos, Joshua
// 	Homework:	6
//	Due:		November 15, 2019
//	Course:		cs-1400-03-f19
//
//	Description:
//			A code that will create an object, Rational and create methods corresponding to rational numbers.
//

public class Rational
{
	private int p;
	private int q;
	public Rational(int p, int q)
	{
		this.p = p;
		if(q == 0)
		{
			throw new RuntimeException("q == 0");
		}
		this.q = q;
	}

	public Rational()
	{
		this(0,1);
	}
	public Rational(int n)
	{
		this(n,1);
	}
	public void set(int num, int den)
	{
		p = num;
		if(q == 0)
		{
			throw new RuntimeException("q == 0");
		}
		q = den;
	}
	public int getP()
	{
		return p;
	}
	public int getQ()
	{
		return q;
	}
	public double toDouble()
	{
		return (double)p/q;
	}
	public boolean equals(Rational rhs)
	{
		return rhs.p * q == rhs.q * p;
	}
	public String toString()
	{
		return p + "/" + q;
	}
	public void add(Rational rhs)
	{
		if(q == rhs.q)
		{
			set(p+rhs.p,q);
		}

		int den = q * rhs.q;
		int num = p * rhs.q + rhs.p * q;
		set(num, den);
	}
	public void subtract(Rational rhs)
	{
		if ( q == rhs.q)
		{
			set(p - rhs.p, q);
		}
		int den = q * rhs.q;
		int num = (p * rhs.q) - (rhs.p * q);
		set(num, den);
	}
	public Rational multiply(Rational rhs)
	{
		return new Rational(p * rhs.p, q* rhs.q);
	}
	public Rational divide(Rational rhs)
	{
		return new Rational(p *rhs.q, q *rhs.p);
	}
	public void print(int n)
	{
		System.out.print(p/q + ".");
		int modulus = p % q;
		for (int i = 0; i <= n; i++)
		{
			System.out.print(modulus * 10/q + "");
			modulus = modulus * 10 % q;
			if (modulus == 0)
			{
				i = n;
			}
		}
	}
}

