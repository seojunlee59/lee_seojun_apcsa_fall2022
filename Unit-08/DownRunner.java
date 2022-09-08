//(c) A+ Computer Science
//www.apluscompsci.com
//Name - James Lee
//Date - 09/07/22

public class DownRunner
{
	public static void main( String args[] )
	{					
//		[-99,1,2,3,4,5,6,7,8,9,10,12345]
//		[10,9,8,7,6,5,4,3,2,1,-99]
//		[10,20,30,40,50,-11818,40,30,20,10]
//		[32767]
//		[255,255]
//		[9,10,-88,100,-555,1000]
//		[10,10,10,11,456]
//		[-111,1,2,3,9,11,20,30]
//		[9,8,7,6,5,4,3,2,0,-2,-989]
//		[12,15,18,21,23,1000]
//		[250,19,17,15,13,11,10,9,6,3,2,1,-455]
//		[9,10,-8,10000,-5000,1000]
		int[] array1 = {-99,1,2,3,4,5,6,7,8,9,10,12345};
		int[] array2 = {10,9,8,7,6,5,4,3,2,1,-99};
		int[] array3 = {10,20,30,40,50,-11818,40,30,20,10};
		int[] array4 = {32767};
		int[] array5 = {255,255};
		int[] array6 = {9,10,-88,100,-555,1000};
		int[] array7 = {10,10,10,11,456};
		int[] array8 = {-111,1,2,3,9,11,20,30};
		int[] array9 = {9,8,7,6,5,4,3,2,0,-2,-989};
		int[] array10 = {12,15,18,21,23,1000};
		int[] array11 = {250,19,17,15,13,11,10,9,6,3,2,1,-455};
		int[] array12 = {9,10,-8,10000,-5000,1000};
		System.out.println(RayDown.go(array1));
		System.out.println(RayDown.go(array2));
		System.out.println(RayDown.go(array3));
		System.out.println(RayDown.go(array4));
		System.out.println(RayDown.go(array5));
		System.out.println(RayDown.go(array6));
		System.out.println(RayDown.go(array7));
		System.out.println(RayDown.go(array8));
		System.out.println(RayDown.go(array9));
		System.out.println(RayDown.go(array10));
		System.out.println(RayDown.go(array11));
		System.out.println(RayDown.go(array12));
		
	}
}