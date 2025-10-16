public class Demo{

  /*3.
  Write this method third. Test it then move on
  to the others.
  */
  public static double distance(Point a, Point b){
    double x1 = a.getX();
    double y1 = a.getY();
  }

  public static void main(String[]args){
    Point p1 = new Point(1,1);
    Point p2 = new Point(-1,-1);
    Point p3 = new Point(3,4);
    Point p4 = new Point(p1);
    System.out.println(p4);
    System.out.println( p3);
    System.out.println( distance(p1,p2));
    System.out.println( Point.distance(p1,p2));
    System.out.println( p1.distanceTo(p2));
  }
}