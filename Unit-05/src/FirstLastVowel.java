//(c) A+ Computer Science
//www.apluscompsci.com
//Name - James Lee
//Date - 08/25/22


public class FirstLastVowel
{
   public static String go( String a )
	{
		String[] stringlist = {"a", "e", "i", "o", "u"};
		a = a.toLowerCase();
		if(a.length()<2) {
			for(int i=0; i<stringlist.length; i+=1) {
				if(a.equals(stringlist[i])) {
					return "yes";
				}
			}
		}
		for(int i=0;i<stringlist.length; i+=1){
			if(a.substring(0,1).equals(stringlist[i])){
//				|| b.substring(1,1).equals(stringlist[i])
				return "yes";
			}
			else if(a.substring(a.length()-1).equals(stringlist[i])) {
				return "Ues";
			}
			else{
				return "no";
			}
		}
		return a;
	}

}