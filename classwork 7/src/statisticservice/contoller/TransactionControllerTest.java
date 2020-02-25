package statisticservice.contoller;

import statisticservice.exception.ValidationException;
import statisticservice.model.Transaction;

import org.junit.Test;
import statisticservice.service.TransactionService;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

public class TransactionControllerTest {
    @Test(expected = ValidationException.class)
    public void should_ThrowValidationException_When_TransactionIsEmpty() throws ValidationException {
        //given
        Transaction transaction = new Transaction(null, null);
        TransactionController transactionController = new TransactionController(null);
        //when
        transactionController.receiveTransaction(transaction);
        //than
    }
    @Test
    public void should_ProcessTransaction_When_TransactionIsValid() throws ValidationException {
        //given
        BigDecimal bigDecimal = new BigDecimal("456");
        Transaction transaction = new Transaction(bigDecimal,"2020-05-15 11:39:45");
        TransactionService transactionService = mock(TransactionService.class);
        TransactionController transactionController = new TransactionController(transactionService);
        //when
        transactionController.receiveTransaction(transaction);
        //than
        verify(transactionService, times(1)).addTransaction(transaction);
    }
}