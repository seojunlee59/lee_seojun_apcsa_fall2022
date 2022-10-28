//(c) A+ Computer Science
//www.apluscompsci.com
//Name - James Lee

import java.util.ArrayList;

public class NumberShifter
{
	public static int[] makeLucky7Array( int size)
	{
		int[] red = new int[size];
		for(int i=0; i<red.length; i++) {
			red[i] = (int)(Math.random()*10)+1;
		}
		return red;
	}
	public static void shiftEm(int[] array)
	{
		ArrayList<Integer> blue = new ArrayList<Integer>();
		for(int i=0; i<array.length; i++) {
			blue.add(array[i]);
		}
		System.out.println("line 29: "+blue);
		for(int i=0; i<blue.size(); i++){
			if(blue.get(i) == 7) {
				blue.remove(i);
				blue.add(0, 7);
			}
		}
		System.out.println("line 36: "+blue);
		for(int i=0; i<blue.size(); i++) {
			array[i] = blue.get(i);
		}
	}
}