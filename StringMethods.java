public class StringMethods{

  //return the index of s that contains the first occurence of target, 
  //or -1 if it is not present. 
  //precondition s and target both have length > 0
  //Do not use indexOf() or similar.
  public static int myIndexOf(String s, String target){
    for (int i=0;i<=s.length()-target.length();i++){
      if (s.substring(i,i+target.length()).equals(target)){
        return i;
      }
    }
    return -1;
  }
  
  //return 0 if the strings are equal
  //return a positive number if other is less than s
  //return a negative number if other is greater than s
  //Do not use compareTo()  or similar.
  public static int myCompareTo(String s, String other){
    int minLength = Math.min(s.length(),other.length());
    for (int i=0; i<minLength;i++){
      if (s.charAt(i) != other.charAt(i)){
        return s.charAt(i) - other.charAt(i);
      }
    }
    return s.length()-other.length();
  }

  //return the integer value of the String.
  //precondition: s is formatted as a valid integer.
  //Do not use Integer.parseInt() or similar.
  public static int parseInt(String s){
    return 0;
  }
}
