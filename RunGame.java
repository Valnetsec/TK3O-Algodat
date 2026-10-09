import java.util.Scanner;

public class RunGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== MYTHAG SHOP ===");
        System.out.println("1. Character Roster");
        System.out.println("2. Material Shop");
        System.out.println("0. Exit");

        System.out.print("Choose: ");
        int choice = input.nextInt();

        System.out.println("Your choice: " + choice);

        input.close();
    }
}
