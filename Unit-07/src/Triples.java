//(c) A+ Computer Science
// www.apluscompsci.com
//Name - James Lee

import static java.lang.System.*;

public class Triples
{
   private int number;
   private String red = "bob";
	public Triples()
	{
		setNum(0);
	}

	public Triples(int num)
	{
		setNum(num);

	}

	public void setNum(int num)
	{
		number = num;

	}
//	if(Math.pow(c, 2)==((Math.pow(a, 2)+Math.pow(b, 2)))) {
////if((((a%2==0)&&(b%2==1)) || ((a%2==1)&&(b%2==0)))) { //greatestCommonFactor2((a%b),c)==1 && 
//red += ""+a+" "+b+" "+c+"\n";
////}
//}
	public String isTriple(int a, int b, int c) {
		while(a<number) {
			System.out.println("here 34");
			while(b<number) {
				System.out.println("here 36");
				while(c<number) {
					System.out.println("here 38");
					if(a%2==0 && b%2==1) {
						if((int)Math.pow(a, 2)==(2*(b+c))) {
							System.out.println("here 41");
							red += ""+a+" "+b+" "+c+"\n";
						}
					}
					else if(a%2==1 && b%2==0) {
						if((int)Math.pow(a,2)==(b+c)) {
							System.out.println("here 47");
							red += ""+a+" "+b+" "+c+"\n";
						}
					}
					c+=1;
				}
				b++;
				c=1;
			}
			a++;
			b=1;
		}
		return red;
	}
	
	private int greatestCommonFactor2(int q, int e)
	{
//		int max = 0;
		if(q==1) {
			return q;
		}
		int x = 0;
		x = q%e;
		return greatestCommonFactor2(x, e);
	}

	public String toString()
	{
		String output=red;
		return output;
	}
}
