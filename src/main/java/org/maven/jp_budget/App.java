package org.maven.jp_budget;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class App {
    static final BudgetService budgetService = new BudgetService();

    public App() {
    }

    public static void main(String[] args) {
        System.out.println("Labas");
        IncomeRecord incomeRecord = new IncomeRecord(BigDecimal.valueOf(1500L), "Salary", LocalDateTime.now(), true, (String)null);
        ExpenseRecord expenseRecord = new ExpenseRecord(BigDecimal.valueOf(100L), "Food", LocalDateTime.now(), PaymentMethodType.CARD, new BankCard("Revolut", "1234"));
        budgetService.setIncomeRecord(incomeRecord);
        budgetService.setExpenseRecords(expenseRecord);
        printIncomeRecords();
        printExpenseRecords();
    }

    private static void printIncomeRecords() {
        for(IncomeRecord record : budgetService.getIncomeRecords()) {
            System.out.println(record);
        }

    }

    private static void printExpenseRecords() {
        for(ExpenseRecord record : budgetService.getExpenseRecords()) {
            System.out.println(record);
        }

    }
}