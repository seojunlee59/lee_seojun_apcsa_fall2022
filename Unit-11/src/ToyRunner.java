//(c) A+ Computer Science
//www.apluscompsci.com
//Name - james lee

import static java.lang.System.*;

public class ToyRunner
{
	public static void main(String[] args)
	{
		Toy test1 = new Toy("sorry");
		test1.setCount(1);
		out.println(test1);
		
		Toy test2 = new Toy("gi joe");
		test2.setCount(5);
		out.println(test2);
	}
}