/**
 * This class provides a convenient way to test shuffling methods.
 */
public class Shuffler {

	/**
	 * The number of consecutive shuffle steps to be performed in each call
	 * to each sorting procedure.
	 */
	private static final int SHUFFLE_COUNT = 1;

	/**
	 * The number of values to shuffle.
	 */
	private static final int VALUE_COUNT = 10;

	/**
	 * Tests shuffling methods.
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive perfect shuffles:");
		int[] values1 = new int[VALUE_COUNT];
		for (int i = 0; i < values1.length; i++) {
			values1[i] = i;
			}
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			perfectShuffle(values1);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values1.length; k++) {
				System.out.print(" " + values1[k]);
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive efficient selection shuffles:");
		int[] values2 = new int[VALUE_COUNT];
		for (int i = 0; i < values2.length; i++) {
			values2[i] = i;
			}
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			selectionShuffle(values2);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values2.length; k++) {
				System.out.print(" " + values2[k]);
			}
			System.out.println();
		}
		System.out.println();
	}


	/**
	 * Apply a "perfect shuffle" to the argument.
	 * The perfect shuffle algorithm splits the deck in half, then interleaves
	 * the cards in one half with the cards in the other.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void perfectShuffle(int[] values) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 3 *** */
		int[] newDeck = new int[values.length];
		int blue= values.length/2;
		for(int a=0; a<values.length; a++) {
			System.out.print(values[a]);
		}
		int red = 0;
		for(int i=0; i<values.length; i+=2) {
			newDeck[i] = values[red];
			red++;
		}
		int red2 = blue;
		for(int k=1; k<(values.length); k+=2) {
			newDeck[k] = values[red2];
			red2++;
		}
		for(int j=0; j<values.length; j++) {
			values[j] = newDeck[j];
		}
	}

	/**
	 * Apply an "efficient selection shuffle" to the argument.
	 * The selection shuffle algorithm conceptually maintains two sequences
	 * of cards: the selected cards (initially empty) and the not-yet-selected
	 * cards (initially the entire deck). It repeatedly does the following until
	 * all cards have been selected: randomly remove a card from those not yet
	 * selected and add it to the selected cards.
	 * An efficient version of this algorithm makes use of arrays to avoid
	 * searching for an as-yet-unselected card.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void selectionShuffle(int[] values) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 3 *** */
		int[] shuffled  = new int[values.length];
		int j=0;
		for(int i=0; i<=values.length-1; i++) {
			if(values[i]!=0){
				j = (int)Math.random()*values.length;
			}
			shuffled[i] = values[j];
			values[j] = 0;
		}
	}
	public static String coinToss(){
		String[] odds = {"heads", "heads", "tails"};
		int randNum = (int)Math.random()*3;
		return odds[randNum];
	}
	public static boolean arePermutations(int[] arr1, int[] arr2){
		int x = 0;
		boolean flag = false;
		for(int i=0; i<arr1.length; i++){
			for(int j=0; j<arr1.length; j++){
				if(arr1[i]>arr2[j]){
					x = arr1[i];
					arr1[i] = arr2[j];
					arr2[j] = x;
				}
			}
		}
		for(int k=0; k<arr1.length; k++){
			if(arr1[k]==arr2[k]){
				flag = true;
			}
		}
		return flag;
	}
	
}

