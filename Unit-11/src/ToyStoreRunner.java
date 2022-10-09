//(c) A+ Computer Science
//www.apluscompsci.com
//Name - james lee

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class ToyStoreRunner
{
	public static void main( String args[] )
	{
		ToyStore test1 = new ToyStore();
		String red = "sorry bat sorry sorry sorry train train teddy teddy ball ball";
		String[] test = red.split(" ");
		out.println(test1);
		for(int i=0; i<test.length; i++) {
			test1.loadToys(test[i]);
		}
		test1.sortToysByCount();
		out.println(test1);
	}
}