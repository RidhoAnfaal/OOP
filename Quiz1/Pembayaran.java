public class Pembayaran {
    private String idPembayaran;
    private double jumlah;
    private String metodePembayaran;
    // private String tanggal;

    public Pembayaran(String idPembayaran, double jumlah, String metodePembayaran) {
        this.idPembayaran = idPembayaran;
        this.jumlah = jumlah;
        this.metodePembayaran = metodePembayaran;
        // this.tanggal = tanggal;
    }

    public void tampilkanDetailPembayaran() {
        System.out.println("ID Pembayaran: " + idPembayaran + ", Jumlah: " + jumlah + ", Metode: " + metodePembayaran);
    }
}