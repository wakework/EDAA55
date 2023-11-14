import java.util.Scanner;

public class SmallGame {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		boolean spel = true;

		Texter t = new Texter();
		t.startSpel();

		MainSmallGame m = new MainSmallGame();
		String start = scan.next();

		if (start.equals("kör")) {
			while (spel) {
				m.quiz();

				System.out.println("Du samlade ihop " + m.getPoäng() + " poäng!");
				m.pris();
				return;
			}

		} else if (start.equals("avsluta")) {
			System.out.println("Stick och brinn TÖNT");

		} else {
			System.out.println("Hej då");
		}

	}
}