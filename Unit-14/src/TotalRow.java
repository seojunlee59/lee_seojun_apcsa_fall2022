//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.*;

public class TotalRow
{
    public static List<Integer> getRowTotals( int[][] m )
    {
    	int sum = 0;
    	ArrayList<Integer> liSum = new  ArrayList<Integer>();
    	for(int[] x : m) {
    		for(int y : x) {
    			sum += y;
    		}
    		liSum.add(sum);
    		sum = 0;
    	}
		return liSum;
    }
}
