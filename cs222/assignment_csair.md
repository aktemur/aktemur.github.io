---
layout: cs222default
---

<a name="Part_I"></a>

## CS Airlines, Part I

**Source:** This assignment is adapted from 
[UIUC's CS242](https://wiki.cites.illinois.edu/wiki/display/cs242fa14/Assignment+2.0).  

**Due:** March 17, Tuesday, 23:55.

**Language:** Java

**Submission:** Your project must be called **CSAir**.
  Your main file must be called **CSAir.java**.

**Context:** You are a senior software engineer for a new international airline, CSAir. 
For CSAir to start selling tickets, 
some software needs to be written to manage the extensive route map. 
Being the senior software engineer of CSair, it's of course your task
to write this wonderful program.
The initial requirements for this new software are:

1. Parse the raw data that represents CSAir's route map into a data structure in memory.
2. Allow users of the software to query data about each of the destinations that CSAir flies to, 
   including its code, name, country, continent, timezone, longitude and latitude, 
   population, region, and each of the cities that are accessible via a single non-stop flight from that destination.


### Flight information

CSAir's flight information has been provided to you as a [JSON](http://en.wikipedia.org/wiki/JSON) file 
[here](data/csair.json).
In Java you'll need to use a [JSON API](https://code.google.com/p/json-simple/)
to parse the contents of the file.

### Task 1 - Object formation

Read the JSON data and convert it to in-memory City and Flight objects that point to each other.
That is, you will have City objects that keep information
such as the code, population, region, etc. of the city as
well as the flights departing from that city.
Similarly, you will have Flight objects that keep the distance and
the source/destination cities.

Note that if there is a flight from city A to B,
having a direct reference from city A to city B is not sufficient, because you have 
to keep the distance information for a flight.

Also note that in the JSON data, there is only one flight listed between
a pair of cities. This stands for **two** flights (one from city A to B,
the other from B to A).

In this part, you have to write your own City and Flight classes.

### Task 2 - User interaction 

Provide a console-based interaction for the user to run queries on your data.
Your interface should allow the user to:

1. Get a list of all the cities that CSAir flies to
2. Get specific information about a specific city in the CSAir route network. This information should include:
   1. Its code
   2. Its name
   3. Its country
   4. Its continent
   5. Its timezone
   6. Its latitude and longitude
   7. Its population
   8. Its region
   9. A list of all of the other cities that are accessible 
   via a single non-stop flight from that source city. 
   This list should include the distance of each of those flights.
3. Statistical information about CSAir's route network:
   1. the longest single flight in the network
   2. the shortest single flight in the network
   3. the average distance of all the flights in the network
   4. the biggest city (by population) served by CSAir
   5. the smallest city (by population) served by CSAir
   6. the average size (by population) of all the cities served by CSAir
   7. a list of the continents served by CSAir and which cities are in them
   8. identifying CSAir's hub cities: the cities that have the most direct connections.

All of this information should be calculated at query time from your objects 
and not be hard-coded into your source. 
Your program should be console-driven, that is it should start up, 
prompt the user for input, and be able to perform any combination of valid operations without exiting. 
Also, be careful to check for invalid input. 
For instance, what happens when a user queries data about a city that CSAir does not fly to?
The JSON data should be parsed once at the beginning of the program. After you construct your objects,
do NOT use the JSON data to calculate the answer to a user query; all those calculations must be 
done through the objects.

### Hints

Watch [this video](https://vimeo.com/122146680).

### Demo

Watch [this video](https://vimeo.com/123639680).

### Grading

* Functionality
    * Construction of the objects: 6
    * User-interaction queries (blatantly inefficient algorithms will be penalized): 10
* Clean code
    * Naming: 3
    * Modular structure, split into well-designed functions and classes: 8
    * Proper comments: 2

Penalty: Up to 10 points for bad format.

---

<a name="Part_II"></a>

## CS Airlines, Part II

**Due:** March 31, Tuesday, 23:55.

### Task 1

Complete Part I if you have any missing features.
Refactor your code to come up with a clean design.
Make sure that you have an object graph, where
your City objects have pointers to Flight objects,
and Flight objects have pointers to City objects.

### Task 2

Extend your menu to allow the user to

* add a new city to CSAir, by specifying its
  name, code, region, timezone, etc.
* add a new flight by specifying its source and
  destination city codes and the distance.
* remove a city by specifying its code.
  Note that this should also remove all the
  flights associated with that city.
* remove a flight by specifying its source
  and destination city codes.

### Task 3

Extend your menu to allow the user to

* print the CSAir data on the screen in JSON format.

### Grading

TBD


---

<a name="Part_III"></a>

## CS Airlines, Part III

**Due:** April 7th, Tuesday, 23:55.

**Goal:** Practice Test-Driven-Development by writing unit tests.

### Prologue
Read [Wikipedia article on Test-Driven Development](http://en.wikipedia.org/wiki/Test-driven_development).

Read Clean Code Chapter 9: Unit Tests, Chapter 15: JUnit.

Check the [Resources](resources.html) page for the TDD
exercise we did in the class.

### Itinerary
An **itinerary** is a list of connected flights.
E.g. BOG-LIM-MEX-LAX is an itinerary that includes 
the flights BOG-LIM, LIM-MEX, MEX-LAX (in this order).
Each flight in an itinerary is called a **leg**.

Copy the following `Itinerary` class to your project.

```java
public class Itinerary {
    public Itinerary(Flight firstLeg) {
        // TODO Write test cases first
    }
    
    public void appendCity(City city) {
        // TODO Write test cases first
    }
    
    public double cost() {
        // TODO Write test cases first
        return 0;
    }
    
    public double duration() {
        // TODO Write test cases first
        return 0;
    }
    
    public int distance() {
        // TODO Write test cases first
        return 0;
    }
}
```

You can add fields and auxiliary methods into this class
as you see fit. Do NOT change the signature of the given methods.

To expand an existing itinerary with a new leg, use the
`appendCity` method. This method should raise an
`IllegalArgumentException`
if there does not exist a direct flight from the last city
of the itinerary to the new city.
For instance, if we have an itinerary that is currently
IST-MIL-ESS, 
it should not be possible to
append LAX to this itinerary because there is no
direct flight from ESS to LAX.

`cost`, `distance` and `duration` methods
are supposed to return values according to the following
definitions:

#### Distance:
The total distance of an itinerary is the sum of the
distances of its legs.

#### Cost:
An itinerary has a cost.
To calculate cost, we have the following algorithm:
the first leg of any flight costs **$0.35** per kilometer traveled. 
Each additional leg costs **$0.05** less per kilometer. 
If the cost for a leg of the itinerary becomes free,
keep the cost free for the rest of the itinerary. 

#### Duration:
CSAir operates a fleet of jets that all have a cruising speed of 750 kph. 
Each jet spends the first 200 kilometers of its flight uniformly 
accelerating from 0 kph to 750 kph,
stays at 750 kph while it is cruising, 
and then decelerates uniformly from 750 kph to 0 kph during the last 200 kilometers of its flight. 
If a flight is less than 400 kilometers in distance, 
the jet accelerates uniformly for the first half of the flight and decelerates 
uniformly for the second half of the flight. 
In addition,
passengers experience some layover time while waiting at airports 
for connecting flights.
The schedule to determine the layover time works as follows. 
The airport with the least number of outbound flights (i.e. 1) 
has a layover time of 2 hours.
For airports with 2 outbound flights, 
the layover time is 1hr 50min. 
Continue subtracting 10 minutes 
for each additional outbound flight that CSAir has from an airport to calculate its layover time.

### Task 1
Write JUnit test cases for the `Itinerary` class.

**You should write test cases before you implement the
Itinerary class.**

Once you write test cases, **commit** your file to SVN.
**Then** start implementing the `Itinerary` class.
Finally commit again.

[Here is a video](https://vimeo.com/124029500) to help you get started.

### Task 2
Extend the console-based menu of your program to
read an itinerary from the user as a comma-separated list
of city codes.
Then print the distance, cost, and duration information.

If an itinerary cannot be formed according to the user input,
output an appropriate warning message.
E.g. If the user enters `IST,MIL,LON`,
print "`There is no flight from MIL to LON.`"
If the user enters `IST,ZZZ,LON`,
print "`ZZZ is not a valid city code.`"


### Demo
A web-based CSAir application is available at
<http://srl.ozyegin.edu.tr/cgi-bin/csair.py>

You can check the distance/cost/duration values
for itineraries on this web page.

Note that I'm NOT asking you to develop a webpage;
I just want a console program from you.
However I'm providing you with this web page so that you can
play around.





