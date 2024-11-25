package net.javaguides.banking.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {
    Long id;
    Long accountId;
    double amount;
    String transactionType;
    LocalDateTime timestamp;
}
