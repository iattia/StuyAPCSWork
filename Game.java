import java.util.*;
public class Game{
  private static final int WIDTH = 80;
  private static final int HEIGHT = 30;
  private static final int BORDER_COLOR = Text.BLACK;
  private static final int BORDER_BACKGROUND = Text.WHITE + Text.BACKGROUND;

  public static void main(String[] args) {
    
    drawBackground();
    run();
  }

  //Display the borders of your screen that will not change.
  //Do not write over the blank areas where text will appeasr or parties will appear.
  public static void drawBackground(){
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    Text.clear();
    System.out.print("\033[;" + BORDER_BACKGROUND + "m");
    for (int i = 1; i <= 80; i++){
      Text.go(30, i);
      System.out.print(" ");
      Text.go(1, i);
      System.out.print(" ");
      Text.go(10, i);
      System.out.print(" ");
      Text.go(19, i);
      System.out.print(" ");
    }
    for (int i = 2; i  <= 30; i++){
      Text.go(i, 1);
      System.out.print(" ");
      Text.go(i, 80);
      System.out.print(" ");
    }
    Text.reset();
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
  }

  //Display a line of text starting at
  //(columns and rows start at 1 (not zero) in the terminal)
  //use this method in your other text drawing methods to make things simpler.
  public static void drawText(String s,int startRow, int startCol){
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    Text.go(startRow, startCol);
    System.out.print(s);
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
  }

  /*Use this method to place text on the screen at a particular location.
  *When the length of the text exceeds width, continue on the next line
  *for up to height lines.
  *All remaining locations in the text box should be written with spaces to
  *clear previously written text.
  *@param row the row to start the top left corner of the text box.
  *@param col the column to start the top left corner of the text box.
  *@param width the number of characters per row
  *@param height the number of rows
  */
  public static void TextBox(int row, int col, int width, int height, String text){
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    Text.go(row, col);
    while (true){
      if (height == 0){
        return;
      }
      if (text.length() > width){
        System.out.print(text.substring(0, width+1));
        text = text.substring(width+1);
        height--;
        row++;
        Text.go(row,col);
        continue;
      } else if(! (text.equals(""))){
        System.out.print(text+" ".repeat(width-text.length()+1));
        height--;
        text = "";
      }
      if (height > 0){
        row++;
        Text.go(row, col);
        System.out.print(" ".repeat(width + 1));
        height--;
      } else{ 
        return;
      }
    }
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
  }




    //return a random adventurer (choose between all available subclasses)
    //feel free to overload this method to allow specific names/stats.
    public static Adventurer createRandomAdventurer(){
      int choice = (int) (Math.random() * 2);
      String[] names = {"Bob", "Charlie", "Eve", "Diana", "Alice"};
      String name = names[(int) (Math.random() * names.length)];

      if (choice == 0){
        return new Giant(name);
      } else{
        return new Witch(name);
      }
    }

    /*Display a List of 1-4 adventurers on the rows row through row+3 (4 rows max)
    *Should include Name HP and Special on 3 separate lines.
    *Note there is one blank row reserved for your use if you choose.
    *Format:
    *Bob          Amy        Jun
    *HP: 10       HP: 15     HP:19
    *Caffeine: 20 Mana: 10   Snark: 1
    * ***THIS ROW INTENTIONALLY LEFT BLANK***
    */
    public static void drawParty(ArrayList<Adventurer> party,int startRow){

      /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
      int boxWidth = 19;
      int boxHeight = 5;
      int borderColor;
      if (startRow < 10){
        borderColor = Text.RED;
      } else{
        borderColor = Text.GREEN;
      }
      for (int i = 0; i < 4; i++){
        int col = 2 + (i * boxWidth);
        Adventurer a;
        if (i < party.size()) {
          a = party.get(i);
        } else {
          a = null;
        }
        drawPlayerBox(startRow, col, boxWidth, boxHeight, a, i, borderColor);
      }
    }
      /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    public static void drawPlayerBox(int row, int col, int width, int height, Adventurer a, int index, int borderColor){
      String topLeft = "┌";
      String topRight = "┐";
      String bottomLeft = "└";
      String bottomRight = "┘";
      String horizontal = "─";
      String vertical = "│";
   
      Text.go(row, col);
      System.out.print(Text.colorize(topLeft + horizontal.repeat(width - 2) + topRight, borderColor));

      for (int r = 1; r < height - 1; r++){
        Text.go(row + r, col);
        System.out.print(Text.colorize(vertical, borderColor));
        System.out.print(" ".repeat(width - 2));
        Text.go(row + r, col + width - 1);
        System.out.print(Text.colorize(vertical, borderColor));
      }

      Text.go(row + height - 1, col);
      System.out.print(Text.colorize(bottomLeft + horizontal.repeat(width - 2) + bottomRight, borderColor));

      if (a != null){
        String name = "[" + index + "] " + a.getName();
        if (name.length() > width - 4) name = name.substring(0, width - 4);
        Text.go(row + 1, col + 2);
        System.out.print(String.format("%-" + (width - 4) + "s", name));
        Text.go(row + 2, col + 2);
        String hpStr = "HP:" + colorByPercent(a.getHP(), a.getmaxHP());
        System.out.print(hpStr);
        Text.go(row + 3, col + 2);
        String spName = a.getSpecialName();
        if (spName.length() > 6) spName = spName.substring(0, 6);
        String spStr = spName + ":" + a.getSpecial() + "/" + a.getSpecialMax();
        if (spStr.length() > width - 4) spStr = spStr.substring(0, width - 4);
        System.out.print(String.format("%-" + (width - 4) + "s", spStr));
      } else {
        Text.go(row + 2, col + 2);
        System.out.print(Text.colorize("  (empty)", Text.BLACK + Text.BRIGHT));
      }
    }

  //Use this to create a colorized number string based on the % compared to the max value.
  public static String colorByPercent(int hp, int maxHP){
    String output = String.format("%2s", hp+"")+"/"+String.format("%2s", maxHP+"");
    double percent = (double) hp / maxHP;
    int color = 0;
    if (percent < 0.25){
      color = Text.RED;
    }
    else if (percent < 0.75){
      color = Text.YELLOW;
    }
    else{
      color = Text.WHITE;
    }
    //COLORIZE THE OUTPUT IF HIGH/LOW:
    // under 25% : red
    // under 75% : yellow
    // otherwise : white
    return Text.colorize(output, color);
  }


  


  //Display the party and enemies
  //Do not write over the blank areas where text will appear.
  //Place the cursor at the place where the user will by typing their input at the end of this method.
  public static void drawScreen(ArrayList<Adventurer> enemies, ArrayList<Adventurer> party){

    //draw player party
    Text.go(12, 3);
    System.out.print(Text.colorize("YOUR PARTY", Text.GREEN, Text.BOLD));
    drawParty(party, 13);

    //draw enemy party
    Text.go(3, 3);
    System.out.print(Text.colorize("ENEMIES", Text.RED, Text.BOLD));
    drawParty(enemies, 4);

  }

  public static String userInput(Scanner in){
      Text.go(29, 2);
      Text.showCursor();

      //show cursor

      String input = in.nextLine();
      for (int i = 2; i < 80; i++){
        drawText(" ", 29, i);
      }

      return input;
  }

  public static void quit(){
    Text.reset();
    Text.showCursor();
    Text.go(32,1);
  }

  public static void run(){
    //Clear and initialize
    Text.hideCursor();



    //Things to attack:
    //Make an ArrayList of Adventurers and add 1-3 enemies to it.
    //If only 1 enemy is added it should be the boss class.
    //start with 1 boss and modify the code to allow 2-3 adventurers later.
    ArrayList<Adventurer>enemies = new ArrayList<Adventurer>();
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    int numEnemies = (int) (Math.random() * 3 + 1);
    if (numEnemies == 1){
      enemies.add(new Witch("Boss"));
    }
    else{
      for (int i = 0; i < numEnemies; i++){
        enemies.add(createRandomAdventurer());
      }
    }
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    //Adventurers you control:
    //Make an ArrayList of Adventurers and add 2-4 Adventurers to it.
    ArrayList<Adventurer> party = new ArrayList<>();
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    for (int i = 0; i < 3; i++){
      party.add(createRandomAdventurer());
    }
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    boolean partyTurn = true;
    int whichPlayer = 0;
    int whichOpponent = 0;
    int turn = 0;
    String input = "";//blank to get into the main loop.
    Scanner in = new Scanner(System.in);
    //Draw the window border

    //You can add parameters to draw screen!
    drawScreen(enemies,party);//initial state.

    //Main loop
    int deadOpp = 0;
    int deadPar = 0;
    ArrayList<Adventurer> deadList = new ArrayList<>();
    //display this prompt at the start of the game.
    String preprompt = "Enter command for "+ (party.get(whichPlayer)).getName() + ": attack/special/support/quit";
    
    Text.go(28, 2);
    System.out.print(preprompt);

    while(! ((input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit") || (deadOpp == enemies.size() || deadPar == party.size())))){
      //Read user input
      input = userInput(in);
      int enemyInd = 100;
      if (partyTurn && !input.startsWith("su ")){
        for (int i = 0; i < input.length(); i++){
          if (input.charAt(i) == ' '){
            if (input.charAt(i + 1) >= '0' && input.charAt(i + 1) <= '9' ){
              enemyInd = Integer.parseInt(input.substring(i + 1, i + 2));
            }
            else{
              continue;
            }
          }
        }
        if (enemyInd == 100){
          continue;
        }
        if (enemyInd >= enemies.size());
    }
    else if (input.startsWith("su ")){
      if (enemyInd >= party.size()){
        continue;
      }
    }
      //example debug statment
      //TextBox(24,2,1,78,"input: "+input+" partyTurn:"+partyTurn+ " whichPlayer="+whichPlayer+ " whichOpp="+whichOpponent );

      //display event based on last turn's input
      if(partyTurn){
        //Process user input for the last Adventurer:
        if(input.startsWith("attack ") || input.startsWith("a ")){
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          if (enemies.get(enemyInd).getHP() == 0){
            TextBox(20, 2, 77, 3, "Please choose another target enemy to attack.");
            continue;
          }
          TextBox(20, 2, 77, 3, (party.get(whichPlayer)).attack(enemies, enemyInd));
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
        else if(input.startsWith("special ") || input.startsWith("sp ")){
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          if (enemies.get(enemyInd).getHP() == 0){
            TextBox(20, 2, 77, 3, "Please choose another target enemy to attack.");
            continue;
          }
          TextBox(20, 2, 77, 3, (party.get(whichPlayer)).specialAttack(enemies, enemyInd));
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
        else if(input.startsWith("su ") || input.startsWith("support ")){
          //"support 0" or "su 0" or "su 2" etc.
          //assume the value that follows su  is an integer.
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          if (party.get(enemyInd).getHP() == party.get(enemyInd).getmaxHP() || party.get(enemyInd).getSpecial() == party.get(enemyInd).getSpecialMax()){
            TextBox(20, 2, 77, 3, party.get(enemyInd).getName() + " has full HP or special. Choose another action/character.");
          }
          TextBox(20, 2, 77, 3, (party.get(whichPlayer)).support(party, enemyInd));
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
        else{
          //not a good input
          continue;
        }
        TextBox(24, 2, 77, 1, " ");

        //checkign for dead characters
        for (int i = 0; i < party.size(); i++){
          if ((party.get(i)).getHP() <= 0 && !deadList.contains(party.get(i))){
            (party.get(i)).setHP(0);
            TextBox(24, 2, 77, 1, Text.colorize(party.get(i).getName() + " has died.", Text.RED));
            deadPar++;
            deadList.add(party.get(i));
          }
        }
        for (int i = 0; i < enemies.size(); i++){
          if ((enemies.get(i)).getHP() <= 0 && !deadList.contains(enemies.get(i))){
            (enemies.get(i)).setHP(0);
            TextBox(24, 2, 77, 1, Text.colorize(enemies.get(i).getName() + " has died.", Text.RED));
            deadOpp++;
            deadList.add(enemies.get(i));
          }
        } 
        drawScreen(enemies,party);
        //You should decide when you want to re-ask for user input
        //If no errors:
        whichPlayer++;

        if(whichPlayer < party.size()){
          //This is a player turn.
          //Decide where to draw the following prompt:
          while (deadList.contains(party.get(whichPlayer))){
            whichPlayer++;
          }
          String prompt = "Enter command for "+party.get(whichPlayer).getName()+": attack/special/support/quit";

          TextBox(28, 2, 77, 1, prompt);
          continue;
        }else{  
          //This is after the player's turn, and allows the user to see the enemy turn
          //Decide where to draw the following prompt:
          String prompt = "press enter to see monster's turn";
          TextBox(28, 2, 77, 1, prompt);
          partyTurn = false;
          whichOpponent = 0;
        if (whichOpponent < enemies.size() - 1){
          while (whichOpponent < enemies.size() && deadList.contains(enemies.get(whichOpponent))){
            whichOpponent++;
          }
        }
        }
        //done with one party member
      }else{
        //not the party turn!


        //enemy attacks a randomly chosen person with a randomly chosen attack.
        //Enemy action choices go here!
        /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
        int randAttack = (int) (Math.random() * 3);
        int randPlayer = (int) (Math.random() * party.size());
        if (party.get(randPlayer).getHP() <= 0){
          continue;
        }
        int randOpp = (int) (Math.random() * enemies.size());
        if (enemies.get(randOpp).getHP() == 0 || enemies.get(randOpp).getHP() == enemies.get(randOpp).getmaxHP()){
          continue;
        }
        if (randAttack == 0){
          TextBox(20, 2, 77, 3, (enemies.get(whichOpponent)).attack(party, randPlayer));
        }
        else if (randAttack == 1){
          TextBox(20, 2, 77, 3, (enemies.get(whichOpponent)).specialAttack(party, randPlayer));
        }
        else{
          TextBox(20, 2, 77, 3, (enemies.get(whichOpponent)).support(enemies, randOpp));
        }
        /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        TextBox(24, 2, 77, 1, " ");
        
        for (int i = 0; i < party.size(); i++){
          if ((party.get(i)).getHP() <= 0 && !deadList.contains(party.get(i))){
            (party.get(i)).setHP(0);
            TextBox(24, 2, 77, 1, Text.colorize(party.get(i).getName() + " has died.", Text.RED));
            deadPar++;
            deadList.add(party.get(i));
          }
        }
        for (int i = 0; i < enemies.size(); i++){
          if ((enemies.get(i)).getHP() <= 0 && !deadList.contains(enemies.get(i))){
            (enemies.get(i)).setHP(0);
            TextBox(24, 2, 77, 1, Text.colorize(enemies.get(i).getName() + " has died.", Text.RED));
            deadOpp++;
            deadList.add(enemies.get(i));
          }
        } 
        //Decide where to draw the following prompt:
        String prompt = "press enter to see next turn";

        TextBox(28, 2, 77, 1, prompt);

        whichOpponent++;
        
        if (whichOpponent < enemies.size()){
          while (whichOpponent < enemies.size() && deadList.contains(enemies.get(whichOpponent))){
            whichOpponent++;
          }
        }

      }//end of one enemy.

      //modify this if statement.
      if(!partyTurn && whichOpponent >= enemies.size()){
        //THIS BLOCK IS TO END THE ENEMY TURN
        //It only triggers after the last enemy goes.
        whichPlayer = 0;
        turn++;
        partyTurn=true;
        //display this prompt before player's turn
        while (deadList.contains(party.get(whichPlayer))){
            whichPlayer++;
          }
        String prompt = "Enter command for "+party.get(whichPlayer).getName()+": attack/special/support/quit";
        TextBox(28, 2, 77, 1, prompt);
      }

      //display the updated screen after input has been processed.

      drawScreen(enemies,party);
    

    }//end of main game loop

    String msg = "";
    if (deadOpp == enemies.size() && deadPar == party.size()){
      msg += "Tie! All characters on both teams have died.";
    }
    else if (deadOpp == enemies.size()){
      msg += "You win! All characters on enemy team have died.";
    }
    else if (deadPar == party.size()){
      msg += "You lost. All of your adventurers have died.";
    }
    TextBox(20, 2, 77, 9, msg);

    //After quit reset things:
    quit();
  }
  
}
