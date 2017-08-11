# Programming 1 for SKE 2017 students

[About](About.md) the course has required programming tools and documentation.

## Topics for this week

1. [Review](week2/Review.md)

2. [Intro to Java](week2/Intro-to-Java.md), [slides](week2/0-Intro-to-Java.pdf)

3. [Program Structure](week2/Program-Structure.md) and [slides

### 2. Tools You Need

See [Tools.md](Tools.md) for how to download. You need

1. Java Development Kit (JDK) version 8.
2. Java Documentation  
3. Coding tool (IDE). Please try BlueJ - its very visual and lets you try out code without compiling. We use BlueJ in class.

### 3. Recommended Textbook

*Big Java, 5th Ed.* by Cay Horstmann.  Book is easy to read, but long.  Horstmann is a well-known author.  He also wrote *Core Java*, a favorite of programmers. *Big Java* may be available online.


### 6. Using the IDE

BlueJ and other IDEs will compile and run code for you, so you don't need to use the command line `javac` and `java`.

### 7. Conceptual View of Software

The purpose of software is to **do something** for us.  In order to do something useful, software also needs *data* and/or *information*.  Some data is used only while the program is running. Other data is persisted (saved) in files, database, or other form.

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

   * String methods: `"hello".toUppercase()`, `"Java is easy".length()`
   * Math methods:   `Math.sqrt(2.0)`, `Math.pow(10.0,7)`
   * System methods: `System.getProperty("os.name")`
   * Output methods: `System.out.println("I am a robot")`
