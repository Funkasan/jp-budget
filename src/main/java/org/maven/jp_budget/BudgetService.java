package org.maven.jp_budget;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BudgetService {

    private final List<IncomeRecord> incomeRecords = new ArrayList<>();
    private final List<ExpenseRecord> expenseRecords = new ArrayList<>();

    public List<IncomeRecord> getIncomeRecords() {
        return incomeRecords;
    }

    public void setIncomeRecord(final IncomeRecord incomeRecords) {
        this.incomeRecords.add(incomeRecords);
    }

    public List<ExpenseRecord> getExpenseRecords() {
        return expenseRecords;
    }

    public void setExpenseRecords(final ExpenseRecord expenseRecords) {
        this.expenseRecords.add(expenseRecords);
    }

    public double balansas(){
        double totalIncome = incomeRecords.stream().map(IncomeRecord::getAmount).filter(Objects::nonNull).mapToDouble(BigDecimal::doubleValue).sum();
        double totalExpense = expenseRecords.stream().map(ExpenseRecord::getAmount).filter(Objects::nonNull).mapToDouble(BigDecimal::doubleValue).sum();

        return totalIncome-totalExpense;

    }



}
