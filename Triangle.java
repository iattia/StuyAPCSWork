public class Triangle{
  //Instance Variables
  private double x0, y0, x1, y1, x2, y2;
  private Point v0, v1, v2;
  //Constructors
  public Triangle(double x0, double y0, double x1, double y1, double x2, double y2){
    this.v0 = new Point(x0, y0);
    this.v1 = new Point(x1, y1);
    this.v2 = new Point(x2, y2);
  }
  public Triangle(Point v0,Point v1,Point v2){
    this.v0 = new Point(v0);
    this.v1 = new Point(v1);
    this.v2 = new Point(v2);
  }
  //Methods

}
