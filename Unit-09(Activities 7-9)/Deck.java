package activity9;
import java.util.ArrayList;

public class Deck {

	private ArrayList<Card> cards;

	private int size;

	public Deck(ArrayList<String> ranks, ArrayList<String> suits, ArrayList<Integer> values) {
		cards = new ArrayList<Card>();
		for(int i=0; i<ranks.size(); i++) {
			for(int j=0; j<suits.size(); j++) {
				cards.add(new Card(ranks.get(i), suits.get(j), values.get(i)));

			}
		}
		size = cards.size();
		
		shuffle();
	}

	public boolean isEmpty() {
		return size==0;
	}

	public int size() {
		System.out.println("here");
		return size;
	}

	 public void shuffle() {
		 for (int k = cards.size() - 1; k > 0; k--) {
			int howMany = k + 1;
			int start = 0;
			int randPos = (int) (Math.random() * howMany) + start;
			Card temp = cards.get(k);
			cards.set(k, cards.get(randPos));
			cards.set(randPos, temp);
		 }
		  size = cards.size();
	 }

	public Card deal() {
		if(isEmpty()) {
			return null;
		}
		size--;
		Card x = cards.get(size);
		return x;
	}

	@Override
	public String toString() {
		String rtn = "size = " + size + "\nUndealt cards: \n";

		for (int k = size - 1; k >= 0; k--) {
			rtn = rtn + cards.get(k);
			if (k != 0) {
				rtn = rtn + ", ";
			}
			if ((size - k) % 2 == 0) {
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\nDealt cards: \n";
		for (int k = size() - 1; k >= size; k--) {
			rtn = rtn + cards.get(k);
			if (k != size) {
				rtn = rtn + ", ";
			}
			if ((k - size()) % 2 == 0) {
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\n";
		return rtn;
	}
}

