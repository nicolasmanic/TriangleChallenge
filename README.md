[![Build Status](https://travis-ci.org/nicolasmanic/TriangleChallenge.svg?branch=master)](https://travis-ci.org/nicolasmanic/TriangleChallenge)
[![codecov](https://codecov.io/gh/nicolasmanic/TriangleChallenge/branch/master/graph/badge.svg)](https://codecov.io/gh/nicolasmanic/TriangleChallenge)

# Triangle Challenge

## Problem
Write a program that will determine the type of a triangle.
It should take the lengths of the triangle's three sides as input, and
return whether the triangle is equilateral, isosceles or scalene.

## Build & Run

### Prerequisite
```
1. Java 8+
2. Maven 3+
```

Since this is a maven project to run the tests use:
```
mvn test
```

To generate a new uber-jar:
```
mvn package
```

There are 2 ways to interact with the application via console or by providing
a csv as input.

To start the application in console mode run:
```
java -jar TriangleChallenge.jar
```

Then you will need to enter 3 integers (comma separated) and the type of
triangle will be printed in the screen.

Another way to work with the application is by providing a (comma separated)
csv file with the lengths of the sides.

eg:
```
1,1,1
3,4,5
2,2,4
...
```

To start the application in csv mode run:
```
java -jar TriangleChallenge.jar FILE NAME.csv
```

## Design Decisions

The application was developed with TDD and SOLID principles in mind. In order
to showcase those principles no popular frameworks were not used.

As described in the Build & Run section, there are 2 ways to interact with the application
either via the console or via a csv file. Both are implementations of a common interface
for future extensibility.

To create a new triangle you need to access the ```TriangleFactory```.
The factory will create a classifier ```TriangleClassifier``` and inject a validation
strategy ```TriangleValidator``` into the classifier in order to validate
if input is correct. Finally if no validation error occur the factory based
on the result of the classifier will return the appropriate ```Triangle```
subclass (```Equilateral, Isosceles, Scalene```).

Finally the project used Travis-CI for continues integration and Codecov for
code coverage analysis.


**Note:** To distinguishes between actual javadoc and explanation for the
design decisions that were taken the ```@impNote``` annotation was
used in source code. For further explanation on why various techniques were
used please search for the corresponding ```@impNote``` annotation