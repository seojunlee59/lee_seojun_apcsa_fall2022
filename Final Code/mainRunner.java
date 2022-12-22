package turtleMaze;
import javax.swing.JFrame;
import java.awt.Component;
public class mainRunner extends JFrame
{
	protected static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public mainRunner()
	{
		super("Maze Runner");
		setSize(WIDTH,HEIGHT);

		mazeMain2 test1 = new mazeMain2(1, 10, 10);
		((Component)test1).setFocusable(true);

		getContentPane().add(test1);

		setVisible(true);
	}

	public static void main( String args[] )
	{
		mainRunner run = new mainRunner();
	}
}