import java.util.Random;

public class MoleTurtle extends RaceTurtle {
	
	public MoleTurtle (RaceWindow w, int nbr) {
		super(w, nbr);
	}
	
	public void raceStep () {
		Random rand = new Random();
		if (rand.nextBoolean() == false) {
			penUp();
		} 
		
		super.raceStep();
		penDown();
	}
	
	public String toString() {
		return super.toString() + " - " + "MoleTurtle";
	}


}
