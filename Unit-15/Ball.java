//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block
{
	private int xSpeed;
	private int ySpeed;

	public Ball()
	{
		super(200,200);
		xSpeed = 3;
		ySpeed = 1;
	}

	//add the other Ball constructors
	public Ball(int x,int y) {
		super(x, y);
	}
	public Ball(int x, int y, int wid, int ht) {
		super(x, y, wid, ht);
	}
	public Ball(int x, int y, int wid, int ht, int xSpd, int ySpd) {
		super(x, y, wid, ht);
		setXSpeed(xSpd);
		setYSpeed(ySpd);
	}
	public Ball(int x, int y, int wid, int ht, Color color, int xSpd, int ySpd) {
		super(x, y, wid, ht, color);
		setXSpeed(xSpd);
		setYSpeed(ySpd);
	}
	
	
   //add the set methods
   public void setXSpeed(int xsp) {
	   xSpeed = xsp;
   }
   public void setYSpeed(int ysp) {
	   ySpeed = ysp;
   }

   public void moveAndDraw(Graphics window)
   {
   	//draw a white ball at old ball location
//	   draw(window, Color.WHITE);
	   draw(window);
	   window.clearRect(getX(), getY(), getWidth(), getHeight());
      setX(getX()+xSpeed);
		//setY
      setY(getY()+ySpeed);

		//draw the ball at its new location
      draw(window);
   }
   
	public boolean equals(Ball obj)
	{
		if(this.getXSpeed()==obj.getXSpeed() && this.getYSpeed()==obj.getYSpeed())return true;
		return false;
	}   

   //add the get methods
	public int getXSpeed() {
		return xSpeed;
	}
	public int getYSpeed() {
		return ySpeed;
	}
   //add a toString() method
	public String toString() {
		return " :: "+xSpeed+", "+ySpeed;
	}
}