//(c) A+ Computer Science
//www.apluscompsci.com
//Name - james lee

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class ToyStore
{
	private ArrayList<Toy> toyList;

	public ToyStore()
	{
		toyList = new ArrayList<Toy>();
	}

	public void loadToys( String toys )
	{
		toyList.add(new Toy(toys));
	}
  
  	public Toy getThatToy( String nm )
  	{
  		Toy x = new Toy();
  		for(int i=0; i<toyList.size(); i++) {
  			if(toyList.get(i).getName()==nm) {
  				x = toyList.get(i);
  			}
  		}
  		return x;
  	}
  
  	public String getMostFrequentToy()
  	{
  		ArrayList<Toy> lstClone = toyList;
  		String toyNm = "";
  		int count = 0;
  		int highCnt = 0;
  		String highNm = "";
  		for(int i=0; i<lstClone.size(); i++) {
  			toyNm = lstClone.get(i).getName();
  			for(int j=0; j<lstClone.size(); j++) {
  				if(lstClone.get(j).getName()==toyNm) {
  					count++;
  				}
  			}
  			if(count>highCnt) {
  				highCnt = count;
  				highNm = lstClone.get(i).getName();
  			}
  			count = 0;
  			for(int k=0; k<lstClone.size(); k++) {
  				if(lstClone.get(k).getName()==toyNm) {
  					lstClone.remove(k);
  				}
  			}
  		}
  		return highNm;
  	}  

  	public void sortToysByCount()
  	{
  		ArrayList<Toy> listClone = toyList;

  		String toyNm = "";
  		int count =0;
  		ArrayList<Toy> lsCln = new ArrayList<Toy>();
  		lsCln.add(listClone.get(0));
  		int yu = 0;
  		boolean flag = false;
  		int d = 0;
  		for(int q=1; q<listClone.size(); q++) {
  			for(int re=yu; re>-1; re--) {
	  			if(!(listClone.get(q).getName().equals(lsCln.get(re).getName()))) {
	  				flag = true;
	  			}
	  			else {
	  				flag = false;
	  				break;
	  			}
  			}
  			if(flag == true) {
  				lsCln.add(listClone.get(q));
  				yu++;
  			}		
  			
  		}
  		
  		ArrayList<Toy> clnCln = listClone;
  		for(int i=0; i<clnCln.size(); i++) {
  			toyNm = clnCln.get(i).getName();
  			for(int j=0; j<clnCln.size();j++) {
  				if(clnCln.get(j).getName().equals(toyNm)) {
  					count++;
  				}

  			}
			lsCln.get(d).setCount(count);
			for(int e=0; e<clnCln.size(); e++) {
				if(clnCln.get(e).getName().equals(toyNm)) {
					clnCln.remove(e);
				}
			}
			count = 0;
			if(d<=3) {
				d++;
			}
  		}

  		Toy max = lsCln.get(0);
  		for(int w=1; w<lsCln.size(); w++) {
  			if(lsCln.get(w).getCount()>max.getCount()) {
  				Toy temp = max;
  				lsCln.set(0, lsCln.get(w));
  				lsCln.set(w, temp);
  				
  			}
  		}
  		toyList = lsCln;
  	}  
  	  
	public String toString()
	{
		String opt = "[";
		for(int i=0; i<toyList.size(); i++) {
			opt += toyList.get(i).getName() + " " + toyList.get(i).getCount()+", ";
			if(i==toyList.size()-1) {
				opt = opt.substring(0, opt.length()-2);
			}
		}
		opt+="]";
		
	   return opt + "\nmax: "+getMostFrequentToy();
	}
}