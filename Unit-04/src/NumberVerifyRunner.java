//(c) A+ Computer Science
//www.apluscompsci.com

//Name - James Lee
//Date - 08/22/22
//Class - Period 2 CSA
//Lab  - NumberVerifyRunner

import static java.lang.System.*;
import java.util.Scanner;

public class NumberVerifyRunner
{
	public static void main ( String[] args )
	{
		Scanner test1 = new Scanner(System.in);
		System.out.println("Is 5 odd or even?");
		System.out.println("5 is odd :: " + NumberVerify.isOdd(5));
		System.out.println("5 is even :: " + NumberVerify.isEven(5));
		out.print("Input Test Number :: ");
		int x = test1.nextInt();
		
		NumberVerify.isOdd(x);
		NumberVerify.isEven(x);
	}
}
