public class MyDeque<E>{
      private E[] data;
      private int size;
      private int start, end;

      public MyDeque(){
        @SuppressWarnings("unchecked")
        E[] d = (E[])new Object[10];
        data = d;
        size = 0;
      }

      public MyDeque(int initialCapacity){
        @SuppressWarnings("unchecked")
        E[] d = (E[])new Object[initialCapacity];
        data = d;
      }

      /**return the current number of values in the deque*/
      public int size(){
        return size;
      }

      /**Format is comma+space separated values e.g. "[a, b, c, d]" or just "[]" */
      public String toString(){
        String result = "[";
        for (int i = 0; i < this.size(); i++){
          result += data[i];
          if (i != this.size()){
            result += ", ";
          }
        }
        return result + "]";
      }

      /**Double the capacity of the deque, copying the old values over in the correct order.*/
      private void resize(){
      }

      /**Add an element to the first position of the deque, resize if needed.*/
      public void addFirst(E element){

      }

      /**Add an element to the last position of the deque, resize if needed.*/
      public void addLast(E element){

      }

      /**Remove and then return the first element*/
      public E removeFirst(){
        return null;
      }

      /**Remove and then return the last element*/
      public E removeLast(){
        return null;
      }

      /**Return but do not remove the first element*/
      public E getFirst(){
        return null;
      }

      /**Return but do not remove the last element*/
      public E getLast(){
        return null;
      }
    }
