int START_MENU = 0;
int CUSTOMIZATION = 1;
int PLAYING = 2;
int GAME_OVER = 3;
int state = START_MENU;
Board board;
ArrayList<Player> players;
Dice dice;
int currentTurn = 0;
boolean hasRolled = false;
boolean canRollAgain = false;
color[] selectedColors = { color(255, 0, 0), color(0, 180, 0), color(0, 0, 255), color(200, 0, 200) };
int selectedPlayerCount = 2;
String popupTitle = "";
String popupMessage = "";
boolean showPopup = false;
Property activePropertyPrompt = null;
ChanceTile activeChanceTilePrompt = null;
boolean wasMovedByCard = false;
void setup() {
    size(1000, 1000);
    board = new Board();
    dice = new Dice();
    players = new ArrayList<Player>();
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
    canRollAgain = false;
    selectedColors[0] = color(255, 0, 0);
    selectedColors[1] = color(0, 180, 0);
    selectedColors[2] = color(0, 0, 255);
    selectedColors[3] = color(200, 0, 200);
    selectedPlayerCount = 2;
    showPopup = false;
    wasMovedByCard = false;
    activePropertyPrompt = null;
    activeChanceTilePrompt = null;
    for (Tile t : board.tiles) {
        if (t instanceof Property) {
            ((Property) t).owner = null;
        }
    }
    state = START_MENU;
}