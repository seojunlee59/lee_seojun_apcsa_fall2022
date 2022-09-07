//(c) A+ Computer Science
//www.apluscompsci.com
//Name - James Lee

import static java.lang.System.*;

public class TriangleFive
{
   private char letter;
   private int amount;
//
//	public TriangleFive()
//	{
//		setLetter('e');
//		setAmount(0);
//	}

	public TriangleFive(char c, int amt)
	{
		setLetter(c);
		setAmount(amt);
	}

	public void setLetter(char c)
	{
		letter = c;
	}

	public void setAmount(int amt)
	{
		amount = amt;
	}

	public String toString()
	{
		String output="";
		int trex = amount;
		int rawr = amount;
		char ltr = letter;
//		String ltr = ""+letter;
//		char[] alpha = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		for(int q=0; q<amount; q++) {
			for(int i=0; i<rawr; i++) {
				for(int j=0; j<trex;j++) {
					output += letter;
				}
				trex--;
				letter = (char) (letter+1);
				output+= " ";
				if(letter>90) {
					letter = 65;
				}
			}
			output+="\n";
			rawr--;
			trex = amount;
			letter = ltr;
		}
		return output;
}
}
	
