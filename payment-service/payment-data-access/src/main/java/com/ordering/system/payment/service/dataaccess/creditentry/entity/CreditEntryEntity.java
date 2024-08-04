package com.ordering.system.payment.service.dataaccess.creditentry.entity;

import lombok.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "credit_entry")
@Entity
public class CreditEntryEntity {

    @Id
    private UUID id;

    private UUID customerId;

    private BigDecimal totalCreditAmount;

}
