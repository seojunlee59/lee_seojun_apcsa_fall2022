//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
   //instance variables
   private int speed;

   public Paddle()
   {
		super(10,10);
      speed = 5;
   }
   //add the other Paddle constructors
   public Paddle(int x, int y, int sp) {
	   super(x, y);
	   speed = sp;
   }
   public Paddle(int x, int y) {
	   super(x, y);
	   speed = 5;
   }
   public Paddle(int x, int y, int wid, int ht, int sp) {
	   super(x, y, wid, ht);
	   speed = sp;
   }
   public Paddle(int x, int y, int wid, int ht, Color color, int sp) {
	   super(x, y, wid, ht, color);
	   speed = sp;
   }

   public void moveUpAndDraw(Graphics window)
   {
	   window.clearRect(getX(), getY(), getWidth(), getHeight());
	   setY(getY()-speed);
	   draw(window);
   }

   public void moveDownAndDraw(Graphics window)
   {
	   window.clearRect(getX(), getY(), getWidth(), getHeight());
	   setY(getY()+speed);
	   draw(window);
   }

   //add get methods
   public int getSp() {
	   return speed;
   }
   
   //add a toString() method
   public String toString() {
	   return ""+getX()+" "+getY()+" "+getWidth()+" "+getHeight()+" "+"\n"+getColor()+"   "+getSp();
   }
}