# Programming 1 for SKE 2017 students

## Topics for this week

### 1. How Java works

Java is a compiled, object-oriented programming language.
Its designed so that the compiled code (called "Java byte code")
can be run on any machine that supports Java.  The same byte code
runs the same on Mac OS, Windows, Linux, or anything with the Java
Runtime installed.

This is different from other languages such as C or C#, 
where the code must be recompiled for each target platform.

Slide presentation: [tba]

### 2. Tools You Need

See [tools.md](tools.md) for programming tools. You need the Java development kit (JDK), Java Documentation, and coding tool (IDE). At first, please use BlueJ - its very visual and lets you try out code without compiling.

### 3. Recommended Textbook

*Big Java, 5th Ed.* by Cay Horstmann.  May be available online.

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
