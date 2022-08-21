//(c) A+ Computer Science
// www.apluscompsci.com

//Name - James Lee
//Date - 08/19/22
//Class - Period 2 CSA
//Lab  - Quadratic

import java.util.Scanner; 
import static java.lang.System.*;
import static java.lang.Math.*;

public class Quadratic
{
	private int a, b, c;
	private double rootOne;
	private double rootTwo;

	public Quadratic()
	{
		setEquation(0,0,0);
		rootOne = 0.0;
		rootTwo = 0.0;
	}

	public Quadratic(int quadA, int quadB, int quadC)
	{
		a = quadA;
		b = quadB;
		c = quadC;
	}

	public void setEquation(int quadA, int quadB, int quadC)
	{
		a = quadA;
		b = quadB;
		c = quadC;
 	}

	public void calcRoots( )
	{
		rootOne = (double)(-b+Math.sqrt(Math. pow(b, 2)-4*(a*c)))/(2*a);
		rootOne = (double)(-b-Math.sqrt(Math. pow(b, 2)-4*(a*c)))/(2*a);
	}

    public void print()
    {
	System.out.print("%.3f\n"+rootOne);
	System.out.print("%.3f\n"+rootTwo);
    }
    
    //complete either print or the toString()

	public String toString()
	{
		return "rootOne :: "+rootOne+"\n rootTwo :: "+rootTwo;
	}
}
