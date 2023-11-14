package memory;

import java.util.Random;

public class MemoryBoard {
	private MemoryCardImage[][] board;
	private boolean[][] b;
	int done = 0;

	/**
	 * Skapar ett memorybräde med size * size kort. backFileName är filnamnet för
	 * filen med baksidesbilden. Vektorn frontFileNames innehåller filnamnen för
	 * frontbilderna.
	 */
	public MemoryBoard(int size, String backFileName, String[] frontFileNames) {
		board = new MemoryCardImage[size][size];
		b = new boolean[size][size];
		createCards(backFileName, frontFileNames);

		for (int i = 0; i < board.length; i++) { // Sätter alla objekt i b-matrisen till false
			for (int k = 0; k < board.length; k++) {
				b[i][k] = false;
			}
		}
	}

	/*
	 * Skapar size * size / 2 st memorykortbilder. Placerar ut varje kort på två
	 * slumpmässiga ställen på spelplanen.
	 */
	private void createCards(String backFileName, String[] frontFileNames) {
		Random rand = new Random();

		for (int i = 0; i < frontFileNames.length; i++) {
			MemoryCardImage card = new MemoryCardImage(frontFileNames[i], backFileName);
			int counter = 0;

			while (counter < 2) {
				int r = rand.nextInt(board.length);
				int c = rand.nextInt(board.length);

				if (board[r][c] == null) { // "Skapar" memoryt, ordningen
					board[r][c] = card;
					counter++;
				}
			}
		}
	}

	/** Tar reda på brädets storlek. */
	public int getSize() {
		return board.length;
	}

	/**
	 * Hämtar den tvåsidiga bilden av kortet på rad r, kolonn c. Raderna och
	 * kolonnerna numreras från 0 och uppåt.
	 */
	public MemoryCardImage getCard(int r, int c) {
		return board[r][c];
	}

	/** Vänder kortet på rad r, kolonn c. */
	public void turnCard(int r, int c) {
		if (b[r][c] == false) {
			b[r][c] = true;
		} else {
			b[r][c] = false;
		}
	}

	/** Returnerar true om kortet r, c har framsidan upp. */
	public boolean frontUp(int r, int c) {
		return b[r][c];
	}

	/**
	 * Returnerar true om det är samma kort på rad r1, kolonn c2 som på rad r2,
	 * kolonn c2.
	 */
	public boolean same(int r1, int c1, int r2, int c2) {
		if (board[r1][c1] == board[r2][c2]) {
			return true;
		}
		return false;

	}

	/** Returnerar true om alla kort har framsidan upp. */
	public boolean hasWon() {
		for (int i = 0; i < board.length; i++) {
			for (int k = 0; k < board.length; k++) {
				if (b[i][k] == false) {
					return false;
				}
			}
		}
		return true;
	}
}