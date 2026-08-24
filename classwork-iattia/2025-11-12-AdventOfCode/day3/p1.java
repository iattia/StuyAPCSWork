import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class p1 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            int count = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;
                String[] parts = line.split("\\s+");
                int a = Integer.parseInt(parts[0]);
                int b = Integer.parseInt(parts[1]);
                int c = Integer.parseInt(parts[2]);
                if (a + b > c && a + c > b && b + c > a) count++;
            }
            scanner.close();
            System.out.println(count);
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found.");
        }
    }
}
