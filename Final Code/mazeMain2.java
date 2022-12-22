package turtleMaze;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class mazeMain2 extends Canvas implements KeyListener, Runnable {
	private ArrayList<turtle> turts;
	private mazeMaker mazeInit;
	private int[][] maze;
	private BufferedImage back;
	private int[] turtPos;
	private int[] exitPos;
	private boolean[] keys;
	private int time;
	public mazeMain2(int howManyTurts, int height, int width) {
		keys = new boolean[1];
		turts = new ArrayList<turtle>();
		turtle turt1 = new turtle(17, 17, 10, 10);
		turts.add(turt1);
		mazeInit = new mazeMaker(10,10);
		mazeInit.makeCorrectPath();
		System.out.println(Arrays.deepToString(mazeInit.getMazeR()));
		maze = mazeInit.getMazeR();
		turtPos = new int[] {1,1};
		for(int j=1; j<maze[0].length; j++) {
			if(maze[maze.length-2][j]==2) {
				exitPos = new int[]{maze.length-2, j};
				break;
			}
		}
		time=0;
		setBackground(Color.white);
		this.addKeyListener(this);
		new Thread(this).start();
		setVisible(true);
	}
	public void trtFndExt(int r, int c, Graphics graphToBack) {
		if(r < maze.length && r >= 0 && c < maze[0].length && c >= 0 && maze[r][c]>=1 )
		{
//			turts.get(0).draw(graphToBack);
			if(turtPos[0]==exitPos[0] && turtPos[1]==exitPos[1]) {
				maze[r][c]=9;
				return;
			}
			else {
				if(maze[r][c]==1 || maze[r][c]==2) {
					turtPos = new int[] {r, c};
					int save = maze[r][c];
					turts.get(0).setX(17*turtPos[0]+2);
					turts.get(0).setY(17*turtPos[1]+2);
					turts.get(0).draw(graphToBack);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("heredded");
					System.out.println(getMaze());
					maze[r][c] = 9;
					trtFndExt(r + 1, c, graphToBack);
					trtFndExt(r - 1, c, graphToBack);
					trtFndExt(r, c + 1, graphToBack);
					trtFndExt(r, c - 1, graphToBack);
					maze[r][c]=save;
				}
			}
		}
	}
	
//	public void findPath
	
	public void update(Graphics window){
	    paint(window);
	}
	
	public void paint(Graphics window){
	    Graphics2D twoDGraph = (Graphics2D)window;

		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		Graphics graphToBack = back.createGraphics();

		graphToBack.setColor(Color.BLUE);
		graphToBack.drawString("Turtle Maze", 25, 50 );
		graphToBack.setColor(Color.white);
		graphToBack.fillRect(0,0, 800, 600);
		graphToBack.setColor(Color.black);
		graphToBack.fillRect(10, 10, 20*maze[0].length+4, 20*maze.length+4);
		graphToBack.setColor(Color.white);
		graphToBack.fillRect(12, 12, 20*maze[0].length, 20*maze.length);
		graphToBack.setColor(Color.black);
		int a=32;
		for(int i=0; i<maze[0].length-2; i++){
		    graphToBack.fillRect(a, 12, 2, 20*maze.length);
		    a+=22;
		}
		a=32;
		for(int i=0; i<maze.length-2; i++){
		    graphToBack.fillRect(12, a, 20*maze[0].length, 2);
		    a+=22;
		}
		
		if(keys[0]==true && time==0) {
			time++;
			trtFndExt(turtPos[0], turtPos[1], graphToBack);
			System.out.println("::here"); 
		}
		if(keys[0]==true && time==5)System.out.println(mazeInit.getMaze());
		
		
		turts.get(0).draw(graphToBack);
		twoDGraph.drawImage(back, null, 0, 0);
	}
	
	public String getMaze() {
		String opt="";
		for(int[] red : maze) {
			for(int blue : red)
				opt+=blue+" ";
			opt+="\n";
		}
		return opt;
	}
	@Override
	public void run() {
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
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[0] = true;
		}
		repaint();
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[0] = false;
		}
		repaint();
	}
	public void keyTyped(KeyEvent e)
	{
      //no code needed here
	}
}

