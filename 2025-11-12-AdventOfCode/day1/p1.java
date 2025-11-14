import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class p1 {
    public static void main(String[] args) {
        System.out.println("Easter Bunny HQ is " + blocksAway() + " blocks away.");
    }

    public static int blocksAway() {
        try {
            Scanner input = new Scanner(new File("input.txt"));
            int x = 0, y = 0, direction = 0;
            String line = input.nextLine();
            String[] steps = line.split(",");
            for (String step : steps) {
                step = step.trim();
                char turn = step.charAt(0);
                int distance = Integer.parseInt(step.substring(1));
                if (turn == 'R') direction = (direction + 1) % 4;
                else if (turn == 'L') direction = (direction + 3) % 4;
                switch (direction) {
                    case 0 -> y += distance;
                    case 1 -> x += distance;
                    case 2 -> y -= distance;
                    case 3 -> x -= distance;
                }
            }
            input.close();
            return Math.abs(x) + Math.abs(y);
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found!");
            return -1;
        }
    }
}
