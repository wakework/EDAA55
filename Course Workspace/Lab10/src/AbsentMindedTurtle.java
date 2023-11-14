import java.util.Random;

public class AbsentMindedTurtle extends RaceTurtle{
	private int tanke; // Tankspridheten i procent
	
	public AbsentMindedTurtle (RaceWindow w, int nbr, int tanke) {
		super(w, nbr);
		this.tanke = tanke;
	}
	
	public void raceStep () {
		Random rand = new Random();
		if (rand.nextInt(100) + 1 >= tanke) {
			super.raceStep();
		}
	}
	
	public String toString() {
		String Tanke = Integer.toString(tanke);
		return super.toString() + " - " + "AbsentMindedTurtle" + " (" + Tanke + "% Frånvarande)";
	}
}
