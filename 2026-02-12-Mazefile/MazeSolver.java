import java.io.*;
import java.util.*;

public class MazeSolver{
  public static char[][] maze(String filename) throws FileNotFoundException{
    String mazeString = "";
    Scanner sc = new Scanner(new File(filename));
    while (sc.hasNextLine()){
      String currentLine = sc.nextLine();
      if (!currentLine.isEmpty()){
        mazeString += currentLine;
      }
    }
    String[] arrString = mazeString.split("\n");
    int rows = arrString.length;
    int cols = arrString[0].length();
    char[][] mazeChar = new char[rows][cols];
    for (int r = 0; r < rows; r++){
      for (int c = 0; c < cols; c++){
        mazeChar[r][c] = arrString[r].charAt(c);
      }
    }
    return mazeChar;
  }
  public static void main(String[] args){
    try{
      char[][] arr = maze("Maze1.txt");
      for (int i = 0; i < arr.length; i++){
        System.out.println(Arrays.toString(arr[i]));
      }
    } catch (FileNotFoundException e){
      System.out.println("File not found");
    }
  }
}
