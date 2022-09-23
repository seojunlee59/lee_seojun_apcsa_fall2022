package withArray;

public class Deck {

	private Card[] cards;

	private int size;

	public Deck(String[] ranks, String[] suits, int[] values) {
		cards = new Card[ranks.length*suits.length];
		for(int i=0; i<ranks.length; i++) {
			for(int j=0; j<suits.length; j++) {
				int cardIndex = suits.length*i + j;
				cards[cardIndex] = new Card(ranks[i], suits[j], values[i]);
				
			}
		}
		size = cards.length;

		shuffle();
	}

	public boolean isEmpty() {
		return size==0;
	}

	public int size() {
		return size;
	}

	public void shuffle() {
		int j=0;
		for(int i=size-1; i>=0; i--) {
			j = (int)(Math.random()*i);
			Card temp = cards[i];
			cards[i]= cards[j];
			cards[j] = temp;
//			size = cards.length;
		}
	}

	public Card deal() {
		if(isEmpty()) {
			return null;
		}
		size--;
		Card x = cards[size];
		return x;
	}

	@Override
	public String toString() {
		String rtn = "size = " + size + "\nUndealt cards: \n";

		for (int k = size - 1; k >= 0; k--) {
			rtn = rtn + cards[k];
			if (k != 0) {
				rtn = rtn + ", ";
			}
			if ((size - k) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\nDealt cards: \n";
		for (int k = size() - 1; k >= size; k--) {
			rtn = rtn + cards[k];
			if (k != size) {
				rtn = rtn + ", ";
			}
			if ((k - size()) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\n";
		return rtn;
	}
}
