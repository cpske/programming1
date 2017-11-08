# Lab for Polymorphism, Equals, and More

## Problem 1. Demonstrate that String == String Can Fail

1.1 Write your own example of creating 2 Strings that contain the **same value**, but are not "==".
```java
String a = _____________________________; // your example
String b = _____________________________; // your example

System.out.println("a = "+a);
System.out.println("b = "+b);  // a and b should print the same
System.out.println("a.equals(b) is " + (a.equals(b)) ); // Should be TRUE
System.out.println("a == b is " + (a==b) ); // Should be FALSE
```

The Lesson: 
> `==` compares object identity (same object), `equals` compares values.

1.2 Sometimes, `a == b` works because of Java's *String pooling*, but this is not reliable.  Here is example:
```java
String a = "apple";
String b = "apple";
if (a == b) System.out.println( "Same" );   // prints "Same"

String A = a.toUpperCase();
String B = b.toUpperCase();
if (A == B) System.out.println( "Same" );   // doesn't print!
```

Explain why "a == b" is true, but "A == B" is false.

## Problem 2: Write equals() for Course

Use your **quiz7** from last week. Revise *Course* and *CourseList* as describe here, and **push** the revised code to Github.  If you deleted the quiz from your computer, you can clone (download) it again from Github.  Find the project on your Github home page.

2.1 Write an `equals(Object)` method for the **Course** class.  Two courses are equal if the course **id** have same value. Ignore the other attributes (title and credits).
  * Use the 4-part template for equals() as shown in class
  * Use the `@Override` annotation so compiler can catch mispelling

2.2 Test that equals works. Create two courses same **value** of course id but **distinct** strings.  Write a `main` method in **Course** and include this code:

```java
// Use same course id but with distinct strings,
// to catch errors in equals.
// equals should only compare course id, not course title (can differ)
Course a = new Course("01219111", "Intro to Programming", 3);
Course b = new Course(new String("01219111"), "Programming for Dummies", 3);
System.out.println("a = " + a);
System.out.println("b = " + b);
// Verify it works -- should be equal
if (a.equals(b)) System.out.println("a and b are equal");
else System.out.println("a and b are not equal");

// Verify that equals really tests the id (only)
// Create another course with different id but same title and credits.
Course c = new Course("01219112", "Intro to Programming", 3);
System.out.println("a = " + a);
System.out.println("c = " + c);
if (a.equals(c)) System.out.println("a and c are equal");
else System.out.println("a and c are not equal");
```

2.3 In the **CourseList** class, modify the `addCourse` method.
Since course.equals is testing the course id, you don't need a loop in addCourse!  You can use **list.contains(course)**.

2.4 Run the test code and verify that now `addCourse` only adds unique courses.

2.5 **Write Correct Class Javadoc**.  For all the classes you edited, write descriptive class Javadoc.  The first line must be a complete sentence describing the purpose of the class.  Include the `@author` tag (**no space** after "@" sign).
  * Javadoc must be in correct location.
  * **No Credit** for any class w/o Javadoc, or useless Javdoc like this:
  
  ```java
  import something;
  /**
   * The Course class.
   * @author Gill Bates
   */
  public class Course
  ```

2.6 Commit and push your code to Github.

## Problem 3: OrderItem 

In your **ske-restaurant** project write an **OrderItem** class.

**OrderItem** represents one item from the menu that customer is ordering.  It knows the menu item and quantity, and knows how to compute the total price.

```java
/**
 * An item in the customer's order, including quantity.
 * @author your name
 */
public class OrderItem {
    /** id of the menu item (same id as in menu) */
    private int id;
    /** name of menu item */
    private String name;
    /** unit price of menu item */
    private double price;
    /** quantity of this item */
    private int quantity;

    /**
     * Initialize a new OrderItem, with quantity 1.
     * @param id menu item id
     * @param name menu item name
     * @param price is the unit price of menu item
     */
    public OrderItem(int id, String name, double price) {
        this(id, name, price, 1);  // invoke the other constructor

    }

    /**
     * Initialize a new OrderItem, with specified quantity.
     * @param id menu item id
     * @param name menu item name
     * @param price is the unit price of menu item
     * @param qnty is the quantity of item in the order
     */
    public OrderItem(/*TODO write the parameters */) {
        //TODO initialize the attributes
    }

```

3.2 Add these methods:

<table border="1">
<tr>
<th width="35%">Method</th>
<th width="65%">Description</th>
</tr>
<tr valign="top">
<td markdown="span">int getId( )<br/>String getName()<br>String getPrice() </td>
<td>get the attributes. getPrice() returns unit price of the menu item.</td>
</tr>
<tr valign="top">
<td markdown="span">void addQuantity(int amount)</td>
<td>add amount to quantity of this item. amount may be negative to reduce quantity in order, but don't reduce to less than 0.</td>
</tr>
<tr valign="top">
<td markdown="span">int getQuantity()</td>
<td>get the quantity of this item. </td>
</tr>
<tr valign="top">
<td markdown="span">void setQuantity(int quantity)</td>
<td>set the quantity of this item. quantity must be 0 or more. </td>
</tr>
<tr valign="top">
<td markdown="span">double getTotal()</td>
<td>get the total price for this order item. Usually this is price x quantity.</td>
</tr>
<tr valign="top">
<td markdown="span">boolean equals(Object obj)</td>
<td>equals method that is *true* if two OrderItem refer to same menu item.  Whatattributes should you compare?</td>
</tr>
<tr valign="top">
<td markdown="span">String toString()</td>
<td>Return a String description of the item. Don't try to format the String for printing a receipt -- this is too much coupling.  Useful toString might look be: "Pad Thai, 3 @ 30.0" (name, quantity, and unit price)</td>
</tr>
</table>
<p></p>

3.3 Write code to create some OrderItems and verify that they work correctly.  It should be pretty easy to compute the total.

This code is only example. Write your own.
```java
OrderItem item1 = new OrderItem(12, "Pad Thai", 30.0);  // quantity is 1
item1.addQuantity(2);   // now total quantity is 3
printOrderItem(item1);

Orderitem item2 = new OrderItem(7, "Salad", 25.50, 2);
printOrderItem(item2);
// change quantity to 1
item2.setQuantity(1);
printOrderItem(item2);

// Add to order and compute the total
OrderItem[] myOrder = { item1, item2 };
System.out.println("Order contains:");
double total = 0.0;
for(OrderItem item: myOrder) {
    printOrderITem(item);
    total += item.getTotal();
}
System.out.printf("Total price: %.2f\n", total);

public static void printOrderItem(OrderItem item) {
    System.out.printf("%-24.24s %2d @ %6.2f %,8.2f\n", 
        item.getName(), item.getQuantity(), item.getPrice(), item.getTotal());
}
```

## Problem 4: TwoForOneItem Subclass

To illustrate the use of polymorphism, define a **TwoForOneItem** subclass of **OrderItem**.  The basic **OrderItem** class already provides most of the behavior this class needs.  Only the `getTotal` and `toString` methods need to be overridden.

4.1 Complete this class.  Also write a suitable toString.

```java
/**
 * An item in the customer's order, with 2-for-1 pricing.
 *
 * @author your name
 */
public class TwoForOneItem extends OrderItem {
    //NO attributes: they are in superclass

    /**
     * Initialize a new TwoForOneItem, with quantity 1.
     * @param id menu item id
     * @param name menu item name
     * @param price is the unit price of menu item
     */
    public TwoForOneItem(int id, String name, double price) {
        super(id, name, price);
    }

    /**
     * Initialize a new TwoForOneItem, with specified quantity.
     * @param id menu item id
     * @param name menu item name
     * @param price is the unit price of menu item
     * @param qnty is the quantity of item in the order
     */
    public TwoForOneItem(/* TODO */) {
        //TODO
    }

    /**
     * Return the total price of this item, using 2-for-1 pricing.
     * If the customer buys 2 then he pays for 1, buy 4 pay for 2.
     * But if he buys 3 then he still pays for 2.
     */
    @Override
    public double getTotal() {
        //TODO write this method
    }
```

4.2 Write some test code.  Using polymorphism, we can treat OrderItem and TwoForOneItem the same for printing receipt, computing total, etc.

This is an example. Write your own code.

```java
OrderItem item1 = new OrderItem(7, "Salad", 25.5, 2); // no discount
printOrderItem(item1);

// SKE wants to compete with PizzaHut, so we have 2-for-1 promotion...
Orderitem item2 = new TwoForOneItem(1, "Large Veg. Pizza", 399.00);
// since its 2-for-1 lets buy more
item2.addQuantity(3);
printOrderItem(item2);

// Add to order and compute the total
OrderItem[] myOrder = { item1, item2 };
System.out.println("Order contains:");
double total = 0.0;
for(OrderItem item: myOrder) {
    printOrderItem(item);
    total += item.getTotal();
}
System.out.printf("Total price: %.2f\n", total);
```

## Order Class

Write an **Order** class that contains everything in a customer's order.  This is similar to Quiz7, where the **CourseList** class contains **Course** objects.  
You should have at least these methods:

<table border="1">
<tr>
<th width="35%">Method</th>
<th width="65%">Description</th>
</tr>
<tr valign="top">
<td markdown="span">void addItem(OrderItem item)</td>
<td>
add an item to the order.  If the item is already in the order, then update the **quantity** of the existing item instead of adding a new OrderItem. 
</td>
</tr>
<tr valign="top">
<td markdown="span">OrderItem getItem(int id)</td>
<td>
get one OrderItem by the menuItem's id number (as on your menu).
Return null if no matching item
</td>
</tr>
<tr valign="top">
<td markdown="span">boolean removeItem(int id)</td>
<td> completely remove an OrderItem with matching item number.  </td>
</tr>
<td markdown="span">List<OrderItem> getItems()</td>
<td> get all the OrderItem in the Order. </td>
</tr>
<tr valign="top">
<td markdown="span">double getTotal()</td>
<td> get the total price for this order.</td>
</tr>
</table>

(\*) In your SKE Restaurant application you may have more methods,
or modify these methods.  For the lab, please use these methods.


```java
OrderItem item1 = new OrderItem(7, "Salad", 25.5, 2); // no discount
Orderitem item2 = new TwoForOneItem(1, "Large Veg. Pizza", 399.00);
// since its 2-for-1 lets buy more
item2.addQuantity(3);

Order order = new Order();
order.addItem(item1);
order.addItem(item2);

// Display the order
System.out.println("Order contains:");
for( OrderItem item: order.getItems() ) {
    printOrderItem(item);
}
double total = order.getTotal();
System.out.printf("Total price: %.2f\n", total);
```


## About the Design 

The design of OrderItem would be better if MenuItem was also a class that encapsulated the id, name, and unitPrice.

If you want to have a discount like "40 Baht off your order", you can use an OrderItem for that.  Its like a menu item with negative price and quantity 1.  This way, the discount is printed as a separate line on the receipt.

A principle in OO design is "*Prefer Composition over Inheritance*".  Instead of writing special subclasses of OrderItem to change the pricing, we could define Pricing classes that defines various discounts.  The OrderItems would invoke a Pricing object to compute the item's price.
