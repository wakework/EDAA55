import se.lth.cs.pt.window.SimpleWindow;
import se.lth.cs.pt.square.Square;

public class Labb2Animated {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "DrawSquare");
		Square sq = new Square(250, 250, 100);

		sq.draw(w);

		while (true) {
			int oldX = sq.getX();
			int oldY = sq.getY();

			w.waitForMouseClick();
			// sq.erase(w);

			int x = w.getMouseX();
			int y = w.getMouseY();

			int xDist = x - oldX;
			int yDist = y - oldY;

			// sq.move(xDist, yDist);
			sq.draw(w);

			for (int i = 0; i < 9; i++) {
				// sq.erase(w);
				sq.move(xDist / 10, yDist / 10);
				sq.draw(w);
				SimpleWindow.delay(100);

			}

		}

	}

}