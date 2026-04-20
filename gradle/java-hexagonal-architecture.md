---
name: java-hexagonal-architecture
description: Enforces Ports & Adapters (Hexagonal) architecture in Java projects, especially those using Temporal SDK. Use when generating or reviewing Java code that must isolate domain logic from Temporal, databases, external APIs, etc. Trigger on "use hexagonal", "ports and adapters", "clean architecture", or when Temporal code is being written.
---

# Java Hexagonal Architecture Skill

## Purpose
Keep the **Domain** pure and isolated. Temporal becomes just one adapter among many.

## Folder Structure (recommended)
src/main/java/com/example/order/
├── domain/                  # Pure DDD entities, aggregates, services (no Temporal!)
│   ├── model/
│   ├── repository/
│   └── service/
├── application/             # Ports + Use Cases
│   └── port/
└── adapter/          # Adapters
    ├── persistence/
    ├── temporal/            # ← Temporal Workflow + Activity adapters
    └── web/
              
text## Core Rules
- **Domain** never imports Temporal, Spring, JPA, etc.
- **Ports** (interfaces) live in `application/port`.
- **Adapters** implement ports (`adapter/`).
- Workflow implementations live in `adapter/temporal`.
- Activities are treated as outgoing ports.

## When to Use with Temporal
- Workflow = Application Service (orchestrator).
- Activities = Outgoing ports (implemented by adapters).
- Temporal Client = Incoming adapter.

Always generate code that respects this layering.`
