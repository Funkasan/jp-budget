package org.maven.jp_budget;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Scanner;

import static org.maven.jp_budget.BudgetManager.budgetService;


public class AddIncomeRecord {

    static void addIncome() {
        System.out.println("Iveskite pajamu dydi: ");
        Scanner scanner = new Scanner(System.in);
        BigDecimal amount = scanner.nextBigDecimal();
        System.out.println("Iveskite pajamu tipa: ");
        String category = scanner.next();
        Record Record = new IncomeRecord(amount, category, LocalDateTime.now(), true, (String) null, BudgetManager.getId());
        budgetService.setRecord(Record);
    }

}
