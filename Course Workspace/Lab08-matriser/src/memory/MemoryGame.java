package memory;

import javax.swing.JOptionPane;

public class MemoryGame {
	public static void main(String[] args) {
		String[] frontFileNames = { "can.jpg", "flopsy_mopsy_cottontail.jpg", "friends.jpg", "mother_ladybird.jpg",
				"mr_mcgregor.jpg", "mrs_rabbit.jpg", "mrs_tittlemouse.jpg", "radishes.jpg" };

		int size = 4;
		MemoryBoard board = new MemoryBoard(size, "back.jpg", frontFileNames);
		MemoryWindow w = new MemoryWindow(board);

		int r1 = 0;
		int c1 = 0;
		int r2 = 0;
		int c2 = 0;
		int attempts = 0;

		w.drawBoard();

		while (board.hasWon() == false) {
			w.waitForMouseClick(); // Spelar första kortet
			r1 = w.getMouseRow();
			c1 = w.getMouseCol();

			while (board.frontUp(r1, c1)) { // Dubbelklick
				w.waitForMouseClick();
				r1 = w.getMouseRow();
				c1 = w.getMouseCol();
			}

			board.turnCard(r1, c1);
			w.drawCard(r1, c1);

			w.waitForMouseClick(); // Spelar andra kortet
			r2 = w.getMouseRow();
			c2 = w.getMouseCol();

			while (board.frontUp(r2, c2)) { // Dubbelklick
				w.waitForMouseClick();
				r2 = w.getMouseRow();
				c2 = w.getMouseCol();
			}

			board.turnCard(r2, c2);
			w.drawCard(r2, c2);

			if (board.same(r1, c1, r2, c2) == false) {
				MemoryWindow.delay(500);
				board.turnCard(r1, c1);
				w.drawCard(r1, c1);
				board.turnCard(r2, c2);
				w.drawCard(r2, c2);
			}

			attempts++;
		}

		JOptionPane.showMessageDialog(null, "Antal försök: " + attempts, "Memory", JOptionPane.INFORMATION_MESSAGE);

	}

}