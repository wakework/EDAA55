import java.util.ArrayList;
 
public class Bank {
    private ArrayList<BankAccount> accounts;
 
    /** Skapar en ny bank utan konton. */
    public Bank() {
        accounts = new ArrayList<BankAccount>();
    }
 
    /**
     * Öppna ett nytt konto i banken. Om det redan finns en kontoinnehavare med de
     * givna uppgifterna ska inte en ny Customer skapas, utan istället den
     * befintliga användas. Det nya kontonumret returneras.
     */
    public int addAccount(String holderName, long idNr) {
 
        for (BankAccount acc : accounts) {
            if (acc.getHolder().getName().equals(holderName) && findHolder(idNr)!=null) {
                // Personen finns. Skapa konto med befintlig customer.
                BankAccount ba = new BankAccount(findHolder(idNr));
                accounts.add(ba);
                return ba.getAccountNumber();
            }
        }
 
        // Personen hittades inte. Gör nytt konto med ny customer.
        BankAccount ba = new BankAccount(holderName, idNr);
        accounts.add(ba);
        return ba.getAccountNumber();
    }
 
    /**
     * Returnerar den kontoinnehavaren som har det givna id-numret, eller null om
     * ingen sådan finns.
     */
    public Customer findHolder(long idNr) {
        for (BankAccount acc : accounts) {
            if (acc.getHolder().getIdNr() == idNr) {
                return acc.getHolder();
            }
        }
        return null;
    }
 
    /**
     * Tar bort konto med nummer ’number’ från banken. Returnerar true om kontot
     * fanns (och kunde tas bort), annars false.
     */
    public boolean removeAccount(int number) {
        for (int i = 0; i<accounts.size(); i++) {
            if (accounts.get(i).getAccountNumber() == number) {
                accounts.remove(i);
                return true;
            }
        }
        return false;
    }
 
    /**
     * Returnerar en lista innehållande samtliga bankkonton i banken. Listan är
     * sorterad på kontoinnehavarnas namn.
     */
    public ArrayList<BankAccount> getAllAccounts() {
        ArrayList<BankAccount> sortedAccounts = new ArrayList<BankAccount>();
        // Bara sortera listan
 
        for (BankAccount acc : accounts) {
            int pos = 0;
            while (pos < sortedAccounts.size() && sortedAccounts.get(pos).getHolder().getName().compareTo(acc.getHolder().getName()) < 0) {
                pos++;
            }
            sortedAccounts.add(pos, acc);
        }
 
        return sortedAccounts;
    }
 
    /**
     * Söker upp och returnerar bankkontot med kontonummer ’accountNumber’.
     * Returnerar null om inget sådant konto finns.
     */
    public BankAccount findByNumber(int accountNumber) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber() == accountNumber) {
                return acc;
            }
        }
       
        return null;
    }
 
    /**
     * Söker upp alla bankkonton som innehas av kunden med id-nummer ’idNr’. Kontona
     * returneras i en lista. Kunderna antas ha unika id-nummer.
     */
    public ArrayList<BankAccount> findAccountsForHolder(long idNr) {
        ArrayList<BankAccount> holderAccount = new ArrayList<BankAccount> ();
        for (BankAccount acc : accounts) {
            if (acc.getHolder().getIdNr() == idNr) {
                holderAccount.add(acc);
            }
        }
       
        if (holderAccount.size() == 0) {
            System.out.println("Hittade inga bankkonton som innehas av kunden med id-nummer: " + idNr);
        } else {
            System.out.println("Följande konton fanns: ");
        }
        return holderAccount;
    }
 
    /**
     * Söker upp kunder utifrån en sökning på namn eller del av namn. Alla personer
     * vars namn innehåller strängen ’namePart’ inkluderas i resultatet, som
     * returneras som en lista. Samma person kan förekomma flera gånger i
     * resultatet. Sökningen är "case insensitive", det vill säga gör ingen skillnad
     * på stora och små bokstäver.
     */
    public ArrayList<Customer> findByPartofName(String namePart) {
 
        ArrayList<Customer> customers = new ArrayList<Customer> ();
        for (BankAccount acc : accounts) {
            if (acc.getHolder().getName().toLowerCase().contains(namePart.toLowerCase())) {
                customers.add(acc.getHolder());
            }
        }
       
        if (customers.size() == 0) {
            System.out.println("Hittade ingen kontoinnehavare på sökningen: " + namePart);
        } else {
            System.out.println("Följande personer fanns: ");
        }
        return customers;
    }
}