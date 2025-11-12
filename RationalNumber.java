public class RationalNumber extends RealNumber
{
  //Hint: ONLY touch instance variables directly in your accessor methods/constructor.
  private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *  When the denominator is negative, negate both numerator and denominator.
  *  This handles all cases including if both are negative.
  *  When the denominator parameter is 0, make the fraction 0/1 regardless of the
  *  numerator. This is not mathematically correct, but we can decide on the behavior to
  *  avoid issues.
  *******************************************************
  *  All RationalNumbers must automatically reduce() upon construction.
  *******************************************************
  *@param nume the numerator
  *@param deno the denominator
  */
  public RationalNumber(int nume, int deno){
    super(0.0);//this value is ignored!
    if (deno == 0){
      numerator = 0;
      denominator = 1;
    } else if (deno < 0){
      numerator = -nume;
      denominator = -deno;
    } else{
      denominator = deno;
      numerator = nume;
    }

    if (numerator == 0 && denominator != 0){
      denominator = 1;
    }
    reduce();
  }

  /**
  *@return the numerator
  */
  public int getNumerator(){
    return numerator;
  }
  /**
  *@return the denominator
  */
  public int getDenominator(){
    return denominator;
  }


  //NOTE! For two reasons, the @Override annotation is useful.
  //1. If the annotated method does not actually override anything, the compiler issues a warning.
  //2. It can help to make the source code more readable.
  @Override
  public double getValue(){
    //COMPLETE THIS METHOD
    return (double) getNumerator()/getDenominator();
  }

  /**
  *@return a new RationalNumber that has the same numerator
  *and denominator as this RationalNumber but reversed.
  */
  public RationalNumber reciprocal(){
    //COMPLETE THIS METHOD
    RationalNumber rec = new RationalNumber(getDenominator(), getNumerator());
    return rec;
  }

  /**
  *@return true if and only if the RationalNumbers are both 0,
  *        or they have the same numerators and denominators,
  *return false otherwise.
  *note, this is NOT an override. If you use equals on a RealNumber
  *      that is the other method.
  */
public boolean equals(RationalNumber other){
    //COMPLETE THIS METHOD
    return (this.getNumerator() == other.getNumerator() && this.getDenominator() == other.getDenominator());
  }

  /**
  *@return the value expressed as "3/4" or "8/3",
  *however 4/1 should be "4", and 0/1 should be 0.
  */
  @Override
  public String toString(){
    //COMPLETE THIS METHOD
    if (getNumerator() == 0){
      return "0";
    }
    if (getDenominator() == 1){
      return "" + getNumerator();
    }
    return getNumerator() + "/" + getDenominator();
  }
  /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */
  public static int gcd(int a, int b){
    /*COMPLETE THIS METHOD
    Easy: You can just loop over all the values and return the largest.
    *Clever: use euclids method if you want to be efficient
    * http://sites.math.rutgers.edu/~greenfie/gs2004/euclid.html
    */
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }

  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced upon construction.
  */
  public void reduce(){
    if (getNumerator() != 0){
      int gcdNumDen = gcd(numerator, denominator);
      numerator/=gcdNumDen;
      denominator/=gcdNumDen;
    }
  }

  /******************new math operations Return a new RationalNumber!!!!****************/
  //Note: RealNumber methods are inherited, these are NOT override, they are different methods.

  /**
  *@return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other){
    //COMPLETE THIS METHOD
    int newNume = this.getNumerator() * other.getNumerator();
    int newDen = this.getDenominator() * other.getDenominator();
    return new RationalNumber(newNume, newDen);
  }

  /**
  *@return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other){
    //COMPLETE THIS METHOD
    return this.multiply(other.reciprocal());
  }

  /**
  *@return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other){
    //COMPLETE THIS METHOD
    int newNume = (this.getNumerator() * other.getDenominator() + other.getDenominator()*this.getDenominator());
    int newDen = this.getDenominator() * other.getDenominator();
    return new RationalNumber(newNume, newDen);
  }
  /**
  *@return a new RationalNumber that this minus the other
  */
  public RationalNumber subtract(RationalNumber other){
    //COMPLETE THIS METHOD
    int newNume = (this.getNumerator()*other.getDenominator() - other.getNumerator()*this.getDenominator());
    int newDen = this.getDenominator() * other.getDenominator();
    return new RationalNumber(newNume, newDen);
  }
}
