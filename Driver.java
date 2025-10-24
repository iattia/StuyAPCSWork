public class Driver{
  public static void main(String[] args){
    SuperArray sup = new SuperArray();
    System.out.println(sup);
    sup.add("1");
    System.out.println(sup);
    System.out.println("Expected 1, got: " + sup.get(0));
    System.out.println(sup.set(0,"3"));
    System.out.println(sup);
    sup.add("2");


    /* Phase 2 Testing */
    for (int i=0; i<sup.size(); i++){
      System.out.println(sup.get(i));
    }
    for (int i=0; i<sup.size(); i++){
      sup.set(i,sup.get(i)+"offset");
    }
    System.out.println(sup);

    for (int i=sup.size()-1; i>0; i--){
      sup.set(i-1,sup.get(i));
      if (i == sup.size()-1){
        sup.set(i,"NOPE!");
      }
    }
    System.out.println(sup);
  }
}
