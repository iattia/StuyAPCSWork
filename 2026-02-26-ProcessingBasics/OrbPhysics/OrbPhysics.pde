      ArrayList<Orb>orbList;
      void setup() {
        size(1000, 700);
        orbList = new ArrayList<Orb>();
      }
      void mouseClicked() {
        //add a new Orb to the orbList, constructed as follows:
        //The x and y positions are the same as the mouse
        //the radius should be a random value in the range [40.0,80.0)
        //the xVelocity and yVelocity should be random values in the range [-3.0,3.0)
        float radius = random(40.0, 80.0);
        float xVelocity = random(-3.0, 3.0);
        float yVelocity = random(-3.0, 3.0);
        orbList.add(new Orb(mouseX, mouseY, xVelocity, yVelocity, radius));
      }
      void draw() {
        background(255);
        for (Orb o : orbList) {
          o.move();
          o.display();
        }
        fill(0);
        text(frameRate,20,20);
        text(orbList.size(),20,40);
      }
