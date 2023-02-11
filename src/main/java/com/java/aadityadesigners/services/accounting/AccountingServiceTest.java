package com.java.aadityadesigners.services.accounting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.java.aadityadesigners.common.exceptions.ResourceNotFoundException;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class AccountingServiceTest {
    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private AccountingService accountingService;

    @Test
    public void getTransactionsByAccountNumber_shouldReturnListOfTransactions() {
        // Given
        String accountNumber = "SAL0AD1";
        List<Transaction> transactions = new ArrayList<>();
        
        // When
        when(transactionRepository.findByAccountNumber(accountNumber)).thenReturn(transactions);
        // Then
        List<Transaction> result = accountingService.getTransactionsByAccountNumber(accountNumber);
        
        assertTrue(result.size()==transactions.size());
    }

    @Test
    void computeAverageTransactionsByTransactionType() throws ResourceNotFoundException {
        Transaction c1 = new Transaction();
        c1.setAmount(100f);
        c1.setType("CREDIT");
        Transaction c2 = new Transaction();
        c2.setAmount(200f);
        c2.setType("DEBIT");
        Transaction d1 = new Transaction();
        d1.setAmount(300f);
        d1.setType("CREDIT");
        List<Transaction> transactions = List.of(c1, c2, d1);

        when(transactionRepository.findAll()).thenReturn(transactions);

        double actual = accountingService.computeAverageTransactionsByTransactionType("CREDIT");
        double expected = 200;

        assertEquals(expected, actual);
    }
}