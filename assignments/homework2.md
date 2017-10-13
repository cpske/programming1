## Homework 2: SKE Restaurant using Arrays

Modify the SKE Restaurant code so that it uses arrays for the menu items, prices, and the customer's order. 


### Requirements

1. Use arrays for menu item names (Strings) and prices (double).  Use an array for the customer's order.
2. The menu items and prices are specified **only** in the arrays -- don't duplicate the information.
3. The menu items and prices arrays may be **static attributes** of the class, because they are fixed.  
4. The array for customer's order should be a **local variable** because it is being modified repeatedly.  Pass the order array **as parameter to methods** that use the order.
5. The code must really use an array as an array. No credit if you just substitute array variables for your old variables.    
    **Wrong (no credit):**
    ```java
    System.out.println("Menu:");
    System.out.printf("1) %-20.20s  %.2f%n", menuItems[0], prices[0]);
    System.out.printf("2) %-20.20s  %.2f%n", menuItems[1], prices[1]);
    System.out.printf("3) %-20.20s  %.2f%n", menuItems[2], prices[2]);
    System.out.print("Enter choice: ");
    ```
    **Better:**    
    ```java
    for(int j=0; j<menuItems.length; j++)
    System.out.printf("%2d) %-20.20s  %.2f%n", j+1, menuItems[j], prices[j]);
    ```
6. We should be able to change the menu and prices, and the program will still work correctly.  In particular:
    * Can change the names or prices of menu items
    * Can add new items to arrays for menu and price
7. **App Should Accept Many Orders.**  Don't quit after the first order! When the order is complete, accept payment, print receipt, and wait for another order.
8. Information that must be written on customer's receipt:
    * Date and time of the order.  Every receipt needs this. 
    * An order number, starting with 1. (So we know which order belongs to who.)
    * Items ordered, with quantity and price (of course).
    * Any discounts (this is not required).
    * Total price of order.

### What to Submit

Submit your code to a Github repository named **ske-restaurant** in your own Github account (not the class account).  This is the same repository as you already submitted code.  Just commit and "push" your updates.

> **What About My Old Code?**    
> Github keeps every commit to a repository.  You can view and "checkout" any previous version.  There is no need to create backup copies.  The old versions are still there!
>
> Please **don't** create backup directories like "old", "version1", in your repository!  There should be **only one set of source files** in the repository.  If you really want to keep a "backup", then copy it someplace else on your computer.

### Programming Hints

1. How to display a numbered list: This is weird:  `1.) Pizza`.  A numbered list can be written in any of these ways:
    <table align="center" cellpadding="10">
    <tr valign="top">
    <td>1) Pizza <br/>2) Salad </td>
    <td> (1) Pizza <br/> (2) Salad <br/> </td>
    <td> 1. Pizza <br/> 2. Salad <br/> </td>
    <td> [1] Pizza <br/> [2] Salad <br/> </td>
    </tr>
    </table>
2. Since we might add more items to the menu, its not a good design to use a number for choices like "4. Edit Order" or "5. Checkout".  How about using **letters**?
    ```shell
    [1] Pizza
    [2] Salad
    [3] Drinking Water

    [e] Edit order
    [p] Print order
    [c] Review order and Checkout
    [x] Cancel order
    Input Choice: 
    ```
By using `console.hasNextInt()` you can test if the user typed a number or something else.
3. Another way to handle user input would be to *always* read the input as a String.  The code can test if the string is a number or other option. To convert a String variable to a number, look at the Javadoc for **Integer** class **parseInt** method (my slides show other ways, too).
4. How can you *test* if a String contains an integer value?  
    * Parse it and check for exception:
    ```java
    boolean isNumber(String word) {
        try {
            Integer.parseInt(word);
            return true;  // it worked!
        } catch(NumberFormatException ex) {
            return false;
        }
    }
    ```
    * Or, use a regular expression: `word.matches("[0-9]+")` is true or false. "[0-9]" means "match any digit" and "+" means "one or more times".  This is a weak test: some invalid numbers like 009 would match.  

Example Receipt containing the required info (your receipt can look different): 

```shell
       SKE Vegetarian Restaurant
           7 Oct 2017, 18:24
Order: 101  

2  Pizza with mushrooms    250ea   500.00
3  Salad                    30ea    90.00
2  Black bean soup          25ea    50.00
VAT (included)                       0.00
Total                              640.00
```

### Checklist for a Good Project

1. Project on Github is named **ske-restaurant**.
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
5. Use arrays for the menu items and prices.  Example (use your own variable names):
    ```java
    // This is a vegetarian restaurant!
    private static final String[] menuItems = {"Tofu", "Pad Thai Je", "Jap Chai", "Veg. stir fry"};
    private static final double[] unitPrice = {20.0, 35.0, 20.0, 25.0};
    ```
    OK to use an array of objects for menu items (each object has both the description and unit price), provided you know what you're doing.
7. The array for the customer's order is a **local variable**, not an attribute.
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
8. Use **methods** for tasks.  For example, computing the total price of order:    
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
9. Test Your Code.  
    * Even better: get a friend to test your code!  Someone else will find bugs you don't see.

