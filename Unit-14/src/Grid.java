//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.ArrayList;
import java.util.Arrays;

public class Grid
{
   private String[][] grid;
   private int maxCnt;

   //load vals into the rows x cols grid randomly
	public Grid(int rows, int cols, String[] vals)
	{
		grid = new String[rows][cols];
		maxCnt = 0;
		ArrayList<String> values = new ArrayList<String>();
		int x = 0;
		for(int i=0; i<vals.length; i++) {
			values.add(vals[i]);
		}
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				x = (int)Math.random()*(values.size()-1);
				grid[i][j] = values.get(x);
				values.remove(x);
			}
		}
	}

	//find out which of the vals occurs the most
	public String findMax(String[] vals)
	{
		String indStr = "";
		String maxNm = "";
		int count = 0;
		int maxCnt = 0;
		for(int i=0; i<vals.length; i++) {
			indStr = vals[i];
			for(int j=0; j<vals.length; j++) {
				if(vals[j].equals(indStr)) {
					count++;
				}
			}
			if(count>maxCnt) {
				maxCnt = count;
				maxNm = vals[i];
			}
			count = 0;
		}
		return maxNm;
	}

	//returns a count of how many times val occurs in the matrix
	private int countVals( String val )
	{
		return maxCnt;
	}

	//display the grid
	public String toString()
	{
		String output="";
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid.length; j++) {
				output += grid[i][j]+" ";
			}
			output+="\n";
		}
		return output;
	}
}