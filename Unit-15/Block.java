//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;

	private Color color;

	public Block()
	{
		setPos(0,0);
		setX(0);
		setY(0);
//		Color rawr = new Color(0,0,0);
		setColor(new Color(0,0,0));

	}

	//add other Block constructors - x , y , width, height, color
	public Block(int x, int y, int wt, int ht, Color color)
	{
		setPos(x, y);
		setX(x);
		setY(y);
		setColor(color);
		height = ht;
		width = wt;

	}
	public Block(int x, int y, int wid, int ht)
	{
		setPos(x,y);
		setX(x);
		setY(y);
		setColor(new Color(0,0,0));
		height = ht;
		width = wid;
	}
	public Block(int x, int y)
	{
		setPos(x,y);
		setX(x);
		setY(y);
		setColor(new Color(0,0,0));
		height = y;
		width = x;
	}
	public Block(Color color)
	{
		setPos(0,0);
		setX(0);
		setY(0);
		setColor(color);

	}
   //add the other set methods
	public void setPos(int x, int y) {
		xPos = x;
		yPos = y;
	}

	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub
		xPos = x;
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		yPos = y;
	}

   public void setColor(Color col)
   {
	   color = col;

   }

   public void draw(Graphics window)
   {
   	//uncomment after you write the set and get methods
      window.setColor(color);
      window.fillRect(getX(), getY(), getWidth(), getHeight());
   }

   public void draw(Graphics window, Color col)
   {
		window.setColor(col);
	
	    window.fillRect(getX(), getY(), getWidth(), getHeight());
   }
   
   public void drawScore(Graphics window, int p1, int p2) {
	   
	   window.drawString("player1 :: "+p1+"\n player2 :: "+p2, getX()+10, getY()+10);
   }

   
	public boolean equals(Object obj)
	{
		Block red = (Block)obj;
		if(this.getX()==red.getX() && this.getY()==red.getY() && this.getWidth()==red.getWidth() && this.getHeight()==red.getHeight())return true;
		return false;
	}


	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return xPos;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return yPos;
	}   

   //add the other get methods
   public int getHeight() {
			// TODO Auto-generated method stub
			return height;
		}

	public int getWidth() {
			// TODO Auto-generated method stub
			return width;
		}
	public Color getColor() {
		return color;
	}

   //add a toString() method  - x , y , width, height, color
	public String toString() {
		return " - "+xPos+", "+yPos+", "+", "+width+", "+height+", "+color; 
	}
}