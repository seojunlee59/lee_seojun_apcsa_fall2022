//(c) A+ Computer Science
// www.apluscompsci.com
//Name - James Lee

import java.util.Scanner;
import static java.lang.System.*;

public class RPSRunner
{
	public static void main(String args[])
	{
//		Rock-Paper-Scissors - pick your weapon[R,P,S]:: R
//		player had R
//		computer had P

		Scanner keyboard = new Scanner(System.in);
		boolean flag = true;
		
		while(flag) {		
			out.print("Rock-Paper-Scissors - pick your weapon[R,P,S] :: ");
			String play = keyboard.next();

			RockPaperScissors game = new RockPaperScissors();	
			game.setPlayers(play);
			game.determineWinner();
			out.println(game);
			
			out.print("Do you want to play again?");
			char yorn = keyboard.next().charAt(0);
			if(yorn=='n') {
				break;
			}
		}
	}
}
