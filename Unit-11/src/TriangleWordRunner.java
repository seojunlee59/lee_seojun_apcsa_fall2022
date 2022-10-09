//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Scanner;
import static java.lang.System.*;

public class TriangleWordRunner
{
	public static void main( String args[] )
	{
		Scanner keyboard = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			out.print("Enter a word :: ");
			String a = keyboard.next();
			out.println(TriangleWord.printTriangle(a));
			out.print("Do you want to enter more sample input? ");
			char b = keyboard.next().charAt(0);
			if(b=='n') {
				flag = false;
			}
		}
	}
}