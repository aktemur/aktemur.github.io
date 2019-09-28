---
layout: cs222default
---

## Matrix Representation

**Due:** June 6th, Tuesday, 13:00

**Goal:** Read the definition of a matrix in coordinate format from a file,
          output a class definition in CSR format.

### Sparse matrix representation
Matrix operations are widely used in linear algebra libraries
that are crucial for countless areas in engineering and science, such as
nuclear physics, microchip design, finite element analysis, 
high performance computing, etc. 
Dense matrices are typically and not surprisingly stored in two-dimensional arrays,
(`double[][] matrix`).
However, when the matrix is sparse,
a two-dimensional array is a terrible waste of space, because the majority of the elements
will be simply zeros.
Considering that real-world matrices can be very large (a few thousands to millions
of elements), efficient representations for sparse matrices are crucial.

Below, we give two different ways to represent a sparse matrix.
To provide an example, we will use the following 10x10 matrix:

```
    0    1.1  2.2  0   0    0   0  0   0    0
    0    0    3.3  4.4 0    0   0  0   0    0
    0    0    0    0   0    0   0  5.5 0    0 
    0    0    6.6  0   0    7.7 0  8.8 9.9  0
    10.0 0    0    0   0    0   0  0   0    11.1
    0    0    0    0   12.2 0   0  0   0    0
    0    0    0    0   13.3 0   0  0   0    0 
    0    14.4 15.5 0   0    0   0  0   16.6 0
    0    0    0    0   0    0   0  0   17.7 0
    0    0    0    0   0    0   0  0   0    18.8
```

Assuming that the matrix elements are double values, 
the matrix above would require a 10x10 array of double values
(i.e. a minimum of 100 double elements) allocated in the memory
if it's represented using a two-dimensional array.

### Coordinate format (COO)
In this format, 
each non-zero value of the matrix is associated with its row and column index.
Assuming that indexing starts from 0, the matrix above could be represented as follows,
where on each line the first value is the row index, the second is the column index, 
and the third is the value of the non-zero element.

```
    0 1 1.1
    0 2 2.2
    1 2 3.3
    1 3 4.4
    2 7 5.5
    3 2 6.6
    3 5 7.7
    3 7 8.8
    3 8 9.9
    4 0 10.0
    4 9 11.1
    5 4 12.2
    6 4 13.3
    7 1 14.4
    7 2 15.5
    7 8 16.6
    8 8 17.7
    9 9 18.8
```

Note that the index values are integers whereas the matrix values are doubles.
This representation would require 18+18 = 36 `int` values,
plus 18 `double` values. 
This is a clear improvement over the naive, two-dimensional array 
representation.

### Condensed Sparse Row format (CSR)
In CSR representation, three arrays of numbers are stored.
The first is the `vals` array that keeps the values of 
non-zero elements, in an order as if the matrix is traversed
in a row-wise fashion.
The second is the `cols` array that keeps the column indices 
of the elements stored in the `vals` array.
So, for matrix _A_,
if `vals[k]=`_A(i,j)_, then
`cols[k]=`_j_.
Hence, for an _NxM_ matrix with NZ non-zero elements, 
the length of `vals` and
the length of `cols` are NZ.

The third array is the `rows` array, whose size is N+1, 
that keeps the locations of the 
elements in the `vals` that start a new row. 
So, if `vals[k]=`_A(i,j)_, then
`rows[`_i_`]` <= k < `rows[`_i_`+1]`.
For convenience, `rows[`N`] = ` NZ.

Our example matrix above would be represented in CSR as follows:

```
vals:
1.1 2.2 3.3 4.4 5.5 6.6 7.7 8.8 9.9 10.0 11.1 12.2 13.3 14.4 15.5 16.6 17.7 18.8
cols:
1  2  2  3  7  2  5  7  8  0  9  4  4  1  2  8  8  9
rows:
0  2  4  5  9  11 12 13 16 17 18
```

This representation requires 18 `double` values and 18+11 = 29 `int` values,
further improving on COO.

To store CSR matrices in memory,
use the `CSRMatrix.java` class definition.

### The Problem
Your task in this problem is to read a matrix definition from a file
written in COO format, and create an instance of `CSRMatrix`.

You will read the matrix from a `.mtx` file that will be obtained from the
<a href="http://math.nist.gov/MatrixMarket/">Matrix Market</a>.
There are four things you need to watch out about these files:

+ The first few lines of the matrix contain comments. These are the lines
  that start with the % sign.
+ Following the comments, the first non-comment line gives
  the number of rows, columns and the number of entries.
+ The entries may be given in any order -- do not assume any particular
  order.
+ The entries may contain zero values. You will need to filter them out.
+ Indexing starts from 1, **NOT** 0.

For instance, the
[fidap005 matrix](http://math.nist.gov/MatrixMarket/data/SPARSKIT/fidap/fidap005.html)
has the following contents:

```
%%MatrixMarket matrix coordinate real general
27 27 279
1 1  1.0370389925925e+06
2 1  2.5925905925925e+05
10 1 -1.1851862518518e+06
... removed for space concerns
27 26  2.5925905925895e+05
8 27  3.7037148148387e+04
9 27  1.4814814814901e+05
17 27 -2.9629665185188e+05
18 27 -1.1851862518519e+06
26 27  2.5925905925895e+05
27 27  1.0370389925918e+06
```

As you can see, the first non-comment line says that this matrix is 27x27,
and there are entries for 279 elements in this file.
Note that the contents are **NOT** sorted in row-major order.

### Remarks

+ Checkout the project from SVN. It is named **MatrixConversion**.
+ Make sure to use the provided `CSRMatrix.java` file.
+ Think about the data structure you will use to store the 
  matrix contents you read from the file. This data structure must be
  space-wise efficient enough. You canNOT use a two-dimensional array;
  that's against the whole idea of reducing the space requirements for the 
  input matrix.
+ Implement the `COOMatrix` class.
  You should define the fields appropriate for sorting
  the matrix contents
  according to the row-major order.
+ Ignoring zero values as you read them from the files is easier than 
  inserting them into your COO matrix and removing later.
+ You may want to use the [sorting routines](http://www.mkyong.com/java/java-object-sorting-example-comparable-and-comparator/) 
  available in the Java library.

### Test cases
At least try the following matrices obtained from the Matrix Market web site.

+ [fidap005](http://math.nist.gov/MatrixMarket/data/SPARSKIT/fidap/fidap005.html),
  [CSR output](data/fidap005_csr.txt)
+ [memplus](http://math.nist.gov/MatrixMarket/data/misc/hamm/memplus.html),
  [CSR output](data/memplus_csr.txt)
+ [add32](http://math.nist.gov/MatrixMarket/data/misc/hamm/add32.html),
  [CSR output](data/add32_csr.txt)
+ [bcsstm01](http://math.nist.gov/MatrixMarket/data/Harwell-Boeing/bcsstruc1/bcsstm01.html),
  [CSR output](data/bcsstm01_csr.txt)
+ [LF10](data/LF10.mtx), [CSR output](data/LF10_csr.txt)

The outputs are obtained by calling the `toString()` method of `CSRMatrix`.

