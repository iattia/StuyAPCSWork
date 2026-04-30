private static int MODE = 0;
private static Kernel[] kernels;
private Kernel k = new Kernel( new float[][] {
    {-1, -1, -1},
    {-1, 8, -1},
    {-1, -1, -1}
  } );

private Kernel k2 = new Kernel( new float[][] {
    {.11, .11, .11},
    {.11, .11, .11},
    {.11, .11, .11}
  } );
void setup(){
  size(1450,500);
}

void mouseClicked() {
  MODE++;
  MODE %= kernels.length;
}

void draw(){
  PImage car = loadImage("redcar.png");
  PImage output = car.copy();
  Kernel k3 = new Kernel( new float[][] {
    {(float) Math.random(), (float) Math.random(), (float) Math.random()},
    {(float) Math.random(), (float) Math.random(), (float) Math.random()},
    {(float) Math.random(), (float) Math.random(), (float) Math.random()}
  } );
  Kernel k4 = new Kernel( new float[][] {
    {(float) (Math.random() * 10 - 5), (float) (Math.random() * 10 - 5), (float) (Math.random() * 10 - 5)},
    {(float) (Math.random() * 10 - 5), (float) (Math.random() * 10 - 5), (float) (Math.random() * 10 - 5)},
    {(float) (Math.random() * 10 - 5), (float) (Math.random() * 10 - 5), (float) (Math.random() * 10 - 5)}
  } );
  kernels = new Kernel[]{k, k2, k3, k4};
  kernels[MODE].apply(car, output);
  image(car,0,0);
  image(output,car.width,0);
}
