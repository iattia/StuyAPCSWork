import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class p1 {
    public static void main(String[] args) {
        System.out.println("Bathroom code: " + getCode());
    }

    public static String getCode() {
        try {
            Scanner input = new Scanner(new File("input.txt"));
            int[][] pad = {{1,2,3},{4,5,6},{7,8,9}};
            int row = 1, col = 1;
            String code = "";
            while (input.hasNextLine()) {
                String line = input.nextLine().trim();
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    if (c == 'U' && row > 0) row--;
                    else if (c == 'D' && row < 2) row++;
                    else if (c == 'L' && col > 0) col--;
                    else if (c == 'R' && col < 2) col++;
                }
                code += pad[row][col];
            }
            input.close();
            return code;
        } catch (FileNotFoundException e) {
            return "";
        }
    }
}
