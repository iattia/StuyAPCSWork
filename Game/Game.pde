Board board;
Player[] players;

void setup() {
  size(900, 900); 
  board = new Board();
  
  players = new Player[2];
  players[0] = new Player("Player 1");
  players[1] = new Player("Player 2");
}

void draw() {
  background(255);
  board.draw();
  board.drawPlayers(players);
}