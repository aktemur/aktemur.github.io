---
layout: cs534default
title: Lectures
---

## Project Topic: Epidemic Simulation

_Adapted from <http://lamp.epfl.ch/files/content/sites/lamp/files/teaching/progfun/assignments/simulations-epfl.html>_

**Goal:** Simulate a contagious disease spread.

**Scenario:** The world is a NxN grid of countries.
Each country may hold an unlimited number of people.
A contagious virus is making people sick.
When a person becomes sick, she looks unhealthy.
When a person becomes infected,
she does not immediately get sick, though,
but enters a phase of incubation in which she is
infectious (i.e. can transmit the virus to other people)
but not sick (so she looks as if she is healthy).
People infected with the virus (whether visibly or not)
may transmit it to other people in the same country.

To avoid the virus, people travel across countries.
They avoid countries that hold visibly sick people.
Unfortunately, travelling people means the virus finds
opportunity to spread to the whole world.

Simulate the disease according to the following rules:

1. Each country, except those at the edge of the world, has 4 neighbors
   at the north, south, west, east side.
   Countries are connected to their neighboring
   countries. A person can travel from a country to a neighboring country.
   A direct travel from a country to another is otherwise not possible.

2. At the beginning, there are P people in the world.
   As an initial condition, X% of them are infected with the virus
   (but they are not sick yet).
   Initially people are assigned to countries uniformly at random.

3. After 6 days of becoming infected,
   a person becomes sick and is therefore visibly infectious
   (i.e. other people can understand that she is unhealthy).

4. After 14 days of becoming infected,
   a person dies with a probability of 25%.
   Dead people do not move, but stay visibly infectious.

5. After 16 days of becoming infected,
   a person becomes immune and is no longer visibly infectious,
   but remains infectious.

6. After 18 days of becoming infected, a person turns healthy.
   He is now in the same state as he was before his infection,
   which means that he can get infected again.

7. Each step of the simulation corresponds to one simulated day.

8. At the beginning of the simulation,
   each person decides when to move within the next 5 days.
   More precisely, she picks the moving day uniformly at random
   among the next 5 days. After moving, she repeats the same process.
   For example, if on day 0 the person decides to move after 3 days,
   she will move from her current country on day 3.
   After that move, she will make another decision:
   for example, she may decide to move after 5 days this time,
   so her next move will be on day 8, etc.

9. On the day of each move, a person will pick one of the countries
   available to her with equal probability and will move to it.
   The set of available countries is defined as the neighboring countries
   that contain no visibly infectious people.
   A person avoids countries with sick or dead (visibly infectious) people.
   This means that if a person is surrounded by visibly infectious people,
   she does not change position; however, she might change position
   the next time she tries to move
   (for example, if a visibly infectious person
   moved out of one of the neighbouring countries or became immune).

10. When a person moves into a country with an infectious person
    she might get infected according to the transmissibility rate of 40%,
    unless the person is already infected or immune.
    A person cannot get infected between moves
    (this is slightly unrealistic, but will simplify your implementation).


### User Interface

The P, X, and N are parameters of the simulation.
You must display the number of healthy,
infected, sick, and dead people
at the end of each day.
These numbers should be displayed for each country,
plus the whole world.
You must implement the interface according to the MVC principle.
If you're working in pairs, you should have a graphical UI;
otherwise, you may just have a command line interface.


### Extensions

New rules may become available later...
For example, the world health organization may take precautions
to fight the disease.
Such changes in the requirements will be announced later.
