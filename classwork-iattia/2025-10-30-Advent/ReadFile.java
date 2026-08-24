import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {

  public static void main(String[] args) {
    //2 Opening a file requires a try/catch
    try {
      File file = new File("ReadFile.java");//1
      Scanner input = new Scanner(file);
      String linee;
      while(input.hasNextLine()) {
        linee = input.nextLine();
        if (linee.contains("{")) System.out.println(linee);
        }
      input.close();//releases the file from your program

    } catch (FileNotFoundException ex) {
      //File not found what should you do?
      System.out.println("File not found");
      return; //you can return from a main or any void function
              //just don't put a value.
    }
    Scanner sc1 = new Scanner("This is a bunch of words");
    while (sc1.hasNext()){
      System.out.println(sc1.next());
    }
    double sum = 0;
    Scanner sc2 = new Scanner("10.0 1.04 99.0 -3.0 4.2");
    while (sc2.hasNext()){
      sum += sc2.nextDouble();
    }
    System.out.println(sum);
  }
}
