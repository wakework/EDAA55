import java.util.Random;

public class RaceTurtle extends Turtle {
	private int nbr;
	/**
	* Skapar en sköldpadda som ska springa i fönstret w och som har start-
	* nummer nbr. Sköldpaddan startar med pennan nere och nosen vänd åt höger.
	*/
	public RaceTurtle(RaceWindow w, int nbr) {
		super(w, w.getStartXPos(nbr), w.getStartYPos(nbr));
		this.nbr = nbr;
		penDown();
		left(270);
	}
	
	
	/**
	* Låter sköldpaddan gå framåt ett steg. Stegets längd ges av ett
	* slumptal (heltal) mellan 1 och 6.
	*/
	public void raceStep() {
		Random rand = new Random(); 
		forward(rand.nextInt(6) + 1);
	}
	/**
	* Returnerar en läsbar representation av denna RaceTurtle,
	* på formen "Nummer x" där x är sköldpaddans startnummer.
	*/
	public String toString() {
		String nummer = Integer.toString(nbr);
		return "Nummer " + nummer;
	}

}
