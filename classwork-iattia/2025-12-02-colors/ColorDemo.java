public class ColorDemo {
  public static final String BLACK_BACKGROUND = "\u001B[40m";
  public static final String WHITE_BACKGROUND = "\u001B[47m";
  public static final String YELLOW_BACKGROUND = "\u001B[43m";
  public static final String RED_BACKGROUND = "\u001B[41m";
  public static final String RESET = "\u001b[0m";
  public static final String CLEAR_SCREEN = "\033[H\033[2J"; 

  public static String space(int n) {
    return " ".repeat(n);
  }
  public static void main(String[] args) {
    int[] waveOffsets = {2, 3, 4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4, 3};
    int flagWidth = 69;
    String redStripe = RED_BACKGROUND + space(flagWidth) + RESET;
    String blackStripe = BLACK_BACKGROUND + space(flagWidth) + RESET;
    String whiteStripe1 = WHITE_BACKGROUND + space(30) + YELLOW_BACKGROUND + space(9) + WHITE_BACKGROUND + space(30) + RESET;
    String whiteStripe2 = WHITE_BACKGROUND + space(28) + YELLOW_BACKGROUND + space(13) + WHITE_BACKGROUND + space(28) + RESET;
    String whiteStripe3 = WHITE_BACKGROUND + space(30) + YELLOW_BACKGROUND + space(9) + WHITE_BACKGROUND + space(30) + RESET;
    try {
      while (true) {
        for (int i = 0; i < waveOffsets.length; i++) {
          int offset = waveOffsets[i];
          System.out.print(CLEAR_SCREEN);
          System.out.flush();
          String indent = space(offset);
          System.out.println(indent + redStripe);
          System.out.println(indent + redStripe);
          System.out.println(indent + redStripe);
          System.out.println(indent + whiteStripe1);
          System.out.println(indent + whiteStripe2);
          System.out.println(indent + whiteStripe3);
          System.out.println(indent + blackStripe);
          System.out.println(indent + blackStripe);
          System.out.println(indent + blackStripe);
          System.out.println(RESET);
          Thread.sleep(50);
        }
      }
    } catch (InterruptedException e) {
        System.out.println("\nAnimation stopped.");
      }
  }
}