---
layout: cs534default
title: Lectures
---

## Project Topic: Cartagena Board Game

Relevant links:
* <https://boardgamegeek.com/boardgame/826/cartagena>
* <http://riograndegames.com/Game/63-Cartagena>

In this project you will implement the Cartagena board game.
This is a game that can be played by 2-5 players.
Each player has 6 pirates. The goal is to bring all the 6 pirates
from the start of a path to the end, where there is a boat.
When a player manages to board all of his/her 6 pirates on the boat,
the game ends.

Here are the rules to setup the game.

1. The path is composed of 6 segments.
   Each path segment contains 6 cells, laid out linearly.
   On each cell, one of the following 6 symbols is printed:
   bottle, keys, sword, skull, hat, pistol.
   A segment contains exactly one cell of each symbol.
   Symbols on a segment are ordered randomly.
   The game path is formed by putting 6 segments end-to-end.
   Imagine that the cells are numbered from 1 to 36.
   All the pirates are initially placed at the beginning of the path (i.e. position 0).
   The goal is to reach the boat at the end of the path (i.e. position 37).
   [[Sample segment]](img/segment.jpg)
   [[Sample game layout]](img/cartagena.jpg)
2. There is a deck of randomly shuffled cards.
   On each card, a symbol is printed (the same symbols used on the path).
   There are 30 cards of each symbol.
3. Each player has 6 pirates. Each player has a unique color.
   Possible colors are: blue, yellow, red, green, brown.
4. Initially each player is given 6 cards from the deck.
   The rest of the deck is placed on the table within the reach of each player.

Once the setup is complete, the game starts. Here are the rules of the game play:

1. A player advances a pirate of their choice by discarding a card. If the pirate
   is located at position _n_, it moves to the first **unoccupied** cell at a position greater than _n_
   whose symbol is the same as the discarded card. 
   If there is no such cell,
   the pirate boards the boat.
2. The player may move a pirate of their choice **backwards**.
   In this case, the pirate moves to the first cell **occupied by at most two pirates**.
   The player draws as many cards as the number of existing pirates on the landed cell (1 or 2 cards). 
   It is not possible to perform this move
   if there is no cell in the backward direction that the pirate can land on.
   This would be the case when all the cell behind the pirate are unoccupied,
   or all the occupied cells contain three pirates. 
3. A player can perform one or two plays in one turn.
   That is, these are the possible move a player may perform in a turn:
   * Advance a pirate by consuming a card, then advance a pirate again by consuming a card.
   * Advance a pirate by consuming a card, then move a pirate backwards to draw card(s).
   * Move a pirate backwards to draw card(s), then advance a pirate by consuming a card.
   * Move a pirate backwards to draw card(s), then move a pirate backwards again to draw card(s).
   * Advance a pirate by consuming a card, then skip moving a second pirate.
   * Move a pirate backwards to draw card(s), then skip moving a second pirate.
4. The game ends when a player moves all of their pirates onto the boat.
   That player becomes the winner.
5. All the cards that the players own are placed face-up on the table during the game.
6. If the cards in the deck are completely consumed, re-shuffle the used cards and continue playing.

### Network
Make the game playable over the network.
You may used socket connections for this.
Use the Command pattern to send player moves through the network.

### Submission
Together with your code,
**submit a report** where you discuss how you handled
the requirements.
This report does not need to have too much text.
Include the UML diagrams of your overall design.
You may give more detailed information about the key design choices.
