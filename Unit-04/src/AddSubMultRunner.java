//(c) A+ Computer Science
//www.apluscompsci.com
//Name - James Lee

import static java.lang.System.*; 
import java.util.Scanner;

public class AddSubMultRunner
{
	public static void main( String args[] )
	{
		System.out.println( AddSubMult.check( 10.0, 20.0) );		
		System.out.println( AddSubMult.check( 20.0, 10.0) );	
		System.out.println( AddSubMult.check( 20.0, 20.0) );
		System.out.println( AddSubMult.check( 10, 10) );	
		System.out.println( AddSubMult.check( 0, 1) );	
		System.out.println( AddSubMult.check( 1, 0 ) );	
		System.out.println( AddSubMult.check( 3.1, 5.7) );	
		System.out.println( AddSubMult.check( 5.2, 3.8 ) );	
		System.out.println( AddSubMult.check( 5342, 323 ) );				
		Scanner keyboard = new Scanner(System.in);
		
		out.print("Enter two numbers :: ");
		int x = keyboard.nextInt();
		int y = keyboard.nextInt();
		
//		String newx1 = x.substring(0, x.charAt(32));
//		String newx2 = x.substring((x.charAt(32)+1), x.length()-1);
//		int newx1_2 = (int)newx1;
		
		AddSubMult test1 = new AddSubMult(x, y);
		test1.check1();
		test1.print();
	}
}

