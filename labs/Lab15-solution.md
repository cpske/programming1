
Q1. *A class is the definition or blueprint for a kind of object.*

Q2. Key characteristics of objects are: 
  * *state* - the current condition of an object, defined by **attributes**
  * *behavior* - what an object can do, defined by **methods**
  * *identity* - objects are distinguishable, even if they have the same state
   
Q3. Make Student a subclass of Person
```java
public class Student extends Person {
```
   
Q4. Use this code:
```java
Person p = new Student();
System.out.println("p says "+p.toString());  //1.
System.out.println("p is "+p.what());        //2.
```

4.1 `p says I am a Student`.    
4.2 When you invoke an instance method using an object reference, like `p.toString()` the JVM uses the object that `p` refers to in order to execute the method.  Conceptually, its like asking `p` to do something, based on the actual `p` at run-time.  This is polymorphism.  Its also called "dynamic dispatch" or "runtime binding".    
4.3 `p is Person`.    
4.4 `what()` is a static method, so `p.what()` is the same as writing `Person.what()`.  Static methods are associated with a class, not objects of the class, and static methods are not polymorphic. `p.what()` uses the **declared** type of `p` (Person) to decide which class to use. 

Eclipse and IntelliJ show a warning when you write `p.what()`, to remind you that it really means `Person.what()`.


5.1 Local variables are defined inside a method and their lifetime is only while the method is executing.  Each time a method is called, the local variable is created. When the method returns, all local variables are destroyed.    
An attribute is part of an object and its lifetime is the lifetime of the object.  An object remembers its attribute values.

5.2 Answer: (b) From the when object is created until the object is destroyed (or no longer in use by the application).  

When objects are no longer referenced by any part of the application, the JVM recycles their memory in a process called "garbage collection".

6.1 `total` is an attribute and its value is NOT reset to zero before computing the total in `getTotal()`.  Each time getTotal is invoked, the values are being added to the total, so total gets larger and larger.  Many students have made this mistake on quizzes.

6.2 Define 'double total = 0.0;' in the getTotal() method. Delete the `total` attribute.

Q7. Code should be:
```java
public class Question6 {
    
    public double getTotal(double[] x) {
        double total = 0.0;
        for(int k=0; k<x.length; k++) total += x[k];
        return total;
    }
}
```

Q8. Why does `arg.equals(null)` fail if `arg = null`? 

Whenver you write `x.anything()`, it means to invoke the `anything()` method of the object **referred to** by `x`.  If `x` is `null` then `x` doesn't refer to any object!  Invoking `x.anything()` when `x` == null *always* causes a **NullPointerException**.  

## 9. Writing Polymorphic Code

The `KuPOS` needs to use the `getValue()` method of Coin and Coupon. To enable KuPOS to treat Coin and Coupon the same (so we don't need separate methods for Coin and Coupon), we need to make Coin and Coupon somehow "look" the same.

Define the `getValue()` behavior that KuPOS wants in a superclass named Money, and declare that Coin and Coupon are subclasses.

```java
/** Superclass for all kinds of Money. */
public class Money {
    public Money() {
        // nothing to initialize
    }

    /** Subclass should override this method. */
    public double getValue() { return 0.0; }
}
```

Make Coin and Coupon be subclasses, each with their own getValue().
```java
/** A Coin with a value */
public class Coin extends Money {
    private double value;

    public Coin(double value) { this.value = value; }

    public double getValue() { return value; }

    public String toString() {
        return String.format("%.2f Baht", value);
    }
}

/** A Coupon used at KU Faire. */
public class Coupon extends Money {
    private double value;
    private String color;

    public Coupon(int value) {
        this.value = value;
        this.color = getCouponColor(value);
    }

    public double getValue() { return value; }

    public String toString() {
        return String.format("%s Coupon (%.2f)", color, value);
    }
}
```
Now KuPOS can use Coin and Coupon the same way.  Replace the 2 `total(...)` methods with one method:   

```
public class KuPOS {
    /** Compute total value of money received. */
    public static double total(Money[] moneys) {
        double total = 0.0;
        for(Money m: moneys) total += m.getValue();
        return total;
    }
}
```

### Refactor to Remove Duplicate Code in Coin and Coupon

Both `Coin` and `Coupon` use `value` exactly the same way. `getValue()` is the same.  We can **eliminate duplicate code** by moving `value` to the `Money` superclass:

```java
/** Superclass for all kinds of Money. */
public class Money {
    protected double value;   // could be private
    public Money(double value) {
        this.value = value;
    }

    /** Subclass should NOT override this method. */
    public double getValue() { return value;  }
}
```

Coin and Coupon let the Money class manage `value`. No `getValue` method!

```java
/** A Coin with a value */
public class Coin extends Money {
    public Coin(double value) { 
        super(value);
    }

    // getValue provided by Money class

    public String toString() {
        return String.format("%.2f Baht", getValue());
    }
}

/** A Coupon used at KU Faire. */
public class Coupon extends Money {
    private String color;

    public Coupon(int value) {
        super(value);
        this.color = getCouponColor(value);
    }

    public String toString() {
        return String.format("%s Coupon (%.2f)", color, getValue());
    }
}
```
