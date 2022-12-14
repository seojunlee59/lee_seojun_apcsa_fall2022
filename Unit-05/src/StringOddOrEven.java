//(c) A+ Computer Science
//www.apluscompsci.com

//Name - James Lee
//Date - 08/25/22
//Class - Period 2 CSA
//Lab  - StringOddOrEven

import static java.lang.System.*;
import java.util.Scanner;

public class StringOddOrEven
{
	private String word;

	public StringOddOrEven()
	{
		 setString("");
	}

	public StringOddOrEven(String s)
	{
		setString(s);
	}

	public void setString(String s)
	{
		word = s;
	}

 	public boolean isEven()
 	{
		if(word.length()%2==0){
			return true;
		}
		return false;
	}

 	public String toString()
 	{
		String output="";
		if(isEven()==true){
			output = word + " is even";
		}
		else{
			output = word + " is odd";
		}
  		return output;
	}
}
