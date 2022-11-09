//(c) A+ Computer Science
//www.apluscompsci.com
//Name - James Lee

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;

public class Pongv2 extends Canvas implements KeyListener, Runnable
{
	private Ball ball;
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private boolean[] keys;
	private BufferedImage back;
	private Block score;
	private Walls[] walls;
	private int p1;
	private int p2;


	public Pongv2()
	{
		//set up all variables related to the game
		ball = new SpeedUpBall(387, 235, 10, 10, 1, 1);
		
		
		//instantiate a left Paddle
		leftPaddle = new Paddle(10, 200, 20, 100, 5);
		
		
		
		//instantiate a right Paddle
		rightPaddle = new Paddle(754, 200, 20, 100, 5);



		keys = new boolean[4];
		
		score = new Block(350, 500, 100, 50, Color.white);
		p1 = 0;
		p2 = 0;
		walls = new Walls[4];
		walls[0] = new Walls(0, 0, 10, 470, Color.lightGray);
		walls[1] = new Walls(774, 0, 10, 470, Color.lightGray);
		walls[2] = new Walls(0, 0, 800, 10, Color.lightGray);
		walls[3] = new Walls(0, 470, 800, 10, Color.lightGray);
		
    	setBackground(Color.WHITE);
		setVisible(true);
		
		new Thread(this).start();
		addKeyListener(this);		//starts the key thread to log key strokes
	}
	
   public void update(Graphics window){
	   paint(window);
   }

   public void paint(Graphics window)
   {
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();


		ball.moveAndDraw(graphToBack);
		leftPaddle.draw(graphToBack);
		rightPaddle.draw(graphToBack);
		score.drawScore(graphToBack, p1, p2);
		


		//see if ball hits left wall or right wall
		//walls 3 and 4 are top and bottom respectively
		for(int i=2; i<4; i++) {
			walls[i].draw(graphToBack);
			if(ball.didCollideTop(walls[i]) || ball.didCollideBottom(walls[i])) {
				ball.setYSpeed(-ball.getYSpeed());
				ball.randomColor();
			}
		}
		//walls 1 and 2 are left and right respectively
		for(int i=0; i<2; i++) {
			walls[i].draw(graphToBack);
			if(ball.didCollideLeft(walls[i])) {
//				ball.setXSpeed(-ball.getXSpeed());
//				ball.randomColor();
				score.draw(graphToBack);
				score.drawScore(graphToBack, p1, p2++);
				ball.draw(graphToBack, Color.white);
				ball = new SpeedUpBall(387, 235, 10, 10, 1, 1);
				ball.setXSpeed(ball.getXSpeed());
				ball.setYSpeed(ball.getYSpeed());
				ball.moveAndDraw(graphToBack);

			}
			else if(ball.didCollideRight(walls[i])) {
//				ball.setXSpeed(-ball.getXSpeed());
//				ball.randomColor();
				score.draw(graphToBack);
				score.drawScore(graphToBack, p1++, p2);
				ball.draw(graphToBack, Color.white);
				ball = new SpeedUpBall(387, 235, 10, 10, 1, 1);
				ball.setXSpeed(ball.getXSpeed());
				ball.setYSpeed(ball.getYSpeed());
				ball.moveAndDraw(graphToBack);
			}
		}
		
		//see if the ball hits the left paddle
		if (ball.didCollideLeft(leftPaddle) || ball.didCollideRight(leftPaddle) || ball.didCollideLeft(rightPaddle) || ball.didCollideRight(rightPaddle)) {
			ball.setXSpeed(-ball.getXSpeed());
			ball.randomColor();
		}
		else if (ball.didCollideTop(leftPaddle) || ball.didCollideBottom(leftPaddle) || ball.didCollideTop(rightPaddle) || ball.didCollideBottom(rightPaddle)) {
			ball.setYSpeed(-ball.getYSpeed());
			ball.randomColor();
		}
		
		//paddle boundary
		if(!(leftPaddle.getY()>=10)){
			leftPaddle.setY(10);
		}
		else if(!(leftPaddle.getY()+leftPaddle.getHeight()<=470)) {
			leftPaddle.setY(470-leftPaddle.getHeight());
		}
		if(!(rightPaddle.getY()>=10)){
			rightPaddle.setY(10);
		}
		else if(!(rightPaddle.getY()+rightPaddle.getHeight()<=470)) {
			rightPaddle.setY(470-rightPaddle.getHeight());
		}
	
		
		//see if the paddles need to be moved
		if(keys[0] == true)
		{
			//move left paddle up and draw it on the window
			leftPaddle.moveUpAndDraw(graphToBack);
			leftPaddle.draw(graphToBack);
		}
		if(keys[1] == true)
		{
			//move left paddle down and draw it on the window
			leftPaddle.moveDownAndDraw(graphToBack);
			leftPaddle.draw(graphToBack);
		}
		if(keys[2] == true)
		{
			rightPaddle.moveUpAndDraw(graphToBack);
			rightPaddle.draw(graphToBack);
		}
		if(keys[3] == true)
		{
			rightPaddle.moveDownAndDraw(graphToBack);
			rightPaddle.draw(graphToBack);
		}


		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'Z' : keys[1]=true; break;
			case 'I' : keys[2]=true; break;
			case 'M' : keys[3]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=false; break;
			case 'Z' : keys[1]=false; break;
			case 'I' : keys[2]=false; break;
			case 'M' : keys[3]=false; break;
		}
	}

	public void keyTyped(KeyEvent e){}
	
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(8);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}	
}