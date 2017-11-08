## Homework 4: Object for Order

** Assignment is strictly Optional **

You are not required to use OrderItem and Order in the SKE Restaurant project (but you are required
to write them for the Nov 7 lab).  Encapsulating an Order is a much better O-O design than using an array,
so you can learn something by doing it.

## Complete and Test Homework 2 and Homework 3 Before Attempting This

* Homework 2: use arrays for menu and prices
* Homework 3: RestauarantManager, with required methods.  Read menu from file, write orders to a file.

You must complete those assignments to get credit.  Test your code and push it to Github.
Then you can play around with Order and OrderItem.

## Requirements

1. Write an **OrderItem** class for one item in a customer order.  See the Polymorphism Lab (Nov 7) for details.  An OrderItem needs to know:
  * id - the menu item id
  * name - name of menu item
  * price - price of the menu item
  * quantity - how many the customer wants
2. Write methods in the **OrderItem** class as in the Polymorphism Lab (Nov 7).
3. Write an **Order** class to contain the OrderItems.  This is also described in the Polymorphism Lab (Nov 7). An Order also needs an Order number and timestamp.  
  * One solution: let the RestaurantManager set those when you submit the order.  Print receipt for customer **after** you submit the order so that it has order number and timestampe.
  * Alternatively, the OrderTaker can set the timestamp.
4. In RestaurantManager, add a method **recordOrder(Order order)**. This method has an **Order** as parameter, instead of array of int.  This method should write the data to the order log file, as in Homework 3.

