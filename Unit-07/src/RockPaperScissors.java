//(c) A+ Computer Science
// www.apluscompsci.com
//Name - James Lee 

import java.util.Scanner;
import static java.lang.System.*;

public class RockPaperScissors
{
	private String playChoice;
	private String compChoice;

	public RockPaperScissors()
	{
		setPlayers("");
	}

	public RockPaperScissors(String player)
	{
		setPlayers(player);
	}

	public void setPlayers(String player)
	{
		switch(player) {
		case "R":
			playChoice = "rock";
			break;
		case "P":
			playChoice = "paper";
			break;
		case "S":
			playChoice = "scissors";
		}
		
		int x = (int)(Math.random()*3);
		switch(x) {
		case 0:
			compChoice = "rock";
			break;
		case 1:
			compChoice = "paper";
			break;
		case 2:
			compChoice = "scissors";
		}
	}

	public String determineWinner()
	{
		String winner="";
		if((playChoice=="rock" && compChoice=="scissors") || (playChoice=="paper" && compChoice=="rock") || (playChoice=="scissors" && compChoice=="paper")) {
			winner = "Player";
		}
		else if(!((playChoice=="rock" && compChoice=="scissors") || (playChoice=="paper" && compChoice=="rock") || (playChoice=="scissors" && compChoice=="paper"))) {
			winner = "Computer";
		}
		else {
			winner = "Tie!";
		}
		return winner;
	}

	public String toString()
	{
		String red = "";
		String blue = "";
		if(determineWinner().equals("Player")) {
			red = playChoice;
			blue = compChoice;
		}
		else if(determineWinner().equals("Computer")) {
			red = compChoice;
			blue = playChoice;
		}
		String output="player had: "+playChoice+"\n"+"computer had: "+compChoice+"\n"+"!"+determineWinner()+" wins <<"+red+" Beats "+blue+">>!\r\n";
		return output;
	}
}
