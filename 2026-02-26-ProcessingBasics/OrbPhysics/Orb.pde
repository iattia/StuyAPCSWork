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


    void display(){
      //Part 1:
      //draw a circle at the x,y position, with the correct radius.
      //make sure it is the correct color
      //make sure you read the parameters of ellipse/circle, so that you have the correct size.
      //radius is NOT one of the parameters by default.
    }

    void move(){
      //PART 2 VELOCITY
      //change the x based on the xVelocity
      //change the y based on the yVelocity

      //PART 3 BOUNCE
      //If you are touching any of the sides of the screen:
      //Change the direction of movement by negataing one of the velocity directions.
      //check x and y separately in case you hit a corner and hit both simultaneously, do not connect with an else!

    }
  }
