[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/E9yrKboB)
# APCS2 Lab06 MyDeque

## Methods:

`addFirst()`,`addLast()`: place a new value on the indicated side (first/last)

`getFirst()`/`getLast()`: return but NOT remove the element. (peek)

`removeFirst()`/`removeLast()`: return AND remove the element. (pop / de-queue)

`toString()`: format has comma space between values, examples: `"[a, b, c, d]"` `"[]"` `"[VALUE, VALUE2, VALUE3]"`. 


## Important:

The left element (a, or VALUE in the toString above) is the start, while the right element (d, or VALUE3) is the end.

All methods should be `O(1)` except `toString()` and `resize()`.

## Exceptions:

Remove/Get (both first and last) will throw: NoSuchElementException - when this deque is empty. Note: This is part of java.util

Add (both first and last) will throw: NullPointerException - if the specified element is null (this deque does not permit null elements)

## Warnings!

Suppress the warning on the creation of the array. Do this in both constructors and resize.

Note you cannot directly assign to the instance variable if you do this. (This is better as it prevents the accidental suppresion of additional warnings)

```
public MyDeque(){
  @SuppressWarnings("unchecked")
  E[] d = (E[])new Object[10];
  data = d;
}
```
