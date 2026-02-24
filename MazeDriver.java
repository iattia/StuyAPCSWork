import java.io.FileNotFoundException;
public class MazeDriver{
  public static void main(String[]args){
    if(args.length > 0){
      String command = args[0];
      String filename = "maze1";
      Maze f;
      if(command.equals("solve")){
        if(args.length>1){
          filename = args[1];
        }
        try{
          f = new Maze(filename);
          f.setAnimate(true);
          int solutions = f.solve();
          System.out.println(f);
          System.out.println("Solved in "+solutions+" steps");
        }catch(FileNotFoundException e){
          System.out.println("Invalid filename: "+filename);
        }
        return;
      }else if(command.equals("generate")){
        int rows = 10;
        int cols = 10;
        if(args.length > 2){
          rows = Integer.parseInt(args[1]);
          cols = Integer.parseInt(args[2]);
        }
        f = new Maze(rows,cols);
        f.setAnimate(true);
        int solutions = f.solve();
        System.out.println(f);
        System.out.println("Solved in "+solutions+" steps");
        return;
      }
      System.out.println("Invalid command.");
    }
    System.out.println("Usage:");
    System.out.println("java Driver solve FILENAME");
    //[rows cols] are optional
    System.out.println("java Driver generate [rows cols]");

  }
}
