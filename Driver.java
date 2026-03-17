public class Driver{
  public static void main(String[] args){
    MyDeque a = new MyDeque();
    System.out.println(a);
    a.addFirst("6");
    System.out.println(a);
    a.addLast("10");
    System.out.println(a);
    for (int i = 0; i < 10; i++){
      a.addFirst("5");
    }
    System.out.println(a);
    System.out.println("new size: " + a.size());
  }
}
