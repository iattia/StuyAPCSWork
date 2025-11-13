import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class p1{
  public static void main(String[] args){
    System.out.println("The answer is " + sumValid);
  }

  public static int sumValid(){
    try{
      File file = new File("input.txt");
      Scanner input = new Scanner(file);
      while (input.hasNextLine()){
        String currentLine = input.nextLine();
        int lastDashIndex = currentLine.lastIndexOf("-"));
        String room = currentLine.substring(0,lastDashIndex);
        room = room.replace("-","");
        }
      }
    }
  }
}
