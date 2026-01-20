package com.telecom.billing.service.impl;

import com.telecom.billing.dto.PlanRequestDto;
import com.telecom.billing.dto.PlanResponseDto;
import com.telecom.billing.dto.PlanUpdateRequestDto;
import com.telecom.billing.entity.Plan;
import com.telecom.billing.enums.SubscriptionType;
import com.telecom.billing.exception.ResourceNotFoundException;
import com.telecom.billing.mapper.PlanMapper;
import com.telecom.billing.repository.PlanRepository;
import com.telecom.billing.service.PlanService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanServiceImpl implements PlanService {
    private final PlanRepository planRepository;

    @Override
    public PlanResponseDto createPlan(PlanRequestDto dto) {
        Plan plan = PlanMapper.toEntity(dto);
        return PlanMapper.toDto(planRepository.save(plan));
    }

    @Override
    public PlanResponseDto updatePlan(Long id, PlanRequestDto dto) {
        Plan plan = planRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Plan not found with id: " + id));

        PlanMapper.updateEntity(plan, dto);
        return PlanMapper.toDto(planRepository.save(plan));
    }

    @Override
    public PlanResponseDto updatePlanPartial(Long id, PlanUpdateRequestDto dto) {

        Plan plan = planRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Plan", "id", id));

        PlanMapper.partialUpdate(plan, dto);

        Plan updatedPlan = planRepository.save(plan);
        return PlanMapper.toDto(updatedPlan);
    }

    @Override
    public PlanResponseDto getPlanById(Long id) {
        Plan plan = planRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Plan not found with id: " + id));

        return PlanMapper.toDto(plan);
    }

    @Override
    public List<PlanResponseDto> getAllPlans() {
        return planRepository.findAll()
                .stream()
                .map(PlanMapper::toDto)
                .toList();
    }

    @Override
    public List<PlanResponseDto> getActivePlans() {
        return planRepository.findByActiveTrue()
                .stream()
                .map(PlanMapper::toDto)
                .toList();
    }

    @Override
    public List<PlanResponseDto> getPlansByType(SubscriptionType type) {
        return planRepository.findByTypeAndActiveTrue(type)
                .stream()
                .map(PlanMapper::toDto)
                .toList();
    }

    @Override
    public void deactivatePlan(Long id) {
        Plan plan = planRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Plan not found with id: " + id));

        plan.setActive(false);
        planRepository.save(plan);
    }
}
