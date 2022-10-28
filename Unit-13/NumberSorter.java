//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.ArrayList;

public class NumberSorter
{
	//instance variables and other methods not shown

	private static int getNumDigits(int number)
	{
		int count = number%10;
		return count;
	}

	public static int[] getSortedDigitArray(int number)
	{
		ArrayList<Integer> red = new ArrayList<Integer>();
		String re = ""+number;
		for(int i=0; i<re.length(); i++) {
			red.add(getNumDigits(number));
			number/=10;
		}
		for(int i=0; i<red.size()-1; i++) {
			for(int j=i+1; j<red.size(); j++) {
				if(red.get(i)>red.get(j)) {
					int temp = red.get(i);
					red.set(i,  red.get(j));
					red.set(j,  temp);
				}
			}
		}
		int[] sorted = new int[red.size()];
		for(int i=0; i<red.size(); i++) {
			sorted[i]=  red.get(i);
		}
		return sorted;
	}
}