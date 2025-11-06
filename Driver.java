public class Driver{
  public static void main(String[] args){
    RealNumber rn1 = new RealNumber(10.43);
    RealNumber rn2 = new RealNumber(3.45);
    System.out.println(rn1.equals(rn2));
    System.out.println(rn1.compareTo(rn2));
    System.out.println(rn1.subtract(rn2));
  }
}
