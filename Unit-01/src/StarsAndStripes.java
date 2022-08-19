//© A+ Computer Science
//www.apluscompsci.com

//Name - James Lee
//Date - 08/18/22
//Class - Period 2 CSA
//Lab  - StarsAndStripes

import static java.lang.System.*;

public class StarsAndStripes
{
   public StarsAndStripes()
   {
      out.println("StarsAndStripes");
      printTwoBlankLines();
   }

   public void printTwentyStars()
   {
	out.println("********************");
   }

   public void printTwentyDashes()
   {
	out.println("--------------------");
   }

   public void printTwoBlankLines()
   {
	out.println("\n\n");
   }
   
   public void printASmallBox()
   {	
	out.println("____________________");
	out.println("|__________________|");
   }
 
   public void printABigBox()
   { 	
	out.println("____________________");
	out.println("|                  |");
	out.println("|                  |");
	out.println("|__________________|");
   }   
}
