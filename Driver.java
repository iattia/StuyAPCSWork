public class Driver{
 public static void main(String[]args){
  //Variables of the test cases are pre-declared.
  //This allows you to copy/paste the entire test case and just change the variables.
  String a;
  String b;
  String whole;
  String part;
  String number;
  
  
  //test cases myCompareTo:
  a="cat";
  b="dog";
  System.out.println("Expected same sign: "+ a.compareTo(b) +" vs my function: "+StringMethods.myCompareTo(a,b)); 
  a="first";
  b="second";
  System.out.println("Expected same sign: "+ a.compareTo(b) +" vs my function: "+StringMethods.myCompareTo(a,b)); 
  a="alphabetical";
  b="zalphabetical";
  System.out.println("Expected same sign: "+ a.compareTo(b) +" vs my function: "+StringMethods.myCompareTo(a,b)); 
  a="prefix";
  b="prefixOf";
  System.out.println("Expected same sign: "+ a.compareTo(b) +" vs my function: "+StringMethods.myCompareTo(a,b)); 
  a="zalphabetical";
  b="alphabetical";
  System.out.println("Expected same sign: "+ a.compareTo(b) +" vs my function: "+StringMethods.myCompareTo(a,b)); 
  a="a";
  b="a";
  System.out.println("Expected same sign: "+ a.compareTo(b) +" vs my function: "+StringMethods.myCompareTo(a,b)); 
  
  //test cases myIndexOf:
  whole = "Hello";
  part = "He";
  System.out.println("Expected "+ whole.indexOf(part) +" vs my function: "+ StringMethods.myIndexOf(whole, part) );
  whole = "SecondTest";
  part = "est"; 
  System.out.println("Expected "+ whole.indexOf(part) +" vs my function: "+ StringMethods.myIndexOf(whole, part) );
  whole = "ThirdTest";
  part = "dT";
  System.out.println("Expected "+ whole.indexOf(part) +" vs my function: "+ StringMethods.myIndexOf(whole, part) );
    
  //Single test case parseInt:
  number = "152";
  int actual = Integer.parseInt(number);
  int guess  = -9999999;//replace with your parse function
  System.out.println("Expected "+ actual +" vs my function: "+ guess+" "+(actual==guess));
 }
}
