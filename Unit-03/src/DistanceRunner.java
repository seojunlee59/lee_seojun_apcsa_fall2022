//(c) A+ Computer Science
//www.apluscompsci.com

//Name - James Lee
//Date - 08/19/22
//Class - Period 2 CSA
//Lab  - Distance

import java.util.Scanner; 
import static java.lang.System.*;
import static java.lang.Math.*;

public class DistanceRunner
{
	public static void main( String[] args )
	{
		Scanner keyboard = new Scanner(in);
		//add test cases	
		out.print("Enter X1 :: ");
		int x1 = keyboard.nextInt();
		out.print("Enter Y1 :: ");
		int y1 = keyboard.nextInt();
		out.print("Enter X2 :: ");
		int x2 = keyboard.nextInt();
		out.print("Enter Y2 :: ");
		int y2 = keyboard.nextInt();
		
		Distance test1 = new Distance(x1, y2, x2, y2);
		test1.calcDistance();
		test1.print();
		test1.toString();
	}
}
