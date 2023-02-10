package com.java.aadityadesigners.services.accounting;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartyDto {
    
    private Long id;

    @NotEmpty(message = "Name can't be empty")
    private String name;
  
    @NotEmpty(message = "Address can't be empty")
    private String address;
  
    private AccountDto accountDto;
}
