package statisticservice.model;

import java.math.BigDecimal;

public class Transaction {
    private final BigDecimal amount;
    private final String date;

    public BigDecimal getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public Transaction(BigDecimal amount, String date) {
        this.amount = amount;
        this.date = date;
    }
}
