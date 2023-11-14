import java.util.ArrayList;

public class TurtleRace {
	public static void main(String[] args) {
		RaceWindow w = new RaceWindow();
		ArrayList<RaceTurtle> race = new ArrayList<RaceTurtle>();

		for (int i = 1; i < 9; i++) {
			race.add(new RaceTurtle(w, i));
		}

		ArrayList<RaceTurtle> podium = new ArrayList<RaceTurtle>();

		while (race.isEmpty() == false) {
			for (int i = 0; i < race.size(); i++) {
				if (race.get(i).getX() >= RaceWindow.X_END_POS) { // De första indexen börjar slå "tärningen"
					podium.add(race.get(i));
					race.remove(i--);
				} else {
					race.get(i).raceStep();
					RaceWindow.delay(10);
				}
			}
		}

		System.out.println("På plats 1: " + podium.get(0).toString());
		System.out.println("På plats 2: " + podium.get(1).toString());
		System.out.println("På plats 3: " + podium.get(2).toString());
	}

}