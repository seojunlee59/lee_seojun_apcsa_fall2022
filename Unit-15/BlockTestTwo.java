//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Canvas;

public class BlockTestTwo extends Canvas
{
	public BlockTestTwo()
	{
		setBackground(Color.WHITE);
	}

	public void paint(Graphics window)
	{
		Block one = new Block();
		one.draw(window);

		Block two = new Block(50,50,30,30);
		two.draw(window, Color.white);

		Block three = new Block(350,350,15,15,Color.RED);
		three.draw(window);

		Block four = new Block(450,50,20,60, Color.GREEN);
		four.draw(window);
		
		//add more test cases	
		Block five = new Block(450, 50, 20, 60);
		five.draw(window);
		
		Block six = new Block(450, 50);
		six.draw(window);
		
		Block seven = new Block(Color.RED);
		seven.draw(window);		
	}
}