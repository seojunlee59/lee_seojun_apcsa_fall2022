package turtleMaze;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
public class mazeMaker {
	private int[][] maze;
	private int[] pos;
	private ArrayList<Position> avail;
	public mazeMaker() {
		maze = new int[10+1][10+1];
		pos = new int[]{1,1};
		avail = new ArrayList<Position>();
	}
	public mazeMaker(int size) {
		maze = new int[size+1][size+1];
		pos = new int[]{1,1};
		avail = new ArrayList<Position>();
	}
	public mazeMaker(int width, int height) {
		maze = new int[height+1][width+1];
		pos = new int[]{1,1};
		avail = new ArrayList<Position>();
	}
	public void makeCorrectPath() {
		for(int i=0; i<maze[0].length; i++) {
			maze[0][i] = -5;
			maze[maze.length-1][i] = -5;
		}
		for(int i=0; i<maze.length; i++) {
			maze[i][0] = -5;
			maze[i][maze[0].length-1] = -5;
		}
		maze[pos[0]][pos[1]] = 1;
		boolean bool = true;
		while(bool) {
			if(pos[0]==maze.length-2) {
				bool = false;
				break;
			}
			if(maze[pos[0]][pos[1]+1]==0)avail.add(new Position(pos[0], pos[1]+1));
			if(maze[pos[0]+1][pos[1]]==0)avail.add(new Position(pos[0]+1, pos[1]));
			if(maze[pos[0]][pos[1]-1]==0)avail.add(new Position(pos[0], pos[1]-1));
			int rand = (int)(Math.random()*avail.size());
			int x = avail.get(rand).getX();
			int y = avail.get(rand).getY();
			maze[x][y] = 1;
			pos = new int[] {x, y};
			avail = new ArrayList<Position>();
		}
		maze[pos[0]][pos[1]] = 2;
		int path = 3;
		for(int i=0; i<maze.length; i++) {
			for(int j=0; j<maze[0].length; j++) {
				if(maze[i][j]==1 && i%2==0) {
					if(checkUp(i, j)) makeAltPaths(i-1, j, path);
					if(checkRight(i, j)) makeAltPaths(i, j+1, path);
					if(checkDown(i, j)) makeAltPaths(i+1, j, path);
					if(checkLeft(i, j)) makeAltPaths(i, j-1, path);
					path++;
				}
			}
		}
	}
	private void makeAltPaths(int x, int y, int path) {
		pos = new int[] {x, y};
		boolean bool = true;
		int count = 0;
		while(bool) {
			if(maze[pos[0]][pos[1]+1]==0)avail.add(new Position(pos[0], pos[1]+1));
			if(maze[pos[0]+1][pos[1]]==0)avail.add(new Position(pos[0]+1, pos[1]));
			if(maze[pos[0]][pos[1]-1]==0)avail.add(new Position(pos[0], pos[1]-1));
			if(avail.size()==0) {
				bool = false;
				return;
			}
			int rand = (int)(Math.random()*avail.size());
			int z = avail.get(rand).getX();
			int c = avail.get(rand).getY();
			maze[z][c] = path;
			pos = new int[] {z, c};
			avail = new ArrayList<Position>();
			count++;
		}
	}
	
	private boolean checkUp(int x, int y) {
		return maze[x-1][y]==1;
	}
	private boolean checkRight(int x, int y) {
		return maze[x][y+1]==1;
	}
	private boolean checkDown(int x, int y) {
		return maze[x+1][y]==1;
	}
	private boolean checkLeft(int x, int y) {
		return maze[x][y-1]==1;
	}
	
	public int[][] getMazeR(){
		return this.maze;
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
	public String toString() {
		String opt="";
		for(int[] red : maze) {
			for(int blue : red)
				opt+=blue+" ";
			opt+="\n";
		}
		opt = opt.replaceAll("-5", "");
		return ""+opt;
	}
	public static void main(String[] args) {
		mazeMaker test1 = new mazeMaker();
		test1.makeCorrectPath();
		System.out.println(test1);
	}
}
