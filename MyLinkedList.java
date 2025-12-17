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
    for (int i=0;i<index;i++){
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
      back = newNode;
    }else{
      back.setNext(newNode);
      back = newNode;
    }
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

  public String backwardsToString(){
    return "";
  }

   public void add(int index, String element){
     if (index == size){
       this.add(element);
       return;
     }
     ListNode newNode = new ListNode(element);
     if (index == 0){
       newNode.setNext(front);
       front.setPrev(newNode);
       front = newNode;
     } else {
       ListNode current = front;
       for (int i=1;i<index;i++){
         current = current.next();
       }
       current.next().setPrev(newNode);
       newNode.setNext(current.next());
       newNode.setPrev(current);
       current.setNext(newNode);
     }
     size++;
  }

   public String set(int index, String value){
    //Replaces the value at the specified index in this list with the specified value.
    //Return the original String that was present
    ListNode current = front;
    for (int i=0;i<index;i++){
      current = current.next();
    }
    String originalString = current.getData();
    current.setData(value);
    return originalString;
  }

  public boolean contains(String element){
    //Returns true if this list contains the specified element, false otherwise.
    for (int i=0;i<size;i++){
      if (this.get(i).equals(element)){
        return true;
      }
    }
    return false;
  }

  public String remove(int index){
    //Removes the element at the specified position in this list..
    ListNode current = front;
    for (int i=0;i<index;i++){
      current = current.next();
    }
    String toRemove = current.getData();
    if (size == 1){
      front = null;
      back = null;
    } else if (index == 0){
      front = front.next();
      front.setPrev(null);
    } else if (index == size-1){
      back = back.prev();
      back.setNext(null);
    } else{
      current.prev().setNext(current.next());
      current.next().setPrev(current.prev());
    }
    size--;
    return toRemove;
  }

  public boolean remove(String element){
    //Removes the first occurrence of the specified element from this list, if it is present..
    for (int i=0;i<size;i++){
      if (this.get(i).equals(element)){
        this.remove(i);
        return true;
      }
    }
    return false;
  }


}
