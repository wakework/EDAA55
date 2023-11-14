package rekrytering;

import java.io.File;
import java.io.FileNotFoundException;
// import java.util.Arrays;
import java.util.Scanner;

public class FileReader {

	/**
	 * Returnerar max nbrOfRows rader från filen som en vektor av Applicant-objekt.
	 * Läser i filen tills det inte finns fler rader eller tills man läst nbrOfRows
	 * rader (det som inträffar först). 
	 * Returnerar null om filen inte finns.
	 */
	public static Applicant[] readFromFile(String fileName, int nbrOfRows) {
		Scanner scan;
		try {
			scan = new Scanner(new File(fileName), "utf-8");
		} catch (FileNotFoundException e) {
			System.err.println("File not found" + fileName);
			e.printStackTrace();
			return null;
		}
		//Här kan du använda Scannern för att läsa från filen fileName.
		//Varje rad motsvarar en Applicant. Kontrollera vad Applicants konstruktor kräver
		//Alla Applicant-objekt (max nbrOfRows stycken) ska lagras i en Applicant-vektor och returneras på slutet
		
		int i = 0;
		Applicant [] a = new Applicant[nbrOfRows];
		
		while (scan.hasNextLine() && i < nbrOfRows) {
			
			String string = scan.nextLine();
			String [] parts = string.split(" ");
			
			if (parts.length < 3) {
				break;
			}
			
			String part1 = parts[0] + " " + parts[1];
			String part2 = parts[2];
			
			Applicant b = new Applicant(part1, part2);
			a[i] = b;
			i++;
		}
		
		return a;
	}
}
