public class Driver{
  public static void main(String[]args){
    //Write your tests here!
    Point r = new Point(100,100);
    Point p = new Point(3.0,4.0);
    Point q = new Point(0.0,0.0);
    
    System.out.println(p+" should be (3.0, 4.0)");
    
    System.out.println(r.distance(p,q)+" should be 5.0");
    
    p = new Point(3.0,4.0);
    q = new Point(4.0,5.0);
    System.out.println(p.distanceTo(q)+" should be 1.4142...");

    Triangle t1 = new Triangle(0, 0, 3, 0, 0, 4);
    System.out.println("Triangle t1: " + t1 + " (Expected: {(0.0, 0.0), (3.0, 0.0), (0.0, 4.0)})");
    System.out.println("Perimeter of t1: " + t1.getPerimeter() + " (Expected: 12.0)");

    Point a = new Point(1, 1);
    Point b = new Point(4, 1);
    Point c = new Point(1, 5);
    Triangle t2 = new Triangle(a, b, c);
    System.out.println("Triangle t2: " + t2 + " (Expected: {(1.0, 1.0), (4.0, 1.0), (1.0, 5.0)})");
    System.out.println("Perimeter of t2: " + t2.getPerimeter() + " (Expected: 12.0)");

    Triangle t3 = new Triangle(0, 0, 1, 0, 0, 1);
    System.out.println("t3: " + t3);
    System.out.println("Expected perimeter: 1 + 1 + √2 ≈ 3.4142");
    System.out.println("Actual perimeter: " + t3.getPerimeter());
    System.out.println();

    Triangle eq = new Triangle(0, 0, 1, Math.sqrt(3), 2, 0);
    System.out.println("eq.classify(): " + eq.classify() + " (Expected: equilateral)");

    Triangle iso = new Triangle(0, 0, 2, 0, 1, 5);
    System.out.println("iso.classify(): " + iso.classify() + " (Expected: isosceles)");

    Triangle sca = new Triangle(0, 0, 3, 0, 1, 4);
    System.out.println("sca.classify(): " + sca.classify() + " (Expected: scalene)");


    Triangle areaT = new Triangle(0, 0, 3, 0, 0, 4);
    System.out.println("areaT.area(): " + areaT.area() + " (Expected: 6.0)");


    Triangle tA = new Triangle(0, 0, 1, 1, 2, 2);
    Triangle tB = new Triangle(new Point(0, 0), new Point(1, 1), new Point(2, 2));
    System.out.println("tA.equals(tB): " + tA.equals(tB) + " (Expected: true)");

    Triangle tC = new Triangle(0, 0, 1, 1, 2, 3);
    System.out.println("tA.equals(tC): " + tA.equals(tC) + " (Expected: false)");
  }
}
