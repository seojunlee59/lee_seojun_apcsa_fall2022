//(c) A+ Computer Science
//www.apluscompsci.com

//Name - James Lee
//Date - 08/25/22
//Class - Period 2 CSA
//Lab  - WordCompareRunner

import static java.lang.System.*;

import java.util.Scanner;

public class WordsCompareRunner
{
   public static void main( String args[] )
   {
//		Input:
//		hello goodbye
//	    one two
//	    three four
//	    TCEA UIL
//	    State Champions
//	    ABC ABC
//	    ABC CBA
//	    Same Same

		Scanner keyboard = new Scanner(in);
		boolean flag = true;
		while(flag) {
			out.print("Enter a word :: ");
			String word1 = keyboard.next();
			out.print("Enter a word :: ");
			String word2 = keyboard.next();
			
			WordsCompare test1 = new WordsCompare(word1, word2);
			test1.compare();
			out.println(test1);
			
			out.print("Exit? :: ");
			char char1 = keyboard.next().charAt(0);
			if(char1=='y') {
				flag = false;
			}
		}
	}
}
