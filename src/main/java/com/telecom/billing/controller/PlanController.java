package com.telecom.billing.controller;

import com.telecom.billing.dto.PlanRequestDto;
import com.telecom.billing.dto.PlanResponseDto;
import com.telecom.billing.dto.PlanUpdateRequestDto;
import com.telecom.billing.enums.SubscriptionType;
import com.telecom.billing.service.PlanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plans")
@RequiredArgsConstructor
public class PlanController {
    private final PlanService planService;

    @PostMapping
    public ResponseEntity<PlanResponseDto> createPlan(
            @Valid @RequestBody PlanRequestDto dto) {
        return new ResponseEntity<>(planService.createPlan(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanResponseDto> updatePlan(
            @PathVariable Long id,
            @Valid @RequestBody PlanRequestDto dto) {
        return ResponseEntity.ok(planService.updatePlan(id, dto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PlanResponseDto> updatePlanPartial(
            @PathVariable Long id,
            @RequestBody PlanUpdateRequestDto dto) {

        return ResponseEntity.ok(planService.updatePlanPartial(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanResponseDto> getPlanById(@PathVariable Long id) {
        return ResponseEntity.ok(planService.getPlanById(id));
    }

    @GetMapping
    public ResponseEntity<List<PlanResponseDto>> getAllPlans() {
        return ResponseEntity.ok(planService.getAllPlans());
    }

    @GetMapping("/active")
    public ResponseEntity<List<PlanResponseDto>> getActivePlans() {
        return ResponseEntity.ok(planService.getActivePlans());
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<PlanResponseDto>> getPlansByType(
            @PathVariable SubscriptionType type) {
        return ResponseEntity.ok(planService.getPlansByType(type));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deactivatePlan(@PathVariable Long id) {
        planService.deactivatePlan(id);
        return ResponseEntity.noContent().build();
    }
}
