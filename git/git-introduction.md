---
layout: page
title: Introduction to Git
description: Introduction to Git
---

## About Git

Git is a version control system.  It keeps a history and archive of changes 
to a collection of files, such as files in a project.

Git keeps a record of every change to a collection of file, along with who made the change, a reason (specified in a log message), and a way for the user to recover any previous version
of any file.  This is similar to the way Google Docs keeps a history of changes to a Google Doc,
except git operates on a collection of files rather than just individual files.

With Git you can also control who has read or write access to files in a repository.

## Git Software

There are many tools for using git, including:

1. **git command line tool** - what we will use and the best way to learn git. Download from [http://git-scm.com/downloads](http://git-scm.com/downloads). For Ubuntu, use `apt-get install git`.
2. **Git GUI client** such as ProGit or SourceTree.
3. **IDE builtin Git feature** Eclipse, Netbeans, IntelliJ, and BlueJ all have a builtin git. After you throughly understand git, these tools are a fast, easy way to use git while programming; but if you *don't* know git well it is easy to make mistakes or be confused.

## Git Concepts and Basic Usage

This explanation uses the command line git.  It describes how to use a local `git` repository. How to use Github as a remote repository is introduced later.

### Creating a Local Git Repository

A git repository stores a collection of files for one project.  You designate which files you want git to save.  To create a local git repostory:

1. Change to the directory containing the project:
```
cmd> cd workspace/myproject
```
2. Run `git init` to create an empty repository
```
cmd> git init
```
This creates a subdirectory named `.git` containing the repository. Don't edit files in that directory! Let git manage it.  Now you should have:
```
myproject/
    .git/ 
    (your project files)
```

## Adding files and checking status

You must tell git which files it should save or "track" by using the `git add` command.  Suppose your project has a file README.md containing this text:
<blockquote>
<pre>
    # My Project  
    by Bill Gates  
    Every project should have a README.md that describes the project
</pre>
</blockquote>

Add this file to the repository using:
```
cmd> git add README.md
```
`git add` marks the file for adding (or updating) to the repository, but does not actually save it.
You can add as many files as you want.
```
cmd> git add Problem1.java  Problem2.java
cmd> git status
  Changes to be commited:
     new file:  README.md
     new file:  Problem1.java
     new file:  Problem2.java
```
The `git status` command shows that there are 3 new files waiting to be added to the repository.

To save the files to the repository use `git commit`.  You must write a log message (-m) with a short explanation:
```
cmd> git commit -m "Initial code checkin"
  3 files changed, 3 insertions, 0 deletions
cmd> git status
nothing to commit, working directory clean
```

## Important Concepts

**Git 4 Storage Areas:**

1. **Working Copy** is the files in your project directory (and its subdirectories). These are the files you edit during your work; it includes **tracked** files (files you have added to repo using *git add*) and untracked files.  
2. **Staging Area** files waiting to be committed to the repository. Use `git add` to add files to the staging area.
3. Local **Repository** contains all revisions of all files "committed" to the repository, along with dates and log messages.  When a file is updated, only the changes are stored, so a repository does not require much space.
4. (Optional) **Remote Repository** is a git repository on another host, like Github.  You can synchronize your local repository with the remote.

A **revision** is one snapshot of a project, created by running "git commit".  Each revision is identified by a code like 58eb09c, generated from a hashcode of the committed files.

**HEAD** refers the most recent version (revision) of files in the repository.

**master branch** (or **master**) is the main branch of revisions in a repository. 

#### Example

In the example above, we added 3 files to the repository.  You can see a history of all commits (revisions) by typing `git history`:
```bash
cmd> git history
git history
* 5d1ab24 - (2 minutes ago) initial code checkin - fatalaijon (HEAD -> master)
```
This shows there was 1 commit with revision code 5d1ab24 and message "initial code checkin". Its also the HEAD revision on the master branch.

## Two Important Files: README.md and .gitignore

Most git projects include 2 special files:
<dl>
<dt><code>README.md</code></dt>
<dd>A description of the project, formatted using Markdown syntax</dd>
<dt><code>.gitignore</code></dt>
<dd>List of files and wildcard patterns for files that git should <b>ignore</b> (not add to the repo)</dd>
</dl>

## Files You Should Not Save in a Git Repository

Don't commit files that can be created from other files, or easily downloaded from the Internet.  For a Java project, don't commit `*.class` files because these are output from the Java compiler. Every time you compile the Java source code, the \*.class files are recreated.

You usually don't want to commit the IDE project files. Your IDE can recreate these
if needed.  For Eclipse, the project files to ignore are .classpath, .project, and .settings.

Here is an example `.gitignore` file for a Java project:
```
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
nbproject/private
nbbuild/
dist/
nbdist/
nb-configuration.xml

# IntelliJ project files
.idea/
*.iml
*.iws
*.ipr
```
**Note:** You **should** add `.gitignore` to the repository:
```
cmd> git add .gitignore
cmd> git commit -m "Add .gitignore"
```


