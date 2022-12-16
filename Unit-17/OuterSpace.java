//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
package starFighterFinal;

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
import java.util.ArrayList;

public class OuterSpace extends Canvas implements KeyListener, Runnable
{
	private Ship ship;
	private Alien alienOne;
	private Alien alienTwo;
	private Alien alienThr;
	private Alien alienFou;
	private Alien alienFiv;
	private Ammo ammo;
	private Ammo alienAmmo;
	private int time;
	private int time2;
	private AlienHorde horde;
	private Bullets shots;
	private Bullets alienShots;
	private int endCond;
	private int endTime;

	private boolean[] keys;
	private BufferedImage back;
	
	protected static int score;

	public OuterSpace()
	{
		setBackground(Color.black);

		keys = new boolean[5];

		//instantiate other instance variables
		//Ship, Alien
		ship = new Ship(350, 400, 100, 100, 5);
		alienOne = new Alien(0, 50, 20, 20, 1);
		alienTwo = new Alien(50, 50, 20, 20, 1);
		alienThr = new Alien(100, 50, 20, 20, 1);
		alienFou = new Alien(150, 50, 20, 20, 1);
		alienFiv = new Alien(200, 50, 20, 20, 1);
		horde = new AlienHorde(5);
		horde.add(alienOne);
		horde.add(alienTwo);
		horde.add(alienThr);
		horde.add(alienFou);
		horde.add(alienFiv);
		
		shots = new Bullets();
		alienShots = new Bullets();
		
		ammo = new Ammo(ship.getX()+ship.getWidth()/2-5, ship.getY()-5, 5);
		for(int i=0; i<horde.getAliens(); i++) {
			alienShots.add(new Ammo(horde.getAlList().get(i).getX()+horde.getAlList().get(i).getWidth()/2-5, horde.getAlList().get(i).getY()+5, 1));
		}
		score = 0;
		endCond = horde.getAliens();
		this.addKeyListener(this);
		new Thread(this).start();
		
		setVisible(true);
	}

   public void update(Graphics window)
   {
	   paint(window);
   }

	public void paint( Graphics window )
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

		graphToBack.setColor(Color.BLUE);
		graphToBack.drawString("StarFighterFinal ", 25, 50 );
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0,0,800,600);

		if(keys[0] == true)
		{
			ship.move("LEFT");
		}
		if(keys[1] == true)
		{
			ship.move("RIGHT");
		}
//		if(keys[2] == true) {
//			ship.move("UP");Z
//		}
//		if(keys[3] == true) {
//			ship.move("DOWN");
//		}
		time++;
		if(keys[4] == true) {
			//fire gun
			if(time%11==0)
			shots.add(new starFighterFinal.Ammo(ship.getX()+ship.getWidth()/2-5, ship.getY()-5, 5));
		}
		if(time>11)time = 0;
		
		time2++;
		if(time2%151==0)
		for(int i=0; i<horde.getAliens(); i++) {
			alienShots.add(new Ammo(horde.getAlList().get(i).getX()+horde.getAlList().get(i).getWidth()/2-5, horde.getAlList().get(i).getY()+5, 1));
		}
		if(time2>151)time2 = 0;

		//add in collision detection to see if Bullets hit the Aliens and if Bullets hit the Ship
		
		if(ship.getX()<=0) {
			ship.setX(0);
		}
		if(ship.getX()+ship.getWidth()>=800) {
			ship.setX(800-ship.getWidth());
		}
		if(ship.getY()<=0) {
			ship.setY(0);
		}
		if(ship.getY()+ship.getHeight()>=600) {
			ship.setY(600-ship.getHeight());
		}
		
		for(int i=0; i<horde.getAliens(); i++) {
			if(alienShots.getList().get(i).getY()>=ship.getY() && (alienShots.getList().get(i).getX()>=ship.getX() && alienShots.getList().get(i).getX()<=ship.getX()+ship.getWidth())) {
				Graphics graphToBack2 = back.createGraphics();
				graphToBack2.setColor(Color.WHITE);
				graphToBack2.fillRect(0,0,800,600);
				graphToBack2.setColor(Color.ORANGE);
				graphToBack2.drawString("YOU LOSE", 350, 300);
				graphToBack2.drawString("Score :: "+score, 350, 320);
				twoDGraph.drawImage(back, null, 0, 0);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.exit(0);
			}
		}
		if(score==endCond) {
			endTime++;
			if(endTime==200) {
				Graphics graphToBack3 = back.createGraphics();
				graphToBack3.setColor(Color.WHITE);
				graphToBack3.fillRect(0,0,800,600);
				graphToBack3.setColor(Color.ORANGE);
				graphToBack3.drawString("YOU WIN", 350, 300);
				graphToBack3.drawString("Score :: "+score, 350, 320);
				twoDGraph.drawImage(back, null, 0, 0);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.exit(0);
			}
		}
		
		
		
		ship.draw(graphToBack);
		horde.removeDeadOnes(shots.getList());
		horde.moveEmAll();
		horde.drawEmAll(graphToBack);
		shots.moveEmAll();
		shots.drawEmAll(graphToBack);
		alienShots.moveAliAll();
		alienShots.drawEmAll(graphToBack);
		drawScore(graphToBack);
		
		twoDGraph.drawImage(back, null, 0, 0);
	}
	
	protected static int getScore() {
		return score;
	}
	protected static void setScore(int sc) {
		score = sc;
	}
	protected void drawScore(Graphics window) {
		window.setColor(Color.ORANGE);
		window.drawString("Score :: "+score, 725, 10);
	}


	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A)
		{
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D)
		{
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = true;
		}
		repaint();
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D)
		{
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = false;
		}
		repaint();
	}

	public void keyTyped(KeyEvent e)
	{
      //no code needed here
	}

   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(5);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
}

