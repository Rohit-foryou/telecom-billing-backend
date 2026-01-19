package com.telecom.billing.entity;

import com.telecom.billing.enums.UsageType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "usage_records")
@Data
public class UsageRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "subscription_id")
    private Subscription subscription;

    @Enumerated(EnumType.STRING)
    @Column(name = "usage_type")
    private UsageType usageType;

    private Double units;

    @Column(name = "usage_date")
    private LocalDateTime usageDate;
}
