import java.io.*;
import java.util.*;

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
        if (select.equals("D")) {
            System.out.println("---------------\nDeposit activated");
            Deposit(amount);
            Deposit(10000);
            Deposit(5000);
        } else if (select.equals("W") && !(balance <= 0)) {
            System.out.println("---------------\nWithdraw activated");
            Withdraw(amount);
            Withdraw(999999999);
        } else {
            System.out.println("-------Transaction failed, please try again.-------");
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
        System.out.println("Your current balance : " + balance);
    }

    public void AccountList() {
        System.out.println("This system will be implement later on");
    }

    // Constructor helps in initalizing and sending paremeters to runnable's run()
    // method. Very good.
    public JavaBankSys(String select, int amount) {
        this.select = select;
        this.amount = amount;
        System.out.println("JavaBankSys constructor has been called.");
    }

}

class Main {
    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Usage : <(D)eposit / (W)ithdraw> <Amount>");
            System.exit(1);
        } else {
            System.out.println("the initialization is complete!\n---------------");

            String userSelection = args[0];
            int userMoneyAmount = Integer.parseInt(args[1]);
            // Create 2 Threads
            JavaBankSys j1 = new JavaBankSys(userSelection, userMoneyAmount);
            JavaBankSys j2 = new JavaBankSys(userSelection, userMoneyAmount);

            Thread t1 = new Thread(j1);
            Thread t2 = new Thread(j2);

            try {
                if (userSelection.equals("D")) {
                    t1.start();
                } else if (userSelection.equals("W")) {
                    t2.start();
                }
                t1.join();
                t2.join();
            } catch (Exception e) {
                System.out.println("you've made some mistake, please try again");
            }
        }
    }
}