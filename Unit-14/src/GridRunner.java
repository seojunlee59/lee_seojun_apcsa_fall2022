//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.IOException;
import static java.lang.System.*;

public class GridRunner
{
	public static void main( String args[] ) throws IOException
	{
		Grid test1 = new Grid(5, 5, new String[] {"a", "9", "2", "2", "b", "a", "9", "a", "b", "7", "a", "2", "b", "x", "a", "9", "7", "c", "2", "a", "b", "2", "2", "x", "c"});
		out.println(test1);
		out.println(test1.findMax(new String[] {"a", "9", "2", "2", "b", "a", "9", "a", "b", "7", "a", "2", "b", "x", "a", "9", "7", "c", "2", "a", "b", "2", "2", "x", "c"}));
		
	}
}