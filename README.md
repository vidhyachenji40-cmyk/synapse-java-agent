# Synapse AI Insight Agent 🚀

An enterprise-grade **Java Spring Boot** microservice designed to provide architectural guidance and optimization strategies for **Azure Synapse Analytics**. This agent is powered by **Anthropic Claude 4.5** and is specifically tuned for high-scale data engineering (5TB+ datasets).

## 🏗️ Technical Stack
- **AI Model:** Anthropic Claude Haiku 4.5 (`claude-haiku-4-5-20251001`)
- **Backend:** Java 17, Spring Boot 3.x, Spring AI
- **Frontend:** Responsive HTML5/JS Dashboard
- **Infrastructure:** Docker (Eclipse Temurin JRE 17)

## 🗺️ Project Analogy: The Walmart Architectural Consultant
Imagine a **Walmart** the size of a city. Instead of just finding a box of cereal, you are building a new wing of the store to handle 5 million customers a day. You need a **Senior Architect** to tell you where to put the aisles so people don't get stuck.

| File Name | The Walmart Analogy | Technical Role |
| :--- | :--- | :--- |
| **SynapseApplication.java** | **The Store Opening** | The manager turning on the lights and opening the front doors. |
| **AgentController.java** | **The Consultant's Desk** | The service window where you submit your complex engineering questions. |
| **ConsultantService.java** | **The Master Architect** | The expert (Claude 4.5) who designs the blueprints for your 5TB data "aisles." |
| **synapse-expert-tips.txt** | **The Building Codes** | The internal handbook the architect uses to ensure everything is "to code." |
| **Dockerfile** | **The Prefab Office** | A standard shipping container that lets the architect work at any Walmart location (Cloud). |

## 🌟 Key Features
- **Partitioning Strategies:** Expert advice on `RANGE LEFT/RIGHT` for multi-terabyte tables.
- **Materialized Views:** Automated best practices for distribution (HASH vs. ROUND_ROBIN).
- **T-SQL Generation:** Ready-to-use snippets for Clustered Columnstore Indexing (CCI).
- **Secure Architecture:** Built with environment-based secret management for API keys.

## 🚀 Getting Started

### 1. Prerequisites
- Java 17 or Docker installed.
- An Anthropic API Key exported to your environment (`ANTHROPIC_API_KEY`).

### 2. Run with Docker
```bash
# Build the image
docker build -t synapse-ai-agent .

# Run the container
docker run -p 8080:8080 -e SPRING_AI_ANTHROPIC_API_KEY=$ANTHROPIC_API_KEY synapse-ai-agent
