import java.util.Random;
 
public class BankAccount {
 
    private Customer person;
    private int bankNbr;
    private double balance;
 
    /**
     * Skapar ett nytt bankkonto åt en innehavare med namn ’holderName’ och id
     * ’holderId’. Kontot tilldelas ett unikt kontonummer och innehåller
     * inledningsvis 0 kr.
     */
 
    public BankAccount(String holderName, long holderId) {
        // Ny person med inskickade uppgifter
        person = new Customer(holderName, holderId);
        balance = 0;
 
        // Slumpar fram ett bankkonto. Inte helt säkert.
        Random rand = new Random();
        bankNbr = rand.nextInt(Integer.MAX_VALUE);
    }
 
    /**
     * Skapar ett nytt bankkonto med innehavare ’holder’. Kontot tilldelas ett unikt
     * kontonummer och innehåller inledningsvis 0 kr.
     */
    public BankAccount(Customer holder) {
        person = holder;
        balance = 0;
 
        // Slumpar fram ett bankkonto. Inte helt säkert.
        Random rand = new Random();
        bankNbr = rand.nextInt(Integer.MAX_VALUE);
    }
 
    /** Tar reda på kontots innehavare. */
    public Customer getHolder() {
        return person;
    }
 
    /** Tar reda på det kontonummer som identifierar detta konto. */
    public int getAccountNumber() {
        return bankNbr;
    }
 
    /** Tar reda på hur mycket pengar som finns på kontot. */
    public double getAmount() {
        return balance;
    }
 
    /** Sätter in beloppet ’amount’ på kontot. */
    public void deposit(double amount) {
        balance = balance + amount;
    }
 
    /**
     * Tar ut beloppet ’amount’ från kontot. Om kontot saknar täckning blir saldot
     * negativt.
     */
    public void withdraw(double amount) {
        balance = balance - amount;
    }
 
    /** Returnerar en strängrepresentation av bankkontot. */
    public String toString() {
        return "Namn ägare: " + person.getName() + ", Kontonummer: " + bankNbr + ", Saldo: " + balance;
    }
 
}