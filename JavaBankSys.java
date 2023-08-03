import java.io.*;
import java.util.*;
import java.lang.*;

public class JavaBankSys implements Runnable {

    public String accName;
    public int balance;
    public int accID;
    public String select;
    public int amount;
    static volatile Object o = new Object();

    @Override
    public void run() {
        String ThreadName = Thread.currentThread().getName();
        System.out.println(ThreadName + " reporting for duty!");
        // Parameters are being send from constructor's help.
        try {
        if (select.equals("2")) {
            System.out.println("---------------\nDeposit activated");
            Deposit(amount);
            System.out.println("! Deposit Successful !");
        } else if (select.equals("3") && !(balance <= 0)) {
            System.out.println("---------------\nWithdraw activated");
            Withdraw(amount);
            System.out.println("! Withdrawal Successful !");
        } else {
            System.out.println("------- Transaction failed, please try again.-------");
        }
        } catch (Exception e) {
            System.out.println("Please enter in the correct format <number>");
        }

    }

    public void CreateAccount(String accName, int balance, int accID) {
        this.accName = accName;
        this.balance = balance;
        this.accID = accID;
    }

    public void Deposit(int amount) {
        synchronized (o) {
            System.out.println(Thread.currentThread().getName() + "\" has Finished its job\nYou've made a deposit");
            balance += amount;
            CheckBalance();
            System.out.println("---------------");
        }
    }

    public void Withdraw(int amount) {
        synchronized (o) {
            System.out.println(Thread.currentThread().getName() + "\" has Finished its job\nYou've made a withdrawal");
            balance -= amount;
            CheckBalance();
            System.out.println("---------------");
        }
    }

    public void CheckBalance() {
        System.out.println("Your current balance : $" + balance);
    }

    public void AccountList() {
        System.out.println("This system will be implement later on");
    }

    public static void WaitUserChoice(Scanner userChoice) {
        System.out.println("Welcome to the Simple Banking System!\r\n" + 
                "1. Create a new bank account\r\n" + //
                "2. Deposit money\r\n" + //
                "3. Withdraw money\r\n" + //
                "4. Check balance\r\n" + //
                "5. Display all accounts\r\n" + //
                "6. Exit\r\n");
        System.out.print("Enter your choice: ");
        String userChoiceSelected = userChoice.nextLine();
        System.out.println("------ You have chosen : " + userChoiceSelected + " ------");

        switch(userChoiceSelected) {
            case "1":
                break;
            case "2":
            case "3":
                String userSelection = String.valueOf(userChoiceSelected);
                Scanner userMoneyAddInitialize = new Scanner(System.in);
                String msg;
                try {

                if (userSelection.equals("2")) {
                        msg = "deposit";
                        System.out.print("Enter Amount to " + msg + " : ");
                    } else if (userSelection.equals("3")) {
                        msg = "withdraw";
                        System.out.print("Enter Amount to " + msg + " : ");
                    }
                int userMoneyAmount = userMoneyAddInitialize.nextInt();
                // Create 2 Threads
                JavaBankSys j1 = new JavaBankSys(userSelection, userMoneyAmount);
                JavaBankSys j2 = new JavaBankSys(userSelection, userMoneyAmount);

                Thread t1 = new Thread(j1);
                Thread t2 = new Thread(j2);

                    if (userSelection.equals("2")) {
                        t1.start();
                    } else if (userSelection.equals("3")) {
                        t2.start();
                    }
                    t1.join();
                    t2.join();
                } catch (Exception e) {
                    System.out.println("You've made a mistake, please try again.");
                }
                break;
            case "4":
                JavaBankSys chkBalance = new JavaBankSys();
                chkBalance.CheckBalance();
                break;
            case "5":
                break;
            case "6":
                System.out.println("Thank you for using the Simple banking System. Goodbye!");
                System.exit(1);
                break;
            default:
                System.out.println("Please select the choices above. <number>");
            break;
        }
    }

    public JavaBankSys() {
        System.out.println("> Empty JavaBankSys constructor has been called.");
    }

    // Constructor helps in initalizing and sending paremeters to runnable's run()
    // method. Very good.
    public JavaBankSys(String select, int amount) {
        this.select = select;
        this.amount = amount;
        System.out.println("> JavaBankSys constructor has been called.");
    }

}

class Main {
    public static void main(String[] args) {

        // START OF PROGRAM, WAIT FOR USER SELECTION
        Scanner scanner = new Scanner(System.in);
        JavaBankSys.WaitUserChoice(scanner);

    }
}