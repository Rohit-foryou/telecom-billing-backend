package com.telecom.billing.entity;

import com.telecom.billing.enums.SubscriptionStatus;
import com.telecom.billing.enums.SubscriptionType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "subscriptions")
@Data
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private String msisdn;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private Plan plan;

    @Enumerated(EnumType.STRING)
    private SubscriptionType type;

    @Enumerated(EnumType.STRING)
    private SubscriptionStatus status;

    @Column(name = "activation_date")
    private LocalDate activationDate;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @OneToMany(mappedBy = "subscription", cascade = CascadeType.ALL)
    private List<UsageRecord> usageRecords;

    @OneToMany(mappedBy = "subscription", cascade = CascadeType.ALL)
    private List<Bill> bills;
}
