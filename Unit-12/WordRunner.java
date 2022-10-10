//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File; 
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
import static java.lang.System.*;
import java.util.ArrayList;

public class WordRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("words.dat"));
		ArrayList<String> red = new ArrayList<String>();
		int size = file.nextInt();
		file.nextLine();
		for(int i=0; i<size; i++) {
			red.add(file.next());
			if(file.hasNextLine()==true) {
				file.nextLine();
			}
		}
		String smol = red.get(0);
		String temp = "";
		for(int j=1; j<red.size(); j++) {
			if(red.get(j).length()<smol.length()) {
				temp = smol;
				red.set(0, red.get(j));
				red.set(j, temp);
				smol = red.get(j);
			}
		}
		Word test1 = new Word();
		Word test2 = new Word();
		String temp2 = "";
		for(int j=1; j<red.size(); j++) {
			if(red.get(j).length()==red.get(j-1).length()) {
				test1.setWord(red.get(j-1));
				test2.setWord(red.get(j));
				if(test1.compareTo(test2)!=0) {
					if(test1.compareTo(test2)==-1) {
						temp2 = test1.getWord();
						red.set(j-1, test2.getWord());
						red.set(j, temp2);
					}
				}
			}
			String opt = "";
			for(int i=0; i<red.size(); i++) {
				opt+=red.get(i);
			}
			out.println(opt);
		}











	}
}