---
layout: cs544default
---

# Assignment: Code Optimization

In this assignment you will implement code
transformations as
[LLVM passes](http://llvm.org/docs/WritingAnLLVMPass.html):

* A limited [peephole optimization](https://en.wikipedia.org/wiki/Peephole_optimization)
* Loop Invariant Code Motion (LICM)


## Files

Skeleton code will be provided at GitHub.

## Testing

Use `opt` to test your pass.
As always, write many test cases.
If needed, write your tests directly in LLVM IR instead of C.

## Implementation

Below is a list of some of the LLVM APIs that you might find helpful:

* Function:
  `inst_begin`, `inst_end`
* Instruction:
  `mayWriteToMemory`, `mayReadFromMemory`, `isa<TerminatorInst>`,
  `mayHaveSideEffects`, `isVolatile`, `clone`,
  `dropAllReferences` (before deleting an instruction or basic block),
  `eraseFromParent` (removes and frees memory)
* ValueTracking:
  `isSafeToSpeculativelyExecute`
* Other useful classes:
  `LoopPass`, `LoopInfo`, `Loop`, 
  `DominatorTree`, `BasicBlock`

## Peephole Optimization

Replace all the occurrences of `x * N`, where `N` is a power of 2 and `x` is an integer, 
with a shift operation.
E.g. `x * 4` should become `x << 2`.

Also replace all occurrences of `x * M`, where `M` is one less than a power of 2,
and `x` is an integer, with a shift and a subtraction.
E.g. `x * 7` should become `(x << 3) - x`.

Your code should take commutativity into account as well.

## LICM Algorithm

**Input:** An LLVM loop L.

**Output:** The loop, with loop-invariant computations
hoisted out of that loop and its inner loops as far as possible.

**Preconditions:** The loop simplification pass should
have been performed on the function where the loop is present.
This ensures that every loop has a preheader.
It does not ensure that a "while" loop is converted into a
do-while loop nested inside an IF; you should not assume that.
You will also need information about natural loops and about dominators.
(Another pass that can make LICM more effective is reassociation,
but that is not required for the algorithm and is not included here;
you should run it yourself before `cs544licm`).
The complete `getAnalysisUsage()` according to these
preconditions has been implemented in the skeleton file.

**Algorithm:** The goal of this algorithm is to hoist
as many loop-invariant computations out of loops as possible.
We focus only on register-to-register LLVM computations,
i.e., those that do not read or write memory.
We do not try to move out computations that have no uses within the loop.
We say it is safe to hoist a computation
out of a loop only if it is executed at least once in the original loop
(when the loop is entered);
this condition is checked using dominator information.
The full list of criteria are given below.

```
LICM(L) {
  // Each Loop object also gives you a preheader block for the loop.
  for (each basic block BB dominated by loop header, in preorder on dominator tree) {
    if (BB is immediately within L) { // not in an inner loop or outside L
      for (each instruction I in BB) {
        if (isLoopInvariant(I) && safeToHoist(I))
          move I to pre-header basic block;
      }
    }
  }
}
```

*   `isLoopInvariant(I)`:  
    An instruction is loop-invariant if both of the following are true:

    * It is one of the following LLVM instructions or instruction classes:
      `binary operator`, `shift`, `select`, `cast`, `getelementptr`.
      All other LLVM instructions are treated as not loop-invariant.
      In particular, you are not moving terminators,
      `phi`, `load`, `store`, `call`, `invoke`, `malloc`, `free`, `alloca`, `vanext`, `vaarg`.
  
    * Every operand of the instruction is either
      (a) constant or (b) computed outside the loop.
      You can use the `Loop::contains()` method to check (b).

*   `safeToHoist(I)`:  
    An instruction is safe to hoist if either of the following is true:

    * It has no side effects (use `isSafeToSpeculativelyExecute(Instruction *)`,
    you can find it in `llvm/Analysis/ValueTracking.h`).

    * The basic block containing the instruction dominates all
    exit blocks for the loop. The exit blocks are the targets
    of exits from the loop, i.e., they are outside the loop.
    Use `Loop::getExitBlocks()` to get the exit blocks,
    and use the dominator tree to check for dominance.

