//(c) A+ Computer Science
//www.apluscompsci.com

//Name - James Lee
//Date - 08/22/22
//Class - Period 2 CSA
//Lab  - Discount

import static java.lang.System.*;
import java.util.Scanner;

public class Discount
{
	private static double gill;
	//instance variables and constructors could be used, but are not really needed
	
	//getDiscountedBill() will return final amount of the bill
	//			if the bill is >2000, the bill receives a 15% discount
	public static double getDiscountedBill(double x)
	{
		if(x>=2000){
			gill = x*0.85;
			return gill;
		}
		return gill;
	}
	public void print(){
System.out.println(String.format("%.3f\n", gill));
	}

}
