---
layout: cs535default
---

## Assignment: Readers-Writers

This assignment is **individual**.

Implement a readers-writers lock using spinning.

There is a blocking version of the readers-writers lock
in Section 8.3.1 of the book. Implement the same functionality
without relying on any existing lock implementation.
Instead, use atomic operations (e.g. CAS, `getAndIncrement`, etc.)

_Suggested idea:_
Use an `AtomicMarkableReference`.
Use the mark bit to denote whether there is a writer
inside or not.
For the reference part, use an `Integer` to denote the
number of readers inside.
