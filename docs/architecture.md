# System Architecture – Telecom Billing Backend

## 1. High-Level Flow

Client (Frontend)
↓
REST API (Spring Boot Controllers)
↓
Service Layer (Business Rules)
↓
Repository Layer (JPA)
↓
PostgreSQL Database

---

## 2. Core Modules & Responsibilities

### Customer Module
- Create and manage customers
- Maintain KYC and customer status
- One customer can have multiple subscriptions

### Subscription Module
- Manage SIM lifecycle
- Handle state transitions:
  NEW → ACTIVE → SUSPENDED → TERMINATED
- Link customer with plan

### Plan Module
- Define prepaid and postpaid plans
- Plans are reusable across subscriptions
- No customer-specific data here

### Usage Module
- Store simulated usage data
- Used by billing engine
- No real telecom integration

### Billing Module
- Generate monthly bills (postpaid)
- Track bill status
- Handle payments and overdue logic

---

## 3. Business Rules (IMPORTANT)

- A subscription must be ACTIVE to generate usage
- Bills can only be generated for POSTPAID plans
- Payment updates bill status
- Suspended subscriptions cannot generate usage

---

## 4. What We Are NOT Doing
- No real payment gateway
- No real telecom CDR integration
- No microservices (single monolith)

---

## 5. Future Scope
- Scheduled billing jobs
- Usage analytics
- Notifications
