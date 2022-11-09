//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable
{
	private int xSpeed;
	private int ySpeed;

	public Ball()
	{
		super(387,235, 10, 10);
		xSpeed = 1;
		ySpeed = 1;
	}

	//add the other Ball constructors
	public Ball(int x,int y) {
		super(x, y);
	}
	public Ball(int x, int y, int wid, int ht) {
		super(x, y, wid, ht);
		xSpeed = 1;
		ySpeed = 1;
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
	
	public void randomColor()
	   {
	   		int r = (int)(Math.random()*256);		//use Math.random()
	 		int g = (int)(Math.random()*256);
	 		int b = (int)(Math.random()*256);
	 		setColor(new Color(r,g,b));
	   }

	@Override
	public boolean didCollideLeft(Object obj) {
		Block red = (Block)obj;
		if(this.getX()>red.getX() && this.getX()<=red.getX()+red.getWidth() && (this.getY()+this.getHeight()>red.getY() && this.getY()<red.getY()+red.getHeight())) {
			return true;
		}
		return false;
	}

	@Override
	public boolean didCollideRight(Object obj) {
		Block red = (Block)obj;
		if(this.getX()<red.getX() && this.getX()+this.getWidth()>=red.getX() && (this.getY()+this.getHeight()>red.getY() && this.getY()<red.getY()+red.getHeight())) {
			return true;
		}
		return false;
	}

	@Override
	public boolean didCollideTop(Object obj) {
		Block red = (Block)obj;
		if((this.getY()<red.getY()) && (this.getY()+this.getHeight()>=red.getY() && (this.getX()+this.getWidth()>red.getX() && this.getX()<red.getX()+red.getWidth()))) {
			return true;
		}
		return false;
	}

	@Override
	public boolean didCollideBottom(Object obj) {
		Block red = (Block)obj;
		if((this.getY()>red.getY()) && (this.getY()<=red.getY()+red.getHeight() && (this.getX()+getWidth()>red.getX() && this.getX()<red.getX()+red.getWidth()))) {
			return true;
		}
		return false;
	}
}
