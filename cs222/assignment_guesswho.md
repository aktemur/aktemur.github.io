---
layout: cs222default
---

# Guess Who

In this homework, you will implement the game of [Guess Who](https://en.wikipedia.org/wiki/Guess_Who%3F).

**Due:** Commit until **10:00 AM** on the day of lab sessions.
Your homework will be graded when all 3 parts are complete.

## Setup

Checkout project `GuessWho` from SVN. To submit, commit your changes.

## Part I

Implement the following simplified version of the game:
There are 24 figures. Each figure has certain features, listed as follows:

* The figure has a name.
* The figure is male or female.
* The figure's eyes are either brown or green.
* The figure may be bald.
* The figure may have beard.
* The figure may be wearing a hat.
* The figure may be wearing glasses.

Your program should generate 24 figures, whose features are randomly decided,
and print these figures' information.
Then randomly pick one of the figures.
The user will try to guess this secret figure.
For this, your program should prompt the user to enter Yes/No questions.
At any point, the user may want make a guess by entering the name of a figure.
If guessed correctly, the user wins. If an incorrect guess is made, the user loses.

Here is a sample output:

```
Welcome to "Guess Who?"
Figures:
1. James (M, brown eyes, bald, has beard, no hat, no glasses) 
2. Kyle (M, green eyes, not bald, no beard, no hat, no glasses) 
3. Jake (M, brown eyes, not bald, has beard, no hat, no glasses) 
4. Nick (M, green eyes, bald, no beard, no hat, with glasses) 
5. Rachael (F, brown eyes, not bald, no beard, has hat, no glasses) 
6. Justin (M, brown eyes, not bald, has beard, no hat, no glasses) 
7. Tyler (M, brown eyes, not bald, has beard, no hat, no glasses) 
8. Andy (M, brown eyes, bald, has beard, has hat, no glasses) 
9. Emily (F, green eyes, not bald, no beard, no hat, with glasses) 
10. Alex (M, brown eyes, bald, no beard, no hat, with glasses) 
11. Connor (M, brown eyes, not bald, no beard, no hat, no glasses) 
12. Zachary (M, brown eyes, bald, no beard, no hat, no glasses) 
13. Sarah (F, brown eyes, not bald, no beard, no hat, with glasses) 
14. Ashley (F, brown eyes, not bald, no beard, has hat, no glasses) 
15. Brandon (M, brown eyes, not bald, no beard, has hat, no glasses) 
16. Megan (F, green eyes, not bald, no beard, no hat, no glasses) 
17. David (M, brown eyes, bald, has beard, no hat, no glasses) 
18. Joseph (M, green eyes, not bald, no beard, no hat, with glasses) 
19. William (M, brown eyes, not bald, has beard, no hat, no glasses) 
20. Daniel (M, brown eyes, not bald, no beard, has hat, no glasses) 
21. Matt (M, brown eyes, not bald, no beard, no hat, no glasses) 
22. Joshua (M, brown eyes, not bald, has beard, no hat, no glasses) 
23. Chris (M, brown eyes, not bald, no beard, has hat, no glasses) 
24. Jon (M, brown eyes, not bald, has beard, no hat, no glasses) 

What's your question? Make your choice.
1. Is the secret figure male?
2. Does the secret figure have brown eyes?
3. Is the secret figure bald?
4. Does the secret figure have beard?
5. Does the secret figure have a hat?
6. Does the secret figure have glasses?
7. I want to guess!

?> 2
Yes.

?> 4
No.

?> 5
Yes.

?> 1
No.

?> 7
Who is it?> Ashley

Correct! You found the secret figure by asking 4 questions.
Bye.
```

Here is another possible ending:

```
?> 7
Who is it?> Rachael

Nope, loser.
Bye.
```

### Guideline

For this homework, the major points you should pay attention are the following:

* Names should conform to Java's `camelNotation` convention.
  Class names should start with an uppercase letter,
  variable and method names start with a lowercase letter.
  Constants should be `ALL_CAPITALS`.
* Class names should be nouns.
* The names of the methods whose return type is `void` should be a verb.
* The names of the methods whose return type is NOT `void`, should be determined
  according to the context. The convention is to use `get`/`set` for the accessor methods.
  Sometimes it's OK to have nouns for non-void methods. E.g.: `message.size()`, `list.length()`.
* Predicate methods and `boolean` methods should be named properly. 
* Methods should be short.
* Methods should be ordered according to the stepdown rule.
* Names should not be too long, or too short (e.g. no single-character names except for loop counters).

<a name="PartII"></a>

## Part II

In the second part of the homework,
you will extend the program for the following functionality:

* Read figure attributes from a file.
* An eye color can be brown, blue, green, or black.
* Figures have age as an attribute.

At the start of the program, you will take a file name as an input.
You will then read the contents of the file to create figures.

The most important thing is, you will NOT pick a figure randomly and answer
questions about that figure.
Instead, you will have a basic notion of an AI to
prevent the user from narrowing down the possibilities
as much as possible.
This will be done as follows:
When the user asks a question, count the number of figures for which
the answer would be a Yes, and count those for which the answer would be
a No. Prefer the anwer which leaves the higher number of figures as possible candidates.

For instance, suppose we have 24 figures, of which 5 have hats, and 19 don't.
If the user asks "Does the secret figure have a hat?",
answering "Yes" leaves 5 figures among which the user can make a guess, while
answering no leaves 19 figures. So, you should prefer to answer "No".
Of course, you are not allowed to cheat;
when the user asks the second question (e.g. about wearing glasses),
you now have to make a decision by analyzing the remaining 19 figures -- the 5 figures
wearing a hat are gone.

The game ends when there is only one possible figure left for an answer.

Here is a sample output:

```
Welcome to "Guess Who?"

Enter file name: funfigures.txt

Figures:
1. James (M, 18, black eyes, bald, has beard, no hat, no glasses) 
2. Kyle (M, 35, green eyes, not bald, no beard, no hat, no glasses) 
3. Jake (M, 25, brown eyes, not bald, has beard, no hat, no glasses) 
4. Nick (M, 40, green eyes, bald, no beard, no hat, with glasses) 
5. Rachael (F, 20, blue eyes, not bald, no beard, has hat, no glasses) 
6. Justin (M, 30, brown eyes, not bald, has beard, no hat, no glasses) 
7. Tyler (M, 50, black eyes, not bald, has beard, no hat, no glasses) 
8. Andy (M, 30, blue eyes, bald, has beard, has hat, no glasses) 
9. Emily (F, 50, green eyes, not bald, no beard, no hat, with glasses) 
10. Alex (M, 30, brown eyes, bald, no beard, no hat, with glasses) 
11. Connor (M, 20, brown eyes, not bald, no beard, no hat, no glasses) 
12. Zachary (M, 20, black eyes, bald, no beard, no hat, no glasses) 
13. Sarah (F, 45, brown eyes, not bald, no beard, no hat, with glasses) 
14. Ashley (F, 18, blue eyes, not bald, no beard, has hat, no glasses) 
15. Brandon (M, 45, brown eyes, not bald, no beard, has hat, no glasses) 
16. Megan (F, 50, green eyes, not bald, no beard, no hat, no glasses) 
17. David (M, 20, brown eyes, bald, has beard, no hat, no glasses) 
18. Joseph (M, 25, green eyes, not bald, no beard, no hat, with glasses) 
19. William (M, 30, black eyes, not bald, has beard, no hat, no glasses) 
20. Daniel (M, 45, blue eyes, not bald, no beard, has hat, no glasses) 
21. Matt (M, 20, brown eyes, not bald, no beard, no hat, no glasses) 
22. Joshua (M, 18, brown eyes, not bald, has beard, no hat, no glasses) 
23. Chris (M, 20, black eyes, not bald, no beard, has hat, no glasses) 
24. Jon (M, 30, brown eyes, not bald, has beard, no hat, no glasses) 

What's your question? Make your choice.
1. Is the secret figure male?
2. Is the secret figure younger than __ ages?
3. Does the secret figure have brown eyes?
4. Is the secret figure bald?
5. Does the secret figure have beard?
6. Does the secret figure have a hat?
7. Does the secret figure have glasses?

?> 1
Yes.

?> 4
No.

?> 2
Enter the age to check if the figure is younger> 28
No.

?> 3
No.

?> 6
No.

?> 5
Yes.

?> 2
Enter the age to check if the figure is younger> 40
Yes.

You found it in 7 steps! It was William!
Bye.
```

Sample files have been committed to your SVN folder.
Each line of the file contains information for a figure
in the following comma-separated format.

_Name, gender, age, eye color, baldness, beard info, hat info, glasses_

See the committed files for concrete examples.


<a name="PartIII"></a>

## Part III

In this last part you will implement
a bot player that plays Guess Who like a human player.
This should be implemented in a file named **Bot.java**
with a `main` method separate from the one in Part II.

The Bot player, when started, will read information about the figures
from a file, just like in Part II.

The bot will then print a question number on the screen, from 1 to 7.
The questions are the same as in Part II.
For question 2, the bot should also print an integer value for the age
on the next line.

Next, the bot will read the answer of the question.
This will be either "Yes" or "No".

The bot will continue asking questions until there is only one
candidate figure is left. At this point,
the bot will print "I found it in _N_ steps! It is _XYZ_!",
where _N_ denotes the number of questions asked, and _XYZ_ denotes
the name of the figure.

Here is a sample run, where **bold text** is used for the text
entered by the user, and normal text is used for the text printed by the bot.

<pre>
Enter file name: <b>10figures.txt</b>
1?
Your answer: <b>No</b>
2?
25
Your answer: <b>Yes</b>
7?
Your answer: <b>No</b>
3?
Your answer: <b>Yes</b>
I found it in 4 steps! It is MXU!
</pre>

If the user enters answers such that there does not exist a figure
that conforms to those answers, the Bot will print
"That's impossible. You're a liar!" and quit. E.g.:

<pre>
Enter file name: <b>10figures.txt</b>
1?
Your answer: <b>Yes</b>
3?
Your answer: <b>No</b>
5?
Your answer: <b>Yes</b>
That's impossible. You're a liar!
</pre>



### Intelligence

The order of the questions your bot will ask is up to you.
Your goal should be to minimize the number of questions you will
ask to find the secret figure.

**I will run a competition among students. The bots that find the figure with
fewer number of questions will get higher grades.**

### Grading

40% of the grade you receive from this homework will be based on
clean code.
Recall that duplication is a true evil.
Try to reuse appropriate portions of Part II in Part III.

60% of the grade you receive will be based on functional correctness and completeness,
distributed as follows:
* 20%: The correctness of the program in Part II.
* 20%: The correctness of the program in Part III.
* 20%: Will be determined according to your ranking in the competition that I'll run.

Make sure that your input/output text matches the samples I give here exactly.

