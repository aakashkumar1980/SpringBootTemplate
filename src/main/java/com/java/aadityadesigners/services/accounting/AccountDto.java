package com.java.aadityadesigners.services.accounting;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    
    @NotNull
    @Size(max = 200)
    private String number;
    
    private List<PartyDto> parties;
    
    private List<TransactionDto> transactions;    
}
