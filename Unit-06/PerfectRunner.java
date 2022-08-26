//(c) A+ Computer Science
//www.apluscompsci.com
//Name - James Lee

import static java.lang.System.*; 

public class PerfectRunner
{
	public static void main( String args[] )
	{
//		496
//		45
//		6
//		14
//		8128
//		1245
//		33
//		28
//		27
//		33550336

		//add test cases
		Perfect test1 = new Perfect(496);
		test1.isPerfect();
		out.println(test1);
		
		test1.setNumber(45);
		test1.isPerfect();
		out.println(test1);
		
		test1.setNumber(6);
		test1.isPerfect();
		out.println(test1);
		
		test1.setNumber(14);
		test1.isPerfect();
		out.println(test1);
		
		test1.setNumber(8128);
		test1.isPerfect();
		out.println(test1);
		
		test1.setNumber(1245);
		test1.isPerfect();
		out.println(test1);
		
		test1.setNumber(33);
		test1.isPerfect();
		out.println(test1);
		
		test1.setNumber(28);
		test1.isPerfect();
		out.println(test1);
		
		test1.setNumber(27);
		test1.isPerfect();
		out.println(test1);
		
		test1.setNumber(33550336);
		test1.isPerfect();
		out.println(test1);
																
	}
}