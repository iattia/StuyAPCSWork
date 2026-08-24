public class Orb{
    float x,y;
    float dx,dy;
    float radius;
    color c;

    public Orb(float x_pos,float y_pos,float x_vel, float y_vel, float radius_ ){
      x = x_pos;
      y = y_pos;
      dx = x_vel;
      dy = y_vel;
      radius = radius_;
      //random color... why not.
      c = color(random(255),random(255),random(255));
    }

    public Orb(float x_, float y_, float angle_, float radius_){
      this(x_, y_, 5 * cos(radians(angle_)), 5 * sin(radians(angle_)), radius_);
    }
    void display(){
      //Part 1:
      //draw a circle at the x,y position, with the correct radius.
      //make sure it is the correct color
      //make sure you read the parameters of ellipse/circle, so that you have the correct size.
      //radius is NOT one of the parameters by default.
      fill(c);
      circle(x, y, radius * 2);
    }

    void move(){
      //PART 2 VELOCITY
      //change the x based on the xVelocity
      //change the y based on the yVelocity
      x += dx;
      y += dy;
      //PART 3 BOUNCE
      //If you are touching any of the sides of the screen:
      //Change the direction of movement by negataing one of the velocity directions.
      //check x and y separately in case you hit a corner and hit both simultaneously, do not connect with an else!
      if (x - radius < 0){
        dx = abs(dx);
      }
      if (x + radius > width){
        dx = -abs(dx);
      }
      if (y - radius < 0){
        dy = abs(dy);
      }
      if (y + radius > height) {
        dy = -abs(dy);
      }
    }
  }
