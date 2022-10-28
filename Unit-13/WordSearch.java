//(c) A+ Computer Science
//www.apluscompsci.com
//Name - James Lee

public class WordSearch
{
    private String[][] m;

    public WordSearch( int size, String str )
    {
    	m = new String[size][size];
    	int count = 0;
    	for(int i=0; i<size; i++) {
    		for(int j=0; j<size; j++) {
    			m[i][j] = str.substring(count, count+1);
    			if(count<(size*size)) {
    				count++;
    			}
    		}
    	}
    }

    public boolean isFound( String word )
    {
    	for(int i=0; i<m.length; i++) {
    		for(int j=0; j<m[i].length;j++) {
    			if(checkRight(word, i, j) || checkLeft(word, i, j) || checkUp(word, i, j) || checkDown(word, i, j) || checkDiagUpRight(word, i, j) || checkDiagUpLeft(word, i, j) || checkDiagDownRight(word, i, j) || checkDiagDownLeft(word, i, j)) {
    				return true;
    			}
			}
		}
    	return false;
    }

    @SuppressWarnings("unused")
	public boolean checkRight(String w, int r, int c)
   {
		int x = 1;
		boolean flag = false;
		String red = ""+w.charAt(0);
		if(m[r][c].charAt(0)==w.charAt(0)) {
			for(int i=c+1; i<m[r].length; i++) {
				if(m[r][i].charAt(0)==w.charAt(x)){
					flag = true;
					red+=m[r][i].charAt(0);
				}
				else {
					flag = false;
					break;
				}
				if(x<w.length()-1)
				x++;
				else {
					break;
				}

			}
		}
		if(red.equals(w)) {
			return true;
		}
		return false;
	}

	@SuppressWarnings("unused")
	public boolean checkLeft(String w, int r, int c)
	{
		int x=1;
		boolean flag = false;
		String red = ""+w.charAt(0);
		if(m[r][c].equals(w.substring(0,1))) {
			for(int i=c-1; i>=0; i--) {
				if(m[r][i].charAt(0)==w.charAt(x)){
					flag = true;
					red+=m[r][i].charAt(0);
				}
				else {
					flag = false;
					break;
				}
				if(x<w.length()-1)
					x++;
				else {
					break;
				}

			}
		}
		if(red.equals(w)) {
			return true;
		}
		return false;
	}

	@SuppressWarnings("unused")
	public boolean checkUp(String w, int r, int c)
	{
		int x=1;
		boolean flag = false;
		String red = ""+w.charAt(0);
		if(m[r][c].equals(w.substring(0,1))) {
			for(int i=r-1; i>=0; i--) {
				if(m[i][c].charAt(0)==w.charAt(x)){
					flag = true;
					red+=m[i][c].charAt(0);
				}
				else {
					flag = false;
					break;
				}
				if(x<w.length()-1)
					x++;
				else {
					break;
				}

			}
		}
		if(red.equals(w)) {
			return true;
		}
		return false;
	}

	@SuppressWarnings("unused")
	public boolean checkDown(String w, int r, int c)
   {
		int x=1;
		boolean flag = false;
		String red = ""+w.charAt(0);
		if(m[r][c].equals(w.substring(0,1))) {
			for(int i=r+1; i<m.length; i++) {
				if(m[i][c].charAt(0)==w.charAt(x)){
					flag = true;
					red+=m[i][c].charAt(0);
				}
				else {
					flag = false;
					break;
				}
				if(x<w.length()-1)
					x++;
				else {
					break;
				}

			}
		}
		if(red.equals(w)) {
			return true;
		}
		return false;
	}
	
	@SuppressWarnings("unused")
	public boolean checkDiagUpRight(String w, int r, int c)
	{
		int x=1;
		boolean flag = false;
		String red = ""+w.charAt(0);
		if(m[r][c].equals(w.substring(0,1))) {
			for(int i=r-1, j=c+1; i>=0 && j<m[r].length; i--, j++) {
				if(m[i][j].charAt(0)==w.charAt(x)){
					flag = true;
					red+=m[i][j].charAt(0);
				}
				else {
					flag = false;
				}
				if(x<w.length()-1)
					x++;
				else {
					break;
				}

			}
		}
		if(red.equals(w)) {
			return true;
		}
		return false;
	}

	@SuppressWarnings("unused")
	public boolean checkDiagUpLeft(String w, int r, int c)
	{
		int x=1;
		boolean flag = false;
		String red = ""+w.charAt(0);
		if(m[r][c].equals(w.substring(0,1))) {
			for(int i=r-1, j=c-1; i>=0 && j>=0; i--, j--) {
				if(m[i][j].charAt(0)==w.charAt(x)){
					flag = true;
					red+=m[i][j].charAt(0);
				}
				else {
					flag = false;
					break;
				}
				if(x<w.length()-1)
					x++;
				else {
					break;
				}

			}
		}
		if(red.equals(w)) {
			return true;
		}
		return false;
	}

	@SuppressWarnings("unused")
	public boolean checkDiagDownLeft(String w, int r, int c)
   {
		int x=1;
		boolean flag = false;
		String red = ""+w.charAt(0);
		if(m[r][c].equals(w.substring(0,1))) {
			for(int i=r+1, j=c-1; i<m.length && j>=0; i++, j--) {
				if(m[i][j].charAt(0)==w.charAt(x)){
					flag = true;
					red+=m[i][j].charAt(0);
				}
				else {
					flag = false;
					break;
				}
				if(x<w.length()-1)
					x++;
				else {
					break;
				}

			}
		}
		if(red.equals(w)) {
			return true;
		}
		return false;
	}

	@SuppressWarnings("unused")
	public boolean checkDiagDownRight(String w, int r, int c)
	{
		int x=1;
		boolean flag = false;
		String red = ""+w.charAt(0);
		if(m[r][c].equals(w.substring(0,1))) {
			for(int i=r+1, j=c+1; i<m.length && j<m[i].length; i++, j++) {
				if(m[i][j].charAt(0)==w.charAt(x)){
					flag = true;
					red+=m[i][j].charAt(0);
				}
				else {
					flag = false;
					break;
				}
				if(x<w.length()-1)
					x++;
				else {
					break;
				}

			}
		}
		if(red.equals(w)) {
			return true;
		}
		return false;
	}

    public String toString()
    {
    	String opt = "";
    	for(int i=0; i<m.length; i++) {
    		for(String red : m[i]) {
    			opt+=red+" ";
    		}
    		opt+="\n";
    	}
 		return opt;
    }
}
