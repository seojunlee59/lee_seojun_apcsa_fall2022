//(c) A+ Computer Science
//www.apluscompsci.com

//Name - James Lee
//Date - 08/19/22
//Class - Period 2 CSA
//Lab  - MilesPerHour

import java.util.Scanner; 
import static java.lang.System.*;
import static java.lang.Math.*;

public class MilesPerHour
{
	private int distance, hours, minutes;
	private double mph;

	public MilesPerHour()
	{
		setNums(0,0,0);
		mph=0.0;
	}

	public MilesPerHour(int dist, int hrs, int mins)
	{
    distance = dist;
    hours = hrs;
    minutes = mins;
	}

	public void setNums(int dist, int hrs, int mins)
	{
    distance = dist;
    hours = hrs;
    minutes = mins;
	}

	public void calcMPH()
	{
    mph = (double)(distance)/(hours+((double)minutes/hours));
    
	}

	public void print()
	{
		System.out.print(mph);
	}
	
	//create a print or toString or both
	
	public String toString()
	{
		return distance+" in "+hours+" hours and "+minutes+" = "+mph+" MPH";
	}
}
