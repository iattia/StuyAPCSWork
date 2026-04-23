ArrayList<Orb>orbList;
Orb earth, center;
static double G = 20;
static double SPRING_CONSTANT = 1.0;
static double SPRING_LENGTH = 150.0;
static int ORBIT = 1;
static int EARTH = 0;
static int OFF = 2;
static int MODE = EARTH;

static boolean BOUNCE = true;
static boolean CLEAR_BACKGROUND = true;
static boolean SPRING = false;

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
earth = new Orb(1.0,200000.0,0.0,0.0,10000.0,500000000.0);


//DO NOT CHANGE THIS:
orbList = new ArrayList<Orb>();
}

//When you click you add an orb that moves to the right
void mouseClicked() {
orbList.add(new Orb(mouseX, mouseY, 5, 0, 20, 10));
}

//When you press a key you change modes
void keyPressed() {
  if (key == ' '){
    MODE++;
    MODE%=3;
  }
  if (key == 'b' || key == 'B'){
    BOUNCE = !BOUNCE;
  }
  if (key == 'c' || key == 'C'){
    CLEAR_BACKGROUND = !CLEAR_BACKGROUND;
  }
  if (key == 's' || key == 'S'){
    SPRING = !SPRING;
  }
}
void draw() {
if (CLEAR_BACKGROUND){
background(255);
}
for (Orb o : orbList) {
  o.move();
  o.display();
  if (MODE==EARTH)
    o.applyForce(o.attractTo(earth));
  if (MODE==ORBIT)
    o.applyForce(o.attractTo(center));
  if (SPRING){
    center.springAttract(o);
  }
}
if (MODE==ORBIT)
  center.display();
fill(0);
if (MODE==ORBIT)
  text("Orbit Mode", 20, 20);
if (MODE==EARTH)
  text("Earth Mode", 20, 20);
if (MODE==OFF){
  text("Gravity Off", 20, 20);
}
if (BOUNCE){
  text("Bounce On", 20, 60);
} else{
  text("Bounce Off", 20, 60);
}
if (CLEAR_BACKGROUND){
  text("Clear Background On", 20, 80);
} else {
  text("Clear Background Off", 20, 80);
}
if (SPRING){
  text("Spring On", 20, 100);
} else{
  text("Spring Off", 20, 100);
}


text(orbList.size(), 20, 40);
}
