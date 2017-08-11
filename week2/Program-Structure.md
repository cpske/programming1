
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
