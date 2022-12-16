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

public class Bullets
{
	private List<Ammo> ammo;
	private int time;

	public Bullets()
	{
		ammo = new ArrayList<Ammo>();
	}

	public void add(Ammo al)
	{
		ammo.add(al);
	}

	//post - draw each Ammo
	public void drawEmAll( Graphics window )
	{
		if(ammo.size()>0) {
			for(Ammo x : ammo) {
				x.draw(window);
			}
		}
	}

	public void moveEmAll()
	{
		if(ammo.size()>0) {
			for(Ammo x : ammo) {
				x.move("UP");
			}
		}
	}
	
	public void moveAliAll() {
		if(ammo.size()>0) {
			for(Ammo x : ammo) {
				x.move("DOWN");
			}
		}
	}

	public void cleanEmUp()
	{
		if(ammo.size()>0) {
			for(int i=0; i<ammo.size(); i++) {
				if(ammo.get(i).getY()<0) {
					ammo.remove(i);
				}
			}
		}
	}

	public List<Ammo> getList()
	{
		return ammo;
	}

	public String toString()
	{
		return "";
	}
}
