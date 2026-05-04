String[]names;
  Kernel[]kernels;
  int currentKernel;
  PImage car,destination;
  //you can have other instance variables here

  void draw(){
    //Required to have the sketch allow for keyPressed()
    //You don't need code here.
  }

  void keyPressed(){
    currentKernel++;
    currentKernel %= kernels.length;
    kernels[currentKernel].apply(car, destination);
    image(destination, car.width, 0);
    fill(0);
    rect(width/2 + 15 , 10, 100, 30);
    fill(255);
    text(names[currentKernel], width / 2 + 30, 30);
  }

  void setup(){
    //you will still need your old initialization here
    //including drawing your starting images.
    size(1524,495);
    car = loadImage("redcar.png");
    names = new String[]{
      "Identity", "Blur", "Sharpen",
      "Outline", "Left Sobel", "Right Sobel",
      "Top Sobel", "Emboss"
    };
    currentKernel = 0;
    destination = car.copy();
    kernels = new Kernel[] {
      new Kernel( new float[][] {
        {0, 0, 0},
        {0, 1, 0},
        {0, 0, 0}
      }) ,
      new Kernel( new float[][] {
        {.111, .111, .111},
        {.111, .111, .111},
        {.111, .111, .111}
      }) ,
      new Kernel( new float[][] {
        {0, -1, 0},
        {-1, 5, -1},
        {0, -1, 0}
      }) ,
      new Kernel( new float[][] {
        {-1, -1, -1},
        {-1, 8, -1},
        {-1, -1, -1}
      }) ,
      new Kernel( new float[][] {
        {1, 0, -1},
        {2, 0, -2},
        {1, 0, -1}
      }) ,
      new Kernel( new float[][] {
        {-1, 0, 1},
        {-2, 0, 2},
        {-1, 0, 1}
      }) ,
      new Kernel( new float[][] {
        {1, 2,  1},
        {0, 0, 0},
        {-1, -2, -1}
      }),
      new Kernel( new float[][] {
        {-2, -1,  0},
        {-1, 1, 1},
        {0, 1, 2}
      })
    };
    kernels[currentKernel].apply(car, destination);
    image(car, 0, 0);
    image(destination, car.width, 0);
    fill(0);
    rect(width/2 + 15 , 10, 100, 30);
    fill(255);
    text(names[currentKernel], width / 2 + 30, 30);
  }
