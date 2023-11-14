import se.lth.cs.pt.window.SimpleWindow;

public class Graphics {
	// Attribut
	private int width;
	private int blockSize;
	private int height;

	private SimpleWindow w;

	public Graphics(int w, int h, int bS) { // Konstruktor Graphics
		// Tilldelar attributen variabler som användaren kan bestämma
		width = w;
		height = h;
		blockSize = bS;

		this.w = new SimpleWindow((width * blockSize), (height * blockSize), "Digging"); // Skapar ett SimpleWindow
	}

	public void square() { // Skapar en ruta i SimpleWindow
		w.moveTo(10, 10);
		w.lineTo(10, 20);
		w.lineTo(20, 20);
		w.lineTo(20, 10);
		w.lineTo(10, 10);
	}

	public void block(int x, int y, java.awt.Color color) {
		w.setLineColor(color); // Ger linjen färgen

		int left = x * blockSize;
		int right = left + blockSize - 1;
		int top = y * blockSize;
		int bottom = top + blockSize - 1;
		for (int row = top; row <= bottom; row++) {
			w.moveTo(left, row);
			w.lineTo(right, row);
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public char waitForKey() {
		return w.waitForKey();
	}

	public void rectangle(int x, int y, int width, int height, java.awt.Color c) {
		for (int yy = y; yy < y + height; yy++) {
			for (int xx = x; xx < x + width; xx++) {
				block(xx, yy, c); // Ritas ut höjd --> bredd?
			}
		}

	}
}