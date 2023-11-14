import java.util.Random;

public class DizzyTurtle extends RaceTurtle {
	private int yrsel;

	public DizzyTurtle(RaceWindow w, int nbr, int yrsel) {
		super(w, nbr);
		this.yrsel = yrsel;
	}

	public void raceStep() {
		Random rand = new Random();
		if (rand.nextBoolean()) {
			if (rand.nextBoolean()) {
				left((yrsel));
			} else {
				left((-yrsel));
			}
		}

		super.raceStep();
		// turnNorth();
		// left(270);
	}

	public String toString() {
		String Yrsel = Integer.toString(yrsel);
		return super.toString() + " - " + "DizzyTurtle" + " (Yrsel: " + Yrsel + ")";
	}
}
