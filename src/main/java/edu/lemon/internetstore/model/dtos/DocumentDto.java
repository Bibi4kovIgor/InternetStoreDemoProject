package edu.lemon.internetstore.model.dtos;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record DocumentDto(
        String id,

        @Digits(message = "Documents tax id must be digits only (10 signs)", integer = 10, fraction = 0)
        Long taxId,

        @Size(min=4, max=10, message = "Passport must contains from 4 to 10 chars or numbers")
        String passport,

        String additionalInfo){}
