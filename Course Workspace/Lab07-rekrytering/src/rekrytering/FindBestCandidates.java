package rekrytering;

import java.util.Arrays;

public class FindBestCandidates {
	private static final double MIN_AVG_GRADE = 4.5;

	public static void main(String[] args) {
		
		Applicant [] applicant = FileReader.readFromFile("applications_x.txt", 231);		
		Applicant [] BS = findBestCandidates(applicant);
		Arrays.sort(BS);
		
		for (int i = 0; i < BS.length; i++) {
			System.out.println(BS[i]);
		}
		// Skicka in Applicant-vektorn (som du fick i föregående steg) till metoden
		// findBestCandidiates (nedan)
		// Spara resultatet i en vektor
		// Printa resultatet från findBestCandidates

	}

	public static Applicant[] findBestCandidates(Applicant[] applicants) {
		// Hitta alla kandidater som har medelbetyg över MIN_AVG_GRADE
		// Lagra alla dessa kandidater i en vektor, returnera vektorn
		// Applicant [] applicant = FileReader.readFromFile("applications_all.txt", 231);
		
		int k = 0;
		int antal = 0;
		
		for(int i = 0; i < applicants.length; i++) {
			if(applicants[i] != null && applicants[i].getAvgGrade() >= MIN_AVG_GRADE) {		
				antal++;
			}	
		}
		Applicant [] AvGrade = new Applicant [antal];
		for(int i = 0; i < applicants.length; i++) {
			if(applicants[i] != null && applicants[i].getAvgGrade() >= MIN_AVG_GRADE) {
				AvGrade[k] = applicants[i];
				k++;
			}
		}
		return AvGrade;
		
	}
}
