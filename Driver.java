public class Driver {

    public static void main(String[] args) {
        System.out.println("--- Testing RealNumber ---");
        testRealNumber();
        
        System.out.println("\n--- Testing RationalNumber (Construction) ---");
        testRationalConstruction();
        
        System.out.println("\n--- Testing RationalNumber (Methods) ---");
        testRationalMethods();
        
        System.out.println("\n--- Testing RationalNumber (Math) ---");
        testRationalMath();
        
        System.out.println("\n--- Testing Polymorphism (Real/Rational Interaction) ---");
        testPolymorphism();
    }

    public static void testRealNumber() {
        RealNumber r1 = new RealNumber(10.5);
        RealNumber r2 = new RealNumber(10.5);
        RealNumber r3 = new RealNumber(-5.0);
        RealNumber r4 = new RealNumber(20.0);

        System.out.println("r1.getValue() | Expected: 10.5 | Actual: " + r1.getValue());
        System.out.println("r1.toString() | Expected: 10.5 | Actual: " + r1.toString());

        System.out.println("\n--- RealNumber compareTo (using your logic) ---");
        System.out.println("r1.compareTo(r2) (10.5 vs 10.5) | Expected: 0 | Actual: " + r1.compareTo(r2));
        System.out.println("r1.compareTo(r3) (10.5 vs -5.0) | Expected: 1 (or >1) | Actual: " + r1.compareTo(r3));
        System.out.println("r3.compareTo(r1) (-5.0 vs 10.5) | Expected: -1 (or <-1) | Actual: " + r3.compareTo(r1));
        System.out.println("r1.compareTo(new RealNumber(10.2)) | Expected: 1 | Actual: " + r1.compareTo(new RealNumber(10.2)));
        
        System.out.println("\n--- RealNumber equals ---");
        System.out.println("r1.equals(r2) (10.5 vs 10.5) | Expected: true | Actual: " + r1.equals(r2));
        System.out.println("r1.equals(r3) (10.5 vs -5.0) | Expected: false | Actual: " + r1.equals(r3));
        
        System.out.println("\n--- RealNumber Math (using double) ---");
        System.out.println("r1.add(r3) (10.5 + -5.0) | Expected: 5.5 | Actual: " + r1.add(r3));
        System.out.println("r1.subtract(r3) (10.5 - -5.0) | Expected: 15.5 | Actual: " + r1.subtract(r3));
        System.out.println("r3.multiply(r4) (-5.0 * 20.0) | Expected: -100.0 | Actual: " + r3.multiply(r4));
        System.out.println("r4.divide(r3) (20.0 / -5.0) | Expected: -4.0 | Actual: " + r4.divide(r3));
    }
    
    public static void testRationalConstruction() {
        RationalNumber r1 = new RationalNumber(1, 2);
        System.out.println("Standard (1, 2) | Expected: 1/2 | Actual: " + r1);
        
        RationalNumber r2 = new RationalNumber(4, 8);
        System.out.println("Reduced (4, 8) | Expected: 1/2 | Actual: " + r2);
        
        RationalNumber r3 = new RationalNumber(1, -2);
        System.out.println("Negative Denom (1, -2) | Expected: -1/2 | Actual: " + r3);
        
        RationalNumber r4 = new RationalNumber(-1, -2);
        System.out.println("Both Negative (-1, -2) | Expected: 1/2 | Actual: " + r4);
        
        RationalNumber r5 = new RationalNumber(0, 5);
        System.out.println("Zero Numerator (0, 5) | Expected: 0 | Actual: " + r5);
        
        RationalNumber r6 = new RationalNumber(5, 0);
        System.out.println("Zero Denominator (5, 0) | Expected: 0 | Actual: " + r6);
        
        RationalNumber r7 = new RationalNumber(5, 1);
        System.out.println("Integer (5, 1) | Expected: 5 | Actual: " + r7);
        
        RationalNumber r8 = new RationalNumber(10, 5);
        System.out.println("Reduced Integer (10, 5) | Expected: 2 | Actual: " + r8);

        RationalNumber r9 = new RationalNumber(0, 0);
        System.out.println("Zero/Zero (0, 0) | Expected: 0 | Actual: " + r9);
    }
    
    public static void testRationalMethods() {
        RationalNumber r1 = new RationalNumber(1, 2);
        RationalNumber r2 = new RationalNumber(4, 8);
        RationalNumber r3 = new RationalNumber(-2, 3);
        
        System.out.println("--- Getters (Post-Reduction) ---");
        System.out.println("r3.getNumerator() (-2, 3) | Expected: -2 | Actual: " + r3.getNumerator());
        System.out.println("r3.getDenominator() (-2, 3) | Expected: 3 | Actual: " + r3.getDenominator());
        System.out.println("r2.getNumerator() (4, 8) | Expected: 1 | Actual: " + r2.getNumerator());
        System.out.println("r2.getDenominator() (4, 8) | Expected: 2 | Actual: " + r2.getDenominator());
        
        System.out.println("\n--- getValue (double) ---");
        System.out.println("r1.getValue() (1/2) | Expected: 0.5 | Actual: " + r1.getValue());
        System.out.println("r3.getValue() (-2/3) | Expected: -0.666... | Actual: " + r3.getValue());
        
        System.out.println("\n--- equals (RationalNumber) ---");
        System.out.println("r1.equals(r2) (1/2 vs 4/8) | Expected: true | Actual: " + r1.equals(r2));
        System.out.println("r1.equals(r3) (1/2 vs -2/3) | Expected: false | Actual: " + r1.equals(r3));

        System.out.println("\n--- reciprocal ---");
        System.out.println("r1.reciprocal() (1/2) | Expected: 2 | Actual: " + r1.reciprocal());
        System.out.println("r3.reciprocal() (-2/3) | Expected: -3/2 | Actual: " + r3.reciprocal());
        RationalNumber r_zero = new RationalNumber(0, 1);
        System.out.println("r_zero.reciprocal() (0/1) | Expected: 0 | Actual: " + r_zero.reciprocal());
    }
    
    public static void testRationalMath() {
        RationalNumber r1 = new RationalNumber(1, 2); // 1/2
        RationalNumber r2 = new RationalNumber(1, 4); // 1/4
        RationalNumber r3 = new RationalNumber(-2, 3); // -2/3
        
        System.out.println("r1: " + r1 + " | r2: " + r2 + " | r3: " + r3);
        
        System.out.println("\n--- Add ---");
        // 1/2 + 1/4 = 2/4 + 1/4 = 3/4
        System.out.println("r1.add(r2) (1/2 + 1/4) | Expected: 3/4 | Actual: " + r1.add(r2));
        // 1/2 + (-2/3) = 3/6 - 4/6 = -1/6
        System.out.println("r1.add(r3) (1/2 + -2/3) | Expected: -1/6 | Actual: " + r1.add(r3));

        System.out.println("\n--- Subtract ---");
        // 1/2 - 1/4 = 2/4 - 1/4 = 1/4
        System.out.println("r1.subtract(r2) (1/2 - 1/4) | Expected: 1/4 | Actual: " + r1.subtract(r2));
        // 1/4 - 1/2 = 1/4 - 2/4 = -1/4
        System.out.println("r2.subtract(r1) (1/4 - 1/2) | Expected: -1/4 | Actual: " + r2.subtract(r1));

        System.out.println("\n--- Multiply ---");
        // (1/2) * (1/4) = 1/8
        System.out.println("r1.multiply(r2) (1/2 * 1/4) | Expected: 1/8 | Actual: " + r1.multiply(r2));
        // (1/2) * (-2/3) = -2/6 = -1/3
        System.out.println("r1.multiply(r3) (1/2 * -2/3) | Expected: -1/3 | Actual: " + r1.multiply(r3));
        
        System.out.println("\n--- Divide ---");
        // (1/2) / (1/4) = 1/2 * 4/1 = 4/2 = 2
        System.out.println("r1.divide(r2) (1/2 / 1/4) | Expected: 2 | Actual: " + r1.divide(r2));
        // (-2/3) / (1/2) = -2/3 * 2/1 = -4/3
        System.out.println("r3.divide(r1) (-2/3 / 1/2) | Expected: -4/3 | Actual: " + r3.divide(r1));
    }
    
    public static void testPolymorphism() {
        RealNumber r_real = new RealNumber(0.5);
        RationalNumber r_rational = new RationalNumber(1, 2);
        RealNumber r_poly = new RationalNumber(3, 4); // Stored as RealNumber
        
        System.out.println("Real(0.5) | Rational(1/2) | Poly(3/4)");

        System.out.println("\n--- RealNumber.equals(RealNumber) ---");
        // This calls RealNumber.equals(), which calls getValue() on both.
        // r_rational.getValue() is 0.5
        System.out.println("r_real.equals(r_rational) | Expected: true | Actual: " + r_real.equals(r_rational));
        // r_poly.getValue() is 0.75
        System.out.println("r_real.equals(r_poly) | Expected: false | Actual: " + r_real.equals(r_poly));
        
        System.out.println("\n--- RealNumber.compareTo(RealNumber) ---");
        System.out.println("r_real.compareTo(r_rational) | Expected: 0 | Actual: " + r_real.compareTo(r_rational));
        System.out.println("r_real.compareTo(r_poly) | Expected: -1 | Actual: " + r_real.compareTo(r_poly));
        System.out.println("r_poly.compareTo(r_real) | Expected: 1 | Actual: " + r_poly.compareTo(r_real));

        System.out.println("\n--- RealNumber.add(RealNumber) ---");
        // These all use the double-based math from RealNumber
        // 0.5 + 0.5 = 1.0
        System.out.println("r_real.add(r_rational) | Expected: 1.0 | Actual: " + r_real.add(r_rational));
        // 0.5 + 0.75 = 1.25
        System.out.println("r_real.add(r_poly) | Expected: 1.25 | Actual: " + r_real.add(r_poly));

        System.out.println("\n--- Polymorphic method calls ---");
        // getValue() is @Override, so the RationalNumber version is used.
        System.out.println("r_poly.getValue() | Expected: 0.75 | Actual: " + r_poly.getValue());
        // toString() is @Override, so the RationalNumber version is used.
        System.out.println("r_poly.toString() | Expected: 3/4 | Actual: " + r_poly.toString());
    }
}