import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class MaterialShop {
private CircularWeaponShop shop;
private LocalDateTime lastRefresh;

public MaterialShop() {
    shop = new CircularWeaponShop();
    lastRefresh = LocalDateTime.now();

    shop.tambahSenjata(new Weapon("Tombak", 100));
    shop.tambahSenjata(new Weapon("Pedang", 200));
    shop.tambahSenjata(new Weapon("Panah", 150));
    shop.tambahSenjata(new Weapon("Perisai", 180));
}

public void tampilkan() {
    cekRefresh();

    shop.tampilkanSenjata();
}

private void cekRefresh() {
    LocalDateTime sekarang = LocalDateTime.now();

    long bulanBerlalu = ChronoUnit.MONTHS.between(
        lastRefresh, sekarang
    );

    if (bulanBerlalu >= 2) {
        long jumlahRefresh = bulanBerlalu / 2;

        for (long i = 0; i < jumlahRefresh; i++) {
            shop.refreshSenjata();
        }

        lastRefresh = lastRefresh.plusMonths(jumlahRefresh * 2);

        System.out.println("Senjata shop telah di-refresh!");
    }
}


}
