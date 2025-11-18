public class Driver{
  public static void main(String[] args){
    NoNullArrayList<String> nn1 = new NoNullArrayList();
    OrderedArrayList<String> oa1 = new OrderedArrayList();
    try{
      nn1.add("l");
      System.out.println(nn1);
      nn1.add("a");
      System.out.println(nn1);
      nn1.add("b");
      System.out.println(nn1);
      nn1.add("B");
      System.out.println(nn1);
      nn1.add(null);
      System.out.println(nn1);
    } catch (IllegalArgumentException e){
      e.printStackTrace();
    }
    try{
      oa1.add("l");
      System.out.println(oa1);
      oa1.add("a");
      System.out.println(oa1);
      oa1.add("b");
      System.out.println(oa1);
      oa1.add("B");
      System.out.println(oa1);
      oa1.add(null);
      System.out.println(oa1);
    } catch (IllegalArgumentException e){
      e.printStackTrace();
    }
  }
}
