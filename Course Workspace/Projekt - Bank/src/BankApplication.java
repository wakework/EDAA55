import java.util.ArrayList;
import java.util.Scanner;
 
public class BankApplication {
 
    public static void main(String[] args) {
        Bank bank = new Bank();
       
        System.out.println(
                "Hej, och välkommen till ✨✨ Banken ✨✨. Välj ett alternativ från menyn nedan genom att mata in alternativets siffra.");
 
        while (true) {
            runApplication(bank);
        }
    }

    public static void printMenu() {
        delay(2000);
 
        System.out.println("\n" + "----- MENY -------");
 
        System.out.println("1. Hitta konton för en viss kontoinnehavare" + "\n"
                + "2. Sök kontoinnehavare på (del av) namn" + "\n" + "3. Sätt in pengar" + "\n" + "4. Ta ut pengar"
                + "\n" + "5. Överföring mellan konton" + "\n" + "6. Skapa nytt konto" + "\n" + "7. Ta bort konto" + "\n"
                + "8. Skriv ut bankens alla konton" + "\n" + "9. Avsluta");
    }
 
    public static void runApplication(Bank bank) {
        Scanner scan = new Scanner(System.in);
        int accNbr;
        double amount;
        int option;
        // Skriv ut menyn
        printMenu();
        option = scan.nextInt();
        scan.nextLine();
        switch (option) {
        case 1: // Hitta konton för en viss kontoinnehavare
            System.out.println("Mata in kontoinnehavarens personnummer: ");
            printAccList(bank.findAccountsForHolder(scan.nextLong()));
           
 
            break;
        case 2:// Sök kontoinnehavare på (del av) namn
            System.out.println("Mata in sökning på del av namn: ");
            printCList(bank.findByPartofName(scan.nextLine()));
            //scan.nextLine();
            break;
        case 3: // Sätt in pengar
 
            // Välj konto
            System.out.print("Kontonummer: ");
            accNbr = scan.nextInt();
            // Välj summa
            System.out.print("Belopp: ");
            amount = scan.nextDouble();
            // Sätt in
            if (bank.findByNumber(accNbr) != null) {
                bank.findByNumber(accNbr).deposit(amount);
                System.out.println("Konto: " + accNbr + " (" + bank.findByNumber(accNbr).getHolder().toString() + "): "
                        + bank.findByNumber(accNbr).getAmount());
            } else {
                System.out.println("Kontot saknas.");
            }
 
            break;
        case 4: // Ta ut pengar
 
            // Välj konto
            System.out.print("Från kontonummer: ");
            accNbr = scan.nextInt();
            // Välj summa
            System.out.print("Belopp: ");
            amount = scan.nextDouble();
            // Ta ut pengar
            if (bank.findByNumber(accNbr) != null) {
                if (bank.findByNumber(accNbr).getAmount() < amount) {
                    System.out.println("Uttaget misslyckades. Du har för lite pengar!");
                } else {
                    bank.findByNumber(accNbr).withdraw(amount);
                    System.out.println("Konto: " + accNbr + " (" + bank.findByNumber(accNbr).getHolder().toString()
                            + "): " + bank.findByNumber(accNbr).getAmount());
                }
            } else {
                System.out.println("Kontot saknas.");
            }
            break;
        case 5: // Överföring mellan konton
           
            System.out.print("Från kontonummer: ");
            int fromAccNbr = scan.nextInt();
            System.out.print("Till kontonummer: ");
            int toAccNbr = scan.nextInt();
            System.out.print("Belopp: ");
            amount = scan.nextDouble();
 
            if (bank.findByNumber(fromAccNbr) != null && bank.findByNumber(toAccNbr) != null) {
                if (bank.findByNumber(fromAccNbr).getAmount() < bank.findByNumber(toAccNbr).getAmount()) {
                    System.out.println("Transaktionen misslyckades. Kontot har för lite pengar!");
                } else {
                    bank.findByNumber(fromAccNbr).withdraw(amount);
                    bank.findByNumber(toAccNbr).deposit(amount);
                    System.out.println(
                            "Konto: " + fromAccNbr + " (" + bank.findByNumber(fromAccNbr).getHolder().toString() + "): "
                                    + bank.findByNumber(fromAccNbr).getAmount());
                    System.out.println("Konto: " + toAccNbr + " (" + bank.findByNumber(toAccNbr).getHolder().toString()
                            + "): " + bank.findByNumber(toAccNbr).getAmount());
                }
            } else {
                System.out.println("Något av kontona saknas.");
            }
 
            break;
        case 6: // Skapa nytt konto
           
            //String name = "";
            //long id = 0;
 
            System.out.print("Mata in kontoinnehavarens namn: ");
       
            //while (!scan.hasNext()) {
            String name = scan.nextLine();         
            //scan.nextLine();
            //}
 
            // ej mata in om personen redan finns??
            System.out.print("Mata in kontoinnehavarens personnummer: ");
            long id = scan.nextLong();
            accNbr = bank.addAccount(name, id);
            System.out.println("Kontots unika kontonummer: " + accNbr);
 
            break;
        case 7:
            // Ta bort konto
            System.out.print("Kontonummer: ");
            accNbr = scan.nextInt();
            if (!bank.removeAccount(accNbr)) {
                System.out.println("Felaktigt kontonummer!");
            }
 
            break;
        case 8:
            // Skriv ut bankens alla konton
            ArrayList<BankAccount> sortedAccounts = new ArrayList<BankAccount>();
            sortedAccounts = bank.getAllAccounts();
 
            System.out.println("Alla konton: ");
            printAccList(sortedAccounts);
//          for (BankAccount acc : sortedAccounts) {
//              System.out.println(acc.toString()); //Obs! vilka toString ska vi använda egentligen?
//          }
            break;
        case 9:
            // Avsluta
            System.out.println("Du avslutar ditt besök nu. Välkommen tillbaka nästa gång till ✨✨ Banken ✨✨.");
            System.exit(0);
            break;
 
        default:
            System.out.println("Felaktig inmatning. Vänligen mata in ett alternativ mellan 1 till 9.");
 
        }
 
    }
 
    private static void printAccList(ArrayList<BankAccount> accounts) {
        for (BankAccount acc : accounts) {
            System.out.println(acc.toString()); // Obs! vilka toString ska vi använda egentligen?
        }
    }
 
    private static void printCList(ArrayList<Customer> costumer) {
        for (Customer c : costumer) {
            System.out.println(c.toString()); // Obs! vilka toString ska vi använda egentligen?
        }
    }
 
    private static void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}