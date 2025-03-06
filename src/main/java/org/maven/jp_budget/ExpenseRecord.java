package org.maven.jp_budget;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ExpenseRecord extends Record{
    private final PaymentMethodType paymentMethod;
    private final BankCard bankCard;


    public ExpenseRecord(BigDecimal amount, String category, LocalDateTime date, PaymentMethodType paymentMethod, BankCard bankCard, int id) {
        super(amount, category, date, id);
        this.paymentMethod = paymentMethod;
        this.bankCard = bankCard;
    }

//    public int getid() {
//        return id;
//    }
//
//    public BigDecimal getAmount() {
//        return amount;
//    }
//
//    public String getCategory() {
//        return category;
//    }
//
//    public LocalDateTime getDate() {
//        return date;
//    }

    public PaymentMethodType getPaymentMethod() {
        return paymentMethod;
    }

    public BankCard getBankCard() {
        return bankCard;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ExpenseRecord{");
        sb.append("amount=").append(amount);
        sb.append(", category='").append(category).append('\'');
        sb.append(", date=").append(date);
        sb.append(", paymentMethod=").append(paymentMethod);
        sb.append(", bankCard=").append(bankCard);
        sb.append(", ID=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
