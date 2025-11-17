[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/iGYnqxS-)
![CI](https://github.com/stuycs-k/AP1L07-T/actions/workflows/ci.yml/badge.svg)

# APCS - Lab07 - NoNullArrayList
You are implementing two classes:

# NoNullArrayList

```
public class NoNullArrayList<T> extends ArrayList<T>{

}
```

### 2 Constructors: 

`public NoNullArrayList()`

`public NoNullArrayList(int initialCapacity)`

### 3 Overrides:

  `public T set(int index, T value)`
  
  `public boolean add(T value)`
  
  `public void add(int index, T value)`

# OrderedArrayList

```
public class OrderedArrayList<T extends Comparable<T>> extends NoNullArrayList<T>{
}
```


### 2 Constructors: 

`public OrderedArrayList()`

`public OrderedArrayList(int initialCapacity)`

### New Method:
  
```
/*return the index that the value should be placed
 *when inserting into the OrderedArrayList.
 */
private int whereToPlace(T value){ 
}
```

When whereToPlace recieves a null as the new value, it should return 0.


### 3 Overrides:


  `public boolean add( T value)`
  The `add` method should add the value to the correct spot based on `whereToPlace`
  
  `public void add(int index,T value)`
  This `add` should behave the same as the single argument add, the index is ignored.

  `public T set(int index, T value)`
  set should add the value to the correct spot, and remove the element at the index. Be careful not to remove the existing element if null is given. 
