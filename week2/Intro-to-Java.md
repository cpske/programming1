### Introduction to Java

1. Why Java?

    [2017 Programming Language Ranking on IEEE Spectrum](http://spectrum.ieee.org/computing/software/top-programming-languages-2017-focus-on-jobs) ranks Java #1 for jobs, and #2 overall (Python 100.0, Java 99.4). IEEE uses data from 10 different sources.  You can create a custom ranking (change weights).

    [Coding Dojo](http://www.codingdojo.com/blog/9-most-in-demand-programming-languages-of-2017/) found Java #2 for number of job listings (SQL was ranked #1, but SQL isn't a general programming language).  Python moved to up #3 (40K postings), slightly ahead of Javascript.

2. About the Java language.

    Java is a *compiled*, *statically typed* programming language designed for object-oriented programming.  All code is contained in classes.  Java is very portable -- compiled code can run on any computer with a JVM installed. See slides (below) for example of Java code.

3. How Java works.

    The Java compiler produces machine-independent *byte code* for a virtual machine.  The Java virtual machine (JVM) verifies and runs the byte code.  This means that after you compile a Java program, you can run it on any machine that has a JVM of the same version.  Even the graphics are portable. You can write a Java program on Windows, compile it, and then run it on a Mac or Linux machine.

    The byte code (produced by compiler) is contained in `.class` files, which are usually packaged into JAR files (jar is just an archive of files in ZIP format, similar to a library).
    This is different from languages such as C or C#, where the code must be recompiled for each target platform.

Slide presentation: [Intro-to-Java](0-Intro-to-Java.pdf)


