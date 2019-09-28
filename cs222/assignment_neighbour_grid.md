---
layout: cs222default
---

## Generating a neighbor grid

**Due:** June 5th, Friday, 23:55  
**Language:** Java  
**Goal:** Read an ASCII input file that represents a terrain and
    generate an output file representing a neighbor grid.

### Submission
Create a new project named **Neighbourhood**.
Commit your changes to the repository by the deadline.

### Prelude
For this assignment, I highly encourage you to watch the
debugger tutorial videos available on the [resources page](resources.html).
Because this assignment involves bit-level operations, using the debugger
helps you much better than debugging with `System.out.println`.

### Task
Your program will read in input file such as

```
17
30
dhhmppppppppgssswwwwwwwwpwwwww
ddddhpppppgggswwwwwjjwwwpwwwww
ddhhhppgggwwwwwwpwjpjwwwpjwwww
ddhppppghwwwwwwjpjpppppwppwwww
hhpppgghwwwwwwpppppdppppshwwww
ppppggwwwwwwwpdpddddpdpssspwww
gggggwwwwwwppppdddhhppsssssjww
ggswwwwwwwpphpdppddppdpssspghw
sswwwwwwwwpppppppphhpdppspppgw
wwwwwwwwwwpppppdddddpwpdpppggw
wwwwwwwwwwwgpppppppppphpppgmhw
sswwwwwwwwwggppwwwwwgwgggpmhhw
sssswwwwwwwfhwwwwwwwwwgggghhww
pppswwwwwwwwwwwwwwwwwwwgghhwww
jjjpgwwwwwwwwwiiiwwwwwwwwwwwww
ffjppggwwwwwwiiiiiwwwwwwwwiwww
fffjppgggwwwwwwiiiwwwwwwwiiiww
```
or

```
3
3
gwg
pgp
fgj
```

and generate an output file representing a neighbor grid. The format
of the input file is as follows:

+ The first line is a positive integer that denotes the number of lines in the data.
+ The second line is a positive integer that denotes the number of characters on each line in the data.
+ The rest is the actual data.

The data characters may be any of
the following:

+ g: grass
+ d: desert
+ j: jungle
+ p: plains
+ s: swamps
+ r: roads
+ w: water
+ h: hotrocks
+ f: forest
+ m: mountains
+ i: ice

For this part of the assignment, we don't care what each cell of the
data portion of the map is;
we're interested only in its relation to its neighbors. Once
you read in the input file, your program should generate an output
file that has one byte per cell of data in the input file, with each
bit of each byte representing that cell's relation to its neighbors:

+ Bit 7: West
+ Bit 6: South West
+ Bit 5: South
+ Bit 4: South East
+ Bit 3: East
+ Bit 2: North East
+ Bit 1: North
+ Bit 0: North West

A **1** for a particular bit signifies that that cell has a neighbor that
is **different** from it, a **0** signifies that that is the **same** type of
cell. So, for the second input file shown above (i.e 3x3 data),
the grass element in the middle of the map would have the 8 bits be 11011010. 

In summary, here is what you have to do:

* read the input file into memory
* for each cell you read in, generate an **8-bit** number that describes
  its relationship to its neighbors.
  Use a data type that is 8 bits: `byte` in Java.
  **Do not write actual 1's and 0's as ASCII to your output file.**
* the collection of 8-bit numbers should be written out to disk in
  the same format as the input, with a line containing the number of
  rows, a line containing the number of columns, and then one line per
  row containing one 8-bit number per cell.


### Recommendations:
+ Modularize your code as much as possible. A sample decomposition is
  shown below.
+ try to use the principle of information hiding, that is, make each
  class's data structures only visible to that class, and have each
  class expose an interface to access its data.
+ do not put all of your code in one long main method.
+ comment your code so it is clear and easy to understand.

Here is a sample decomposition for your program:

**Input class:**

```java
  void readFile(filename);
  int getRowCount();
  int getColCount();
  char getData(row, col);
```

or, you may prefer

```java
  void readFile(filename);
  char[][] getData();
```

**Processor class:**

```java
  void run();
  void setNeighbor(row, col, dir);
  boolean neighborDifferent(row, col, dir); 
  byte processCell(row, col);
```

**Output class:**

```java
  void writeToFile(filename);
```

and a mediator class to coordinate all of the other modules
together. That is, the mediator (aka the class with the main method)
implements the following "pipe" flow:

```
             __________             _____________             __________
--filename-->| Reader |--char[][]-->| Processor |--byte[][]-->| Writer |-->outputfile
             |________|             |___________|             |________|
```

Using this decomposition, none of the data structures are
exposed outside of the modules in which they reside and any changes
made would be local to that module. 

The decomposition suggestions are merely a guideline. 
You are not required to follow these suggestions.

### Things to watch out for
+ What do you do when you reach the edge of
  a map? Should you have 0's or 1's for the edge neighbors of a
  cell?
+ What if
  we changed the input format, how much work would need to be done to
  your code to accommodate the change? Try to make your program as
  flexible as possible.
+ What if we changed the output format?

### Hints
The output file has exactly the same format as the input,
except that each character in the input
has been replaced by the 8-bit neighbor grid representation of the corresponding cell.

Use of a hexadecimal editor is extremely useful in this assignment.
Do not try to debug your program
by printing 8-bit values
as ASCII values - what you see will make no sense. If you must use print statements, 
at least print the values in hexadecimal notation. 

Remember that whenever you get stuck, Google is your best friend. 
Do not hesitate to post questions to Piazza.

I use `hexdump` to display the contents of my files in 
hex notation. Emacs has a `hexl-mode`.
You can use other hex editors/viewers as well. 
For instance, here is what I see for the 
simple 3x3 example given above:

```
$ hexdump -C terrain_3_3.txt 
00000000  33 0a 33 0a 67 77 67 0a  70 67 70 0a 66 67 6a 0a  |3.3.gwg.pgp.fgj.|
00000010
```

Note that `33` is the ASCII code for character '3' in hex notation. 
`0a` is the hex code for the newline character, 
`67` is for the character 'g' and so on.

My output file has the following contents:

```
$ hexdump -C terrain_3_3.bin 
00000000  33 0a 33 0a ef ff bf 0a  ff da ff 0a ff fd ff 0a  |3.3.............|
00000010
```

Note that the file starts exactly the same as the input file.
Row and column counts are given in ASCII format. 
However, the data part now contains the neighbor grid values.
For instance, the value for 'g' in the middle is `da`, which 
is the hex notation for binary `11011010`.

Keep in mind that the sample output above shows the newline as `0x0a`. 
On a Windows machine, you may get two separate characters (`0x0d0a`). 
That's normal. See <http://en.wikipedia.org/wiki/Newline#Representations>
for why that happens.

### Test Cases
Here is the input file and the neighbor grid (i.e. output) for the 17x30 terrain:  
[terrain\_17_30.txt](data/terrain_17_30.txt),
[terrain\_17_30.bin](data/terrain_17_30.bin)

A randomly generated 8x21 terrain and its grid:  
[randomTerrain\_8_21.txt](data/randomTerrain_8_21.txt),
[randomTerrain\_8_21.bin](data/randomTerrain_8_21.bin)

A randomly generated 23x14 terrain and its grid:  
[randomTerrain\_23_14.txt](data/randomTerrain_23_14.txt),
[randomTerrain\_23_14.bin](data/randomTerrain_23_14.bin)

### Notes
You must use bit-level operations
(google for shift operations, `<<` and `>>`)
to build your output.
Constructing a string made out of '1' and '0' characters and then
parsing it as binary will NOT be accepted as a satisfactory solution.


Spend as much time on refactoring your code to improve it 
as you spend on the actual solution to the problem.

You may assume that the input files are formatted as specified;
we won't do ugly jokes.

I recommend that you choose `FileOutputStream` to write to the output file,
and use `Scanner` to read from the input file. 

### Grading Rubric
+ Functional requirements
  * Your program can properly read the input file: 2
  * Your program can do edge detection: 2
  * Your program properly calculates the neighbour grid: 2
  * You use bit-level operations: 4 
  * Your program writes the neighbour grid out to file properly: 2 
+ Clean code
  * You used adequate and meaningful comments: 1
  * You used meaningful names used for variables, constants and functions, etc: 3
  * Code was modular and easily adaptable to change
    (nicely decomposed, functions are short enough and
    have well-defined responsibilities): 4
  * There aren't smells in your code: 4
