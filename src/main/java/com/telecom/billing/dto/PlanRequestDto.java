package com.telecom.billing.dto;

import com.telecom.billing.enums.SubscriptionType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PlanRequestDto {
    @NotBlank
    private String name;

    @NotNull
    private SubscriptionType type;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = true)
    private BigDecimal monthlyRental;

    @NotNull
    @Min(1)
    private Integer validityDays;

    @NotNull
    @Min(0)
    private Integer dataLimitMb;

    @NotNull
    @Min(0)
    private Integer callLimitMinutes;

    @NotNull
    @Min(0)
    private Integer smsLimit;

    @NotNull
    private Boolean active;
}
