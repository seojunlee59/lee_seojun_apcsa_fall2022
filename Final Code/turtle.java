package turtleMaze;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Canvas;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.imageio.ImageIO;
public class turtle extends MovingThing{
	private Image image;
	private int speed;
	public turtle(int x, int y, int width, int height){
		super(x, y, width, height);
		speed = 1;
		try
		{
			URL url = getClass().getResource("/turtleMaze/turt.jpg");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			//feel free to do something here
			System.out.println("FAIL");
		}
	}
	
	public void setSpeed(int s)
	{
	   //add more code
		speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void move(String direction)
	{
		//add code here
		switch(direction) {
		   case "LEFT": setX(getX()-speed);break;
		   case "RIGHT": setX(getX()+speed);break;
		   case "UP": setY(getY()-speed);break;
		   case "DOWN": setY(getY()+speed);break;
		   }
	}

	public void draw( Graphics window )
	{
   	window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}
	
	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
