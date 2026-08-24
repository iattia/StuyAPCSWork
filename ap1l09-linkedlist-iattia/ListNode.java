public class ListNode{
  private String data;
  private ListNode next,prev;

  public ListNode(String d){ //default next/prev should be null
    next = null;
    prev = null;
    data = d;
  }

  public String toString(){
    return data;
  } //Return the string of the data (matters more for other types of nodes)

  public String getData(){
    return data;
  } //return the data

  public ListNode next(){
    return next;
  } //return the next node

  public ListNode prev(){
    return prev;
  } //return the previous node

  public String setData(String newdata){
    String originalData = data;
    data = newdata;
    return originalData;
  }//replace the data, with the newdata, return the original data.

  public void setNext(ListNode n){
    next = n;
  }

  public void setPrev(ListNode n){
    prev = n;
  }

}
