//(c) A+ Computer Science
//www.apluscompsci.com
//Name - James Lee

public class MatrixCount1
{
    public static int[][] m = {{ 1, 2, 3, 4, 5},
								{ 6, 7, 8, 9, 0},
								{ 6, 7, 1, 2, 5},
								{ 6, 7, 8, 9, 0},
								{ 5, 4, 3, 2, 1}};

    public static int count( int val  )
    {
    	int count = 0;
    	for(int i=0; i<m.length; i++) {
    		for(int j=0; j<m.length; j++) {
    			if(m[i][j]==val) {
    				count++;
    			}
    		}
    	}
		return count;
    }
}
