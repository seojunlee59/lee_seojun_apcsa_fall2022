//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class Word implements Comparable<Word>
{
	private String word;
	
	public Word() {
		setWord("");
	}
	
	public Word( String s )
	{
		setWord(s);
	}
	
	public void setWord(String s) {
		word = s;
	}
	public String getWord() {
		return word;
	}
	
	public int compareTo( Word rhs )
	{		
		if(!(word.equals(rhs))) {
			if(word.charAt(0)<rhs.word.charAt(0)) {
				return 1;
			}
			else {
				return -1;
			}
		}
		return 0;
	}

	public String toString()
	{
		return ""+word;
	}
}