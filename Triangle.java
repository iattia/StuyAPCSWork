public class Triangle{
  //Instance Variables
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
  public Point getVertex(int v){
    if (v == 0){
      return v0;
    } else if (v == 1){
      return v1;
    }
    return v2;
  }

  public String toString(){
    String triangleString = "{";
    for (int i=0;i<3;i++){
      triangleString += this.getVertex(i);
      if (i<2){
        triangleString += ", ";
      }
    }
    triangleString += "}";
    return triangleString;
  }

  public double getPerimeter(){
    return this.v0.distanceTo(this.v1) + this.v1.distanceTo(this.v2) + this.v0.distanceTo(this.v2);
  }

  public void setVertex(int v, Point p){
    if (v == 0) {
      v0 = new Point(p);
    } else if (v == 1) {
      v1 = new Point(p);
    } else if (v == 2) {
      v2 = new Point(p);
    }
  }

  /*Return true when the Points of the triangles are
  *all equal() to the corresponding points of the
  *other Triangle.
  */
  public boolean equals(Triangle other){
    return this.v0.equals(other.v0) && this.v1.equals(other.v1) && this.v2.equals(other.v2);
  }

  /*Return "scalene", "isosceles", or "equilateral"
  *All other spelling/capitalization will be graded as incorrect.
  *Make sure to use closeEnough() to determine if
  *two sides are equal because of rounding!
  */
  public String classify(){
    double side1 = this.v0.distanceTo(this.v1);
    double side2 = this.v1.distanceTo(this.v2);
    double side3 = this.v0.distanceTo(this.v2);
    if (Point.closeEnough(side1, side2) && Point.closeEnough(side2, side3)){
      return "equilateral";
    } else if (Point.closeEnough(side1, side2) || Point.closeEnough(side2, side3)){
      return "isosceles";
    } else{
      return "scalene";
    }
  }

  /*Return the area of the triangle
   *Make sure to use the formula:
   *Area = sqrt ( s(s-a)(s-b)(s-c) )
   *given: s = perimeter/2 (semi-perimeter),
   *       a,b,c are the side lengths.
   */
  public double area(){
    double semiPerimeter = this.getPerimeter()/2;
    double side1 = this.v0.distanceTo(this.v1);
    double side2 = this.v1.distanceTo(this.v2);
    double side3 = this.v0.distanceTo(this.v2);
    return Math.sqrt(semiPerimeter*(semiPerimeter-side1)*(semiPerimeter-side2)*(semiPerimeter-side3));
  }
}
