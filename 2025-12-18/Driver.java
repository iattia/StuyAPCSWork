// fib(47) passes 10 seconds;
// fib(47) exceeds max int;
public class Driver{
  public static void main(String[] args){
    System.out.println(Fibonacci.fib(Integer.parseInt(args[0])));
  }
}
