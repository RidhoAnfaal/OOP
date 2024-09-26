import java.util.ArrayList;
import java.util.List;

public class Kursus {
    private String namaKursus;
    private double harga;
    private List<Konten> kontenList = new ArrayList<>();

    public Kursus(String namaKursus, double harga) {
        this.namaKursus = namaKursus;
        this.harga = harga;
    }

    public String getNamaKursus() {
        return namaKursus;
    }

    public double getHarga() {
        return harga;
    }

    public void tambahKonten(Konten konten) {
        kontenList.add(konten);
    }

    public List<Konten> getKontenList() {
        return kontenList;
    }

    public void tampilkanDaftarKonten() {
        System.out.println("Daftar Konten untuk Kursus " + namaKursus + ":");
        if (kontenList.isEmpty()) {
            System.out.println("Belum ada konten.");
        } else {
            for (Konten konten : kontenList) {
                System.out.println("- " + konten);
            }
        }
    }
}
