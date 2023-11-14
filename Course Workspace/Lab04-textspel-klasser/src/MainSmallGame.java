import java.util.Scanner;

public class MainSmallGame {
	// kan endas användas i denna klassen.
	private Scanner scan;
	private int poäng;

	public MainSmallGame() {
		this.scan = new Scanner(System.in);
		// Poängställning
		this.poäng = 0; 

	}

	public void quiz() {
		Texter f = new Texter();

		for (int i = 0; i < 5; i++) {
			// Skanna svar
			scan = new Scanner(System.in);

			// Ny fråga för varje loop
			if (i == 0) {
				// Fråga 1
				f.fråga1();
				int svar = scan.nextInt();

				// Rätt svar
				if (svar == 1) {
					System.out.println("Rätt! Du tilldelas 1 poäng.");
					poäng = poäng + 1;
					avslutaSpel();

				} else {
					System.out.println("Fel, rätt svar var alternativ 1 :(");
					avslutaSpel();
				}

			} else if (i == 1) {
				f.fråga2();
				int svar = scan.nextInt();

				if (svar == 2) {
					System.out.println("Rätt! Du tilldelas 1 poäng.");
					poäng = poäng + 1;
					avslutaSpel();

				} else {
					System.out.println("Fel, rätt svar var alternativ 2 :(");
					avslutaSpel();
				}

			} else if (i == 2) {
				f.fråga3();
				int svar = scan.nextInt();

				if (svar == 3) {
					System.out.println("Rätt! Du tilldelas 1 poäng.");
					poäng = poäng + 1;
					avslutaSpel();

				} else {
					System.out.println("Fel, rätt svar var alternativ 3 :(");
					avslutaSpel();
				}

			} else if (i == 3) {
				f.fråga4();
				int svar = scan.nextInt();

				if (svar == 3) {
					System.out.println("Rätt! Du tilldelas 1 poäng.");
					poäng = poäng + 1;
					avslutaSpel();

				} else {
					System.out.println("Fel, rätt svar var alternativ 3 :(");
					avslutaSpel();
				}

			} else if (i == 4) {
				f.fråga5();
				int svar = scan.nextInt();

				if (svar == 2) {
					System.out.println("Rätt! Du tilldelas 1 poäng.");
					poäng = poäng + 1;
					avslutaSpel();

				} else {
					System.out.println("Fel, rätt svar var alternativ 2 :(");
					avslutaSpel();
				}
			}
		}

	}

	public void avslutaSpel() {
		System.out.println();
		System.out.println("Vill du gå hem med dina hittills ihopsamlade poäng? Tryck in avsluta.");
		System.out.println("För att fortsätta, tryck var som helst");

		String svar2 = scan.next();
		if (svar2.equals("avsluta")) {
			System.out.println();
			System.out.println("Du samlade ihop " + getPoäng() + " poäng!");
			pris();

			System.exit(0);

		}

	}

	public void pris() {
		System.out.println();
		poäng = getPoäng();

		if (poäng == 0) {
			System.out.println("DU SUGER");

		} else if (poäng == 1) {
			System.out.println("Vem är du?");

		} else if (poäng == 5) {
			System.out.println("MIN BÄSTA KOMPIS, du är bäst, välkommen på pyjamasparty");

		} else {
			System.out.println("Du har vunnit en kram <3");
		}

	}

	public int getPoäng() {
		return poäng;
	}
}