public class Demo{

  /*3.
  Write this method third. Test it then move on
  to the others.
  */
  public static double distance(Point a, Point b){
    double x1 = a.getX();
    double y1 = a.getY();
    double x2 = b.getX();
    double y2 = b.getY();
    return Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1, 2));
  }

  public static void main(String[]args){
    Point p1 = new Point(1,1);
    Point p2 = new Point(-1,-1);
    Point p3 = new Point(3,4);
    Point p4 = new Point(p1);
    Point p5 = new Point(0,3);
    Point p6 = new Point(4, 0);
    Point eq1 = new Point(0,0);
    Point eq2 = new Point(1,0);
    Point eq3 = new Point(0.5, Math.sqrt(3)/2);
    System.out.println(p4);
    System.out.println( p3);
    System.out.println( distance(p1,p2));
    System.out.println( Point.distance(p1,p2));
    System.out.println( p1.distanceTo(p2));
    System.out.println("Expected 5.0, got: " + distance(p5,p6));
    System.out.println("Expected 5.0, got: " + Point.distance(p5,p6));
    System.out.println("Expected 5.0, got: " + p5.distanceTo(p6));
    System.out.println("Equilateral triangle side 1 (expecting length of 1): " + eq1.distanceTo(eq2));
    System.out.println("Equilateral triangle side 2 (expecting length of 1): " + eq1.distanceTo(eq3));
    System.out.println("Equilateral triangle side 3 (expecting length of 1): " + eq2.distanceTo(eq3));
  }
}