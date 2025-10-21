public class Point{
  private double x,y;

  /*Return a string in the format: (x, y)
  *where x and y are the values from the Point.
  *e.g.  "(0.0, 1.23)"  or  "(-1.02, 21.45)"
  */
  public String toString(){
    //your code here
    return "(" + x + ", " + y + ")";
  }

  public static double distance(Point a, Point b){
    double x1 = a.getX();
    double y1 = a.getY();
    double x2 = b.getX();
    double y2 = b.getY();
    return Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1, 2));
  }

  public double distanceTo(Point other){
   //your code here
   return Math.sqrt(Math.pow(this.x-other.getX(),2)+Math.pow(this.y-other.getY(), 2));
  }



  //#####################################
  //STOP! DO NOT DO THIS PARTS UNTIL YOU ARE TOLD TO DO SO
  //####################################
  public static boolean closeEnough(double a, double b){
    //How can you determine if two values are close enough to eachother?
    //you write this later
    if (a == 0.0 || b == 0.0){
      return a == 0.0 && b == 0.0;
    }
    return Math.abs(a-b)/a >= 0.00001;
  }

  /*Return true when the respective x and y values of the two points differ by at most 0.001% each.
  *To avoid issues: If one is 0.0, the other must be exactly 0.0.
  */
  public boolean equals(Point other){
    //You write this later
    if (closeEnough(this.x,other.x)){
      return closeEnough(this.y,other.y);
    }
    return false;
  }

  //#####################################
  //DO NOT EDIT BELOW THIS LINE:
  //#####################################
  public Point(double X, double Y){
    x=X;
    y=Y;
  }
  public Point(Point p){
    x= p.x;
    y= p.y;
  }
  public double getX(){
    return x;
  }
  public double getY(){
    return y;
  }
}
