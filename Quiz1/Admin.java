public class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public void tampilkanMenu() {
        System.out.println("\n=== Menu Admin ===");
        System.out.println("1. Tambah Kursus");
        System.out.println("2. Lihat Daftar Instruktur");
        System.out.println("3. Lihat Daftar Peserta");
        System.out.println("4. Lihat Daftar Kursus");
        System.out.println("5. Lihat Rincian Transaksi Pembayaran");
        System.out.println("6. Logout");
        System.out.print("Pilih menu: ");
    }
}
