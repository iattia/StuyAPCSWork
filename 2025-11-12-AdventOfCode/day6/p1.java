import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class p1{
  public static void main(String[] args){
    System.out.println("The answer is " + findFreqSingle()[0]);
  }
  public static int[] findFreqSingle(){
    int[] freq = new int[26];
    try{
      File file = new File("input.txt");
      Scanner input = new Scanner(file);
      while (input.hasNextLine()){
        String currentLine = input.nextLine();
        for (int i=0; i<1;i++){
          freq[currentLine.charAt(i)-'a']++;
        }
      }
      return freq;
    } catch (FileNotFoundException e){
      System.out.println("input.txt not found");
      return freq;
    }
  }
  public static String findMessage(){
    for (int i=0; i<)

  }
}
