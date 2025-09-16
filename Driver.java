public class Driver{
 public static void main(String[]args){
   /**
   *Examples how to call a method from a different java file:
   */
   //you can store it in a variable
   int x = Functions.test(1);
   //you can print it (but I won't here)
   //System.out.println(Functions.test(2));
  
   //print it with context! This is better than printing numbers to the terminal!
   //e.g.
   //System.out.println("test(test(4)) =" + Functions.test(Functions.test(4)));
  
  
   /*
   *You must write several test cases for this problem:
   *The tests should print the intended output in addition to the actual output.
   *You should also replace the placeholder text with an actual function call.
   */
   System.out.println("makeBricks(1,1,2) expected false result: " + Functions.makeBricks(1,1,2));
   System.out.println("makeBricks(1,1,6) expected true  result: " + Functions.makeBricks(1, 1, 6));
   System.out.println("makeBricks(3,1,9) expected false  result: " + Functions.makeBricks(3, 1, 9));
   System.out.println("makeBricks(3,2,10) expected true  result: " + Functions.makeBricks(3, 2, 10));
   System.out.println("makeBricks(3,2,8) expected true  result: " + Functions.makeBricks(3, 2, 8));
   System.out.println("makeBricks(3,2,9) expected false  result: " + Functions.makeBricks(3, 2, 9));
   System.out.println("makeBricks(7,1,13) expected false  result: " + Functions.makeBricks(7, 1, 13));
   System.out.println("makeBricks(43,1,46) expected true  result: " + Functions.makeBricks(43, 1, 46));
 }
}
