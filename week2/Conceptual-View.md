## Software: concept and code

The purpose of software is to **do something**.  In order to do something useful, software needs **data** and/or **information**.  Some data is needed only while the program is running. Other data is persisted (saved) in files, database, or other form.

* **Calculator** performs calculations for us. The data it needs are numbers to operate on and the operations (or formulas) we want.  Most calculators don't *persist* (save) any information when they exit.
    * behavior (doing): read input, evaluate expression, multiply, divide, etc.
    * data: temporary variables for operands and results.
* **Mobile Contacts**.  What are the actions a Contacts app must provide?  What data/information does it need?  Does it need to persist (store) data?
    * behavior: add contact, find contact, display contact, edit or delete contact
    * data:  persistent storage for contacts, and memory for currently displayed contact(s)
    
### Code View of Software

**Behavior** or **actions** are coded into **functions** or **methods**.  "Methods" refer to behavior (functions) of an object or class.

**Data** held in **memory** and referred to using **variables** while the software is running.  But, data in memory is lost when the program stops running! For longer term storage, data is stored in files, databases, and network resources.  Storing data is sometimes called **persistence**.

### Example

1. A program to greet a person.

2. Ask a person his name and then greet him.

3. Has only a `main` method, but invokes `nextLine()` method of Scanner and `println` method of System.out.

> In Java, Python, C# and many other languages, you invoke a method
> of an object by writing `object.methodname( )`.
> For example, String is an object. Java Strings have methods like:
>
> `"hello".toUppercase()`, `"Java is easy".length()`
>
> A class also has methods of its own.  For example:
>
> `Math.sqrt(2.0)`, `Math.pow(10.0,7)`

```
import java.util.Scanner;
/**
 * A class to greet someone.  Uses only static behavior.
 */
public class Greeter {
    // This defines a static attribute of the Greeter class.
    /** Scanner is used to read from the input. */
    static Scanner console = new Scanner(System.in);

    /** Main method is where program execution starts. */
    public static void main(String [] args) {
        System.out.print("What's your name? ");
        // read person's name and save it as variable who
        String who = scanner.nextLine( );
        // print a greeting
        System.out.println("Hello, " + who);
    }
}
```
