package activity9;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board {

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 9;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static String[] ranks = {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};
	private static final ArrayList<String> RANKS = new ArrayList<>(Arrays.asList(ranks)); 

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static String[] suits = {"spades", "hearts", "diamonds", "clubs"};
	private static final ArrayList<String> SUITS = new ArrayList<>(Arrays.asList(suits)); 

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static int[] p_t = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};
	private static final ArrayList<Integer> POINT_VALUES = IntStream.of(p_t)
            .boxed()
            .collect(Collectors.toCollection(ArrayList::new));

	/**
	 * Flag used to control debugging print statements.
	 */
	@SuppressWarnings("unused")
	private static final boolean I_AM_DEBUGGING = true;


	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
	 public ElevensBoard() {
	 	super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	 }

	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Elevens, the legal groups are (1) a pair of non-face cards
	 * whose values add to 11, and (2) a group of three cards consisting of
	 * a jack, a queen, and a king in some order.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	@Override
	public boolean isLegal(List<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		if(containsJQK(selectedCards)==false && selectedCards.size()==2) {
			if(cardAt(selectedCards.get(0)).pointValue()+cardAt(selectedCards.get(1)).pointValue()==11) {
				return true;
			}
		}
		else if(selectedCards.size()==3) {
			if(containsJQK(selectedCards)==true) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Determine if there are any legal plays left on the board.
	 * In Elevens, there is a legal play if the board contains
	 * (1) a pair of non-face cards whose values add to 11, or (2) a group
	 * of three cards consisting of a jack, a queen, and a king in some order.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	@Override
	public boolean anotherPlayIsPossible() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		List<Integer> red = cardIndexes();
		return containsPairSum11(red)==true || containsJQK(red)==true;
	}

	/**
	 * Check for an 11-pair in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 11-pair.
	 * @return true if the board entries in selectedCards
	 *              contain an 11-pair; false otherwise.
	 */
	private boolean containsPairSum11(List<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		for(int i=0; i<selectedCards.size(); i++) {
			for(int j=0; j<selectedCards.size(); j++) {
				if(cardAt(selectedCards.get(i)).pointValue()+cardAt(selectedCards.get(j)).pointValue()==11) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Check for a JQK in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find a JQK group.
	 * @return true if the board entries in selectedCards
	 *              include a jack, a queen, and a king; false otherwise.
	 */
	private boolean containsJQK(List<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		boolean flag = false;
		for(int red : selectedCards) {
			if(cardAt(red).rank().equals("jack") || cardAt(red).rank().equals("queen") || cardAt(red).rank().equals("king")) {
				return true;
			}
		}
		return false;
	}
}
