# 📡 Telecom Subscription & Billing System (Backend)

## 📌 Overview
This project is a backend system designed to manage telecom customers,
subscriptions (SIMs), plans, usage tracking, and billing lifecycle.

The project focuses on real-world telecom business rules and clean backend design.

---

## 📌 Setup
Create a .env file with variables

- DB_URL=jdbc:postgresql://localhost:5432/db_name
- DB_USERNAME=username ,
- DB_PASSWORD=password

---
## 🧱 Tech Stack
- Java 17
- Spring Boot
- Spring Web
- Spring Security
- JWT Authentication (planned)
- JPA / Hibernate (planned)
- PostgreSQL (planned)
- Maven

---

## 📦 Core Modules
- Customer Management
- Subscription Lifecycle Management
- Plan Management (Prepaid / Postpaid)
- Usage Tracking
- Billing Engine

---

## 🗄️ Database Design (Conceptual)

### customer
- id (PK)
- name
- email
- mobile_number
- kyc_status (PENDING, VERIFIED)
- status (ACTIVE, SUSPENDED)
- created_at

---

### subscription
- id (PK)
- customer_id (FK)
- msisdn (phone number)
- plan_id (FK)
- type (PREPAID, POSTPAID)
- status (NEW, ACTIVE, SUSPENDED, TERMINATED)
- activation_date
- expiry_date

---

### plan
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

### usage_record
- id (PK)
- subscription_id (FK)
- usage_type (DATA, CALL, SMS)
- units
- usage_date

---

### bill
- id (PK)
- subscription_id (FK)
- billing_month
- total_amount
- status (GENERATED, PAID, OVERDUE)
- generated_date

---

## 🔗 Entity Relationships
Customer     1 ---- * Subscription  
Plan         1 ---- * Subscription  
Subscription 1 ---- * Usage_Record  
Subscription 1 ---- * Bill

---

## 🔄 State Machines

### Subscription Lifecycle
NEW → ACTIVE → SUSPENDED → TERMINATED

### Bill Lifecycle
GENERATED → PAID → OVERDUE

---

## 🔐 Security (Planned)
- Spring Security
- JWT-based authentication
- Role-based authorization:
    - ADMIN
    - SUPPORT
    - CUSTOMER

---

## 📂 Documentation
Additional documentation is available in the `docs/` folder:
- docs/architecture.md
- docs/workflow.md

---

## 🚧 Project Status
- Backend setup completed
- Database design finalized
- API design in progress
- JPA & PostgreSQL integration pending

---

## 👨‍💻 Author
Rohit Kumar | Aryan Kodinya
