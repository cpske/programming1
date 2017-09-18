---
layout: page
title: Git Assignment
---

## Preparation: Learn to use Git and Github

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
3. Before you can use Git with Github or Bitbucket you must tell git **who you are**. This info is including in commit messages.  
Enter these commands (just one time) on your local computer:
```shell
cmd>  git config --global user.name "Your Name"
cmd>  git config --global user.email "youremail@ku.th"
cmd>  git config --list
(shows the config values)
```
You can change this info anytime by running `git config` again.
4. Create an account on [Github](https://github.com). **Add these things to your Github profile**:
    * Your **full name in English**, with proper case of letters, e.g. Bill Gates.
    * A **photograph** *clearly* showing your *face*.
    * Your **KU-Gmail** address.
    * (Optional) Write a **profile** about yourself.
    * Example last year OOP students: [Jirayu](https://github.com/JirayuL) and [Kongpon](https://github.com/kykungz) (they both got "A" in OOP2)
    * Employers look at your Github account, so do a good job! Its part of your **resume**. For example: [https://kykungz.github.io](https://kykungz.github.io)

## Problem 1: Complete this Simple Form

Answer these questions: [Git Sign-up](https://goo.gl/cwrBbW) (https://goo.gl/cwrBbW) 

* Your score will include completeness information in your Github account.

## Problem 2: Create a Local Git Repo for Homework 1 and Push it to Github

1. Find your project for Homework 1 ("SKE Restaurant", elab #10).
2. Create a git repository in that directory by running `git init`.
3. Create a `.gitignore` file in the SKE Restaurant project directory to to ignore Java class files and IDE project files. See the [Introduction to Git](git-intro) for what to put in `.gitignore`.
>  `.gitignore` **must** be in the top-level project directory, **not** in the src/ directory.
4. Create a `README.md` file describing the project. It must contain at least this info:

    ```
    # SKE Restaurant
    by Fatalai Jon

    A command line interface for a simple food ordering application.
    (If you write only this, it means you are LAZY.)
    ```
5. Add `.gitignore`, `README.md`, and your **source code** (`src`) to the repository, of course.
5. Commit everything using `git commit -m "initial code checkin"`.
6. On **Github** create an *empty* repository named `ske-restaurant`.  It must be empty because you want to upload ("push") your local project to here.
7. Back in your local project, add the Github repo as a "remote" repository and "push" your repository to Github:
    ```shell
    cmd> git remote add origin https://github.com/your_github_name/ske-restaurant
    cmd> git push -u origin master
    ```
8. In a web browser, view your project on Github.
    * Are all the source files there (in a src/ dir)?
    * Does it have a .gitignore and README.md?
    * Is the formatting of README.md correct?

**Note:** that the Github repo name (ske-restaurant) can be different from your local project name!

## Problem 3: Code Improvement

For this problem you will clone a project from Github, make some improvements in the code, and then "push" your work back to Github.

We are using **Github Classroom** for this, instead of your personal github account.  The Github URL for the project will look like:

(to be completed)

## Homework

Please complete these tutorials. There will be a **Git Quiz** which may include anything from these tutorials.

1. Learn more about git: [https://try.github.io](https://try.github.io)
2. [Using Git on Github](https://guides.github.com/activities/hello-world/).

---
[git-scm]: https://git-scm.com/downloads 
