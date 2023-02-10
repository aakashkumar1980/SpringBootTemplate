package com.java.aadityadesigners.services.accounting;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {
    
    private Long id;

    @NotNull
    @DecimalMin("0.00")
    private Float amount;

    @NotEmpty
    private String type;

    private AccountDto accountDto;
}
