public class ColorDemo {
  public static final String BLACK_BACKGROUND = "\u001B[40m";
  public static final String WHITE_BACKGROUND = "\u001B[47m";
  public static final String CYAN_BACKGROUND = "\u001B[46m";
  public static final String YELLOW_BACKGROUND = "\u001B[43m";
  public static final String RED_BACKGROUND = "\u001B[41m";
  public static final String RESET = "\u001b[0m";
  public static final String EMPTY_SPACE = "                       ";
  public static void main(String[] args){
    for (int i=0;i<2;i++){
      System.out.println(RED_BACKGROUND+EMPTY_SPACE+EMPTY_SPACE+EMPTY_SPACE);
    }
    for (int i=0; i<2;i++){
      System.out.println(WHITE_BACKGROUND+EMPTY_SPACE+YELLOW_BACKGROUND+EMPTY_SPACE+WHITE_BACKGROUND+EMPTY_SPACE);
    }
    System.out.println(RESET);
  }
}
