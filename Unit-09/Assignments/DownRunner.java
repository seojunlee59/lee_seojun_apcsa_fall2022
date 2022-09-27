//(c) A+ Computer Science
//www.apluscompsci.com
//Name - James Lee
//Date - 9/27/22
package assignments;
import java.util.ArrayList;
public class DownRunner
{
	public static void main( String args[] ) {
		ArrayList<Integer> test1 = new ArrayList<Integer>();
		int[][] list1 = new int[][]{{-99,1,2,3,4,5,6,7,8,9,10,12345}, {10,9,8,7,6,5,4,3,2,1,-99}, {10,20,30,40,50,-11818,40,30,20,10}, {32767}, {255,255}, {9,10,-88,100,-555,1000}, {10,10,10,11,456}, {-111,1,2,3,9,11,20,30}, {9,8,7,6,5,4,3,2,0,-2,-989}, {12,15,18,21,23,1000}, {250,19,17,15,13,11,10,9,6,3,2,1,-455}, {9,10,-8,10000,-5000,1000}};
		for(int i=0; i<list1.length; i++) {
			for(int j=0; j<list1[i].length; j++) {
				test1.add(list1[i][j]);
			}
			System.out.println(ListDown.go(test1));
			test1.clear();
		}
	}
}