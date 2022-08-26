//(c) A+ Computer Science
//www.apluscompsci.com

//Name - James Lee
//Date - 08/23/22
//Class - Period 2 CSA
//Lab  - String Equality

import static java.lang.System.*;

public class StringEquality
{
	private String wordOne, wordTwo;
	private int red;
	private boolean condit;
	public StringEquality()
	{
		setWords("","");
	}

	public StringEquality(String one, String two)
	{
		setWords(one, two);
	}

	public void setWords(String one, String two)
	{
		wordOne = one;
		wordTwo = two;
	}

	public boolean checkEquality( )
	{
		if((wordOne.length()==wordTwo.length()) && (wordOne.equals(wordTwo))){
			return true;
		}
		return false;
	}

	public String toString()
	{
		if(checkEquality() == true){
			return wordOne + " does have the same letters as  " + wordTwo + "\n";
		}
		else{
			return wordOne + " does not have the same letters as " + wordTwo + "\n";
		}
	}
}
