//(c) A+ Computer Science
//www.apluscompsci.com
//Name - James Lee


public class Skeleton implements Monster
{
	private String nm;
	private int ag;
	
	public Skeleton() {
		setMon("",0);
	}
	public Skeleton(String name, int age) {
		setMon(name, age);
	}
	
	public void setMon(String name, int age) {
		nm = name;
		ag = age;
	}
	@Override
	public int getHowBig() {
		return ag;
	}

	@Override
	public String getName() {
		return nm;
	}

	@Override
	public boolean isBigger(Monster other) {
		if(other.getHowBig()>ag) {
			return false;
		}
		return true;
	}

	@Override
	public boolean isSmaller(Monster other) {
		if(other.getHowBig()>ag) {
			return true;
		}
		return false;
	}

	@Override
	public boolean namesTheSame(Monster other) {
		if(other.getName().equals(nm)) {
			return true;
		}
		return false;
	}

	//add a toString
	public String toString() {
		return ""+nm+" "+ag;
	}
}