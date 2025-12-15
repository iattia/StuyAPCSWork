public class MyLinkedList{
  private int size;
  private ListNode front,back;

  //You will only write the no argument Constructor, as you do not have a capacity.
  public MyLinkedList(){
    size = 0;
    front = null;
    back = null;
  }

  public int size(){
    //Returns the number of elements in this list.
    return size;
  }
  public String get(int index){
    //Return the value at the specified index.
    ListNode current = front;
    for (int i=0;i<index-1;i++){
      current = current.next();
    }
    return current.getData();
  }

  public boolean add(String e){
    //Appends the specified element to the end of this list.
    ListNode newNode = new ListNode(e);
    newNode.setNext(null);
    newNode.setPrev(back);
    if (size==0){
      front = newNode;
    }
    back = newNode;
    size++;
    return true;
  }

  public String toString(){
    //same format as ArrayList "[A, B, C]" or "[]"
    String listString = "[";
    for (int i=0;i<size;i++){
      listString += this.get(i);
      if (i!= size-1){
        listString += ", ";
      }
    }
    listString += "]";
    return listString;
  }

   public void add(int index, String element){
    //Inserts the specified element at the specified position in this list.
  }

   public String set(int index, String value){
    //Replaces the value at the specified index in this list with the specified value.
    //Return the original String that was present
    return "";
  }

  public boolean contains(String element){
    //Returns true if this list contains the specified element, false otherwise.
    return true;
  }

  public String remove(int index){
    //Removes the element at the specified position in this list..
    return "";
  }

  public boolean remove(String element){
    //Removes the first occurrence of the specified element from this list, if it is present..
    return true;
  }


}
