---
layout: cs222default
---

## Assignment 5.2 - Queens on a Chessboard
**Due:** May 21st, Wednesday, **09:00**. (**morning!!!**)  
**Language:** Java  
**Goal:** Implement the N-Queens problem for 
which you wrote test cases.
Also review the code of a friend of yours.

### Reading:
Agile Mantra: Make it work. Make it right. Make it fast.

+ <http://c2.com/cgi/wiki?MakeItWorkMakeItRightMakeItFast>
+ <http://agileinaflash.blogspot.com/2009/03/make-it-work-make-it-right-make-it-fast.html> 
+ <http://henriquebastos.net/2009/08/18/the-make-it-work-make-it-right-make-it-fast-misconception/>

### Task
You will write a console-driven program that will prompt the user to enter the 
size of the board. 
Then, for that size, it will print out all the possible solutions.
Below is a possible way you can display a board (this board also happens to 
be an 8-queen solution):

```
    +-+-+-+-+-+-+-+-+
    | | | | | | | |Q|
    +-+-+-+-+-+-+-+-+
    | | | |Q| | | | |
    +-+-+-+-+-+-+-+-+
    |Q| | | | | | | |
    +-+-+-+-+-+-+-+-+
    | | |Q| | | | | |
    +-+-+-+-+-+-+-+-+
    | | | | | |Q| | |
    +-+-+-+-+-+-+-+-+
    | |Q| | | | | | |
    +-+-+-+-+-+-+-+-+
    | | | | | | |Q| |
    +-+-+-+-+-+-+-+-+
    | | | | |Q| | | |
    +-+-+-+-+-+-+-+-+
```

You must use a somewhat "smart" algorithm; that is, no brute-force solutions.
Note that for n=8, there are 4,426,165,368 
possible arrangements of 8 queens on the board (64 choose 8).

You are recommended to follow the class outlines given to you in the previous 
assignment; however, you are free to add/remove new methods and classes, 
or change the signatures of existing ones. For instance, think about whether
`List<Board>` instead of `Set<Board>` would be a better choice.

Remember that it is very important to have short methods that have well-defined
responsibilities and are consistent at the level of abstraction they have.

### The process
Follow the TDD cycle:

1. Write test cases.
2. Implement the methods for which the tests fail. Make the tests pass.
3. Refactor the code.
4. Go to step 1.

During this process, as you add new methods and new tests, commit your code
to SVN. It is a common practice to commit whenever you have new stuff. 
(But, never commit code that does NOT compile)

**Comment** your code whenever needed, and **comment your test cases**
to explain their purpose, if this is not apparent from the method name.

When writing your functions always keep in mind writing 
them so that they are easy to test. 
The more focused each individual function is, 
the easier it will be to test, and the more correct your code will be.
Modularity is key to unit-testing.
It may even be a good idea to split your library into multiple classes 
depending on the data structure you use as an internal representation.

### Grading
+ Correctly calculating the queens problem. (10)
+ Quality and coverage of test cases. (you may have to add new cases to those from last assignment) (4)
+ Clean code. (10)
+ Preparedness for reviewing your peer's code. (4)
