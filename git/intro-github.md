### Why Use Github?

Using Git on your local computer is a good habit, but...

* What if the hard disk on your computer fails?
* What if want to share a project with someone else?

you also need a **remote** copy of your project -- along with the project history and an easy way to update the remote copy.

Git supports use of **remote** repositories.
[Github](https://github.com) and [Bitbucket](https://bitbucket.org) are 2 well known project hosting sites for git.  Both places let you store projects for free.

Using a git hosting site (such as Github) you can:

* synchronize your local repository with the remote. Only the changes are uploaded/downloaded, so its efficient and fast.
* create a new local copy from the remote
* view project activity, updates, and compare version of files in a browser
* give read-only or read-write access to other people 
* create a professional looking web site for your project (*Github pages*, which are shown on github.io)

### Two Ways to Use Github

How you **initialize** a project with Github has 2 cases:

1. You already have code on your computer.
2. You don't have any code on your computer, or the project already exists on Github.

The only thing that varies is how you create your local repository and connect it with Github.

### Case 1: You already have code on your computer. Copy it to Github.

In this case, there are 3 steps

1. Create a local repository for your and add code to it.
    ```shell
    cmd> cd workspace/myproject
    cmd> git init
    cmd> git add README.md .gitignore  (create these files yourself)
    cmd> git add src
    cmd> git commit -m "initial code checkin"
    ```
2. On Github, create an **empty** repository for the project.
    a. on [github.com](https://github.com) click on the "+" icon at upper-right of your home page and choose "create a new repository".
    b. give the repository a name. It does **not** need to be the same as your local project name.  For Programming 1, use the name the instructor specifies.
    c. don't put any files in the repo (no README or .gitignore)
    d. copy the URL that Github shows you, for example `https://github.com/fatalaijon/assignment1.git`.  (this is the URL for the "https" protocol)
3. Add Github as "remote".  On your local computer, do:
   ```shell
   cmd> git remote add origin https://github.com/fatalaijon/assignment1.git
   cmd> git push -u origin master
   ```
   This adds the Github repo (assignment1) as a remote named "origin". There is nothing special about "origin", but it is the standard name.  `git push` means to copy your local repository to the remote (github), `-u origin master` means that it shoud "push" the "master" branch to the remote named "origin".

You only need to type `git push -u origin master` the **first time** you connect to Github.  After that, when you want to update Github you just type:
```shell
cmd> git push
```

### Case 2: You don't have a project on your computer. Copy from Github.

If the project already exists on Github then do:

1. In web browser, go to the project page on github so you can get the URL
2. Click the "Clone or Download" button. This will show the URL of the project. It also gives instructions.
    * There is a button to copy this URL directly to your clipboard 
3. In the **parent directory** of where you want to clone the project, enter the `git clone` command:
    ```shell
    cmd> git clone https://github.com/fatalaijon/someproject.git
    ```
    This creates a local directory having the same name as remote repository ("someproject" in this example) and copies the Github repo into it.
4. If you want to use a different name for your copy of the repository, then type:
    ```shell
    cmd> git clone https://github.com/fatalaijon/someproject.git  myproject
    ```
    in this case, git will create a directory named `myproject` and copy the project there.

When you clone a project, git remembers the "upstream" location. So you can push (copy) your
local changes using `git push`.

### Case 3: You don't have ANYTHING yet

In this case you can start from either side (local or Github).  But Case 2 (clone from Github) requires less typing. Just create a new repo on Github, let Github create a README and .gitignore for you, and then clone it.

### Pushing Local Changes to a Remote (Github)

Once you have connected a local repository with a Github repository using either Case 1 or Case 2, the information
is saved in the local git configuration.  You can "upload" your changes to Github using:
```
cmd> git push
```

You can start a project by copying it from Github. This is called **cloning**.
Suppose the project already exists on Github. Navigate to the project and copy the 

### Learn Github

* [Using Git on Github](https://guides.github.com/activities/hello-world/), a tutorial on using git with gitub, including use of branches.  The example is a text file with variation in branches.


### Student Developer Pack on Github

A free [student developer pack](https://education.github.com/pack) gives you free private repositories, free builds on Travis CI, and other resources.  Some of the offers are limited to 1 year (starts the first time you use them), so you should read the details before activating a special offer.


### Use SSH Keys instead of your Github password

Every time you `push` an update to Github or Bitbucket, it prompts you for your username and password.  You can eliminate this by setting up a public/private key pair for Github.

The steps are described in [Connecting to Github with ssh](https://help.github.com/articles/connecting-to-github-with-ssh/).
