void avatar(int x, int y){
  fill(255,210,0);
  circle(x,y,100);
  fill(30,0,0);
    ellipse(x-20,y-10,10,20);
    ellipse(x+20,y-10,10,20);
    ellipse(x,y+20,50,10);
  stroke(255,210,0);
  strokeWeight(10);
  line(x-100,y,x-30,y-40);
}

//setup will draw two of your avatars.
void setup(){
         size(800,800);
         background(255);
         avatar(200,200);
}
