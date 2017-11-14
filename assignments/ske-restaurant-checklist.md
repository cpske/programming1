## Checklist for SKE Restaurant Assignment

This is a list of common issues seen in the SKE Restaurant code.
Please check your project.

### Github Checks

1. Repository is named **ske-restaurant** exactly.  Not "ske restaurant" or "ske-restaurant." (no period) or "SKE-restaurant" (wrong case).
2. Repository has correct directory structure.
    ```shell
    README.md
    .gitignore
    src/       (source code)
    src/data   (menu data file)
    ```

### Checklist for RestaurantManager

1. All attributes are **private**.  The other classes should not directly access attributes.
2. Has the methods required in Homework 3:
<table border="1" align="left">
<tr>
<th width="50%">Method</th>  <th width="50%">Description</th>
</tr>
<tr valign="top">
<td markdown="span">
<tt>public static String[] getMenuItems()</tt>
</td>
<td markdown="span">Return **array** of menu item names.</td>
</tr>
<tr valign="top">
<td markdown="span">
<tt>public static double[] getPrices()</tt>
</td>
<td markdown="span">
Return **array** of menu item prices.
</td>
</tr>
<tr valign="top">
<td markdown="span">
<tt>public static void recordOrder(int orderNumber, int[] order, double total)</tt>
</td>
<td markdown="span">
Record a completed order. *Your method may be different or have different parameters. But the **order** should be a parameter.*
</td>
</tr>
</table>
3. RestaurantManager **does not interact with customer**. 
4. RestaurantManager **does not** have an **attribute** for an order.  recordOrder receives order as a parameter.  There is no need for an attribute for this.
5. Write a good Javadoc comment.  That should be obvious by now.

```java
import java.util.List;
import java.noway.DontCopyThis;

/**
 * The Restaurant Manager provides services of the
 * restaurant, including access to the menu and prices,
 * and receiving orders. It records orders to a file.
 *
 * @author Bill Gates
 */
public class RestaurantManager {
    private String[] menuItems;
    private double[] prices;
    // no ArrayList attributes. they are local variables used temporarily.
```

### Checklist for Restaurant (or whatever class accepts order from user)

1. Gets the menuItems and prices from RestaurantManager **one time** and saves them.
```java
public class Restaurant {

    private String[] menuItems = RestaurantManager.getMenuItems();
    private double[] prices = RestaurantManager.getPrices();

    /** This is an example of flow of accepting/submitting an order. 
        Your code will probably be different.
     */
    public void makeOrder() {
         int[] order = new int[menuItems.length];
         while( ! complete ) {
             getitems( order ); // accept item using a loop
             displayTotal( order );
             complete = confirmOrder( order );
         }
         double totalPrice = getTotal(order);
         long orderNumber = RestaurantManger.recordOrder( order, totalPrice );
         printReceipt( order, orderNumber, totalPrice );
    }
```
2. Don't repeatedly nag RestaurantManager for the menu.  Don't do this:
```java
for(int k=0; k<RestaurantManger.getMenuItems().length; k++) {
     System.out.printf("[%2d] %-30.30s  %.2f\n",
      k+1, RestaurantManager.getMenuItems()[k], RestaurantManager.getPrices()[k]);
}
```
3. Even **worse**, don't directly access attributes of RestaurantManager.  The attributes should be private.
```java
// Totally wrong: directly access attribute of another class
for(int k=0; k<RestaurantManger.menuItems.length; k++) {
     System.out.printf("[%2d] %-30.30s  %.2f\n",
      k+1, RestaurantManager.menuItems[k], RestaurantManager.prices[k] );
}
```
4. Create a new **order** array (or order object) for each order.  You pass the **order** as parameter to methods instead of using an attribute for order.  
  * This isn't as important as the above checklist items. Its not good design to use an attribute for order, but not terrible.

### Checklist from Homework 2 (some items removed)

1. Project on Github is named **ske-restaurant**
    * in the repository, source code is in the **src** directory.
2. Project has a README.md describing the project.
    * includes your real name
    * correctly formatted with Markdown.  If it looks like crap (bad formatting), it means you didn't bother to check your own repo on Github!
3. Source code contains a **class Javadoc comment**, which must be **after** the `import` statements and **before** the start of class.

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
4. For really good code, write **Javadoc method comments** for important methods.  See the Arrays lab for examples.
5. The array for the customer's order is a **local variable**, not an attribute.
    * This avoids lots of subtle bugs, avoids side effects, and reduces complexity of the code. 
    * It makes it easier to test each method of the code.
    * Each time you start a new order, either create a new array or reset ("fill") existing array with 0.    
    **GOOD** (order is local variable, pass it to methods as parameter)
    ```java
    public void makeOrder() {
        int[] order = new int[menuItems.length];
        ...
    ```
    **BAD** (order is attribute)
    ```java
    public class Restaurant {
        private static int[] order;
    ```
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
7. Use **methods** for tasks.  For example, computing the total price of order:    
   **GOOD** (a separate method to compute the total, as needed)
   ```java
   public static double getTotal(int[] order) {
        double total = 0.0;
        for(int k=0; k<order.length; k++) total += order[k]*unitPrice[k];
        // do other stuff, like add VAT or apply a discount
        return total;
    }
    ```    
    **BAD** (incrementally computing total as a side-effect)
    ```java
    // This method is both adding something to the order
    // AND computing the order total.  This is error-prone.
    // Remember: 1) method should do only one thing, 2) minimize side effects
    public static void addToOrder(int item, int quantity) {
        order[item] += quantity;
        total = total + quantity * unitPrice[item]; // BAD: modifying total as a side-effect
    }
    ```
8. **Test Your Code**.
    * Don't test inside the IDE, because you may miss some bugs.
    * Use a command prompt and change to the project "bin" (Eclipse) or "build" (Netbeans) or "out/production" (IntelliJ) directory.  Then run:
    ```shell
    cmd>  cd ske-restaraurant/bin
    cmd>  java MyMainClass
    ```
    * If your code is in a package, use "." (not /) after package name(s).
    ```shell
    cmd>  java restaurant.MyMainClass
    ```
    * Even better: get a friend to test your code!  They will find bugs you don't see.


