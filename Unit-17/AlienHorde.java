//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
package starFighterFinal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class AlienHorde
{
	private List<Alien> aliens;
	private int time;

	public AlienHorde(int size)
	{
		aliens = new ArrayList<Alien>(size);
	}

	public void add(Alien al)
	{
		aliens.add(al);
	}
	
	public int getAliens() {
		return aliens.size();
	}
	
	public List<Alien> getAlList() {
		return aliens;
	}

	public void drawEmAll( Graphics window )
	{
		if(aliens.size() >0) {
			for(Alien x : aliens) {
				x.draw(window);
			}
		}
	}

	public void moveEmAll()
	{
		time++;
		if(aliens.size() > 0) {
			for(Alien x : aliens) {
				if(time<=800)x.move("RIGHT");
				if(time>800 && time<=830)x.move("DOWN");
				if(time>830 && time<=1630)x.move("LEFT");
				if(time>1630 && time<=1660)x.move("DOWN");
				if(time>1660)time=0;
			}
		}
	}

	public void removeDeadOnes(List<Ammo> shots)
	{
		for(Alien x : aliens) {
			for(Ammo y : shots) {
				if(((y.getY()<=x.getY()+x.getHeight() && y.getY()>=x.getY()) 
						&& (y.getX()>=x.getX() && y.getX()<=x.getX()+x.getWidth()))){
					aliens.remove(x);
					shots.remove(y);
					OuterSpace.setScore(OuterSpace.getScore()+1);
				}
			}
		}
	}

	public String toString()
	{
		return "";
	}
}
