---
layout: cs535default
---

## Assignment: Executor Service

**Goal:** Implement your own `ExecutorService` and `Future`s.
Let's call these `CoolExecutorService` and `CoolFuture`.

`CoolExecutorService` shall have a pool of a number of
threads. It should be possible to submit
`Callable<T>` tasks to the service, and get a
`CoolFuture<T>` object that has a blocking `get()`
method.

**Suggestion:**
In `CoolExecutorService`, keep a list of
tasks. Whenever a thread is free, assign a task from the
list to that thread. Note that the list structure you keep
has to be thread-safe; tasks may be submitted simultaneously.
You can use Java library's concurrent collection objects.
To implement `CoolFuture`'s `get` method,
use the `wait`/`notify` mechanism. This requires
acquiring/releasing locks, which is expensive,
but that's OK.

