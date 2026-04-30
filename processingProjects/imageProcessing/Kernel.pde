public class Kernel {
  float[][]kernel;

  /**Constructor takes the kernel that will be applied to the image
  *This implementation only allows 3x3 kernels
  */
  public Kernel(float[][]init) {
    kernel = init;
  }

  /**If part of the kernel is off of the image, return black, Otherwise
  *Calculate the convolution of r/g/b separately, and return that color\
  *if the calculation for any of the r,g,b values is outside the range
  *     0-255, then clamp it to that range (< 0 becomes 0, >255 becomes 255)
  */
  color calcNewColor(PImage img, int x, int y) {
    //Hint: start by always returning black.
    //This will let you test your apply method right away!
    if (x <= 0 || x >= img.width - 1 || y <= 0 || y >= img.height - 1) {
      return color(0);
    }
    float r = 0;
    float g = 0;
    float b = 0;
    for (int i = -1; i <= 1; i++) {
      for (int j = -1; j <= 1; j++) {
        color c = img.get(x + j, y + i);
        float kernVal = kernel[i + 1][j + 1];
        r += red(c) * kernVal;
        g += green(c) * kernVal;
        b += blue(c) * kernVal;
      }
    }
    return color(constrain(r, 0, 255), constrain(g, 0, 255), constrain(b, 0, 255));
  }

  /**You must write this method that applies the kernel to the source,
  *and saves the data to the destination.*/
  void apply(PImage source, PImage destination) {
    for (int r = 0; r < source.height; r++){
      for (int c = 0; c < source.width; c++){
        destination.set(c, r, calcNewColor(source, c, r));
      }
    }
  }

}
