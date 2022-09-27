//(c) A+ Computer Science
//www.apluscompsci.com
//Name - James Lee
//Date - 9/27/22
package assignments;
import java.util.List;
import java.util.ArrayList;

public class ListSumFirst
{
	public static int go(List<Integer> ray)
	{
		int firstInd = ray.get(0);
		int sum = 0;
		for(int i=1; i<ray.size(); i++) {
			if(ray.get(i)>firstInd) {
				sum+=ray.get(i);
				}
		}
		if(sum!=0)
		return sum;
		else {
			return -1;
		}
	}
}