### Introduction to Java

1. Why Java?

    [2017 Programming Language Ranking on IEEE Spectrum](http://spectrum.ieee.org/computing/software/top-programming-languages-2017-focus-on-jobs) ranks Python slightly above C and Java overall (Python 100.0, Java 99.4), but Java is #1 for Jobs.  IEEE uses data from 10 different sources.  You can create a custom ranking (change weights).

    [Coding Dojo](http://www.codingdojo.com/blog/9-most-in-demand-programming-languages-of-2017/) Programming Jobs: SQL was most in-demand. Java was #2 (about 68K job postings), Python moved up 2 spots to #3 (40K postings), slightly ahead of Javascript.

2. About the language.

    Java is a *compiled*, *statically typed* programming language designed for object-oriented programming.  All code is contained in classes.  The Java compiler verifies syntax and validity Java is very portable -- compiled code can run on any computer with a JVM installed. See below for code example.

3. How Java works.

    The Java compiler produces machine-independent *byte code* for a virtual machine.  The Java virtual machine (JVM) verifies and runs the byte code.  This means that after you compile a Java program, you can run it on any machine that has a JVM, of the same version.  Even the graphics are portable. You can write a GUI app on Windows, compile it, and then run it on a Mac or Linux machine.

    The byte code (produced by compiler) is contained in `.class` files, which are usually packaged into JAR files (jar is just an archive of files in ZIP format, similar to a library).
    This is different from languages such as C or C#, 
where the code must be recompiled for each target platform.

Slide presentation: [Intro-to-Java](0-Intro-to-Java.pdf)


