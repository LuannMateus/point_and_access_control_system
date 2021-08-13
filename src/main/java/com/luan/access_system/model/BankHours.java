package com.luan.access_system.model;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Audited
public class BankHours {

    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public static class BankHoursId implements Serializable {
        private long bankHoursId;
        private long movementId;
        private long userId;
    }

    @EmbeddedId
    private BankHoursId id;

    private LocalDateTime workDate;
    private BigDecimal workHoursQuantity;
    private BigDecimal amountWorkHours;

}
