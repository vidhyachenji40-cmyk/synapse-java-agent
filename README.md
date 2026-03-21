# Synapse AI Insight Agent 🚀

An enterprise-grade **Java Spring Boot** microservice designed to orchestrate and optimize **Azure Synapse Analytics** environments. This agent automatically scans data lake metadata to generate high-performance Scala/Spark scripts for massive data partitioning.

---

## 🏗️ Technical Stack
* **Backend:** Java 17, Spring Boot 3.x
* **Database:** H2 In-Memory (for metadata simulation)
* **DevOps:** Docker, GitHub Actions (CI/CD)
* **Cloud Logic:** Azure Synapse, Scala/Spark generation

## 🚀 Features
- **Metadata Scanning:** Automatically identifies table structures and row counts via JDBC.
- **AI-Driven Logic:** Generates optimized `OptimizeSynapse.scala` scripts specifically tuned for 5TB+ datasets.
- **Containerized:** Fully Dockerized for deployment to Azure Kubernetes Service (AKS).

---

## 🗺️ Project Analogy: The Walmart Personal Shopper

To understand how these files link together, imagine a **Walmart** the size of a city. This project is the **Personal Shopper** that finds exactly what you need.

| File Name | The Walmart Analogy | Technical Role |
| :--- | :--- | :--- |
| **SynapseApplication.java** | **The Store Opening:** The manager turning on the lights and opening the front doors. | Entry point for the Spring Boot engine. |
| **AgentController.java** | **The Customer Service Desk:** Where you stand and say, "I need a data optimization plan!" | REST API endpoint (`/run-agent`) that accepts requests. |
| **SynapseAgent.java** | **The Personal Shopper:** The expert who knows the aisles and gathers the items. | The Service layer containing the core logic. |
| **synapse_db.mv.db** | **The Store Inventory:** The actual shelves holding all the product data. | H2 Database storing the metadata to be scanned. |
| **OptimizeSynapse.scala** | **The Delivery Receipt:** The custom plan the shopper hands back to you for your 5TB order. | The generated output script for Azure Synapse. |
| **pom.xml** | **The Shopping List:** A list of tools (scanner, cart, badge) the shopper needs to work. | Maven file managing all project dependencies. |
| **Dockerfile** | **The Delivery Truck:** A standard container that lets the shopper work in any city (cloud). | Instructions to package the app for Azure Kubernetes (AKS). |

---

## 🛠️ Getting Started

### Run with Docker
```bash
docker build -t synapse-ai-agent .
docker run -p 8080:8080 synapse-ai-agent
