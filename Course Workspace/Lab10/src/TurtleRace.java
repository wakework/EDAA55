import java.util.ArrayList;
import java.util.Random;

public class TurtleRace {
	public static void main(String[] args) {
		RaceWindow w = new RaceWindow();
		ArrayList<RaceTurtle> race = new ArrayList<RaceTurtle>();
		Random rand = new Random();
		
		for (int i = 0; i < 8; i++) {
			int a = rand.nextInt(3);
			
			if (a == 0) {
				race.add(new MoleTurtle(w, i + 1));
			} else if (a == 1) {
				race.add(new AbsentMindedTurtle(w, i + 1, rand.nextInt(100) + 1));
			} else {
				race.add(new DizzyTurtle(w, i + 1, rand.nextInt(5) + 1));
			}
		}
		
		for (int i = 0; i < race.size(); i++) {
			System.out.println(race.get(i).toString());
		}

		ArrayList<RaceTurtle> podium = new ArrayList<RaceTurtle>();

		while (race.isEmpty() == false) {
			for (int i = 0; i < race.size(); i++) {
				if (race.get(i).getX() >= RaceWindow.X_END_POS) { // De första indexen börjar slå "tärningen"
					podium.add(race.get(i));
					race.remove(i--);
				} else {
					race.get(i).raceStep();
					RaceWindow.delay(5);
				}
			}
		}

		System.out.println("På plats 1: " + podium.get(0).toString());
		System.out.println("På plats 2: " + podium.get(1).toString());
		System.out.println("På plats 3: " + podium.get(2).toString());
	}

}