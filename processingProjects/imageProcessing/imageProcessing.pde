private static int MODE = 0;
private static Kernel[] kernels;
void setup(){
  size(1450,500);
  PImage car = loadImage("redcar.png");
  PImage output = car.copy();
  Kernel k = new Kernel( new float[][] {
    {-1, -1, -1},
    {-1, 8, -1},
    {-1, -1, -1}
  } );
  Kernel k2 = new Kernel( new float[][] {
    {.11, .11, .11},
    {.11, .11, .11},
    {.11, .11, .11}
  } );
  kernels = new Kernel[]{k, k2};
}

void mouseClicked() {
  MODE++;
  MODE %= kernels.length;
}

void draw(){
  PImage car = loadImage("redcar.png");
  PImage output = car.copy();
  kernels[MODE].apply(car, output);
  image(car,0,0);
  image(output,car.width,0);
}
