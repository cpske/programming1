---
layout: page
title: Git Assignment
---

## Preparation: Install Git, Create Github Account

1. **Install git** on your computer.
    * Windows and MacOS: download from [https://git-scm.com/downloads][git-scm]
    * Ubuntu: run `sudo apt-get install git`
    * Other Linux: see instructions at [https://git-scm.com/download/linux](https://git-scm.com/download/linux)
2. **Run** these **git** commands in a command window (*aka* a terminal or shell) to verify git is working on your computer:
```shell
cmd>  git --version
git version 2.14.x (your version may be different)
cmd>  git help config
(prints a help message for how to use "git config")
```
3. **Add your name and email:** Before you can use Git with Github or Bitbucket you must tell git **who you are**. This info is included in commit messages.  
Enter these commands (just one time) on your local computer:
```shell
cmd>  git config --global user.name "Your Name"
cmd>  git config --global user.email "youremail@ku.th"
cmd>  git config --list
(shows the config values)
```
You can change this info anytime by running `git config` again.    
**Points Deducted:** If I find commits by you on Github with missing/bogus info, points will be deducted from the assignment.
4. Create an account on [Github](https://github.com). **Complete your Github profile**:
    * Your **full name in English**, with proper case of letters, e.g. Bill Gates (not "bill gates").
    * A **photograph** *clearly* showing your *face*.
    * Your **KU-Gmail** address.
    * (Optional) Write a **profile** about yourself.
    * Example last year OOP students: [Jirayu](https://github.com/JirayuL) and [Kongpon](https://github.com/kykungz) (they both got "A" in OOP2)
    * **Employers** look at your Github account, so do a good job! For example: [https://kykungz.github.io](https://kykungz.github.io)

## Problem 1: Complete this Sign-up Form

Answer these questions: [Git Sign-up](https://goo.gl/cwrBbW) (https://goo.gl/cwrBbW).    
Your score is based on completeness information in your Github account.

## Problem 2: Create a Local Git Repo for Homework 1 and Push it to Github

1. Find your project for Homework 1 ("SKE Restaurant", elab #10).
2. Create a git repository in that directory by running `git init`.
3. Create a `.gitignore` file in your project directory to ignore Java class files and IDE project files.     
    See [Introduction to Git](intro-git) for what to put in `.gitignore`.   
    **Note:** `.gitignore` **must** be in the top-level project directory, **not** in the src/ directory.
4. Create a `README.md` file describing the project. It must contain at least this info:
    ```
    # SKE Restaurant
    by Your Name

    A command line interface for a simple food ordering application.
    (Add more info about your project.)
    ```
5. Add to the repository: a) `.gitignore`, b) `README.md`, c) your **source code** (`src`) directory:
    ```shell
    cmd> git add .gitignore README.md src
    ```
5. Commit the files to the repository using `git commit -m "initial code checkin"`.
6. On **Github** create an *empty* repository named `ske-restaurant`.  It must be empty because you want to upload your local project repository to here.
7. Back in your local project, add the Github as a "remote" repository and "push" your repository to Github:
    ```shell
    cmd> git remote add origin https://github.com/your_github_name/ske-restaurant.git
    cmd> git push -u origin master
    ```
8. In a web browser, view your project on Github.
    * Are all the source files there (in a src/ dir)?
    * Does it have a .gitignore and README.md?
    * Is the formatting of README.md correct?

**Note:** your local project name **can be different** from the Github repository name (ske-restaurant)!  Git doesn't care.

## Problem 3: Improve your SKE-Restaurant and Send Results to Github

**You must do this after Problem 2** I will check that there are 2 commits to Github (before and after changed).

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
2. Make your code **easy to read**.  At least you must have:
    * Class name in *Title Case* such as MenuSystem or Restaurant. Bad names: restaurant, test.
    * Descriptive names for variables and methods.
    * One blank line between each method.
    * Space outside if "(...)" and "{...}", as shown in class.
3. Apply the principle: a method should do only one thing.  Use separate methods for separate tasks and avoid duplicate code.  Some example methods are:
    ```java
    /** Print the menu with prices. */
    public static void printMenu()

    /** Print a message and get the user's input. */
    public static String getReply(String prompt)

    /** Print the user's order and total price. */
    public static void printOrder()

    /** Compute the total price of an order and return it. */
    public static double computeOrderTotal()
    ```
4. Test that your code works correctly after making these changes.
5. Commit changed files to your local repository:
    ```shell
    cmd> git status
    (shows changed files)
    cmd> git add file1 ...   (add any changed or new files)
    cmd> git commit -m "code improvements"
    ```
5. Push your changes to Github using `git push`.
6. View your project on Github to verity the files are up-to-date.

## Problem 4: Code Improvement

In this problem you will clone a project from Github, make code improvements, and then "push" your work back to Github.  In the previous problems you started with local code and then added Github (case 1). In this problem you clone a project from Github (case 2).

We are using **Github Classroom** for this exercise. Your Github repository is in the OOP2018 account instead of your personal Github account.    
The Github URL will look like: `https://github.com/OOP2018/fixcode-yourlogin`.  

When you clone it to your computer, you can rename your copy (clone) so you don't have use the long name `fixcode-yourlogin`.

1. Go the the URL specified in lab to create your assignment.
2. Accept the assignment.  Github will create a repository for you.  The repo name is `https://github.com/OOP2018/fixcode-yourlogin`
3. Clone this repository to your computer.
    a) Go the the repository on Github and click the "Clone or Download" button.
    b) Copy the URL
    c) In a command window (shell) on your computer, change to a directory where you want to save the project.  For Eclipse, this is usually "home_dir/workspace".
    d) Clone the Github repository. In this example, the last argument is the name we want for the local copy (instead of the default `fixcode-yourlogin`):
    ```
    cmd> cd workspace
    cmd> git clone https://github.com/OOP2018/fixcode-yourlogin fixcode
    ```
4. The source code contains TODO comments with instructions.  Do each of the TODO items and **delete the TODO comment** when you are done.
5. Test your code.
6. Commit your changes locally.
7. Upload (push) the changes to the Github repository.


## Homework

Please complete these tutorials. There will be a **Git Quiz** which may include anything from these tutorials.

1. Learn more about git: [https://try.github.io](https://try.github.io)
2. [Using Git on Github](https://guides.github.com/activities/hello-world/).

---
[git-scm]: https://git-scm.com/downloads 
