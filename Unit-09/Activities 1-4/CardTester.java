/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */
		Card test1 = new Card("10", "spade", 10);
		Card test2 = new Card("2", "hearts", 2);
		System.out.println(test1.matches(test2));
		Card test3 = new Card("jack", "clubs", 11);
		System.out.println(test3);
	}
}
