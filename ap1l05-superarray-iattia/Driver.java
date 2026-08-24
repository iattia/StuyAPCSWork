public class Driver {
  public static void main(String[] args) {

    int testNum = 1;
    String testName = "";
    boolean pass = true;

    System.out.println("--- Running SuperArray Tests ---");

    // ----- PHASE 1-3 TESTS (Good values) -----

    /**************************************************
     * TEST CASE 1
     */
    testName = "1. No-arg Constructor & size()";
    pass = true;
    try {
      SuperArray list1 = new SuperArray();
      if (!list1.toString().equals("[]")) {
        pass = false;
        System.out.println("   FAIL: toString() should be '[]', got: " + list1.toString());
      }
      if (list1.size() != 0) {
        pass = false;
        System.out.println("   FAIL: size() should be 0, got: " + list1.size());
      }

      if (pass) {
        System.out.println(testNum + ". PASS " + testName);
      } else {
        System.out.println(testNum + ". FAIL " + testName);
      }
    } catch (Exception e) {
      System.out.println(testNum + ". Exception " + testName);
      e.printStackTrace();
    }

    /**************************************************
     * TEST CASE 2
     */
    testNum++;
    testName = "2. add(String) and toString() (no resize)";
    pass = true;
    try {
      SuperArray list2 = new SuperArray();
      list2.add("A");
      list2.add("B");
      list2.add("C");

      if (list2.size() != 3) {
        pass = false;
        System.out.println("   FAIL: size() should be 3, got: " + list2.size());
      }
      if (!list2.toString().equals("[A, B, C]")) {
        pass = false;
        System.out.println("   FAIL: toString() should be '[A, B, C]', got: " + list2.toString());
      }

      if (pass) {
        System.out.println(testNum + ". PASS " + testName);
      } else {
        System.out.println(testNum + ". FAIL " + testName);
      }
    } catch (Exception e) {
      System.out.println(testNum + ". Exception " + testName);
      e.printStackTrace();
    }

    /**************************************************
     * TEST CASE 3
     */
    testNum++;
    testName = "3. SuperArray(int initialCapacity)";
    pass = true;
    try {
      SuperArray list3 = new SuperArray(5); // Should not resize yet
      list3.add("a");
      list3.add("b");
      if (list3.size() != 2 || !list3.toString().equals("[a, b]")) {
        pass = false;
      }

      if (pass) {
        System.out.println(testNum + ". PASS " + testName);
      } else {
        System.out.println(testNum + ". FAIL " + testName);
      }
    } catch (Exception e) {
      System.out.println(testNum + ". Exception " + testName);
      e.printStackTrace();
    }

    /**************************************************
     * TEST CASE 4
     */
    testNum++;
    testName = "4. add(String) - causing ONE resize";
    pass = true;
    try {
      SuperArray list4 = new SuperArray(3); // Start with capacity 3
      for (int i = 0; i < 3; i++) list4.add(""+i); // Fills to [0, 1, 2]
      
      list4.add("3"); // Should trigger resize (new cap = 2*3+1 = 7)
      list4.add("4");
      
      if (list4.size() != 5) {
        pass = false;
        System.out.println("   FAIL: size() should be 5, got: " + list4.size());
      }
      if (!list4.toString().equals("[0, 1, 2, 3, 4]")) {
        pass = false;
        System.out.println("   FAIL: toString() mismatch after resize");
      }

      if (pass) {
        System.out.println(testNum + ". PASS " + testName);
      } else {
        System.out.println(testNum + ". FAIL " + testName);
      }
    } catch (Exception e) {
      System.out.println(testNum + ". Exception " + testName);
      e.printStackTrace();
    }
    
    /**************************************************
     * TEST CASE 5
     */
    testNum++;
    testName = "5. add(String) - causing TWO resizes";
    pass = true;
    try {
      SuperArray list5 = new SuperArray(2); // Start with capacity 2
      list5.add("a");
      list5.add("b"); // Full (cap 2)
      
      list5.add("c"); // Triggers Resize 1 (new cap 2*2+1 = 5)
      list5.add("d");
      list5.add("e"); // Full (cap 5)

      list5.add("f"); // Triggers Resize 2 (new cap 2*5+1 = 11)
      list5.add("g");

      if (list5.size() != 7) {
        pass = false;
        System.out.println("   FAIL: size() should be 7, got: " + list5.size());
      }
      if (!list5.toString().equals("[a, b, c, d, e, f, g]")) {
        pass = false;
        System.out.println("   FAIL: toString() mismatch after 2nd resize");
      }

      if (pass) {
        System.out.println(testNum + ". PASS " + testName);
      } else {
        System.out.println(testNum + ". FAIL " + testName);
      }
    } catch (Exception e) {
      System.out.println(testNum + ". Exception " + testName);
      e.printStackTrace();
    }

    /**************************************************
     * TEST CASE 6
     */
    testNum++;
    testName = "6. get() and set()";
    pass = true;
    try {
      SuperArray list6 = new SuperArray();
      list6.add("A"); list6.add("B"); list6.add("C");
      
      if (!list6.get(0).equals("A") || !list6.get(2).equals("C")) {
        pass = false;
        System.out.println("   FAIL: get() returned wrong value");
      }
      
      String old = list6.set(1, "Z"); // Replace "B" with "Z"
      
      if (!old.equals("B")) {
        pass = false;
        System.out.println("   FAIL: set() did not return replaced value 'B', got: " + old);
      }
      if (!list6.get(1).equals("Z")) {
        pass = false;
        System.out.println("   FAIL: get() after set() returned wrong value");
      }
      if (list6.size() != 3 || !list6.toString().equals("[A, Z, C]")) {
        pass = false;
        System.out.println("   FAIL: list is incorrect after set()");
      }

      if (pass) {
        System.out.println(testNum + ". PASS " + testName);
      } else {
        System.out.println(testNum + ". FAIL " + testName);
      }
    } catch (Exception e) {
      System.out.println(testNum + ". Exception " + testName);
      e.printStackTrace();
    }
    
    // ----- PHASE 4 TESTS (Good values) -----

    /**************************************************
     * TEST CASE 7
     */
    testNum++;
    testName = "7. add(int, String) - start, middle, end";
    pass = true;
    try {
      SuperArray list7 = new SuperArray();
      list7.add("B");
      list7.add("D"); // [B, D]
      
      list7.add(0, "A"); // Add to start: [A, B, D]
      if (list7.size() != 3 || !list7.toString().equals("[A, B, D]")) {
        pass = false;
        System.out.println("   FAIL: add(0, ...) failed");
      }
      
      list7.add(2, "C"); // Add to middle: [A, B, C, D]
      if (list7.size() != 4 || !list7.toString().equals("[A, B, C, D]")) {
        pass = false;
        System.out.println("   FAIL: add(2, ...) failed");
      }
      
      list7.add(4, "E"); // Add to end (index == size): [A, B, C, D, E]
      if (list7.size() != 5 || !list7.toString().equals("[A, B, C, D, E]")) {
        pass = false;
        System.out.println("   FAIL: add(size, ...) failed");
      }

      if (pass) {
        System.out.println(testNum + ". PASS " + testName);
      } else {
        System.out.println(testNum + ". FAIL " + testName);
      }
    } catch (Exception e) {
      System.out.println(testNum + ". Exception " + testName);
      e.printStackTrace();
    }
    
    /**************************************************
     * TEST CASE 8
     */
    testNum++;
    testName = "8. add(int, String) - with resize";
    pass = true;
    try {
      SuperArray list8 = new SuperArray(2);
      list8.add("A");
      list8.add("C"); // Full (cap 2) [A, C]
      
      list8.add(1, "B"); // Triggers resize: [A, B, C]
      
      if (list8.size() != 3 || !list8.toString().equals("[A, B, C]")) {
        pass = false;
        System.out.println("   FAIL: list incorrect after add(index) resize");
      }

      if (pass) {
        System.out.println(testNum + ". PASS " + testName);
      } else {
        System.out.println(testNum + ". FAIL " + testName);
      }
    } catch (Exception e) {
      System.out.println(testNum + ". Exception " + testName);
      e.printStackTrace();
    }

    /**************************************************
     * TEST CASE 9
     */
    testNum++;
    testName = "9. remove(int) - start, middle, end";
    pass = true;
    try {
      SuperArray list9 = new SuperArray();
      list9.add("A"); list9.add("B"); list9.add("C"); list9.add("D"); list9.add("E");
      // [A, B, C, D, E]
      
      String r1 = list9.remove(2); // Remove "C" from middle
      if (!r1.equals("C") || list9.size() != 4 || !list9.toString().equals("[A, B, D, E]")) {
        pass = false;
        System.out.println("   FAIL: remove(middle) failed");
      }
      
      String r2 = list9.remove(0); // Remove "A" from start
      if (!r2.equals("A") || list9.size() != 3 || !list9.toString().equals("[B, D, E]")) {
        pass = false;
        System.out.println("   FAIL: remove(start) failed");
      }
      
      String r3 = list9.remove(2); // Remove "E" from end
      if (!r3.equals("E") || list9.size() != 2 || !list9.toString().equals("[B, D]")) {
        pass = false;
        System.out.println("   FAIL: remove(end) failed");
      }

      if (pass) {
        System.out.println(testNum + ". PASS " + testName);
      } else {
        System.out.println(testNum + ". FAIL " + testName);
      }
    } catch (Exception e) {
      System.out.println(testNum + ". Exception " + testName);
      e.printStackTrace();
    }

    /**************************************************
     * TEST CASE 10
     */
    testNum++;
    testName = "10. indexOf() and lastIndexOf()";
    pass = true;
    try {
      SuperArray list10 = new SuperArray();
      list10.add("X"); list10.add("Y"); list10.add("Z"); 
      list10.add("Y"); list10.add("X");
      // [X, Y, Z, Y, X]
      
      if (list10.indexOf("X") != 0) pass = false;
      if (list10.lastIndexOf("X") != 4) pass = false;
      if (list10.indexOf("Y") != 1) pass = false;
      if (list10.lastIndexOf("Y") != 3) pass = false;
      if (list10.indexOf("Z") != 2) pass = false;
      if (list10.lastIndexOf("Z") != 2) pass = false;
      if (list10.indexOf("A") != -1) pass = false; // Not found
      if (list10.lastIndexOf("A") != -1) pass = false; // Not found

      if (pass) {
        System.out.println(testNum + ". PASS " + testName);
      } else {
        System.out.println(testNum + ". FAIL " + testName);
      }
    } catch (Exception e) {
      System.out.println(testNum + ". Exception " + testName);
      e.printStackTrace();
    }

    /**************************************************
     * TEST CASE 11
     */
    testNum++;
    testName = "11. indexOf() and lastIndexOf() with null";
    pass = true;
    try {
      SuperArray list11 = new SuperArray();
      list11.add(null); list11.add("A"); list11.add(null); list11.add("A");
      // [null, A, null, A]
      
      if (list11.indexOf(null) != 0) pass = false;
      if (list11.lastIndexOf(null) != 2) pass = false;
      if (list11.indexOf("A") != 1) pass = false;
      if (list11.lastIndexOf("A") != 3) pass = false;

      if (pass) {
        System.out.println(testNum + ". PASS " + testName);
      } else {
        System.out.println(testNum + ". FAIL " + testName);
      }
    } catch (Exception e) {
      System.out.println(testNum + ". Exception " + testName);
      e.printStackTrace();
    }

    /**************************************************
     * TEST CASE 12
     */
    testNum++;
    testName = "12. remove(String)";
    pass = true;
    try {
      SuperArray list12 = new SuperArray();
      list12.add("A"); list12.add("B"); list12.add("C"); list12.add("B");
      // [A, B, C, B]
      
      boolean r1 = list12.remove("B"); // Should remove first "B"
      
      if (!r1) {
        pass = false;
        System.out.println("   FAIL: remove(String) returned false");
      }
      if (list12.size() != 3 || !list12.toString().equals("[A, C, B]")) {
        pass = false;
        System.out.println("   FAIL: list incorrect after remove(String)");
      }

      if (pass) {
        System.out.println(testNum + ". PASS " + testName);
      } else {
        System.out.println(testNum + ". FAIL " + testName);
      }
    } catch (Exception e) {
      System.out.println(testNum + ". Exception " + testName);
      e.printStackTrace();
    }
    
    /**************************************************
     * TEST CASE 13
     */
    testNum++;
    testName = "13. remove(String) with null";
    pass = true;
    try {
      SuperArray list13 = new SuperArray();
      list13.add("A"); list13.add(null); list13.add("B"); list13.add(null);
      // [A, null, B, null]
      
      boolean r1 = list13.remove(null); // Should remove first null
      
      if (!r1 || list13.size() != 3 || !list13.toString().equals("[A, B, null]")) {
        pass = false;
        System.out.println("   FAIL: list incorrect after remove(null)");
      }

      if (pass) {
        System.out.println(testNum + ". PASS " + testName);
      } else {
        System.out.println(testNum + ". FAIL " + testName);
      }
    } catch (Exception e) {
      System.out.println(testNum + ". Exception " + testName);
      e.printStackTrace();
    }

    /**************************************************
     * TEST CASE 14
     */
    testNum++;
    testName = "14. remove(String) - not found";
    pass = true;
    try {
      SuperArray list14 = new SuperArray();
      list14.add("A"); list14.add("B");
      
      boolean r1 = list14.remove("Z"); // Should not find "Z"
      
      if (r1) { // Should return false
        pass = false;
        System.out.println("   FAIL: remove(String) returned true for non-existent value");
      }
      if (list14.size() != 2 || !list14.toString().equals("[A, B]")) {
        pass = false;
        System.out.println("   FAIL: list was modified by remove(String) not-found");
      }

      if (pass) {
        System.out.println(testNum + ". PASS " + testName);
      } else {
        System.out.println(testNum + ". FAIL " + testName);
      }
    } catch (Exception e) {
      System.out.println(testNum + ". Exception " + testName);
      e.printStackTrace();
    }


    // ----- EXCEPTION TESTS (Bad values) -----
    // For these tests, PASS means the *correct* exception was thrown.
    // FAIL means no exception was thrown, or the wrong one was.
    System.out.println("\n--- Running Exception Tests ---");
    
    // Create one list to use for most exception tests
    SuperArray listEx = new SuperArray(5);
    listEx.add("0"); listEx.add("1"); listEx.add("2");
    // listEx is [0, 1, 2] with size 3
    
    /**************************************************
     * TEST CASE 15
     */
    testNum++;
    testName = "15. SuperArray(-1) (Exception)";
    try {
      SuperArray neg = new SuperArray(-1);
      // If it gets here, it's a failure
      System.out.println(testNum + ". FAIL " + testName + " (No exception thrown)");
    } catch (IllegalArgumentException e) {
      System.out.println(testNum + ". PASS " + testName);
    } catch (Exception e) {
      System.out.println(testNum + ". FAIL " + testName + " (Wrong exception thrown)");
      e.printStackTrace();
    }
    
    /**************************************************
     * TEST CASE 16
     */
    testNum++;
    testName = "16. get(-1) (Exception)";
    try {
      listEx.get(-1);
      System.out.println(testNum + ". FAIL " + testName + " (No exception thrown)");
    } catch (IndexOutOfBoundsException e) {
      System.out.println(testNum + ". PASS " + testName);
    } catch (Exception e) {
      System.out.println(testNum + ". FAIL " + testName + " (Wrong exception thrown)");
      e.printStackTrace();
    }
    
    /**************************************************
     * TEST CASE 17
     */
    testNum++;
    testName = "17. get(size) (Exception)";
    try {
      listEx.get(listEx.size()); // size is 3, get(3) should fail
      System.out.println(testNum + ". FAIL " + testName + " (No exception thrown)");
    } catch (IndexOutOfBoundsException e) {
      System.out.println(testNum + ". PASS " + testName);
    } catch (Exception e) {
      System.out.println(testNum + ". FAIL " + testName + " (Wrong exception thrown)");
      e.printStackTrace();
    }

    /**************************************************
     * TEST CASE 18
     */
    testNum++;
    testName = "18. set(-1, ...) (Exception)";
    try {
      listEx.set(-1, "X");
      System.out.println(testNum + ". FAIL " + testName + " (No exception thrown)");
    } catch (IndexOutOfBoundsException e) {
      System.out.println(testNum + ". PASS " + testName);
    } catch (Exception e) {
      System.out.println(testNum + ". FAIL " + testName + " (Wrong exception thrown)");
      e.printStackTrace();
    }

    /**************************************************
     * TEST CASE 19
     */
    testNum++;
    testName = "19. set(size, ...) (Exception)";
    try {
      listEx.set(listEx.size(), "X"); // size is 3, set(3, "X") should fail
      System.out.println(testNum + ". FAIL " + testName + " (No exception thrown)");
    } catch (IndexOutOfBoundsException e) {
      System.out.println(testNum + ". PASS " + testName);
    } catch (Exception e) {
      System.out.println(testNum + ". FAIL " + testName + " (Wrong exception thrown)");
      e.printStackTrace();
    }
    
    /**************************************************
     * TEST CASE 20
     */
    testNum++;
    testName = "20. add(-1, ...) (Exception)";
    try {
      listEx.add(-1, "X");
      System.out.println(testNum + ". FAIL " + testName + " (No exception thrown)");
    } catch (IndexOutOfBoundsException e) {
      System.out.println(testNum + ". PASS " + testName);
    } catch (Exception e) {
      System.out.println(testNum + ". FAIL " + testName + " (Wrong exception thrown)");
      e.printStackTrace();
    }

    /**************************************************
     * TEST CASE 21
     */
    testNum++;
    testName = "21. add(size + 1, ...) (Exception)";
    try {
      listEx.add(listEx.size() + 1, "X"); // size is 3, add(4, "X") should fail
      System.out.println(testNum + ". FAIL " + testName + " (No exception thrown)");
    } catch (IndexOutOfBoundsException e) {
      System.out.println(testNum + ". PASS " + testName);
    } catch (Exception e) {
      System.out.println(testNum + ". FAIL " + testName + " (Wrong exception thrown)");
      e.printStackTrace();
    }
    
    /**************************************************
     * TEST CASE 22
     */
    testNum++;
    testName = "22. remove(-1) (Exception)";
    try {
      listEx.remove(-1);
      System.out.println(testNum + ". FAIL " + testName + " (No exception thrown)");
    } catch (IndexOutOfBoundsException e) {
      System.out.println(testNum + ". PASS " + testName);
    } catch (Exception e) {
      System.out.println(testNum + ". FAIL " + testName + " (Wrong exception thrown)");
      e.printStackTrace();
    }

    /**************************************************
     * TEST CASE 23
     */
    testNum++;
    testName = "23. remove(size) (Exception)";
    try {
      listEx.remove(listEx.size()); // size is 3, remove(3) should fail
      System.out.println(testNum + ". FAIL " + testName + " (No exception thrown)");
    } catch (IndexOutOfBoundsException e) {
      System.out.println(testNum + ". PASS " + testName);
    } catch (Exception e) {
      System.out.println(testNum + ". FAIL " + testName + " (Wrong exception thrown)");
      e.printStackTrace();
    }
    
    /**************************************************
     * TEST CASE 24
     */
    testNum++;
    testName = "24. remove(0) from empty list (Exception)";
    try {
      SuperArray empty = new SuperArray();
      empty.remove(0); // Should fail
      System.out.println(testNum + ". FAIL " + testName + " (No exception thrown)");
    } catch (IndexOutOfBoundsException e) {
      System.out.println(testNum + ". PASS " + testName);
    } catch (Exception e) {
      System.out.println(testNum + ". FAIL " + testName + " (Wrong exception thrown)");
      e.printStackTrace();
    }

  }
}