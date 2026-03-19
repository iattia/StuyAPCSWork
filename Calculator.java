import java.util.*;

public class Calculator{
      /**Evaluate a postfix expression stored in expression.
      *Assume string contains ints, doubles, and operators.
      *Assume all tokens are separated by a space.
      *Valid operators are + - / * and % (remainder not modulo)
      *All results are doubles even if the operands are both int.
      *@param expression The string representation of a valid postfix expression, formatted
      *                  such that there is a single space separating all operators and operands.
      *@throws IllegalArgumentException when there are too many or too few operands.
      *        Use the string parameter of your exception to indicate what happened.
      *        Either:
      *        "too many operands" when you are left with more than 1 value in the stack at the end,
      *        or
      *        "too few operands for operation _" (replace _ with +,- etc.) when you try to evaluate an operator but there are not enough operands
      */
      public static double eval(String expression){
        return 0.0;
      }

      public static boolean isOperator(String str){
        return str.equals("+") || str.equals("-") || str.equals("/") || str.equals("*") || str.equals("%");
      }
      
      public static double operate(double x, double y, String operator){
        if (operator.equals("+")){
          return y + x;
        }
        if (operator.equals("-")){
          return y - x;
        }
        if (operator.equals("/")){
          return y / x;
        }
        if (operator.equals("*")){
          return y * x;
        }
        if (operator.equals("%")){
          if ((y > 0 && x > 0) || (y < 0 && x < 0)){
            return y % x;
          } else{
            return x - (y % x);
          }
        }
      }
}
