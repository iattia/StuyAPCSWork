import java.util.ArrayList;
import java.util.Random;

public class Driver {
    public static void main(String[] args) {
        MyLinkedList myList = new MyLinkedList();
        ArrayList<String> realList = new ArrayList<String>();
        Random rand = new Random();
        int numOperations = 50000; 
        int maxVal = 10;
        for (int i = 0; i < numOperations; i++) {
            int op = rand.nextInt(5);
            String val = "" + rand.nextInt(maxVal);
            try {
                if (op == 0) {
                    boolean myRet = myList.add(val);
                    boolean realRet = realList.add(val);
                    if (myRet != realRet) {
                        fail("add(val) return value mismatch", String.valueOf(myRet), String.valueOf(realRet));
                    }
                }
                else if (op == 1) {
                    int index = 0;
                    if (realList.size() > 0) {
                        index = rand.nextInt(realList.size() + 1);
                    }
                    myList.add(index, val);
                    realList.add(index, val);
                }
                else if (op == 2) {
                    if (realList.size() == 0) continue;
                    int index = rand.nextInt(realList.size());
                    String myRet = myList.remove(index);
                    String realRet = realList.remove(index);
                    if (!myRet.equals(realRet)) {
                        fail("remove(index) return value mismatch", myRet, realRet);
                    }
                }
                else if (op == 3) {
                    boolean myRet = myList.remove(val);
                    boolean realRet = realList.remove(val);
                    if (myRet != realRet) {
                        fail("remove(object) return value mismatch", String.valueOf(myRet), String.valueOf(realRet));
                    }
                }
                else { 
                    if (realList.size() == 0) continue;
                    int index = rand.nextInt(realList.size());
                    String myRet = myList.set(index, val);
                    String realRet = realList.set(index, val);
                    if (!myRet.equals(realRet)) {
                        fail("set(index) return value mismatch", myRet, realRet);
                    }
                }
                if (myList.size() != realList.size()) {
                    fail("Size mismatch", String.valueOf(myList.size()), String.valueOf(realList.size()));
                }
                String myStr = myList.toString();
                String realStr = realList.toString();
                if (!myStr.equals(realStr)) {
                    fail("Forward toString mismatch", myStr, realStr);
                }
                String myReverseStr = myList.toStringReversed();
                String realReverseStr = "[";
                for (int k = realList.size() - 1; k >= 0; k--) {
                    realReverseStr += realList.get(k);
                    if (k != 0) {
                        realReverseStr += ", ";
                    }
                }
                realReverseStr += "]";
                if (!myReverseStr.equals(realReverseStr)) {
                    fail("Backward toString mismatch (Broken Links!)", myReverseStr, realReverseStr);
                }
            } catch (Exception e) {
                System.out.println("CRASHED on operation #" + i + " (Op Code: " + op + ")");
                e.printStackTrace();
                System.exit(1);
            }
        }
        System.out.println("Passed all " + numOperations + " random operations.");
    }
    public static void fail(String reason, String mine, String real) {
        System.out.println("FAIL: " + reason);
        System.out.println("Mine: " + mine);
        System.out.println("Real: " + real);
        System.exit(1);
    }
}