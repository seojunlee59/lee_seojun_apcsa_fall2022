//(c) A+ Computer Science
//www.apluscompsci.com
//Name -James Lee
//Date - 09/07/22

public class RayDown
{
	//go() will return true if all numbers in numArray
	//are in decreasing order [31,12,6,2,1]
	public static boolean go(int[] numArray)
	{
		boolean flag = false;
		if(numArray.length==1) {
			return true;
		}
		for(int i=1; i<numArray.length; i++) {
			if(numArray[i]<numArray[i-1]) {
				flag = true;
			}
		}
		if(flag==true) {
			return true;
		}
		else {
			return false;
		}
	}	
}
