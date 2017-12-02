## Sample Exam Problems

These problems are similar in complexity to what will be on the
programming part of the final exam.

## 1. Write a MenuItem class in Package menu

A MenuItem has an id, description, and price (unit price).

Write a class with these private attributes

| `int id`        | the item id |
| `String name`   | the name (description) of the item |
| `double price`  | the unit price, in local currency |
    

and these constructor and methods

| `MenuItem(id,name,price)` | initialize a new MenuItem with the given parameters |
| `int getId()`             | get the item id |
| `String getName()`        | get the item description |
| `double getPrice()`       | get the item price |
| `String toString()`       | returns "id name", ex: "123 Ice Coffee" |
| `booelan equals(Object)`  | true if argument is a MenuItem with same id |

## 2. Write a MenuItemTest class

Write a `MenuItemTest` class to test your MenuItem class.
Each method should test some code of the MenuItem class and verify
it returns the correct result.  For each test you write, print the
expected value and actual value, so the programmer can see what you
are testing and what the result is.

```
Test new MenuItem(123,"Tofu Burger",25.95);
getId(): expect: 123  actual: 123   OK
getName(): expect: Tofu Burger  actual: Tofu Burger  OK
getPrice(): expect: 25.95  actual: 0.00   ERROR
```

It should have 3 static methods:

| `static void testMenuItem()` | Test the constructor and "get" methods. |
| `static void testEquals()`   | Thorough test of equals method. |
| `static void main(String[] arg)` | call the 2 test methods.    |

We didn't test toString because its easy to check that visually.
Your test code is going to contain a lot of **almost duplicate code**.
In the example output above, the test code for getId(), getName(), 
and gerPrice() is almost identical.

Consider creating a **method** to perform redundant tasks
and eliminate duplicate code.  For example:

```java
/** print a message and test if expect and actual have the same value. */
void testEqual(String message, Object expect, Object actual)
```

**Note:** Testing is important.  No credit for careless or incomplete tests.

## 3. Write a Menu Class

The Menu class reads MenuItem data from a file in CSV format and
creates a list of MenuItem.  The members are:

| `List<MenuItems> items`          | The menu items. |
| `Menu( )`                        | Constructor initializes an empty menu |
| `int readMenu(String filename)`  | Read the menu data from a file. Return the number of items read or -1 if cannot read the file. |
| `List<MenuItems> getMenuItems()` | Return all the menu items. |
| `MenuItem getMenuItem(id)`       | Return one MenuItem with the requested id. Return null if no match for the id. |
| `boolean add(MenuItem item)`     | Add an item to the menu if its not already in the menu. |

The method `readMenu(String filename)` should open the file using a "new FileInputStream(filename)" or similar command.  You don't need to use ClassLoader; but you can try both ways if you want -- first try ClassLoader.getResourseAsStream and if that fails then use FileInputStream.

Example:
```java
Menu menu = new Menu();
int count = menu.getMenu("menudata.csv");
System.out.println("Read "+count+" items");
List<MenuItem> items = menu.getMenuItems();
System.out.println("First item: "+items.get(0));
```

#### File Format

* Each menu item is on a separate line.
* Each line contains: id:description:price (fields separated by colon).
* Blank lines are ignored.
* Any line beginning with # sign is ignored (comment lines).

Example:
```
# id : Description : price
101:Hot Brewed Coffee, medium: 30.0
102:Hot Brewed Coffee, large: 40.0
105:Espresso Coffee, medium: 30.0
106:Espresso Coffee, large: 40.0
123:Ice Coffee, medium: 35.0
124:Ice Coffee, large: 45.0
125:Cafe Frappe, large: 80.0
130:Croissant:25.0
131:Raisin Muffin:32.0
```

## 4. OrderItem and Order

`OrderItem` represents one item in a customer's order. The code is given:
```java
package orders;

public class OrderItem {
    private MenuItem item;
    private int quantity;

    /**
     * Initialize an order item with MenuItem and quantity.
     */
    public OrderItem(MenuItem item, int qnty) {
        this.item = item;
        this.quantity = qnty;
    }

    /**
     * Initialize an order item with quantity of 1.
     */
    public OrderItem(MenuItem item) {
        this(item, 1);
    }

    public MenuItem getItem() { return item; }

    public int getQuantity() { return quantity; }

    public void setQuantity(int qnty) { this.quantity = qnty; }

    public void addQuantity(int amount) { this.quantity += amount; }
}
```

An `Order` represents a complete order by a customer, containing one or more OrderItems.

```
package orders;
import java.util.List;
import java.util.ArrayList;

/**
 * Information about a customer's order.
 */
public class Order {
    private List<OrderItem> items;

    public Order() {
        items = new ArrayList<>();
    }

    /** Add an item to the order, with quantity 1. */
    public void addItem(MenuItem item) {
        //TODO complete this
    }

    /** Add an item to the order, with given quantity. */
    public void addItem(MenuItem item, int quantity) {
        //TODO complete this
    }

    /** Print the order. */
    public void printOrder() {
        //TODO complete this
    }

    /** Compute and return the total price of the order. */
    public double getTotal() {
        //TODO complete this
    }
}
```

4.1 Complete the `addItem` methods.    
(a) if the MenuItem (parameter) is not in the order, then create an OrderItem with quantity 1 and add it.    
(b) if the MenuItem is already in the order (in an OrderItem), then increase the quantity by 1. Don't create a new OrderItem.

4.2 Write the `getTotal` method.  Compute and return the total price of the order.

4.3 Write the `printOrder` method.  The output should look like this:
```shell
 id   Description             Qnty   Price   Total   
101   Hot Brewed Coffee, med    2     30.0    60.0
106   Espresso Coffee, large    1     40.0    40.0
130   Croissant                 3     25.0    75.0
      Total                                  175.0
```


#### Menu File Name and Location

The menu file name is `menu.txt` in a subdirectory of the project named `data`.  The `data` directory is **inside the src dir** so it is included in the project build.  Your project will look like this:
```
ske-restaurant/
      README.md
      src/ 
           OrderTaker.java        (your code may have a different class name)
           RestaurantManager.java (must use this name)
           data/
                 menu.txt
```


## 5. Distance to the Moon

This question tests your ability to use the Java API. You **may not** "google" for a solution. You may only use the Java API docs that you installed on your computer.

Java has a `BigDecimal` class for performing arbitrary precision arithmetic.
Use `BigDecimal` to precisely compute the distance to the Moon.

The speed of light in vacuum is
```java
final String LIGHTSPEED = "299792458"; // meters per second
```
and the time for a laser beam to reach the Moon and return to Earth is:
```
final String time = "2.422371576";  // seconds
```

Create BigDecimal objects for the speed of light (`c`) and the time (`t`).
**Don't** convert LIGHTSPEED or time to `double` because that would lose precision!  Directly create BigDecimal from the Strings.

Compute the distance from the Earth to the Moon using BigDecimal arithmetic,
using the formula d = (c \* t)/2. 
Use BigDecimal arithmetic to convert the result to kilometers (divide by 1000).
You must use BigDecimal methods, not "\*" and "/".  

Print the result.

