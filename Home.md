# Programming 1 for SKE 2017 students

[About](About.md) the course lists required programming tools and documentation.

## Topics for this week

### 0. Review

* What programming structures (or concepts) did you learn at code.org last week?
    * I learned 5.  To get you started:
    1. Code a sequence of instructions to achieve a goal.
    2. (hint: how to use same sequence more than once? 2 ways)
    3. (hint: how to modularize sequence for reuse many times?)
    4. what else?
    5. what else?


### 1. Intro to Java
1. Why Java?

[2017 Annual Language Ranking on IEEE Spectrum](http://spectrum.ieee.org/computing/software/top-programming-languages-2017-focus-on-jobs) ranks Python slightly above C and Java overall (Python 100.0, Java 99.4), but for "Jobs", the ratings are reversed (Java still #1). IEEE Spectrum has an interactive rating tool you can customize the ranking criteria and weights. Data from 10 different sources.

On [Coding Dojo](http://www.codingdojo.com/blog/9-most-in-demand-programming-languages-of-2017/), SQL was most in-demand. Java was #2 (about 68K job postings), Python moved up 2 spots to #3 (40K postings), slightly ahead of Javascript.

2. About the language.

Java is a *compiled*, *statically typed* programming language designed for object-oriented programming.  All code is contained in classes.  Java is very portable -- compiled code can run on any computer with a JVM installed.

3. How Java works.

Java is designed so that the compiled code (called "Java byte code")
can be run on any machine that supports Java.  The same byte code
runs the same on Mac OS, Windows, Linux, or anything with the Java
Runtime installed.

This is different from languages such as C or C#, 
where the code must be recompiled for each target platform.

Slide presentation: [tba]

### 2. Tools You Need

See [tools.md](tools.md) for details. You need the Java Development Kit (JDK), Java Documentation, and a coding tool (IDE). At first, please try BlueJ - its very visual and lets you try out code without compiling. We use BlueJ in class.

### 3. Recommended Textbook

*Big Java, 5th Ed.* by Cay Horstmann.  Book is easy to read, but long.  Horstmann is a well-known author.  He also wrote *Core Java*, a favorite of programmers. *Big Java* may be available online.

Another good book is *Starting Out with Java* by Tony Gaddis. Covers same topics as *Big Java* but more focus on code.

### 4. Structure of a Java Program

All Java code is contained in *methods* that are part of a *class*.
For example:
```java
public class Greeter {
    // a variable referring to a string
    static String who = "Nerd";

    // a method. 'static' means its owned by the class, not an object
    public static void main(String[] args) {

        // Ridiculously verbose syntax for printing to the console
        System.out.println("Hello, " + who);  // prints: Hello, Nerd
    }
}
```

This source code must be in a file named: `Greeter.java`.

Java requires all source files by named **exactly** same as the class they contain, with extension `.java`.

Wrong: `greeter.java` (lowercase "g"), `Greet.java` (name doesn't match)

### 5. Compiling and Running a Program

You must compile Java code before you can run it. The command for this is **javac**. First verify that `javac` is on your shell (or command window) PATH by typing:
```
cmd>  javac -version
```
The output print the version number (`java 1.8.0_121`).
If you get "command not found", it means the JDK programs directory isn't on your command interpreter (or "shell") PATH.  The Java commands are in the directory `JAVA_INSTALL_DIR/bin`.  You should add this directory to your path. This depends on OS.

To compile the Greeter class, on the command line enter:
```
cmd>  javac Greeter.java
```

The compiler (javac) will create a file containing Java "byte code" for your class. For `Greeter.java` the output will be `Greeter.class`.  Java byte code files always have `.class` extension.

To run the byte code use the Java Virtual Machine (JVM).  The command is `java`.  Just type:
```
cmd>  java Greeter
```
note that you type just the class name (Greeter), **not** Greeter.class.

### 6. Using the IDE

BlueJ and other IDEs will compile and run code for you, so you don't need to use the command line `javac` and `java`.

### 7. Conceptual View of Software

The purpose of software is to **do something** for us.  In order to do something useful, software also needs *data" and/or *information*.  Some data is used only while the program is running. Other data is persisted (saved) in files, database, or other form.

* **Calculator** performs calculations for us. The data it needs are numbers to operate on and the operations (or formulas) we want.  Most calculators don't *persist* (save) any information when they exit.
    * behavior (actions): read input, evaluate expression, multiply, divide, etc.
    * data: temporary variables to hold most recent result(s) and current input
* **Contacts** on a mobile phone or email.  What are the actions a Contacts app must provide?  What data/information does it need?  Does it need to persist (store) data?
    * behavior: (t.b.a.)
    * data: (t.b.a.)
    
### 8. Code View of Software

**Behavior** or **actions** are coded into **functions** or **methods**.  "Methods" refer to behavior (functions) that are part of an object or class.

**Data** or **information** is held in **memory** and referred to using **variables** while the software is running.  But, data in memory is lost when the program stops running! For longer term storage, data is stored in files, databases, and network resources.  Storing data is sometimes called **persistence**.

### Example

1. A program to greet a person.

2. Ask a person his name and then greet him.

3. Using methods.

> In Java, Python, C# and many other languages, you invoke behavior (a method)
> of an object by writing `object.methodname( )`.

   * String methods: toUppercase()
