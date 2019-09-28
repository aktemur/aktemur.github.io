---
layout: cs222default
---

# Using SVN on Eclipse

## Step 1: Check-out the project from the repository
First, you need to check out project file from your repo.
Below, I will use `<WORKSPACE>` to refer to your
Eclipse workspace folder.
I will assume your project is named `simpleNoteTaker`.

### On Mac and Linux

1.  Open a terminal window. Go into your workspace:

    ```
    $ cd <WORKSPACE>
    ```

2.  Now use the svn command to check out the project.

    ```
    $ svn co --username kivanc.tatlitug https://srl.ozyegin.edu.tr/cs222hws/sp16/kivanc.tatlitug/simpleNoteTaker
    ```
    where you should replace `kivanc.tatlitug` with your username, and
    `simpleNoteTaker` with the assignment folder name.

It is possible that `svn` command does not exist.
In this case, on Mac, the terminal will most likely pop up a window
asking if you want to install command-line tools. Click on Yes.
On Linux, you will need to install subversion. Ask Google to see how to do this.

### On Windows
1. Install the Tortoise SVN client.

2. Use your window explorer to go to the <WORKSPACE>.

3. Do a right click. Pick "SVN Checkout".

4. Enter the URL, username, password, etc. to check out the project folder.

## Step 2: Import the project into Eclipse
In the previous step, you downloaded project files
into your workspace. Now is the time to tell Eclipse
that you have a new project.

1. In the "File" menu of Eclipse, click on "Import...".

2. Choose "General -> Existing project into workspace"

3. As the root folder, choose <WORKSPACE>.

4. `simpleNoteTaker` should show up in the list below.

Now, you should be able to write new code.

## Step 3: Commit the files to the repository
When you are done, and want to send your code to the repo,
do the following things:

### On Mac and Linux
1.  Open a terminal window. Go into your project folder.

    ```
    $ cd <WORKSPACE>/simpleNoteTaker
    ```

2.  Use the `svn` command to commit as follows:

    ```
    $ svn commit -m ""
    ```


That's it!
To make sure that everything's OK,
use your browser (e.g. FireFox, IE, Safari, Google Chrome, etc)
and go to `https://srl.ozyegin.edu.tr/cs222hws/sp16/kivanc.tatlitug/simpleNoteTaker`
to check the file contents.

### On Windows

1. Use your window explorer to go to <WORKSPACE>.

2. Do a right click on the `simpleNoteTaker` folder. Choose "SVN Commit..."

3. Enter a message, or leave empty, and commit.


That's it!
To make sure that everything's OK,
use your browser (e.g. FireFox, IE, Safari, Google Chrome, etc)
and go to `https://srl.ozyegin.edu.tr/cs222hws/sp16/kivanc.tatlitug/simpleNoteTaker`
to check the file contents.
