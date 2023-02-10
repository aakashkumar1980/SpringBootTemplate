package com.java.aadityadesigners.services.accounting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.aadityadesigners.common.exceptions.ResourceNotFoundException;

@Service
public class AccountingService {

      @Autowired
      private TransactionRepository transactionRepository;

      public List<Transaction> getTransactionsByAccountNumber(String accountNumber) {
            return transactionRepository.findByAccountNumber(accountNumber);
      }

      public Double computeAverageTransactionsByTransactionType(String transactionType)
                  throws ResourceNotFoundException {
            List<Transaction> transactions = transactionRepository.findByTransactionType(transactionType);
            if (transactions.isEmpty()) {
                  throw new ResourceNotFoundException("Transaction type not found: " + transactionType);
            }
            double sum = 0;
            for (Transaction transaction : transactions) {
                  sum = sum + transaction.getAmount();
            }
            return sum / transactions.size();
      }
}
