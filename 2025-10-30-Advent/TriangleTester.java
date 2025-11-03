import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TriangleTester {

  public static int countTrianglesA(String filename) {
    int numValid = 0;
    try {
      File file = new File(filename);
      Scanner input = new Scanner(file);
      while (input.hasNextLine()) {
        if (input.hasNextInt()) {
            int side1 = input.nextInt();
            int side2 = input.nextInt();
            int side3 = input.nextInt();
            
            if (side1 + side2 > side3 && side2 + side3 > side1 && side1 + side3 > side2) {
              numValid++;
            }
        } else {
            input.nextLine();
        }
      }
      input.close();
    } catch (FileNotFoundException ex) {
      System.out.println("File not found");
    }
    return numValid;
  }

  public static int countTrianglesB(String filename) {
    int numValid = 0;
    try {
      File file = new File(filename);
      Scanner input = new Scanner(file);
      while (input.hasNextInt()) {
        int r1c1 = input.nextInt();
        int r1c2 = input.nextInt();
        int r1c3 = input.nextInt();

        int r2c1 = input.nextInt();
        int r2c2 = input.nextInt();
        int r2c3 = input.nextInt();

        int r3c1 = input.nextInt();
        int r3c2 = input.nextInt();
        int r3c3 = input.nextInt();

        if (r1c1 + r2c1 > r3c1 && r2c1 + r3c1 > r1c1 && r1c1 + r3c1 > r2c1) {
          numValid++;
        }
        if (r1c2 + r2c2 > r3c2 && r2c2 + r3c2 > r1c2 && r1c2 + r3c2 > r2c2) {
          numValid++;
        }
        if (r1c3 + r2c3 > r3c3 && r2c3 + r3c3 > r1c3 && r1c3 + r3c3 > r2c3) {
          numValid++;
        }
      }
      input.close();

    } catch (FileNotFoundException ex) {
      System.out.println("File not found");
    }
    return numValid;
  }

  public static void main(String[] args) {
    String filename = "inputTri.txt";

    int validTrianglesA = countTrianglesA(filename);
    System.out.println(validTrianglesA);

    int validTrianglesB = countTrianglesB(filename);
    System.out.println(validTrianglesB);
  }
}