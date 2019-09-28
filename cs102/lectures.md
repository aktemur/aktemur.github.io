---
layout: cs102default
---

### Important Dates (tentative):
* Midterm Exam 1: 15.03.2018
* Midterm Exam 2: 19.04.2018
* Final Exam: TBD
* Withdrawal week: 26-30.03.2018 

---

## Code

Public repository: <https://github.com/aktemur/CS102>

---

## Lectures

### Week 01
* Download and install [IntelliJ IDEA](https://www.jetbrains.com/idea/).
* Intro to objects and classes
  - [v0](http://www.pythontutor.com/java.html#code=public%20class%20AccountTest%20%7B%0A%20%20%20%20public%20static%20void%20main%28String%5B%5D%20args%29%20%7B%0A%20%20%20%20%20%20%20%20int%20account1number%20%3D%201%3B%0A%20%20%20%20%20%20%20%20double%20account1balance%20%3D%20100%3B%0A%20%20%20%20%20%20%20%20String%20account1currency%20%3D%20%22TL%22%3B%0A%20%20%20%20%20%20%20%20%0A%20%20%20%20%20%20%20%20int%20account2number%20%3D%202%3B%0A%20%20%20%20%20%20%20%20double%20account2balance%20%3D%20200%3B%0A%20%20%20%20%20%20%20%20String%20account2currency%20%3D%20%22USD%22%3B%0A%20%20%20%20%20%20%20%20%0A%20%20%20%20%20%20%20%20System.out.println%28%22Account%20%22%20%2B%20account1number%20%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%2B%20%22%20has%20%22%20%2B%20account1balance%20%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%2B%20%22%20%22%20%2B%20account1currency%20%2B%20%22.%22%29%3B%0A%20%20%20%20%20%20%20%20System.out.println%28%22Account%20%22%20%2B%20account2number%20%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%2B%20%22%20has%20%22%20%2B%20account2balance%20%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%2B%20%22%20%22%20%2B%20account2currency%20%2B%20%22.%22%29%3B%0A%20%20%20%20%20%20%20%20%0A%20%20%20%20%20%20%20%20//%20Deposit%2050TL%20into%20account%201%0A%20%20%20%20%20%20%20%20account1balance%20%3D%20account1balance%20%2B%2050%3B%0A%20%20%20%20%20%20%20%20%0A%20%20%20%20%20%20%20%20//%20Deposit%20300%20USD%20into%20account%202%0A%20%20%20%20%20%20%20%20account2balance%20%3D%20account2balance%20%2B%20300%3B%0A%20%20%20%20%20%20%20%20%0A%20%20%20%20%20%20%20%20System.out.println%28%22Account%20%22%20%2B%20account1number%20%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%2B%20%22%20has%20%22%20%2B%20account1balance%20%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%2B%20%22%20%22%20%2B%20account1currency%20%2B%20%22.%22%29%3B%0A%20%20%20%20%20%20%20%20System.out.println%28%22Account%20%22%20%2B%20account2number%20%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%2B%20%22%20has%20%22%20%2B%20account2balance%20%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%2B%20%22%20%22%20%2B%20account2currency%20%2B%20%22.%22%29%3B%0A%20%20%20%20%7D%0A%7D&cumulative=false&heapPrimitives=true&mode=edit&origin=opt-frontend.js&py=java&rawInputLstJSON=%5B%5D&textReferences=false),
    [v1](http://www.pythontutor.com/java.html#code=class%20Account%20%7B%0A%20%20%20%20int%20number%3B%0A%20%20%20%20double%20balance%3B%0A%20%20%20%20String%20currency%3B%0A%7D%0A%0Apublic%20class%20AccountTest%20%7B%0A%20%20%20%20public%20static%20void%20main%28String%5B%5D%20args%29%20%7B%0A%20%20%20%20%20%20%20%20Account%20account1%20%3D%20new%20Account%28%29%3B%0A%20%20%20%20%20%20%20%20account1.number%20%3D%201%3B%0A%20%20%20%20%20%20%20%20account1.balance%20%3D%20100%3B%0A%20%20%20%20%20%20%20%20account1.currency%20%3D%20%22TL%22%3B%0A%20%20%20%20%20%20%20%20%0A%20%20%20%20%20%20%20%20Account%20account2%20%3D%20new%20Account%28%29%3B%0A%20%20%20%20%20%20%20%20account2.number%20%3D%202%3B%0A%20%20%20%20%20%20%20%20account2.balance%20%3D%20200%3B%0A%20%20%20%20%20%20%20%20account2.currency%20%3D%20%22USD%22%3B%0A%20%20%20%20%20%20%20%20%0A%20%20%20%20%20%20%20%20System.out.println%28%22Account%20%22%20%2B%20account1.number%20%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%2B%20%22%20has%20%22%20%2B%20account1.balance%20%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%2B%20%22%20%22%20%2B%20account1.currency%20%2B%20%22.%22%29%3B%0A%20%20%20%20%20%20%20%20System.out.println%28%22Account%20%22%20%2B%20account2.number%20%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%2B%20%22%20has%20%22%20%2B%20account2.balance%20%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%2B%20%22%20%22%20%2B%20account2.currency%20%2B%20%22.%22%29%3B%0A%20%20%20%20%20%20%20%20%0A%20%20%20%20%20%20%20%20//%20Deposit%2050TL%20into%20account%201%0A%20%20%20%20%20%20%20%20account1.balance%20%3D%20account1.balance%20%2B%2050%3B%0A%20%20%20%20%20%20%20%20%0A%20%20%20%20%20%20%20%20//%20Deposit%20300%20USD%20into%20account%202%0A%20%20%20%20%20%20%20%20account2.balance%20%3D%20account2.balance%20%2B%20300%3B%0A%20%20%20%20%20%20%20%20%0A%20%20%20%20%20%20%20%20System.out.println%28%22Account%20%22%20%2B%20account1.number%20%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%2B%20%22%20has%20%22%20%2B%20account1.balance%20%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%2B%20%22%20%22%20%2B%20account1.currency%20%2B%20%22.%22%29%3B%0A%20%20%20%20%20%20%20%20System.out.println%28%22Account%20%22%20%2B%20account2.number%20%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%2B%20%22%20has%20%22%20%2B%20account2.balance%20%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%2B%20%22%20%22%20%2B%20account2.currency%20%2B%20%22.%22%29%3B%0A%20%20%20%20%7D%0A%0A%7D&cumulative=false&heapPrimitives=true&mode=edit&origin=opt-frontend.js&py=java&rawInputLstJSON=%5B%5D&textReferences=false),
    [v2](http://www.pythontutor.com/java.html#code=class%20Account%20%7B%0A%20%20%20%20int%20number%3B%0A%20%20%20%20double%20balance%3B%0A%20%20%20%20String%20currency%3B%0A%20%20%20%20%0A%20%20%20%20public%20void%20deposit%28double%20d%29%20%7B%0A%20%20%20%20%20%20%20%20balance%20%3D%20balance%20%2B%20d%3B%0A%20%20%20%20%7D%0A%7D%0A%0Apublic%20class%20AccountTest%20%7B%0A%20%20%20%20public%20static%20void%20main%28String%5B%5D%20args%29%20%7B%0A%20%20%20%20%20%20%20%20Account%20account1%20%3D%20new%20Account%28%29%3B%0A%20%20%20%20%20%20%20%20account1.number%20%3D%201%3B%0A%20%20%20%20%20%20%20%20account1.balance%20%3D%20100%3B%0A%20%20%20%20%20%20%20%20account1.currency%20%3D%20%22TL%22%3B%0A%20%20%20%20%20%20%20%20%0A%20%20%20%20%20%20%20%20Account%20account2%20%3D%20new%20Account%28%29%3B%0A%20%20%20%20%20%20%20%20account2.number%20%3D%202%3B%0A%20%20%20%20%20%20%20%20account2.balance%20%3D%20200%3B%0A%20%20%20%20%20%20%20%20account2.currency%20%3D%20%22USD%22%3B%0A%20%20%20%20%20%20%20%20%0A%20%20%20%20%20%20%20%20System.out.println%28%22Account%20%22%20%2B%20account1.number%20%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%2B%20%22%20has%20%22%20%2B%20account1.balance%20%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%2B%20%22%20%22%20%2B%20account1.currency%20%2B%20%22.%22%29%3B%0A%20%20%20%20%20%20%20%20System.out.println%28%22Account%20%22%20%2B%20account2.number%20%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%2B%20%22%20has%20%22%20%2B%20account2.balance%20%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%2B%20%22%20%22%20%2B%20account2.currency%20%2B%20%22.%22%29%3B%0A%20%20%20%20%20%20%20%20%0A%20%20%20%20%20%20%20%20//%20Deposit%2050TL%20into%20account%201%0A%20%20%20%20%20%20%20%20account1.deposit%2850%29%3B%0A%20%20%20%20%20%20%20%20%0A%20%20%20%20%20%20%20%20//%20Deposit%20300%20USD%20into%20account%202%0A%20%20%20%20%20%20%20%20account2.deposit%28300%29%3B%0A%20%20%20%20%20%20%20%20%0A%20%20%20%20%20%20%20%20System.out.println%28%22Account%20%22%20%2B%20account1.number%20%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%2B%20%22%20has%20%22%20%2B%20account1.balance%20%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%2B%20%22%20%22%20%2B%20account1.currency%20%2B%20%22.%22%29%3B%0A%20%20%20%20%20%20%20%20System.out.println%28%22Account%20%22%20%2B%20account2.number%20%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%2B%20%22%20has%20%22%20%2B%20account2.balance%20%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%2B%20%22%20%22%20%2B%20account2.currency%20%2B%20%22.%22%29%3B%0A%20%20%20%20%7D%0A%0A%7D&cumulative=false&heapPrimitives=true&mode=edit&origin=opt-frontend.js&py=java&rawInputLstJSON=%5B%5D&textReferences=false),
    [v3](http://www.pythontutor.com/java.html#code=class%20Account%20%7B%0A%20%20%20%20int%20number%3B%0A%20%20%20%20double%20balance%3B%0A%20%20%20%20String%20currency%3B%0A%20%20%20%20%0A%20%20%20%20public%20void%20deposit%28double%20d%29%20%7B%0A%20%20%20%20%20%20%20%20balance%20%3D%20balance%20%2B%20d%3B%0A%20%20%20%20%7D%0A%20%20%20%20%0A%20%20%20%20public%20void%20report%28%29%20%7B%0A%20%20%20%20%20%20%20%20System.out.println%28%22Account%20%22%20%2B%20number%20%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%2B%20%22%20has%20%22%20%2B%20balance%20%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%2B%20%22%20%22%20%2B%20currency%20%2B%20%22.%22%29%3B%0A%20%20%20%20%7D%0A%7D%0A%0Apublic%20class%20AccountTest%20%7B%0A%20%20%20%20public%20static%20void%20main%28String%5B%5D%20args%29%20%7B%0A%20%20%20%20%20%20%20%20Account%20account1%20%3D%20new%20Account%28%29%3B%0A%20%20%20%20%20%20%20%20account1.number%20%3D%201%3B%0A%20%20%20%20%20%20%20%20account1.balance%20%3D%20100%3B%0A%20%20%20%20%20%20%20%20account1.currency%20%3D%20%22TL%22%3B%0A%20%20%20%20%20%20%20%20%0A%20%20%20%20%20%20%20%20Account%20account2%20%3D%20new%20Account%28%29%3B%0A%20%20%20%20%20%20%20%20account2.number%20%3D%202%3B%0A%20%20%20%20%20%20%20%20account2.balance%20%3D%20200%3B%0A%20%20%20%20%20%20%20%20account2.currency%20%3D%20%22USD%22%3B%0A%20%20%20%20%20%20%20%20%0A%20%20%20%20%20%20%20%20account1.report%28%29%3B%0A%20%20%20%20%20%20%20%20account2.report%28%29%3B%0A%20%20%20%20%20%20%20%20%0A%20%20%20%20%20%20%20%20//%20Deposit%2050TL%20into%20account%201%0A%20%20%20%20%20%20%20%20account1.deposit%2850%29%3B%0A%20%20%20%20%20%20%20%20%0A%20%20%20%20%20%20%20%20//%20Deposit%20300%20USD%20into%20account%202%0A%20%20%20%20%20%20%20%20account2.deposit%28300%29%3B%0A%20%20%20%20%20%20%20%20%0A%20%20%20%20%20%20%20%20account1.report%28%29%3B%0A%20%20%20%20%20%20%20%20account2.report%28%29%3B%0A%20%20%20%20%7D%0A%0A%7D&cumulative=false&heapPrimitives=true&mode=edit&origin=opt-frontend.js&py=java&rawInputLstJSON=%5B%5D&textReferences=false),
    [v3 (with aliasing)](http://www.pythontutor.com/java.html#code=class%20Account%20%7B%0A%20%20%20%20int%20number%3B%0A%20%20%20%20double%20balance%3B%0A%20%20%20%20String%20currency%3B%0A%20%20%20%20%0A%20%20%20%20public%20void%20deposit%28double%20d%29%20%7B%0A%20%20%20%20%20%20%20%20balance%20%3D%20balance%20%2B%20d%3B%0A%20%20%20%20%7D%0A%20%20%20%20%0A%20%20%20%20public%20void%20report%28%29%20%7B%0A%20%20%20%20%20%20%20%20System.out.println%28%22Account%20%22%20%2B%20number%20%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%2B%20%22%20has%20%22%20%2B%20balance%20%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%2B%20%22%20%22%20%2B%20currency%20%2B%20%22.%22%29%3B%0A%20%20%20%20%7D%0A%7D%0A%0Apublic%20class%20AccountTest%20%7B%0A%20%20%20%20public%20static%20void%20main%28String%5B%5D%20args%29%20%7B%0A%20%20%20%20%20%20%20%20Account%20account1%20%3D%20new%20Account%28%29%3B%0A%20%20%20%20%20%20%20%20account1.number%20%3D%201%3B%0A%20%20%20%20%20%20%20%20account1.balance%20%3D%20100%3B%0A%20%20%20%20%20%20%20%20account1.currency%20%3D%20%22TL%22%3B%0A%20%20%20%20%20%20%20%20%0A%20%20%20%20%20%20%20%20Account%20account2%20%3D%20new%20Account%28%29%3B%0A%20%20%20%20%20%20%20%20account2.number%20%3D%202%3B%0A%20%20%20%20%20%20%20%20account2.balance%20%3D%20200%3B%0A%20%20%20%20%20%20%20%20account2.currency%20%3D%20%22USD%22%3B%0A%20%20%20%20%20%20%20%20%0A%20%20%20%20%20%20%20%20account1.report%28%29%3B%0A%20%20%20%20%20%20%20%20account2.report%28%29%3B%0A%20%20%20%20%20%20%20%20%0A%20%20%20%20%20%20%20%20account1.deposit%2850%29%3B%0A%20%20%20%20%20%20%20%20%0A%20%20%20%20%20%20%20%20account2%20%3D%20account1%3B%0A%20%20%20%20%20%20%20%20%0A%20%20%20%20%20%20%20%20account2.deposit%28300%29%3B%0A%20%20%20%20%20%20%20%20%0A%20%20%20%20%20%20%20%20account1.report%28%29%3B%0A%20%20%20%20%20%20%20%20account2.report%28%29%3B%0A%20%20%20%20%7D%0A%0A%7D&cumulative=false&heapPrimitives=true&mode=edit&origin=opt-frontend.js&py=java&rawInputLstJSON=%5B%5D&textReferences=false)

* [Annotated notes](data/01_bankAccount_annotated.pdf)
* [ACM library vs Java SDK](data/ACM-vs-Java_SDK.pdf)
* Lab 01 exercise

### Week 02
* Constructors, function overloading.
* Access modifiers
* `get`/`set` methods.
* `toString()` method.


### Week 03
* What is `this`?

### Week 04
* Defining a collection of objects (ArrayList).

### Week 05
* Inheritance

### Week 06
* Inheritance cont'd.
* **!!! EXAM 1 !!!**

### Week 07
* Objects and memory.
* Abstract classes and methods.

### Week 08
* Interfaces ([example](data/animals.png))
* Static fields and methods ([example](https://goo.gl/X7rd9y))

### Week 09
* UML
* GUI programming

### Week 10
* ActionListener, MouseListener, MouseMotionListener, MouseAdapter
* [Project](project.html) is announced.

### Week 11
* Object-oriented programming exercise: Snake Game.

### Week 12
* Extending the Snake Game.
* General review.
* **!!! EXAM 2 !!!**

### Week 13
* MVC

### Week 14
* Exceptions
* Inner and anonymous classes

### Week 15
* More about exceptions
* Snakes and ladders game

