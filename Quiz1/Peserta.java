import java.util.ArrayList;
import java.util.List;

public class Peserta extends User {
    private List<Kursus> kursusYangDibeli = new ArrayList<>();

    public Peserta(String username, String password) {
        super(username, password);
    }

    public void beliKursus(Kursus kursus) {
        kursusYangDibeli.add(kursus);
    }

    public List<Kursus> getKursusYangDibeli() {
        return kursusYangDibeli;
    }

    @Override
    public void tampilkanMenu() {
        System.out.println("\n=== Menu Peserta ===");
        System.out.println("1. Daftar Kursus");
        System.out.println("2. Lihat Kursus yang Telah Dibeli");
        System.out.println("3. Logout");
        System.out.print("Pilih menu: ");
    }
}
