Board board;
Player[] players;
Dice dice;
int currentTurn = 0;
boolean hasRolled = false;

void setup() {
  size(900, 900); 
  board = new Board();
  dice = new Dice();
  players = new Player[2];
  players[0] = new Player("Player 1", color(255, 0, 0));
  players[1] = new Player("Player 2", color(34, 139, 34));
}

void draw() {
  background(255);
  board.draw(players, currentTurn);
  board.drawPlayers(players);
}


void keyPressed() {
  if (key == ' ' && !hasRolled) {
    int roll = dice.roll();
    players[currentTurn].move(roll);
    println("Rolled: " + dice.die1 + " + " + dice.die2 + " = " + roll + " | " + players[currentTurn].name + " on tile: " + players[currentTurn].position);
    board.tiles[players[currentTurn].position].landOn(players[currentTurn]);
    hasRolled = true;
  }
  if (key == 'b') {
    Tile t = board.tiles[players[currentTurn].position];
    if (t instanceof Property) {
      if (((Property) t).owner == null) {   
        players[currentTurn].buyProperty((Property) t);
      }
    }
  }
  if (key == 'e' && hasRolled) {
    currentTurn = (currentTurn + 1) % players.length;
    hasRolled = false;
  }
}
 
