

## Written Practice

1. Using only **one Java statement** create an array named `fruit` containing the strings "apple", "banana", "fig", "orange".

2. Suppose `x` is an array variable.  How do you get the value of the **last** element of x? 

3. `x` is an array of `double`.  Write a loop to set all the values to 0.0.

4. Find and fix the errors in some code.

5. What does this code do?

6. Java has a class named `LocalDate` in package `java.time`.  To create a LocalDate object you write:
    ```
    LocalDate date = new LocalDate(year, month, day);
    // localdate for December 31:
    LocalDate endyear = new LocalDate(2017, 12, 31);
    ```
Create an array named `months` of 12 LocalDate objects.  Use a loop to set the objects to the first day of each month (year 2017), e.g. months[0] is 1/1/2017, months[1] is 1/2/2017.

7. Complete this code: write a for-ate` object, you can print the day of the week and day of the month using:
    ```
    // prints "September 1 is FRIDAY" (maybe)
    System.out.printf("%s %d is %s\n", date.getMonth(), 
                      date.getDayOfMonth(), date.getDayOfWeek() );
    ```

