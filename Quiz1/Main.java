import java.util.*;

public class Main {
    private static List<User> daftarUser = new ArrayList<>();
    private static List<Kursus> daftarKursus = new ArrayList<>();
    private static List<Pembayaran> daftarPembayaran = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Inisialisasi Data
        daftarUser.add(new Instruktur("instruktur1", "password1"));
        daftarUser.add(new Instruktur("instruktur2", "password2"));
        daftarUser.add(new Admin("admin", "admin123"));
        daftarKursus.add(new Kursus("Kursus Java Basic-Advance", 500000));
        daftarKursus.add(new Kursus("Kursus Web Development Basic-Advance", 600000));
        daftarKursus.add(new Kursus("Kursus SQL Basic-Advance", 400000));
        daftarKursus.add(new Kursus("Kursus Game Development Basic-Advance", 700000));
        daftarKursus.add(new Kursus("Kursus Data Science Basic-Advance", 800000));

        while (true) {
            System.out.println("\n=== Selamat Datang di EduTech Platform ===");
            System.out.println("1. Login");
            System.out.println("2. Daftar Akun Peserta");
            System.out.println("3. Exit");
            System.out.print("Pilih menu: ");
            int mainMenu = scanner.nextInt();

            switch (mainMenu) {
                case 1:
                    login();
                    break;
                case 2:
                    daftarAkunPeserta();
                    break;
                case 3:
                    System.out.println("Terima kasih telah menggunakan EduTech Platform!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void daftarAkunPeserta() {
        System.out.print("Masukkan username: ");
        String username = scanner.next();
        System.out.print("Masukkan password: ");
        String password = scanner.next();

        for (User user : daftarUser) {
            if (user.getUsername().equals(username)) {
                System.out.println("Username sudah terdaftar.");
                return;
            }
        }

        daftarUser.add(new Peserta(username, password));
        System.out.println("Akun peserta berhasil dibuat!");
    }

    private static void login() {
        System.out.print("Username: ");
        String username = scanner.next();
        System.out.print("Password: ");
        String password = scanner.next();

        for (User user : daftarUser) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                if (user instanceof Instruktur) {
                    instrukturMenu((Instruktur) user);
                } else if (user instanceof Peserta) {
                    pesertaMenu((Peserta) user);
                } else if (user instanceof Admin) {
                    adminMenu((Admin) user);
                }
                return;
            }
        }
        System.out.println("Login gagal. Username atau password salah.");
    }

    private static void instrukturMenu(Instruktur instruktur) {
        while (true) {
            instruktur.tampilkanMenu();
            int menu = scanner.nextInt();

            switch (menu) {
                case 1:
                    tambahKonten();
                    break;
                case 2:
                    lihatDaftarKonten();
                    break;
                case 3:
                    return; // Logout
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void tambahKonten() {
        System.out.println("\n=== Tambah Konten ke Kursus ===");
        System.out.println("Pilih kursus:");
        for (int i = 0; i < daftarKursus.size(); i++) {
            System.out.println((i + 1) + ". " + daftarKursus.get(i).getNamaKursus());
        }
        System.out.print("Pilih kursus (nomor): ");
        int kursusIndex = scanner.nextInt() - 1;
        if (kursusIndex >= 0 && kursusIndex < daftarKursus.size()) {
            scanner.nextLine(); // Konsumsi newline
            System.out.print("Masukkan judul konten: ");
            String judul = scanner.nextLine();
            System.out.print("Masukkan deskripsi konten: ");
            String deskripsi = scanner.nextLine();
            Konten konten = new Konten(judul, deskripsi);
            daftarKursus.get(kursusIndex).tambahKonten(konten);
            System.out.println("Konten berhasil ditambahkan ke kursus.");
        } else {
            System.out.println("Kursus tidak valid.");
        }
    }

    private static void lihatDaftarKonten() {
        System.out.println("\n=== Lihat Daftar Konten ===");
        System.out.println("Pilih kursus:");
        for (int i = 0; i < daftarKursus.size(); i++) {
            System.out.println((i + 1) + ". " + daftarKursus.get(i).getNamaKursus());
        }
        System.out.print("Pilih kursus (nomor): ");
        int kursusIndex = scanner.nextInt() - 1;
        if (kursusIndex >= 0 && kursusIndex < daftarKursus.size()) {
            daftarKursus.get(kursusIndex).tampilkanDaftarKonten();
        } else {
            System.out.println("Kursus tidak valid.");
        }
    }

    private static void pesertaMenu(Peserta peserta) {
        while (true) {
            peserta.tampilkanMenu();
            int menu = scanner.nextInt();

            switch (menu) {
                case 1:
                    daftarKursus(peserta);
                    break;
                case 2:
                    lihatKursusYangDibeli(peserta);
                    break;
                case 3:
                    return; // Logout
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void daftarKursus(Peserta peserta) {
        System.out.println("\n=== Daftar Kursus ===");
        for (int i = 0; i < daftarKursus.size(); i++) {
            System.out.println((i + 1) + ". " + daftarKursus.get(i).getNamaKursus() + " - Harga: "
                    + daftarKursus.get(i).getHarga());
        }
        System.out.print("Pilih kursus (nomor): ");
        int kursusIndex = scanner.nextInt() - 1;
        if (kursusIndex >= 0 && kursusIndex < daftarKursus.size()) {
            Kursus kursus = daftarKursus.get(kursusIndex);
            System.out.print("Pilih metode pembayaran (1. Transfer, 2. Indomaret): ");
            int metode = scanner.nextInt();
            String metodePembayaran = metode == 1 ? "Transfer" : "Indomaret";
            System.out.print("Masukkan ID Pembayaran: ");
            String idPembayaran = scanner.next();
            Pembayaran pembayaran = new Pembayaran(idPembayaran, kursus.getHarga(), metodePembayaran,
                    new Date().toString());
            daftarPembayaran.add(pembayaran);
            peserta.beliKursus(kursus);
            System.out.println("Pembayaran berhasil. Anda telah membeli kursus " + kursus.getNamaKursus());
        } else {
            System.out.println("Kursus tidak valid.");
        }
    }

    private static void lihatKursusYangDibeli(Peserta peserta) {
        System.out.println("\n=== Kursus yang Telah Dibeli ===");
        List<Kursus> kursusYangDibeli = peserta.getKursusYangDibeli();
        if (kursusYangDibeli.isEmpty()) {
            System.out.println("Anda belum membeli kursus apapun.");
        } else {
            for (int i = 0; i < kursusYangDibeli.size(); i++) {
                System.out.println((i + 1) + ". " + kursusYangDibeli.get(i).getNamaKursus());
            }
            System.out.print("Pilih kursus (nomor) untuk melihat daftar konten: ");
            int kursusIndex = scanner.nextInt() - 1;
            if (kursusIndex >= 0 && kursusIndex < kursusYangDibeli.size()) {
                kursusYangDibeli.get(kursusIndex).tampilkanDaftarKonten();
            } else {
                System.out.println("Kursus tidak valid.");
            }
        }
    }

    private static void adminMenu(Admin admin) {
        while (true) {
            admin.tampilkanMenu();
            int menu = scanner.nextInt();

            switch (menu) {
                case 1:
                    tambahKursus();
                    break;
                case 2:
                    lihatDaftarInstruktur();
                    break;
                case 3:
                    lihatDaftarPeserta();
                    break;
                case 4:
                    lihatDaftarKursus();
                    break;
                case 5:
                    lihatRincianTransaksi();
                    break;
                case 6:
                    return; // Logout
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void tambahKursus() {
        scanner.nextLine(); // Konsumsi newline
        System.out.print("Masukkan nama kursus: ");
        String namaKursus = scanner.nextLine();
        System.out.print("Masukkan harga kursus: ");
        double harga = scanner.nextDouble();
        daftarKursus.add(new Kursus(namaKursus, harga));
        System.out.println("Kursus berhasil ditambahkan.");
    }

    private static void lihatDaftarInstruktur() {
        System.out.println("\n=== Daftar Instruktur ===");
        for (User user : daftarUser) {
            if (user instanceof Instruktur) {
                System.out.println(user.getUsername());
            }
        }
    }

    private static void lihatDaftarPeserta() {
        System.out.println("\n=== Daftar Peserta ===");
        for (User user : daftarUser) {
            if (user instanceof Peserta) {
                System.out.println(user.getUsername());
            }
        }
    }

    private static void lihatDaftarKursus() {
        System.out.println("\n=== Daftar Kursus ===");
        for (Kursus kursus : daftarKursus) {
            System.out.println(kursus.getNamaKursus() + " - Harga: " + kursus.getHarga());
        }
    }

    private static void lihatRincianTransaksi() {
        System.out.println("\n=== Rincian Transaksi Pembayaran ===");
        for (Pembayaran pembayaran : daftarPembayaran) {
            pembayaran.tampilkanDetailPembayaran();
        }
    }
}
