import java.util.*;

public class MyDeque<E>{
      private E[] data;
      private int size;
      private int start, end;

      public MyDeque(){
        @SuppressWarnings("unchecked")
        E[] d = (E[])new Object[10];
        data = d;
        size = 0;
        start = 0;
        end = 0;
      }

      public MyDeque(int initialCapacity){
        @SuppressWarnings("unchecked")
        E[] d = (E[])new Object[initialCapacity];
        data = d;
        size = 0;
        start = 0;
        end = 0;
      }

      /**return the current number of values in the deque*/
      public int size(){
        return size;
      }

      /**Format is comma+space separated values e.g. "[a, b, c, d]" or just "[]" */
      public String toString(){
        String result = "[";
        for (int i = 0; i < this.size(); i++){
          result += data[(start + i) % data.length];
          if (i != this.size() - 1){
            result += ", ";
          }
        }
        return result + "]";
      }

      /**Double the capacity of the deque, copying the old values over in the correct order.*/
      private void resize(){
        @SuppressWarnings("unchecked")
        E[] newData = (E[]) new Object[data.length * 2];
        for (int i = 0; i < size; i++){
          newData[i] = data[(start + i) % data.length];
        }
        data = newData;
        start = 0;
        end = size;
      }

      /**Add an element to the first position of the deque, resize if needed.*/
      public void addFirst(E element){
        if (element == null){
          throw new NullPointerException("Element is null");
        }
        if (data.length == size){
          this.resize();
        }
        start = (start - 1 + data.length) % data.length;
        data[start] = element;
        size++;
      }

      /**Add an element to the last position of the deque, resize if needed.*/
      public void addLast(E element){
        if (element == null){
          throw new NullPointerException("Element is null");
        }
        if (data.length == size){
          this.resize();
        }
        data[end] = element;
        end = (end + 1) % data.length;
        size++;
      }

      /**Remove and then return the first element*/
      public E removeFirst(){
        if (size == 0){
          throw new NoSuchElementException("No element to remove");
        }
        E removed = data[start];
        data[start] = null;
        start = (start + 1 + data.length) % data.length;
        size--;
        return removed;
      }

      /**Remove and then return the last element*/
      public E removeLast(){
        if (size == 0){
          throw new NoSuchElementException("No element to remove");
        }
        end = (end - 1 + data.length) % data.length;
        E removed = data[end];
        data[end] = null;
        size--;
        return removed;
      }

      /**Return but do not remove the first element*/
      public E getFirst(){
        if (size == 0){
          throw new NoSuchElementException("No element to get");
        }
        return data[start];
      }

      /**Return but do not remove the last element*/
      public E getLast(){
        if (size == 0){
          throw new NoSuchElementException("No element to get");
        }
        return data[(end - 1 + data.length) % data.length];
      }
    }
