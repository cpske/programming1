# Code Improvement Problems

You must join the OOP2018 organization before you can do Problem 3. Then you can go to the URL (in class) to create a Github repository for the assignment.

## Problem 3: Code Improvement

In this problem you will clone a project from Github, modify the code, and then "push" your work back to Github.  In the previous problem you started with local code and then added Github (case 1). In this problem you clone a project from Github (case 2).

We are using **Github Classroom** for this exercise. Your Github repository is in the OOP2018 organization instead of your personal Github account.    
The Github URL will look like: `https://github.com/OOP2018/fixcode-yourlogin`.  

When you clone it to your computer, you can rename your copy so you don't have use the long name `fixcode-yourlogin`.

1. Go the the URL given in lab to create your assignment.
2. Accept the assignment.  Github will create a repository for you.  The repo name is `https://github.com/OOP2018/fixcode-yourlogin`
3. Clone this repository to your computer.
    a) Go the the repository on Github and click the "Clone or Download" button.
    b) Copy the URL
    c) In a command window (shell) on your computer, change to a directory where you want to save the project.  For Eclipse, this is usually "home_dir/workspace".
    d) Clone the Github repository. In this example, the last argument is the name we want for the local copy (instead of the default `fixcode-yourlogin`):
    ```
    cmd> cd workspace
    cmd> git clone https://github.com/OOP2018/fixcode-yourlogin.git fixcode
    ```
4. The source code contains TODO comments with instructions.  Do each of the TODO items and **delete the TODO comment** when you are done.
5. Test your code.
6. Commit your changes locally.
7. Upload (push) the changes to the Github repository.

## Problem 4: Improve your SKE-Restaurant and Send Results to Github

**Do this after Problem 2** I will check that there are commits to Github for "before" and "after" changes.

Make these improvements to your code:

1. Add a **class Javadoc comment**  and include your name using the `@author` tag. Here is an example, but you should write more description than this.
    
    ```java
    /**
     * User interface for a menu and ordering system,
     * using console interface.
     * @author Bill Gates
     */
    public class YourClassName {
    ```
2. Make your code **easy to read**.  You should have:
    * Class name in *Title Case* such as MenuSystem, Restaurant, PizzaShop. Bad names: restaurant, test, HW1.
    * Descriptive names for variables and methods.
    * One blank line between each method.
    * Space outside if "(...)" and "{...}", as shown in class.
3. Apply this principle: a method should do only one thing.  Use separate methods for separate tasks and avoid duplicate code.  Some **example** methods are (you don't have to use these names):
    ```java
    /** Print the menu with prices. */
    public static void printMenu()

    /** Print a message and get the user's input. */
    public static String getReply(String prompt)

    /** Print the user's order and total price. */
    public static void printOrder()

    /** Compute the total price of an order and return it. */
    public static double computeOrderTotal()
    
    /** Add an item to customer's order. */
    public static void addToOrder(int itemNumber, int quantity)
    ```
4. Use the Java Naming Convention for class, method, and variable names. Use descriptive names. 
5. **Review your code**.  Look for other improvements, such as:
    * Localize variables (are there attributes used by only 1 method?)
    * Replace duplicate code with a method code
    * Avoid very long methods.
    * Avoid too much program logic in `main()`. Use some other method.
6. Test that your code works correctly after making these changes.
7. Commit changed files to your local repository:
    ```shell
    cmd> git status
    (shows changed files)
    cmd> git add file1 ...   (add any changed or new files)
    cmd> git commit -m "code improvements"
    ```
8. Push your changes to Github using `git push`.
9. View your project on Github to verity the files are up-to-date.


