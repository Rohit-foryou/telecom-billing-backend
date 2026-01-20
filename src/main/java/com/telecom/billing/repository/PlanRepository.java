package com.telecom.billing.repository;

import com.telecom.billing.entity.Plan;
import com.telecom.billing.enums.SubscriptionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Long> {
    List<Plan> findByActiveTrue();
    List<Plan> findByTypeAndActiveTrue(SubscriptionType type);
}
