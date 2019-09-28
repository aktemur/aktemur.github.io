---
layout: cs544default
---

## Lectures

_The lecture notes below are adapted from the
original slides prepared by Cooper and Torczon
(i.e. our textbook's authors)
for their course at Rice._

### Week 1 (30.01-03.02.2017)
_Intro & Scanning_

* [Introduction](lectures/chapter 00 introduction.pdf), [Overview](lectures/chapter 01 overview.pdf)
* [Scanner starter code](https://github.com/aktemur/CS544)


### Week 2 (06.02-10.02.2017)
_Scanning and Parsing_

* [Lexical analysis](lectures/chapter 02 scanners.pdf)
* Parsing. [[Code]](https://github.com/aktemur/CS544)

### Week 3 (13.02-17.02.2017)
_Scanning and Parsing_

* Parsing. [[Slides]](lectures/chapter 03 parsing.pdf)

### Week 4 (20.02-24.02.2017)
_Intermediate Representation_

* **Read** EaC2 Chapter 5
  [[Slides]](lectures/chapter 05 IR.pdf)
* [Install LLVM](setup.html)
* [LLVM IR experiments from the lecture](https://github.com/aktemur/CS544) 

### Week 5 (27.02-03.03.2017)
_Code Generation_

* LLVM IR experiments cont'd
* [LLVM's getelementptr Instruction](http://llvm.org/docs/LangRef.html#getelementptr-instruction)
* [The often misunderstood GEP instruction](http://llvm.org/docs/GetElementPtr.html)

### Week 6 (06.03-10.03.2017)
_Code Generation_

* [Cpp2C](https://github.com/aktemur/Cpp2C)
* [Mapping Object-Oriented Constructs to LLVM IR](https://f0rki.gitbooks.io/mapping-high-level-constructs-to-llvm-ir/content/mapping-object-oriented-constructs-to-llvm-ir/)

### Week 7 (13.03-17.03.2017)
_Midterm Exam_

### Week 8 (20.03-24.03.2017) - Withdrawal week
_Code Generation_

* [Installing LLVM](setup.html).
* [Visitor pattern](https://en.wikipedia.org/wiki/Visitor_pattern)
* [Generating code for non-OO features](https://github.com/aktemur/CS544)

### Week 9 (27.03-31.03.2017)
_Code Generation_

* [Generating code for OO features](https://github.com/aktemur/CS544)

### Week 10 (03.04-07.04.2017)
_Optimization_

* [Chapter 8 slides](lectures/chapter 08 optimization.pdf)
* [Data flow analysis slides](lectures/Data_Flow_Analysis.pdf)

### Week of 10.04-14.04.2017)
**Spring break!**

### Week 11 (17.04-21.04.2017)
_Optimization_

* [Code transformation (LICM and GCSE)](lectures/Code transformation LICM GCSE.pdf)
* Passes in LLVM:
  [[Sample code]](https://github.com/aktemur/CS544)
  [[Documentation]](http://llvm.org/docs/WritingAnLLVMPass.html)
* **Suggested exercises (Chapter 8):** 4
* **Suggested exercises (Chapter 9):** 3, 5a, 6, and the exercises on the slides.
* **Suggested exercises (Chapter 10):** "Before" and "After" cases
  of applying LICM and GCSE.

### Week 12 (24.04-28.04.2017)
_The Backend_

* Instruction selection
  [[Slides]](lectures/chapter 11 instSelection.pdf)
* Instruction scheduling
  [[Slides]](lectures/chapter 12 instScheduling.pdf)

### Week 13 01.05-05.05.2017)
_The Backend_

* Register allocation
  [[Slides]](lectures/chapter 13 registerAllocation.pdf)

### Week 14 (08.05-12.05.2017)
_The Backend_

* [Starter code for register allocation](https://github.com/aktemur/CS544)

<!--

### Scanning
* **Read** EaC2 Chapter 2 (skip 2.4.3, 2.4.4, 2.4.5).
  [[Slides]](lectures/chapter 02 scanners.pdf)
* **Suggested exercises:** 1, 2, 4, 5, 13
  
### Parsing
* **Read** EaC2 Chapter 3
  [[Slides]](lectures/chapter 03 parsing.pdf)
* **Suggested exercises:** 1, 4, 5, 7, 13

### Intermediate Representations
* **Suggested exercises:** 3, 4, 7, 12

### Code Generation
* **Suggested exercises (part I):** 3, 4, 12
* **Suggested exercises (part II):** 6, 7, 11

### Optimization
* **Read** EaC2 Chapter 8, 9, and 10.

### The Back-End
* **Read** EaC2 Chapter 11, 12, and 13
* **Suggested exercises:** "Before" and "After" cases on the slides
  for applying instruction selection and scheduling
  on code snippets.
* **Suggested exercises (Chapter 13):** 1, 3a, 4a. 

-->

