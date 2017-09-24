---
layout: page
title: Introduction to Git
---

## About Git

Git is a version control system.  It keeps a history and archive of all changes 
to a collection of files, such as files in a project.

Git records every change to a collection of files, along with who made the change and why. Git lets you view changes and recover any previous version of any file (even deleted files!).  This is similar to the way Google Docs keeps a history of changes to a Google Doc,
except git operates on a collection of files rather than just individual files.

Git also lets you control who has read or write access to files in a repository.

## Git Software

There are many tools for using git, including:

1. **Git command line tool** - what we will use and the best way to learn git. Download from [http://git-scm.com/downloads](http://git-scm.com/downloads). For Ubuntu, use `apt-get install git`.
2. **Git GUI client** such [SourceTree](https://www.sourcetreeapp.com/).
3. **IDE builtin Git feature** Eclipse, Netbeans, IntelliJ, and BlueJ all include git tools. After you thoroughly understand git, these tools are a fast, easy way to use git while programming; but if you *don't* know git well it is easy to make mistakes or be confused.

### Git Concepts and Basic Usage

This explanation uses the command line `git` program.  It describes how to use a local git repository. 

How to use Github as a remote repository is introduced in a separate document.

### Creating a Local Git Repository

A git **repository** stores a collection of files for **one project**.  Create a git repostory for a project:

1. Change to the directory containing the project:
```shell
cmd> cd workspace/myproject
```
2. Run `git init` to create an empty repository
```shell
cmd> git init
```
This creates a subdirectory named `.git` for the repository. Don't edit files in that directory! Let git manage it.  Now your project will look something like:
```shell
myproject/
    .git/  (git local repository)
    bin/   (directory for compiler output. May be "build/" or "out/")
    src/   (your project source code)
    other project files
```
3. The new repository is empty. You must add files, as described below.

### Add files to the Repository and Check Status

You must tell git which files it should save in the repository using the `git add` command.  Suppose your project has a file README.md containing this text:
<blockquote>
<pre>
    # My Project  
    by Bill Gates  
    Every project should have a README.md that describes the project
</pre>
</blockquote>

Add this file to the repository using:
```shell
cmd> git add README.md
```
You can add as many files as you want. Add some source code files:
```shell
cmd> git add src/Problem1.java  src/Problem2.java
```

`git add` marks the files for add (or update) to the repository, but does not actually save them.  You can check the status using:
```shell
cmd> git status
  Changes to be commited:
     new file:  README.md
     new file:  src/Problem1.java
     new file:  src/Problem2.java
```
The `git status` command shows that there are 3 new files waiting to be added to the repository.

To save the files to the repository use `git commit`.  You must write a log message (-m) with a short explanation:
```shell
cmd> git commit -m "Initial code checkin"
  3 files changed, 3 insertions, 0 deletions
cmd> git status
  nothing to commit, working directory clean
```
Now your repository contains 3 files (called **tracked files**).

## Adding a Directory to the Repository

You can use `git add` to add a directory and all its files.  Git will add **everything** in the directory and its subdirectories -- so be careful.

If you want to add **everything** in the project `src` directory to git, use:
```shell
cmd> git add src
```
**Note**:  **After** you add the `src` dir to git, if you later create new files in the "src" directory then you must add those files to git yourself. Its not automatic.

As usual, to save the directory and its contents to the repository, run `git commit`:
```shell
cmd> git commit -m "add source code dir"
```

### View History

View the history of all commits (revisions) to a repository by typing `git history`.
For the example above:
```shell
cmd> git history
git history
* 992a0c5 - (2 minutes ago) add source code dir  - fatalaijon (HEAD -> master)
* 5d1ab24 - (5 minutes ago) initial code checkin - fatalaijon 
```
This shows there were 2 commits. The most recent commit has revision code 992a0c5 and message "add source code dir". It is also the HEAD revision on the master branch.

### Updating Your Files

Each time you make changes to a previously commited file (called a **tracked file**), you need to commit those changes to the repository.  First, check the status of your working copy:
```shell
cmd>  git status
On branch master
Changes not staged for commit:
   modified:   src/Problem1.java
   modified:   README.md
```
This shows that `src/Problem1.java` and `README.md` have been modified since the last commit. To update the repository, enter:
```shell
cmd>  git add src/Problem1.java README.md
cmd>  git commit -m "fixed bugs in Problem 1"
  [master 7cb3e90] fixed bugs in Problem1
  2 files changed, 35 insertions(+), 11 deletions(-)
```
**Shortcut**: if you want to commit all modifications to tracked files, you can skip "git add" and use `git commit -am` ("-a" means "all"):
```shell
cmd>  git commit -am "fixed bugs in Problem 1"
```

### Important Concepts

Git uses 4 storage areas:

1. **Working Copy** is the files in your project directory (and its subdirectories). These are the files you edit during your work; it includes **tracked** files (files you have added to repo using *git add*) and **untracked** files.  
2. **Staging Area** of files waiting to be committed to the repository. `git add` adds files to the staging area.
3. Local **Repository** contains all revisions of all files "added" and "committed" to the repository, along with dates and log messages.  When a file is updated, only the changes are stored, so a repository does not require much space.
4. **Remote Repository** (optional) is a git repository on another host, like Github.  You can synchronize your local repository with the remote repository.

A **Revision** is one snapshot of a project, created using "git commit".  Each revision is identified by a code like 58eb09c. This code (the revision id) is based on a hashcode of the committed files.

**HEAD** refers the most recent version (revision) of files in the repository.

**master branch** (or **master**) is the main branch of revisions in a repository. 

**Tracked files** refers to files that you have committed to the repository. Git constantly checks for changes to these files, every time you run `git status` or other commands.

### Two Important Files: README.md and .gitignore

Most git projects include 2 special files:
<dl>
<dt><b>README.md</b></dt>
<dd>A description of the project, formatted using Markdown syntax. Github and Bitbucket display these files (formatted) when someone visits your project</dd>
<dt><b>.gitignore</b></dt>
<dd>List of files and wildcard patterns for files that git should <b>ignore</b> (not add to the repository)</dd>
</dl>

### Files You Should Not Save in a Git Repository (.gitignore)

Don't commit files that can be recreated from other files, or libraries easily downloaded from the Internet.  For a Java project, don't commit `*.class` files because these are output from the Java compiler. Every time you compile the Java source code, the \*.class files are recreated.

You usually don't want to commit IDE project files. Your IDE will recreate these when you create a new project (even a project with existing source code).  For Eclipse, the project files to ignore are .classpath, .project, and .settings.

Here is an example `.gitignore` file for a Java project:
```shell
# compiler output and build directories
*.class
*.temp
bin/
build/

# Eclipse project files
.classpath
.project
.settings/

# Netbeans project files
nbproject/
nbdist/
nb-configuration.xml

# IntelliJ project files
.idea/
out/
*.iml
*.iws
*.ipr

# MacOS junk (if you use a Mac)
.DS_Store
```

**Note:** You **should add** `.gitignore` to the repository:
```shell
cmd> git add .gitignore
cmd> git commit -m "Add .gitignore"
```

**Note:** Github has examples of `.gitignore` for different programming languages.

### Example README.md

README.md is text with [Markdown] formatting.  Github and Bitbucket show a web page from this file (after formatting it) when someone visits your repository. Use the README to describe the project and anything the viewer needs to know.
```markdown
# Bus Ticket Counter
by Bill Gates

Counts the number of tickets sold for a collection of buses.
Written in Java. Input is read from System.in or a file.
```
Markdown is widely used for formatting web pages, and the syntax is simple.  

* [Mastering Markdown](https://guides.github.com/features/mastering-markdown/) on Github explains Markdown in one page
* [Markdown Tutorial](https://www.markdowntutorial.com/lesson/2/) interactive tutorial.

## Why Use Git? (An Example)

You **work all week** on the final project for your Programming 1 course. You write source code (in /src) and a report (Report.docx), so you project looks like this:
```shell
myproject/
    .gitignore
    README.md
    Report.docx
    bin/   (compiler output)
    dist/  (runnable application)
    src/   (many source code files)
```
You commit everything except "bin" to git, and go to lunch.

When you come back from lunch you find that your **cat has deleted Report.docx** by walking on the keyboard!  Your project report is gone!

![](cat-on-keyboard.jpg?raw=true)

What to do?

Since you saved the report using git, you can **recover** the most recent version of the report from the repository. Use:
```shell
cmd> git checkout -- Report.docx
```

If your cat deletes (or edits) lots of files, you can revert *everything* your working copy to the most recent (HEAD) revision in git. This will discard all changes to your working copy since the last "git commit".
```shell
# Be careful. This will overwrite your working copy 
# with the most recent revision commited to git.
cmd> git reset --hard
```

