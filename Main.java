import java.util.Scanner;

public class Main {
public static void main(String[] args) {
Scanner input = new Scanner(System.in);
MaterialShop shop = new MaterialShop();

    System.out.println("=== MYTHAG SHOP ===");
    System.out.println("1. Character Roster");
    System.out.println("2. Material Shop");
    System.out.println("0. Exit");

    System.out.print("Choose: ");
    int choice = input.nextInt();

    System.out.println("Your choice: " + choice);

    if (choice == 1) {
        System.out.println("Character Roster");
    } else if (choice == 2) {
        shop.tampilkan();
    } else if (choice == 0) {
        System.out.println("Keluar dari shop...");
    } else {
        System.out.println("Pilihan tidak valid!");
    }

    input.close();
}


}
