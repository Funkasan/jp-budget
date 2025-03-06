package org.maven.jp_budget;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class BudgetService {

//    private final List<Record> incomeRecords = new ArrayList<>();
//    private final List<Record> expenseRecords = new ArrayList<>();
    private final List<Record> records = new ArrayList<>();

    public List<Record> getRecords() {
        return records;
    }

    public void setRecord(final Record Records) {
        this.records.add(Records);
    }

    public List<Record> getIncomeRecords() {
        return records;
    }

    public void setIncomeRecord(final Record incomeRecords) {
        this.records.add(incomeRecords);
    }

    public List<Record> getExpenseRecords() {
        return records;
    }

    public void setExpenseRecords(final Record expenseRecords) {
        this.records.add(expenseRecords);
    }

    public double balansas() {
        double totalIncome = 0;
        double totalExpenses = 0;
        
        for (Record record : records) {
            if (record instanceof IncomeRecord) {
                totalIncome += record.getAmount().doubleValue();
            } else if (record instanceof ExpenseRecord) {
                totalExpenses += record.getAmount().doubleValue();
            }
        }
        
        return totalIncome - totalExpenses;
    }

//    private List<Record> record() {
//        if (record -> record() == incomeRecords) {
//
//        }
//    }
//
    public void deleteRecord(int id) {
        records.removeIf(record -> record.getId() == id);
    }


//    private void addExpense() {
//        System.out.println("Iveskite islaidu dydi: ");
//        Scanner scanner = new Scanner(System.in);
//        BigDecimal amount = scanner.nextBigDecimal();
//        System.out.println("Iveskite islaidu tipa: ");
//        String tipas = scanner.next();
//        id++;
//        Record Record = new ExpenseRecord(amount, tipas, LocalDateTime.now(), PaymentMethodType.CARD, new BankCard("Revolut", "1234"), id);
////        records.add(new ExpenseRecord(amount, tipas, LocalDateTime.now(), PaymentMethodType.CARD, new BankCard("Revolut", "1234"), id));
//        budgetService.setRecord(Record);
//    }


}

