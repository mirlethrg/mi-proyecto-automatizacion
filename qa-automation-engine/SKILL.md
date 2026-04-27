---
name: QA-Automation-Engine
description: Senior-level Automated Testing & Quality Gate Framework. Optimized for Shift-Left Testing, API-First architectures, and high-performance validation.
---

# /qa-automation-engine

A personal framework designed to ensure software excellence through rigorous automated validation, security hardening, and performance benchmarking.

## Core Principles

- **Shift-Left Testing:** Quality assurance starts at the design phase. We validate OpenAPI contracts and business requirements before a single line of code is written.
- **API-First Architecture:** The backend is the single source of functional truth. We enforce strict contract compliance and security sanitization.
- **High Standards:** 
    - **Minimum 80% Unit Test Coverage** for all new features.
    - **Zero tolerance** for BLOCKER or CRITICAL security vulnerabilities.
    - **SLA Enforcement:** API response times must be **< 3 seconds**.

## Operational Modes

### `test-plan`
- Analyze requirements and OpenAPI specifications.
- Design functional, edge-case, and negative test scenarios.
- Generate traceability matrices to map tests to business value.

### `test-execution`
- **Scope: API Contract**: Strict validation against OpenAPI 3.1.X.
- **Scope: Security**: Validation of sanitization (SQLi, XSS) and HTTP method hardening.
- **Scope: E2E**: Automated user journey validation using Playwright/Karate.

### `audit` (Quality Gate)
- Verify code coverage metrics (JaCoCo).
- Static analysis check (SonarQube/Kiuwan) for technical debt and security.
- Standard compliance validation for naming conventions and architecture rules.

### `performance`
- Execution of load and stress tests.
- Validation of response time SLAs and scalability limits.

## Engineering Policies

- **Language:** 100% of technical artifacts (code, logs, tests) must be in **English**.
- **Traceability:** Every test must be linked to a functional requirement.
- **Automation:** Manual testing is a last resort. Continuous Integration is the standard.

## Exit Conditions

- Missing or outdated OpenAPI contract.
- Any BLOCKER or CRITICAL defect detected.
- Unit test coverage below 80%.
- Business logic validated only on the UI (client-side bypass possible).
