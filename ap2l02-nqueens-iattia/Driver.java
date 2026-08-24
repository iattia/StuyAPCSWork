public class Driver{
  public static void main(String[]args){
    QueenBoard b;
    int size = 8;
    if (args.length > 0) {
      size = Integer.parseInt(args[0]);
    }
    try{
      b = new QueenBoard(size);
      if (args.length > 1) {
        b.setAnimate(true);
        b.setDelay(Integer.parseInt(args[1]));
      }
      System.out.println(Text.CLEAR_SCREEN);
      System.out.println(Text.HIDE_CURSOR);
      Text.go(1, 1);
      b.solve();
      System.out.println(Text.RESET);
      Text.go(1,1);
      System.out.println(b);
    }catch(Exception e){
	    System.out.println("Fail solve size "+size+" board, exception"+e);
    }


    try{
      b = new QueenBoard(size);
      System.out.println(b.countSolutions());
    }catch(Exception e){
	    System.out.println("Fail countsolutions size "+size+" board, exception"+e);
    }
  }
}
