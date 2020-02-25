package statisticservice.service;

import statisticservice.model.Transaction;

import java.time.format.DateTimeFormatter;

public class TransactionService {
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void addTransaction(Transaction transaction) {
    }
}
