package org.maven.jp_budget;

import java.util.Scanner;

import static org.maven.jp_budget.AddExpenseRecord.addExpense;
import static org.maven.jp_budget.AddIncomeRecord.addIncome;

public class BudgetManager {
    static final BudgetService budgetService = new BudgetService();

    Scanner scanner = new Scanner(System.in);
    static int id = 1;
    private final RecordModifier recordModifier;

    public BudgetManager() {
        this.recordModifier = new RecordModifier(budgetService, scanner);
    }

    public void run() {

        int pasirinkimas;

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
            System.out.println("8. Keisti įrašo reikšmes");
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
                case 8:
                    recordModifier.modifyRecord();
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

    private static void printIncomeRecords() {
        for (Record record : budgetService.getRecords()) {
            if (record instanceof IncomeRecord) {
                System.out.println(record);
            }
        }
    }

    private static void printExpenseRecords() {
        for (Record record : budgetService.getRecords()) {
            if (record instanceof ExpenseRecord) {
                System.out.println(record);
            }
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
