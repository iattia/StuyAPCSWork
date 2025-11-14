import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class p1 {
    public static void main(String[] args) {
        System.out.println("The answer is " + sumValid());
    }
    public static int sumValid() {
        int total = 0;
        try {
            Scanner input = new Scanner(new File("input.txt"));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                int lastDash = line.lastIndexOf("-");
                int bracket = line.indexOf("[");
                String name = line.substring(0, lastDash).replace("-", "");
                int sector = Integer.parseInt(line.substring(lastDash + 1, bracket));
                String checksum = line.substring(bracket + 1, line.indexOf("]"));
                if (isValid(name, checksum)) {
                    total += sector;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("input.txt not found");
        }
        return total;
    }
    private static boolean isValid(String name, String checksum) {
        int[] freq = new int[26];
        for (char c : name.toCharArray()) {
            freq[c - 'a']++;
        }
        Character[] letters = new Character[26];
        for (int i = 0; i < 26; i++) {
            letters[i] = (char) ('a' + i);
        }
        Arrays.sort(letters, (a, b) -> {
            int f1 = freq[a - 'a'];
            int f2 = freq[b - 'a'];
            if (f1 != f2) return f2 - f1;
            return a - b;
        });
        StringBuilder check = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            check.append(letters[i]);
        }
        return check.toString().equals(checksum);
    }
}
