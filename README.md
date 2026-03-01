# We4Lead Backend

Spring Boot REST API for **secure school incident reporting** and administrative management.

**We4Lead** enables schools to:
- Manage institutions and users 
- Allow students, teachers and staff to submit and track reports on harassment, discrimination, violence and other serious incidents
- Ensure strong **security** and **privacy** throughout the process

## Features

- Incident report submission, status tracking & management  
  (harassment · discrimination · violence · misconduct …)
- **JWT authentication** powered by **Supabase Auth**
- Role-based access control (RBAC)
- Full support for **PostgreSQL** (local or Supabase hosted)

## Tech Stack

| Layer              | Technology                          |
|--------------------|-------------------------------------|
| Language           | Java 17+                            |
| Framework          | Spring Boot 3.x                     |
| Security           | Spring Security + Supabase JWT      |
| Database           | PostgreSQL                          |
| Build Tool         | Maven 3.9+                          |

## Prerequisites

- Java 17+
- Maven 3.9+
- PostgreSQL 14+ (local) **or** a Supabase project

## Quick Start

```bash
# 1. Clone the repository
git clone https://github.com/ahmedksont/we4lead_backend.git
cd we4lead_backend

# 2. Build the project (skip tests for speed)
mvn clean package -DskipTests

# 3. Run in development mode
mvn spring-boot:run -Dspring-boot.run.profiles=dev

# ── OR ── run the generated JAR
java -jar target/backend-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev
# backend_we4lead
