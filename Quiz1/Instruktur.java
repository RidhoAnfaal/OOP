public class Instruktur extends User {
    public Instruktur(String username, String password) {
        super(username, password);
    }

    @Override
    public void tampilkanMenu() {
        System.out.println("\n=== Menu Instruktur ===");
        System.out.println("1. Tambah Konten ke Kursus");
        System.out.println("2. Lihat Daftar Konten");
        System.out.println("3. Logout");
        System.out.print("Pilih menu: ");
    }
}
