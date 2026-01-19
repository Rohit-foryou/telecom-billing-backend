package com.telecom.billing.entity;

import com.telecom.billing.enums.SubscriptionType;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "plans")
@Data
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private SubscriptionType type;

    @Column(name = "monthly_rental")
    private BigDecimal monthlyRental;

    @Column(name = "validity_days")
    private Integer validityDays;

    @Column(name = "data_limit_mb")
    private Integer dataLimitMb;

    @Column(name = "call_limit_minutes")
    private Integer callLimitMinutes;

    @Column(name = "sms_limit")
    private Integer smsLimit;

    private Boolean active;

    @OneToMany(mappedBy = "plan")
    private List<Subscription> subscriptions;
}
