package com.telecom.billing.dto;

import com.telecom.billing.enums.SubscriptionType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PlanResponseDto {
    private Long id;
    private String name;
    private SubscriptionType type;
    private BigDecimal monthlyRental;
    private Integer validityDays;
    private Integer dataLimitMb;
    private Integer callLimitMinutes;
    private Integer smsLimit;
    private Boolean active;
}
