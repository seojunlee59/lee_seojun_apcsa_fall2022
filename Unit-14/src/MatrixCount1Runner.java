//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

public class MatrixCount1Runner
{
	public static void main( String args[] ) throws Exception
	{
		String output = "";
		for(int i=0; i<MatrixCount1.m.length; i++) {
			for(int j=0; j<MatrixCount1.m.length; j++) {
				output += MatrixCount1.m[i][j]+" ";
			}
			output+="\n";
		}
		System.out.println("Matrix Values: \n"+output+"\n\n"+"The 7 count is :: "+MatrixCount1.count(7)+"\n"+"The 8 count is :: "+MatrixCount1.count(8)+"\nThe 6 count is :: "+MatrixCount1.count(6)+"\nThe 21 count is :: "+MatrixCount1.count(21));
	}
}



