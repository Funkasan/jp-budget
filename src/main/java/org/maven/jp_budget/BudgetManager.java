package org.maven.jp_budget;

import java.util.Scanner;

import static org.maven.jp_budget.AddExpenseRecord.addExpense;
import static org.maven.jp_budget.AddIncomeRecord.addIncome;

public class BudgetManager {
    static final BudgetService budgetService = new BudgetService();

    Scanner scanner = new Scanner(System.in);
    static int id = 1;

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



        do {
            System.out.println("Meniu:");
            System.out.println("1. Pridėti pajamas");
            System.out.println("2. Pridėti išlaidas");
            System.out.println("3. Patikrinti balansą");
            System.out.println("4. Parodyti pajamas");
            System.out.println("5. Parodyti islaidas");
            System.out.println("6. Parodyti visas saskaitas");
            System.out.println("7. Pasalinti saskaita");
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
                    printRecords();
                    break;
                case 7:
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



//    private void addIncome() {
//        System.out.println("Iveskite pajamu dydi: ");
//        BigDecimal amount = scanner.nextBigDecimal();
//        System.out.println("Iveskite pajamu tipa: ");
//        String tipas = scanner.next();
//        id++;
//        Record Record = new IncomeRecord(amount, tipas, LocalDateTime.now(), true, (String) null, id);
//        budgetService.setRecord(Record);
//
//    }

//    private void addExpense() {
//        System.out.println("Iveskite islaidu dydi: ");
//        BigDecimal amount = scanner.nextBigDecimal();
//        System.out.println("Iveskite islaidu tipa: ");
//        String tipas = scanner.next();
//        id++;
//        Record Record = new ExpenseRecord(amount, tipas, LocalDateTime.now(), PaymentMethodType.CARD, new BankCard("Revolut", "1234"), id);
////        records.add(new ExpenseRecord(amount, tipas, LocalDateTime.now(), PaymentMethodType.CARD, new BankCard("Revolut", "1234"), id));
//        budgetService.setRecord(Record);
//    }


    private static void printIncomeRecords() {
        for (Record record : budgetService.getIncomeRecords()) {
            System.out.println(record);
        }

    }

    private static void printExpenseRecords() {
        for (Record record : budgetService.getExpenseRecords()) {
            System.out.println(record);
        }

    }
    private static void printRecords() {
        for (Record record : budgetService.getRecords()) {
            System.out.println(record);
        }

    }

    public static int getId() {
        return id++;
    }
}





