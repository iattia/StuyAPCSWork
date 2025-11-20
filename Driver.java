public class Driver {

  public static void main(String[] args) {
    testNoNullArrayList();
    testOrderedArrayList();
  }

  public static void testNoNullArrayList() {
    System.out.println("--- TESTING NoNullArrayList ---");
    NoNullArrayList<String> nnList = new NoNullArrayList<>();

    // 1. Test add(T value)
    nnList.add("one");
    nnList.add("two");
    System.out.println("List state: " + nnList); // Expected: [one, two]

    // 2. Test add(T value) - (null)
    try {
      nnList.add(null);
      System.out.println("TEST FAILED: add(null) did not throw exception.");
    } catch (IllegalArgumentException e) {
      System.out.println("SUCCESS: Caught expected exception: " + e.getMessage());
    }
    System.out.println("List state: " + nnList); // Expected: [one, two]

    // 3. Test add(int index, T value)
    nnList.add(1, "three");
    System.out.println("List state: " + nnList); // Expected: [one, three, two]

    // 4. Test add(int index, T value) - (null)
    try {
      nnList.add(0, null);
      System.out.println("TEST FAILED: add(0, null) did not throw exception.");
    } catch (IllegalArgumentException e) {
      System.out.println("SUCCESS: Caught expected exception: " + e.getMessage());
    }
    System.out.println("List state: " + nnList); // Expected: [one, three, two]

    // 5. Test set(int index, T value)
    String replaced = nnList.set(0, "ONE");
    System.out.println("Value returned from set: " + replaced); // Expected: one
    System.out.println("List state: " + nnList); // Expected: [ONE, three, two]

    // 6. Test set(int index, T value) - (null)
    try {
      nnList.set(0, null);
      System.out.println("TEST FAILED: set(0, null) did not throw exception.");
    } catch (IllegalArgumentException e) {
      System.out.println("SUCCESS: Caught expected exception: " + e.getMessage());
    }
    System.out.println("List state: " + nnList); // Expected: [ONE, three, two]

    System.out.println("\n--- NoNullArrayList Testing Complete ---");
  }

  public static void testOrderedArrayList() {
    System.out.println("\n\n--- TESTING OrderedArrayList ---");
    OrderedArrayList<String> oList = new OrderedArrayList<>();

    // 1. Test add(T value)
    oList.add("Mango");
    System.out.println("List state: " + oList); // Expected: [Mango]
    oList.add("Apple");
    System.out.println("List state: " + oList); // Expected: [Apple, Mango]
    oList.add("Date");
    System.out.println("List state: " + oList); // Expected: [Apple, Date, Mango]
    oList.add("Plum");
    System.out.println("List state: " + oList); // Expected: [Apple, Date, Mango, Plum]
    oList.add("Cherry");
    System.out.println("List state: " + oList); // Expected: [Apple, Cherry, Date, Mango, Plum]

    // 2. Test add(T value) -  (null)
    try {
      oList.add(null);
      System.out.println("TEST FAILED: add(null) did not throw exception.");
    } catch (IllegalArgumentException e) {
      System.out.println("SUCCESS: Caught expected exception: " + e.getMessage());
    }
    System.out.println("List state: " + oList); // Expected: [Apple, Cherry, Date, Mango, Plum]

    // 3. Test add(int index, T value)
    System.out.println("\nTesting add(int index, T value) [Happy Path - Index Ignored]...");
    System.out.println("Adding \"Banana\" at index 0...");
    oList.add(0, "Banana"); // Index 0 is ignored
    System.out.println("List state: " + oList); // Expected: [Apple, Banana, Cherry, Date, Mango, Plum]

    // 4. Test add(int index, T value) - (null)
    try {
      oList.add(0, null);
      System.out.println("TEST FAILED: add(0, null) did not throw exception.");
    } catch (IllegalArgumentException e) {
      System.out.println("SUCCESS: Caught expected exception: " + e.getMessage());
    }
    System.out.println("List state: " + oList); // Expected: [Apple, Banana, Cherry, Date, Mango, Plum]

    // 5. Test set(int index, T value)
    System.out.println("Calling set(2, \"Avocado\")... (should remove \"Cherry\")");
    String replaced = oList.set(2, "Avocado"); // "Avocado" added, "Cherry" removed
    System.out.println("Value returned from set: " + replaced); // Expected: Cherry
    System.out.println("List state: " + oList); // Expected: [Apple, Avocado, Banana, Date, Mango, Plum]

    // 6. Test set(int index, T value) - (null)
    System.out.println("Calling set(0, null)... (should remove nothing)");
    try {
      oList.set(0, null);
      System.out.println("TEST FAILED: set(0, null) did not throw exception.");
    } catch (IllegalArgumentException e) {
      System.out.println("SUCCESS: Caught expected exception: " + e.getMessage());
    }
    System.out.println("List state: " + oList); // Expected: [Apple, Avocado, Banana, Date, Mango, Plum]

    System.out.println("\n--- OrderedArrayList Testing Complete ---");
  }
}