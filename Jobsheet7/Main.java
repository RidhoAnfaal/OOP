package Jobsheet7;

public class Main {
    public static void main(String[] args) {
        Manusia m1 = new Manusia();
        Manusia m2 = new Dosen();
        Manusia m3 = new Mahasiswa();

        m1.makan();
        m2.makan();
        m3.makan();

        Dosen dosen = new Dosen();
        dosen.lembur();

        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.tidur();
    }
}
