---
layout: cs222default
---

# Chessboard, Part I
**Due:** May 7th, Wednesday, **09:00**. (**morning!!!**)  
**Language:** Java (with JUnit)  
**Goal:** Practice Test-Driven-Development by writing unit tests.

### Prologue
Read [Wikipedia article on Test-Driven Development](http://en.wikipedia.org/wiki/Test-driven_development).

Read Clean Code Chapter 9: Unit Tests, Chapter 15: JUnit.

### Code Reading
In this assignment, you will be responsible for another student's code.
You must read the student's code **before** the discussion and come ready with
a report that answers the following questions:

+ Are there any test cases that make your peer's test suite
  better than yours, in terms of coverage?
+ Are there any test cases that make your test suite
  better than your peer's, in terms of coverage?
+ What suggestions would you give to your peer to improve the cleanliness of their code?

Your discussion session moderator will send you your peer's code via email.


### The Problem: Queens on a Chessboard
This is a classic computer science problem that asks 
the configurations that you can create such that _n_ queens occupy _n_ distinct spots 
on an _n_x_n_ by chess board such that no two queens can attack each other. 
This means that no two queens can share a row, a column, or a diagonal. 
There are solutions for all natural _n_ except 2 and 3. 
Play the game below to get a feel for how it works:  
<http://www.coolmath4kids.com/math_puzzles/Logic-eightqueens/index.html>

For some extra background information, it may help to read  
<https://en.wikipedia.org/wiki/Eight_queens_puzzle>

Your task for this week is to write test cases for code that doesn't exist yet.


### Test cases
Write test cases for the following class outlines.

```java
  class Board
    Board(int dimension)
    void placePiece(int x, int y, Piece piece)
    Piece getPieceAt(int x, int y)
    boolean isValid() // No piece can attack another?
    Set<Piece> getPieces()
    String toString()

  abstract class Piece
    abstract boolean canAttack(int x, int y)
    int getX()
    int getY()
    void setX(int x)
    void setY(int y)
    String toString()

  class Queen extends Piece
    boolean canAttack(int x, int y)

  abstract class PuzzleSolver
    abstract Set<Board> getAllSolutions()

  class NQueensSolver extends PuzzleSolver
    NQueensSolver(int n)
```

In order for your test cases to compile, you will have to create
stub classes, of course.
That is, write empty classes with empty methods. 
Add bogus return values where necessary, such as false for a boolean method, 
0 for an int method, null for a method that returns an object, etc.

Good testing requires you to test for the unexpected. 
Every function should have _at least_ one test. 
However to get full credit,
you should write tests which cover all corner cases and other possibilities 
that your library may eventually encounter. 

When writing your functions always keep in mind writing them so that they are easy to test. 
The more focused each individual function is, 
the easier it will be to test, and the more correct your code will be.

### JUnit
In the lecture, we covered a case study with JUnit and Eclipse.
You may find the source code at the <a href="resources.php">Resources</a> page.

### Things you should test for
You should test for several things to ensure full coverage:

+ successful construction of objects</li>
+ each method an object has
  - usual use cases
  - corner cases

The usual use cases for each method should be straightforward to come up with. 
The corner cases will be tougher, 
and you will only receive full testing points 
if you have extensive corner case coverage.

### Abstract classes
Hmm, abstract classes cannot be instantiated.
So, how do you write test cases for abstract classes?

### Grading
+ Coverage of test cases (10)
+ Code quality (8)
+ Preparedness for discussing your peer's code (5)

