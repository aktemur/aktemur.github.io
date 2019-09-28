---
layout: cs222default
---

# Assignment: Simple OCR

**Grading deadline:** The most recent version of your code at the time of
**May 11th, 23:55** will be used for grading.

**Part I**: To receive feedback on Part I, 
submit until **April 17th, 14:30**, by committing your code to SVN.

**Part II**: To receive feedback on Part II, 
submit until **April 24th, 14:30**, by committing your code to SVN.

**Part III**: To receive feedback on Part III, 
submit until **May 8th, 14:30**, by committing your code to SVN.

_Keep in mind that you do not have to
commit your code just once.
I suggest you to commit your code whenever you implement
a new feature. This way, you will also have a backup of your code.
We will use the most recent version of your code available at the specified deadline._

## Problem
You will be given a string that contains digits
written using the `'_'`, `'|'`, and `' '` characters.
Each digit is specified in a 4-line string where each line
contains 3 characters. The 4th line is always blank.

E.g. This is 0:
```
 _ 
| |
|_|
   
```

This is 1:
```
   
  |
  |
   
```

Digit 2:
```
 _ 
 _|
|_ 
   
```

Digit 3:
```
 _ 
 _|
 _|
   
```

Digit 4:
```
   
|_|
  |
   
```

Digit 5:
```
 _ 
|_ 
 _|
   
```

Digit 6:
```
 _ 
|_ 
|_|
   
```

Digit 7:
```
 _ 
  |
  |
   
```

Digit 8:
```
 _ 
|_|
|_|
   
```

Digit 9:
```
 _ 
|_|
 _|
   
```

A multi-digit input then looks like:
```
    _  _     _  _  _  _  _  _ 
  | _| _||_||_ |_   ||_||_|| |
  ||_  _|  | _||_|  ||_| _||_|
                              
```
For this input, the output is `"1234567890"`.

## Part I

Your task in Part I is to take a multi-digit input,
recognize the digits, and return the converted string.
But first, you should write test cases.
If an input contains an invalid digit,
the corresponding character is `?`.

Do an svn update to fetch the skeleton code.
We will use the package named `ocr` in this assignment.

## Part II

Your task in part II is to handle letters A, B, C, D, E, F
in addition to the digits.

This is A:
```
 _ 
|_|
| |
   
```

This is B:
```
   
|_ 
|_|
   
```

This is C:
```
 _ 
|  
|_ 
   
```

This is D:
```
   
 _|
|_|
   
```

This is E:
```
 _ 
|_ 
|_ 
   
```

This is F:
```
 _ 
|_ 
|  
   
```

## Part III

Your task in this part is to handle "multi-line" inputs.
E.g.

```
    _  _ 
  | _| _|
  ||_  _|
         
    _  _  _ 
|_||_ |_ |_ 
  | _||_||  
            
 _  _ 
  ||_|
  | _|
      
```

In the output, lines should be separated with commas.
So the input above should be recognized as "123,456F,79".

Remember to write test cases first.
