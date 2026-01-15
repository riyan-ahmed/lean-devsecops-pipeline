# DevSecOps Investigation Journey: An Analytical Case Study of Shift-Left Security in a Java CI/CD Pipeline.

## 📖 Project Overview
This project investigates the trade-offs of **DevSecOps** practices, focusing on the balance between **performance overhead** and **security efficacy** in CI/CD pipelines.  
It provides a practical, empirical case study of "Shift-Left" security by integrating static analysis (SAST) and software composition analysis (SCA) tools into a Spring Boot pipeline.

---

## 🎯 Objectives
- Measure the **cost** (pipeline runtime overhead) of adding security gates.
- Evaluate the **benefit** (ability to detect and block vulnerabilities).
- Provide analytical conclusions on tool reliability, performance trade-offs, and enforcement policies.

---

## 🛠️ Technical Stack
- **Language/Framework**: Java (Spring Boot)
- **Build Tool**: Maven
- **Version Control & CI/CD**: GitHub Actions
- **Security Tools**:
  - SonarQube / SonarCloud (SAST)
  - Snyk (SCA)
  - OWASP Dependency-Check (attempted, failed)

---

## 📊 Experimental Phases

### Phase 1: Baseline Pipeline 
- Built a clean CI/CD pipeline for Spring Boot.
- **Baseline runtime**: 43 seconds.

### Phase 2: Performance Experimentation (Cost)
- **SonarQube (SAST)**: +14s overhead (total 57s).
- **OWASP Dependency-Check (SCA)**: Failed due to NVD API errors.
- **Snyk (SCA)**: +26s overhead (total 1m 23s). Reliable and fast compared to OWASP.

### Phase 3: Efficacy Experimentation (Benefit)
- **SCA Test**: Injected `log4j-core@2.14.1` (Log4Shell vulnerability).  
  → Build failed as expected (`--fail-on=high` policy enforced).
- **SAST Test**: Planted SQL Injection + Hardcoded Password.  
  → SonarCloud flagged issues, Quality Gate failed.

### Phase 4: Fix Cycle (Pass)
- Removed vulnerable dependency (Log4j).  
- Reviewed and remediated SonarCloud hotspots.  
- Corrected compilation/package issues.  
- Final pipeline: **Green ✅**, Quality Gate: **Passed**.

---

## 📌 Key Findings
- **Tool Reliability Matters**: OWASP Dependency-Check proved unstable; Snyk provided consistent results.  
- **Performance Overhead is Acceptable**: ~40s increase justified by catching critical vulnerabilities.  
- **Policy Enforcement is Essential**: Scanners must enforce fail-on policies to block insecure deployments.  
- **Full Cycle Achieved**: Find → Fail → Fix → Pass.

---

## 📂 Repository Structure
