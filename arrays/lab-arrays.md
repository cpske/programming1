## Programming Problems using Arrays

You will submit this assignment using git and Github.

1. Go to this URL to accept the assignment and create a repository.
2. Clone the repository to your computer.
   ```
   # Change directory to your workspace for Programming 1 labs:
   cmd> cd someplace/workspace
   cmd> git clone http://github.com/OOP2018/arraylab-yourname arraylab
   ```
3. Complete the problems below.  Its good to periodically "commit" your work to your local repository.
4. Test your work.  Review your code.  Is it well formatted and easy to read?
5. Push the finished lab to Github:
   ```
   cmd> git push
   ```
6. Ask the instructor or TA to review your code!  You might get some good ideas for improving it.

### Problem1.java

Complete these methods in the class **Problem1.java**. They are all **public static**.

1. **String[] readArray()** - read Strings from the console and return them in an array.  Ask the user how many strings, then create an array, and use a loop to read each element from the console. Note that **scanner.next()** can read words on the same line or different lines -- it doesn't care. Here is example of what happens when you call **readArray()**:
    ```shell
    How many strings to input?  5
    Input 5 strings separated by space or newline:
    Java arrays 
    have
    fixed length
    ```
    **readArray()** should return array: ["Java","arrays","have","fixed","length"]
2. **void printArray(String[] array)** - print the elements of an array, one per line.  Example:
    ```java
    String[] fruit = {"apple", "banana", "orange"};
    printArray(fruit);
    ```
    should print:
    ```
    apple
    banana
    orange
    ```
3. **void printUnique(String[] array)** - print the elements of an array one per line, but omit duplicate values. Example:
    ```java
    String[] fruit = {"fig", "apple", "fig", "orange", "apple"};
    printUnique(fruit);
    ```
    should print only:
    ```
    fig
    apple
    orange
    ```

## Problem 2: Fibonacci.java

1. In the Fibonacci class, write a method **long[] makeFibonacci(int n)** that returns an array of the first **n** Fibonacci numbers. Fibonacci numbers are defined by the formula:    
    f[0] = f[1] = 1     
    f[n] = f[n-1] + f[n-2] for n > 1.    
2. Write a **main** method to test your makeFibonacci method. You must test **at least** these cases:
    * makeFibonacci(1) returns an array of size 1 containing [1]
    * makeFibonacci(5) returns an array of size 5 containing [1, 1, 2, 3, 5]
    * makeFibonacci(50) returns an array of size 50 and fib[49] is 12,586,269,025.

**Note:** If you want to Java to print numbers with "," use the "%,d" format: `System.out.printf("%,d", n)`
    
## Problem 3: ArrayMath

No lab about arrays would be complete without some linear algebra problems! Write these **public static** methods in the **ArrayMath** class:

1. **dotProduct(a, b)** - compute the dot-product of two arrays of double. It should return a **double** value.  If the lengths of a and b are different, compute the dot-product using the smaller length.  Example:
   ```java
   double[] a = {2, 5, 8};
   double[] b = {3, -1, 10};
   double prod = dotProduct(a, b);  // prod = 2x3 + 5x(-1) + 8x10 = 81.
   double[] c = {4, 20};
   prod = dotProduct(a,c);  // prod = 2x4 + 5x20 = 108, since c is shorter
   ```
2. **norm(double[] a)** - return the Euclidean length of double vector `a`.  It is the square root of the sum of squares of elements: Math.sqrt(a0^2 + a1^2 + a2^3 ...). **Hint:** To compute the square of x, `x*x` is faster than calling Math.pow()!
   ```java
   double[] a = {3.0,4.0};
   double z = norm(a);  // is 5.0
   double[] b = {2E6, 3E6, 5E6};
   double big = norm(b); // is 6.164414E+6
   ```
3. **long[] makePrimes(int howMany)** - return an array containing the first **howMany** prime numbers. The first prime number is 2 (not 1, sorry).
    **Hint:** Suppose you are using a loop k=3,5,7,... to search for prime numbers and have already found primes p[0], p[1]..., p[n].  To test if k is prime, you only need to test if k can be divided by p[0], p[1]..., p[n].
   ```java
   long[] primes = makePrimes(5);
   System.out.println("First 5 prime numbers are:");
   // you could use a for-each loop here
   for(int j=0; j<primes.length; j++) System.out.println(primes[j]);
   ```
4. **double min(double[] x)** return the minimum value in x.
5. **int argmin(double[] x)** return the index of the element in x which has the smallest value.  For example:
   ```java
   double[] x = {5.0, 3.0, 0.1, 2.98E+8};
   int n = argmin(x);   // n = 2
   ```
4. Write a **main** method to test all the above methods.  For each method, use at least **3 different test cases**. Be sure to print both the test values and the results of the method call.  If you want to easily print an array, use Arrays.toString() as in this example:
    ```
    import java.util.Arrays;
    ...
        double[] x = {10, 20, 30};
        System.out.println("x = " + Arrays.toString(x));
        // prints: x = [10, 20, 30]
    ```

## Problem 4: Palindrome

A Palindrome is a word or phrase that is the same when read left-to-right and right-to-left.  For example:
```
dad
Mom   (uppercase and lowercase letters are same)
I     (any single letter is a palindrome)
นาน
```
For phrases, a palindrome ignores spaces between words:
```
race car
Do geese see God
กา ฝาก
```
1. In the **Palindrome** class write a static method **isPalindrome(String word)** that returns **true** if the parameter is a palindrome, **false** otherwise.    
    **Hint**: The String class has some methods that may help:
    * **replaceAll(old,new)** replaces the **old** value with the **new** value, and returns the result as a string:  `s = "i love space".replaceAll(" ","");` returns "ilovespace".
    * **toLowerCase()** returns a copy of the string in lowercase.
    * **toCharArray()** splits a String into array of char. `char[] c = "hello".toCharArray()` returns ['h','e','l','l','o'] (array of char).
    
2. Write a **main** method that asks user to input a phrase and then tells him whether or not it is a palindrome.  Loop until user enters a blank line.
    ```
    Enter a blank line to quit.
    Enter a phrase:  mom
    mom is a palindrome
    Enter a phrase:  dog
    dog is not a palindrome
    Enter a phrase:  Race car
    Race car is a palindrome
    Enter a phrase: 
    [Quit]
    ``` 

## Challenge (Optional): Array substitution

Write an **ArrayUtil** class containing these static methods.  The parameters are declared as **Object** so we can use these methods with arrays of any kind of object (like String), but they won't work with array of primitives (like double).

1. **void remove(Object[] array, int index)** - remove the element at index and shift the remaining array elements down.  Set the last element of the array to null after shifting. If index is larger than the last element in the array then do nothing.
2. **void swap(Object[] array, int j, int k)** - swap elements i and j.
3. **void reverse(Object[] array)** - reverse the order of elements in the array.



