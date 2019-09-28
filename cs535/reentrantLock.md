---
layout: cs535default
---

## Assignment: A Reentrant Lock

This is an **individual** assignment.

Implement a reentrant lock without relying on the
existence of another lock implementation.
You will want to use the CAS operation for this.
Hint: Start from a simple lock implementation, such as the TASLock,
and use an `AtomicReference` to keep track of the
owner thread.


