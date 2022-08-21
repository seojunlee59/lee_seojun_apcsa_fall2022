//(c) A+ Computer Science
//www.apluscompsci.com

//Name - James Lee
//Date - 08/19/22
//Class - Period 2 CSA
//Lab  - Quadratic

import java.util.Scanner; 
import static java.lang.System.*;
import static java.lang.Math.*;

public class QuadraticRunner
{
	public static void main( String[] args )
	{
		Scanner keyboard = new Scanner(in);
		
		out.print("Enter a :: ");
		int a = keyboard.nextInt();
		out.print("Enter b :: ");
		int b = keyboard.nextInt();
		out.print("Enter c :: ");
		int c = keyboard.nextInt();
		
		Quadratic test2 = new Quadratic(a,b,c);
		test2.calcRoots();
		test2.print();
		test2.toString();
	
	}
}
