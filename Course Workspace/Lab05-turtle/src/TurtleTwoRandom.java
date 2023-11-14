import se.lth.cs.pt.window.SimpleWindow;
import java.util.Random;

public class TurtleTwoRandom {

	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "TurtleTwoRandom");
		Turtle t = new Turtle(w, 250, 250);
		Turtle t2 = new Turtle(w, 350, 350);
		Random rand = new Random();

		t.penDown();
		t2.penDown();
		double X = Math.pow((t2.getX() - t.getX()), 2);
		double Y = Math.pow((t2.getY() - t.getY()), 2);
		int d = (int) Math.sqrt(X + Y);
		
		while (d >= 50) {
				t.forward(rand.nextInt(10));
				t.left(rand.nextInt(361) - 180);
				
				t2.forward(rand.nextInt(10));
				t2.left(rand.nextInt(361) - 180);
				
				SimpleWindow.delay(10);
				X = Math.pow((t2.getX() - t.getX()), 2);
				Y = Math.pow((t2.getY() - t.getY()), 2);
				d = (int) Math.sqrt(X + Y);
		}
	}		
}