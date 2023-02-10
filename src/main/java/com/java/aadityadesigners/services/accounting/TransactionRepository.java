package com.java.aadityadesigners.services.accounting;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

  List<Transaction> findByAccountNumber(String accountNumber);
  
  @Query("SELECT t FROM Transaction t WHERE t.type = ?1")
  List<Transaction> findByTransactionType(String type);  
}