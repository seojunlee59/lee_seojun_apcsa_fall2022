//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Scanner;
import static java.lang.System.*;

public class MonsterRunner
{
	public static void main( String args[] )
	{
		try (Scanner keyboard = new Scanner(System.in)) {
			//ask for name and size
			out.print("Enter 1st Monster's Name :: ");
			String oneNm = keyboard.next();
			
			out.print("Enter 1st Monster's Age :: ");
			int oneAg = keyboard.nextInt();
			
			out.print("Enter 2nd Monster's Name :: ");
			String twoNm = keyboard.next();
			
			out.print("Enter 2nd Monster's Age :: ");
			int twoAg = keyboard.nextInt();
			
			//instantiate monster one
			out.println(oneNm+" "+oneAg);
			Skeleton test1 = new Skeleton(oneNm, oneAg);
			out.println("Monster 1 - "+test1);
			Skeleton test2 = new Skeleton(twoNm, twoAg);
			out.println("Monster 2 - "+test2);
			
			if(test1.isBigger(test2)==true) {
				out.println("Monster one is bigger than Monster two.");
			}
			else {
				out.println("Monster two is bigger than Monster one.");
			}
			if(test1.equals(test2)==true) {
				out.println("Monster one does have the same name as Monster two.");
			}
			else {
				out.println("Monster one does not have the same name as Monster two.");
			}

		}
	}
}