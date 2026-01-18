# Telecom Subscription & Billing System (Backend)

## Tech Stack
- Spring Boot
- Spring Security
- JPA / Hibernate
- PostgreSQL
- JWT Authentication

## Modules
- Customer Management
- Subscription Lifecycle
- Plan Management
- Billing Engine

## Status
🚧 In Progress

## 🗄️ Database Design (Conceptual)
### 1️⃣ Customer
Represents a telecom customer.
- customer
- id (PK)
- name
- email
- mobile_number
- kyc_status (PENDING, VERIFIED)
- status (ACTIVE, SUSPENDED)
- created_at


---

### 2️⃣ Subscription
Represents a SIM / telecom connection.
- id (PK)
- customer_id (FK)
- msisdn (phone number)
- plan_id (FK)
- type (PREPAID, POSTPAID)
- status (NEW, ACTIVE, SUSPENDED, TERMINATED)
- activation_date
- expiry_date


---

### 3️⃣ Plan
Defines billing and usage rules.
- plan
- id (PK)
- name
- type (PREPAID, POSTPAID)
- monthly_rental
- validity_days
- data_limit_mb
- call_limit_minutes
- sms_limit
- active


---

### 4️⃣ Usage Record
Tracks usage data for billing calculations.
- id (PK)
- subscription_id (FK)
- usage_type (DATA, CALL, SMS)
- units
- usage_date


---

### 5️⃣ Bill
Generated for postpaid subscriptions.
- id (PK)
- subscription_id (FK)
- billing_month
- total_amount
- status (GENERATED, PAID, OVERDUE)
- generated_date


---

## 🔗 Entity Relationships
- Customer 1 ──── * Subscription
- Plan 1 ──── * Subscription
- Subscription 1 ──── * UsageRecord
- Subscription 1 ──── * Bill


---

## 🔄 State Machines

### Subscription Lifecycle
NEW → ACTIVE → SUSPENDED → TERMINATED


### Bill Lifecycle
GENERATED → PAID → OVERDUE

## 🔐 Security (Planned)
- Spring Security
- JWT-based authentication
- Role-based authorization:
    - ADMIN
    - SUPPORT

## 👨‍💻 Author
**Rohit Kumar**  
Backend Developer | Java | Spring Boot




