package com.java.aadityadesigners.common.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResourceNotFoundException extends Throwable {
    
    public ResourceNotFoundException(String string) {
        super(string);
    }

}
