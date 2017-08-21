---
layout: page
title: Using Arrays
description: Idioms and methods for array
---
## Loops for Processing Array Elements

You often want to process every element in an array.
The typical logic is:
```
initialize some values
foreach element in array
{
    process this element
}
compute some result
```
Here are 3 kinds of loops for arrays.

### 1. "for" loop with index

This loop is useful if you need to know the index of the array element,
or you don't want to process every element.  The syntax is:
```
for(int index=start; test_condition; increment_operation) {
   statements for loop
}
```
For example, to compute the sum of squares:
```java
double[] array = /* some array of values */;
double sumSquares = 0;
for(int k=0; k<array.length; k++) {
    sumSquares += array[k]*array[k];
```
The `test_condition` can be anything that evaluates to true or false.

### 2. for-each loop

If you want to process *all* the elements of an array and don't need
to know the index of each element, use a for-each loop.
The syntax is:
```
for( Datatype x : array )  { ... }
```
The `Datatype` should be the type of elements in the array, and `x` is the name of the loop variable (anything you like).

Here's the same example of summing squares of array elements:
```java
double[] array = /* some array */;
double sumSquares = 0;
// "foreach x in array"
for(double x: array) {
    sumSquares += x*x;
}
```
The loop is much easier to read with the index (k).

### 3. While loop



### Secret: every "for" loop is a "while" loop, and vice versa

You can always rewrite a "for" loop as "while", and "while" as "for".
```java
for(int k=0; k<x.length; k++) { statements; }
```
is same as:
```java
int k = 0;
while(k < x.length) { statements;  k++; }
```

Conversely:
```java
while( someTest() ) { statements; }
```
is the same as:
```java
for(  ; someTest(); ) { statements; }
```

You can even write "do forever" loops:
```java
while( true ) { /* loop forever */ }
```
or:
```java
for( ; ; ) { /* loop forever */ }
```

