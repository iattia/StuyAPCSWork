public class Driver{
  public static void main(String[] args){
    RealNumber re1 = new RealNumber(10.43);
    RealNumber re2 = new RealNumber(3.45);
    RationalNumber ra1 = new RationalNumber(3,4);
    System.out.println(re1.equals(re2));
    System.out.println(re1.compareTo(re2));
    System.out.println(re1.subtract(re2));
    System.out.println(ra1.reciprocal());
  }
}
