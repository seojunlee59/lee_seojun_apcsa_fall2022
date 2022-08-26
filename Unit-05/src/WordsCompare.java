//(c) A+ Computer Science
//www.apluscompsci.com

//Name - James Lee
//Date - 08/25/22
//Class - Period 2 CSA
//Lab  - WordsCompare

import static java.lang.System.*;

public class WordsCompare
{
	private String wordOne, wordTwo;
   private int compare;

	public WordsCompare()
	{
		setWords("","");
		wordOne = "";
		wordTwo = "";
	}

	public WordsCompare(String one, String two)
	{
		wordOne = one;
		wordTwo = two;
		setWords(wordOne, wordTwo);
	}

	public void setWords(String one, String two)
	{
		wordOne = one;
		wordTwo = two;

	}

	public void compare()
	{
		compare = wordOne.compareTo(wordTwo);
	}

	public String toString()
	{
		if(compare<0)
		{
			return wordOne + " should be placed before " + wordTwo + "\n";
		}
		else if(compare==0) {
			return wordOne + " is the same length as " + wordTwo + "\n";
		}
		else
		{
			return wordOne + " should be placed after " + wordTwo + "\n";
		}
	}
}
