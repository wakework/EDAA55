import se.lth.cs.pt.window.SimpleWindow;
import se.lth.cs.pt.maze.Maze;
import java.util.Scanner;

public class MainMazeWalker {
	public static void main(String[] args) {
		int x = 10;
		int y = 10;

		Scanner scan = new Scanner(System.in);
		System.out.println("Skriv in en siffra mellan 1-5 för att välja en Maze");
		int start = scan.nextInt();

		Maze m = new Maze(start);
		SimpleWindow w = new SimpleWindow(600, 600, "MazeWalker");
		Turtle t = new Turtle(w, x, y);

		m.draw(w);
		MazeWalker mw = new MazeWalker(t);
		mw.walk(m);
	}

}
