package com.telecom.billing.service;

import com.telecom.billing.dto.PlanRequestDto;
import com.telecom.billing.dto.PlanResponseDto;
import com.telecom.billing.dto.PlanUpdateRequestDto;
import com.telecom.billing.enums.SubscriptionType;

import java.util.List;

public interface PlanService {
    PlanResponseDto createPlan(PlanRequestDto dto);
    PlanResponseDto updatePlan(Long id, PlanRequestDto dto);
    PlanResponseDto updatePlanPartial(Long id, PlanUpdateRequestDto dto);
    PlanResponseDto getPlanById(Long id);
    List<PlanResponseDto> getAllPlans();
    List<PlanResponseDto> getActivePlans();
    List<PlanResponseDto> getPlansByType(SubscriptionType type);
    void deactivatePlan(Long id);
}
