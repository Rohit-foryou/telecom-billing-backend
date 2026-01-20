package com.telecom.billing.mapper;

import com.telecom.billing.dto.PlanRequestDto;
import com.telecom.billing.dto.PlanResponseDto;
import com.telecom.billing.dto.PlanUpdateRequestDto;
import com.telecom.billing.entity.Plan;

public class PlanMapper {
    public static Plan toEntity(PlanRequestDto dto) {
        Plan plan = new Plan();
        plan.setName(dto.getName());
        plan.setType(dto.getType());
        plan.setMonthlyRental(dto.getMonthlyRental());
        plan.setValidityDays(dto.getValidityDays());
        plan.setDataLimitMb(dto.getDataLimitMb());
        plan.setCallLimitMinutes(dto.getCallLimitMinutes());
        plan.setSmsLimit(dto.getSmsLimit());
        plan.setActive(dto.getActive());
        return plan;
    }

    public static PlanResponseDto toDto(Plan plan) {
        PlanResponseDto dto = new PlanResponseDto();
        dto.setId(plan.getId());
        dto.setName(plan.getName());
        dto.setType(plan.getType());
        dto.setMonthlyRental(plan.getMonthlyRental());
        dto.setValidityDays(plan.getValidityDays());
        dto.setDataLimitMb(plan.getDataLimitMb());
        dto.setCallLimitMinutes(plan.getCallLimitMinutes());
        dto.setSmsLimit(plan.getSmsLimit());
        dto.setActive(plan.getActive());
        return dto;
    }

    public static void updateEntity(Plan plan, PlanRequestDto dto) {
        plan.setName(dto.getName());
        plan.setType(dto.getType());
        plan.setMonthlyRental(dto.getMonthlyRental());
        plan.setValidityDays(dto.getValidityDays());
        plan.setDataLimitMb(dto.getDataLimitMb());
        plan.setCallLimitMinutes(dto.getCallLimitMinutes());
        plan.setSmsLimit(dto.getSmsLimit());
        plan.setActive(dto.getActive());
    }

    public static void partialUpdate(Plan plan, PlanUpdateRequestDto dto) {

        if (dto.getName() != null) {
            plan.setName(dto.getName());
        }
        if (dto.getType() != null) {
            plan.setType(dto.getType());
        }
        if (dto.getMonthlyRental() != null) {
            plan.setMonthlyRental(dto.getMonthlyRental());
        }
        if (dto.getValidityDays() != null) {
            plan.setValidityDays(dto.getValidityDays());
        }
        if (dto.getDataLimitMb() != null) {
            plan.setDataLimitMb(dto.getDataLimitMb());
        }
        if (dto.getCallLimitMinutes() != null) {
            plan.setCallLimitMinutes(dto.getCallLimitMinutes());
        }
        if (dto.getSmsLimit() != null) {
            plan.setSmsLimit(dto.getSmsLimit());
        }
        if (dto.getActive() != null) {
            plan.setActive(dto.getActive());
        }
    }
}
