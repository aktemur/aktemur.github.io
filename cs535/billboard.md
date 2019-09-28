---
layout: cs535default
---

## Assignment: Concurrent Billboard

This is an **individual** assignment.

Consider the following problem:
We have a big billboard consisting of several letter signs.
A writer changes the billboard sign by replacing and/or adding
signs.
A reader reads the letter signs one by one.
Readers and writers process the signs
from left to right.
It is important that the readers do not read
a mix of old/new messages.

For instance, in the following program,
no caution is taken to synchronize readers and writers.
Therefore, readers sometimes read a mixtures of two different messages.

```java
class Sign {
    private char letter;
    
    public Sign(char c) {
        // creating a letter sign is not cheap
        try {
            Thread.sleep(10);
        } catch(InterruptedException e) {}
        letter = c;
    }
    
    public char getLetter() {
        // reading the letter sign is not cheap
        try {
            Thread.sleep(2);
        } catch(InterruptedException e) {}
        return letter;
    }
}

class Billboard {
    private final int LENGTH = 12;
    private Sign[] signs = new Sign[LENGTH];
    
    public void write(String message) {
        if (message.length() != signs.length) {
            throw new IllegalArgumentException("Message length must be " + signs.length);
        }
        for(int i = 0; i < signs.length; i++) {
            Sign newSign = new Sign(message.charAt(i));
            signs[i] = newSign;
        }
    }
    
    public String read() {
        String message = "";
        for(int i = 0; i < signs.length; i++) {
            message += signs[i].getLetter();
        }
        return message;
    }
}

class Writer extends Thread {
    private Billboard bb;
    
    public Writer(Billboard bb) {
        this.bb = bb;
    }

    public void run() {
        while(true) {
            bb.write("WASH THE DOG");
            try {
                sleep(50);
            } catch(InterruptedException e) {}
            bb.write("SELL THE CAR");
            try {
                sleep(50);
            } catch(InterruptedException e) {}
        }
    }
}

class Reader extends Thread {
    private Billboard bb;
    
    public Reader(Billboard bb) {
        this.bb = bb;
    }

    public void run() {
        while(true) {
            String message = bb.read();
            System.out.println("Message: " + message);
            try {
                sleep(50);
            } catch(InterruptedException e) {}
        }
    }
}

public class BillboardTest {
    public static void main(String[] args) throws InterruptedException {
        Billboard bb = new Billboard();

        // Sequential test
        bb.write("WASH THE DOG");
        System.out.println("Message: " + bb.read());
        bb.write("SELL THE CAR");
        System.out.println("Message: " + bb.read());
        System.out.println();

        // Parallel test
        Writer writer1 = new Writer(bb);
        Reader reader1 = new Reader(bb);
        Reader reader2 = new Reader(bb);
        writer1.start();
        reader1.start();
        reader2.start();

        writer1.join();
        reader1.join();
        reader2.join();
    }
}
```

Here is a sample output:

```
$ javac BillboardTest.java
$ java BillboardTest
Message: WASH THE DOG
Message: SELL THE CAR

Message: SELL THE CAR
Message: SELL THE CAR
Message: WASH THE CAR
Message: WASH THE CAR
Message: WASH THE DOG
Message: WASH THE DOG
Message: SELL THE DOG
Message: SELL THE DOG
Message: SELL THE CAR
Message: SELL THE CAR
Message: WELL THE CAR
Message: WELL THE CAR
```

Fix the problems of this code by making the 
`Billboard` object thread-safe using locks.
Your solution should allow multiple readers and
writers to operate on the billboard simultaneously.
Note that a reader or a writer traverses the signs from left to right.
When multiple readers/writers exist,
readers are allowed to pass each other (this is safe),
but writers should not be allowed to pass anybody,
and nobody should be allowed to pass writers.

