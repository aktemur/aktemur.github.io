---
layout: cs222default
---

# Assignment: Number Game

**Grading deadline:** The most recent version of your code at the time of
**March 2nd, 23:55** will be used for grading.

**Part I**: To receive feedback on Part I, 
submit until **Feb 13th, 13:00**, by committing your code to SVN.

**Part II**: To receive feedback on Part II, 
submit until **Feb 20th, 14:30**, by committing your code to SVN.

**Part III**: To receive feedback on Part III, 
submit until **Feb 27th, 14:30**, by committing your code to SVN.

In this assignment, we will be working with code
in the `numbergame` package.
In any part, do NOT change the signature of the public methods
you've been provided with.
You may add new private or protected methods and fields,
unless otherwise specified.

_Keep in mind that you do not have to
commit your code just once.
I suggest you to commit your code whenever you implement
a new feature. This way, you will also have a backup of your code.
We will use the most recent version of your code available at the specified deadline._

## Grading
* Cleanness (names, functions, format): 40%
* Correctness: 20%
* Efficiency of Part 2: 15%
* Efficiency of Part 3: 15%
* Participation in code review sessions: 10%

Correctness will be auto-graded using test cases similar to those provided to you.

"Efficiency" will also be auto-graded.
For Part II, we will test in how many guesses you can find a particular number;
for Part III, we will test for how many steps you can keep a secret.


## Problem Definition

I'm going to play a game with you.
In this game, you pick a number hidden from me.
Without loss of generality, suppose we agree that
the number will have 4 digits.
Another requirement is that the number has distinct (i.e. unique) digits.
Suppose you pick 4097.
I make a guess about the number.
Suppose my guess is 6790.
You will report back the _similarity_ between your secret number and my guess.
The similarity of two numbers is the count of the digits
that occur in both numbers in different positions, and the count
of digits that occur in the same positions.
Consider 4097 and 6790. 
There is one digit (9)
that occurs in the same position in both numbers;
and there are two digits (0 and 7) that occur in
different positions in both numbers. This similarity is reported
as `1+ 2-`.
If my guess were 1256, there would be no common digits, making
the similarity `0+ 0-`. If my guess were
4097, the similarity would be `4+ 0-`, meaning the secret number
has been found.

## Part I

Implement the missing methods in the class named `SecretKeeper`.

You have also been provided with a `Main` class and several test cases
in `test/numbergame/SecretKeeperTest` so that you can test your code.

Below is an expected sample run, where we manually set the secret number to 4097 so that
we can test easily.

```
Will you set the secret number manually (y/n)? y
Enter the number of digits: 4
Enter the secret number: 4097
?> 4207
2 + 1 -
?> 1234
0 + 1 -
?> 5678
0 + 1 -
?> 7904
0 + 4 -
?> 7909
Bad input!
?> 4098
3 + 0 -
?> 4079
2 + 2 -
?> 4097
Dammit!
```

## Part II

First, you should **update** your local copy of the repository
to fetch the code that I'm providing.
For this, make a right click on the CS222 project and choose Subversion -> Update. 

In this part you will be at the other side of the game.
You will be the secret finder.

For this, you will implement the `FabulousSecretFinder` class.
In fact, this class has already been implemented for you, but currently it's
too naive. It simply tries all possible inputs one by one.
Your job is to come up with a better approach.

There are two important methods your should be aware of:
`makeAGuess` returns the next guess;
`process` takes in the similarity of the most recent guess to the secret number.
Use these methods wisely to find the secret number.
To see how these methods are used in combination, see the `SecretFinder` class,
which is the parent of `FabulousSecretFinder`.

You may change the `FabulousSecretFinder` class in any way that you wish.
Remove the code that does the simple, brute-force search;
implement your approach. Add new private methods and fields as you see fit.

Your goal should be to find the secret number in as few guesses as possible.
Here is my suggested algorithm.
Keep a set of possible secret numbers.
Initially this set will contain all the N-digit numbers
that do not have any duplicate digits.
Pick a number from this set and return it as your guess.
Upon receiving the similarity to the `process` method,
eliminate all the numbers from the set whose similarity
to your guess is not the same as the received similarity.
This will reduce the set of possible secret numbers substantially.
When `makeAGuess` is invoked again, pick a number from this set as your next guess.
When `process` is invoked, eliminate the numbers in the set again.
Keep doing this until you find the answer.

You may want to use data structures like `Set` and `List` from the `java.util`
package. See the [List processing and lambdas](https://github.com/aktemur/CS222)
examples for some inspiration.

Finally, your code should throw a `RuntimeException` if you detect an inconsistency
in the similarity values you receive. `SecretKeeper` may not be telling you the truth always!


## Part III

In this part, you will implement a `FabulousSecretKeeper` class.
In this secret keeper, instead of simply determining the secret number randomly,
you will follow a smart aproach with goal of keeping the secret number unrevealed
as long as possible.
That is, you should try to enforce the finder to make as many guesses as possible.
By the way, cheating (i.e. returning conflicting similarity results) is a terrible idea,
and will cause you lose significant points.

Which smart approach you will use is totally up to you.
When grading, I'll create a "leaderboard" of students.
Those who perform better will be granted more points.

### Code

We may several changes to the code base. Pay extreme attention
to these steps:

- First, do an svn update.
- We moved your `SecretKeeper.java` to `ObsoleteSecretKeeper.java`. There is a new `SecretKeeper.java`.
This is an abstract base class. You should not change it.
- We added a new class, `Number`, that represents a number. Secret keepers and finders use this
class. You will need to implement `similarityWith`, `isValid`, and `asInt` methods in this class.
This should be doable by a straightforward copy-paste-fix from `ObsoleteSecretKeeper`.
- Fix your `FabulousSecretFinder` to get rid of compilation problems.
In particular, you will need to
  * change `makeAGuess` to return a `Number` instead of an `int`.
  * Use the Number objects to check validity. E.g. `number.isValid(numDigits)` instead of `secretKeeper.isValidNumber(number)`.
- `FabulousSecretKeeper` is the class that you will implement for Part III.
- `NaiveSecretKeeper` is a secret keeper whose secret number is set manually.
This class is used for testing purposes. Do NOT change it.
- `RandomSecretKeeper` is a secret keeper that sets its secret number randomly.
It is the class for Part I. Implement its `setSecretNumber` method.
This should be doable by a straightforward copy-paste-fix from `ObsoleteSecretKeeper`.
- `SecretKeeper` and `SecretFinder` are abstract base classes. Do NOT change them.
- Do NOT change the `Similarity` class.

At the end, you can simply delete or ignore `ObsoleteSecretKeeper`;
we won't use it.


