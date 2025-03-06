package org.maven.jp_budget.exception;

public class AmountLessOrEqualZeroException extends Exception {
    public AmountLessOrEqualZeroException() {
        super("Amount must be greater than zero");
    }
}
