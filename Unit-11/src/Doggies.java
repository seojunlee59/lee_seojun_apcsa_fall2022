//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;

public class Doggies
{
	private Dog[] pups;

	public Doggies(int size)
	{
		pups = new Dog[size];
		
	}
	
	public void set(int spot, int age, String name)
	{
		//put a new Dog in the array at spot 
		//make sure spot is in bounds		
		if(spot<=pups.length-1) {
			pups[spot] = new Dog(age, name);
		}
	}

	public String getNameOfOldest()
	{
		int old = pups[0].getAge();
		int q = 0;
		for(int i=0; i<pups.length; i++) {
			if(old<pups[i].getAge()) {
				old = pups[i].getAge();
				q=i;
			}
		}
		return pups[q].getName();
	}

	public String getNameOfYoungest()
	{
		int young = pups[0].getAge();
		int q = 0;
		for(int i=0; i<pups.length; i++) {
			if(young>pups[i].getAge()) {
				young = pups[i].getAge();
				q = i;
			}
		}
		return pups[q].getName();
	}

	public String toString()
	{
		return ""+Arrays.toString(pups);
	}
}