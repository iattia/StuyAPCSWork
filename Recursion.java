public class Recursion{


  /*Print all words that are made of the characters in the array of letters.
    *There may not be consecutive equal letters, so:
    *aax is not allowed, but axa is allowed.
    *@param length : the length of the words that are to be printed
    *@param alphabet: the letters you should be using,
    *@precondition: alphabet contains at least 2 characters, and has no duplicates.
    */
    public static void printNoDoubleLetterWords(int length,String alphabet){
      //This is the wrapper method
      //do not change this method
      printNoDoubleLetterWords(length,"",alphabet);
    }

    /*Print all words that are made of the characters in letters. There may not be consecutive equal letters,
    *aax is not allowed, but axa is allowed.
    *@param length : either how many more letters need to be
    *@param word   : the partial word so far.
    *@param alphabet: the letters you should be using
    */
    private static void printNoDoubleLetterWords(int length,String word, String alphabet){
      if (length == 0){
        System.out.println(word);
        return;
      } else{
        for (int i=0; i<alphabet.length(); i++){
          if (word.length() == 0 || word.charAt(word.length()-1) != alphabet.charAt(i)){
            printNoDoubleLetterWords(length - 1, word+alphabet.charAt(i), alphabet);
          }
        }
      }
    }

    /*Convert the integer to a String containing English words that are used to say the number.
    * precondition: n > Integer.MIN_VALUE   && n <= Integer.MAX_VALUE
    * it is noteworthy that Integer.MIN_VALUE will not be tested.
    * toWords(0) returns "zero"
    * toWords(340) returns "three hundred and forty"
    * toWords(1000430) returns: "one million four hundred and thirty"
    * toWords(-2101000442) returns: "negative two billion one hundred and one million four hundred and forty-two"
    */
    public static String toWords(int n){
      //THIS SHOULD BE A WRAPPER METHOD
      //call toWordsRec
      //Write this method, and the recursive method it calls.
      if (n==0){
        return "zero";
      }
      if (n<0){
        return "negative" + toWordsRec(n, 0, "");
      }
      return toWordsRec(n,0,"");
    }

    private static String toWordsRec(int n, int place, String word){
      String[] ones = new String{"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
      String[] specials = new String{"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
      String[] tens = new String{"", "ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};
      String[] places = new String{"", "thousand", "million", "billion"};
      if (n==0){
        return word;
      }else{
        int hundreds = n%1000/100;
        int tens = n%100/10;
        int ones = n%10;
        if (hundreds > 0){
          word += ones[hundreds] + " hundred ";
          if (tens > 0){
            word += "and ";
          }
        )
        if (tens > 2){
          word += tens[tens];
          if (ones > 0){
            word += 
          }
        }
    }
}
