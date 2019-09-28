---
layout: cs222default
---

## Assignment 2.2 - Matrix Visualization and Stencil Analysis

**Due:** March 11th, Tuesday, 23:59  
**Language:** Java  
**Goal:** Visualize a sparse matrix as a PNG file;
          analyze a matrix to output its stencils.

### Prelude
For this assignment, you may want to add accessor (i.e. `get`) methods to `CSRMatrix`.
While solving this assignment, you may (and are encouraged to)
refactor your existing code as needed.

### Submission
Continue coding in the **Assignment_2** project. Commit your changes to the repository
by the deadline. Do NOT start a new project.

### Task I - Visualization
Create a PNG file to display the structure of a sparse matrix in CSR format.
You code must work using the CSR format, NOT the COO format.
For sample PNG files, see the **Test Cases** below.

Below is a short Java snippet that creates a 400x400 image that has one red pixel
in the middle.

```java
BufferedImage img = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
// Put a red pixel at location 200, 200
// Two bytes for each of: Alpha Red Green Blue
img.setRGB(200, 200, 0x00FF0000); 
File outputfile = new File("matrix.png");
ImageIO.write(img, "png", outputfile);
```
Requirements for this part are as follows:

+ The background of the image should be white; nonzero elements are black.
+ The output image must be named the same as the input matrix. E.g. fidap005.png, memplus.png, etc.
+ The size of the image must be read as input from the user. The locations of the nonzero elements
  of the matrix must be proportional to the size of the image. The examples given below are 400x400.
+ If the matrix is too large for the image, some elements may overlap on the same pixel. This is OK.
+ If the image size is bigger than the matrix, multiple pixels may need to be painted.
  In this case, leave one pixel gap between consecutive nonzero elements for better visualization.
  See my output for **fidap005** for an example.

### Task II - Stencil analysis
A _stencil_ for a row _i_ is defined as follows:

> {_j-i_ | there is an element of row _i_ at column _j_}

For instance, if row 2 has elements at columns {1,2,5,6,8},
then its stencil is {-1,0,3,4,6}.

In this part, analyze a CSR matrix (not COO!) to find its stencils. 
At the end of the program, output each stencil together with the indices of the rows
that have that stencil. See the test cases below for the output format.

### Test cases
At least try the following matrices obtained from the Matrix Market and Florida web sites.

+ [fidap005](http://math.nist.gov/MatrixMarket/data/SPARSKIT/fidap/fidap005.html),
  [Stencil output](data/fidap005_stencils.txt),
  [PNG output](data/fidap005.png)
+ [memplus](http://math.nist.gov/MatrixMarket/data/misc/hamm/memplus.html),
  [Stencil output](data/memplus_stencils.txt),
  [PNG output](data/memplus.png)
+ [add32](http://math.nist.gov/MatrixMarket/data/misc/hamm/add32.html),
  [Stencil output](data/add32_stencils.txt),
  [PNG output](data/add32.png)
+ [bcsstm01](http://math.nist.gov/MatrixMarket/data/Harwell-Boeing/bcsstruc1/bcsstm01.html),
  [Stencil output](data/bcsstm01_stencils.txt),
  [PNG output](data/bcsstm01.png)
+ [LF10](data/LF10.mtx),
  [Stencil output](data/LF10_stencils.txt),
  [PNG output](data/LF10.png)

### Misc.
Note that in my stencil output, stencils are sorted in ascending order
according to a pairwise comparison of indices.

You may want to use a [List<Integer>](http://docs.oracle.com/javase/7/docs/api/java/util/List.html)
(e.g. an `ArrayList<Integer>`) to store both the indices of the stencil
and the indices of the rows with that stencil.
Watch my [ArrayList and Generics video](https://vimeo.com/90197868) to recall why a collection object such
as `ArrayList` is desirable over plain arrays.

You may also want to keep stencils in a [Map](http://docs.oracle.com/javase/7/docs/api/java/util/Map.html) structure
(e.g. [HashMap](http://docs.oracle.com/javase/7/docs/api/java/util/HashMap.html),
[TreeMap](http://docs.oracle.com/javase/7/docs/api/java/util/TreeMap.html))
so that you can check whether the stencil of a row already exists.
The advantage of TreeMap is that its [**keySet()** method](http://docs.oracle.com/javase/7/docs/api/java/util/TreeMap.html#keySet())
returns the keys of the map already sorted in ascending order.
But this requires that you either pass a `Comparator` to the `TreeMap` using the
[appropriate constructor](http://docs.oracle.com/javase/7/docs/api/java/util/TreeMap.html#TreeMap(java.util.Comparator)),
or you make your key objects implement the `Comparable` interface,
so that the map knows how to compare its keys.

### Grading
+ Visualization
    * Outputting a fixed-size image: 1
    * Outputting a custom-size image: 1
    * Properly enlarging matrix elements when the matrix size is smaller than image size: 2
+ Stencil analysis
    * Identifying stencils (in whatever order): 4
    * Sorting stencils in correct order: 4
+ Style
    * Adequate and meaningful comments: 1
    * Modularization of code into methods and classes: 2
    * Proper names: 2
    * Format: 1
    * Short functions that are at the right level of abstraction: 5
