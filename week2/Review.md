# Review of week1

In week1 you completed the [Accelerated Intro to CS](https://studio.code.org/s/20-hour) on [code.org](https://www.code.org).

> What programming structures (or concepts) did you learn at http://code.org last week? (At least 5)

The students offered the following:
k
1. Code a sequence of instructions to achieve a goal.
2. "Repeat" loop to repeat instructions a set number of times.
3. "While" loop to repate instructions while a test condition is true, e.g.
    ```
    while( pathAhead() )
        moveForward
        [do something]
    ```
4. "if" statement for *conditional logic*, so some instructions are executed only if a condition is true (or false).
    ```
    if( pathAhead() )
       moveForward
    else
       turn(left)
   ```
5. Define a function for a block of code that you can invoke from someplace else in your code. Functions make code modular and reusable. In the "artist" lesson you defined a square with size parameter:
    ```
    Function draw_a_square(size):
        repeat 4:
        do  move forward by size pixels
            turn right by 90 degrees

    # Elsewhere in the code, draw 2 squares, next to each other 
    draw_a_square(100)
    turn right 90 degrees
    move(100)
    turn left 90 degrees
    draw_a_square(50)
    ```
