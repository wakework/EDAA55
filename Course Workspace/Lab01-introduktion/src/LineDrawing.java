import se.lth.cs.pt.window.SimpleWindow;

public class LineDrawing {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(500, 500, "LineDrawing");
		w.moveTo(0, 0);
		
		while (true) {
			w.waitForMouseClick();
			/** Väntar tills användaren har klickat på en musknapp */
			
			int posX = w.getMouseX();
			/** Tar reda på x-koordinaten för musens position vid senaste musklick */
			int posY = w.getMouseY();
			/** Tar reda på y-koordinaten för musens position vid senaste musklick */
			
			w.lineTo(posX, posY);
		}
	}
}
