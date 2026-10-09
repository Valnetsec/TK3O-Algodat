public class CircularWeaponShop {
private WeaponNode head;
private WeaponNode current;

public CircularWeaponShop() {
    head = null;
    current = null;
}

public void tambahSenjata(Weapon weapon) {
    WeaponNode baru = new WeaponNode(weapon);

    if (head == null) {
        head = baru;
        baru.next = head;
        current = head;
    } else {
        WeaponNode temp = head;

        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = baru;
        baru.next = head;
    }
}

public void tampilkanSenjata() {
    if (current == null) {
        System.out.println("Tidak ada senjata yang dijual.");
        return;
    }

    System.out.println("=== WEAPON SHOP ===");
    current.weapon.tampilkan();
}

public void refreshSenjata() {
    if (current != null) {
        current = current.next;
        System.out.println("Shop telah di-refresh!");
    }
}

}
