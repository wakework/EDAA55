import se.lth.cs.pt.maze.Maze;
import se.lth.cs.pt.window.SimpleWindow;

public class MazeWalker {
	private Turtle t;

	public MazeWalker(Turtle t) {
		this.t = t;
	}

	/**
	 * Låter sköldpaddan vandra genom labyrinten maze, från ingången till utgången.
	 */
	public void walk(Maze m) {
		t.jumpTo(m.getXEntry(), m.getYEntry());
		t.penDown();
		
		while (m.atExit(t.getX(), t.getY()) == false) {
			if (m.wallAtLeft(t.getDirection(), t.getX(), t.getY()) == false) {
				t.left(90);
				t.forward(1);
			} else if (m.wallInFront(t.getDirection(), t.getX(), t.getY()) == true) {
				t.left(270);
			} else {
				t.forward(1);
			}
			
			SimpleWindow.delay(1);

		}
	}
}