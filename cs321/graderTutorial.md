---
layout: cs321default
---

### Tutorial on using the automated grader
In an exam and for exercise, you may be given some grader files,
[obtainable via SVN](hwcheckout.html).
This is the actual grader 
that will be used to grade your exam, 
except that you will be provided with a limited 
set of test cases; you are highly recommended to extend the 
given cases with your own. Try to cover as many corner cases
as possible when adding new test cases so that you will increase
the coverage of the test suite. This will increase the chances
for you to catch a bug in your solution, if there is one.

A grader folder will typically contain the following files:

  + `grader.fs` and `graderlib.fs`:
    File internal to the grader. You don't need to worry
    about these, but you may take a look at the contents;
    there are simple functions inside.
  + `solution.dll`: The compiled solution file
    to check your implementation against.
  + `testCases.fs`: The file that contains the test
    cases to be used for grading.
  + `hw`_N_`.fs`: This is the file you need to
    add your solutions to and then submit. _N_ stands
    for the number of the howework.
  + `Makefile`: The makefile to compile the files.

### Using the grader with `make`
**Note:** This works on Unix-based OSes. 
On Windows, you may need to install Cygwin.

`cd` into the `hw`_N_ folder, and type `make`. This is going to 
compile the files and build an executable named `grader.exe`.

Below is my screenshot, doing these steps on Mac OS.
Note that I have to execute the grader using **Mono**.

```
[aktemur@levrek ~]$ cd hw0
[aktemur@levrek ~/hw0]$ make
fsc --nologo -a hw0.fs
fsc --nologo -a graderlib.fs
fsc --nologo -r graderlib.dll -r solution.dll -r hw0.dll -a testCases.fs
fsc --nologo -r testCases.dll grader.fs
[aktemur@levrek ~/hw0]$ mono grader.exe 
[ 1|FAIL] q1 0
[ 1|FAIL] q2 5 3
[ 1|FAIL] q3 (fun n -> n)
[ 1|FAIL] q4 (fun n -> n) 0
Score: [  0/  4]
[aktemur@levrek ~/hw0]$
```

Now you can edit the `hw`_N_`.fs` file. 
Each time you modify this file, do a `make` again to recompile.

```
[aktemur@levrek ~/hw0]$ touch hw0.fs 
[aktemur@levrek ~/hw0]$ make
fsc --nologo -a hw0.fs
fsc --nologo -r testCases.dll grader.fs
```

### Using the grader without `make`
You can use the following steps to load grader files individually.
You may want to use this approach if you want to work with the `fsharpi`,
for instance inside Visual Studio.

+   First load the common file (if there is one)

    ```
    > #r "common.dll";;
    ```
+   Next, load the solution file.

    ```
    > #r "solution.dll";;
    ```
+   Load the graderlib.

    ```
    > #load "graderlib.fs";;
    ```
+   Load your homework file.

    ```
    > #load "hwX.fs";;
    ```
+   Load the test cases.

    ```
    > #load "testCases.fs";;
    ```
+   Finally, load the grader.

    ```
    > #load "grader.fs";;
    ```

If you modify your `hwX.fs` file, repeat steps 4-6.
If you modify the `testCases.fs` file, repeat steps 5-6.

Because you loaded the compiled solution file,
you can run the solution functions in fsi to
see what output is given for certain inputs.
This may be very useful in some cases. E.g.

```
> Solution.q2;;
val it : (int -> int -> int) = <fun:it@2>
> Solution.q2 5 3;;
val it : int = 3
> Solution.q2 5 9;;
val it : int = 5
```

To not have to qualify every solution function with the `Solution.`
prefix, open the Solution module (and the Common module if it
exists.) E.g:

```
> Solution.eval;;
val it : (Common.expr -> (string * int) list -> int) = < fun:it@3 >

> open Common;;
> open Solution;;

> eval;;
val it : (expr -> (string * int) list -> int) = < fun:it@6-1 >

> eval (Prim("+", CstInt 17, CstInt 25)) [];;
val it : int = 42
```

