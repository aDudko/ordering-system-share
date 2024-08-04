package com.ordering.system.payment.service.dataaccess.credithistory.entity;

import com.ordering.system.payment.service.domain.valueobject.TransactionType;
import lombok.*;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "credit_history")
@Entity
public class CreditHistoryEntity {

    @Id
    private UUID id;

    private UUID customerId;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

}
