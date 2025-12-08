import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
      Scanner userInput = new Scanner(System.in);
      System.out.print("Enter username: ");
      String userName = userInput.nextLine();
      Adventurer player = new Witch(userName);
      Adventurer opponent = new CodeWarrior("Warrior");
      while (true) {
        if (player.getHP() < 0){
          System.out.println(opponent + " wins!");
          break;
        }
        if (opponent.getHP() < 0){
          System.out.println(player.getName() + "wins!");
          break;
        }
        System.out.println(player);
        System.out.println(opponent+" (" + opponent.getClass().getName() + ") - HP: " + opponent.getHP() + "/"+opponent.getmaxHP()+ " | "+ opponent.getSpecialName()+": "+opponent.getSpecial()+"/"+opponent.getSpecialMax());
        System.out.println("Type: (a)ttack / (sp)ecial / (su)pport / quit");
        String selection = userInput.nextLine();
        if (selection.toLowerCase().equals("a") || selection.toLowerCase().equals("attack")){
          player.attack(opponent);
        } else if (selection.toLowerCase().equals("sp") || selection.toLowerCase().equals("special")){
          player.specialAttack(opponent);
        } else if (selection.toLowerCase().equals("su") || selection.toLowerCase().equals("support")){
          player.support();
        } else if (selection.toLowerCase().equals("quit")){
          break;
        } else {
          System.out.println("Please check for typos and try again.");
          continue;
        }

      }
    }
}
