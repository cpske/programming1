## Programming Problems using ArrayList

You will submit this assignment using git and Github.

### Instructions

1. Go to the URL given in class; accept the assignment and create a repository.
2. Clone the repository to your computer.
   ```
   # Change directory to your workspace for Programming 1 labs:
   cmd> cd someplace/workspace
   # Clone the project. This will clone arraylistlab-yourlogin into a
   # new directory named arraylab.
   cmd> git clone  https://github.com/OOP2018/arraylistlab-yourlogin.git  arraylistlab
   ```
3. Complete the problems below.  Periodically "commit" your work to your local repository.
4. Test your work.  Review your code.  Is it well formatted and easy to read?
5. Push the finished lab to Github:
   ```
   cmd> git push
   ```
6. Ask the instructor or TA to review your code!  You might get some good ideas for improving it.  You can "push" again (and again) if you make changes.

### Problem 1: ListExplorer.java

Complete these methods.  The Javadoc comments in code describe what each method should do.

1. **printList(ArrayList\<String\> list)** prints contents of the list on the console like this:
    ```shell
    list = { first, second, third, fourth }
    ```
    If the list is empty, then print:
    ```shell
    list = { }
    ```
    Print only 10 elements per line. Add newline after each 10th element.
2. **append(String value, ArrayList\<String\> list)** append value to the list. Don't print anything.
3. **insert(String value, int index, ArrayList\<String\> list)** insert **value** at position **index** in the list.  If successful, don't print anything.  If index is too large then print a message like: `8 is too large. Last index is 5`.
4. **remove(int index, ArrayList\<String\> list)** remove one element from list at **index** and print it on the console.  For example:
    ```
    Removed Banana
    ```
    If the index is too large, then print (for example):
    ```
    8 is too large. Last index is 5.
    ```
5. **find(String value, ArrayList\<String\> list)** find **value** in the list and print index of its position. For example `find("Banana",list)` might print: `Banana is element 5`.  If it is not in list, print: `Banana not in list`.
6. **Run** the application.  Use the console dialog to see what the ArrayList methods do. 

Example of running program:
```shell
a value       - append value to the end of list
i index value - insert a value into list at index (integer)
d index       - delete element at index
f value       - find value in the list, print its location
p             - print the list
q             - quit
?             - print this menu again
Input: p
list = { }
Input: a apple
Input: a orange
Input: p
list = { apple, orange }
Input: i 1 fig
Input: p
list = { apple, fig, orange }
Input: d 0
Removed apple
Input: p
list = { fig, orange }
Input: a apple
Input: p
list = { fig, orange, apple }
Input: f orange
orange  is element 1
Input: q
```

### Problem 2: Code Improvement 

**ArrayList** implements the **List** interface.  That means ArrayList is a kind of *List*.  All kinds of *List* have the same methods, so the ListExplorer methods should work with any List -- not just ArrayList.

When you use a List as method parameter, it is more flexible to use the Interface type (List) instead of a specific class name (ArrayList). In this problem, we should use "List" instead of "ArrayList" as parameter type.  For example:
```java
public void findStudent( List<String> students, String name )
```
is better than:
```java
public void findStudent( ArrayList<String> students, String name )
```

1. In all the methods that have `ArrayList<String>` as a **parameter**, change the parameter type to `List<String>`.  (But don't change the local `list` variable in consoleDialog.)
2. Add the import `import java.util.List;`.
3. Verify that the program still works correctly.

Any method that expects a "List" as parameter will accept an "ArrayList" object as the actual value when you invoke the method.  It is a form of *polymorphism*.


