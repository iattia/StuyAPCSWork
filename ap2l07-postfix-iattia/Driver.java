public class Driver{
  public static void main(String[] args){
    System.out.println(Calculator.eval("11 3 - 4 + 2.5 *"));
    System.out.println(Calculator.eval("10 2.0 +"));
    System.out.println(Calculator.eval("8 2 + 99 9 - * 2 + 9 -"));
    System.out.println(Calculator.eval("1 2 3 4 5 + * - -"));
    System.out.println(Calculator.eval("15.6 3.7 5.9 7.1 18.7 - + - +"));
    System.out.println(Calculator.eval("25"));
    System.out.println(Calculator.eval("32.0 20.0 18 % 8 * /"));
    //System.out.println(Calculator.eval(""));
    //System.out.println(Calculator.eval("1 1 1 +"));
    //System.out.println(Calculator.eval("1 1 1 - * +"));
    System.out.println(Calculator.eval("4.3 5.5 11.5 11.8 - 11.8 * + - 12.3 2.2 * + 2.7 / 15.5 5.2 - 10.8 10.7 + 8.8 14.4 / / 1.9 + 7.6 - 18.6 8.2 14.6 / 16.5 + - 15.8 * / 19.9 * / + 16.2 9.7 12.0 + + 19.8 8.3 + + 2.9 1.8 + 4.6 + 15.9 * 9.1 * / 9.4 4.3 * 9.6 15.2 - + 6.6 14.1 / + 13.8 * * 3.8 17.9 8.8 * 12.6 - 12.5 + - 5.5 / + 16.8 1.4 0.4 + - 10.7 + 5.4 8.2 7.9 - / / 2.8 18.7 / * 3.5 2.8 * / - *"));
    System.out.println(Calculator.eval(Generator.expression(1.0)));
  }
}
