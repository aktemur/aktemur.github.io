---
layout: cs222default
---

## Assignment 4.3 - More CS Airlines 

**Source:** This assignment is adapted from 
[UIUC's CS242](https://wiki.engr.illinois.edu/display/cs242sp13/Assignment+2.0).  
**Due:** April 28, Monday, 13:00.  
**Language:** Python  
**Submission:** This is a continuation of the previous assignment, which was located in the 
**Assignment_4** folder.
Modify your files and add new files as needed. Then commit.
Do not forget to do an `svn add` first for the new files. 

### Visualization

Your first task is to visualize CSAir's route map using the 
[Great Circle Mapper](http://www.gcmap.com). First, learn how GCM works:

1. Open a web browser to <http://www.gcmap.com>.
2. In the text box at the top, type a comma separated list of routes. 
   For example, you might enter LIM-MEX, LIM-BOG, MEX-LAX
3. Click on the map button.

Notice how when you do this, the Great Circle Mapper 
automatically generates a route map for you. 
Try playing around with some of the options to edit/enhance the generated image.

### Task 1
Extend your CSAir program with a user menu option
to generate a GCM URL that shows **all** the (nonstop) CSAir flights.

### Task 2
Extend your CSAir program with a user menu option
that prompts the user to enter a city code, then
generates a GCM URL that shows all the (nonstop) CSAir flights that
depart from that city.

### Task 3
Add another menu option that prompts the user to enter a route. 
Then print information about that route.

#### Route:
A route is a list of city codes. E.g. BOG-LIM-MEX-LAX is a route that includes 
the flights BOG-LIM, LIM-MEX, MEX-LAX (in this order). 
Its your task to first check that the route entered by the user is a valid route.

#### Route info:
Print the following information regarding a route: 

1. The total distance of the route
2. The cost to fly the route
3. The time it will take to travel the route
4. GCM URL to the visual map

**Route cost:**
To calculate cost, the first leg of any flight will cost **$0.35** per kilometer traveled. 
Each additional leg will cost **$0.05** less per kilometer. 
If the cost for a leg of the route becomes free, keep the cost free for the rest of the route. 

**Route time:**
CSAir operates a fleet of jets that all have a cruising speed of 750 kph. 
Each jet spends the first 200 kilometers of its flight uniformly 
accelerating from 0 kph to 750 kph, stays at 750 kph while it is cruising, 
and then decelerates uniformly from 750 kph to 0 kph during the last 200 kilometers of its flight. 
If a flight is less than 400 kilometers in distance, 
the jet accelerates uniformly for the first half of the flight and decelerates 
uniformly for the second half of the flight. 
In addition, passengers will experience some layover time while waiting at airports 
for connecting flights. The schedule to determine the layover time works as follows. 
The airport with the least number of outbound flights (i.e. 1) 
has a layover time of 2 hours. For airports with 2 outbound flights, 
the layover time is 1hr 50min. 
Continue subtracting 10 minutes 
for each additional outbound flight that CSAir has from an airport to calculate its layover time.

**Route map:** This is the GCM URL generated for the given route.

### Task 4: Shortest Route
Extend the CSAir program with a menu item that prompts the user to enter two cities, then
finds the **shortest route** between the two cities and prints the information (i.e. distance, cost, time, GCM URL).
about that route.

To do this, you will need to employ [Dijkstra's algorithm](https://en.wikipedia.org/wiki/Dijkstra's_algorithm).
The basic outline of the algorithm on Wikipedia 
does a good job of laying out the steps to perform it. 
You will probably need to modify your graph data structure to handle marking nodes as visited. 
It is up to you to determine how to do this. 
Also, think about what other data structures 
you could use to improve the running time of this algorithm. 

Please note, if you decided to find a version of the algorithm that is already written and cite it, 
you will **not** be penalized for **plagiarism**, 
but you will **not** get credit for this portion of the assignment, 
so please write your own implementation from scratch to get a high score.

### Testing
A web-based version of this assignment is available at
<http://srl.ozyegin.edu.tr/cgi-bin/csair.py>

Note that I'm NOT asking you to develop a webpage;
I just want a console program from you.
However I'm providing you with this web page so that you can
check whether your calculations are the same as mine.

### Grading

Requirements

* Task 1 (Generate GCM URL for all the flights) - 1
* Task 2 (Generate GCM URL for a single city) - 1
* Task 3 (Route info)
  * Read and parse user input, print route info - 1
  * Cost & duration - 3
  * GCM URL - 1
* Task 4 (Dijkstra) - 4
* Error handling (i.e. your code handles bad input gracefully) - 3

Clean Code

* Modular design (classes and methods) - 6
* Other things (naming, comments, format, etc) - 4


