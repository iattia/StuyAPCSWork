public class Driver{
  public static void main(String[] args){
    MyLinkedList ll1 = new MyLinkedList();
    System.out.println(ll1);
    ll1.add("e");
    ll1.add("f");
    ll1.add("d");
    ll1.add("d");
    ll1.add(2,"2");
    System.out.println(ll1);
  }
}
