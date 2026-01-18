# Team Workflow & Contribution Guide

## 1. Branch Strategy
- main → stable code
- feature/* → new features

Example:
feature/customer-api
feature/subscription-entity

---

## 2. Work Allocation
- One person works on ONE module at a time
- No parallel changes in same package

---

## 3. Coding Rules
- No direct DB calls from controllers
- Service layer must contain business logic
- No entity exposure in APIs (DTOs later)

---

## 4. Commit Rules
- Small, meaningful commits
- Example messages:
    - "Add customer entity"
    - "Implement subscription state validation"

---

## 5. Communication Rule
- If a change affects schema or states → discuss first
- Do NOT silently change core logic
