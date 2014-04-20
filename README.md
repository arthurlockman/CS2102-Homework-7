
[Source](http://web.cs.wpi.edu/~cs2102/d14/hw7.html "Permalink to Homework 7 - Implementing a Visitor for a Tree")

# Homework 7 - Implementing a Visitor for a Tree

##  CS 2102 - Dterm 14

##  Homework 7 - Implementing a Visitor over a Binary Search Tree

###  Due: Thursday, April 24 at 5pm

(Project Presentation Day, no class that day)


## Assignment Goals

  * To implement function objects in Java
  * To be able to implement a visitor over a tree

##  Problems

The Chamber of Commerce maintains a database on various attractions in New York City. The information in the database is organized in a binary search tree. There are three kinds of attractions - hotels, museums, and restaurants. Each attraction has a name and a location. The location is specified as the intersection of an avenue and a street - for example, the location representing 7th Avenue and 85th Street is stored as the two integers 7 and 85. Museums have an admission fee. Hotels and restaurants are rated. The rating system is from 1 to 5. Rated attractions support a method highlyRated() which returns true if the attraction has a rating of 4 or 5.

  1. Design a class hierarchy to represent attractions. Abstract out common fields and methods where feasible.
  2. Design a binary search tree to hold attractions. The attractions will be stored in the BST alphabetically according to the name of the attraction. (To make the problem a little simpler, you don't have to check for duplicates.) You need to provide an addElt() method that consumes an attraction and produces a BST with the attraction added.
  3. Although the attractions are stored in a BST, potentially making the search for a particular element more efficient, we also want to be able to traverse the entire tree, visiting each node. In this assignment, "visiting" a node will mean deciding whether or not a node meets some selection criterion. So, for example, a tourist might be interested in knowing what attractions can be found in the area above 65th Street. Or, it may be desired to know whether the database contains any highly rated attractions.

Design a visitor interface called ISelect that provides a visitor called choose(). choose() returns true if a given item meets the criteria for selection, and returns false otherwise. Then create two classes that implement ISelect. One of the classes, TopRated, selects an attraction if it is highly rated (if the attraction is not a rated attraction, it is not chosen). The other class, LocatedAbove, selects an attraction if it is located above a specified street.

  4. Create appropriate accept() methods for each of the attraction variants.
  5. Provide the following traversal methods for the BST:

        // does this BST contain any attractions that satisfy the given criteria?
    boolean containsAny(ISelect s);

    // do all of the attractions in this BST satisfy the given criteria?
    boolean allAre(ISelect s);

    // filter this BST of attractions, returning a list of attractions that
    // satisfy the given criteria
    LinkedList  filter(ISelect s);


## Grading

Here is the [general grading rubric][1] for the assignments in this course.

_Programs must compile in order to receive credit._ Programs must run in order to receive credit for Examples and Test Cases. Code that is commented out will not be graded.

## What to Turn In

Using [web-based turnin][2], submit .java files (as a .zip file) containing the final versions of all classes, interfaces, and examples developed for this assignment. Do not submit the .class files.

* * *

   [1]: http://web.cs.wpi.edu/common/general-design.txt
   [2]: https://turnin.cs.wpi.edu:8088/turnin.rkt
  