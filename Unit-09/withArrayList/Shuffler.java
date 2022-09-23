package withArrayList;
import java.util.ArrayList;
public class Shuffler {

	private static final int SHUFFLE_COUNT = 8;

	private static final int VALUE_COUNT = 52;
	
	public static void main(String[] args) {
		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive perfect shuffles:");
		ArrayList<Integer> values1 = new ArrayList<Integer>();
		for (int i = 0; i < VALUE_COUNT; i++) {
			values1.add(i, i);
			}
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			perfectShuffle(values1);
			for (int k = 0; k < values1.size(); k++) {
				System.out.print(" " + values1.get(k));
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive efficient selection shuffles:");
		ArrayList<Integer> values2 = new ArrayList<Integer>();
		for (int i = 0; i < VALUE_COUNT; i++) {
			values2.add(i, i);
			}
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			selectionShuffle(values2);
			for (int k = 0; k < values2.size(); k++) {
				System.out.print(" " + values2.get(k));
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void perfectShuffle(ArrayList<Integer> values) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 3 *** */
		ArrayList<Integer> newDeck = new ArrayList<Integer>();
		for(int i=0; i<values.size(); i++) {
			newDeck.add(i, 0);
		}
		for(int j=0, k=0; j<values.size()/2; j++) {
			newDeck.set(k, values.get(j));
			k+=2;
		}
		for(int j=values.size()/2,  k2 = 1; j<(values.size()); j++) {
			newDeck.set(k2, values.get(j));
			k2+=2;
		}
		for(int j=0; j<values.size(); j++) {
			values.set(j, newDeck.get(j));
		}
	}

	public static void selectionShuffle(ArrayList<Integer> values) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 3 *** */
		int j=0;
		for(int i=values.size()-1; i>=0; i--) {
			j = (int)(Math.random()*(i));
			int temp = values.get(j);
			values.set(j, values.get(i));
			values.set(i, temp);
		}
	}
	public static String coinToss(){
		ArrayList<String> odds = new ArrayList<String>();
		odds.add("heads");
		odds.add("heads");
		odds.add("tails");
		int randNum = (int)Math.random()*3;
		return odds.get(randNum);
	}
	public static boolean arePermutations(ArrayList<Integer> arr1, ArrayList<Integer> arr2){
		int x = 0; 
		boolean flag = false;
		for(int i=0; i<arr1.size(); i++){
			for(int j=0; j<arr1.size(); j++){
				if(arr1.get(i)>arr2.get(j)){
					x = arr1.get(i);
					arr1.set(i, arr2.get(j));
					arr2.set(j, x);
				}
			}
		}
		for(int k=0; k<arr1.size(); k++){
			if(arr1.get(k)==arr2.get(k)){
				flag = true;
			}
		}
		return flag;
	}
	
}
