---
layout: cs535default
---

### Literature Review

Grad students are required to review a recent paper
regarding concurrency.

1. Pick a paper published in a recent (i.e. in the last ~5 years)
reputable conference (e.g. ICSE, OOPSLA/SPLASH, PLDI, POPL, PPoPP, RV)
or journal (e.g. ACM TOSEM, ACM TOPLAS, ACM TACO).

2. The paper should be about concurrent programming.

3. Send the paper link to the instructor for approval.

4. Prepare a review of the paper as a report. A "review" is a serious job.
   In particular, focus on the following things:
   * What is the paper about? What problem does it address? What are the assumptions about its problem context?
   * How does the paper solve the problem?
   * What are the strengths and weaknesses?
   * How can the paper be extended for future work?
   
   Reading papers that cite the picked paper is a smart trick to quickly
   see what other researchers think about this paper.

5. At the end of the semester, you will
submit the report, and present the paper in class.

### Links

* [How to Read an Engineering Research Paper](http://cseweb.ucsd.edu/~wgg/CSE210/howtoread.html)
* [Sample Review](http://www.cs.uml.edu/~cchen/580-S06/sample_review.html)

---

* _Mert Bahadir:_  
  Aravind Natarajan and Neeraj Mittal.
  _Fast concurrent lock-free binary search trees._ PPoPP '14.  
  <http://dx.doi.org/10.1145/2555243.2555256>
* Kivanc Kabasakal:  
  Nam Duong, Dali Zhao, Taesu Kim, Rosario Cammarota, Mateo Valero, and Alexander V. Veidenbaum.
  _Improving Cache Management Policies Using Dynamic Reuse Distances._ MICRO '12.  
  <http://dx.doi.org/10.1109/MICRO.2012.43>
* Mehmet Kose:  
  Mahdi Eslamimehr and Jens Palsberg.
  _Sherlock: scalable deadlock detection for concurrent programs._ FSE '14.  
  <http://dx.doi.org/10.1145/2635868.2635918>
* Irfan Karazor:  
  Alex A. Aravind.
  _Highly-fair bakery algorithm using symmetric tokens._ Inf. Process. Letters 110, 23 (Nov. 2010).  
  <http://dx.doi.org/10.1016/j.ipl.2010.09.004>
* Ulvi Cesur:
  H. Liao et al.
  _Eliminating Concurrency Bugs in Multithreaded Software: A New Approach Based on Discrete-Event Control._
  IEEE Transactions on Control Systems Technology, vol. 21, no. 6, 2013.  
  <http://ieeexplore.ieee.org/stamp/stamp.jsp?tp=&arnumber=6403531&isnumber=6623119>
* Anil Sezgin:
  Yan Cai and W. K. Chan.
  _MagicFuzzer: scalable deadlock detection for large-scale applications._ ICSE '12.  
  <http://dl.acm.org/citation.cfm?id=2337294>
* Baturay Saran:
  Alex Kogan and Erez Petrank.
  _A methodology for creating fast wait-free data structures._ PPoPP '12.  
  <http://dx.doi.org/10.1145/2145816.2145835>
* Rifat Can Sarili:
  Samy Al Bahra.
  _Nonblocking algorithms and scalable multicore programming._ Commun. ACM 56, 7 (July 2013), 50-61.  
  <http://dx.doi.org/10.1145/2483852.2483866>
* Mehmet Ceylan:
  Alex Kogan and Erez Petrank.
  _Wait-free queues with multiple enqueuers and dequeuers._ PPoPP '11.  
  <http://dx.doi.org/10.1145/1941553.1941585>
* Songul Abuzar:
  Dana Drachsler, Martin Vechev, and Eran Yahav.
  _Practical concurrent binary search trees via logical ordering._ PPoPP '14.  
  <http://dx.doi.org/10.1145/2555243.2555269>
  
---

* Takayuki Usui, Reimer Behrends, Jacob Evans, and Yannis Smaragdakis.
  _Adaptive Locks: Combining Transactions and Locks for Efficient Concurrency._  
  <http://ieeexplore.ieee.org/document/5260570/?part=1>
* Christoph Reichenbach, Yannis Smaragdakis, and Neil Immerman.
  _PQL: a purely-declarative java extension for parallel programming._  
  <https://yanniss.github.io/pql-ecoop12.pdf>
* Tayfun Elmas, Shaz Qadeer, and Serdar Tasiran.
  _Goldilocks: a race and transaction-aware java runtime._  
  <http://dl.acm.org/citation.cfm?id=1250762>
* Muthu Manikandan Baskaran, J. Ramanujam, and P. Sadayappan.
  _Automatic C-to-CUDA code generation for affine programs._  
  <http://link.springer.com/chapter/10.1007%2F978-3-642-11970-5_14>
* Bryan Catanzaro, Michael Garland, and Kurt Keutzer.
  _Copperhead: compiling an embedded data parallel language._  
  <http://dl.acm.org/citation.cfm?doid=1941553.1941562>
* Jason Ansel, Cy Chan, Yee Lok Wong, Marek Olszewski, Qin Zhao, Alan Edelman, and Saman Amarasinghe.
  _PetaBricks: a language and compiler for algorithmic choice._  
  <http://dl.acm.org/citation.cfm?id=1542481>
* Tianzheng Wang, Milind Chabbi, and Hideaki Kimura.
  _Be my guest: MCS lock now welcomes guests._ PPoPP '16.  
  <http://dl.acm.org/citation.cfm?id=2851160>
* Chaoran Yang and John Mellor-Crummey.
  _A wait-free queue as fast as fetch-and-add._ PPoPP '16.  
  <http://dl.acm.org/citation.cfm?id=2851168>
* Cosmin Radoi and Danny Dig.
  _Practical static race detection for Java parallel loops._ ISSTA '13.  
  <http://doi.acm.org/10.1145/2483760.2483765>
* Semih Okur, Cansu Erdogan, and Danny Dig.
  _Converting Parallel Code from Low-Level Abstractions to Higher-Level Abstractions._ ECOOP '14.  
  <http://dx.doi.org/10.1007/978-3-662-44202-9_21>
* Vilas Jagannath, Milos Gligoric, Dongyun Jin, Qingzhou Luo, Grigore Rosu, and Darko Marinov.
  _Improved multithreaded unit testing._ ESEC/FSE '11.  
  <http://dx.doi.org/10.1145/2025113.2025145>
* Adam Morrison.
  _Scaling synchronization in multicore programs._ Commun. ACM 59, 11 (October 2016).  
  <http://dx.doi.org/10.1145/2980987>




