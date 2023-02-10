package com.java.aadityadesigners.services.accounting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.aadityadesigners.common.utils.DtoToEntityConverter;

@RestController
public class AccountingController {

    @Autowired
    AccountingService accountingService;
    @Autowired
    DtoToEntityConverter dtoToEntityConverter;

    @GetMapping("/transactions/account")
    public ResponseEntity<List<TransactionDto>> getTransactionsByAccountNumber(@RequestParam String accountNumber) {

        List<Transaction> transactions = accountingService.getTransactionsByAccountNumber(accountNumber);
        return ResponseEntity.ok(dtoToEntityConverter.convertToDtoList(transactions, TransactionDto.class));
    }
}
