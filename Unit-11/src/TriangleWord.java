//(c) A+ Computer Science
//www.apluscompsci.com
//Name - James Lee


public class TriangleWord
{
	//instance variables and constructors could be present, but are not necessary
		
	public static String printTriangle(String word)
	{
		String opt = "";
		String lnOpt = "";
		for(int i=1; i<=word.length(); i++) {
			for(int j=0; j<i; j++) {
				opt=opt+word.substring(0, i);
			}
			opt+="\n";
		}
		return opt;
	}
}