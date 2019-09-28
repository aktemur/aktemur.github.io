---
layout: cs535default
---

## Assignment: Lock-free, array-based stack

Below is a faulty implementation of a lock-free stack
based on arrays, taken from Exercise 131.
(Use the code given below; the code in the book
has multiple typos).

```java
import java.util.concurrent.atomic.*;

class FullException extends Exception {}
class EmptyException extends Exception {}

public class DualStackOriginal<T> {
  private class Slot {
    volatile boolean full = false;
    volatile T value = null;
  }
  
  Slot[] stack;
  int capacity;
  private AtomicInteger top = new AtomicInteger(0); // array index
  
  @SuppressWarnings("unchecked")
  public DualStackOriginal(int myCapacity) {
    capacity = myCapacity;
    stack = (Slot []) new Object[capacity];
    for (int i = 0; i < capacity; i++) {
      stack[i] = new Slot();
    }
  }
  
  public void push(T value) throws FullException {
    while (true) {
      int i = top.getAndIncrement();
      if (i > capacity - 1) { // is stack full?
        top.getAndDecrement(); // restore the index
        throw new FullException();
      } else if (i >= 0) { // i in range, slot reserved
        stack[i].value = value;
        stack[i].full = true; //push fulfilled
        return;
      }
      top.getAndDecrement(); // restore the index
    }
  }
  
  public T pop() throws EmptyException {
    while (true) {
      int i = top.getAndDecrement();
      if (i <= 0) { // is stack empty?
        top.getAndIncrement(); // restore the index
        throw new EmptyException();
      } else if (i - 1 < capacity) {
        while (!stack[i-1].full) {}
        T value = stack[i-1].value;
        stack[i-1].full = false;
        return value;
      }
      top.getAndIncrement(); // restore the index
    }
  }
}
```

* What's the problem of this code? What can go wrong?
Explain by giving scenarios.

* Fix the implementation. That is, implement
a bounded, lock-free, array-based stack.

