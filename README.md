🚀 Lean DevSecOps CI/CD Pipeline

Shift-Left Security in a Java-Based CI/CD Workflow

📌 Overview

This project demonstrates a Lean DevSecOps CI/CD pipeline that integrates shift-left security into the software delivery lifecycle using industry-standard open-source tools.

The goal is not just automation, but to evaluate real-world trade-offs between security coverage and pipeline performance by embedding security checks early and enforcing them pragmatically.

🧠 Problem Statement

Traditional CI/CD pipelines often treat security as a late-stage activity, which:

Allows vulnerable code and dependencies to reach production

Increases remediation cost

Slows down delivery when issues are found late

This project addresses that gap by embedding security directly into the CI pipeline.

🏗️ Architecture Overview

Pipeline Flow:

Code pushed to GitHub

CI triggered via GitHub Actions

Build & test Java application

Static Application Security Testing (SAST)

Software Composition Analysis (SCA)

Docker image build

Container image security scanning

Centralised security reporting

The pipeline runs on every push and pull request to ensure continuous security validation.

🔐 Security Layers Implemented
Layer	Tool	Purpose
Source Code	SonarCloud	Detect insecure coding patterns (SAST)
Dependencies	Snyk	Identify vulnerable third-party libraries (SCA)
Container Image	Trivy	Scan OS & runtime vulnerabilities
Reporting	GitHub Code Scanning	Centralised vulnerability visibility
⚙️ Tech Stack

CI/CD: GitHub Actions

Language: Java (Spring Boot, Maven)

Security: SonarCloud, Snyk, Trivy

Containerisation: Docker

Security Reporting: SARIF + GitHub Security Dashboard

🧪 Key Features

✅ Automated build and test execution

✅ Shift-left security with layered scanning

✅ Risk-based enforcement (blocking only high-severity findings)

✅ Centralised vulnerability reporting

✅ Docker-based environment consistency

✅ Reproducible CI/CD workflows

📊 Key Learnings & Trade-Offs

Most critical vulnerabilities originated from dependencies and container images, not application code

Security automation increased pipeline runtime but remained operationally acceptable

Selective enforcement provided the best balance between security and delivery speed

Shift-left security significantly improved visibility without blocking developer productivity

📁 Repository Structure
.
├── .github/workflows/        # GitHub Actions CI/CD pipeline
├── src/                      # Java Spring Boot application
├── Dockerfile                # Container build definition
├── pom.xml                   # Maven dependencies & plugins
└── README.md

🔗 Related Resources

CI/CD pipeline definitions: .github/workflows

Security reports: GitHub → Security → Code scanning

Academic case study: MSc Advanced Computer Science Final Project

🎯 Why This Project Matters

This project reflects real DevSecOps practices, not just tooling:

Practical CI/CD design

Security embedded early, not bolted on

Balanced enforcement strategy

Industry-aligned tools and workflows

📬 Contact

If you’d like to discuss DevSecOps, CI/CD security, or this project:

Riyan Ahmed
GitHub: https://github.com/riyan-ahmed

LinkedIn: https://www.linkedin.com/in/riyan-ahmed-devops
