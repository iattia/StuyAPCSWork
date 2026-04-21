public class Orb {
PVector position, velocity, acceleration;
float radius;
float mass;
color c;
/**
 *IN THIS TAB MODIFY:
 *move()
 *attractTo()
 *applyForce()
 */



void move() {
  //You have 3 PVectors, acceleration, velocity, and position.
  //1. apply acceleration to velocity
  //2. apply velocity to position
  //3. reset acceleration to 0 so that forces do not accumulate
  velocity.add(acceleration);
  position.add(velocity);
  acceleration.set(0, 0);

  //DO NOT EDIT:
  //bounce on earth mode
  if (MODE == EARTH)
    bounce();
}


/**
 *Calculate the force between this orb and the other orb.
 *Return a PVector with the correct magnitude and direction
 */
PVector attractTo(Orb other) {
  //You should be familiar with the formular from physics: g = G*M1*M2/dist^2
  //G is a gravitational constant
  //M1 and M2 are the masses of this Orb, and the other Orb.
  //dist is the distance between the dist.

  //CHANGE THIS
  //calculate the distance from this orb to other orb
  float distance = position.dist(other.position);

  //DO NOT CHANGE THIS:
  //this code prevents small distances creating problems (overlapping orbs with 0 dist)
  distance = max(15.0, distance);

  //CHANGE THIS
  //calculate the magnitude of the force g using the formula g = G*M1*M2/dist^2
  double mag = 1.0;

  //CHANGE THIS
  //calculate the direction of the force
  //hint: (concept) https://mathsathome.com/vector-between-2-points/
  //hint2: use the built in functions of pvectors.
  PVector force = null;

  //CHANGE THIS
  //normalize the force
  force.normalize();

  //CHANGE THIS
  //now you have a unit vector, and a magnitude.
  //Make your force vector have the correct magnitude before returning it.


  //DO NOT CHANGE THIS
  return force;
}

/*Apply a force to the current orb by changing the acceleration.*/
void applyForce(PVector f) {
  //knowing that f = ma, you can rearrange the formula to see how you want to manipulate acceleration:
  //a = f / m
  PVector a = PVector.div(f, mass);
  //CHANGE THIS
  //add  force/mass to the acceleration to apply the force.
  acceleration.add(a);
}

//DO NOT CHANGE THINGS BELOW THIS POINT
//DO NOT CHANGE THINGS BELOW THIS POINT
//DO NOT CHANGE THINGS BELOW THIS POINT

public Orb(float x, float y, float xSpeed, float ySpeed, float radius_, float mass_ ) {
  position = new PVector(x, y);
  velocity = new PVector(xSpeed, ySpeed);
  acceleration = new PVector(0, 0);
  mass = mass_;
  radius = radius_;
  c = color(random(255), random(255), random(255));
}


void display() {
  fill(c);
  noStroke();
  circle(position.x, position.y, (float)radius*2);
}


public void bounce() {
  //This can introduce/remove energy from the system because of small "teleportations".
  if (position.x < radius)
    velocity.x = abs(velocity.x);
  if (position.x > width-radius)
    velocity.x= -1 * abs(velocity.x);
  if (position.y < radius)
    velocity.y = abs(velocity.y);
  if (position.y > height-radius)
    velocity.y= -1 * abs(velocity.y);
}
}
