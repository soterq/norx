package com.example.norx.spender.SpenderType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class History {
    @SequenceGenerator(
            name = "history_sequence",
            sequenceName = "history_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "history_sequence"
    )
    private Long id;
    private LocalDateTime executedAt;
    private BigInteger amount;
    @Enumerated(EnumType.STRING)
   private MoneyManagement moneyManagement;

    public History(BigInteger amount, MoneyManagement moneyManagement) {
        this.amount = amount;
        this.moneyManagement = moneyManagement;
        this.executedAt = LocalDateTime.now();
    }
}
