public class Generator{
  private static String[] operators = new String[]{"+", "-", "*", "/", "%"};
  public static void main(String[] args){
    double probability = 1.0;
    String expression = expression(probability);
    System.out.println(expression);
  }
  public static String expression(double probability){
    String expression = "";
    if (Math.random() < probability){
      expression += expression(probability - 0.1) + " " + expression(probability - 0.1) + " " + operators[(int) (Math.random()*5)];
    } else{
      double number = Math.random()*100;
      expression += String.format("%.2f", number);
    }
    return expression;
  }
}
