---
layout: cs222default
---

# Assignment: Tbitter

**Language:** Java or C++

**Goal:** Make queries on a super-simple Twiter model

### Setup
Check out the project from
the following URL, where you
should **replace donald.duck with your user name**:

<https://srl.ozyegin.edu.tr/cs222hws/sp15/donald.duck/Tbitter>


### Task
Write a program named `Main` in the **default package**.

Your program will read JSON data that model Twitter.
The data provide user information and who follows whom.
Take a look at `tbitter.json`.

1. Parse the JSON file and construct your `User` objects.
   You may **NOT** change the `User.java` file.

2. Provide two options to the user:

  * Read a Twitter username and print detailed information about that user, including
  the user id, full name, number of tweets, the full names of users followed by this user,
  the full names of users that follow this user.
  * List the Twitter users sorted according to the number of people they follow. 

### Demo

Watch [this video](https://vimeo.com/122973816) to see a short demo.

