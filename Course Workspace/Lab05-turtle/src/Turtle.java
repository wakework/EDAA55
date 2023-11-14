import se.lth.cs.pt.window.SimpleWindow;

public class Turtle {
	private boolean pen;
	private double x;
	private double y;
	private double angle;
	private SimpleWindow w;

	public Turtle (SimpleWindow w, int x, int y) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.pen = false;
		this.angle = (Math.PI / 2);

	}

	public void penDown() {
		pen = true;

	}

	public void penUp() {
		pen = false;
	}

	public void forward(int n) {

		w.moveTo((int) Math.round(x), (int) Math.round(y));
		x = x + (n * Math.cos(angle));
		y = y - (n * Math.sin(angle));

		if (pen == true) {
			w.lineTo((int) Math.round(x), (int) Math.round(y));
			
		}
	}

	public void left(int beta) {
		angle = (angle + (beta * (Math.PI / 180)));
	}

	public void jumpTo(int newX, int newY) {
		x = newX;
		y = newY;
		w.moveTo((int) Math.round(x), (int) Math.round(y));
	}

	public void turnNorth() {
		angle = (Math.PI / 2);
	}

	public int getX() {
		return (int) Math.round(x);
	}

	public int getY() {
		return (int) Math.round(y);
	}

	public int getDirection() {
		return (int) Math.toDegrees(angle);
	}
}
