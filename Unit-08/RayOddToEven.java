//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class RayOddToEven
{
	public static int go(int[] ray)
	{
		boolean odD = false;
		boolean eveN = false;
		int oddInd = 0;
		int evenInd = 0;
		for(int i=0; i<ray.length; i++) {
			if(ray[i]%2==1) {
				odD = true;
				oddInd = i;
				break;
			}
		}
		for(int j=oddInd; j<ray.length; j++) {
			if(ray[j]%2==0) {
				eveN = true;
				evenInd = j;
				break;
			}
		}
		if(odD==true && eveN==true) {
			return (int)Math.abs((oddInd-evenInd));
		}
		else {
			return -1;
		}
	}
}