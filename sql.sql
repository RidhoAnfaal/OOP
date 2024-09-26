+-------------------+
|       User        |
+-------------------+
| - username: String|
| - password: String|
+-------------------+
| + getUsername(): String  |
| + getPassword(): String  |
| + tampilkanMenu(): void  |
+-------------------+
         ^
         |
   +-----+-----+
   |           |
+---------+   +---------+
| Instruktur|   | Peserta |
+---------+   +---------+
| + tampilkanMenu(): void  | | - kursusYangDibeli: List<Kursus> |
+--------------------------+ | + beliKursus(kursus: Kursus): void   |
                              | + getKursusYangDibeli(): List<Kursus>|
                              | + tampilkanMenu(): void  |
                              +--------------------------+
                                    |
                                    |
                                 +---------+
                                 |   Admin |
                                 +---------+
                                 | + tampilkanMenu(): void  |
                                 +--------------------------+

+-------------+
|    Kursus   |
+-------------+
| - namaKursus: String |
| - harga: double      |
| - kontenList: List<Konten> |
+-------------+
| + getNamaKursus(): String  |
| + getHarga(): double       |
| + tambahKonten(konten: Konten): void |
| + getKontenList(): List<Konten> |
| + tampilkanDaftarKonten(): void |
+-------------+

+--------------+
|    Konten    |
+--------------+
| - judul: String  |
| - deskripsi: String |
+--------------+
| + getJudul(): String   |
| + getDeskripsi(): String|
| + toString(): String    |
+--------------+

+-----------------+
|   Pembayaran    |
+-----------------+
| - idPembayaran: String |
| - jumlah: double        |
| - metodePembayaran: String |
| - tanggal: String      |
+-----------------+
| + tampilkanDetailPembayaran(): void |
+-----------------+
