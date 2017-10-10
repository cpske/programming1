
### Optional: Type parameter instead of "String"

The methods in the ListUtil only accept an ArrayList of String, such as:
```java
public static void print(List<String> list)
```
You can add a type parameter to the method so it accepts list of any kind of object:
```java
public static<T> void print(List<T> list)
```
Now, you can call `print` using `ArrayList<String>` or `ArrayList<Double>` or `ArrayList<Food>`.
Java automatically sets the value of &amp;T&amp;.

If the method has other parameters or local variables that depend on type, you can use "T" for their type also.  For example:
```java
public static void find(String arg, List<String> list)
```
becomes:
```java
public static<T> void find(T arg, List<T> list)
```
