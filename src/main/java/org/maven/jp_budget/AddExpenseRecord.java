package org.maven.jp_budget;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Scanner;

import static org.maven.jp_budget.BudgetManager.budgetService;


public class AddExpenseRecord  {

    static void addExpense() {
        System.out.println("Iveskite islaidu dydi: ");
        Scanner scanner = new Scanner(System.in);
        BigDecimal amount = scanner.nextBigDecimal();
        System.out.println("Iveskite islaidu tipa: ");
        String category = scanner.next();
        Record Record = new ExpenseRecord(amount, category, LocalDateTime.now(), PaymentMethodType.CARD, new BankCard("Revolut", "1234"), BudgetManager.getId());
        budgetService.setRecord(Record);
    }
}