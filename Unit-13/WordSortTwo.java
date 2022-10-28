//(c) A+ Computer Science
//www.apluscompsci.com
//Name -


public class WordSortTwo
{
	private String[] wordRay;

	public WordSortTwo(String sentence)
	{
		wordRay = sentence.split(" ");
	}

	public void sort()
	{
		for(int i=0; i<wordRay.length; i++) {
			for(int j=1; j<wordRay.length; j++) {
				if(wordRay[i].charAt(0)>wordRay[j].charAt(0)) {
					String temp = wordRay[i];
					wordRay[i] = wordRay[j];
					wordRay[j] = temp;
				}
				if(wordRay[i].length()>1 && wordRay[j].length()>1) {
					if(wordRay[i].charAt(0)==wordRay[j].charAt(0)) {
						if(wordRay[i].charAt(1)>wordRay[j].charAt(1)) {
							String temp = wordRay[i];
							wordRay[i] = wordRay[j];
							wordRay[j] = temp;
						}
					}
				}
			}
		}
	}

	public String toString()
	{
		String output=""+wordRay[0]+"\n";
		for(int i=wordRay.length-1; i>0; i--) {
			output+=wordRay[i]+"\n";
		}
		return output+"\n";
	}
}