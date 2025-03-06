package org.maven.jp_budget;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Scanner;

public class BudgetManager {

    static final BudgetService budgetService = new BudgetService();
    Scanner scanner = new Scanner(System.in);
    int id=0;
    public void run() {

        int pasirinkimas;
        
        // IncomeRecord incomeRecord1 = new IncomeRecord(BigDecimal.valueOf(1500L), "Atlyginimas", LocalDateTime.now(), true, (String) null, 1);
        // budgetService.setIncomeRecord(incomeRecord1);
        // IncomeRecord incomeRecord2 = new IncomeRecord(BigDecimal.valueOf(600L), "Pensija", LocalDateTime.now(), true, (String) null, 2);
        // budgetService.setIncomeRecord(incomeRecord2);
        // ExpenseRecord expenseRecord1 = new ExpenseRecord(BigDecimal.valueOf(100L), "Food", LocalDateTime.now(), PaymentMethodType.CARD, new BankCard("Revolut", "1234"), 3);
        // budgetService.setExpenseRecords(expenseRecord1);
        // ExpenseRecord expenseRecord2 = new ExpenseRecord(BigDecimal.valueOf(200L), "Komunaliniai", LocalDateTime.now(), PaymentMethodType.CARD, new BankCard("Revolut", "1234"), 4);

        // budgetService.setExpenseRecords(expenseRecord2);

        printIncomeRecords();

        printExpenseRecords();
        budgetService.balansas();
        System.out.println(budgetService.balansas());


        do {
            System.out.println("Meniu:");
            System.out.println("1. Pridėti pajamas");
            System.out.println("2. Pridėti išlaidas");
            System.out.println("3. Patikrinti balansą");
            System.out.println("4. Parodyti pajamas");
            System.out.println("5. Parodyti islaidas");
            System.out.println("6. Pasalinti saskaita");
            System.out.println("0. Išeiti");
            System.out.print("Pasirinkite veiksmą: ");
            pasirinkimas = scanner.nextInt();

            switch (pasirinkimas) {
                case 1:
                    addIncome();
                    break;
                case 2:
                    addExpense();
                    break;
                case 3:
                    System.out.println("Balansas: " + budgetService.balansas());
                    break;
                case 4:
                    printIncomeRecords();
                    break;
                case 5:
                    printExpenseRecords();
                    break;
                case 6:
                    System.out.println("Iveskite israso ID numeri: ");
                    int deleteId = scanner.nextInt();
                    budgetService.deleteRecord(deleteId);
                    System.out.println("Israsas istrintas");
                    break;
                case 0:
                    System.out.println("Programa baigta.");
                    break;
                default:
                    System.out.println("Neteisingas pasirinkimas. Bandykite dar kartą.");
            }
        } while (pasirinkimas != 0);

        scanner.close();

    }

    private void addIncome() {
        System.out.println("Iveskite pajamu dydi: ");
        BigDecimal amount = scanner.nextBigDecimal();
        System.out.println("Iveskite pajamu tipa: ");
        String tipas = scanner.next();
        id++;
        IncomeRecord incomeRecord = new IncomeRecord(amount, tipas, LocalDateTime.now(), true, (String) null, id);
        budgetService.setIncomeRecord(incomeRecord);
    }

    private void addExpense() {
        System.out.println("Iveskite islaidu dydi: ");
        BigDecimal amount = scanner.nextBigDecimal();
        System.out.println("Iveskite islaidu tipa: ");
        String tipas = scanner.next();
        id++;
        ExpenseRecord expenseRecord = new ExpenseRecord(amount, tipas, LocalDateTime.now(), PaymentMethodType.CARD, new BankCard("Revolut", "1234"), id);
        budgetService.setExpenseRecords(expenseRecord);
    }


    private static void printIncomeRecords() {
        for (IncomeRecord record : budgetService.getIncomeRecords()) {
            System.out.println(record);
        }

    }

    private static void printExpenseRecords() {
        for (ExpenseRecord record : budgetService.getExpenseRecords()) {
            System.out.println(record);
        }

    }


}





