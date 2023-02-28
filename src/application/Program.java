package application;

import entities.Account;
import java.util.Locale;
import java.util.Scanner;

public class Program {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    Account account;

    System.out.println("=====BANK_MANAGER=====");
    System.out.print("Enter account number: ");
    int number = sc.nextInt();
    System.out.print("Enter account holder: ");
    sc.nextLine();
    String holder = sc.nextLine();

    System.out.print("Is there an initial deposit? (y/n): ");
    char response = sc.next().charAt(0);

    if (response == 'y') {
      System.out.println("Enter initial deposit value: ");
      double initialDeposit = sc.nextDouble();
      account = new Account(number, holder, initialDeposit);
    } else {
      account = new Account(number, holder);
    }

    System.out.println("");
    System.out.println("Account Data: \n" + account.toString());
    System.out.println("");
    System.out.print("Deposit or Withdraw? (d/w): ");
    do {
      response = sc.next().charAt(0);
      if (response == 'd') {
        System.out.printf("%n=====DEPOSIT=====%n");
        System.out.print("Enter a deposit value: ");
        double value = sc.nextDouble();
        account.deposit(value);
      } else if (response == 'w') {
        System.out.printf("%n=====Withdraw===== ( $5 Tax )%n ");
        System.out.print("Enter a withdraw value: ");
        double value = sc.nextDouble();
        account.withdraw(value);
      }
    } while (response != 'd' && response != 'w');

    System.out.println("");
    System.out.println("Updated Data: \n" + account);

    sc.close();
  }
}
