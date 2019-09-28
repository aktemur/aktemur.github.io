---
layout: cs321default
---

## Lectures
### Important Dates (tentative):
* Midterm Exam 1: 26.10.2017
* Midterm Exam 2: 30.11.2017
* Final Exam: **11.01.2018 @ 9:00, in room 237.**
* Withdrawal week: 13-17.11.2017 

---

### 25.09.2017 Monday
* **Task:** [Install the latest version of Ocaml](installing_ocaml.html) on your computer.
* Course intro
  [[2up]](lectures/01_intro-2up.pdf)
  [[4up]](lectures/01_intro-4up.pdf)
  [[Video]](https://vimeo.com/182668506)
* OCaml, part 01
  [[2up]](lectures/ocaml_01-2up.pdf)
  [[4up]](lectures/ocaml_01-4up.pdf)
* [Code written during the lecture](https://github.com/aktemur/cs321/blob/master/lecture_notes/)


### 28.09.2017 Thursday
* OCaml, part 02
  [[2up]](lectures/ocaml_02-2up.pdf)
  [[4up]](lectures/ocaml_02-4up.pdf)

### 02.10.2017 Monday
* OCaml, part 02 cont'd.
* OCaml, part 03 - Lists (up to slide #19)
  [[2up]](lectures/ocaml_03-2up.pdf)
  [[4up]](lectures/ocaml_03-4up.pdf)

### 05.10.2017 Thursday
* NO LECTURE. The instructor is attending a conference.

### 09.10.2017 Monday
* OCaml, part 03 cont'd.
* **Watch** videos:
  - [[Reversing a list]](https://vimeo.com/108644234)
  - [[Map]](https://vimeo.com/108644606)
  - [[Maya the bee]](https://vimeo.com/109113767)
  - [[fold left & fold right]](https://vimeo.com/108647491)
    (_Note:_ This video uses F# as the programming language.
    The differences from OCaml is that the "`let`" expressions do not have
    the "`in`" keyword,
    `fold_left` is called `fold`, and `fold_right` is called `foldBack`.
    Otherwise, the ideas are the same.)

### 12.10.2017 Thursday
* OCaml, part 03 cont'd.
* Tail recursion
  [[2up]](lectures/ocaml_04-2up.pdf)
  [[4up]](lectures/ocaml_04-4up.pdf)
  [[Video]](https://vimeo.com/109811607)
* [Code written during the lecture](https://github.com/aktemur/cs321/blob/master/lecture_notes/)

### 16.10.2017 Monday
* User-defined data types
  [[2up]](lectures/ocaml_05-2up.pdf)
  [[4up]](lectures/ocaml_05-4up.pdf)
* [Code written during the lecture](https://github.com/aktemur/cs321/blob/master/lecture_notes/)

### 19.10.2017 Thursday
* User-defined data types (cont'd)
  - Polymorphic tree implementation in Java [[Code]](https://github.com/aktemur/cs321/blob/master/lecture_notes/)
* An interpreter for the ArithLang language
  (constant ints, names, arithmetic operations).
  - [OCaml code](https://github.com/aktemur/cs321/tree/905d8e3b3e539322486f274466a9c84b98de30a9/ArithLang)
  - Read Chapter 1 and Chapter 2 (up to Section 2.3.2) in PLC.

### 23.10.2017 Monday
* Extended the ArithLang with Let-in.
  - [Code](https://github.com/aktemur/cs321/commit/e36e1e4e91c70b774670d0e64184eabbca869cd5)

### 26.10.2017 Thursday
* MIDTERM EXAM 1
* To study, solve the exercises on the slides,
  the [sample questions on functional programming](https://github.com/aktemur/cs321/tree/master/sampleProblems/functionalProgramming), and
  the [sample questions on interpretation (Q1-Q4)](https://github.com/aktemur/cs321/tree/master/sampleProblems/interpretation).
   - [Suggested approach](https://vimeo.com/185644967)

### 30.10.2017 Monday
* A [Java implementation for the ArithLang interpreter](https://github.com/aktemur/cs321/commit/d05417e03ac6e6287f659b586134b9fcd4261bbf).
  - [A generic implementation for Env](https://github.com/aktemur/cs321/commit/090b4ad82958c3cce69bf4990b167a684475278a).
* Abandoned "ArithLang", will call it "Deve" from now on.
* Extended Deve [with conditionals](https://github.com/aktemur/cs321/commit/49b7cc956a92bb3892ea3ee1a55560a7d7b94d5a).
* Extended Deve [with relational operations](https://github.com/aktemur/cs321/commit/f6312a791fefd81f157c833b11ce509cfe0a941c).
* [The corresponding Java code](https://github.com/aktemur/cs321/commit/64f57b49af80d4992b408dec5e4f7ec03d5304c5).
* Extended Deve [with boolean literals](https://github.com/aktemur/cs321/commit/3cb5c146773e581211c34e52f834d9297a212714).

### 02.11.2017 Thursday
* [The big picture](lectures/bigPicture.pdf)
* Writing a lexer for the Deve language.
  - [Step 1](https://github.com/aktemur/cs321/commit/10ba2b68aa47981242892d0405fb9e22d29197f4),
    [Step 2](https://github.com/aktemur/cs321/commit/c6808365ab94e74363178ba6b2fb2db29cc94376),
    [Step 3](https://github.com/aktemur/cs321/commit/9e3dd2877c1e1a176cec79b0710da3550bd5b8ef),
    [Step 4](https://github.com/aktemur/cs321/commit/3e1d3f70c6fb0520c469598d3e9a7375becbfe96),
    [Step 5](https://github.com/aktemur/cs321/commit/6881dcabb9892342a61e2b1221eb2bc9aad03b44),
    [Step 6](https://github.com/aktemur/cs321/commit/b319c09c4873367fbf1326978a5939dda60424c8)

### 06.11.2017 Monday
* Parsing [[Slides]](lectures/parsing_slides.pdf) [[Notes]](lectures/parsing_notes.pdf)
* Writing a parser for the Deve language.
  - [Names and int constants](https://github.com/aktemur/cs321/commit/c55607edd84f0d49760fd7cfc32f905741ca5cd5),
    [Let-in](https://github.com/aktemur/cs321/commit/2883904b98353e93eca8cb9768be66dbf641a1fd),
    [boolean literals](https://github.com/aktemur/cs321/commit/d45eec20aa402e9d3dd490c56cccaad54db5d4ad),
    [if-then-else](https://github.com/aktemur/cs321/commit/e586bb07dc2d5a720bcc68be72ece982d27f22bb)

### 09.11.2017 Thursday
* Parsing cont'd.
  - [Refactoring](https://github.com/aktemur/cs321/commit/cf516d520d7676cfb2a89f51c0693141b18d7b21),
    [Binary exps (limited)](https://github.com/aktemur/cs321/commit/edd7fffe58cea6777ee0ede8674cd968e7a8d610),
    [Binary exps (right assoc.)](https://github.com/aktemur/cs321/commit/ab830c54d18d9abb5ba00492372f3ba780ee7cf8),
    [Binary exps](https://github.com/aktemur/cs321/commit/e9c6e105d3b633d1293880839af19a518c8113d3),
    [Parenthesized exps](https://github.com/aktemur/cs321/commit/169f3724c665db8708771eb6fcfec74cfbbd3d1b)
* Connecting the pieces to obtain a [Deve REPL](https://github.com/aktemur/cs321/commit/acd8eb5eea3a7679551997071925ec1f8083f610).
* At this point, we have an end-to-end interpreter that takes
  code as a string and reduces the code to a value.
  We will call this [Deve 1.0](https://github.com/aktemur/cs321/tree/master/Deve-1.0).

### 13.11.2017 Monday
* Extending the Deve language with new features.
  See the [sample questions on interpretation](https://github.com/aktemur/cs321/tree/master/sampleProblems/interpretation).
* At this point, we have a version of the language
  that handles booleans gracefully,
  has relational operators,
  handles pairs, etc.
  We will call this [Deve 2.0](https://github.com/aktemur/cs321/tree/master/Deve-2.0).

### 16.11.2017 Thursday
* [How to Have Fun](lectures/howToHaveFun.pdf)
* At this point, we have reached
  [Deve 3.0](https://github.com/aktemur/cs321/tree/master/Deve-3.0).

### 20.11.2017 Monday
* Read PLC Sections 4.1-4.9, 5.4.
* [Type checking](lectures/typeChecking.pdf)

### 23.11.2017 Thursday
* At this point, we have reached
  [Deve 4.0](https://github.com/aktemur/cs321/tree/master/Deve-4.0).

### 27.11.2017 Monday
* Type inference and polymorphism
  [[Slides (1-5)]](lectures/lecture05.pdf)
* Read PLC Section 6.2.

### 30.11.2017 Thursday
* MIDTERM EXAM 2
* See [sample questions on interpretation](https://github.com/aktemur/cs321/tree/master/sampleProblems/interpretation),
  and [type checking](https://github.com/aktemur/cs321/tree/master/sampleProblems/typeChecking).

### 04.12.2017 Monday
* Generics, Co-variance/Contra-variance 
  [[ArrayList Slides]](lectures/ArrayList.pdf)
  [[Code]](https://github.com/aktemur/cs321/tree/master/Variance).
* Read PLC Section 6.5, 6.6.

### 07.12.2017 Thursday
* Lambda calculus and Church numeral encodings
  [[2up]](lectures/07_lambda-2up.pdf)
  [[4up]](lectures/07_lambda-4up.pdf)
  [[Code]](https://github.com/aktemur/cs321/tree/master/Lambda)
* Read: PLC Section 5.6

### 11.12.2017 Monday
* Lambda calculus (cont'd with recursion)
   - [Sample problems](https://github.com/aktemur/cs321/tree/master/sampleProblems/lambdaCalculus).
   - Videos: [part 1](https://vimeo.com/250076161), [part 2](https://vimeo.com/250078355),
   [part 3](https://vimeo.com/250079704), [part 4](https://vimeo.com/250079905)
* Imperative programming
    [[Slides]](lectures/lecture06.pdf)
    [[Code (experiment?.c)]](https://github.com/aktemur/cs321/blob/master/lecture_notes/)
* **Read:** The C Programming Language by K&R, Chapter 5, Sections 5.1-5.4.
    (Available on LMS)

### 14.12.2017 Thursday
* Imperative programming cont'd.

### 18.12.2017 Monday
* Imperative programming cont'd.
  See `swap.cpp` and `experiment5.cpp`.
* Read: PLC Sections 7.1-7.5.
* [Sample problems](https://github.com/aktemur/cs321/tree/master/sampleProblems/imperativeProgramming)
   - [Q8 video](https://vimeo.com/250293259)

### 21.12.2017 Thursday
*   Garbage collection [[Slides]](lectures/garbageCollection.pdf)
*   **Read:** PLC Chapter 10, Sections 10.1-10.5
*   Bonus reading: David Kieras' [C++11 Smart Pointers handout](lectures/C++11_smart_ptrs.pdf)
*   [Sample problems](https://github.com/aktemur/cs321/tree/master/sampleProblems/garbageCollection)

### 25.12.2017 Monday
*   Eager vs. lazy evaluation, infinite streams
    [[2up]](lectures/eager_vs_lazy-2up.pdf)
    [[4up]](lectures/eager_vs_lazy-4up.pdf)
    [[Sample code]](https://github.com/aktemur/cs321/tree/master/streams)
*   [Sample problems](https://github.com/aktemur/cs321/tree/master/sampleProblems/streams)

### 28.12.2017 Thursday


