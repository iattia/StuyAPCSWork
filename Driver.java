import java.util.*;
import java.io.*;
public class Driver{
  public static void main(String[]args) throws Exception{
      if(args.length < 2){
       System.out.println("Syntax:  java Driver TEST_NUMBER PROBLEM\n where PROBLEM= bronze/silver");
       System.out.println("Input files are ctravel.X.in/makelake.X.in, where x are integers");
       System.out.println("Output files are ctravel.X.out/makelake.X.out, where x are integers that match the output file.");
       System.exit(0); 
      }
      String number = args[0];
      String type = args[1];

      if(type.equals("bronze")){
        String file = "makelake."+number;
        long guess = USACO.bronze(file+".in");
        long ans = new Scanner(new File(file+".out")).nextLong();
        if(guess == ans ){
          System.out.println("PASS case: "+file+".in");
        }else{
          System.out.println("FAIL case: "+file+".in does not match output expected "+ ans+", your result is: "+guess);
        }
      }   
      if(type.equals("silver")){
        String file = "ctravel."+number;
        long ans = new Scanner(new File(file+".out")).nextLong();
        long guess = USACO.silver(file+".in");
        if( guess == ans ){
          System.out.println("PASS case: "+file+".in");
        }else{
          System.out.println("FAIL case: "+file+".in does not match output expected "+ ans+", your result is: "+guess);
        }
      }
    
    }
  }
