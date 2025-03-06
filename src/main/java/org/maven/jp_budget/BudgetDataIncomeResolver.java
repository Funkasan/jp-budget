package org.maven.jp_budget;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;
import org.maven.jp_budget.exception.AmountLessOrEqualZeroException;

import static org.maven.jp_budget.BudgetManager.budgetService;

public class BudgetDataIncomeResolver {

    private final Scanner sc = new Scanner(System.in);
    private final BudgetService budgetService;

    public BudgetDataIncomeResolver(final BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    public void resolve() throws AmountLessOrEqualZeroException, InputMismatchException {
        try {
            System.out.println("Please enter your income record.");
            System.out.print("Amount: ");
            final BigDecimal amount = sc.nextBigDecimal();
            sc.nextLine();
            if (amount.compareTo(BigDecimal.ZERO) <= 0) {
                throw new AmountLessOrEqualZeroException();
            }
            System.out.print("Category: ");
            final String tipas = sc.nextLine();
            System.out.print("Is it a bank transfer? (true/false): ");
            final boolean isBankTransfer = sc.nextBoolean();
            System.out.print("Please enter other optional information: ");
            final String optionalInfo = sc.nextLine();

//            final IncomeRecord incomeRecord = new IncomeRecord(
//                    amount, category, LocalDateTime.now(), isBankTransfer, optionalInfo);
            Record Record = new IncomeRecord(amount, tipas, LocalDateTime.now(), true, (String) null, BudgetManager.getId());
            budgetService.setRecord(Record);
//            budgetService.setIncomeRecord(incomeRecord);
        } catch (InputMismatchException e) {
            sc.nextLine();
            throw new InputMismatchException();
        }
    }


}
