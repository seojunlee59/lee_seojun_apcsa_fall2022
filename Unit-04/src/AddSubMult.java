//(c) A+ Computer Science
//www.apluscompsci.com
//Name - James Lee

import static java.lang.System.*; 
import java.util.Scanner;

public class AddSubMult
{
	private static double r;
	private static double a;
	private static double b;
	public AddSubMult() {
//		check(0.0, 0.0);
		r = 0.0;
	}
	public AddSubMult(double aa, double bb) {
		a = aa;
		b = bb;
		check(a,b);
	}
	
	public static double check(double c, double d)
	{
		if(c>d){
			r = c-d;
			return r;
		}
		else if(d>c){
			r = b-a;
			return r;
		}
		else if(c==d){
			r = c*d;
			return r;
		}
		return r;
	}
	
	public double check1()
	{
		if(a>b){
			r = a-b;
			return r;
		}
		else if(b>a){
			r = b-a;
			return r;
		}
		else if(a==b){
			r = a*b;
			return r;
		}
		return r;
	}
public void print(){
	out.printf("%.1f\n", r);
}

}
