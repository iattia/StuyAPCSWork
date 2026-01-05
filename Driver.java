public class Driver{
  public static void main(String[] args){
    Recursion.printNoDoubleLetterWords(3, "abcgdsf");
    int[] testCases = {0,1,14,340,1000430,-2101000442,99,1001};
    for (int n : testCases) {
      System.out.println(n + ": " + Recursion.toWords(n));
    }
  }
}
