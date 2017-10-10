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

### Problem 1: ListUtil.java

1. Complete the methods in the code, then run the console dialog so you can see how an ArrayList works.
2. Commit the code to Github. Don't forget to put your name in the code.

### Problem 2: Code Improvement: "Program to an Interface"

**ArrayList** implements the **List** interface.  When you declare a parameter, it is more flexible to use the Interface type instead of a specific class name.

1. In all the methods that have `ArrayList<String>` as parameter, change it `Lisst<String>`.
2. Add the import `import java.util.List;`;
3. Verify that the code works exactly the same!

This is called "programming to an interface". 


### Problem 3: Optional

