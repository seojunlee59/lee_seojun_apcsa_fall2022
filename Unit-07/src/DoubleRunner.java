//(c) A+ Computer Science
// www.apluscompsci.com
//Name - James Lee

import static java.lang.System.*;

public class DoubleRunner
{
	public static void main(String[] args)
	{
		BiggestDouble run = new BiggestDouble(4.5,6.7,7.8,9.0);
		System.out.println(run);
		
		for(int i=0; i<10; i++) {
			run.setDoubles(((double)Math.random()*10), (double)Math.random()*10, (double)Math.random()*10, (double)Math.random()*10);
			out.println(run);
		}
		
				
	}
}
