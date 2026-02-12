public class MyDeque<E>{
      private E[] data;
      private int size;
      private int start, end;

      public MyDeque(){
            
      }
      
      public MyDeque(int initialCapacity){
            
      }
      
      /**return the current number of values in the deque*/
      public int size(){
        return 0;
      }

      /**Format is comma+space separated values e.g. "[a, b, c, d]" or just "[]" */
      public String toString(){ 
        return "";
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
