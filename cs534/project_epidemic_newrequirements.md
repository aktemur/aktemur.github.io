---
layout: cs534default
title: Lectures
---

## New Requirements for the Epidemic Simulation

1. The world is not flat anymore; it is round.
   That is, the countries in the upper edge of the grid are neighbours
   with those on the lower edge. Similarly,
   left edge countries are neighbours with the right edge countries.

2. There are genetically super people in the world (_S_% of the population,
   where _S_ is taken as a parameter
   at the beginning of the simulation). These super people never get infected. 
   
3. World Health Organization developed a vaccine.
   There are doctors (_D_% of the population; taken as a parameter
   at the beginning of the simulation) that can apply the vaccine.
   A doctor can vaccinate at most _V_ people (_V_ is a parameter)
   each day. A Doctor can vaccinate people that are in the same country
   with the doctor.
   Only healthy people are vaccinated.
   Once vaccinated, a person becomes immune for life.

4. There is air traffic. When a person decides to travel,
   with _A_% probability (_A_ is a parameter), she chooses to
   use air travel to fly to a random country
   (countries with visibly-infected people
   are NOT avoided). 

On the demo day,
**submit a report** where you discuss how you handled
these new requirements.
What did you need to change in your design?
Were the changes modular, or did you have to touch many scattered parts of your code?
