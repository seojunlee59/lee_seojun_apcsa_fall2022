//(c) A+ Computer Science
// www.apluscompsci.com
//Name - James Lee

import static java.lang.System.*;

public class BiggestDouble
{
	private double one,two,three,four;

	public BiggestDouble()
	{
		this(0,0,0,0);
	}

	public BiggestDouble(double a, double b, double c, double d)
	{
		setDoubles(a,b,c,d);
	}

	public void setDoubles(double a, double b, double c, double d)
	{
		one = a;
		two = b;
		three = c;
		four = d;
	}

	public double getBiggest()
	{
		double[] red = {one, two, three, four};
		double temp = 0.0;
		for(int i=1;i<red.length;i++) {
			if(red[i-1]>red[i]) {
				temp = red[i-1];
				red[i-1] = red[i];
				red[i] = temp;
			}
		}
		return red[red.length-1];
	}

	public String toString()
	{
	   return ""+one+" "+two+" "+three+" "+four+" "+"\n"+"biggest: "+getBiggest();
	}
}
