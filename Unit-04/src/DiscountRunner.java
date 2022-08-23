//(c) A+ Computer Science
//www.apluscompsci.com

//Name - James Lee
//Date - 08/22/22
//Class - Period 2 CSA
//Lab  - DiscountRunner

import static java.lang.System.*;
import java.util.Scanner;

public class DiscountRunner
{
	public static void main( String args[] )
	{
		Scanner keyboard = new Scanner(System.in);
		
		out.print("Enter the original bill amount :: ");
		double amt = keyboard.nextDouble();
		
		
		Discount well = new Discount();
		Discount.getDiscountedBill(amt);
		well.print();		
	}
}
