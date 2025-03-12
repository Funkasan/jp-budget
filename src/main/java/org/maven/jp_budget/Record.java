package org.maven.jp_budget;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public class Record {
    BigDecimal amount;
    String category;
    LocalDateTime date;
    int id;

    public Record(BigDecimal amount, String category, LocalDateTime date, int id) {
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.id = id;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public LocalDateTime getDate() {
        return date;
    }
    public int getId() {
        return id;
    }

    public int getRecordById(int recordId) {
        return id;
    }

    public String toString() {
        final StringBuffer sb = new StringBuffer("Record{");
        sb.append("amount=").append(amount);
        sb.append(", category='").append(category).append('\'');
        sb.append(", date=").append(date);
        sb.append(", ID=").append(id);
        sb.append('}');
        return sb.toString();
    }

}
