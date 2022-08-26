//(c) A+ Computer Science
//www.apluscompsci.com

//Name - James Lee 
//Date - 08/25/22
//Class - Period 2 CSA
//Lab  - StringEquality

import static java.lang.System.*;

import java.util.Scanner;

public class StringEqualityRunner
{
	public static void main( String args[] )
	{
		Scanner keyboard = new Scanner(in);
		boolean flag = true;
		while(flag) {
			out.print("Enter a word :: ");
			String word1 = keyboard.next();
			out.print("Enter a word :: ");
			String word2 = keyboard.next();
			
			StringEquality test1 = new StringEquality(word1, word2);
			test1.checkEquality();
			out.println(test1);
			
			out.print("Exit? :: ");
			char char1 = keyboard.next().charAt(0);
			if(char1=='y') {
				flag = false;
			}
		}
		
	}
}
