void avatar(int x, int y) {
  fill(255, 210, 0);
  stroke(0);
  strokeWeight(2);
  circle(x, y, 100);
  fill(30, 0, 0);
  noStroke();
  circle(x - 20, y - 10, 15);
  circle(x + 20, y - 10, 15);
  noFill();
  stroke(30, 0, 0);
  strokeWeight(3);
  arc(x, y + 15, 30, 15, 0, PI);
  stroke(255, 210, 0);
  strokeWeight(14);
  strokeCap(ROUND);
  line(x + 60, y + 40, x + 80, y);
  line(x + 80, y, x + 30, y - 25);
  stroke(0);
  strokeWeight(1);
  line(x + 40, y - 20, x + 70, y - 5);
  line(x + 45, y - 10, x + 75, y + 5);
}

//setup will draw two of your avatars.
void setup(){
         size(800,800);
         background(255);
         avatar(200,200);
         avatar(500,500);
}
