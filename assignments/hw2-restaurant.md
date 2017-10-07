## Checklist and Suggestions for SKE Restaurant using Arrays

### Assignment

1. Modify the SKE Restaurant project to use arrays for menu items, prices, and the customer's order.
2. The only place where the menu items and prices should appear is in the arrays -- don't duplicate it.
3. Use methods for common tasks such as computing the total price of an order.

The menu items and prices can be attributes of the class, but the customer's order array
should be a **local variable**.  (See item 7 for details.)

### Example

This kind of code is error-prone.
```java
private double totalPrice;

public static double addToOrder(int itemNumber, int quantity, 
           int[] 

### Checklist for a Good Project

1. Project on Github is named **ske-restaurant**.
    * in the repository, source code is in the **src** directory.
2. Project has a README.md describing the project.
    * includes your real name
    * correctly formatted with Markdown.  If it looks like crap (bad formatting), it means you didn't bother to check your own repo on Github!
3. Java source code contains **at least** a class Javadoc comment, which must be **after** the `import` statments and **before** the start of class.

    ```java
    // don't copy this!  its just example to show where to write Javadoc
    import java.util.Scanner;
    import java.util.Arrays;
    /**
     * Main class for SKE Restaurarnt order taking application.
     * It displays a menu and accepts items to order.
     * When done, it prints a receipt including the order total.
     *
     * @author Bill Gates
     */
    public class Restaurant
    ```
4. For good code, write **method Javadoc** comments for important methods.  See the Arrays lab for examples.
5. Use arrays for the menu items and prices.  Example (use your own variable names):
    ```java
    // This is a vegetarian restaurant!
    private static final String[] menuItems = {"Tofu", "Pad Thai Je", "Jap Chai", "Veg. stir fry"};
    private static final double[] unitPrice = {20.0, 35.0, 20.0, 25.0};
    ```
    OK to use an array of objects for menu items (each object has both the description and unit price), provided you know what you're doing.
6. **Don't** "hard code" the menu items or prices in code.       

   **GOOD**    
    ```java
    public static void printMenu() {
        ...
        System.out.printf("%-20.20s  %.2f%n", menuItems[k], unitPrice[k]);
    ```
    **BAD**    
    ```java
    public static void printMenu() {
        ...
        System.out.printf("Tofu          20.0 Baht%n"); // hard-coding data into code
    ```
7. The array for the customer's order is a **local variable**, not an attribute.  Create a new array for each customer.
    * This avoids lots of subtle bugs, avoids side effects, and reduces complexity of the code. 
    * It makes it easier to test parts of the code.
    * Example: `makeOrder` creates a new **order** and passes it as a parameter to methods the need to use the order.
   ```java
   public static int[] makeOrder() {
       int[] order = new int[menuItems.length];
       do {
           printMenu();
           int choice = getChoice();
           ...
           addToOrder(order, choice, quantity);
           ...
       } while (choice != CHECKOUT);
       acceptPayment( order );
       printReceipt( order );
       return order; // other parts of code can use order, too.
   ```

8. Use **methods** for tasks.  For example, computing the total price of order:
   **GOOD**
   ```java
   public static double getTotal(int[] order) {
        double total = 0.0;
        for(int k=0; k<order.length; k++) total += order[k]*unitPrice[k];
        // do other stuff, like add VAT or apply a discount
        return total;
    }
    ```    
    **BAD**
    ```java
    // This method is both adding something to the order
    // AND computing the order total.  This is error-prone.
    // Remember: 1) method should do only one thing, 2) minimize side effects
    public static void addToOrder(int item, int quantity) {
        order[item] += quantity;
        total = total + quantity * unitPrice[item]; // BAD: modifying total as a side-effect
    }
    ```
9. Test Your Code.  
    * Even better: get a friend to test your code!  Someone else will find bugs you don't see.

