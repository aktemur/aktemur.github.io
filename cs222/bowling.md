---
layout: cs222default
---

# Bowling

Here are the rules for bowling:

* There are 10 **pins**.
The goal is to knock down as many pins as possible.

* A game is played over 10 **frames**.

* In each frame, a player can make two **rolls**.
If the players knocks down all the pins in her second roll,
this is called a **spare**.
If the players knocks down all the pins in her first roll,
this is called a **strike**. In the case of a strike, the player
does *NOT* make the second roll.
If no pins are knocked down in a roll, this is called a **miss**.

* A strike is denoted as "X", a spare is denoted as "/",
a miss is denoted as "-",
and other rolls are denoted by the number of pins knocked down.

Example:
- A frame where 4 pins are knocked down in the first roll,
and 3 in the second is written as "43".
- A frame where 4 pins are knocked down in the first roll,
and the second roll is a miss, is written as "4-".
- A frame where 4 pins are knocked down in the first roll,
and all the remaining are knocked down in the second, is written as "4/".
- A frame where the player achieves a strike is written as "X".

* A game is denoted simply as a sequence of comma-separated frames:
E.g. "43,X,4/,4-" is a game of 4 frames.

## Scoring
* If the player cannot knock down all the pins in a frame,
the score for that frame is simply the sum of the number
of pins knocked down.
E.g: The score for "43" is 7.

* If the player makes a *spare*, the score for that frame
is 10 points plus the number of pins knocked down in the next roll
(i.e. next frame's first roll).

* If the player makes a *strike*, the score for that frame
is 10 points plus the number of pins knocked down in the next *two* rolls.

Example:
The score for the game "43,X,4/,4-" is 7+(10+4+6)+(10+4)+4 = 45.

## Special case

The 10th frame is a special case.

* If the player makes a *strike* in the 10th frame,
she is given two additional bonus rolls.

* If the player makes a *spare* in the 10th frame,
she is given one additional bonus roll.

In both cases, the score of the 10th frame is the sum of all
the three rolls.

Examples:
* "9-,9-,9-,9-,9-,9-,9-,9-,9-,9-":  (20 rolls: 10 pairs of 9 and miss) = 10 frames * 9 points = 90
* "5/,5/,5/,5/,5/,5/,5/,5/,5/,5/5": (21 rolls: 10 pairs of 5 and spare, with a final 5) = 10 frames * 15 points = 150
* "X,X,X,X,X,X,X,X,X,XXX": (12 rolls: 12 strikes) = 10 frames * 30 points = 300

# Instructions

* Under your `src` folder, create a package named `bowling`.
* Under your `test` folder, create a package named `bowling`.
* Copy [ScoreCalculator.java](bowling/ScoreCalculator.java) into the `src/bowling` package.
* Copy [ScoreCalculatorTest.java](bowling/ScoreCalculatorTest.java) into the `test/bowling` package.

# EXAM

Write test cases for the `ScoreCalculator` class.
You may assume that inputs will always be valid in terms of the format.
That is, you do not have to write test cases for badly-formatted inputs.

Next, implement the `ScoreCalculator` class.

## Grading

* 20 points for the completeness and quality of test cases.
* 40 points for correctness of `ScoreCalculator`.
* 40 points for cleanness of `ScoreCalculator`.

