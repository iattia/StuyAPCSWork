public class Driver{
  public static void makeBorder(){
    for (int i=1;i<81;i++){
      Text.go(i,0);
      if (i==1 || i == 80){
        System.out.print(Text.CYAN+" ".repeat(80));
      }
    }
  }
}
