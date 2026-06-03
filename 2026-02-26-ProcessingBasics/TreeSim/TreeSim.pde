/*1. the ratio of width to COLS = height to ROWS
*2. SQUARESIZE = width / COLS
*3. Since draw tries to run 60 times a second, adding a restriction on tick will slow down the simulaiton visual and actually make it possible for someone to watch the fire spread.
*4. treeSim = new BurnTrees(COLS, ROWS, DENSITY); 
*/

/**IMPORTANT:
 *Please read through the logic of this sketch before you try to modify anything.
 *Please answer ALL questions in the source code BEFORE writing any code.
 */
BurnTrees treeSim;
int ROWS;
int COLS;
int SQUARESIZE;
int MODE;

void setup() {
  size(1200, 1000);
  ROWS = 50;
  COLS = 60;
  /**question 1 *********************************
   *At this point you have initialized width, height,ROWS,COLS. You can change these values
   *to alter the screen size, but you cannot just change one value!
   *What must be true about the ratio of these values in order for this simulation to display squares?
   *ANSWER ON THE TOP IN ANSWER SLOT 1.
   */

  //width is cols, or x.
  treeSim = new BurnTrees(COLS, ROWS, MODE);

  /**question 2 *********************************
   *Given that you can change the size() and the number of ROWS and COLS,
   *How do you calculate the SQUARESIZE (size of each square you draw) using an expression?
   *ANSWER : replace squareSize = 8; with the correct square size.
   * DO NOT just write a number, it must work when you change the size() command or the ROWS and COLS
   */
  SQUARESIZE = width / COLS ;//COPY YOUR CHANGED LINE TO THE TOP IN ANSWER SLOT 2.


}

/*DO NOT UPDATE THIS METHOD*/
void draw() {
  background(0);
  //frameCount tells you how many times the draw method was called.
  if (frameCount % 1 == 0 && !treeSim.done()) {
    treeSim.tick();
    //println("Frame number: "+ frameCount);
  }
  /**question 3 *********************************
   *Here we only call tick() when the frameCount % 10 == 0.
   *Why do we want to do this?
   *(The print statement is NOT part of the simulation, it is to help you answer this question)
   *hint:  If you cannot figure this out analytically, experiment to test
   *       the difference by changing the code. A print statement is commented out to facilitate testing.
   *ANSWER ON THE TOP IN ANSWER SLOT 3.
   */



  //Convert the 2D array into a grid of RED/GREEN/WHITE/GREY Squares.
  //noStroke();
  drawSquares(treeSim);

  //Output the resulting time and dimensions of the simulation
  if (treeSim.done()) {
    fill(100);
    rect(20,00,450,20);
    fill(255);

    textSize(20);
    text("Simulation of "+COLS+" by "+ROWS+" board lasted "+treeSim.getTicks()+" ticks", 20, 20);
  }
}


/**
 *Clicking the mouse will reset the simulation by re-constructing the treeSim variable.
 */
void mouseClicked() {
  /**question 4 *********************************
   *We can easily reset the simulation by clicking the mouse.
   *Please use the same values that it was initialized with in the setup.
   * ANSWER: UPDATE THE NEXT LINE THEN COPY IT TO THE TOP IN ANSWER SLOT 4.
   */
  MODE = (MODE + 1) % 4;
  treeSim = new BurnTrees(COLS, ROWS, MODE);
}


/** question 5 *********************************
 *Write the method that will draw ROWSxCOLS colored squares on the screen
 *@param treeSim: a BurnTrees Object to be drawn
 *ANSWER: Complete this method. (DO NOT COPY THIS TO THE TOP!)
 */
void drawSquares(BurnTrees treeSim) {
  /**Complete this method.
   *1. Break up your screen by drawing ROWSxCOLS squares of the same color.
   *2. Decide how to fill them in using the treeSim object.
   *   Colors: Fire = RED, Tree = GREEN, SPACE = BLACK, ASH = GREY
   *3. You can use the array directly (treeSim.map) because it is in the same java file (sketch).
   */
  for (int r = 0; r < ROWS; r++){
    for (int c = 0; c < COLS; c++){
      int state = treeSim.map[r][c];
      if (state == 10){
        fill(255, 0, 0); 
      } else if (state == -2){
        fill(0, 255, 0); 
      } else if (state == 0){
        fill(128, 128, 128); 
      } else if (state == 5){
        fill(255,255,0);
      } else if (state == 7){ 
        fill(0, 0, 255);
      } else{
        fill(0, 0, 0); 
      }
      rect(c * SQUARESIZE, r * SQUARESIZE, SQUARESIZE, SQUARESIZE);
      if (MODE == 2 || MODE == 3){
        textSize(15);
        fill(255);
        text(treeSim.getDistance(r, c), c * SQUARESIZE + 3, r * SQUARESIZE + SQUARESIZE/2 + 3);
      }
  }
}
}
