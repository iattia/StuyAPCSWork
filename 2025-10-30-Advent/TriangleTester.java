import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TriangleTester{
  public static void main(String[] args){
    try {
      int numValid = 0;
      File file = new File("inputTri.txt");//1
      Scanner input = new Scanner(file);
      while (input.hasNextLine()){
        Scanner currentLine = new Scanner(input.nextLine());
        int side1 = currentLine.nextInt();
        int side2 = currentLine.nextInt();
        int side3 = currentLine.nextInt();
        if (side1 + side2 > side3 && side2 + side3 > side1 && side1 + side3 > side2){
          numValid++;
        }
        currentLine.close();
      }
      System.out.println(numValid);
      //CODE THAT SCANS THE FILE.
      input.close();//releases the file from your program
    } catch (FileNotFoundException ex) {
      //File not found what should you do?
      System.out.println("File not found");
      return; //you can return from a main or any void function
              //just don't put a value.
    }
  }
}
