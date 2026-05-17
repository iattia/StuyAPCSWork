Board board;
Player[] players;
Dice dice;

void setup() {
  size(900, 900); 
  board = new Board();
  dice = new Dice();
  players = new Player[2];
  players[0] = new Player("Player 1");
  players[1] = new Player("Player 2");
}

void draw() {
  background(255);
  board.draw();
  board.drawPlayers(players);
}

void keyPressed() {
  if (key == ' ') {
    int roll = dice.roll();
    players[0].move(roll);
    println("Rolled: " + dice.die1 + " + " + dice.die2 + " = " + roll + " | Player 1 on tile: " + players[0].position);
  }
  if (key == 'f') {
    int roll = dice.roll();
    players[1].move(roll);
    println("Rolled: " + dice.die1 + " + " + dice.die2 + " = " + roll + " | Player 2 on tile: " + players[1].position);
  }
}