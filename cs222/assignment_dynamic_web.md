---
layout: cs222default
---

## Assignment 4.1 - Dynamic web content

**Due:** April 9, Wednesday, 16:00.  
**Language:** Python  
**Submission:** Check out `Assignment_4` from SVN. Commit a file named `doviz.py`.
Watch [this video](https://vimeo.com/91285459) to see how to use SVN without an IDE.
**Goal:** Create a web page by reading the JSON feed of exchange rates for the Turkish Lira.

### Python
You will implement this assignment in Python **2.7**.
Hence, first thing your should do is study Python.
[Google's Python Class](https://developers.google.com/edu/python/)
is an excellent source for this purpose.
(There are a zillion other superb sources, too, of course).
Study the material upto and including `Dicts and Files`.

In this assignment, you may NOT use third-party libraries.
Only built-in libraries of Python must be used.

### JSON
[JSON](http://en.wikipedia.org/wiki/JSON)
is a format to exchange data (in particular over the web).
It is designed to be human-readable. 
A JSON value basically can be

* a number
* a string
* an array of JSON values
* a dictionary where keys are strings, values are other JSON values. 

In this assignment, you will use a web service that provides
the currency exchange rates as a JSON feed.
Use the following web service for this purpose:
<http://api.piyasa.com/json/?kaynak=doviz_guncel_serb>

The following two web sites offer a nice way of parsing and visualizing JSON data.

* <http://jsonviewer.stack.hu>
* <http://jsonviewer.net>

### The Problem
Your task in this problem is to write a Python program that
generates a web page (named **currency.html**) by outputting HTML code.
The web page should read the exchange rates and display them in a nice format,
such as a table.
Do **NOT** try to parse the JSON data manually.
There are libraries that will allow you do that in one line of code.
When opened with a browser, your HTML output should look nice.

Do some nice things when displaying the results.
For instance, display the change in the currency in red color if it has decreased,
and in green color if it has increased; alternate table row background colors for
better readability, etc.

### Grading
+ Read and display the currency rates: 10
+ GUI: 5
