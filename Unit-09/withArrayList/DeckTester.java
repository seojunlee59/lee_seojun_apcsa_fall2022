package withArrayList;
import java.util.ArrayList;
public class DeckTester {
	
	public static void main(String[] args) {
		ArrayList<String> ranks = new ArrayList<String>();
		ranks.add("jack");
		ranks.add("queen");
		ranks.add("king");
		ArrayList<String> suits = new ArrayList<String>();
		suits.add("blue");
		suits.add("red");
		ArrayList<Integer> pointsValues = new ArrayList<Integer>();
		pointsValues.add(11);
		pointsValues.add(12);
		pointsValues.add(13);
		Deck d = new Deck(ranks, suits, pointsValues);
		System.out.println(d.isEmpty());
		System.out.println(d.size());
		System.out.println(d.deal());
		System.out.println(d);
		
	}
}
