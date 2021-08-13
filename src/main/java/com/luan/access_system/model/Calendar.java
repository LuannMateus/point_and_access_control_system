package com.luan.access_system.model;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Audited
public class Calendar {
    @Id
    private long id;

    @ManyToOne
    private DateType dateType;
    private String description;
    private LocalDateTime specialDate;
}
