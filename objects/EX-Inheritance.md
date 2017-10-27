## Inheritance

> This document introduces inheritance be defining a Student class
> that extends Person.  You need the `person.Person` class from the
> week 12 lab.

### Student and Person

We want to define a **Student** class with these attributes:

* `name`
* `email`
* `id` - the Student ID

and methods:

* `getName()` and `setName(name)`
* `getEmail()` and `setEmail(email)`
* `getId()` - get the student id.  **No** `setId` (cannot change id).
* `toString()` - print "Student *name* (*id*)" e.g. "Fatalai Jon (6010540001)"

### Avoid Duplicate Code

The **Student** class is very similar to **Person**:

<table border="1" align="center">
<tr valign="top">
<th>Person</th>  <th>Student</th>
</tr>
<tr valign="top">
<td>
String name <br/>
String email
</td>
<td>
String name <br/>
String email <br/>
Long id
</td>
</tr>
<tr valign="top">
<td>
Person(String name)
</td>
<td>
Student(String name, Long id)
</td>
</tr>
<tr valign="top">
<td>
getEmail() <br/>
getName() <br/>
       <br/>
setEmail(String) <br/>
setName(String) <br/>
toString() 
</td>
<td>
getEmail() <br/>
getName() <br/>
getId() <br/>
setEmail(String) <br/>
setName(String) <br/>
toString() 
</td>
</tr>
</table>

#### Q1: How Can Student Reuse Code from Person?

Complete this code to make Student be a subclass of Person.

```java
public class Student _____________________ {
    private Long id;

    /** Initialize a new Student. */
    public Student(String name, Long id) {
        this.id = id;
        setName(name);   // Can't write "this.name = name"
    }

    /** Get the student's id */
    public Long getId() {
        return id;
    }

    /** Printable string representation of student. */
    @Override
    public String toString() {
        //TODO return name and id. Example "Fatalai Jon (6010540001)"

    }
}
```

#### Q2: Why the Constructor Error?

After you complete the code, Java gives an error in the Student constructor.

1. What is the reason for the error?
2. How do you correct the code?

```java
    /** Initialize a new Student. */
    public Student(String name, Long id) {
        _____________________
        this.id = id;
        //setName(name);   // setName isn't necessary now
    }
```

Add a "print" statement to the constructor for Student and Person so you can see what is happening.

```java
public class Person {
   ...
   public Person(String name) {
       System.out.println("Person constructor");
       this.name = name;
```

```java
public class Student {
   ...
   public Student(String name, Long id) {
       _________________________; // must be first statement
       System.out.println("Student constructor");
       this.id = id;
   }
```


#### Q3: How to set a Student's Email?

Student does not define a `setEmail` or `getEmail` method in its source code.
Can we still call setEmail?  Why?

```java
Student s = new Student("Fatalai Jon", 6010540001L);
String email = "fatalai.j@ku.th";
// set the email:
s.setEmail( email );
```

#### Q4: How to Access the Name and Email in Student.java?

The Student `toString()` method needs to return the name.  But this code does not work:
```java
    public toString() {
        return String.format("%s (%d)", email, id);
    }
```

This does not work either:
```java
    public toString() {
        return String.format("%s (%d)", super.email, this.id);
    }
```

What is the solution?

### BankAccount

Use the `banking.BankAccount` class from previous lab.
BankAccount should have this structure:
:

#### Add a New Method

AddModification
