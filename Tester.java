public class Tester {
    public static boolean isPrime(int x) {
        if (x <= 1) {
            return false;
        }
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static int nthPrime(int n) {
        int count = 0;
        int number = 2;
        while (true) {
            if (isPrime(number)) {
                if (count == n) {
                    return number;
                }
                count++;
            }
            number++;
        }
    }
    public static void main(String[] args) {
        int[] n = {0, 1, 2, 3, 4, 9, 24, 99};
        int[] expectedPrimes = {2, 3, 5, 7, 11, 29, 97, 541};
        System.out.println("\nTesting nthPrime function:");
        for (int i = 0; i < n.length; i++) {
            int result = nthPrime(n[i]);
            if (result == expectedPrimes[i]) {
                System.out.println("Test " + (i + 1) + ": pass");
            } else {
                System.out.println("Test " + (i + 1) + ": fail expected " + expectedPrimes[i] + ", but value returned was " + result);
            }
        }
        System.out.println("\nTesting isPrime function:");
        int[] testNumbers = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 17, 29, 97, 60000049};
        boolean[] expectedResults = {true, true, false, true, false, true, false, false, false, true, true, true, true, true};
        for (int i = 0; i < testNumbers.length; i++) {
            boolean result = isPrime(testNumbers[i]);
            if (result == expectedResults[i]) {
                System.out.println("Test " + (i + 1) + ": pass");
            } else {
                System.out.println("Test " + (i + 1) + ": fail expected " + expectedResults[i] + ", but value returned was " + result);
            }
        }
    }
}