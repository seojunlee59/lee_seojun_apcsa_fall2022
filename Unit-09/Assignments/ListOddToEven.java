//(c) A+ Computer Science
//www.apluscompsci.com
//Name - James Lee
//Date - 9/27/22
package assignments;

import java.util.ArrayList;

public class ListOddToEven
{
	public static int go( ArrayList<Integer> ray )
	{
		int oddInd = -1;
		int evenInd = -1;
		int finInd = 0;
		for(int i=0; i<ray.size(); i++) {
			if(ray.get(i)%2==1) {
				oddInd = i;
				break;
			}
		}
		if(oddInd==-1) {
			return oddInd;
		}
		for(int i=oddInd; i<ray.size(); i++) {
			if(ray.get(i)%2==0) {
				evenInd = i;
				break;
			}
		}
		if(evenInd!=-1) {
			for(int i=ray.size()-1; i>=0; i--) {
				if(ray.get(i)%2==0) {
					finInd = i;
					break;
				}
			}
			return Math.abs(oddInd-finInd);
		}
		else {
			return -1;
		}
	}
}