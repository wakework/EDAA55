import se.lth.cs.pt.window.SimpleWindow;
import java.util.Random;

public class Turtle1000 {

	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "TurtleDrawRandomFigure");
		Turtle t = new Turtle(w, 300, 300);
		Random rand = new Random();

		t.penDown();
		for (int i = 1; i <= 1000; i++) {
			t.forward(rand.nextInt(10));
			t.left(rand.nextInt(361) - 180);

		}
	}
}