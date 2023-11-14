
public class Texter {
	private String a;
	private String b;
	private String c;

	public Texter() {
		this.a = "";
		this.b = "";
		this.c = "";

	}

	public void fråga1() {
		System.out.println("Fråga 1");
		System.out.println("Vilket av alternativen är Jacobs fullständiga namn?");

		a = "Karl Jacob Benjamin";
		b = "Karl Jacob";
		c = "Lars Karl Jacob";

		System.out.println("1: " + a);
		System.out.println("2: " + b);
		System.out.println("3: " + c);
	}

	public void fråga2() {
		System.out.println("Fråga 2");
		System.out.println("Vilket alternativ är mest rätt angående hur lång Jacob är?");

		a = "175 cm över havet";
		b = "Ca två skitar hög";
		c = "Väldigt lång";

		System.out.println("1: " + a);
		System.out.println("2: " + b);
		System.out.println("3: " + c);
	}

	public void fråga3() {
		System.out.println("Fråga 3");
		System.out.println("Vad tycker Jacob är roligast med LTH?");

		a = "Sittningar";
		b = "Engagera sig";
		c = "Snacka skit om Harry";

		System.out.println("1: " + a);
		System.out.println("2: " + b);
		System.out.println("3: " + c);
	}

	public void fråga4() {
		System.out.println("Fråga 4");
		System.out.println("Vad tycker Jacob är bäst med Stockholm?");

		a = "Den fina dialekt";
		b = "Statuskåthet";
		c = "Att det är långt från Skåne";

		System.out.println("1: " + a);
		System.out.println("2: " + b);
		System.out.println("3: " + c);

	}

	public void fråga5() {
		System.out.println("Fråga 5");
		System.out.println("Vilket är mest skrrt?");

		a = "va";
		b = "När man dansar skitfull på helsingkrona klockan 3 på natten";
		c = "Göra mål i en seriefinal i division 5, glida på knäna, slita av sin tröja och skrika ENKELT";

		System.out.println("1: " + a);
		System.out.println("2: " + b);
		System.out.println("3: " + c);
	}

	public void startSpel() {
		System.out.println("Hej och välkommen till ett quiz om Jacob Persson!");
		System.out.println("Under resans gång kommer ni att samla på er poäng, som sedan kan bytas ut mot ett pris.");
		System.out.println("Skriv in kör för att starta spelet, lycka till!");

	}
}