package testtest;
//� A+ Computer Science  -  www.apluscompsci.com
//Name - James Lee
//Date - 10/31/22
//Class - Period 2
//Lab  - Maze

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class Maze
{
 private int[][] maze;
 private boolean exitFound;

	public Maze()
	{
		exitFound = false;
		maze = new int[0][0];
	}

	public Maze(int size, String line)
	{
		/*
		 * Create a 2-D array of the maze blocks (1==passable, 0=blocked)
		 */
		exitFound=false;
		maze = new int[size][size];
		int spot=0;
		//out.println(line);
		for(int r= 0; r<maze.length; r++)
		{
			for(int c =0; c<maze[r].length; c++)
			{
				
				maze[r][c]=(line.charAt(spot*2)-48);
				spot++;
			}
		}
	}

	public void checkForExitPath(int r, int c)
	{
		/* Input the starting location row, col (on left side of maze)
		 * Check the cell location to make sure its within bounds.
		 * If current position is on the right side of maze then found exit.
		 * If not on right side, then check the cells around it (top, bot, left, right)
		 * 
		 */
		if(r < maze.length && r >= 0 && c < maze.length && c >= 0 && maze[r][c]==1 )
		{
			if( c==maze.length-1)
			{
				exitFound = true;
			}
			else
			{
				int save = maze[r][c];  //save current value in matrix
				maze[r][c] = 0;			//mark the spot as visited (so don't recheck in recursive call)
				checkForExitPath(r + 1, c); //below
				checkForExitPath(r - 1, c); //above
				checkForExitPath(r, c + 1); //right
				checkForExitPath(r, c - 1); //left
				maze[r][c]=save;			//put the original value back
			}
		}
	}

	public String toString()
	{
		String output="";
		for(int r= 0; r<maze.length; r++)
		{
			for(int c =0; c<maze[r].length; c++)
			{
				output+=maze[r][c]+" ";
			}
			output+="\n";
		}
		output+=(exitFound==true?"exit found\n\n":"exit not found\n\n");
		return output;
	}
}