Board board;
ArrayList<Player> players;
Dice dice;
int currentTurn = 0;
boolean hasRolled = false;

void setup() {
  size(900, 900);
  board = new Board();
  dice = new Dice();
  players = new ArrayList<Player>();
  players.add(new Player("Player 1", color(255, 0, 0)));
  players.add(new Player("Player 2", color(34, 139, 34)));
}

void draw() {
  background(255);
  for (int i = players.size() - 1;  i>= 0; i--){
    if (players.get(i).getBankrupt() == true){
      players.remove(i);
    }
  }
  board.draw(players, currentTurn);
  board.drawPlayers(players);

}


void keyPressed() {
  if (key == ' ' && !hasRolled) {
    int roll = dice.roll();
    players.get(currentTurn).move(roll);
    println("Rolled: " + dice.die1 + " + " + dice.die2 + " = " + roll + " | " + players.get(currentTurn).name + " on tile: " + players.get(currentTurn).position);
    board.tiles[players.get(currentTurn).position].landOn(players.get(currentTurn));
    hasRolled = true;
  }
  if (key == 'b') {
    Tile t = board.tiles[players.get(currentTurn).position];
    if (t instanceof Property) {
      if (((Property) t).owner == null) {
        players.get(currentTurn).buyProperty((Property) t);
      }
    }
  }
  if (key == 'e' && hasRolled) {
    currentTurn = (currentTurn + 1) % players.size();
    hasRolled = false;
  }
}
