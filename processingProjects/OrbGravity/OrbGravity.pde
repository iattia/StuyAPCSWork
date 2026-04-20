ArrayList<Orb>orbList;
Orb earth, center;
static double G = 20;
static int ORBIT = 0;
static int EARTH = 1;
static int MODE = EARTH;

/**
*IN THIS TAB: MODIFY YOUR SETUP BEFORE YOU EDIT ORB
*/

void setup() {
size(1200, 900);
//CHANGE THIS
//make an orb at the center of the screen with a mass of 100.
//note: Orb Constructor parameters: x,y,xSpeed,ySpeed,radius,mass
center = new Orb(600.0,450.0, 0.0, 0.0, 10.0, 100.0);

//CHANGE THIS
//make earth (mass of 500million) place it very far off the bottom of the screen
earth = new Orb(1.0,99999999.0,0.0,0.0,10000.0,500000000.0);


//DO NOT CHANGE THIS:
orbList = new ArrayList<Orb>();
}

//When you click you add an orb that moves to the right
void mouseClicked() {
orbList.add(new Orb(mouseX, mouseY, 5, 0, 20, 10));
}

//When you press a key you change modes
void keyPressed() {
MODE++;
MODE%=2;
}
void draw() {
background(255);
for (Orb o : orbList) {
  o.move();
  o.display();
  if (MODE==EARTH)
    o.applyForce(o.attractTo(earth));
  if (MODE==ORBIT)
    o.applyForce(o.attractTo(center));
}
if (MODE==ORBIT)
  center.display();
fill(0);
if (MODE==ORBIT)
  text("Orbit Mode", 20, 20);
if (MODE==EARTH)
  text("Earth Mode", 20, 20);

text(orbList.size(), 20, 40);
}
