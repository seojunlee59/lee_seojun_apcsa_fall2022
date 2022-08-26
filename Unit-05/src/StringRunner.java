//(c) A+ Computer Science
//www.apluscompsci.com

//Name - James Lee
//Date - 08/25/22
//Class - Period 2 CSA
//Lab  - StringOddOrEvenRunner

import static java.lang.System.*;
import java.util.Scanner;

public class StringRunner
{
	public static void main ( String[] args )
	{
		Scanner keyboard = new Scanner(in);
		boolean flag = true;
		while(flag){
			out.print("Enter a word :: ");
			String word1 = keyboard.next();
			
			StringOddOrEven test1 = new StringOddOrEven(word1);
			test1.isEven();
			out.println(test1);

			out.print("Do you want to continue :: ");
			char exit = keyboard.next().charAt(0);
			if(exit=='y'){
				flag=false;
			}
		}
	}
}
