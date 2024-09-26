public class Konten {
    private String judul;
    private String deskripsi;

    public Konten(String judul, String deskripsi) {
        this.judul = judul;
        this.deskripsi = deskripsi;
    }

    public String getJudul() {
        return judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    @Override
    public String toString() {
        return "Judul: " + judul + ", Deskripsi: " + deskripsi;
    }
}
