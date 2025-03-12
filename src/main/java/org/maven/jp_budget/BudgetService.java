package org.maven.jp_budget;

import java.util.ArrayList;
import java.util.List;

public class BudgetService {

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

    public List<Record> getExpenseRecords() {
        return records;
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

    public void deleteRecord(int id) {
        records.removeIf(record -> record.getId() == id);
    }

    public Record getRecordById(int recordId) {
        for (Record record : records) {
            if (record.getId() == recordId) {
                return record;
            }
        }
        return null;
    }
}
