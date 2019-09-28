---
layout: cs535default
---

## Assignment: Penguin Hat Swap

**Note:** This is an **individual** assignment.

**Due:** Oct. 7th, Friday, 23:55.

Suppose a situation where N penguins are in a circular
queue, where a penguin can access (i.e. can see and touch)
the penguin standing in front of it, and not the others.
For example, see the picture below but ignore the red chair.

![](img/penguins.jpg)

Assume that each penguin wears a hat.
Each penguin wants to continously swap hats
with the penguin in front of it.
A hat can be held by only one penguin
at a time.

Write concurrent Java code that satisfies
mutual exclusion (no two penguins hold the same hat simultaneously),
and liveness (no deadlock or livelock).
Avoid obviously non-optimal solutions (e.g. do not use a central lock).

[Here is a starting point](HatSwap.java) for your implementation.
