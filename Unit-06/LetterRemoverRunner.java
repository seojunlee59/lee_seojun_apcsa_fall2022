//(c) A+ Computer Science
//www.apluscompsci.com
//Name - James Lee

import static java.lang.System.*;

public class LetterRemoverRunner
{
	public static void main( String args[] )
	{
		LetterRemover test1 = new LetterRemover("I am Sam I am", 'a');
		test1.removeLetters();
		out.println(test1);
		
		test1.setRemover("ssssssssxssssesssssesss", 's');
		test1.removeLetters();
		out.println(test1);
		
		test1.setRemover("qwertyqwertyqwerty", 'a');
		test1.removeLetters();
		out.println(test1);
		
		test1.setRemover("abababababa", 'b');
		test1.removeLetters();
		out.println(test1);
		
		test1.setRemover("abaababababa", 'x');
		test1.removeLetters();
		out.println(test1);
//		I am Sam I am   a
//		ssssssssxssssesssssesss   s
//		qwertyqwertyqwerty   a
//		abababababa   b
//		abaababababa   x
		
	}
}