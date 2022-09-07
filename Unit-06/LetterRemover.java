//(c) A+ Computer Science
//www.apluscompsci.com
//Name - James Lee

import static java.lang.System.*;

public class LetterRemover
{
   private String sentence;
   private char lookFor;
   private String cleaned;

	public LetterRemover()
	{
		setRemover("", ' ');
	}

	public LetterRemover(String s, char rem) {
		setRemover(s, rem);
	}
	
	
	public void setRemover(String s, char rem)
	{
		sentence = s;
		lookFor = rem;
	}

	public String removeLetters()
	{
		cleaned = sentence;
		for(int i=0; i<sentence.length();i++) {
			if(cleaned.charAt(i)==lookFor) {
				cleaned = cleaned.replace(lookFor, ' ');
			}
		}
		return cleaned;
	}

	public String toString()
	{
		return sentence + " - letter to remove " + lookFor +"\n"+cleaned;
	}
}