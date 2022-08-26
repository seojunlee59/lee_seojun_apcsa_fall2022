//(c) A+ Computer Science
//www.apluscompsci.com
//Name - James Lee

import static java.lang.System.*;

public class Word
{
	private String word;

	public Word()
	{
		word="";
		setString("");
	}

	public Word(String s)
	{
		setString(s);
	}

	public void setString(String s)
	{
		word = s;
	}

	public char getFirstChar()
	{
		char red = word.charAt(0);
		return red;
	}

	public char getLastChar()
	{
		char red = word.charAt(word.length()-1);
		return red;
	}

	public String getBackWards()
	{
		String back="";
		for(int i=word.length()-1; i>-1;i--) {
			back = back + "" + word.charAt(i);
		}
		return back;
	}

 	public String toString()
 	{
 		return ""+getFirstChar()+"\n"+getLastChar()+"\n"+getBackWards()+"\n"+word;
	}
}