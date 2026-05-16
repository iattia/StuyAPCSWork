Board board;

void setup() {
  size(900, 900); 
  board = new Board();
}

void draw() {
  background(255);
  board.draw();
}