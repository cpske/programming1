## Homework 3: SKE Restaurant with Menu File and RestaurantManager

Modify the SKE Restaurant code so that it reads menu information from a file and writes orders in a Sales Log.  Use a separate class for this, named `RestaurantManager`.


## Requirements

### 1. Menu data in a file

SKE Restaurant should be able to update the menu without modifying the Java source code.  An easy way to achieve this is to put the menu information in a file.  Here is the format and location of the file.

#### File Format

* Each menu item is on a separate line.
* Each line contains item name, semi-colon, and price.
* Blank lines are ignored.
* Any line beginning with # sign is ignored (comment lines). The line may have spaces before #.
* We don't use "," to separate fields, because it might be part of an item name.

Example:
```
# Description; price

Cheese Pizza;  220.0
Pizza with mushroom; 250.0
Salad, small;   30.0
# Coke;         20.0   -- we aren't selling coke any more. Its bad food
Ice Tea;        20.0
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


### 2. RestaurantManager class

Write a new class named **RestaurantManager** that is responsible for information about the restaurant.  **RestaurantManager** will have these methods:

<table border="1" align="left">
<tr>
<th width="50%">Method</th>  <th width="50%">Description</th>
</tr>
<tr valign="top">
<td markdown="span">
<tt>public static String[] getMenuItems()</tt>
</td>
<td>Return array of menu item names.  Always returns the same array.</td>
</tr>
<tr valign="top">
<td markdown="span">
<tt>public static double[] getPrices()</tt>
</td>
<td>Return array of menu item prices.  Always returns the same array.</td>
</tr>
<tr valign="top">
<td markdown="span">
<tt>public static void recordOrder(int orderNumber, int[] order, double total)</tt>
</td>
<td>Record a completed order. It appends the order to a sales log.</td>
</tr>
<tr valign="top">
<td markdown="span">
<tt>static void setMenu(String filename)</tt>
</td>
<td>Set the name of the menu file.  The default menu file is "data/menu.txt", but the application can set the name of the menu file. After this method is called, the RestaurantManger will reload the menu data from the file.
</td>
</tr>
</table>

The SKE Restaurant class should get the menu data by calling
`RestaurantManager.getMenuItems()` and `RestaurantManger.getPrices()`.
The SKE Restaurant class (the order taker) should not have any string constants like "Pizza".

### 3. Record Sales in a Sales Log

When an order is completed, the SKE Restaurant should call the **recordOrder** method, so the restaurant can record the sale.  (RestaurantManger should also send the order to the chef!  But that feature is for later.)

### 4. (Optional) Command Line Argument for Menu: -m menufile

How can the user tell the application what file he wants to use for menu data?  For testing, we might have a separate file (`testmenu.txt`) and the restaurant might have a different breakfast menu and lunch menu. Or a special menu for the vegetarian festival.

Many applications let you specify *command line arguments* to pass optional values to the application.  In Java, the command line arguments are put into the String array in `main(String[] args)`.

1. Modify the `main` method to check for command line arguments "-m *menufile*", where the *menufile* is the actual filename of the restaurant menu.
2. The user might input a relative or absolute path for the file, and it may be relative to the SKE Restaurant application.  To handle both possibilities do this:
    * Try to open the file as a file in the filesystem using `new FileInputStream(filename)`. If that works, you are done.
    * Try to open the file as a a classpath resource (using ClassLoader, described above).  

### 5. RestaurantManager is Not User Interface

The RestaurantManager does not interact with the customer.  It accepts orders from another object, but it doesn't create the order.  So don't create the `quantity` array or `Order` object (if you use a class for Order) in RestaurantManager.  That's the responsibility of another class.


### How to Submit

Commit your source code to your Github repository named **ske-restaurant**.

We should add a git "tag" to this version, since its a major change to the restaurant.

### Coding Suggestions

#### How to Read from a File

We want SKE Restaurant to run on someone else's computer, and we don't know where he will install the software.  So we can't use an **absolute path** for the menu file.  Instead, we will require that the menu file be in a `data` subdirectory of **wherever the application is installed**.  This is a standard away of including resources such as icons and data files as part of an application.  The SKE Restaurant is *not* going to be running Eclipse, so "src/" is not part of the file path!

The Java Classloader knows where the application is installed and can find "resources" that are located relative to the application.  The code is like this:

```java
String filename = "data/menu.txt";
ClassLoader loader = RestaurantManager.class.getClassLoader();

// This is the key part: find and open the file as InputStream
InputStream in = loader.getResourceAsStream( filename );
if (in == null) {
    System.out.println("Could not access file "+filename);
    return;
}

Scanner reader = new Scanner( in );
// do something with the data - example: print it
while( reader.hasNextLine() ) {
    String line = reader.nextLine().trim();
    System.out.println( line );
}
// Done reading file. Close it to free resources.
reader.close();
```

The JVM uses multiple class loaders. We want the class loader for this class, so we wrote `ClassName.class.getClassLoader()`.  That is kind of hacky: the ClassName is a constant.  You can write more general code by using this more expression:
```java
ClassLoader loader = Thread.currentThread().getClass().getClassLoader();
```
If the code is part of an instance method instead of a static method, then simply use **this** (refers to "this" object):
```java
ClassLoader loader = this.getClass().getClassLoader();
```

#### How to Parse Input Lines

Since we want to ignore blank lines and lines that begin with "#", its probably easiest to read the entire line at once.  But then, how do you separate the line into parts (menu item name and price)?

Here are 2 ways to split a String at a character:

1. **string.split(regex)** - split string at an expression. Returns an array of Strings
    ```java
    String fruit = "Apples, bananas, and grapes.";
    String[] parts = fruit.split(",");
    // parts = ["Apples", " bananas", " and grapes."]
    // notice that it did not remove spaces
    ```
    You can have `split()` remove spaces by writing a more clever expression.
2. **int index = string.indexOf(char delim)** - get index of a character, then use substring:
   ```java
   String fruit = "Apples, bananas, and grapes.";
   int k = fruit.indexOf(',');
   // returns k = 6
   String start = fruit.substring(0,k);  // = "Apples"
   String rest =  fruit.subtring(k+1);   // = " bananas, and grapes."
   ```

The String class also has a `lastIndexOf(char)` method that is sometimes useful.

#### How to Read Data of Unknown Length

The menu may contain an arbitrary number of items, so we cannot directly save the data into an array.  Instead, use two ArrayLists: one for the item names and one for prices.  Append all the menu items to the ArrayLists.

When you are finished reading the data, create arrays from the ArrayList.  Use the method `arrayList.toArray()`.  For a String ArrayList:
```java
List<String> list = new ArrayList<String>();
list.add("something");
...   // add more items

// create an array 
String[] array = new String[ list.size() ];
list.toArray( array );
// return the array to caller, or set an attribute
// of the class so your app can use it later
return array;
``` 
#### Closing a File

When you are done using an InputStream or OutputStream, it is a good idea
to close it.  It frees resources.  For the InputStream, if you are using a `Scanner` to read it, then just close the Scanner.
Scanner will close the InputStream for you.

```java
Scanner scanner = new Scanner( inputStream );
// read the data using Scanner
while( scanner.hasNextLine() ) {
   ...
}
// done reading the data, close it
scanner.close();
```

#### Writing Text to a File

To read text (strings, numbers, etc) from a file we first open an InputStream (reads bytes) and then create a Scanner or BufferedReader to read text. 

Similarly, to **write** to a file we first open an OutputStream (writes bytes) and then create a PrintWriter (or PrintStream) to write formatted text.

Here is one way to do that using a file for the output.  First we open a **FileOutputStream** object, then create a **PrintStream** object to handle writing of text and formatting.  Opening a file for input or output may cause an Exception to be thrown if the file cannot be read or written, so the code uses a try - catch block to handle the exception.  If an exception occurs, the code will jump into the "catch" block.  If everything is OK, it will skip over the catch block.   See *Big Java* section 11.3 for info about handling exceptions.

```java
String outputfile = "test.txt";
OutputStream out = null;
try {
    out = new FileOutputStream( outputfile );
} catch (FileNotFoundException ex) {
    System.out.println("Couldn't open output file "+outputfile);
    return;
}
// now we have an OutputStream.  Create a PrintStream for text output.
PrintStream pout = new PrintStream(out);

// PrintStream works just like System.out.
// You can use print(), println(), and printf().
pout.println("Some test output");
pout.printf("The time is %tT\n", System.currentTimeMillis());

// Close the file when you are done
pout.close();
```

#### How to Initialize RestaurantManager at Startup

The RestaurantManager should read the menu file only once, but we need the menu data before the app can do anything.  We **might** also need to open the orders file for recording orders (or open the orders file each time you write an order and then close it). A simple solution is to make RestaurantManager read the data when the program starts.  

Suppose you have a method named **init()** that initializes everything the RestaurantManager needs:
```java
class RestaurantManager {
    private static String[] menuItems;
    private static double[] prices;

    public static void init() {
        // read the menu from file, put the data in arrays
        // open the sales log
    }
}
```
From your application's "main" method (probably in the SKE Restaurant class), just call:
```java
    RestaurantManager.init();
```
