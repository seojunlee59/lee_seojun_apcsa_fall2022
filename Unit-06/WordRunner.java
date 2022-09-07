//(c) A+ Computer Science
//www.apluscompsci.com
//Name - James Lee

import static java.lang.System.*;

public class WordRunner
{
	public static void main ( String[] args )
	{
		//add test cases	
//		Hello
//		World
//		JukeBox
//		TCEA
//		UIL

		Word test1 = new Word("Hello");
		test1.getFirstChar();
		test1.getLastChar();
		test1.getBackWards();
		out.println(test1);
		test1.setString("World");
		test1.getFirstChar();
		test1.getLastChar();
		test1.getBackWards();
		out.println(test1);
		test1.setString("Jukebox");
		test1.getFirstChar();
		test1.getLastChar();
		test1.getBackWards();
		out.println(test1);
		test1.setString("TCEA");
		test1.getFirstChar();
		test1.getLastChar();
		test1.getBackWards();
		out.println(test1);
		test1.setString("UIL");
		test1.getFirstChar();
		test1.getLastChar();
		test1.getBackWards();
		out.println(test1);
	}
}