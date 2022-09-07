//(c) A+ Computer Science
//www.apluscompsci.com
//Name - James Lee

import static java.lang.System.*;

public class TriangleFiveRunner
{
   public static void main(String args[])
   {
//	   C 4
//	   A 5
//	   B 7
//	   X 6
//	   Z 8

	   TriangleFive test1 = new TriangleFive('C', 4);
	   out.println(test1);
	   test1.setLetter('A');
	   test1.setAmount(5);
	   out.println(test1);
	   test1.setLetter('B');
	   test1.setAmount(7);
	   out.println(test1);
	   test1.setLetter('X');
	   test1.setAmount(6);
	   out.println(test1);
	   test1.setLetter('Z');
	   test1.setAmount(8);
	   out.println(test1);
	}
}
