package org.maven.jp_budget;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class IncomeRecord extends Record {

    private final boolean isBankTransfer;
    private final String otherInfo;



    public IncomeRecord(BigDecimal amount, String category, LocalDateTime date, boolean isBankTransfer, String otherInfo, int id) {
        super(amount, category, date, id);
        this.isBankTransfer = isBankTransfer;
        this.otherInfo = otherInfo;
    }

//    public int getId() {
//        return id;
//    }
//
////    public BigDecimal getAmount() {
////        return amount;
////    }
//
//    public String getCategory() {
//        return category;
//    }
//
//    public LocalDateTime getDate() {
//        return date;
//    }

    public boolean isBankTransfer() {
        return isBankTransfer;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("IncomeRecord{");
        sb.append("amount=").append(amount);
        sb.append(", category='").append(category).append('\'');
        sb.append(", date=").append(date);
        sb.append(", isBankTransfer=").append(isBankTransfer);
        sb.append(", otherInfo='").append(otherInfo).append('\'');
        sb.append(", ID=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
