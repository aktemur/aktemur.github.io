---
layout: cs544default
---

# Cool

[Cool](http://theory.stanford.edu/~aiken/software/cool/cool.html)
(Classroom Object-Oriented Language)
is a language designed at Stanford by [Prof. Alex Aiken](http://theory.stanford.edu/~aiken)
for use in a compilers course.
We will be developing a compiler from Cool to LLVM IR.

A long version of the [Cool manual](http://theory.stanford.edu/~aiken/software/cool/cool-manual.pdf)
is available. Here, I summarize the manual according to our needs.

## Examples
Several Cool examples exist in the
[examples](http://theory.stanford.edu/~aiken/software/cooldist/examples/) folder.
Cool source files have extension `.cl`.

## Classes
Multiple classes may be defined in the same file.
Class definitions have the form:

```
  class <Name> [ inherits <Name> ] {
    <feature_list>
  };
```

The notation `[...]` denotes an optional construct.
Class names begin with an uppercase letter.

### Features
The body of a class definition consists of a list of _feature_ definitions.
A feature is either an _attribute_ (i.e. a field) or a _method_.
All attributes have scope local to the class (i.e. they are private),
and all methods have global scope (i.e. they are public).
Thus, the only way to provide access to object state in Cool is through methods.

Feature names must begin with a lowercase letter.
No method name may be defined multiple times in a class,
and no attribute name may be defined multiple times in a class,
but a method and an attribute may have the same name.

Methods are executed according to the _dynamic dispatch_ (i.e. late binding)
principle, as in Java (i.e. `virtual` methods in C++).

The special variable `self` refers to the object on which a method
is executed (just like `this` in Java and C++).

The expression `new C` creates a new instance of the class `C`.

### Inheritance
A child class inherits all the attributes of its parent.
Methods can be redefined in a child class.
It is illegal to redefine attribute names.

There is a distinguished class `Object`.
If a class definition does not specify a parent class,
then the class inherits from `Object` by default.
A class may inherit only from a single class (i.e. there is single inheritance).

In addition to `Object`, Cool has four other basic classes:
`Int`, `String`, `Bool`, and `IO`.

## Types
A type declaration has the form `x:C`, where `x` is a variable and `C` is a type.
The use of types and type-checking in Cool is similar to Java,
except for `SELF_TYPE`.

The type `SELF_TYPE` is used to refer to the type of the `self` variable.
This is useful in classes that will be inherited by other classes,
because it allows the programmer to avoid specifying a fixed final type
at the time the class is written. For example, consider the program below.

```
class Silly {
    copy() : SELF_TYPE { self };
};
    
class Sally inherits Silly { };

class Main {
    x : Sally <- (new Sally).copy();

    main() : Sally { x };
};
```

Because `SELF_TYPE` is used in the definition of the copy method,
we know that the result of copy is the same as the type of the `self` variable.
Thus, it follows that `(new Sally).copy()` has type `Sally`,
which conforms to the declaration of attribute `x`.

Note that the meaning of `SELF_TYPE` is not fixed, but depends on the class in which it is used.
In general, `SELF_TYPE` may refer to the class `C` in which it appears,
or any child (or grandchild) class of `C`.

Finally, `SELF_TYPE` may be used in the following places:

* `new SELF_TYPE`,
* as the return type of a method,
* as the declared type of a `let` variable,
* or as the declared type of an attribute.

No other uses of `SELF_TYPE` are permitted.

Cool has a solid type system. We will not implement a type checker
for Cool in this course.

## Attributes
An attribute definition has the form

```
<id> : <type> [ <- <expr> ];
```

The expression is optional initialization that is executed when a new object is created.
If no initialization is supplied, then the default initialization is used (see below).
When a new object of a class is created, all of the inherited and
local attributes must be initialized.
Inherited attributes are initialized first in inheritance order
beginning with the attributes of the greatest ancestor class.
Within a given class, attributes are initialized in the order they appear in the source text.
Attributes are local to the class in which they are defined or inherited.
Inherited attributes cannot be redefined.

### Void
All variables in Cool are initialized to contain values of the appropriate type.
The special value `void` is used as the default initialization for variables
where no initialization is supplied by the user.
(`void` is used where one would use `NULL` in C or `null` in Java;
Cool does not have anything equivalent to C’s or Java’s `void` type.)
Note that there is no name for `void` in Cool;
the only way to create a `void` value is to declare a variable of some class
other than `Int`, `String`, or `Bool` and allow the default initialization to occur,
or to store the result of a `while` loop.

There is a special form `isvoid expr` that tests whether a value is `void`.
In addition, `void` values may be tested for equality.
A `void` value may be passed as an argument, assigned to a variable,
or otherwise used in any context where any value is legitimate,
except that a method call or `case` on `void` generates a runtime error.

Variables of the basic classes `Int`, `Bool`, and `String` are initialized specially
(discussed later below).

## Methods
A method definition has the form

```
<id>(<id> : <type>,...,<id> : <type>): <type> { <expr> };
```

There may be zero or more formal parameters.
The identifiers used in the formal parameter list must be distinct.
When a method is invoked, the formal parameters are bound to the actual
arguments and the expression is evaluated;
the resulting value is the meaning of the method invocation (i.e. the method's return value).
A formal parameter hides any definition of an attribute of the same name.

## Expressions
Expressions are the largest syntactic category in Cool.

### Constants
The simplest expressions are constants.
The boolean constants are `true` and `false`.
Integer constants are unsigned numbers such as `0`, `123`, and `007`.
String constants are sequences of characters enclosed in double quotes,
such as `"This is a string."`
String constants may be at most 1024 characters long.

The constants belong to the basic classes `Bool`, `Int`, and `String`.
The value of a constant is an object of the appropriate basic class.

### Identifiers
The names of local variables, formal parameters of methods, `self`,
and class attributes are all expressions.
The identifier `self` may be referenced, but it is an error to assign to `self`
or to bind `self` in a `let`, a `case`, or as a formal parameter.
It is also illegal to have attributes named `self`.
Local variables and formal parameters have lexical scope.
The binding of an identifier reference is the innermost scope
that contains a declaration for that identifier,
or to the attribute of the same name if there is no other declaration.
The exception to this rule is the identifier `self`,
which is implicitly bound in every class.

### Assignment
An assignment has the form

```
<id> <- <expr>
```

The value of an assignment is the value of the expression.

### Dispatch
There are three forms of dispatch (i.e. method call) in Cool.
The three forms differ only in how the called method is selected.
The most commonly used form of dispatch is

```
<expr>.<id>(<expr>,...,<expr>)
```

Consider the dispatch `e0.f(e1, . . . , en)`.
To evaluate this expression, the arguments are evaluated in left-to-right order,
from `e1` to `en`.
Next, `e0` is evaluated and its class `C` noted
(if `e0` is `void`, a runtime error is generated).
Finally, the method `f` in class `C` is invoked,
with the value of `e0` bound to `self` in the body of `f` and
the actual arguments bound to the formals as usual.

The other forms of dispatch are:

```
<id>(<expr>,...,<expr>)
<expr>@<type>.id(<expr>,...,<expr>)
```

The first form is shorthand for `self.<id>(<expr>,...,<expr>)`.

The second form provides a way of accessing methods of parent
classes that have been hidden by redefinitions in child classes.
Instead of using the class of the leftmost expression to determine the method,
the method of the class explicitly specified is used.
For example, `e@B.f()` invokes the method `f` in class `B`
on the object that is the value of `e`.

### Conditionals
A conditional has the form

```
if <expr> then <expr> else <expr> fi
```

The semantics of conditionals is standard.
The predicate (i.e. the condition) is evaluated first.
If the predicate is `true`, the `then` branch is evaluated.
If the predicate is `false`, the `else` branch is evaluated.
The value of an if-expression is the value of the evaluated branch.

### Loops
A loop has the form

```
while <expr> loop <expr> pool
```

The predicate is evaluated before each iteration of the loop.
If the predicate is `false`, the loop terminates and `void` is returned.
If the predicate is `true`, the body of the loop is evaluated and the process repeats.

### Blocks
A block has the form

```
{ <expr>; ... <expr>; }
```

The expressions are evaluated in left-to-right order.
Every block has at least one expression;
the value of a block is the value of the last expression.

An occasional source of confusion in Cool is the use of semi-colons ("`;`").
Semi-colons are used as terminators in lists of expressions (e.g. the block syntax above)
and not as expression separators.

### Let
A `let` expression has the form

```
let <id1> : <type1> [ <- <expr1> ], ..., <idn> : <typen> [ <- <exprn> ] in <expr>
```

The optional expressions are initialization; the other expression is the body.
A `let` is evaluated as follows.
First `<expr1>` is evaluated and the result is bound to `<id1>`.
Then `<expr2>` is evaluated and the result is bound to `<id2>`, and so on,
until all of the variables in the `let` are initialized.
(If the initialization of `<idk>` is omitted,
the default initialization of type `<typek>` is used.)
Next, the body of the `let` (i.e. `<expr>`) is evaluated.
The value of the `let` is the value of the body.

The `let` identifiers `<id1>`,...,`<idn>` are
visible in the body of the `let`.
Furthermore, identifiers `<id1>`,...,`<idk>` are visible in the initialization
of `<idm>` for any `m` > `k`.

If an identifier is defined multiple times in a `let`,
later bindings hide earlier ones.
Identifiers introduced by `let` also hide any definitions for the same names
in containing scopes.
Every `let` expression must introduce at least one identifier.

### Case
A case expression has the form

```
case <expr0> of
  <id1> : <type1> => <expr1>;
  ...
  <idn> : <typen> => <exprn>;
esac
```

Case expressions provide runtime type tests on objects.
First, `expr0` is evaluated and its dynamic type `C` noted
(if `expr0` evaluates to `void`, a run-time error is produced).
Next, from among the branches the branch with the type `<typek>`
that is closest to `C` in the inheritance hierarchy is chosen.
The identifier `<idk>` is bound to the value of `<expr0>`
and the expression `<exprk>` is evaluated.
The result of the `case` is the value of `<exprk>`.
If no branch can be selected for evaluation,
a run-time error is generated.
Every `case` expression must have at least one branch.

The case expression has no special construct for a "default" or "otherwise" branch.
The same affect is achieved by including a branch

```
  x : Object => ...
```

because `Object` is at the top of the inheritance hierarchy.

The `case` expression provides programmers a way to insert
explicit runtime type checks in situations where static types
inferred by the type checker are too conservative.
A typical situation is that a programmer writes an expression `e` and
type checking infers that `e` has static type `P`.
However, the programmer may know that, in fact,
the dynamic type of `e` is always `C` for some `C` that is a (grand)child of `P`.
This information can be captured using a case expression:

```
  case e of x : C => ...
```

In the branch, the variable `x` is bound to the value of `e`
but has the more specific static type `C`.

### New
A `new` expression has the form

```
new <type>
```

The value is a fresh object of the appropriate class.
If the type is `SELF_TYPE`,
then the value is a fresh object of the class of self in the current scope.

### Isvoid
The expression

```
isvoid expr
```

evaluates to `true` if `expr` is `void`, and evaluates to `false` if `expr` is not `void`.

### Arithmetic and Comparison Operations
Cool has four binary arithmetic operations: `+`, `-`, `*`, `/`.
The syntax is

```
expr1 <op> expr2
```

To evaluate such an expression, first `expr1` is evaluated and then `expr2`.
Cool has only integer division.

Cool has three comparison operations: `<`, `<=`, `=`.
For `<` and `<=` the rules are exactly the same as
for the binary arithmetic operations, except that the result is a `Bool`.

The comparison `=` is a special case.
If either `<expr1>` or `<expr2>` has static type `Int`, `Bool`, or `String`,
then the other must have the same static type.
Any other types, including `SELF_TYPE`, may be freely compared.
On non-basic objects,
equality simply checks for pointer equality
(i.e., whether the memory addresses of the objects are the same).
Equality is defined for `void`.

In principle, there is nothing wrong with permitting equality tests between,
for example, `Bool` and `Int`.
However, such a test must always be `false` and almost certainly
indicates some sort of programming error.
The Cool type checking rules catch such errors at compile-time instead of waiting until runtime.
So, we shall not about such cases when implementing our compiler.

Finally, there is one arithmetic and one logical unary operator.
The expression `~<expr>` is the integer complement of `<expr>` (i.e. negation).
The expression `not <expr>` is the boolean complement of `<expr>`.

## Basic Classes

### Object
The `Object` class is the root of the inheritance graph.
A method with the following declaration is defined:

```
type_name() : String
```

The method `type_name` returns a string with the name of the class of the object.


### Int
The `Int` class provides integers.
There are no methods special to `Int`.
The default initialization for variables of type `Int` is `0` (not `void`).
It is an error to inherit from or redefine `Int`.

### Bool
The `Bool` class provides `true` and `false`.
The default initialization for variables of type `Bool` is `false` (not `void`).
It is an error to inherit from or redefine `Bool`.

### String
The `String` class provides strings.
The following methods are defined:

```
length() : Int
concat(s : String) : String
substr(i : Int, l : Int) : String
```

The method `length` returns the length of `self`.
The method `concat` returns a string formed by concatenating `s` after `self`.
The method `substr` returns the substring of `self` beginning at position `i` with length `l`;
string positions are numbered beginning at `0`.

The default initialization for variables of type `String` is `""` (not `void`).
It is an error to inherit from or redefine `String`.

### IO
The `IO` class provides the following methods for performing simple
input and output operations:

```
out_string(x : String) : SELF_TYPE
out_int(x : Int) : SELF_TYPE
in_string() : String
in_int() : Int
```

The methods `out_string` and `out_int` print their argument and return `self`.
The method `in_string` reads a string from the standard input,
up to but not including a newline character.
The method `in_int` reads a single integer.
Any characters following the integer, up to and including the next newline,
are discarded by `in_int`.

A class can make use of the methods in the `IO` class by inheriting from `IO`.
It is an error to redefine the `IO` class.

## Main Class
Every program must have a class `Main`.
Furthermore, the `Main` class must have a method `main` that takes no formal parameters.
The `main` method must be defined in class `Main` (not inherited from another class).
A program is executed by evaluating `(new Main).main()`.

