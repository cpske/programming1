
### Structure of a Java Program

Java source code is contained in *methods* that are part of a *class*.
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
This code should be in a file `Greeter.java`.
Java requires that source file names **exactly match** the name of the class they contain.  

**Wrong**: `greeter.java` (lowercase "g"), `Greet.java` (name doesn't match)

If you have a class named `Person` then it should be in a file named `Person.java`.  If not, the compiler will give an error message.

### Compiling and Running a Program

You must compile Java code before you can run it. The command for this is **javac**. First verify that `javac` is on your shell (or command window) PATH by typing:
```
cmd>  javac -version
```
The output print the version number (e.g., `java 1.8.0_121`).
If you get "command not found", it means the JDK programs directory isn't on your command interpreter (or "shell") PATH.  The Java commands are in the directory `JAVA_INSTALL_DIR/bin`.  You should add this directory to your path. This depends on OS.

To compile the Greeter class on the command line enter:
```
cmd>  javac Greeter.java
```

The compiler (javac) will create a file containing Java "byte code" for your class. For `Greeter.java` the output will be `Greeter.class`.  Java byte code files always have `.class` extension.

Run the byte code in the Java Virtual Machine (JVM).  The command is `java`.  Just type:
```
cmd>  java Greeter
```
note that you type just the class name (Greeter), **not** Greeter.class.

### What's a *Java Virtual Machine* and why bother?

The Java compiler produces hardware-independent byte code.
The "byte code" is instructions for a virtual machine, aka the Java Virtual Machine (JVM).  The JVM is the same for all computers, so you can run the
same byte code on any computer that has a JVM.  As a developer, this
means you can write and compile your code once, and users can run it
on any platform that has a JVM.  The only requirement is that the JVM
must be at least the minimum version you used for compiling your source.
(*If your code is compiled for Java 8 and someone only has a Java 7 JVM
then it won't run.*)

### Experiments

1. Compile Greeter.java to produce Greeter.class.  Give the
`Greeter.class` file to someone using a different kind of computer
(e.g. if you have a PC running Windows, give it to someone using a Mac).
Verify that they can run it!

2. Modify Greeter.java to display the Java version (see below). Compile it for an older version of java using the `-source` and `-target` flags.  Install an old version of the JRE (or find a computer with one) and run it.

Modified Greeter to show OS and Java version:
```
public class Greeter {
    public static void main(String[] args) {
        String ver = System.getProperty("java.version");
        String os  = System.getProperty("os.name");
        System.out.println("Hello, Human. You are running Java "+ver
                +" on "+os);
    }
}
```
To compile for Java 1.6 (aka Java 6) use:
```
cmd> javac -source 1.6 -target 1.6 Greeter
```

Suppose Java 6 JRE is in directory /java/jdk6/jre/bin (Java 7 would also work) then you could run Greeter.class using:
```
cmd> /java/jdk6/jre/bin/java  Greeter
```
It should print:
Hello, Human. You are running Java 1.6.0_24 on Windows 
```
The update (24) and OS (Windows) may vary.

