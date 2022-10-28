//(c) A+ Computer Science
//www.apluscompsci.com
//Name - James Lee

import java.util.Arrays;
import java.io.IOException;

public class NumberShifterRunner
{
	public static void main( String args[] ) throws IOException
	{
		//add test cases
		for(int i=0; i<5; i++) {
			int[] red = NumberShifter.makeLucky7Array((int)(Math.random()*20)+1);
			System.out.println(Arrays.toString(red));
			NumberShifter.shiftEm(red);
			System.out.println(Arrays.toString(red));
			System.out.println("----------------");
		}
	}
}



