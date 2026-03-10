import java.util.*;

public class Driver {
  public static void main(String[] args) {
    int[] a = {5, 1, 4, 2};
    int[] b = {8, 3, 7, 6};
    Arrays.sort(a);
    Arrays.sort(b);
    System.out.println("  left:  " + Arrays.toString(a));
    System.out.println("  right: " + Arrays.toString(b));
    System.out.println("  merged: " + Arrays.toString(Merge.merge(a, b)));
    System.out.println();

    int[] c = {10, 2};
    int[] d = {1, 3, 5, 7, 9};
    Arrays.sort(c);
    Arrays.sort(d);
    System.out.println("  left:  " + Arrays.toString(c));
    System.out.println("  right: " + Arrays.toString(d));
    System.out.println("  merged: " + Arrays.toString(Merge.merge(c, d)));
    System.out.println();

    int[] e = {};
    int[] f = {4, 2, 6};
    Arrays.sort(e);
    Arrays.sort(f);
    System.out.println("  left:  " + Arrays.toString(e));
    System.out.println("  right: " + Arrays.toString(f));
    System.out.println("  merged: " + Arrays.toString(Merge.merge(e, f)));
    System.out.println();

    int[] g = {3, 3, 1};
    int[] h = {3, 2, 1};
    Arrays.sort(g);
    Arrays.sort(h);
    System.out.println("  left:  " + Arrays.toString(g));
    System.out.println("  right: " + Arrays.toString(h));
    System.out.println("  merged: " + Arrays.toString(Merge.merge(g, h)));
  }
}