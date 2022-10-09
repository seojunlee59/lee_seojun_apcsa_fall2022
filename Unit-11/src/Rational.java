//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*; 

class Rational implements Comparable<Rational>
{
	private int numer;
	private int denom;

	public Rational() {
		setRational(1,1);
	}
	public Rational(int num, int den) {
		setRational(num, den);
	}

	public void setRational(int num, int den) {
		numer = num;
		denom = den;
	}

	public void setNum(int num) {
		numer = num;
	}
	public void setDen(int den) {
		denom = den;
	}
	
	public void add(Rational  other)
	{

		numer = (numer * other.getDen() + other.getNum() * denom);
		denom = (denom * other.getDen());
		
		reduce();
	}

	public void reduce()
	{
		int red = gcd(numer, denom);
		denom /= red;
		
		numer /= red;
	}

	public int gcd(int numOne, int numTwo)
	{
//		if(numTwo==0) {
//			return numOne;
//		}
//		return gcd(numOne, numTwo%numOne);
		int gcd = 1;
		for(int i = 1; i <= numOne && i <= numTwo; i++)  
		{  
		if(numOne%i==0 && numTwo%i==0)  
		gcd = i;  
		}  
		return gcd;
	}

	public Object clone ()
	{
		return this;
	}

	public int getNum() {
		return numer;
	}
	public int getDen() {
		return denom;
	}
	
	public boolean equals( Rational obj)
	{
		obj.reduce();

		System.out.println("line 88: "+obj);
		if(this.numer==obj.numer && this.denom==obj.denom) {
			return true;
		}
		return false;
	}

	public int compareTo(Rational other)
	{
		if(this.equals(other)) {
			return 0;
		}
		else {
			if(((double)this.numer/this.denom)>((double)other.getNum()/other.getDen())) {
				return 1;
			}
			else {
				return -1;
			}
		}
	}

	public String toString() {
		return ""+getNum()+"/"+getDen();
	}
	
}