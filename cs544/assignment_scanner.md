---
layout: cs544default
---

# Assignment: Scanner

**DUE:** Feb. 16th, Thursday, 23:55.
I will fetch your code from Github according to this timestamp.

In this assignment you will implement a scanner
for the [Cool](cool.html) language.
Steps:

1. Give a quick read to the [Cool manual](cool.html). You will read in more detail later.
2. Read the **Lexical Structure** section below.
3. Examine the starter code that has been copied to your private Github repo.
4. Read the **Coding Instructions** section below.
5. Do the assignment and commit on Github.

Advice: Start early and start by writing test cases. Write many test cases.

## Lexical Structure
_(Taken from the [original Cool manual](http://theory.stanford.edu/~aiken/software/cool/cool-manual.pdf).)_

The lexical units of Cool are integers,
type identifiers, object identifiers,
special notation, strings, keywords, and white space.

### Integers, Identifiers, and Special Notation
Integers are non-empty strings of digits 0-9.
Identifiers are strings (other than keywords)
consisting of letters, digits, and the underscore character.
Type identifiers begin with a capital letter;
object identifiers begin with a lower case letter.
There are two other identifiers, `self` and `SELF_TYPE`
that are treated specially by Cool but are not treated as keywords.
The special syntactic symbols
(e.g., parentheses, assignment operator, etc.) are given
in the [Cool syntax](cool_syntax.pdf).

### Strings
Strings are enclosed in double quotes `"..."`.
Within a string, a sequence '`\c`' denotes the character '`c`',
with the exception of the following:

* `\b` backspace
* `\t` tab
* `\n` newline
* `\f` formfeed

A non-escaped newline character may not appear in a string:

```
"This \
is OK"
```

```
"This is not
OK"
```

A string may not contain EOF (end of file).
A string may not contain the null character (`\0`).
Any other character may be included in a string.

### Comments
There are two forms of comments in Cool.
Any characters between two dashes "`--`"
and the next newline (or EOF, if there is no next newline)
are treated as comments.
Comments may also be written by enclosing text in
`(∗ ... ∗)`.
The latter form of comment may be nested. E.g:

```
(* This (* is
a *) nested
comment. *)
```

### Keywords
The keywords of cool are: `class`, `else`, `false`, `fi`, `if`,
`in`, `inherits`, `isvoid`, `let`, `loop`, `pool`, `then`,
`while`, `case`, `esac`, `new`, `of`, `not`, `true`.
Except for the constants `true` and `false`,
keywords are case *insensitive*.
To conform to the rules for other objects,
the first letter of `true` and `false` must be lowercase;
the trailing letters may be upper or lower case.

### White Space
White space consists of any sequence of the characters:
blank (ascii 32), `\n` (newline, ascii 10), `\f` (form feed, ascii 12),
`\r` (carriage return, ascii 13), `\t` (tab, ascii 9),
`\v` (vertical tab, ascii 11).

## Coding Instructions

*   All of the single character symbols, keywrods, etc.
    are listed in the [Cool syntax](cool_syntax.pdf).

*   Handle identifiers in a similar way we identified numbers.
    Do not try to distinguish keywords while consuming characters.
    Instead, after you recognize an identifier and before you create a token for it,
    check whether it's a keyword or not. For this, you may want to
    keep all the keywords in hashtable in which you can do a lookup.

*   Note that comments can be nested. To handle them, you may want to keep
    a counter to denote the depth of comment you're inside.
    Using recursion will probably make your implementation easy and cool.

*   When a string contains invalid characters (i.e. the null chararacter), report that.
    Lexing should resume after the end of the string.
    If a string contains an unescaped newline, report that,
    and resume lexing at the beginning of the next line —
    we assume the programmer simply forgot the close-quote.
    Do not produce a string token.

*   If a comment remains open when EOF is encountered, report that.
    Do not tokenize the comment's contents simply because the terminator is missing.
    If you see "`*)`" outside a comment, report this as an unmatched comment terminator,
    rather than tokenizing it as `*` and `)`.

*   Use the `value` field of the `Token` class to
    store the name value of the class identifiers and object identifiers,
    the numeric value of integer literals,
    and the text value of string literals.
