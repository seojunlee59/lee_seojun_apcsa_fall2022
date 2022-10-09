//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class WordPrinter
{
	//instance variables and constructors could be present, but are not necessary
		
	public static String printWord(String word, int times)
	{
		String opt = "";
		for(int i=0; i<times; i++) {
			opt=opt+word+"\n";
		}
		return opt;
	}
}