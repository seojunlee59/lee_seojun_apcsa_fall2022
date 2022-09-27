//(c) A+ Computer Science
//www.apluscompsci.com
//Name - James Lee
//Date - 9/27/22
package assignments;
import java.util.ArrayList;

public class ListDown
{
	//go() will return true if all numbers in numArray
	//are in decreasing order [31,12,6,2,1]
	public static boolean go(ArrayList<Integer> numArray)
	{
		boolean flag = false;
		int count = 0;
		if(numArray.size()==1) {
			return true;
		}
		for(int i=1; i<numArray.size(); i++) {
			if(numArray.get(i)<numArray.get(i-1)) {
				flag = true;
			}
			else {
				flag = false;
				count++;
			}
			if(count>1) {
				break;
			}
		}
		return flag;
	}	
}