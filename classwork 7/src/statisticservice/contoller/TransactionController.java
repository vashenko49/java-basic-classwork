package statisticservice.contoller;

import statisticservice.exception.ValidationException;
import statisticservice.model.Transaction;
import statisticservice.service.TransactionService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import static java.util.Objects.*;
import static statisticservice.service.TransactionService.DATE_TIME_FORMATTER;

public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public void receiveTransaction(Transaction transaction) throws ValidationException {
        if (transaction == null || isValidAmount(transaction.getAmount())) {
            throw new ValidationException();
        } else {
            transactionService.addTransaction(transaction);
        }
    }

    private boolean isValidAmount(BigDecimal amount) {
        return nonNull(amount) || amount.doubleValue() > 0;
    }

    private boolean isValidDate(String date) {
        LocalDate.parse(date, DATE_TIME_FORMATTER);
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
