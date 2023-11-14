import java.util.Random;
 
public class Customer {
    private String name;
    private long idNbr;
    private int customerNbr;
   
    /**
     * Skapar en kund (kontoinnehavare) med namnet ’name’ och id-nummer ’idNr’.
     * Kunden tilldelas också ett unikt kundnummer.
     */
    public Customer(String name, long idNr) {
        this.name = name;
        this.idNbr = idNr;
        Random rand = new Random();
        customerNbr = rand.nextInt(Integer.MAX_VALUE);
    }
 
    /** Tar reda på kundens namn. */
    public String getName() {
        return name;
    }
 
    /** Tar reda på kundens personnummer. */
    public long getIdNr() {
 
        return idNbr;
    }
 
    /** Tar reda på kundens kundnummer. */
    public int getCustomerNr() {
 
        return customerNbr;
    }
 
    /** Returnerar en strrängbeskrivning av kunden. */
    public String toString() {
 
        return "Namn: " + name + ", Personnummer: " + idNbr + ", Kundnummer: " + customerNbr ;
    }
 
}